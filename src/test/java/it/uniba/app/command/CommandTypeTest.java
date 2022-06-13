package it.uniba.app.command;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CommandTypeTest {
    @Test
    @DisplayName("This test check if the CommandType enum "
            + "is correctly implemented.")
    void fromLabel() {
        String[] commands = {"/nuova", "/mostra", "/help", "/gioca",
                "/abbandona", "/esci"};
        CommandType[] commandlist = {CommandType.NUOVA, CommandType.MOSTRA,
                CommandType.HELP, CommandType.GIOCA, CommandType.ABBANDONA,
                CommandType.ESCI, CommandType.ATTEMPT};
        int i;
        for (i = 0; i < commands.length; i++) {
            assertEquals(commandlist[i], CommandType.fromLabel(commands[i]));
        }
        String attempt = "prova";
        assertNull(CommandType.fromLabel(attempt));
    }
}
