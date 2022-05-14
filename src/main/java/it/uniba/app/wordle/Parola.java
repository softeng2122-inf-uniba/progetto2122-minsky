package it.uniba.app.wordle;

import it.uniba.app.exception.LetteraInvalidaException;
import it.uniba.app.exception.ParolaCortaException;
import it.uniba.app.exception.ParolaLungaException;

/**
 * <Entity>
 * <p>
 * Rappresenta una qualsiasi parola valida in Wordle.
 */

public class Parola {
    private static int length = 5;

    private final Lettera[] lettere;

    public Parola(final Lettera[] lettere) throws ParolaCortaException, ParolaLungaException {
        if (lettere.length < getLength()) {
            throw new ParolaCortaException();
        } else if (lettere.length > getLength()) {
            throw new ParolaLungaException();
        } else {
            this.lettere = lettere;
        }

    }

    public Parola(String parola) throws ParolaCortaException, ParolaLungaException, LetteraInvalidaException {
        parola = parola.trim();

        if (parola.length() < getLength()) {
            throw new ParolaCortaException();
        } else if (parola.length() > getLength()) {
            throw new ParolaLungaException();
        } else {
            lettere = new Lettera[getLength()];

            for (int i = 0; i < getLength(); i++) {
                lettere[i] = new Lettera(parola.charAt(i));
            }
        }
    }

    public static int getLength() {
        return length;
    }

    public final Lettera[] getLettere() {
        return lettere;
    }

    public final boolean equalsIgnoreCaseAndColors(final Parola parola) {
        for (int i = 0; i < getLength(); i++) {
            if (!getLettere()[i].equalsIgnoreCaseAndColor(parola.getLettere()[i])) return false;
        }

        return true;
    }
}
