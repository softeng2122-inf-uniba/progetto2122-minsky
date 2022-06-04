package it.uniba.app.controller;

import it.uniba.app.exception.*;
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


                if (args[0].length() == Word.getLength()) {

                    Word word = new Word(args[0]);
                    String[] coloredLetter;

                    attemptController.addCount();
                    coloredLetter = compereLetters(SecretWord.getCurrentSecretWord(), word);

                    attempt.add(coloredLetter);

                    printGrid(attempt);

                    attemptController.endAttempts();

                } else if (args[0].length() < Word.getLength()) {


                    throw new ShortWordException();

                } else if (args[0].length() > Word.getLength()) {

                    throw new LongWordException();

                } else {

                    throw new InvalidLetterException();
                }

            } else {

                throw new RunningGameException();
            }

        } catch (RunningGameException px) {

            System.out.println(new ErrorStringBuilder(px.showMessage()));

        } catch (ShortWordException e) {

            System.out.println(new ErrorStringBuilder(e.showMessage()));

        } catch (LongWordException e) {

            System.out.println(new ErrorStringBuilder(e.showMessage()));

        } catch (InvalidLetterException e) {

            System.out.println(new ErrorStringBuilder(e.showMessage()));

        } catch (MissingRunningGameException e) {
        }

    }

    public String[] compereLetters(Word secretWord, Word gameAttempt) throws MissingRunningGameException {

        String[] coloredWord = new String[5];
        boolean letterFlag = false;

        if (gameAttempt.equalsIgnoreCaseAndColors(SecretWord.getCurrentSecretWord())) {

            for (int i = 0; i < Word.getLength(); i++) {
                coloredWord[i] = AnsiColors.makeBackgroundGreen(gameAttempt.getLetters()[i].getCharacter());
            }
            System.out.println(AnsiColors.getBrightGreen() + "Parola segreta indovinata, complimenti! Numero tentativi : " + attemptController.getCount() + AnsiColors.getReset());
            attemptController.setWin();
            Game.abortRunningGame();
        } else {

            for (int i = 0; i < Word.getLength(); i++) {

                int j = 0;

                letterFlag = false;

                while (j < Word.getLength() && letterFlag == false) {

                    if (secretWord.getLetters()[j].getCharacter() == gameAttempt.getLetters()[i].getCharacter()) {

                        letterFlag = true;

                        if (i == j) {

                            coloredWord[i] = AnsiColors.makeBackgroundGreen(gameAttempt.getLetters()[i].getCharacter());
                        } else {

                            j = i;
                            if (secretWord.getLetters()[j].getCharacter() == gameAttempt.getLetters()[i]
                                    .getCharacter()) {
                                coloredWord[i] = AnsiColors
                                        .makeBackgroundGreen(gameAttempt.getLetters()[i].getCharacter());
                            } else {

                                coloredWord[i] = AnsiColors
                                        .makeBackgroundYellow(gameAttempt.getLetters()[i].getCharacter());
                            }

                        }

                    }

                    j++;
                }

                if (letterFlag == false) {
                    coloredWord[i] = AnsiColors.makeBackgroundGray(gameAttempt.getLetters()[i].getCharacter());
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