package it.uniba.app.controller;
import it.uniba.app.exception.MissingCurrentSecretWordException;
import it.uniba.app.wordle.SecretWord;
import it.uniba.app.utility.ShowSecretWordBoundary;

/**
 * <Control>
 * <p>
 * This class is used to display the current {@code SecretWord}
 * if it has already been selected.
 *
 * @see SecretWord
 */

public class ShowSecretWord implements Controller {

    /**
     * This method is used to display the current {@code SecretWord}.
     */
    @Override
    public void control(final String[] args) {
        ShowSecretWordBoundary showMessageBoundary =
                new ShowSecretWordBoundary();
        try {
            if (SecretWord.getCurrentSecretWord() != null) {
                showMessageBoundary.showMess();
                SecretWord thisSecrW = SecretWord.getCurrentSecretWord();
                System.out.println(thisSecrW.toString().toUpperCase());
            } else {
                throw new MissingCurrentSecretWordException();
            }
        } catch (MissingCurrentSecretWordException e) {
            showMessageBoundary.showError();
        }

    }
}
