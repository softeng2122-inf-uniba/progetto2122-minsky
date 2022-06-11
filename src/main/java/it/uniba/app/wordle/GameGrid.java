package it.uniba.app.wordle;

import java.util.ArrayList;
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

    /** List of attempts contained in this game grid. */
    private List<AttemptWord> attemptWords = new ArrayList<>();

    /**
     * Get an attempt word at index.
     * @param index
     * @return the attempt word at index
     */

    public AttemptWord getWord(final int index) {
        return attemptWords.get(index);
    }

    /**
     * Add an attempt word at the list.
     * @param attempt
     */

    public void setWord(final AttemptWord attempt) {
        this.attemptWords.add(attempt);
    }

}
