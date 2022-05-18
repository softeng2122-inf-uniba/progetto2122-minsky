package it.uniba.app.exception;

/**
 * <noECB>
 * <p>
 * Rappresenta una situazione in cui l'utente ha inserito
 * una parola contenente caratteri non alfabetici.
 */

public class LetteraInvalidaException extends Exception {


    public String showMessage(){
        
        return "[ERRORE]: Tentativo non valido, carratteri non riconosciuti, per maggiori informazioni digitare /help \n\n";
    }

}
