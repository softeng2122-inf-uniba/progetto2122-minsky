package it.uniba.app.command;

import it.uniba.app.controller.*;

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

    NUOVA(SecretWordSelectionController.class),
    MOSTRA(ShowSecretWord.class),
    HELP(HelpController.class),
    GIOCA(StartGameController.class),
    ABBANDONA(AbortGameController.class),
    ESCI(ExitGame.class),
    ATTEMPT(AttemptController.class);

    private final Class<? extends Controller> controllerClass;

    CommandType(final Class<? extends Controller> controllerClass) {
        this.controllerClass = controllerClass;
    }

    public Class<? extends Controller> getControllerClass() {
        return controllerClass;
    }
}
