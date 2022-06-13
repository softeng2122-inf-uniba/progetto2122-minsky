package it.uniba.app.command;

import it.uniba.app.exception.InvalidCommandException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandParserTest {

    @Test
    @DisplayName("This test check if the method <parse> of "
            + "CommandParser are correctly implemented.")
    void parse() {
       try {
           CommandParser parser = new CommandParser();
           String[] commands = {"/nuova", "/mostra", "/help", "/gioca",
                   "/abbandona", "/esci"};
           CommandType[] commandlist = {CommandType.NUOVA, CommandType.MOSTRA,
                   CommandType.HELP, CommandType.GIOCA,
                   CommandType.ABBANDONA, CommandType.ESCI};
           String attempt = "prova";
           int i;
           for (i = 0; i < commands.length; i++) {
               Command command2 = parser.parse(commands[i]);
               assertEquals(commandlist[i], command2.getCommandType());
           }
           Command command3 = parser.parse(attempt);
           assertEquals(CommandType.ATTEMPT, command3.getCommandType());
       } catch (InvalidCommandException e) {
           System.out.println("Eccezione");
       }
    }
}
