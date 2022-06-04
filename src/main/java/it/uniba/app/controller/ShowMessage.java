package it.uniba.app.controller;
import it.uniba.app.exception.MissingCurrentSecretWordException;
import it.uniba.app.wordle.SecretWord;

/**
 * <Control>
 * <p>
 * This class is used to display the current {@code SecretWord}
 * if it has already been selected.
 *
 * @see SecretWord
 */

public class ShowMessage implements Controller{
    private static final String SHOWING_MESSAGE = "Questa è la parola segreta impostata: ";
    private static final String MISSING_WORD="\n[ERRORE]Non è stata impostata nessuna parola segreta";
    
    @Override
    public void control(String[] args)  {

        
        try{
            if (SecretWord.getCurrentSecretWord() != null) {
                System.out.println(SHOWING_MESSAGE);
                System.out.println(SecretWord.getCurrentSecretWord().toString());
            } else {
                throw new MissingCurrentSecretWordException();
            }  
        } catch (MissingCurrentSecretWordException e) {
            System.out.println(MISSING_WORD);
        }
         
    }
}