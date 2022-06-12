package it.uniba.app;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.app.controller.HelpController;
public class TestHelpController {
    /**
     * Test the method {@link HelpController#checkFlagOnStart(String[])}.
     */
    @Test
    @DisplayName("Test if the application is invoked with the correct flags.")
    public void testCheckFlagOnStart() {
        String[] args = {"-h", "--help"};
        boolean helpFlag = false;
        try {
            helpFlag = HelpController.checkFlagOnStart(args);
            assertTrue(helpFlag, "The flag is correct");
            assertFalse(!helpFlag, "The flag is incorrect");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
