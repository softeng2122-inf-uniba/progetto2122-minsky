package it.uniba.app.exception;

public class FlagException extends Exception{
    
    public String showMessage(){
        return "Errore: Flag non valido, riprova con -h oppure --help";
    }

}
