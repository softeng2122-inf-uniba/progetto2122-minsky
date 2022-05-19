package it.uniba.app.utility;

/**
 * <Boundary>
 * <p>
 * Interagisce con l'utente, mostrando il feedback relativo
 * all'abbandono di una partita.
 */

public class AbbandonaPartitaBoundary {
    private static final String gameNotRunningErrorMessage = "[ERRORE] Non c'è nessuna partita in corso.";
    private static final String AbandonGameMessage = "[OK] La Partita è stata abbandonata.";

    public static void showGameNotRunningError() {
        System.out.println();
        System.out.println(gameNotRunningErrorMessage);
        System.out.println();
    }

    public static void showPartitaAbbandonata() {
        System.out.println();
        System.out.println(AbandonGameMessage);
        System.out.println();
    }
}
