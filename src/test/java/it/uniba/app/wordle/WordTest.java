package it.uniba.app.wordle;

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

    @Test
    void validWordTest() {
        final Random random = new Random();
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < Word.getLength(); i++) {
            stringBuilder
                    .append(LETTERS.charAt(random.nextInt(LETTERS_LENGTH)));
        }

        Assertions.assertDoesNotThrow(
                () -> Word.checkWord(stringBuilder.toString()));
    }

    @Test
    void emptyStringTest() {
        if (Word.getLength() > 0) {
            Assertions.assertThrows(ShortWordException.class,
                    () -> Word.checkWord(""));
        } else {
            Assertions.assertDoesNotThrow(() -> Word.checkWord(""));
        }
    }

    @Test
    void shortWordTest() {
        if (Word.getLength() > 0) {
            final Random random = new Random();
            final StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < Word.getLength() - 1; i++) {
                stringBuilder
                        .append(LETTERS.charAt(random.nextInt(LETTERS_LENGTH)));
            }

            Assertions.assertThrows(ShortWordException.class,
                    () -> Word.checkWord(stringBuilder.toString()));
        }
    }
}
