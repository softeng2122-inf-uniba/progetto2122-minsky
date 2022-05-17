package it.uniba.app.controller;

import it.uniba.app.exception.LetteraInvalidaException;
import it.uniba.app.exception.ParolaCortaException;
import it.uniba.app.exception.ParolaLungaException;
import it.uniba.app.exception.PartitaInCorsoException;
import it.uniba.app.utility.SelezioneParolaSegretaBoundary;
import it.uniba.app.wordle.ParolaSegreta;

/**
 * <Control>
 * <p>
 * Gestisce il processo di selezione di una nuova parola segreta.
 */

public final class SelezioneParolaSegretaController implements Controller {
    @Override
    public void control(final String[] args) {
        SelezioneParolaSegretaBoundary selezioneParolaSegretaBoundary = new SelezioneParolaSegretaBoundary();

        try {
            ParolaSegreta.impostaAttualeParolaSegreta(new ParolaSegreta(args[0]));

            selezioneParolaSegretaBoundary.mostraOK();
        } catch (ArrayIndexOutOfBoundsException e) {
            selezioneParolaSegretaBoundary.mostraErroreParolaMancante();
        } catch (PartitaInCorsoException e) {
            selezioneParolaSegretaBoundary.mostraErrorePartitaInCorso();
        } catch (ParolaCortaException e) {
            selezioneParolaSegretaBoundary.mostraErroreParolaCorta(ParolaSegreta.getLength());
        } catch (ParolaLungaException e) {
            selezioneParolaSegretaBoundary.mostraErroreParolaLunga(ParolaSegreta.getLength());
        } catch (LetteraInvalidaException e) {
            selezioneParolaSegretaBoundary.mostraErroreParolaInvalida();
        }
    }
}
