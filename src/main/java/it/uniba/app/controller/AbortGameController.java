package it.uniba.app.controller;

import it.uniba.app.exception.InvalidConfirmationException;
import it.uniba.app.exception.MissingRunningGameException;
import it.uniba.app.utility.AbortGameBoundary;
import it.uniba.app.utility.ConfirmationRequest;
import it.uniba.app.wordle.Game;

import java.io.IOException;

/**
 * <Control>
 * <p>
 * This class allows the player
 * to abort the game currently running.
 */
public final class AbortGameController implements Controller {
    @Override
    public void control(final String[] args) {
        try {
            if (Game.getRunningGame() != null) {
                AbortGameBoundary.setAbortgamemessage();
                ConfirmationRequest abortConfirmation =
                        new ConfirmationRequest();
                if (abortConfirmation.askUserConfirmation()) {
                    Game.abortRunningGame();
                    AbortGameBoundary.showGameAbortedMessage();
                }
            } else {
                throw new MissingRunningGameException();
            }
        } catch (IOException | InvalidConfirmationException ex) {
            ConfirmationRequest exitConfirmation = new ConfirmationRequest();
            exitConfirmation.showInputError();
        } catch (MissingRunningGameException e) {
            AbortGameBoundary.showGameNotRunningError();
        }
    }
}
