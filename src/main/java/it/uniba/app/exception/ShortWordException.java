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
     * Construct a new {@code ShortWordException}.
     * @param message
     * @param correctLength
     */
    public ShortWordException(final String message, final int correctLength) {
        super(String.format(message, correctLength));

        if (correctLength < 2) {
            throw new IllegalArgumentException("length is less than 2");
        }
    }

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
}
