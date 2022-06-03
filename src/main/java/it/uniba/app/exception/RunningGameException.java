package it.uniba.app.exception;

/**
 * <noECB>
 * <p>
 * Thrown to indicate that the player tried to start a new game
 * while another game is already running.
 */

public class RunningGameException extends Exception {

    public String showMessage() {

        return "Impossibile effettuare un tentativo se la partita non è in corso, per maggiori informazioni digitare /help";
    }

}
