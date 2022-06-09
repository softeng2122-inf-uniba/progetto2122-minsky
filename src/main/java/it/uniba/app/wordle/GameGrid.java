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
    private List<AttemptWord> gameAttempts = new ArrayList<>();

    public GameGrid()
    {
      
    }

    public AttemptWord getWord(int index){
        return gameAttempts.get(index);
    }

    public void setWord(AttemptWord attempt){
        this.gameAttempts.add(attempt);
    }
}
