package it.uniba.app.controller;
import it.uniba.app.exception.MissingCurrentSecretWordException;
import it.uniba.app.wordle.SecretWord;
import it.uniba.app.utility.ShowMessageBoundary;

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
    private static final String ERROR_MESSAGE =
    "Per visualizzare la parola segreta devi prima impostarla.";

    /**
     * This method is used to display the current {@code SecretWord}.
     */
    @Override
    public void control(final String[] args) {
        ShowMessageBoundary showMessageBoundary = new ShowMessageBoundary();
        try {
            if (SecretWord.getCurrentSecretWord() != null) {
                showMessageBoundary.showMess();
                SecretWord thisSecrW = SecretWord.getCurrentSecretWord();
                System.out.println(thisSecrW.toString().toUpperCase());
            } else {
                throw new MissingCurrentSecretWordException();
            }
        } catch (MissingCurrentSecretWordException e) {
            showMessageBoundary.showError(ERROR_MESSAGE);
        }

    }
}
