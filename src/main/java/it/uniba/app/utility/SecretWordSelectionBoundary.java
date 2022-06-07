package it.uniba.app.utility;

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
     * Displays a message to the user
     * confirming that the secret word entered has been successfully selected,
     * using appropriate formatting.
     */
    public void showOK() {
        System.out.println(OK_MESSAGE);
    }

    /**
     * Displays an error message to the user
     * using appropriate text formatting for errors.
     *
     * @param errorMessage the message displayed to the user
     */
    public void showError(final String errorMessage) {
        System.out.println(new ErrorStringBuilder(errorMessage));
    }
}
