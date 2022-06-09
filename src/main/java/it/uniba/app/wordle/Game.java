package it.uniba.app.wordle;

import it.uniba.app.controller.AttemptController;
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
    private static int attemptCount = 0;
    private static boolean win = false;

    public Game(final SecretWord secretWord) {
        this.secretWord = secretWord;
    }

    public static void addCount() {
        attemptCount++;
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

    private static void resetWin() {
        win = false;
    }

    private static void resetAttemptCount() {
        attemptCount = 0;
    }

    private static void clearAttempt() {
        //TODO: Pulire la lista dei tentativi
    }

    public static void startNewGame() throws RunningGameException, MissingCurrentSecretWordException {
        if (getRunningGame() == null) {
            if (SecretWord.getCurrentSecretWord() != null) {
                resetWin();
                resetAttemptCount();
                clearAttempt();
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
