package it.uniba.app.exception;

/**
 * <noECB>
 * <p>
 * Rappresenta una situazione in cui l'utente
 * ha inserito una parola troppo corta.
 */

public class ParolaCortaException extends Exception {

    public String showMessage(){
        
        return "[ERRORE]: Tentativo incompleto, parola troppo corta, per maggiori informazioni digitare /help \n\n";
    }

}
