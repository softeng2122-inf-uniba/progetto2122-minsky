package it.uniba.app.wordle;

import it.uniba.app.exception.InvalidLetterException;

import java.awt.Color;

/**
 * <Entity>
 * <p>
 * Every {@code Letter} is characterized by:
 * <ul>
 *     <li>an alphabetic character;
 *     <li>a color.
 * </ul>
 */

public final class Letter {

    /**
     * Alphabetical character contained in this letter.
     */
    private final char character;
    /**
     * Background color of this letter.
     */
    private final Color color;

    /**
     * Constructs a new letter with the given character and color.
     *
     * @param ch an alphabetical character
     * @param c background color for this new letter.
     * @throws InvalidLetterException if {@code ch} is not alphabetical.
     */
    public Letter(final char ch, final Color c) throws InvalidLetterException {
        if (Character.isLetter(ch)) {
            this.character = ch;
            this.color = c;
        } else {
            throw new InvalidLetterException();
        }
    }

    /**
     * Returns the alphabetical character contained in this letter.
     *
     * @return alphabetical character contained in this letter
     */
    public char getCharacter() {
        return character;
    }

    /**
     * Retruns the background color of this letter.
     *
     * @return background color of this letter
     */
    public Color getColor() {
        return color;
    }
}
