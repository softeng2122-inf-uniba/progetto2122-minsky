package it.uniba.app.command;

import it.uniba.app.exception.InvalidCommandException;

/**
 * <noECB>
 * <p>
 * The {@code Command} class is used to represent
 * any command entered in a {@code CommandLineShell} and
 * recognised by a {@code CommandParser}.
 *
 * @see CommandLineShell
 * @see CommandParser
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
