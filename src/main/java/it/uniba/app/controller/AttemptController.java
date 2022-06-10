package it.uniba.app.controller;

import it.uniba.app.command.CommandLineShell;
import it.uniba.app.exception.InvalidLetterException;
import it.uniba.app.exception.InvalidWordException;
import it.uniba.app.exception.LongWordException;
import it.uniba.app.exception.MissingRunningGameException;
import it.uniba.app.exception.ShortWordException;
import it.uniba.app.utility.AttemptBoundary;
import it.uniba.app.utility.ErrorStringBuilder;
import it.uniba.app.wordle.AttemptWord;
import it.uniba.app.wordle.Game;
import it.uniba.app.wordle.GameGridBoundary;
import it.uniba.app.wordle.Letter;
import it.uniba.app.wordle.SecretWord;
import it.uniba.app.wordle.Word;
import java.awt.*;

/**
 * <Control>
 * <p>
 * Handles the execution of {@code Game} attempts.
 */

public class AttemptController implements Controller {

    public static void endAttempts() {

        AttemptBoundary attemptBoundary = new AttemptBoundary();

        if (Game.getRunningGame().getCount() == Game.getMaxGameAttempts() && Game.getRunningGame().getWin() == false) {
            attemptBoundary.showEndAttemptsMessage();
            try {
                Game.abortRunningGame();
            } catch (MissingRunningGameException e) {
                CommandLineShell.showUnexpectedError(e);
            }
        } else if (Game.getRunningGame().getWin()) {

            attemptBoundary.showWinMessage();
            try {
                Game.abortRunningGame();
            } catch (MissingRunningGameException e) {
                CommandLineShell.showUnexpectedError(e);
            }

        }
    }

    @Override
    public void control(String[] args) {

        AttemptBoundary attemptBoundary = new AttemptBoundary();

        try {
            if (Game.getRunningGame() == null) {
                throw new MissingRunningGameException();
            }

            Word.checkWord(args[0]);
        } catch (MissingRunningGameException | ShortWordException
                | LongWordException | InvalidWordException e) {
            attemptBoundary.showError(e);
            return;
        }

        Game.getRunningGame().addCount();
        compereLetters(SecretWord.getCurrentSecretWord(), args[0].trim().toLowerCase());

        GameGridBoundary.showGrid(Game.getRunningGame().getGameGrid());

        endAttempts();
    }

    public void compereLetters(SecretWord secretWord, final String attemptWord) {

        boolean letterFlag = false;
        Letter[] coloredLetters = new Letter[Word.getLength()];

        try {

            if (secretWord.equalsIgnoreCase(attemptWord)) {

                for (int i = 0; i < Word.getLength(); i++) {
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
                                if (secretWord.toString().charAt(j) == attemptWord.charAt(i)) {
                                    coloredLetters[i] = new Letter(attemptWord.charAt(i), Color.GREEN);

                                } else {
                                    coloredLetters[i] = new Letter(attemptWord.charAt(i), Color.YELLOW);

                                }

                            }

                        }

                    }

                    if (letterFlag == false) {
                        coloredLetters[i] = new Letter(attemptWord.charAt(i), Color.GRAY);

                    }

                }
            }

            Game.getRunningGame().getGameGrid().setWord(new AttemptWord(coloredLetters));

        } catch (InvalidLetterException | ShortWordException | LongWordException e) {
            CommandLineShell.showUnexpectedError(e);
        }

    }

}
