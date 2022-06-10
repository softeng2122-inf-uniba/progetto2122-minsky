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

    /**
     * The maximum amount of attempts to guess the secret word.
     */
    private static final int MAX_GAME_ATTEMPTS = 6;

    /**
     * The currently running game.
     */
    private static Game runningGame;

    /**
     * The game grid containing the attempts already made in this game.
     */
    private final GameGrid gameGrid = new GameGrid();

    /**
     * The secret word for this game.
     */
    private final SecretWord secretWord;
    private int attemptCount = 0;
    private boolean win = false;

    /** Constructs a new game with the given secret word.
     *
     * @param gameSecretWord {@link SecretWord} to guess for this new game
     */
    public Game(final SecretWord gameSecretWord) {
        this.secretWord = gameSecretWord;
    }

    public void addCount() {
        attemptCount++;
    }

    public int getCount() {
        return attemptCount;
    }

    public boolean getWin() {
        return win;
    }

    public void setWin() {
        win = true;
    }

    /**
     * Starts a new game of Wordle.
     *
     * @throws RunningGameException if another game is still running.
     * @throws MissingCurrentSecretWordException
     *             if the secret word has not yet been selected.
     */
    public static void startNewGame()
            throws RunningGameException, MissingCurrentSecretWordException {

        if (getRunningGame() == null) {
            if (SecretWord.getCurrentSecretWord() != null) {

                runningGame = new Game(SecretWord.getCurrentSecretWord());
            } else {
                throw new MissingCurrentSecretWordException();
            }
        } else {
            throw new RunningGameException();
        }
    }

    /**
     * Aborts the currently running game.
     *
     * @throws MissingRunningGameException if no game is currently running.
     */
    public static void abortRunningGame() throws MissingRunningGameException {
        if (getRunningGame() != null) {
            runningGame = null;
        } else {
            throw new MissingRunningGameException();
        }
    }

    /**
     * Returns the currently running game.
     *
     * @return currently running game
     */
    public static Game getRunningGame() {
        return runningGame;
    }

    /**
     * Returns the maximum amount of attempts to guess the secret word.
     *
     * @return maximum amount of attempts to guess the secret word
     */
    public static int getMaxGameAttempts() {
        return MAX_GAME_ATTEMPTS;
    }

    /**
     * Returns the game grid containing the attempts already made in this game.
     *
     * @return game grid containing the attempts already made in this game
     */
    public GameGrid getGameGrid() {
        return gameGrid;
    }

    /**
     * Returns the secret word for this game.
     *
     * @return secret word for this game
     */
    public SecretWord getSecretWord() {
        return secretWord;
    }
}
