package it.uniba.app;

import it.uniba.app.wordle.Game;

/**
 * <Boundary>
 * <p>
 * Responsible of showing feedback messages when a player
 * tries to start a new {@code Game} of Wordle.
 *
 * @see Game
 */

public class StartGameBoundary {
    private static final String gameRunningErrorMessage = "[ERRORE] Una partita è già in corso.";
    private static final String missingSecretWordErrorMessage = "[ERRORE] La parola segreta non è stata impostata.";
    private static final String setSecretWordTip = "[TIP] Imposta una parola segreta con /nuova <parola>.";

    public void showEmptyGrid() {
        int i;
        System.out.println("┌───────────────────┐");
        System.out.println("│ GRIGLIA DI GIOCO  │");
        System.out.println("├───┬───┬───┬───┬───┤");
        for (i = 0; i < (Game.getMaxGameAttempts() - 1); i++) {
            System.out.println("│   │   │   │   │   │");
            System.out.println("├───┼───┼───┼───┼───┤");
        }
        System.out.println("│   │   │   │   │   │");
        System.out.println("└───┴───┴───┴───┴───┘");
    }

    public void showGameRunningError() {
        System.out.println();
        System.out.println(gameRunningErrorMessage);
        System.out.println();
    }

    public void showMissingSecretWord() {
        System.out.println();
        System.out.println(missingSecretWordErrorMessage);
        System.out.println(setSecretWordTip);
        System.out.println();
    }
}
