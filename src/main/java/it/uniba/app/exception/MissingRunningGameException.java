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
}
