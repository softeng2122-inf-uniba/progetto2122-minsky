package it.uniba.app.ui;

import it.uniba.app.utility.ErrorStringBuilder;

/**
 * <Boundary>
 * <p>
 * Responsible of showing feedback messages when a player
 * tries to start a new {@code Game} of Wordle.
 *
 * @see it.uniba.app.wordle.Game
 */

public final class StartGameBoundary {
    /**
     * String used in {@link #showGameRunningError()}.
     */
    private static final String GAMERUNNINGERRORMESSAGE =
            "Una partita è già in corso.";
    /**
     * String used in {@link #showMissingSecretWord()}.
     */
    private static final String MISSINGSECRETWORDERROR =
            "Per iniziare una nuova partita, "
                    + "devi impostare una parola segreta.";
    /**
     * String used in {@link #showMissingSecretWord()}.
     */
    private static final String SETSECRETWORDTIP =
            "[TIP] Imposta la parola segreta con il comando /nuova <parola>.";

    private StartGameBoundary() {
        throw new
                UnsupportedOperationException(
                "Questa è una classe <<utility>> e non può essere istanziata");
    }

    /**
     * Displays an error message to the user
     * when there's already a game currently running.
     */
    public static void showGameRunningError() {
        System.out.println();
        System.out.println(new ErrorStringBuilder(GAMERUNNINGERRORMESSAGE));
        System.out.println();
    }

    /**
     * Displays an error message to the user
     * when he tries to start a new game
     * without set a Secret Word before.
     */
    public static void showMissingSecretWord() {
        System.out.println();
        System.out.println(new ErrorStringBuilder(MISSINGSECRETWORDERROR));
        System.out.println(SETSECRETWORDTIP);
        System.out.println();
    }
}
