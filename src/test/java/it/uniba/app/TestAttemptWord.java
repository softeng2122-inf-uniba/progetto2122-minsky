package it.uniba.app;

import org.junit.jupiter.api.Test;

import it.uniba.app.exception.InvalidLetterException;
import it.uniba.app.exception.LongWordException;
import it.uniba.app.exception.ShortWordException;
import it.uniba.app.wordle.AttemptWord;
import it.uniba.app.wordle.Letter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.awt.Color;

public class TestAttemptWord {
    /**
     * Test the method {@link AttemptWord#getLetters()}
     * Test the method {@link Letter#getCharacter()}
     * Test the method {@link Letter#getColor()}.
     */
    @Test
    public void testGetLettersGetcolors() {
        try {
            char[] letters = {'a', 'b', 'c', 'd', 'e'};
            int max = letters.length;
            Letter[] letter = new Letter[max];
            for (int i = 0; i < max; i++) {
                letter[i] = new Letter(letters[i], Color.BLACK);
            }
            AttemptWord attempt = new AttemptWord(letter);
            for (int i = 0; i < max; i++) {
                char expected = attempt.getLetters()[i].getCharacter();
                assertEquals(letters[i], expected);
                assertSame(Color.BLACK, attempt.getLetters()[i].getColor());
            }
        } catch (InvalidLetterException | LongWordException
        | ShortWordException e) {
            System.out.println("InvalidLetterException");
        }

    }
}
