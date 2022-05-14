package it.uniba.app.command;

import java.util.HashMap;
import java.util.Map;

/**
 * <Control>
 * <p>
 * Riconosce i comandi inseriti dall'utente in una CommandLineShell.
 */

public final class CommandParser {
    private final Map<String, CommandType> commandsStrings = new HashMap<>();

    public Command parse(String commandString) {
        commandString = commandString.trim().toLowerCase();

        String[] prefixAndArgs = commandString.split("\\s+", 2);
        String prefix = prefixAndArgs[0];
        String[] args = (prefixAndArgs.length >= 2
                ? prefixAndArgs[1].split("\\s+")
                : new String[0]);

        if (prefix.startsWith("/")) {
            return new Command(commandsStrings.get(prefix), args);
        } else {
            // TODO: return new Command(CommandType.TENTA, prefix);
            return new Command(null, args);
        }
    }

    public void addCommand(final String commandString, final CommandType commandType) {
        commandsStrings.put(commandString, commandType);
    }
}
