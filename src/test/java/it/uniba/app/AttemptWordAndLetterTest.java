package it.uniba.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.app.exception.InvalidLetterException;
import it.uniba.app.exception.LongWordException;
import it.uniba.app.exception.ShortWordException;
import it.uniba.app.wordle.AttemptWord;
import it.uniba.app.wordle.Letter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.awt.Color;

public class AttemptWordAndLetterTest {
    /**
     * The word to be tested.
     */
    private AttemptWord attempt;
    /**
     * The letter that compose the attempt.
     */
    private Letter[] letter;
    /**
     * The letter that the test expects.
     */
    private char[] letters = {'a', 'b', 'c', 'd', 'e'};
    /**
     * A costant that represents the number of letters in the word.
     */
    private int max = letters.length;
    /**
     * Initializer for the test.
     */ 
    @BeforeEach
    public void setup() {
        try {
            letter = new Letter[max];
            for (int i = 0; i < max; i++) {
                letter[i] = new Letter(letters[i], Color.BLACK);
            }
            attempt = new AttemptWord(letter);
        } catch (InvalidLetterException | LongWordException
        | ShortWordException e) {
            System.out.println(e.getMessage());
        }

    } 
    /**
     * Test the method {@link AttemptWord#getLetters()}
     * Test the method {@link Letter#getCharacter()}
     * Test the method {@link Letter#getColor()}.
     */
    @Test
    @DisplayName("Test the method getLetters(), getCharacter() and getColor()")
    public void testGetLettersGetcolors(){
        for (int i = 0; i < max; i++) {
                char expected = attempt.getLetters()[i].getCharacter();
                assertEquals(letters[i], expected);
                assertSame(Color.BLACK, attempt.getLetters()[i].getColor());
            }
    }
}
