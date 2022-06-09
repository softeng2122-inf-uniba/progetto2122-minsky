package it.uniba.app.exception;

/**
 * <noECB>
 * <p>
 * Thrown to indicate that the player tried to start a new {@code Game}
 * but there is not a current {@code SecretWord}.
 *
 * @see it.uniba.app.wordle.Game
 * @see it.uniba.app.wordle.SecretWord
 */

public class MissingCurrentSecretWordException extends Exception {
}
