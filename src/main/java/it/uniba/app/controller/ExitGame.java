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

    ConfirmationRequest exitConfirmation = new ConfirmationRequest();
    
    
    public void control(String[] args) {
             
        try {
           if(exitConfirmation.askUserConfirmation()){
               System.exit(0);
           }
        } catch (IOException | InvalidConfirmationException ex) {
            
        }
   
   }
    
}
