package it.uniba.app.controller;

import it.uniba.app.exception.InvalidWordException;
import it.uniba.app.exception.LongWordException;
import it.uniba.app.exception.RunningGameException;
import it.uniba.app.exception.ShortWordException;
import it.uniba.app.utility.SecretWordSelectionBoundary;
import it.uniba.app.wordle.SecretWord;

/**
 * <Control>
 * <p>
 * This class handles the process
 * for selecting a new current {@code SecretWord}.
 *
 * @see SecretWord
 */

public final class SecretWordSelectionController implements Controller {

    /**
     * Error message indicating to the user that no word has been specified.
     */
    private static final String MISSING_WORD_MESSAGE =
            "Non hai specificato alcuna parola.";

    @Override
    public void control(final String[] args) {
        SecretWordSelectionBoundary secretWordSelectionBoundary =
                new SecretWordSelectionBoundary();

        try {
            SecretWord.setCurrentSecretWord(new SecretWord(args[0]));

            secretWordSelectionBoundary.showOK();
        } catch (ArrayIndexOutOfBoundsException e) {
            secretWordSelectionBoundary.showError(MISSING_WORD_MESSAGE);
        } catch (RunningGameException | ShortWordException
                 | LongWordException | InvalidWordException e) {
            secretWordSelectionBoundary.showError(e.getLocalizedMessage());
        }
    }
}
