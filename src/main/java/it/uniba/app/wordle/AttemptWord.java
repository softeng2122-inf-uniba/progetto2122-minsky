package it.uniba.app.wordle;

import it.uniba.app.exception.LongWordException;
import it.uniba.app.exception.ShortWordException;

public class AttemptWord extends Word {

    /** Letters from which this {@link AttemptWord} is composed. */
    private final Letter[] attemptLetters;

    /**
     * Constructs a new {@link AttemptWord} composed of the letters
     * contained in the given array of {@link Letter}.
     *
     * @param letters array of {@link Letter}
     * @throws ShortWordException if {@code letters.length < Word.getLength()}
     * @throws LongWordException if {@code letters.length > Word.getLength()}
     */
    public AttemptWord(final Letter[] letters)
            throws ShortWordException, LongWordException {

        if (letters.length < Word.getLength()) {
            throw new ShortWordException(
                    "Array letters length is less than Word.getLength().");
        } else if (letters.length > Word.getLength()) {
            throw new LongWordException(
                    "Array letters length is greater than Word.getLength().");
        } else {
            this.attemptLetters = letters.clone();
        }
    }

    /**
     * Returns a copy of letters of which this {@link AttemptWord} is composed.
     *
     * @return {@link Letter} array.
     */
    public final Letter[] getLetters() {
        return attemptLetters.clone();
    }

}
