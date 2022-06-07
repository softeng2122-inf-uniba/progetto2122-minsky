package it.uniba.app.wordle;

/**
 * <Entity>
 * <p>
 * Abstract base class for representing Wordle words.
 */

public abstract class Word {

    /**
     * Length of all valid Wordle words
     */
    private static final int LENGTH = 5;

    /**
     * Returns the length of all valid Wordle words
     */
    public static int getLength() {
        return LENGTH;
    }
}
