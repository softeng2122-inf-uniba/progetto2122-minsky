package it.uniba.app.controller;

import it.uniba.app.exception.MissingCurrentSecretWordException;
import it.uniba.app.exception.RunningGameException;
import it.uniba.app.ui.GameGridBoundary;
import it.uniba.app.ui.StartGameBoundary;
import it.uniba.app.wordle.Game;

/**
 * <Control>
 * <p>
 * This class handles the start of a new {@code Game}.
 *
 * @see Game
 */

public final class StartGameController implements Controller {

    @Override
    public void control(final String[] args) {
        try {
            Game.startNewGame();
            GameGridBoundary.showEmptyGrid();
        } catch (RunningGameException e) {
            StartGameBoundary.showGameRunningError();
        } catch (MissingCurrentSecretWordException e) {
            StartGameBoundary.showMissingSecretWord();
        }
    }
}
