package it.uniba.app.wordle;

import it.uniba.app.exception.InvalidWordException;
import it.uniba.app.exception.LongWordException;
import it.uniba.app.exception.ShortWordException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Random;

class SecretWordTest {

    /**
     * Used to generate a random boolean in
     * {@link SecretWordTest#getCurrentSecretWordTest()}.
     */
    private static final Random RANDOM = new Random();

    @Test
    void validSecretWordTest()
            throws LongWordException, ShortWordException, InvalidWordException,
            NoSuchFieldException, IllegalAccessException {

        if (Word.getLength() >= 0) {
            final String secretWordString =
                    WordTest.randomAlphaWord(Word.getLength());

            Assertions
                    .assertDoesNotThrow(() -> new SecretWord(secretWordString));

            final SecretWord secretWord = new SecretWord(secretWordString);
            final Field secretWordStringRepresentation =
                    secretWord.getClass().getDeclaredField("secretWord");

            Assertions.assertSame(
                    secretWordStringRepresentation.getType(), String.class);

            secretWordStringRepresentation.setAccessible(true);

            Assertions.assertTrue(secretWordString.equalsIgnoreCase(
                    (String) secretWordStringRepresentation.get(secretWord)));
        }
    }

    @Test
    void getCurrentSecretWordTest()
            throws LongWordException, ShortWordException, InvalidWordException,
            NoSuchFieldException, IllegalAccessException {

        final Field currentSecretWord =
                SecretWord.class.getDeclaredField("currentSecretWord");

        Assertions.assertSame(currentSecretWord.getType(), SecretWord.class);

        currentSecretWord.setAccessible(true);

        if (RANDOM.nextBoolean() && Word.getLength() >= 0) {
            currentSecretWord.set(null,
                    new SecretWord(WordTest.randomAlphaWord(Word.getLength())));
        }

        Assertions.assertEquals(
                currentSecretWord.get(null), SecretWord.getCurrentSecretWord());
    }
}
