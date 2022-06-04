package it.uniba.app.exception;

/**
 * <noECB>
 * <p>
 * Thrown to indicate that the user entered a non-alphabetic character.
 *
 * @see it.uniba.app.wordle.Letter
 */

public class InvalidLetterException extends Exception {


    public String showMessage() {

        return "Tentativo non valido, carratteri non riconosciuti, per maggiori informazioni digitare /help";
    }

}
