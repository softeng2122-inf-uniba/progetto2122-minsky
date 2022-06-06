package it.uniba.app.exception;

/**
 * <noECB>
 * <p>
 * Thrown to indicate that the player tried to start a new game
 * while another game is already running.
 */

public class RunningGameException extends Exception {

    /**
     * Constructs a new {@code RunningGameException}
     * with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public RunningGameException(final String message) {
        super(message);
    }

}
