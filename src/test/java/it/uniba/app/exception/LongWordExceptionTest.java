package it.uniba.app.exception;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import it.uniba.app.wordle.AttemptWord;
import it.uniba.app.wordle.Letter;
import it.uniba.app.wordle.SecretWord;
import it.uniba.app.wordle.Word;


/**
 * Class used to test {@code LongWordException}.
 */
public class LongWordExceptionTest extends Exception {

    /** random generated string used for testing purposes. */
    private String generatedString;
    /** Instance of Random used to generate the {@link #generatedString}. */
    private final Random random = new Random();

    /** method used to generate a random string. */
    @BeforeEach
    @DisplayName("Generating the random string for the test")
    void generateRandomString() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder randomstring = new StringBuilder(Word.getLength() + 1);
        for (int i = 0; i < Word.getLength() + 1; i++) {
            char c = chars[random.nextInt(chars.length)];
            randomstring.append(c);
        }
        generatedString = randomstring.toString();

    }

    /** method used to test if an {@code AttemptWord} is too long. */
    @Test
    public void testLongAttemptWord() {
        assertThrows(LongWordException.class, () -> {
            new AttemptWord(new Letter[Word.getLength() + 1]);
        });

    }

    /** method used to test if a {@code SecretWord} is too long. */
    @Test
    public void testLongSecretWord() {
        assertThrows(LongWordException.class, () -> {
            new SecretWord(generatedString);
        });
    }

}

