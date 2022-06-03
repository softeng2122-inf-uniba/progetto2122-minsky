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

    public Letter(final char character, final Color color) throws InvalidLetterException {
        if (Character.isLetter(character)) {
            this.character = character;
            this.color = color;
        } else {
            throw new InvalidLetterException();
        }
    }

    public Letter(final char character) throws InvalidLetterException {
        this(character, null);
    }

    public char getCharacter() {
        return character;
    }

    public Color getColor() {
        return color;
    }

    public boolean equalsIgnoreCaseAndColor(final Letter letter) {
        return Character.toLowerCase(getCharacter())
                == Character.toLowerCase(letter.getCharacter());
    }
}
