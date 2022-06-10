package it.uniba.app.utility;

import it.uniba.app.wordle.AttemptWord;
import it.uniba.app.wordle.Letter;

import java.awt.Color;

/**
 * <noECB>
 * <p>
 * This class contains the color definitions used for the CLI.
 */

public final class AnsiColors {

    /** Bright green color ANSI sequence for characters foreground in CLI. */
    public static final String ANSI_BRIGHT_GREEN = "\u001b[32;1m";

    /** Bright red color ANSI sequence for characters foreground in CLI. */
    public static final String ANSI_BRIGHT_RED = "\u001b[31;1m";

    /** Bright green color ANSI sequence for characters background in CLI. */
    public static final String ANSI_BACKGROUND_BRIGHT_GREEN = "\u001b[42;1m";

    /** Bright yellow color ANSI sequence for characters background in CLI. */
    public static final String ANSI_BACKGROUND_BRIGHT_YELLOW = "\u001b[43;1m";

    /** Bright gray color ANSI sequence for characters background in CLI. */
    public static final String ANSI_BACKGROUND_BRIGHT_GRAY = "\u001b[47;1m";

    /**
     * ANSI sequence that disables all attributes
     * applied from previous ANSI sequences.
     */
    public static final String ANSI_RESET = "\u001B[0m";

    private AnsiColors() {
    }

    /**
     * Returns bright red color ANSI sequence for char foreground in CLI.
     *
     * @return foreground bright red color ANSI sequence
     */
    public static String getBrightRed() {
        return ANSI_BRIGHT_RED;
    }

    /**
     * Returns bright green color ANSI sequence for char foreground in CLI.
     *
     * @return foreground bright green color ANSI sequence
     */
    public static String getBrightGreen() {
        return ANSI_BRIGHT_GREEN;
    }

    /**
     * Returns ANSI sequence that disables all attributes
     * applied from previous ANSI sequences.
     *
     * @return Reset ANSI sequence
     */
    public static String getReset() {
        return ANSI_RESET;
    }

    private static String makeBackgroundGreen(final char letter) {
        return ANSI_BACKGROUND_BRIGHT_GREEN + " " + letter + " " + ANSI_RESET;
    }

    private static String makeBackgroundYellow(final char letter) {
        return ANSI_BACKGROUND_BRIGHT_YELLOW + " " + letter + " " + ANSI_RESET;
    }

    private static String makeBackgroundGray(final char letter) {
        return ANSI_BACKGROUND_BRIGHT_GRAY + " " + letter + " " + ANSI_RESET;
    }

    /**
     * Method used to convert the attempt word that will be converted.
     * @param attemptWord the attempt that will be converted
     * @return colored attempt word
     */

    public static String convertAttemptWordToGridRow(
            final AttemptWord attemptWord) {
        StringBuilder stringBuilder = new StringBuilder("│");

        for (Letter letter : attemptWord.getLetters()) {

            if (letter.getColor().equals(Color.GREEN)) {
                stringBuilder.append(makeBackgroundGreen(letter
                    .getCharacter()) + "│");
            } else if (letter.getColor().equals(Color.YELLOW)) {
                stringBuilder.append(makeBackgroundYellow(letter
                    .getCharacter()) + "│");
            } else if (letter.getColor().equals(Color.GRAY)) {
                stringBuilder.append(makeBackgroundGray(letter
                    .getCharacter()) + "│");
            }
        }

        return stringBuilder.toString();
    }

}
