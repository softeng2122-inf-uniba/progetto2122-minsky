package it.uniba.app.controller;

import it.uniba.app.exception.InvalidLetterException;
import it.uniba.app.exception.InvalidWordException;
import it.uniba.app.exception.LongWordException;
import it.uniba.app.exception.MissingRunningGameException;
import it.uniba.app.exception.ShortWordException;
import it.uniba.app.utility.AnsiColors;
import it.uniba.app.utility.ErrorStringBuilder;
import it.uniba.app.wordle.AttemptWord;
import it.uniba.app.wordle.Game;
import it.uniba.app.wordle.GameGrid;
import it.uniba.app.wordle.GameGridBoundary;
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

public class AttemptController implements Controller {

    public static List<String[]> attempt = new ArrayList<>();

    public static void endAttempts() throws MissingRunningGameException {

        if (Game.getCount() == 6 && Game.getWin() == false) {
            System.out.println(new ErrorStringBuilder(
                    "Hai raggiunto il numero massimo di tentativi, per maggiori informazioni digitare /help"));
            System.out.println("\nLa parola segreta è: " + SecretWord.getCurrentSecretWord().toString());
            Game.abortRunningGame();
        }
    }

    @Override
    public void control(String[] args) {

        try {

            if (Game.getRunningGame() != null) {

                GameGrid attemptGameGrid = new GameGrid();

                AttemptWord attemptWord = new AttemptWord(args[0]);
                String[] coloredLetter;

                Game.addCount();
                // coloredLetter = compereLetters(SecretWord.getCurrentSecretWord(),
                // attemptWord);

                // attempt.add(coloredLetter);

                // printGrid(attempt);
                GameGridBoundary.showGrid(Game.getRunningGame().getGameGrid());

                AttemptController.endAttempts();

            } else {

                throw new MissingRunningGameException(
                        "Impossibile effettuare un tentativo se la partita non è in corso, per maggiori informazioni digitare /help");
            }

        } catch (MissingRunningGameException | ShortWordException
                | LongWordException | InvalidWordException e) {
            System.out.println(new ErrorStringBuilder(e.getLocalizedMessage()));
        }

    }

    /*
     * public String[] compereLetters(SecretWord secretWord, AttemptWord
     * attemptWord) throws MissingRunningGameException {
     * 
     * String[] coloredWord = new String[5];
     * boolean letterFlag = false;
     * 
     * if (attemptWord.equalsIgnoreCase(SecretWord.getCurrentSecretWord())) {
     * 
     * for (int i = 0; i < Word.getLength(); i++) {
     * coloredWord[i] =
     * AnsiColors.makeBackgroundGreen(attemptWord.getLetters()[i].getCharacter());
     * }
     * System.out
     * .println(AnsiColors.getBrightGreen() +
     * "Parola segreta indovinata, complimenti! Numero tentativi : "
     * + attemptController.getCount() + AnsiColors.getReset());
     * attemptController.setWin();
     * Game.abortRunningGame();
     * } else {
     * 
     * for (int i = 0; i < Word.getLength(); i++) {
     * 
     * int j = 0;
     * 
     * letterFlag = false;
     * 
     * while (j < Word.getLength() && letterFlag == false) {
     * 
     * if (secretWord.toString().charAt(j) ==
     * attemptWord.getLetters()[i].getCharacter()) {
     * 
     * letterFlag = true;
     * 
     * if (i == j) {
     * 
     * coloredWord[i] =
     * AnsiColors.makeBackgroundGreen(attemptWord.getLetters()[i].getCharacter());
     * } else {
     * 
     * j = i;
     * if (secretWord.toString().charAt(j) == attemptWord.getLetters()[i]
     * .getCharacter()) {
     * coloredWord[i] = AnsiColors
     * .makeBackgroundGreen(attemptWord.getLetters()[i].getCharacter());
     * } else {
     * 
     * coloredWord[i] = AnsiColors
     * .makeBackgroundYellow(attemptWord.getLetters()[i].getCharacter());
     * }
     * 
     * }
     * 
     * }
     * 
     * j++;
     * }
     * 
     * if (letterFlag == false) {
     * coloredWord[i] =
     * AnsiColors.makeBackgroundGray(attemptWord.getLetters()[i].getCharacter());
     * }
     * 
     * }
     * 
     * }
     * 
     * return coloredWord;
     * 
     * }
     */

}