package it.uniba.app.exception;

/**
 * <noECB>
 * <p>
 * Thrown to indicate that the user has provided an invalid flag.
 */


public class FlagException extends Exception {
    /**
     * Constructs a new {@code FlagException}.
     * @return a message of a flag error.
     */

    public String showMessage() {

        return "[ERRORE] Flag non valido, riprova con -h oppure --help \n\n";
    }

}
