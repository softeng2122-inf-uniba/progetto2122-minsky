package it.uniba.app.controller;
import it.uniba.app.exception.ParolaSegretaMancanteException;
import it.uniba.app.wordle.ParolaSegreta;
/**
 * <Control>
 * <p>
 * Classe che permette di visualizzare la parola segreta se impostata 
 */

public class ShowMessage implements Controller{
    private static final String SHOWING_MESSAGE = "Questa è la parola segreta impostata: ";
    
    @Override
    public void control(String[] args)  {
        System.out.println(SHOWING_MESSAGE);
        
        try{
            System.out.println(ParolaSegreta.getAttualeParolaSegreta());
            throw new ParolaSegretaMancanteException();
        }
        catch (ParolaSegretaMancanteException e) {
             System.out.println(e);
        }
         
    }
}