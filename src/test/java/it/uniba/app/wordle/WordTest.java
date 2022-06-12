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

    private String randomAlphaWord(final int length) {
        if (length >= 0) {
            final Random random = new Random();
            final StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < length; i++) {
                stringBuilder
                        .append(LETTERS.charAt(random.nextInt(LETTERS_LENGTH)));
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
