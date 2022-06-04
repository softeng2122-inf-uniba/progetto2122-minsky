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

    private static final String OK_MESSAGE = AnsiColors.getBrightGreen() + "[OK] Parola segreta impostata con successo!" + AnsiColors.getReset();
    private static final String MISSING_WORD_MESSAGE =
            new ErrorStringBuilder("Non hai specificato alcuna parola.").toString();
    private static final String RUNNING_GAME_MESSAGE =
            new ErrorStringBuilder("Non è possibile modificare la parola segreta durante una partita.").toString();
    private static final String SHORT_WORD_MESSAGE =
            new ErrorStringBuilder("Parola segreta troppo corta (deve essere di %d lettere).").toString();
    private static final String LONG_WORD_MESSAGE =
            new ErrorStringBuilder("Parola segreta troppo lunga (deve essere di %d lettere).").toString();
    private static final String INVALID_WORD_MESSAGE =
            new ErrorStringBuilder("Parola segreta non valida (non conteneva solo lettere dell'alfabeto).").toString();

    public void showOK() {
        System.out.println(OK_MESSAGE);
    }

    public void showMissingWordError() {
        System.out.println(MISSING_WORD_MESSAGE);
    }

    public void showRunningGameError() {
        System.out.println(RUNNING_GAME_MESSAGE);
    }

    public void showShortWordError(final int correctLength) {
        if (correctLength >= 2) {
            System.out.format(SHORT_WORD_MESSAGE, correctLength);
            System.out.println();
        } else {
            throw new IllegalArgumentException("length is less than 2");
        }
    }

    public void showLongWordError(final int correctLength) {
        if (correctLength >= 2) {
            System.out.format(LONG_WORD_MESSAGE, correctLength);
            System.out.println();
        } else {
            throw new IllegalArgumentException("length is less than 2");
        }
    }

    public void showInvalidWordError() {
        System.out.println(INVALID_WORD_MESSAGE);
    }
}
