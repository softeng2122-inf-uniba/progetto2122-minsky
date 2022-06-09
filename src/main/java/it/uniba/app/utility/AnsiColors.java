package it.uniba.app.utility;

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

    public static String makeBackgroundGreen(final char c) {
        return ANSI_BACKGROUND_BRIGHT_GREEN + " " + c + " " + ANSI_RESET;
    }

    public static String makeBackgroundYellow(final char c) {
        return ANSI_BACKGROUND_BRIGHT_YELLOW + " " + c + " " + ANSI_RESET;
    }

    public static String makeBackgroundGray(final char c) {
        return ANSI_BACKGROUND_BRIGHT_GRAY + " " + c + " " + ANSI_RESET;
    }

}
