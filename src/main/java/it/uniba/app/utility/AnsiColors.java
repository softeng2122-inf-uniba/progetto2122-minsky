package it.uniba.app.utility;

/**
 * <noECB>
 * <p>
 * This class contains the colour definitions used for the CLI.
 */


public class AnsiColors {

    private static final String ANSI_BRIGHT_GREEN = "\u001b[32;1m";
    private static final String ANSI_BRIGHT_RED = "\u001b[31;1m";

    private static final String ANSI_BACKGROUND_BRIGHT_GREEN = "\u001b[42;1m";
    private static final String ANSI_BACKGROUND_BRIGHT_YELLOW = "\u001b[43;1m";
    private static final String ANSI_BACKGROUND_BRIGHT_GRAY = "\u001b[47;1m";

    private static final String ANSI_RESET = "\u001B[0m";

    public static String getBrightRed() {
        return ANSI_BRIGHT_RED;
    }

    public static String getBrightGreen() {
        return ANSI_BRIGHT_GREEN;
    }

    public static String getReset() {
        return ANSI_RESET;
    }

    public static String makeBackgroundGreen(char c) {
        return ANSI_BACKGROUND_BRIGHT_GREEN + " " + c + " " + ANSI_RESET;
    }

    public static String makeBackgroundYellow(char c) {
        return ANSI_BACKGROUND_BRIGHT_YELLOW + " " + c + " " + ANSI_RESET;
    }

    public static String makeBackgroundGray(char c) {
        return ANSI_BACKGROUND_BRIGHT_GRAY + " " + c + " " + ANSI_RESET;
    }

}
