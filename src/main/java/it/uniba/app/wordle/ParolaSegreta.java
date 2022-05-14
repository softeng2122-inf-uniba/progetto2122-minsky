package it.uniba.app.wordle;

import it.uniba.app.exception.LetteraInvalidaException;
import it.uniba.app.exception.ParolaCortaException;
import it.uniba.app.exception.ParolaLungaException;

/**
 * <Entity>
 * <p>
 * Rappresenta una parola segreta di Wordle.
 */

public class ParolaSegreta extends Parola {
    private static ParolaSegreta attualeParolaSegreta;

    public ParolaSegreta(final String parola) throws ParolaCortaException, ParolaLungaException, LetteraInvalidaException {
        super(parola);
    }

    public static ParolaSegreta getAttualeParolaSegreta() {
        return attualeParolaSegreta;
    }
}
