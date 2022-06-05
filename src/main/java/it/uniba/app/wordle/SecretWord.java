package it.uniba.app.wordle;

import it.uniba.app.exception.InvalidWordException;
import it.uniba.app.exception.LongWordException;
import it.uniba.app.exception.RunningGameException;
import it.uniba.app.exception.ShortWordException;

import java.util.Locale;

/**
 * <Entity>
 * <p>
 * A secret word in Wordle.
 */

public class SecretWord extends Word {
    /**
     * Error message used when user tries
     * to select a new secret word
     * when a game is running.
     */
    private static final String GAME_RUNNING_ERROR_MESSAGE =
            "Non è possibile modificare la parola segreta durante una partita.";
    /**
     * Error message used when user enters
     * a secret word that is too short.
     */
    private static final String SHORT_SECRET_WORD_ERROR_MESSAGE =
            "Parola segreta troppo corta (deve essere di %d lettere).";
    /**
     * Error message used when user enters
     * a secret word that is too long.
     */
    private static final String LONG_SECRET_WORD_ERROR_MESSAGE =
            "Parola segreta troppo lunga (deve essere di %d lettere).";
    /**
     * Error message used when user enters
     * a secret word that contains some characters
     * that are not letters.
     */
    private static final String INVALID_SECRET_WORD_ERROR_MESSAGE =
            "Parola segreta non valida (non conteneva solo lettere dell'alfabeto).";
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
     * Note that {@code stringRepresentation} it's a valid string representation
     * if and only if:
     * <ol>
     *     <li>
     * {@code stringRepresentation.trim().length() == Word.getLength()}
     *     <li>
     * {@code stringRepresentation.trim().chars().allMatch(Character::isLetter)}
     * is {@code true}.
     * </ol>
     *
     * @param stringRepresentation string representation of
     *                             the new {@code SecretWord}.
     * @throws ShortWordException   if
     *                              {@code stringRepresentation.trim().length() < Word.getLength()}.
     * @throws LongWordException    if
     *                              {@code stringRepresentation.trim().length() > Word.getLength()}.
     * @throws InvalidWordException if
     *                              {@code stringRepresentation.trim().chars().allMatch(Character::isLetter)}
     *                              is {@code false}.
     */
    public SecretWord(final String stringRepresentation) throws
            ShortWordException,
            LongWordException,
            InvalidWordException {

        String str = stringRepresentation.trim().toLowerCase(Locale.ROOT);

        if (str.length() < Word.getLength()) {
            throw new ShortWordException(SHORT_SECRET_WORD_ERROR_MESSAGE,
                    Word.getLength());
        } else if (str.length() > Word.getLength()) {
            throw new LongWordException(LONG_SECRET_WORD_ERROR_MESSAGE,
                    Word.getLength());
        } else if (!str.chars().allMatch(Character::isLetter)) {
            throw new InvalidWordException(INVALID_SECRET_WORD_ERROR_MESSAGE);
        } else {
            this.secretWord = str;
        }

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
            throw new RunningGameException(GAME_RUNNING_ERROR_MESSAGE);
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
}
