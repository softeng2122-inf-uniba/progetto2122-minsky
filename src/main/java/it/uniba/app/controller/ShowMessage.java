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
    private static final String MISSING_WORD="\n[ERRORE]Non è stata impostata nessuna parola segreta";
    
    @Override
    public void control(String[] args)  {
        
        
        try{
            if(ParolaSegreta.getAttualeParolaSegreta()!=null){
            System.out.println(SHOWING_MESSAGE);
            System.out.println(ParolaSegreta.getAttualeParolaSegreta().toString());
        }
            else{
                throw new ParolaSegretaMancanteException();
            }  
        }
        catch (ParolaSegretaMancanteException e) {
             System.out.println(MISSING_WORD);
        }
         
    }
}