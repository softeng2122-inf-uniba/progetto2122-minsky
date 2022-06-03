package it.uniba.app.command;

import it.uniba.app.exception.InvalidCommandException;

import java.util.HashMap;
import java.util.Map;

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
    private final Map<String, CommandType> commandsStrings = new HashMap<>();

    public Command parse(String commandString) throws InvalidCommandException {
        commandString = commandString.trim().toLowerCase();

        String[] prefixAndArgs = commandString.split("\\s+", 2);
        String prefix = prefixAndArgs[0];
        String[] args = (prefixAndArgs.length >= 2
                ? prefixAndArgs[1].split("\\s+")
                : new String[0]);

        if (prefix.startsWith("/")) {
            return new Command(commandsStrings.get(prefix), args);
        } else {

            return new Command(CommandType.ATTEMPT, prefixAndArgs);
        }
    }

    public void addCommand(final String commandString, final CommandType commandType) {
        commandsStrings.put(commandString, commandType);
    }
}