package it.uniba.app.ui;

import it.uniba.app.command.Command;
import it.uniba.app.command.CommandParser;
import it.uniba.app.controller.Controller;
import it.uniba.app.controller.HelpController;
import it.uniba.app.exception.FlagException;
import it.uniba.app.exception.InvalidCommandException;
import it.uniba.app.utility.ErrorStringBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * <Boundary>
 * <p>
 * Accepts commands from the user in a CLI,
 * performing a REPL (Read, Eval, Print Loop).
 */

public final class CommandLineShell {

    /**
     * Welcome message displayed on application start-up.
     */
    private static final String WELCOME_MESSAGE =
            "\n\n ================================ "
                    + "Benvenuto su Wordle! "
                    + "================================ \n\n";

    /**
     * Message suggesting how to view the list of available commands.
     */
    private static final String HELP_TIP =
            "[TIP] Usa /help per visualizzare la lista dei comandi disponibili";

    /**
     * Prefix displayed before each command request or attempt.
     */
    private static final String INPUT_PREFIX = "wordle:> ";

    /**
     * Message shown when the user enters a non-existent command.
     */
    private static final String UNKNOWN_COMMAND_MESSAGE = "Comando inesistente";

    /**
     * Message shown when an unexpected error occurs
     * during application execution.
     */
    private static final String UNEXPECTED_ERROR_MESSAGE =
            "Si è verificato un errore inaspettato. "
                    + "Comunicare al team di sviluppo il seguente testo:\n";

    /**
     * Responsible for the recognition of commands
     * in this {@code CommandLineShell}.
     */
    private final CommandParser commandParser = new CommandParser();

    /**
     * Input stream from Command Line Interface.
     */
    private final BufferedReader commandLineInputStream = new BufferedReader(
            new InputStreamReader(System.in, StandardCharsets.UTF_8));


    /**
     * Used to display unexpected errors during normal application execution.
     *
     * @param e exception containing information on the unexpected error.
     */
    public static void showUnexpectedError(final Exception e) {
        System.out.println(new ErrorStringBuilder(UNEXPECTED_ERROR_MESSAGE));
        e.printStackTrace();
    }

    /**
     * This method triggers the execution of this shell,
     * initiating a start-up procedure followed by the Read, Eval, Print loop.
     *
     * @param args arguments passed to the application.
     */
    public void execute(final String[] args) {
        start(args);

        runREPL();
    }

    /**
     * Executes the shell's start-up procedure,
     * which consists of displaying start-up messages
     * and interpreting any arguments provided at application start-up.
     *
     * @param args arguments provided at application start-up
     */
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
            Runtime.getRuntime().exit(0);
        }
    }

    /**
     * Read, Eval, Print loop of this shell.
     * It asks for input of a command or an attempt, recognises it
     * and passes control to the responsible Controller class.
     *
     * @see Controller
     */
    private void runREPL() {
        do {
            try {
                Command command = inputCommand();

                Controller controller = createController(command);

                controller.control(command.getArguments());
            } catch (InvalidCommandException e) {
                System.out.println(
                        new ErrorStringBuilder(UNKNOWN_COMMAND_MESSAGE));

                System.out.println(HELP_TIP);
            } catch (IOException | ReflectiveOperationException e) {
                showUnexpectedError(e);
            }
        }
        while (true);
    }

    private Command inputCommand()
            throws InvalidCommandException, IOException {

        System.out.println();
        System.out.print(INPUT_PREFIX);

        String commandString = commandLineInputStream.readLine();

        System.out.println();

        if (commandString != null) {
            return commandParser.parse(commandString);
        } else {
            throw new NullPointerException("end of stream has been reached.");
        }
    }

    private Controller createController(final Command command)
            throws ReflectiveOperationException {

        return command.getCommandType().getControllerClass()
                .getConstructor().newInstance();
    }
}
