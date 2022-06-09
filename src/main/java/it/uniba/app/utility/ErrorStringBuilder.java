package it.uniba.app.utility;

/**
 * <noECB>
 * <p>
 * An {@code ErrorStringBuilder} is used
 * to create error message strings for CLI.
 */

public final class ErrorStringBuilder {

    /**
     * Prefix for error message strings displayed on CLI.
     */
    private static final String ERROR_STRING_PREFIX =
            AnsiColors.getBrightRed() + "[ERRORE] ";

    /**
     * Suffix for error message strings displayed on CLI.
     */
    private static final String ERROR_STRING_SUFFIX = AnsiColors.getReset();

    /**
     * {@link StringBuilder} instance used to create error message string.
     */
    private final StringBuilder stringBuilder =
            new StringBuilder(ERROR_STRING_PREFIX + ERROR_STRING_SUFFIX);

    /**
     * Constructs an {@link ErrorStringBuilder} with no characters in it.
     */
    public ErrorStringBuilder() {
    }


    /**
     * Constructs an {@link ErrorStringBuilder} initialized
     * to the contents of the specified string.
     *
     * @param str the initial contents of the buffer.
     */
    public ErrorStringBuilder(final String str) {
        this();

        append(str);
    }

    /**
     * Appends the specified string to this character sequence.
     * <p>
     * The characters of the {@code String} argument are appended, in
     * order, increasing the length of this sequence by the length of the
     * argument.
     *
     * @param str a string.
     */
    public void append(final String str) {
        stringBuilder.insert(
                stringBuilder.length() - ERROR_STRING_SUFFIX.length(), str);
    }


    /**
     * Returns a string containing the characters in this sequence
     * in the same order as this sequence.
     * <p>
     * The length of the string will be the length of this sequence.
     *
     * @return a string consisting of exactly this sequence of characters
     */
    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
