package it.uniba.app.ui;

import it.uniba.app.exception.InvalidWordException;
import it.uniba.app.exception.LongWordException;
import it.uniba.app.exception.RunningGameException;
import it.uniba.app.exception.ShortWordException;
import it.uniba.app.utility.AnsiColors;
import it.uniba.app.utility.ErrorStringBuilder;
import it.uniba.app.wordle.Word;

/**
 * <Boundary>
 * <p>
 * This class is responsible for displaying feedback to the user
 * regarding their request to select a new {@code SecretWord}.
 *
 * @see it.uniba.app.wordle.SecretWord
 * @see it.uniba.app.controller.SecretWordSelectionController
 */

public final class SecretWordSelectionBoundary {

    /**
     * Message confirming to the user that
     * the secret word has been correctly selected.
     */
    private static final String OK_MESSAGE = AnsiColors.getBrightGreen()
            + "[OK] Parola segreta impostata con successo!"
            + AnsiColors.getReset();
    /**
     * Error message used when user tries
     * to select a new secret word
     * when a game is running.
     */
    private static final String GAME_RUNNING_ERROR_MESSAGE =
            "Non è possibile modificare la parola segreta durante una partita.";
    /**
     * Error message indicating to the user that no word has been specified.
     */
    private static final String MISSING_WORD_MESSAGE =
            "Non hai specificato alcuna parola.";
    /**
     * Error message used when user enters
     * a secret word that is too short.
     */
    private static final String SHORT_SECRET_WORD_ERROR_MESSAGE = String.format(
            "Parola segreta troppo corta (deve essere di %d lettere).",
            Word.getLength());
    /**
     * Error message used when user enters
     * a secret word that is too long.
     */
    private static final String LONG_SECRET_WORD_ERROR_MESSAGE = String.format(
            "Parola segreta troppo lunga (deve essere di %d lettere).",
            Word.getLength());
    /**
     * Error message used when user enters
     * a secret word that contains some characters
     * that are not letters.
     */
    private static final String INVALID_SECRET_WORD_ERROR_MESSAGE =
            "Parola segreta non valida "
                    + "(non conteneva solo lettere dell'alfabeto).";

    /**
     * Displays a message to the user
     * confirming that the secret word entered has been successfully selected,
     * using appropriate formatting.
     */
    public void showOK() {
        System.out.println(OK_MESSAGE);
    }

    /**
     * Displays an error message to the user,
     * based on the type of the given {@code Exception}.
     *
     * @param exception indicates the error type.
     */
    public void showError(final Exception exception) {
        String errorMessage;

        if (exception instanceof RunningGameException) {
            errorMessage = GAME_RUNNING_ERROR_MESSAGE;
        } else if (exception instanceof ArrayIndexOutOfBoundsException) {
            errorMessage = MISSING_WORD_MESSAGE;
        } else if (exception instanceof ShortWordException) {
            errorMessage = SHORT_SECRET_WORD_ERROR_MESSAGE;
        } else if (exception instanceof LongWordException) {
            errorMessage = LONG_SECRET_WORD_ERROR_MESSAGE;
        } else if (exception instanceof InvalidWordException) {
            errorMessage = INVALID_SECRET_WORD_ERROR_MESSAGE;
        } else {
            throw new IllegalArgumentException();
        }

        System.out.println(new ErrorStringBuilder(errorMessage));
    }
}
