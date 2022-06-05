package it.uniba.app.wordle;

import it.uniba.app.controller.attemptController;
import it.uniba.app.exception.MissingCurrentSecretWordException;
import it.uniba.app.exception.MissingRunningGameException;
import it.uniba.app.exception.RunningGameException;

/**
 * <Entity>
 * <p>
 * A game of Wordle.
 */

public class Game {

    private static final int maxGameAttempts = 6;
    private static Game runningGame;
    private final GameGrid gameGrid = new GameGrid();
    private final SecretWord secretWord;

    public Game(final SecretWord secretWord) {
        this.secretWord = secretWord;
    }

    public static void startNewGame() throws RunningGameException, MissingCurrentSecretWordException {
        if (getRunningGame() == null) {
            if (SecretWord.getCurrentSecretWord() != null) {
                attemptController.resetWin();
                attemptController.resetAttemptCount();
                attemptController.clearAttempt();
                runningGame = new Game(SecretWord.getCurrentSecretWord());
            } else {
                throw new MissingCurrentSecretWordException();
            }
        } else {
            throw new RunningGameException("Una partita è già in corso.");
        }
    }

    public static void abortRunningGame() throws MissingRunningGameException {
        if (getRunningGame() != null) {
            runningGame = null;
        } else {
            throw new MissingRunningGameException("Non c'è nessuna partita in corso.");
        }
    }

    public static Game getRunningGame() {
        return runningGame;
    }

    public static int getMaxGameAttempts() {
        return maxGameAttempts;
    }

    public GameGrid getGameGrid() {
        return gameGrid;
    }

    public SecretWord getSecretWord() {
        return secretWord;
    }
}
