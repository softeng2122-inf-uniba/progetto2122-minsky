package it.uniba.app.command;

import it.uniba.app.controller.Controller;
import it.uniba.app.controller.ExitGame;

/**
 * Contiene tutti i tipi di comando riconoscibili da un CommandParser.
 */

public enum CommandType {
    // TODO: Aggiungere per ogni comando la classe <control> associata
    NUOVA(null),
    MOSTRA(null),
    HELP(null),
    GIOCA(null),
    ABBANDONA(null),
    ESCI(ExitGame.class),
    TENTA(null);

    private final Class<? extends Controller> controllerClass;

    CommandType(final Class<? extends Controller> controllerClass) {
        this.controllerClass = controllerClass;
    }

    public Class<? extends Controller> getControllerClass() {
        return controllerClass;
    }
}
