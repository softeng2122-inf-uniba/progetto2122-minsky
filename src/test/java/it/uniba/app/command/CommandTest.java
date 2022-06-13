package it.uniba.app.command;

import it.uniba.app.exception.InvalidCommandException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class CommandTest {
    @Test
    @DisplayName("This test check if the Command methods are correctly "
            + "implemented")
    void getCommandType() {
        String[] commands = {"/nuova", "/mostra", "/help", "/gioca",
                "/abbandona", "/esci"};
        CommandType[] commandlist = CommandType.values();
        int i;
        try {
            for (i = 0; i < commands.length; i++) {
                Command command1 = new Command(commandlist[i], commands);
                assertSame(commands.getClass(),
                        command1.getArguments().getClass());
                assertEquals(commandlist[i], command1.getCommandType());

            }
        } catch (InvalidCommandException e) {
            System.out.println("comando non valido");
        }
    }
}
