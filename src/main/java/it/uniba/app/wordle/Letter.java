package it.uniba.app.wordle;

import it.uniba.app.exception.InvalidLetterException;

import java.awt.*;

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
    private final char character;
    private final Color color;

    public Letter(final char ch, final Color c) throws InvalidLetterException {
        if (Character.isLetter(ch)) {
            this.character = ch;
            this.color = c;
        } else {
            throw new InvalidLetterException();
        }
    }

    public Letter(final char ch) throws InvalidLetterException {
        this(ch, null);
    }

    public char getCharacter() {
        return character;
    }

    public Color getColor() {
        return color;
    }

    public boolean equalsIgnoreCase(final char ch) {
        return Character.toLowerCase(getCharacter())
                == Character.toLowerCase(ch);
    }
}
