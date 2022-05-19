package it.uniba.app.controller;

import it.uniba.app.exception.InvalidConfirmationException;
import it.uniba.app.exception.NessunaPartitaInCorsoException;
import it.uniba.app.utility.AbbandonaPartitaBoundary;
import it.uniba.app.utility.ConfirmationRequest;
import it.uniba.app.wordle.Partita;

import java.io.IOException;

/**
 * <Control>
 * <p>
 * Gestisce l'abbandono di una partita di Wordle.
 */
public class AbbandonaPartitaController implements Controller {
    @Override
    public void control(String[] args) {
        try {
            if (Partita.getPartitaInCorso() != null) {
                System.out.println("Vuoi Abbandonare la partita in corso?");
                ConfirmationRequest abandonConfirmation = new ConfirmationRequest();
                if (abandonConfirmation.askUserConfirmation()) {
                    Partita.AbbandonaPartita();
                    AbbandonaPartitaBoundary.showPartitaAbbandonata();
                }
            } else {
                throw new NessunaPartitaInCorsoException();
            }
        } catch (IOException | InvalidConfirmationException ex) {
            System.out.println("Errore nell'input");
        } catch (NessunaPartitaInCorsoException e) {
            AbbandonaPartitaBoundary.showGameNotRunningError();
        }
    }
}
