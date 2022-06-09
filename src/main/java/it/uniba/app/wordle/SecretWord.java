package it.uniba.app.wordle;

import it.uniba.app.exception.InvalidWordException;
import it.uniba.app.exception.LongWordException;
import it.uniba.app.exception.RunningGameException;
import it.uniba.app.exception.ShortWordException;

/**
 * <Entity>
 * <p>
 * A secret word in Wordle.
 */

public final class SecretWord extends Word {
    /**
     * The current {@code SecretWord}.
     */
    private static SecretWord currentSecretWord;
    /**
     * String representation of this {@code SecretWord}.
     */
    private final String secretWord;

    /**
     * Creates a {@code SecretWord} having {@code stringRepresentation}
     * as its string representation.
     * <p>
     * Note that {@code stringRepresentation} it's a valid Wordle word
     * if and only if
     * {@code Word.checkWord(stringRepresentation)} doesn't throw any exception.
     *
     * @param stringRepresentation string representation of
     *                             the new {@code SecretWord}.
     * @throws ShortWordException   if
     *                              {@code Word.checkWord(stringRepresentation)}
     *                              throws {@link ShortWordException}.
     * @throws LongWordException    if
     *                              {@code Word.checkWord(stringRepresentation)}
     *                              throws {@link LongWordException}.
     * @throws InvalidWordException if
     *                              {@code Word.checkWord(stringRepresentation)}
     *                              throws {@link InvalidWordException}.
     * @see it.uniba.app.wordle.Word#checkWord(String)
     */
    public SecretWord(final String stringRepresentation) throws
            ShortWordException,
            LongWordException,
            InvalidWordException {

        checkWord(stringRepresentation);

        this.secretWord = stringRepresentation.trim().toLowerCase();
    }

    /**
     * Returns the current {@code SecretWord}, or {@code null}
     * if the user still hasn't selected one.
     *
     * @return the current {@code SecretWord} or {@code null}.
     */
    public static SecretWord getCurrentSecretWord() {
        return currentSecretWord;
    }

    /**
     * Sets a new secret word as the current secret word.
     * <p>
     * Note that it's not allowed to set a new secret word while
     * a {@code Game} is running (if {@code Game.getRunningGame() != null})
     *
     * @param newSecretWord the new secret word to set as current secret word.
     * @throws RunningGameException if a {@code Game} is running.
     */
    public static void setCurrentSecretWord(final SecretWord newSecretWord)
            throws RunningGameException {
        if (Game.getRunningGame() == null) {
            currentSecretWord = newSecretWord;
        } else {
            throw new RunningGameException();
        }
    }

    /**
     * Returns a string representation of this {@code SecretWord}.
     *
     * @return a string representation of this {@code SecretWord}.
     */
    @Override
    public String toString() {
        return secretWord;
    }

    /**
     * Compares the string representation of this secret word to another String,
     * ignoring case considerations.
     *
     * @param word The String to compare this secret word against
     * @return {@code true}  if the argument is not null and
     *                       it represents an equivalent String ignoring case;
     *         {@code false} otherwise
     */
    public boolean equalsIgnoreCase(final String word) {
        return secretWord.equalsIgnoreCase(word);
    }
}
