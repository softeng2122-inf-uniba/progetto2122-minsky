package it.uniba.app.utility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Random;
import java.util.UUID;

class ErrorStringBuilderTest {

    /**
     * Used to generate a random integer in
     * {@link ErrorStringBuilderTest#appendTest()}.
     */
    private static final Random RANDOM = new Random();
    /**
     * Max amount of times {@link #appendTest()} can
     * use {@link ErrorStringBuilder#append(String)}.
     */
    private static final int MAX_APPEND_AMOUNT = 1000;
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

    @Test
    void stringParamConstructorTest() {
        final String randomString = UUID.randomUUID().toString();

        Assertions.assertEquals(prefix + randomString + suffix,
                new ErrorStringBuilder(randomString).toString());
    }

    @Test
    void appendTest() {
        final StringBuilder stringBuilder =
                new StringBuilder(UUID.randomUUID().toString());
        final int appendAmount = RANDOM.nextInt(MAX_APPEND_AMOUNT) + 1;
        final ErrorStringBuilder errorStringBuilder =
                new ErrorStringBuilder(stringBuilder.toString());

        for (int i = 0; i < appendAmount; i++) {
            final String randomString = UUID.randomUUID().toString();

            stringBuilder.append(randomString);
            errorStringBuilder.append(randomString);

            Assertions.assertEquals(prefix + stringBuilder + suffix,
                    errorStringBuilder.toString());
        }
    }

    @Test
    void toStringTest() {
        final String randomString = UUID.randomUUID().toString();

        Assertions.assertEquals(prefix + randomString + suffix,
                new ErrorStringBuilder(randomString).toString());
    }
}
