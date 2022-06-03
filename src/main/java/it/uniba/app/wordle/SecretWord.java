package it.uniba.app.wordle;

import it.uniba.app.exception.InvalidLetterException;
import it.uniba.app.exception.LongWordException;
import it.uniba.app.exception.RunningGameException;
import it.uniba.app.exception.ShortWordException;

/**
 * <Entity>
 * <p>
 * A secret word in Wordle.
 */

public class SecretWord extends Word {
    private static SecretWord currentSecretWord;

    public SecretWord(final String word) throws ShortWordException, LongWordException, InvalidLetterException {
        super(word.toLowerCase());
    }

    public static SecretWord getCurrentSecretWord() {
        return currentSecretWord;
    }

    public static void setCurrentSecretWord(final SecretWord secretWord) throws RunningGameException {
        if (Game.getRunningGame() == null) {
            currentSecretWord = secretWord;
        } else {
            throw new RunningGameException();
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        for (Letter l : getLetters()) {
            sb.append(l.getCharacter());
        }

        return sb.toString();
    }
}
