package it.uniba.app.wordle;

import it.uniba.app.exception.LongWordException;
import it.uniba.app.exception.ShortWordException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class WordTest {

    /**
     * {@code String} containing all accepted letters for a valid word.
     */
    private static final String LETTERS = "abcdefghijklmnopqrstuvwxyz"
            + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * Length of the {@code String} {@link WordTest#LETTERS}.
     */
    private static final int LETTERS_LENGTH = LETTERS.length();

    /**
     * Used to generate random doubles and integers in
     * {@link WordTest#randomAlphaWord(int)} and
     * {@link WordTest#randomNotAlphaWord(int)}.
     */
    private static final Random RANDOM = new Random();

    private String randomAlphaWord(final int length) {
        if (length >= 0) {
            final StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < length; i++) {
                stringBuilder
                        .append(LETTERS.charAt(RANDOM.nextInt(LETTERS_LENGTH)));
            }

            return stringBuilder.toString();
        } else {
            throw new IllegalArgumentException("length must be positive.");
        }
    }

    private String randomNotAlphaWord(final int length) {
        if (length >= 0) {
            final int[] notAlphaCharIndexes = RANDOM.ints(0, length)
                    .distinct().limit(RANDOM.nextInt(length) + 1).toArray();
            final StringBuilder stringBuilder =
                    new StringBuilder(randomAlphaWord(length));

            for (final int i : notAlphaCharIndexes) {
                char randomNotAlphaChar;

                do {
                    randomNotAlphaChar =
                            (char) (RANDOM.nextInt('␡' - '!') + '!');
                }
                while (Character.isLetter(randomNotAlphaChar));

                stringBuilder.setCharAt(i, randomNotAlphaChar);
            }

            return stringBuilder.toString();
        } else {
            throw new IllegalArgumentException("length must be positive.");
        }
    }

    @Test
    void validWordTest() {
        if (Word.getLength() >= 0) {
            Assertions.assertDoesNotThrow(
                    () -> Word.checkWord(randomAlphaWord(Word.getLength())));
        }
    }

    @Test
    void emptyStringTest() {
        if (Word.getLength() > 0) {
            Assertions.assertThrows(ShortWordException.class,
                    () -> Word.checkWord(""));
        } else if (Word.getLength() == 0) {
            Assertions.assertDoesNotThrow(() -> Word.checkWord(""));
        }
    }

    @Test
    void shortWordTest() {
        if (Word.getLength() > 0) {
            Assertions.assertThrows(ShortWordException.class, () ->
                    Word.checkWord(randomAlphaWord(Word.getLength() - 1)));
        }
    }

    @Test
    void longWordTest() {
        if (Word.getLength() >= 0 && Word.getLength() < Integer.MAX_VALUE) {
            Assertions.assertThrows(LongWordException.class, () ->
                    Word.checkWord(randomAlphaWord(Word.getLength() + 1)));
        }
    }
}
