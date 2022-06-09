package it.uniba.app.utility;

import it.uniba.app.wordle.AttemptWord;
import it.uniba.app.wordle.Letter;

import java.awt.Color;

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

    private static String makeBackgroundGreen(char letter) {
        return ANSI_BACKGROUND_BRIGHT_GREEN + " " + letter + " " + ANSI_RESET;
    }

    private static String makeBackgroundYellow(char letter) {
        return ANSI_BACKGROUND_BRIGHT_YELLOW + " " + letter + " " + ANSI_RESET;
    }

    private static String makeBackgroundGray(char letter) {
        return ANSI_BACKGROUND_BRIGHT_GRAY + " " + letter + " " + ANSI_RESET;
    }

    public static String convertAttemptWordToGridRow(AttemptWord attemptWord)
    {
        StringBuilder stringBuilder = new StringBuilder("│");

        for(Letter letter : attemptWord.getLetters())
        {
            if (letter.getColor().equals(Color.GREEN))
            {
                stringBuilder.append(makeBackgroundGreen(letter.getCharacter()) + "│");
            }
            else if (letter.getColor().equals(Color.YELLOW))
            {
                stringBuilder.append(makeBackgroundYellow(letter.getCharacter()) + "│");
            }
            else if (letter.getColor().equals(Color.GRAY))
            {
                stringBuilder.append(makeBackgroundGray(letter.getCharacter()) + "│");
            }
        }

        return stringBuilder.toString();
    }

}
