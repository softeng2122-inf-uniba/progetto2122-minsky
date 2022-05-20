package it.uniba.app.command;

import it.uniba.app.controller.*;

/**
 * Contiene tutti i tipi di comando riconoscibili da un CommandParser.
 */

public enum CommandType {

    NUOVA(SelezioneParolaSegretaController.class),
    MOSTRA(ShowMessage.class),
    HELP(HelpController.class),
    GIOCA(InizioPartitaController.class),
    ABBANDONA(AbbandonaPartitaController.class),
    ESCI(ExitGame.class),
    TENTA(attemptController.class);

    private final Class<? extends Controller> controllerClass;

    CommandType(final Class<? extends Controller> controllerClass) {
        this.controllerClass = controllerClass;
    }

    public Class<? extends Controller> getControllerClass() {
        return controllerClass;
    }
}
