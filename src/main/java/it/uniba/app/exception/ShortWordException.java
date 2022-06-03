package it.uniba.app.exception;

/**
 * <noECB>
 * <p>
 * Thrown to indicate that the user entered a too short word.
 */

public class ShortWordException extends Exception {

    public String showMessage() {

        return "Tentativo incompleto, parola troppo corta, per maggiori informazioni digitare /help";
    }

}
