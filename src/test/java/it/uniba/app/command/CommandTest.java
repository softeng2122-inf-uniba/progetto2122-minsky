package it.uniba.app.command;

import it.uniba.app.exception.InvalidCommandException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class CommandTest {
    @Test
    @DisplayName("This test check if the getCommandType "
            + "method is correctly implemented")
    void getCommandType() {
        String[] commands = {"/nuova", "/mostra", "/help", "/gioca",
                "/abbandona", "/esci", "prova"};
        CommandType[] commandlist = CommandType.values();
        int i;
        try {
            for (i = 0; i < commands.length; i++) {
                Command command1 = new Command(commandlist[i], commands);
                assertEquals(commandlist[i], command1.getCommandType());
            }
        } catch (InvalidCommandException e) {
            System.out.println("comando non valido");
        }
    }
    @Test
    @DisplayName("This test check if the getArguments method"
            + "is correctly implemented.")
    void getArguments() {
        String[] commands = {"/nuova", "/mostra", "/help", "/gioca",
                "/abbandona", "/esci", "prova"};
        CommandType[] commandlist = CommandType.values();
        int i;
        try {
            for (i = 0; i < commands.length; i++) {
                Command command5 = new Command(commandlist[i], commands);
                assertSame(commands.getClass(),
                        command5.getArguments().getClass());
            }
        } catch (InvalidCommandException e) {
            System.out.println("comando non valido");
        }
    }
}
