package it.uniba.app.exception;

/**
 * <noECB>
 * <p>
 * Thrown to indicate that the user has provided an invalid flag.
 */

public final class FlagException extends Exception {

    /**
     * Returns a message of a flag error.
     * @return a message of a flag error.
     */
    public String showMessage() {

        return "[ERRORE] Flag non valido, riprova con -h oppure --help \n\n";
    }
}
