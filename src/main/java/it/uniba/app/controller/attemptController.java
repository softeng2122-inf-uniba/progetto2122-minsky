package it.uniba.app.controller;

import it.uniba.app.exception.InvalidWordException;
import it.uniba.app.exception.LongWordException;
import it.uniba.app.exception.MissingRunningGameException;
import it.uniba.app.exception.ShortWordException;
import it.uniba.app.utility.AnsiColors;
import it.uniba.app.utility.ErrorStringBuilder;
import it.uniba.app.wordle.AttemptWord;
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

    private static void addCount() {
        attemptCount++;
    }

    private static int getCount() {
        return attemptCount;
    }

    private static boolean getWin() {
        return win;
    }

    private static void setWin() {
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

    public static void endAttempts() throws MissingRunningGameException {

        if (attemptController.getCount() == 6 && attemptController.getWin() == false) {
            System.out.println(new ErrorStringBuilder("Hai raggiunto il numero massimo di tentativi, per maggiori informazioni digitare /help"));
            System.out.println("\nLa parola segreta è: " + SecretWord.getCurrentSecretWord().toString());
            Game.abortRunningGame();
        }
    }

    @Override
    public void control(String[] args) {

        try {

            if (Game.getRunningGame() != null) {

                AttemptWord attemptWord = new AttemptWord(args[0]);
                String[] coloredLetter;

                attemptController.addCount();
                coloredLetter = compereLetters(SecretWord.getCurrentSecretWord(), attemptWord);

                attempt.add(coloredLetter);

                printGrid(attempt);

                attemptController.endAttempts();

            } else {

                throw new MissingRunningGameException("Impossibile effettuare un tentativo se la partita non è in corso, per maggiori informazioni digitare /help");
            }

        } catch (MissingRunningGameException | ShortWordException
                 | LongWordException | InvalidWordException e) {
            System.out.println(new ErrorStringBuilder(e.getLocalizedMessage()));
        }

    }

    public String[] compereLetters(SecretWord secretWord, AttemptWord attemptWord) throws MissingRunningGameException {

        String[] coloredWord = new String[5];
        boolean letterFlag = false;

        if (attemptWord.equalsIgnoreCase(SecretWord.getCurrentSecretWord())) {

            for (int i = 0; i < Word.getLength(); i++) {
                coloredWord[i] = AnsiColors.makeBackgroundGreen(attemptWord.getLetters()[i].getCharacter());
            }
            System.out.println(AnsiColors.getBrightGreen() + "Parola segreta indovinata, complimenti! Numero tentativi : " + attemptController.getCount() + AnsiColors.getReset());
            attemptController.setWin();
            Game.abortRunningGame();
        } else {

            for (int i = 0; i < Word.getLength(); i++) {

                int j = 0;

                letterFlag = false;

                while (j < Word.getLength() && letterFlag == false) {

                    if (secretWord.toString().charAt(j) == attemptWord.getLetters()[i].getCharacter()) {

                        letterFlag = true;

                        if (i == j) {

                            coloredWord[i] = AnsiColors.makeBackgroundGreen(attemptWord.getLetters()[i].getCharacter());
                        } else {

                            j = i;
                            if (secretWord.toString().charAt(j) == attemptWord.getLetters()[i]
                                    .getCharacter()) {
                                coloredWord[i] = AnsiColors
                                        .makeBackgroundGreen(attemptWord.getLetters()[i].getCharacter());
                            } else {

                                coloredWord[i] = AnsiColors
                                        .makeBackgroundYellow(attemptWord.getLetters()[i].getCharacter());
                            }

                        }

                    }

                    j++;
                }

                if (letterFlag == false) {
                    coloredWord[i] = AnsiColors.makeBackgroundGray(attemptWord.getLetters()[i].getCharacter());
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

}