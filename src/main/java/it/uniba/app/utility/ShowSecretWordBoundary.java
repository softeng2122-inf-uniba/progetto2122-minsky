package it.uniba.app.utility;
/**
 * <Boundary>
 * <p>
 * This class is responsible for displaying messages to the user
 * requested by selecting the choice
 * to show the secret word {@code ShowSecretWord}.
 *
 * @see it.uniba.app.wordle.SecretWord
 * @see it.uniba.app.controller.ShowSecretWord
 */

public class ShowSecretWordBoundary {

    /** A string that shows an initial message. */
    private static final String SHOWING_MESSAGE =
    "Questa è la parola segreta impostata: ";

    /** A string that shows an error message. */
    private static final String ERROR_MESSAGE =
    "Per visualizzare la parola segreta devi prima impostarla.";

    /** A string that shows a tip. */
    private static final String TIP_MESSAGE =
    "[TIP] Imposta una parola segreta con /nuova <parola>.";

    /**
     * Displays an initial message to the user
     * that introduce the secret word.
     */
    public void showMess() {
        System.out.println(SHOWING_MESSAGE);
    }

    /**
     * Displays an error message to the user
     * using appropriate text formatting for errors.
     */
    public void showError() {
        System.out.println(new ErrorStringBuilder(ERROR_MESSAGE));
        System.out.println(TIP_MESSAGE);
    }
}
