package it.uniba.app.exception;

/**
 * <noECB>
 * <p>
 * Rappresenta una situazione in cui l'utente
 * ha inserito una parola troppo lunga.
 */

public class ParolaLungaException extends Exception {

    public String showMessage(){
        
        return "Tentativo eccessivo, parola troppo lunga, per maggiori informazioni digitare /help";
    }

}
