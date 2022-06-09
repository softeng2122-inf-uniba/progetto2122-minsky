package it.uniba.app.exception;

/**
 * <noECB>
 * <p>
 * Thrown to indicate that the player tried to do something
 * that is illegal to do when there is no game running.
 *
 * @see it.uniba.app.wordle.Game
 */
public class MissingRunningGameException extends Exception {

    /**
     * Constructs a new {@code MissingRunningGameException}
     * with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public MissingRunningGameException(final String message) {
        super(message);
    }
}
