package it.uniba.app.wordle;

import it.uniba.app.exception.LetteraInvalidaException;
import it.uniba.app.exception.ParolaCortaException;
import it.uniba.app.exception.ParolaLungaException;
import it.uniba.app.exception.PartitaInCorsoException;

/**
 * <Entity>
 * <p>
 * Rappresenta una parola segreta di Wordle.
 */

public class ParolaSegreta extends Parola {
    private static ParolaSegreta attualeParolaSegreta;

    public ParolaSegreta(final String parola) throws ParolaCortaException, ParolaLungaException, LetteraInvalidaException {
        super(parola.toLowerCase());
    }

    public static void impostaAttualeParolaSegreta(final ParolaSegreta parolaSegreta) throws PartitaInCorsoException {
        if (Partita.getPartitaInCorso() == null) {
            attualeParolaSegreta = parolaSegreta;
        } else {
            throw new PartitaInCorsoException();
        }
    }

    public static ParolaSegreta getAttualeParolaSegreta() {
        return attualeParolaSegreta;
    }
}
