package it.uniba.app.exception;

/**
 * <noECB>
 * <p>
 * Rappresenta una situazione dove l'utente ha tentato di
 * avviare una nuova partita mentre un'altra era già in corso.
 */

public class PartitaInCorsoException extends Exception {

    public String showMessage(){
        
        return "Impossibile effettuare un tentativo se la partita non è in corso, per maggiori informazioni digitare /help";
    }

}
