package it.uniba.app.command;

import it.uniba.app.controller.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * <Boundary>
 * <p>
 * Acquisisce dall'utente i comandi attraverso una CLI,
 * realizzando un REPL (Read, Eval, Print Loop).
 */

public final class CommandLineShell {
    private static final String HELP_TIP = "[TIP] Usa /help per visualizzare la lista dei comandi disponibili.";
    private static final String WELCOME_MESSAGE = "Benvenuto su Wordle!";
    private static final String UNKNOWN_COMMAND_MESSAGE = "[ERRORE] Comando inesistente.";
    private static final String INPUT_PREFIX = "wordle:> ";
    private final CommandParser commandParser = new CommandParser();
    private final BufferedReader commandLineInputStream = new BufferedReader(new InputStreamReader(System.in));

    public CommandLineShell() {
        registerCommands();
    }

    public void execute(final String[] args) {
        start(args);

        runREPL();
    }

    private void start(final String[] args) {
        System.out.println(WELCOME_MESSAGE);

        if (checkHelpOnStart(args)) {
            // TODO
        } else {
            System.out.println(HELP_TIP);
        }
    }

    private boolean checkHelpOnStart(final String[] args) {
        // TODO
        return false;
    }

    private void runREPL() {
        try {
            do {
                System.out.println();
                System.out.print(INPUT_PREFIX);

                String commandString = commandLineInputStream.readLine();
                System.out.println();

                Command command = commandParser.parse(commandString);

                if (command.getCommandType() != null) {
                    Controller controller = command.getCommandType().getControllerClass().getConstructor().newInstance();
                    controller.control(command.getArgs());
                } else {
                    System.out.println(UNKNOWN_COMMAND_MESSAGE);
                    System.out.println(HELP_TIP);
                }
            }
            while (true);
        } catch (Exception ignored) {
        }
    }

    private void registerCommands() {
        // TODO Aggiungere ogni nuovo comando con: commandParser.addCommand();
    }
}