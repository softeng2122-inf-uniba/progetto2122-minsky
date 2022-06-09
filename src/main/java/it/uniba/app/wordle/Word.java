package it.uniba.app.wordle;

import it.uniba.app.exception.InvalidWordException;
import it.uniba.app.exception.LongWordException;
import it.uniba.app.exception.ShortWordException;

/**
 * <Entity>
 * <p>
 * Abstract base class for representing Wordle words.
 */

public abstract class Word {

    /**
     * Length of all valid Wordle words.
     */
    private static final int LENGTH = 5;


    /**
     * Checks if the given string is a valid Wordle word.
     *
     * Note that {@code wordString} is a valid Wordle word if and only if:
     *
     * <ol>
     *     <li>
     * {@code wordString.trim().length() == Word.getLength()}
     *     <li>
     * {@code wordString.trim().chars().allMatch(Character::isLetter)}
     * is {@code true}.
     * </ol>
     * @param wordString string to check as valid Wordle word.
     * @throws ShortWordException if
     *         {@code wordString.trim().length() < Word.getLength()}
     *
     * @throws LongWordException if
     *         {@code wordString.trim().length() > Word.getLength()}
     *
     * @throws InvalidWordException if
     *         {@code wordString.trim().chars().allMatch(Character::isLetter)}
     *         is {@code false}.
     */
    public static void checkWord(final String wordString)
            throws ShortWordException, LongWordException, InvalidWordException {

        String word = wordString.trim();

        if (word.length() < LENGTH) {
            throw new ShortWordException();
        } else if (word.length() > LENGTH) {
            throw new LongWordException();
        } else if (!word.chars().allMatch(Character::isLetter)) {
            throw new InvalidWordException();
        }
    }

    /**
     * Returns the length of all valid Wordle words.
     *
     * @return length of all valid Wordle words
     */
    public static int getLength() {
        return LENGTH;
    }
}
