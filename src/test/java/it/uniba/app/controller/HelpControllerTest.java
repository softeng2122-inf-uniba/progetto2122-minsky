package it.uniba.app.controller;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.app.exception.FlagException;

public class HelpControllerTest {
    /**
     * The flags that are expected.
     */
    private String[] args = {"-h", "--help"};
    /**
     * The controller that is tested.
     */
    private boolean helpFlag;
    /**
     * Method that set up the variables for the test.
     */
    @BeforeEach
    public void setup() {
        helpFlag = false;
        try {
            helpFlag = HelpController.checkFlagOnStart(args);
        } catch (FlagException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Test the method {@link HelpController#checkFlagOnStart(String[])}.
     */
    @Test
    @DisplayName("Test if the application is invoked with the correct flags.")
    public void testCheckFlagOnStart() {
        assertTrue(helpFlag, "The flag is correct");
        assertFalse(!helpFlag, "The flag is incorrect");
    }
}
