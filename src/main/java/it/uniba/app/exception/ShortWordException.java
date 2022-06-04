package it.uniba.app.exception;

/**
 * <noECB>
 * <p>
 * Thrown to indicate that the user entered a {@code Word} that is too short.
 *
 * @see it.uniba.app.wordle.Word
 */

public class ShortWordException extends Exception {

    public String showMessage() {

        return "Tentativo incompleto, parola troppo corta, per maggiori informazioni digitare /help";
    }

}
