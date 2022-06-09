package it.uniba.app.controller;

import it.uniba.app.command.CommandLineShell;
import it.uniba.app.exception.InvalidWordException;
import it.uniba.app.exception.LongWordException;
import it.uniba.app.exception.MissingRunningGameException;
import it.uniba.app.exception.ShortWordException;
import it.uniba.app.utility.AnsiColors;
import it.uniba.app.utility.ErrorStringBuilder;
import it.uniba.app.wordle.Game;
import it.uniba.app.wordle.SecretWord;
import it.uniba.app.wordle.Word;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * <Control>
 * <p>
 * Handles the execution of {@code Game} attempts.
 */

public class attemptController implements Controller {

    private static int attemptCount = 0;
    private static boolean win = false;
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

    public static void addCount() {
        attemptCount++;
    }

    public static void reduceCount() {
        attemptCount--;
    }

    public static int getCount() {
        return attemptCount;
    }

    public static boolean getWin() {
        return win;
    }

    public static void setWin() {
        win = true;
    }

    public static void resetWin() {
        win = false;
    }

    public static void resetAttemptCount() {
        attemptCount = 0;
    }

    public static void clearAttempt() {
        attempt.clear();
    }

    public static void endAttempts() {

        if (attemptController.getCount() == 6 && attemptController.getWin() == false) {
            System.out.println(new ErrorStringBuilder("Hai raggiunto il numero massimo di tentativi, per maggiori informazioni digitare /help"));
            System.out.println("\nLa parola segreta è: " + SecretWord.getCurrentSecretWord().toString());
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

        String[] coloredLetter;

        attemptController.addCount();
        coloredLetter = compereLetters(SecretWord.getCurrentSecretWord(), args[0].trim().toLowerCase());

        attempt.add(coloredLetter);

        printGrid(attempt);

        attemptController.endAttempts();
    }

    public String[] compereLetters(SecretWord secretWord, final String attemptString) {

        String[] coloredWord = new String[5];
        boolean letterFlag = false;

        if (SecretWord.getCurrentSecretWord().equalsIgnoreCase(attemptString)) {

            for (int i = 0; i < Word.getLength(); i++) {
                coloredWord[i] = AnsiColors.makeBackgroundGreen(attemptString.charAt(i));
            }
            System.out.println(AnsiColors.getBrightGreen() + "Parola segreta indovinata, complimenti! Numero tentativi : " + attemptController.getCount() + AnsiColors.getReset());
            attemptController.setWin();
            try {
                Game.abortRunningGame();
            } catch (MissingRunningGameException e) {
                CommandLineShell.showUnexpectedError(e);
            }
        } else {

            for (int i = 0; i < Word.getLength(); i++) {

                int j = 0;

                letterFlag = false;

                while (j < Word.getLength() && letterFlag == false) {

                    if (secretWord.toString().charAt(j) == attemptString.charAt(i)) {

                        letterFlag = true;

                        if (i == j) {

                            coloredWord[i] = AnsiColors.makeBackgroundGreen(attemptString.charAt(i));
                        } else {

                            j = i;
                            if (secretWord.toString().charAt(j) == attemptString.charAt(i)) {
                                coloredWord[i] = AnsiColors
                                        .makeBackgroundGreen(attemptString.charAt(i));
                            } else {

                                coloredWord[i] = AnsiColors
                                        .makeBackgroundYellow(attemptString.charAt(i));
                            }

                        }

                    }

                    j++;
                }

                if (letterFlag == false) {
                    coloredWord[i] = AnsiColors.makeBackgroundGray(attemptString.charAt(i));
                }

            }

        }

        return coloredWord;

    }

    public static void printGrid(List<String[]> attempt){


        System.out.println("┌───────────────────┐");
        System.out.println("│ GRIGLIA DI GIOCO  │");
        System.out.println("├───┬───┬───┬───┬───┤");

        for(int i = 0; i < attempt.size(); i++){

            System.out.println(MessageFormat.format("│{0}│{1}│{2}│{3}│{4}│", attempt.get(i)[0],
            attempt.get(i)[1],  attempt.get(i)[2],  attempt.get(i)[3],  attempt.get(i)[4]));
            System.out.println("├───┼───┼───┼───┼───┤");

        }

        System.out.println("│   │   │   │   │   │");
        System.out.println("└───┴───┴───┴───┴───┘");

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
