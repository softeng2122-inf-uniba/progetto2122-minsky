package it.uniba.app.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import it.uniba.app.exception.InvalidLetterException;
import it.uniba.app.exception.LongWordException;
import it.uniba.app.exception.ShortWordException;
import it.uniba.app.wordle.AttemptWord;
import it.uniba.app.wordle.Letter;
import it.uniba.app.wordle.Word;

public class AnsiColorsTest {

    /** Expected bright green color ANSI sequence for characters foreground. */
    private static final String EXPECTED_BRIGHT_GREEN = "\u001b[32;1m";

    /** Expected bright red color ANSI sequence for characters foreground. */
    private static final String EXPECTED_BRIGHT_RED = "\u001b[31;1m";

    /** Bright green color ANSI sequence for characters background. */
    private static final String ANSI_BACKGROUND_BRIGHT_GREEN = "\u001b[42;1m";

    /** Bright yellow color ANSI sequence for characters background. */
    private static final String ANSI_BACKGROUND_BRIGHT_YELLOW = "\u001b[43;1m";

    /** Bright gray color ANSI sequence for characters background. */
    private static final String ANSI_BACKGROUND_BRIGHT_GRAY = "\u001b[47;1m";

    /**
     * Expected ANSI sequence that disables all attributes
     * applied from previous ANSI sequences.
     */
    private static final String EXPECTED_RESET = "\u001B[0m";

    /**Letters of attempt word. */
    private Letter[] coloredLetters;

    /**An attempt word. */
    private AttemptWord attemptWord;

    /**Expected grid row that contains colored letters. */
    private String gridRow;

    /**First index. */
    private static final int FIRST = 0;

    /**Second index. */
    private static final int SECOND = 1;

    /**Third index. */
    private static final int THIRD = 2;

    /**Fourth index. */
    private static final int FOURTH = 3;

    /**Fifth index. */
    private static final int FIFTH = 4;

    /**
     * Initial configuration of the test.
     */

    @BeforeEach
    void setUp() {

        coloredLetters = new Letter[Word.getLength()];
        try {

            coloredLetters[FIRST] = new Letter('a', Color.GREEN);
            coloredLetters[SECOND] = new Letter('b', Color.GRAY);
            coloredLetters[THIRD] = new Letter('c', Color.GREEN);
            coloredLetters[FOURTH] = new Letter('d', Color.YELLOW);
            coloredLetters[FIFTH] = new Letter('e', Color.GRAY);
            attemptWord =  new AttemptWord(coloredLetters);

        } catch (InvalidLetterException
            | ShortWordException | LongWordException e) {
            System.out.println(e.getMessage());
        }

        gridRow = "│" + ANSI_BACKGROUND_BRIGHT_GREEN + " a " + EXPECTED_RESET
            + "│" + ANSI_BACKGROUND_BRIGHT_GRAY + " b " + EXPECTED_RESET
            + "│" + ANSI_BACKGROUND_BRIGHT_GREEN + " c " + EXPECTED_RESET
            + "│" + ANSI_BACKGROUND_BRIGHT_YELLOW + " d " + EXPECTED_RESET
            + "│" + ANSI_BACKGROUND_BRIGHT_GRAY + " e " + EXPECTED_RESET + "│";

    }

    /**
     * Test the method {@link AnsiColors#getBrightGreen()}.
     */

    @Test
    @DisplayName("Green ANSI color code getter")
    void testGetBrightGreen() {
        assertEquals(EXPECTED_BRIGHT_GREEN, AnsiColors.getBrightGreen());
    }

    /**
     * Test the method {@link AnsiColors#getBrightRed()}.
     */

    @Test
    @DisplayName("Red ANSI color code getter")
    void testGetBrightRed() {
        assertEquals(EXPECTED_BRIGHT_RED, AnsiColors.getBrightRed());
    }

    /**
     * Test the method {@link AnsiColors#getReset()}.
     */

    @Test
    @DisplayName("Reset the letter ANSI color code getter")
    void testGetReset() {
        assertEquals(EXPECTED_RESET, AnsiColors.getReset());
    }

    /**
     * Test the method
     * {@link AnsiColors#convertAttemptWordToGridRow(AttemptWord)}.
     */

    @Test
    @DisplayName("Compare an artificial grid row with"
        + "the grid row generator result")
    void testConvertAttemptWordToGridRow() {
        assertEquals(gridRow,
        AnsiColors.convertAttemptWordToGridRow(attemptWord));
    }


}
