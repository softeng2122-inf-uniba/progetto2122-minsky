package it.uniba.app.wordle;

import it.uniba.app.exception.InvalidLetterException;
import it.uniba.app.exception.InvalidWordException;
import it.uniba.app.exception.LongWordException;
import it.uniba.app.exception.ShortWordException;

public class AttemptWord extends Word {

    private static final String SHORT_ATTEMPT_MESSAGE =
            "Tentativo incompleto, parola troppo corta, " +
                    "per maggiori informazioni digitare /help";
    private static final String LONG_ATTEMPT_MESSAGE =
            "Tentativo eccessivo, parola troppo lunga, " +
                    "per maggiori informazioni digitare /help";
    private static final String INVALID_ATTEMPT_MESSAGE =
            "Tentativo non valido, caratteri non riconosciuti, " +
                    "per maggiori informazioni digitare /help";
    private final Letter[] letters;

    public AttemptWord(final Letter[] letters) throws ShortWordException, LongWordException {
        if (letters.length < Word.getLength()) {
            throw new ShortWordException(SHORT_ATTEMPT_MESSAGE);
        } else if (letters.length > Word.getLength()) {
            throw new LongWordException(LONG_ATTEMPT_MESSAGE);
        } else {
            this.letters = letters;
        }

    }

    public AttemptWord(String word) throws ShortWordException, LongWordException, InvalidWordException {
        word = word.trim();

        if (word.length() < Word.getLength()) {
            throw new ShortWordException(SHORT_ATTEMPT_MESSAGE);
        } else if (word.length() > Word.getLength()) {
            throw new LongWordException(LONG_ATTEMPT_MESSAGE);
        } else {
            letters = new Letter[Word.getLength()];

            try {
                for (int i = 0; i < Word.getLength(); i++) {
                    letters[i] = new Letter(word.charAt(i));
                }
            } catch (InvalidLetterException e) {
                throw new InvalidWordException(INVALID_ATTEMPT_MESSAGE);
            }
        }
    }

    public final Letter[] getLetters() {
        return letters;
    }

    public final boolean equalsIgnoreCase(final SecretWord secretWord) {
        for (int i = 0; i < Word.getLength(); i++) {
            if (!getLetters()[i].equalsIgnoreCase(secretWord.toString().charAt(i))) return false;
        }

        return true;
    }
}
