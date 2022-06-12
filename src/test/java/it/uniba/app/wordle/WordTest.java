package it.uniba.app.wordle;

import it.uniba.app.exception.ShortWordException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class WordTest {

    /**
     * String containing all accepted letters for a valid word.
     */
    private static final String LETTERS = "abcdefghijklmnopqrstuvwxyz"
            + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Test
    void validWordTest() {
        final int n = LETTERS.length();
        final Random random = new Random();
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < Word.getLength(); i++) {
            stringBuilder.append(LETTERS.charAt(random.nextInt(n)));
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
}
