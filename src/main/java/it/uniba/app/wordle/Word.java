package it.uniba.app.wordle;

import it.uniba.app.exception.InvalidLetterException;
import it.uniba.app.exception.LongWordException;
import it.uniba.app.exception.ShortWordException;

/**
 * <Entity>
 * <p>
 * Base class for representing Wordle words.
 */

public class Word {
    private static int length = 5;

    private final Letter[] letters;

    public Word(final Letter[] letters) throws ShortWordException, LongWordException {
        if (letters.length < getLength()) {
            throw new ShortWordException();
        } else if (letters.length > getLength()) {
            throw new LongWordException();
        } else {
            this.letters = letters;
        }

    }

    public Word(String word) throws ShortWordException, LongWordException, InvalidLetterException {
        word = word.trim();

        if (word.length() < getLength()) {
            throw new ShortWordException();
        } else if (word.length() > getLength()) {
            throw new LongWordException();
        } else {
            letters = new Letter[getLength()];

            for (int i = 0; i < getLength(); i++) {
                letters[i] = new Letter(word.charAt(i));
            }
        }
    }

    public static int getLength() {
        return length;
    }

    public final Letter[] getLetters() {
        return letters;
    }

    public final boolean equalsIgnoreCaseAndColors(final Word word) {
        for (int i = 0; i < getLength(); i++) {
            if (!getLetters()[i].equalsIgnoreCaseAndColor(word.getLetters()[i])) return false;
        }

        return true;
    }
}
