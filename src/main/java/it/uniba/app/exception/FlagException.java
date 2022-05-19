package it.uniba.app.exception;

public class FlagException extends Exception{
    
    public String showMessage(){
        
        return "[ERRORE] Flag non valido, riprova con -h oppure --help \n\n";
    }

}
