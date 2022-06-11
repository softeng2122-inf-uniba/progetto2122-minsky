package it.uniba.app.utility;


/**
 * <Boundary>
 * <p>
 * Responsible of showing feedback messages when a player
 * tries to start a new {@code Game} of Wordle.
 *
 * @see it.uniba.app.wordle.Game
 */

public final class StartGameBoundary {
    private static final String GAMERUNNINGERRORMESSAGE =
            "Una partita è già in corso.";
    private static final String MISSINGSECRETWORDERROR =
            "La parola segreta non è stata impostata.";
    private static final String SETSECRETWORDTIP =
            "[TIP] Per iniziare una nuova partita, devi impostare una nuova partita con il comando /nuova parola";

    private StartGameBoundary() {
        throw new
                UnsupportedOperationException(
                "Questa è una classe <<utility>> e non può essere istanziata");
    }

    public static void showGameRunningError() {
        System.out.println();
        System.out.println(new ErrorStringBuilder(GAMERUNNINGERRORMESSAGE));
        System.out.println();
    }

    public static void showMissingSecretWord() {
        System.out.println();
        System.out.println(new ErrorStringBuilder(MISSINGSECRETWORDERROR));
        System.out.println(SETSECRETWORDTIP);
        System.out.println();
    }
}
