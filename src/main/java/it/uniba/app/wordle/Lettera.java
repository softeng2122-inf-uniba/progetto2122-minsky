package it.uniba.app.wordle;

import it.uniba.app.exception.LetteraInvalidaException;

import java.awt.*;

/**
 * <Entity>
 * <p>
 * Rappresenta una lettera di una Parola del gioco.
 */

public final class Lettera {
    private final char carattere;
    private final Color colore;

    public Lettera(final char carattere, final Color colore) throws LetteraInvalidaException {
        if (Character.isLetter(carattere)) {
            this.carattere = carattere;
            this.colore = colore;
        } else {
            throw new LetteraInvalidaException();
        }
    }

    public Lettera(final char carattere) throws LetteraInvalidaException {
        this(carattere, null);
    }

    public char getCarattere() {
        return carattere;
    }

    public Color getColore() {
        return colore;
    }

    public boolean equalsIgnoreCaseAndColor(final Lettera lettera) {
        return Character.toLowerCase(getCarattere())
                == Character.toLowerCase(lettera.getCarattere());
    }
}
