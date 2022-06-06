package it.uniba.app.exception;

/**
 * <noECB>
 * <p>
 * Thrown to indicate that the user entered a {@code Word}
 * containing non-alphabetic characters.
 *
 * @see it.uniba.app.wordle.Word
 * @see it.uniba.app.wordle.Letter
 * @see InvalidLetterException
 */

public class InvalidWordException extends Exception {

    /**
     * Constructs a new {@code InvalidWordException}
     * with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public InvalidWordException(final String message) {
        super(message);
    }
}
