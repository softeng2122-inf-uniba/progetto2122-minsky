package it.uniba.app.command;

import it.uniba.app.exception.InvalidCommandException;

/**
 * <Control>
 * <p>
 * A {@code CommandParser} is able to identify {@code Command}s
 * entered in a {@code CommandLineShell}.
 *
 * @see Command
 * @see CommandLineShell
 */

public final class CommandParser {

    /**
     * It recognises the command contained in {@code commandString},
     * creating a new {@link Command} instance containing
     * the recognised command type and
     * any arguments specified for the recognised command.
     *
     * @param commandString string containing the command to be recognised.
     * @return a new {@link Command} instance containing
     *         the recognised command type and
     *         any arguments specified for the recognised command.
     * @throws InvalidCommandException if {@code commandString} contains
     *                                 a non-existent command.
     */
    public Command parse(final String commandString)
            throws InvalidCommandException {

        String cmdString = commandString.trim().toLowerCase();

        String[] prefixAndArgs = cmdString.split("\\s+", 2);
        String prefix = prefixAndArgs[0];
        String[] args = (prefixAndArgs.length >= 2
                ? prefixAndArgs[1].split("\\s+")
                : new String[0]);

        if (prefix.startsWith("/")) {
            return new Command(CommandType.fromLabel(prefix), args);
        } else {
            return new Command(CommandType.ATTEMPT, prefixAndArgs);
        }
    }
}
