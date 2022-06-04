package it.uniba.app.wordle;

import java.util.List;

/**
 * <Entity>
 * <p>
 * A {@code GameGrid} is responsible of
 * memorizing the attempts the player has done
 * in a specific {@code Game} of Wordle.
 *
 * @see Game
 */

public class GameGrid {
    private List<Word> gameAttempts;
}
