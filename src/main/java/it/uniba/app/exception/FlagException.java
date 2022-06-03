package it.uniba.app.exception;

/**
 * <noECB>
 * <p>
 * Thrown to indicate that the user has provided an invalid flag.
 */


public class FlagException extends Exception{
    
    public String showMessage(){
        
        return "[ERRORE] Flag non valido, riprova con -h oppure --help \n\n";
    }

}
