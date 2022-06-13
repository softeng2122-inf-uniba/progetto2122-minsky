package it.uniba.app.wordle;

import it.uniba.app.exception.InvalidWordException;
import it.uniba.app.exception.LongWordException;
import it.uniba.app.exception.RunningGameException;
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
                    String.class, secretWordStringRepresentation.getType());

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

        Assertions.assertSame(SecretWord.class, currentSecretWord.getType());

        currentSecretWord.setAccessible(true);

        if (RANDOM.nextBoolean() && Word.getLength() >= 0) {
            currentSecretWord.set(null,
                    new SecretWord(WordTest.randomAlphaWord(Word.getLength())));
        }

        Assertions.assertEquals(
                currentSecretWord.get(null), SecretWord.getCurrentSecretWord());
    }

    @Test
    void setCurrentSecretWordGameRunningTest()
            throws LongWordException, ShortWordException, InvalidWordException,
            NoSuchFieldException, IllegalAccessException {

        if (Word.getLength() >= 0) {
            final Field runningGame =
                    Game.class.getDeclaredField("runningGame");
            final SecretWord secretWord =
                    new SecretWord(WordTest.randomAlphaWord(Word.getLength()));

            runningGame.setAccessible(true);

            runningGame.set(null, new Game(secretWord));

            Assertions.assertThrows(RunningGameException.class,
                    () -> SecretWord.setCurrentSecretWord(secretWord));

            runningGame.set(null, null);
        }
    }

    @Test
    void setCurrentSecretWordGameNotRunningTest()
            throws LongWordException, ShortWordException, InvalidWordException,
            NoSuchFieldException, IllegalAccessException {

        if (Word.getLength() >= 0) {
            final SecretWord secretWord =
                    new SecretWord(WordTest.randomAlphaWord(Word.getLength()));

            Assertions.assertDoesNotThrow(
                    () -> SecretWord.setCurrentSecretWord(secretWord));

            final Field currentSecretWord =
                    SecretWord.class.getDeclaredField("currentSecretWord");

            Assertions
                    .assertSame(SecretWord.class, currentSecretWord.getType());

            currentSecretWord.setAccessible(true);

            Assertions.assertEquals(secretWord, currentSecretWord.get(null));
        }
    }

    @Test
    void toStringTest()
            throws LongWordException, ShortWordException, InvalidWordException {
        if (Word.getLength() >= 0) {
            final String secretWordString =
                    WordTest.randomAlphaWord(Word.getLength());

            Assertions.assertTrue(secretWordString.equalsIgnoreCase(
                    new SecretWord(secretWordString).toString()));
        }
    }
}
