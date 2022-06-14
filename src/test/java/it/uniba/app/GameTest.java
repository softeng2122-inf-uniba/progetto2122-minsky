package it.uniba.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.app.exception.InvalidWordException;
import it.uniba.app.exception.LongWordException;
import it.uniba.app.exception.MissingCurrentSecretWordException;
import it.uniba.app.exception.MissingRunningGameException;
import it.uniba.app.exception.RunningGameException;
import it.uniba.app.exception.ShortWordException;
import it.uniba.app.wordle.Game;
import it.uniba.app.wordle.SecretWord;

public class GameTest {

    /**A secret word. */
    private SecretWord secretWord;
    /**Expectation of the number of attempts. */
    private static final int EXPECTED_GAME_ATTEMPTS = 6;
    /**A game instance. */
    private Game game;

    /**
     * Initial configuration of the test.
     */
    @BeforeEach
    void setUp() {
        try {
            secretWord = new SecretWord("aaabb");
            SecretWord.setCurrentSecretWord(secretWord);
            Game.startNewGame();
            Game.getRunningGame().addCount();
            Game.getRunningGame().setWin();
        } catch (ShortWordException | LongWordException
            | InvalidWordException | RunningGameException
                | MissingCurrentSecretWordException e) {
            System.out.println(e.getMessage());
        }

    }

    /**Test the method {@link Game#Game(SecretWord)}. */

    @Test
    @DisplayName("Constructor test")
    void testGame() {
        game = new Game(secretWord);
        assertEquals(secretWord, game.getSecretWord());
    }

    /**Test the method {@link Game#getMaxGameAttempts()}. */

    @Test
    @DisplayName("Compare the current max number of attempts defined")
    void testGetMaxGameAttempts() {
        assertEquals(EXPECTED_GAME_ATTEMPTS, Game.getMaxGameAttempts());
    }

    /**Test the method {@link Game#getSecretWord()}. */

    @Test
    @DisplayName("Compare an artificial setted secret "
        + "word with the current Game secret word")
    void testGetSecretWord() {
        assertEquals(secretWord.toString(),
            Game.getRunningGame().getSecretWord().toString());
    }

    /**Test the method {@link Game#getWin()}. */

    @Test
    @DisplayName("Check if there is victory")
    void testGetWin() {
        assertTrue(Game.getRunningGame().getWin());
    }

    /**Test the method {@link Game#getCount()}. */

    @Test
    @DisplayName("Check if the counter has been increased")
    void testGetCount() {
        assertEquals(1, Game.getRunningGame().getCount());
        Game.getRunningGame().addCount();
        assertEquals(2,  Game.getRunningGame().getCount());
    }

    /**Test the method {@link Game#getRunningGame()}. */

    @Test
    @DisplayName("Check if there is a instance of Game")
    void testGetRunningGame() {
        assertNotNull(Game.getRunningGame());
    }

    /**Test the method {@link Game#getGameGrid()}. */

    @Test
    @DisplayName("Check if there is a instance of GameGrid")
    void testGetGameGrid() {
        assertNotNull(Game.getRunningGame().getGameGrid());
    }

    /**Test the method {@link Game#abortRunningGame()}. */

    @Test
    @DisplayName("Abort game test")
    void testAbortRunningGame() {

        try {
            Game.abortRunningGame();
        } catch (MissingRunningGameException e) {
            System.out.println(e.getMessage());
        }

        assertNull(Game.getRunningGame());

    }

    /**Cleaning the environment. */

    @AfterAll
    static void cleanUp() {
        try {
            Game.abortRunningGame();
        } catch (MissingRunningGameException e) {
            System.out.println(e.getMessage());
        }
    }

}
