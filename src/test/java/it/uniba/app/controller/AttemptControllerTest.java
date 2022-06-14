package it.uniba.app.controller;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniba.app.exception.InvalidWordException;
import it.uniba.app.exception.LongWordException;
import it.uniba.app.exception.MissingCurrentSecretWordException;
import it.uniba.app.exception.MissingRunningGameException;
import it.uniba.app.exception.RunningGameException;
import it.uniba.app.exception.ShortWordException;
import it.uniba.app.wordle.AttemptWord;
import it.uniba.app.wordle.Game;
import it.uniba.app.wordle.Letter;
import it.uniba.app.wordle.SecretWord;
import it.uniba.app.wordle.Word;
import java.awt.Color;

public class AttemptControllerTest {

  /** Instance of {@code AttemptController} that will be tested. */
  private static AttemptController attemptController;

  /** String used to set the {@code SecretWord}. */
  private static final String GREENWORD = "hello";

  /** String used to test a gray {@code AttemptWord}. */
  private static final String GRAYWORD = "bbbbb";

  /** String used to test a yellow {@code AttemptWord}. */
  private static final String YELLOWWORD = "llhoe";

  /** String used to test a mixed color {@code AttemptWord}. */
  private static final String MIXCOLORWORD = "lella";

  /** Instance of {@code SecretWord} used for testing purposes. */
  private static SecretWord secretWord;

  /** Instance of {@code AttemptWord} used for testing purposes. */
  private AttemptWord attemptWord;

  /** Instance of {@code Game} used for starting the game. */
  private Game currentGame;

  /** Array of {@code Letter} used to build up the {@link #attemptWord}. */
  private Letter[] coloredWord;

  /**
   * Creates the {@link #attemptController}.
   * Creates the {@link #secretWord}.
   * Sets the {@link #secretWord} as current SecretWord.
   * @throws ShortWordException
   * @throws LongWordException
   * @throws InvalidWordException
   * @throws RunningGameException
   */
  @BeforeAll
  public static void setUpAll()
      throws ShortWordException, LongWordException,
      InvalidWordException, RunningGameException {


    attemptController = new AttemptController();
    secretWord = new SecretWord(GREENWORD);
    SecretWord.setCurrentSecretWord(secretWord);
  }

  /**
   * Starts a new {@code Game} if there's no current game.
   * @throws RunningGameException
   * @throws MissingCurrentSecretWordException
   */
  @BeforeEach
  public void setUpEach() throws
  RunningGameException, MissingCurrentSecretWordException {

    if (Game.getRunningGame() == null) {
      Game.startNewGame();
    }

  }

  /**
   * Test the method {@link AttemptController#endAttemps()}
   * in case the user terminates the attempts without winning.
   */
  @Test
  public void testEndAttemptsWithoutWin() {

    currentGame = Game.getRunningGame();
    for (int i = 0; i < Game.getMaxGameAttempts(); i++) {
      attemptController.compereLetters(secretWord, GRAYWORD);
      currentGame.addCount();
    }

    attemptController.endAttempts();
    assertFalse(currentGame.getWin());

  }



  /**
   * Test the method {@link AttemptController#endAttemps()}
   * in case the user wins before terminating the attempts.
   */
    @Test
    public void testEndAttemptsWithWin() {
      currentGame = Game.getRunningGame();
      attemptController.compereLetters(secretWord, GREENWORD);
      currentGame.addCount();
      attemptController.endAttempts();
      assertTrue(currentGame.getWin());

    }

    /**
     * Test the method {@link AttemptController#compereLetters()}
     * in case the result is an added green {@link #attemptWord}
     * hello : hello -> | GREEN | GREEN | GREEN | GREEN | GREEN |.
     * @throws MissingRunningGameException
     */
    @Test
    public void testAttemptGreenLetters() throws MissingRunningGameException {

      currentGame = Game.getRunningGame();
      attemptController.compereLetters(secretWord, GREENWORD);
      attemptWord = currentGame.getGameGrid().getWord(0);
      coloredWord = attemptWord.getLetters();
      for (int i = 0; i < Word.getLength(); i++) {
        assertTrue(coloredWord[i].getColor() == Color.GREEN);
      }

      Game.abortRunningGame();

    }

    /**
     * Test the method {@link AttemptController#compereLetters()}
     * in case the result is an added gray {@link #attemptWord}.
     * hello : bbbbb -> | GRAY | GRAY | GRAY | GRAY | GRAY |
     * @throws MissingRunningGameException
     */
    @Test
    public void testAttemptGrayLetters() throws MissingRunningGameException {

      currentGame = Game.getRunningGame();
      attemptController.compereLetters(secretWord, GRAYWORD);
      attemptWord = currentGame.getGameGrid().getWord(0);
      coloredWord = attemptWord.getLetters();
      for (int i = 0; i < Word.getLength(); i++) {
        assertTrue(coloredWord[i].getColor() == Color.GRAY);
      }

      Game.abortRunningGame();

    }

    /**
     * Test the method {@link AttemptController#compereLetters()}
     * in case the result is an added yellow {@link #attemptWord}.
     * hello : llhoe -> | YELLOW | YELLOW | YELLOW | YELLOW | YELLOW |
     * @throws MissingRunningGameException
     */
    @Test
    public void testAttemptYellowLetters() throws MissingRunningGameException {

      currentGame = Game.getRunningGame();
      attemptController.compereLetters(secretWord, YELLOWWORD);
      attemptWord = currentGame.getGameGrid().getWord(0);
      coloredWord = attemptWord.getLetters();
      for (int i = 0; i < Word.getLength(); i++) {
        assertTrue(coloredWord[i].getColor() == Color.YELLOW);
      }

      Game.abortRunningGame();

    }

     /**
     * Test the method {@link AttemptController#compereLetters()}
     * in case the result is a mixed color {@link #attemptWord}.
     * hello : lella -> | YELLOW | GREEN | GREEN | GREEN | GRAY |
     * @throws MissingRunningGameException
     */
    @Test
    public void testMixedColorAttempt() throws MissingRunningGameException {

      currentGame = Game.getRunningGame();
      attemptController.compereLetters(secretWord, MIXCOLORWORD);
      attemptWord = currentGame.getGameGrid().getWord(0);
      coloredWord = attemptWord.getLetters();
      int index = 0;
      assertTrue(coloredWord[index].getColor() == Color.YELLOW);
      index++;
      assertTrue(coloredWord[index].getColor() == Color.GREEN);
      index++;
      assertTrue(coloredWord[index].getColor() == Color.GREEN);
      index++;
      assertTrue(coloredWord[index].getColor() == Color.GREEN);
      index++;
      assertTrue(coloredWord[index].getColor() == Color.GRAY);

      Game.abortRunningGame();

    }

  }
