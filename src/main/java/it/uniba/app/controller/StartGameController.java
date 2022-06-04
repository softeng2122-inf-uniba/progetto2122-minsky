package it.uniba.app.controller;

import it.uniba.app.StartGameBoundary;
import it.uniba.app.exception.MissingCurrentSecretWordException;
import it.uniba.app.exception.RunningGameException;
import it.uniba.app.wordle.Game;

/**
 * <Control>
 * <p>
 * This class handles the start of a new {@code Game}.
 *
 * @see Game
 */

public class StartGameController implements Controller {

    @Override
    public void control(String[] args) {
        StartGameBoundary startGameBoundary = new StartGameBoundary();

        try {
            Game.startNewGame();

            startGameBoundary.showEmptyGrid();
        } catch (RunningGameException e) {
            startGameBoundary.showGameRunningError();
        } catch (MissingCurrentSecretWordException e) {
            startGameBoundary.showMissingSecretWord();
        }
    }
}
