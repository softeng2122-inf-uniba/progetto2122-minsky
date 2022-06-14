package it.uniba.app.command;

import it.uniba.app.controller.AbortGameController;
import it.uniba.app.controller.Controller;
import it.uniba.app.controller.ExitGameController;
import it.uniba.app.controller.HelpController;
import it.uniba.app.controller.SecretWordSelectionController;
import it.uniba.app.controller.ShowSecretWordController;
import it.uniba.app.controller.StartGameController;
import it.uniba.app.controller.AttemptController;

/**
 * <noECB>
 * <p>
 * This enum provides all {@code CommandType}s
 * that a {@code CommandParser} can identify.
 * <p>
 * Each {@code CommandType} is provided with a class
 * implementing the {@code Controller} interface.
 *
 * @see CommandParser
 * @see Controller
 */

public enum CommandType {

    /** Command to select a new {@link it.uniba.app.wordle.SecretWord}. */
    NUOVA("/nuova", SecretWordSelectionController.class),

    /**
     * Command to show the current {@link it.uniba.app.wordle.SecretWord}.
     *
     * @see it.uniba.app.wordle.SecretWord#getCurrentSecretWord()
     */
    MOSTRA("/mostra", ShowSecretWordController.class),

    /** Command to show help message. */
    HELP("/help", HelpController.class),

    /**
     * Command to start a new Wordle {@link it.uniba.app.wordle.Game}.
     *
     * @see it.uniba.app.wordle.Game#startNewGame()
     */
    GIOCA("/gioca", StartGameController.class),

    /**
     * Command to abort the running Wordle {@link it.uniba.app.wordle.Game}.
     *
     * @see it.uniba.app.wordle.Game#abortRunningGame()
     */
    ABBANDONA("/abbandona", AbortGameController.class),

    /** Command to exit the application. */
    ESCI("/esci", ExitGameController.class),

    /**
     * This command type is recognised whenever
     * the user enters a game attempt.
     */
    ATTEMPT(null, AttemptController.class);

    /** Label corresponding to this {@link CommandType}. */
    private final String label;

    /** Controller class responsible to execute this {@link CommandType}. */
    private final Class<? extends Controller> controllerClass;

    CommandType(final String commandLabel,
                final Class<? extends Controller> commandControllerClass) {
        this.label = commandLabel;
        this.controllerClass = commandControllerClass;
    }

    /**
     * Returns the {@link CommandType} having {@code commandLabel} as label,
     * or {@code null}
     * if {@code commandLabel} does not match any known {@link CommandType}.
     *
     * @param commandLabel {@link String} containing the label
     *                     corresponding to the {@link CommandType} returned.
     *
     * @return {@link CommandType} corresponding to the specified label.
     */
    public static CommandType fromLabel(final String commandLabel) {
        for (CommandType commandType : CommandType.values()) {
            if (commandType.label != null
                    && commandType.label.equalsIgnoreCase(commandLabel)) {
                return commandType;
            }
        }

        return null;
    }

    /**
     * Returns the {@link Controller} class
     * responsible to execute this {@link CommandType}.
     *
     * @return {@link Controller} class
     *         responsible to execute this {@link CommandType}.
     */
    public Class<? extends Controller> getControllerClass() {
        return controllerClass;
    }
}
