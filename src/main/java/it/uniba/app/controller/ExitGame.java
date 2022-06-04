package it.uniba.app.controller;

import it.uniba.app.exception.InvalidConfirmationException;
import it.uniba.app.utility.ConfirmationRequest;

import java.io.IOException;

/**
 * <Control>
 * <p>
 * This class is responsible for shutting down the application.
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
