package it.uniba.app.utility;

import it.uniba.app.utility.AnsiColors;

/**
 * <noECB>
 * <p>
 * Realizza stringhe rappresentanti errori.
 */

public final class ErrorStringBuilder {
    private static final String ERROR_STRING_PREFIX = AnsiColors.getBrightRed() + "[ERRORE] ";
    private static final String ERROR_STRING_SUFFIX = AnsiColors.getReset();

    private final StringBuilder stringBuilder = new StringBuilder(ERROR_STRING_PREFIX + ERROR_STRING_SUFFIX);

    public ErrorStringBuilder() {
    }

    public ErrorStringBuilder(final String str) {
        this();

        stringBuilder.insert(ERROR_STRING_PREFIX.length(), str);
    }

    public void append(final String str) {
        stringBuilder.insert(stringBuilder.length() - ERROR_STRING_SUFFIX.length(), str);
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
