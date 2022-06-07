package it.uniba.app.utility;
/**
 * <Boundary>
 * <p>
 * this class is resposible for displaying messages to the user
 * requested by selecting the choice
 * to show the secret word{@code ShowMessage}.
 *
 * @see it.uniba.app.wordle.SecretWord
 * @see it.uniba.app.controller.ShowMessage
 */

public class ShowMessageBoundary {

    /**
     * @param is a string that show an initial message.
     */
    private static final String SHOWING_MESSAGE =
    "Questa è la parola segreta impostata: ";

    /**
     * @param is a string that show a tip.
     */
    private static final String TIP_MESSAGE =
    "[TIP] Imposta una parola segreta con /nuova <parola>.";

    /**
     * Displays an initial message to the user
     * tthat introduce the secret word.
     */
    public void showMess() {
        System.out.println(SHOWING_MESSAGE);
    }

    /**
     * Displays a message to the user
     * using appropriate text formatting for errors.
     *
     * @param errorMessage the message displayed to the user
     */
    public void showError(final String errorMessage) {
        System.out.println(new ErrorStringBuilder(errorMessage));
        System.out.println(TIP_MESSAGE);
    }
}
