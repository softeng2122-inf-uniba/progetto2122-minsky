package it.uniba.app.exception;

/**
 * <noECB>
 * <p>
 * Thrown to indicate that the user entered a {@code Word} that is too long.
 *
 * @see it.uniba.app.wordle.Word
 */

public class LongWordException extends Exception {
    /**
     * Constructs a new {@code LongWordException}
     * with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public LongWordException(final String message) {
        super(message);
    }

    /**
     * Constructs a new {@code LongWordException}
     * with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public LongWordException() {
        super();
    }
}
