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
public class AbortGameController implements Controller {
    @Override
    public void control(String[] args) {
        try {
            if (Game.getRunningGame() != null) {
                System.out.println("Vuoi Abbandonare la partita in corso?");
                ConfirmationRequest abortConfirmation = new ConfirmationRequest();
                if (abortConfirmation.askUserConfirmation()) {
                    Game.abortRunningGame();
                    AbortGameBoundary.showGameAbortedMessage();
                }
            } else {
                throw new MissingRunningGameException("Non c'è nessuna partita in corso.");
            }
        } catch (IOException | InvalidConfirmationException ex) {
            System.out.println("Errore nell'input");
        } catch (MissingRunningGameException e) {
            AbortGameBoundary.showGameNotRunningError();
        }
    }
}
