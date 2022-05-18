package it.uniba.app.controller;
import it.uniba.app.wordle.ParolaSegreta;
/**
 * <Control>
 * <p>
 * Classe che permette di visualizzare la parola segreta se impostata 
 */

public class ShowMessage implements Controller{
    private static final String SHOWING_MESSAGE = "Questa è la parola segreta impostata: ";
    private static final String ERROR_SHOWING_MESSAGE= "\nLa parola segreta non è stata impostata";
    
    public void control(String[] args){
        System.out.println(SHOWING_MESSAGE);
        
        try{
            if(ParolaSegreta.getAttualeParolaSegreta()!=null){
                System.out.println(ParolaSegreta.getAttualeParolaSegreta());
            }
            else{
                System.out.println(ERROR_SHOWING_MESSAGE);           
             }
        }
        catch(Exception ex){
              System.out.println(ex);
        }
        /**
         * catch(ParolaSegretaMancanteException ex){
         *       inizioPartitaBoundary.showMissingSecretWord();
         * }
         */
    }
}