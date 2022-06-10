package it.uniba.app.controller;

import it.uniba.app.command.CommandLineShell;
import it.uniba.app.exception.InvalidLetterException;
import it.uniba.app.exception.InvalidWordException;
import it.uniba.app.exception.LongWordException;
import it.uniba.app.exception.MissingRunningGameException;
import it.uniba.app.exception.ShortWordException;
import it.uniba.app.utility.ErrorStringBuilder;
import it.uniba.app.wordle.AttemptWord;
import it.uniba.app.wordle.Game;
import it.uniba.app.wordle.GameGridBoundary;
import it.uniba.app.wordle.Letter;
import it.uniba.app.wordle.SecretWord;
import it.uniba.app.wordle.Word;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <Control>
 * <p>
 * Handles the execution of {@code Game} attempts.
 */

public class AttemptController implements Controller {

    public static List<String[]> attempt = new ArrayList<>();

    /**
     * Error message used when user tries
     * to make a game attempt
     * when no game is running.
     */
    private static final String GAME_NOT_RUNNING_MESSAGE =
            "Impossibile effettuare un tentativo se la partita non è in corso, "
          + "per maggiori informazioni digitare /help";

    /**
     * Error message used when user enters
     * an attempt that is too short.
     */
    private static final String SHORT_ATTEMPT_MESSAGE =
            "Tentativo incompleto, parola troppo corta, "
          + "per maggiori informazioni digitare /help";

    /**
     * Error message used when user enters
     * an attempt that is too long.
     */
    private static final String LONG_ATTEMPT_MESSAGE =
            "Tentativo eccessivo, parola troppo lunga, "
          + "per maggiori informazioni digitare /help";

    /**
     * Error message used when user enters
     * an attempt that contains some characters
     * that are not letters.
     */
    private static final String INVALID_ATTEMPT_MESSAGE =
            "Tentativo non valido, caratteri non riconosciuti, "
          + "per maggiori informazioni digitare /help";


          public static void endAttempts() {

            if (Game.getRunningGame().getCount() == 6 && Game.getRunningGame().getWin() == false) {
                System.out.println(new ErrorStringBuilder("Hai raggiunto il numero massimo di tentativi, per maggiori informazioni digitare /help"));
                System.out.println("\nLa parola segreta è: " + SecretWord.getCurrentSecretWord().toString());
                try {
                    Game.abortRunningGame();
                } catch (MissingRunningGameException e) {
                    CommandLineShell.showUnexpectedError(e);
                }
            }else if(Game.getRunningGame().getWin()){
            // TODO: spostare nella classe boundary
            // System.out.println(AnsiColors.getBrightGreen() + "Parola segreta indovinata,
            // complimenti! Numero tentativi : " + attemptController.getCount() +
            // AnsiColors.getReset());
                try {
                    Game.abortRunningGame();
                } catch (MissingRunningGameException e) {
                    CommandLineShell.showUnexpectedError(e);
                }
                
            }
        }


        @Override
        public void control(String[] args) {
            try {
                if (Game.getRunningGame() == null) {
                    throw new MissingRunningGameException();
                }
    
                Word.checkWord(args[0]);
            } catch (MissingRunningGameException | ShortWordException
                     | LongWordException | InvalidWordException e) {
                showError(e);
                return;
            }
        
            Game.getRunningGame().addCount();
            compereLetters(SecretWord.getCurrentSecretWord(), args[0].trim().toLowerCase());
        
            GameGridBoundary.showGrid(Game.getRunningGame().getGameGrid());
    
            endAttempts();
        }
    

    public void compereLetters(SecretWord secretWord, final String attemptWord){

        boolean letterFlag = false;
        Letter[] coloredLetters = new Letter[Word.getLength()];

        try{

        if (secretWord.equalsIgnoreCase(attemptWord)) {

            for(int i = 0; i < Word.getLength(); i++){
                coloredLetters[i] = new Letter(attemptWord.charAt(i), Color.GREEN);
            }

            Game.getRunningGame().setWin();

        } else {

            for (int i = 0; i < Word.getLength(); i++) {

                letterFlag = false;

                for (int j = 0; j < Word.getLength() && letterFlag == false; j++) {

                    if (secretWord.toString().charAt(j) == attemptWord.charAt(i)) {

                        letterFlag = true;

                        if (i == j) {
                            coloredLetters[i] = new Letter(attemptWord.charAt(i), Color.GREEN);

                        } else {
                            j = i;
                            if(secretWord.toString().charAt(j) == attemptWord.charAt(i)){
                                coloredLetters[i] = new Letter(attemptWord.charAt(i), Color.GREEN);

                            }else{
                                coloredLetters[i] = new Letter(attemptWord.charAt(i), Color.YELLOW);

                            }

                        }

                    } 

                }

                if(letterFlag == false){
                    coloredLetters[i] = new Letter(attemptWord.charAt(i), Color.GRAY);

                }

            }
        }

        Game.getRunningGame().getGameGrid().setWord(new AttemptWord(coloredLetters));

    }catch(InvalidLetterException | ShortWordException | LongWordException e){
        CommandLineShell.showUnexpectedError(e);
    }

    }

    private void showError(final Exception exception) {
        String errorMessage;

        if (exception instanceof MissingRunningGameException) {
            errorMessage = GAME_NOT_RUNNING_MESSAGE;
        } else if (exception instanceof ShortWordException) {
            errorMessage = SHORT_ATTEMPT_MESSAGE;
        } else if (exception instanceof LongWordException) {
            errorMessage = LONG_ATTEMPT_MESSAGE;
        } else if (exception instanceof InvalidWordException) {
            errorMessage = INVALID_ATTEMPT_MESSAGE;
        } else {
            throw new IllegalArgumentException();
        }

        System.out.println(new ErrorStringBuilder(errorMessage));
    }

}
