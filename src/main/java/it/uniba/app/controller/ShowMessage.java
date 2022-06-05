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

public class ShowMessage implements Controller {

    /** @param is a string that show an initial message. */
    private static final String SHOWING_MESSAGE =
    "Questa è la parola segreta impostata: ";

    /** @param is a string that show a message
     * if the current secret word is not set. */
    private static final String MISSING_WORD =
    "\n[ERRORE]Non è stata impostata nessuna parola segreta";

    /**
     * This method is used to display the current {@code SecretWord}.
     */
    @Override
    public void control(final String[] args)  {
        try {
            if (SecretWord.getCurrentSecretWord() != null) {
                System.out.println(SHOWING_MESSAGE);
                SecretWord thisSecrW = SecretWord.getCurrentSecretWord();
                System.out.println(thisSecrW.toString());
            } else {
                throw new MissingCurrentSecretWordException();
            }
        } catch (MissingCurrentSecretWordException e) {
            System.out.println(MISSING_WORD);
        }

    }
}
