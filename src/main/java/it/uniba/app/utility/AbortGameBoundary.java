package it.uniba.app.utility;

/**
 * <Boundary>
 * <p>
 * This class is responsible for displaying feedback to the player
 * regarding their request to quit the {@code Game}.
 *
 * @see it.uniba.app.wordle.Game
 * @see it.uniba.app.controller.AbortGameController
 */

public class AbortGameBoundary {
    private static final String gameNotRunningErrorMessage = "[ERRORE] Non c'è nessuna partita in corso.";
    private static final String AbandonGameMessage = "[OK] La Partita è stata abbandonata.";

    public static void showGameNotRunningError() {
        System.out.println();
        System.out.println(gameNotRunningErrorMessage);
        System.out.println();
    }

    public static void showGameAbortedMessage() {
        System.out.println();
        System.out.println(AbandonGameMessage);
        System.out.println();
    }
}
