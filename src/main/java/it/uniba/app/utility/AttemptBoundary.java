package it.uniba.app.utility;

import it.uniba.app.exception.InvalidWordException;
import it.uniba.app.exception.LongWordException;
import it.uniba.app.exception.MissingRunningGameException;
import it.uniba.app.exception.ShortWordException;
import it.uniba.app.wordle.Game;

public class AttemptBoundary {

    /**
     * Error message used when user tries
     * to make a game attempt
     * when no game is running.
     */
    private static final String GAME_NOT_RUNNING_MESSAGE =
        "Impossibile effettuare un tentativo se la partita non è in corso, "
        + "per maggiori informazioni digitare /help";

    /**
     * Error message used when user enters
     * an attempt that is too short.
     */
    private static final String SHORT_ATTEMPT_MESSAGE =
        "Tentativo incompleto, parola troppo corta, "
        + "per maggiori informazioni digitare /help";

    /**
     * Error message used when user enters
     * an attempt that is too long.
     */
    private static final String LONG_ATTEMPT_MESSAGE =
        "Tentativo eccessivo, parola troppo lunga, "
        + "per maggiori informazioni digitare /help";

    /**
     * Error message used when user enters
     * an attempt that contains some characters
     * that are not letters.
     */
    private static final String INVALID_ATTEMPT_MESSAGE =
        "Tentativo non valido, caratteri non riconosciuti, "
        + "per maggiori informazioni digitare /help";

    /**
     * Error message used when user enters
     * an attempt that contains some characters
     * that are not letters.
     */
    private static final String END_ATTEMPTS_MESSAGE =
        "Numero massimo di tentativi raggiunto, "
        + "per maggiori informazioni digitare /help";

    /**
     * Error message used when user enters
     * an attempt that contains some characters
     * that are not letters.
     */
    private static final String WIN_MESSAGE =
        AnsiColors.getBrightGreen() + "Parola segreta indovinata, "
        + "complimenti! Numero tentativi : %d"
        + AnsiColors.getReset();

    public void showError(final Exception exception) {

        String errorMessage;

        if (exception instanceof MissingRunningGameException) {
            errorMessage = GAME_NOT_RUNNING_MESSAGE;
        } else if (exception instanceof ShortWordException) {
            errorMessage = SHORT_ATTEMPT_MESSAGE;
        } else if (exception instanceof LongWordException) {
            errorMessage = LONG_ATTEMPT_MESSAGE;
        } else if (exception instanceof InvalidWordException) {
            errorMessage = INVALID_ATTEMPT_MESSAGE;
        } else {
            throw new IllegalArgumentException();
        }

        System.out.println(new ErrorStringBuilder(errorMessage));
    }

    public void showEndAttemptsMessage() {
        System.out.println(new ErrorStringBuilder(END_ATTEMPTS_MESSAGE));
        System.out.println("\nLa parola segreta è: "
            + Game.getRunningGame().getSecretWord().toString());
    }

    public void showWinMessage() {
        System.out.println(String.format(WIN_MESSAGE,
            Game.getRunningGame().getCount()));
    }

}
