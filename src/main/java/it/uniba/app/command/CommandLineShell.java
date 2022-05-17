package it.uniba.app.command;

import it.uniba.app.controller.Controller;
import it.uniba.app.controller.HelpController;
import it.uniba.app.exception.FlagException;
import it.uniba.app.exception.InvalidCommandException;

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
    private static final String WELCOME_MESSAGE = "\n\n ================================ Benvenuto su Wordle! ================================ \n\n";
    private static final String UNKNOWN_COMMAND_MESSAGE = "[ERRORE] Comando inesistente.";
    private static final String INPUT_PREFIX = "wordle:> ";
    private static final String EXIT_MESSAGE = "/esci";
    private static final String HELP_MESSAGE = "/help";
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

        try {
            if (HelpController.checkFlagOnStart(args)) {

                HelpController helpController = new HelpController();
                helpController.control(args);

            } else {
                System.out.println(HELP_TIP);
            }
        } catch (FlagException fe) {

            System.out.println(fe.showMessage());
            System.exit(0);
        }
    }

    private void runREPL() {
        try {
            do {
                System.out.println();
                System.out.print(INPUT_PREFIX);

                String commandString = commandLineInputStream.readLine();
                System.out.println();

                try {
                    Command command = commandParser.parse(commandString);

                    Controller controller = command.getCommandType().getControllerClass().getConstructor()
                            .newInstance();
                    controller.control(command.getArgs());
                } catch (InvalidCommandException exception) {
                    System.out.println(UNKNOWN_COMMAND_MESSAGE);
                    System.out.println(HELP_TIP);
                }
            } while (true);
        } catch (Exception ignored) {
        }
    }

    private void registerCommands() {
        // TODO Aggiungere ogni nuovo comando con: commandParser.addCommand();
        commandParser.addCommand("/nuova", CommandType.NUOVA);
        commandParser.addCommand(EXIT_MESSAGE, CommandType.ESCI);
        commandParser.addCommand(HELP_MESSAGE, CommandType.HELP);
    }
}
