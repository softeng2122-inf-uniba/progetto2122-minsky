package it.uniba.app.command;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandTypeTest {

    @Test
    @DisplayName("This test check if the CommandType enum "
            + "is correctly implemented.")
    void testfromLabel() {
        String[] commands = {"/nuova", "/mostra", "/help", "/gioca",
                "/abbandona", "/esci"};
        CommandType[] commandlist = {CommandType.NUOVA, CommandType.MOSTRA,
                CommandType.HELP, CommandType.GIOCA, CommandType.ABBANDONA,
                CommandType.ESCI};
        int i;
        for (i = 0; i < commands.length; i++) {
            assertEquals(commandlist[i], CommandType.fromLabel(commands[i]));
        }
    }
}
