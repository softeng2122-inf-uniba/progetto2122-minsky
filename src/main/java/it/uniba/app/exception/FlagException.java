package it.uniba.app.exception;

/**
 * <noECB>
 * <p>
 * Rappresenta la situazione in cui l'utente sbaglai il flag
 */


public class FlagException extends Exception{
    
    public String showMessage(){
        
        return "[ERRORE] Flag non valido, riprova con -h oppure --help \n\n";
    }

}
