package it.uniba.app.utility;

/**
 * <noECB>
 * <p>
 * Realizza stringhe rappresentanti errori.
 */

public final class ErrorStringBuilder {
    private static final String ANSI_RED = "\u001b[31;1m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ERROR_STRING_PREFIX = ANSI_RED + "[ERRORE] ";
    private static final String ERROR_STRING_SUFFIX = ANSI_RESET;

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
