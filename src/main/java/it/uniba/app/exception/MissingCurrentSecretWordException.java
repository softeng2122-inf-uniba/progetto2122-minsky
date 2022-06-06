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
    /**
     * String that include a
     * missing secret word message {@param MISSING_SECRET_WORD_MESSAGE}.
     */
    private static final String MISSING_SECRET_WORD_MESSAGE =
    "Non hai specificato alcuna parola.";

    /**
     * Constructs a new {@code MissingCurrentSecretWordException}.
     */
    public MissingCurrentSecretWordException() {
        super(MISSING_SECRET_WORD_MESSAGE);
    }
}
