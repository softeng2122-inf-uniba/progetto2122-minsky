package it.uniba.app.wordle;

import it.uniba.app.exception.InvalidWordException;
import it.uniba.app.exception.LongWordException;
import it.uniba.app.exception.ShortWordException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

class SecretWordTest {

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
}
