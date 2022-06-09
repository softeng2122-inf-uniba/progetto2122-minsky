package it.uniba.app.exception;

/**
 * <noECB>
 * <p>
 * Thrown to indicate that the user entered a {@code Word} that is too short.
 *
 * @see it.uniba.app.wordle.Word
 */

public class ShortWordException extends Exception {
    /**
     * Constructs a new {@code ShortWordException}
     * with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public ShortWordException(final String message) {
        super(message);
    }

    /**
     * Constructs a new {@code ShortWordException}
     * with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public ShortWordException() {
        super();
    }
}
