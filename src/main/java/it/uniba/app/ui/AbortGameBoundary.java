package it.uniba.app.ui;

import it.uniba.app.utility.AnsiColors;
import it.uniba.app.utility.ErrorStringBuilder;

/**
 * <Boundary>
 * <p>
 * This class is responsible for displaying feedback to the player
 * regarding their request to quit the {@code Game}.
 *
 * @see it.uniba.app.wordle.Game
 * @see it.uniba.app.controller.AbortGameController
 */

public final class AbortGameBoundary {
    /**
     * String used to ask user if he wants to abort the
     * game currently running.
     */
    private static final String ABORT_REQUEST =
            "Vuoi Abbandonare la partita in corso?";
    /**
     * String used in {@link #showGameNotRunningError()}.
     */
    private static final String GAMENOTRUNNINGERROR =
            "Non c'è nessuna partita in corso.";
    /**
     * String used in {@link #showGameAbortedMessage()} .
     */
    private static final String ABORTGAMEMESSAGE = AnsiColors.getBrightGreen()
            + "[OK] La Partita è stata abbandonata."
            + AnsiColors.getReset();

    private AbortGameBoundary() {
        throw new
                UnsupportedOperationException(
                "Questa è una classe <<utility>> e non può essere istanziata");
    }

    /**
     * Displays an error message to the user
     * tries to abort a game that is not
     * currently running.
     */
    public static void showGameNotRunningError() {
        System.out.println();
        System.out.println(new ErrorStringBuilder(GAMENOTRUNNINGERROR));
        System.out.println();
    }

    /**
     * Displays an error message to the user
     * has successfully aborted the current game.
     */
    public static void showGameAbortedMessage() {
        System.out.println();
        System.out.println(ABORTGAMEMESSAGE);
        System.out.println();
    }
    /**
     * Displays a message to the user asking
     * if he wants to abort the game.
     */
    public static void setAbortgamemessage() {
        System.out.println();
        System.out.println(ABORT_REQUEST);
        System.out.println();
    }
}
