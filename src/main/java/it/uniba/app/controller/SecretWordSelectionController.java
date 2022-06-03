package it.uniba.app.controller;

import it.uniba.app.exception.InvalidLetterException;
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
    @Override
    public void control(final String[] args) {
        SecretWordSelectionBoundary secretWordSelectionBoundary = new SecretWordSelectionBoundary();

        try {
            SecretWord.setCurrentSecretWord(new SecretWord(args[0]));

            secretWordSelectionBoundary.showOK();
        } catch (ArrayIndexOutOfBoundsException e) {
            secretWordSelectionBoundary.showMissingWordError();
        } catch (RunningGameException e) {
            secretWordSelectionBoundary.showRunningGameError();
        } catch (ShortWordException e) {
            secretWordSelectionBoundary.showShortWordError(SecretWord.getLength());
        } catch (LongWordException e) {
            secretWordSelectionBoundary.showLongWordError(SecretWord.getLength());
        } catch (InvalidLetterException e) {
            secretWordSelectionBoundary.showInvalidWordError();
        }
    }
}