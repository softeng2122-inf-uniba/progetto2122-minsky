package it.uniba.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import it.uniba.app.exception.InvalidLetterException;
import it.uniba.app.exception.LongWordException;
import it.uniba.app.exception.ShortWordException;
import it.uniba.app.wordle.AttemptWord;
import it.uniba.app.wordle.GameGrid;
import it.uniba.app.wordle.Letter;
import it.uniba.app.wordle.Word;

public class GameGridTest {

    /**Game grid. */
    private GameGrid gameGrid;
    /**An attempt word. */
    private AttemptWord attemptWord;
    /**Letters of attempt word. */
    private Letter[] letters;

    /**
     * Initial configuration of the test.
     */

    @BeforeEach
    void setUp() {

        gameGrid = new GameGrid();
        letters = new Letter[Word.getLength()];

        try {

            for (Letter letter : letters) {
                letter = new Letter('a', Color.GREEN);
            }

            attemptWord = new AttemptWord(letters);
            gameGrid.setWord(attemptWord);

        } catch (InvalidLetterException
            | ShortWordException | LongWordException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Test the method {@link GameGrid#getWord(int)}.
     */

    @Test
    @DisplayName("Compare an artificial attempt Word added to a game grid with the return of getWord of game grid")
    void testGetWord() {

        assertEquals(attemptWord, gameGrid.getWord(0));

    }

}
