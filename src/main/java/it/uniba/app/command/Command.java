package it.uniba.app.command;

import it.uniba.app.exception.InvalidCommandException;

/**
 * <noECB>
 * <p>
 * Rappresenta un comando inserito dall'utente in una
 * CommandLineShell e riconosciuto da un CommandParser.
 */

public final class Command {
    private final CommandType commandType;
    private final String[] args;

    public Command(final CommandType commandType, final String[] args) throws InvalidCommandException {
        if (commandType != null) this.commandType = commandType;
        else throw new InvalidCommandException();

        if (args == null) this.args = new String[0];
        else this.args = args;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public String[] getArgs() {
        return args;
    }
}
