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

    /** The type of this command. */
    private final CommandType commandType;

    /** The arguments of this command. */
    private final String[] arguments;


    /**
     * Creates a new command with {@code cmdType} as type
     * and {@code args} as arguments.
     *
     * @param cmdType the type of the new command.
     * @param args the arguments of the new command.
     * @throws InvalidCommandException if cmdType is {@code null}.
     */
    public Command(final CommandType cmdType, final String[] args)
            throws InvalidCommandException {

        if (cmdType != null) {
            this.commandType = cmdType;
        } else {
            throw new InvalidCommandException();
        }

        if (args == null) {
            this.arguments = new String[0];
        } else {
            this.arguments = args.clone();
        }
    }

    /**
     * Returns the type of this command.
     *
     * @return the type of this command
     */
    public CommandType getCommandType() {
        return commandType;
    }

    /**
     * Returns the arguments of this command.
     *
     * @return the arguments of this command
     */
    public String[] getArguments() {
        return arguments.clone();
    }
}
