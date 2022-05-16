package it.uniba.app.controller;

import it.uniba.app.InizioPartitaBoundary;
import it.uniba.app.exception.ParolaSegretaMancanteException;
import it.uniba.app.exception.PartitaInCorsoException;
import it.uniba.app.wordle.Partita;

/**
 * <Control>
 * <p>
 * Gestisce l'avvio di una partita di Wordle.
 */

public class InizioPartitaController implements Controller {

    @Override
    public void control(String[] args) {
        InizioPartitaBoundary inizioPartitaBoundary = new InizioPartitaBoundary();

        try {
            Partita.iniziaNuovaPartita();

            inizioPartitaBoundary.showEmptyGrid();
        } catch (PartitaInCorsoException e) {
            inizioPartitaBoundary.showGameRunningError();
        } catch (ParolaSegretaMancanteException e) {
            inizioPartitaBoundary.showMissingSecretWord();
        }
    }
}
