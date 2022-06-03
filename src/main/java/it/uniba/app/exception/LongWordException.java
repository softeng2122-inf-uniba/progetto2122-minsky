package it.uniba.app.exception;

/**
 * <noECB>
 * <p>
 * Thrown to indicate that the user entered a {@code Word} that is too long.
 *
 * @see it.uniba.app.wordle.Word
 */

public class LongWordException extends Exception {

    public String showMessage() {

        return "Tentativo eccessivo, parola troppo lunga, per maggiori informazioni digitare /help";
    }

}
