package it.uniba.app.controller;
import java.io.IOException;
import it.uniba.app.exception.InvalidConfirmationException;
import it.uniba.app.utility.ConfirmationRequest;

/**
 * <Control>
 * <p>
 * Classe per la user story di chiusura del gioco
 */


public class ExitGame implements Controller  {

    private static final String EXIT_CONFIRMATION = "Sei sicuro di voler uscire da Wordle?";
    
    ConfirmationRequest exitConfirmation = new ConfirmationRequest();
    
    
    public void control(String[] args) {
        
        System.out.println(EXIT_CONFIRMATION);
        
        try {
           if(exitConfirmation.askUserConfirmation()){
               System.exit(0);
           }
        } catch (IOException | InvalidConfirmationException ex) {
            System.out.println("Errore nell'input");
        }
   
   }
    
}
