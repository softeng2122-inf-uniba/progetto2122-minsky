package it.uniba.app.utility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

class ErrorStringBuilderTest {

    /**
     * Prefix of error string messages.
     */
    private static String prefix;

    /**
     * Suffix of error string messages.
     */
    private static String suffix;

    @BeforeAll
    static void beforeAll()
            throws NoSuchFieldException, IllegalAccessException {
        final Field prefixField = ErrorStringBuilder.class
                .getDeclaredField("ERROR_STRING_PREFIX");
        final Field suffixField = ErrorStringBuilder.class
                .getDeclaredField("ERROR_STRING_SUFFIX");

        prefixField.setAccessible(true);
        suffixField.setAccessible(true);

        prefix = (String) prefixField.get(null);
        suffix = (String) suffixField.get(null);
    }

    @Test
    void emptyConstructorTest() {
        Assertions.assertEquals(
                prefix + suffix, new ErrorStringBuilder().toString());
    }
}
