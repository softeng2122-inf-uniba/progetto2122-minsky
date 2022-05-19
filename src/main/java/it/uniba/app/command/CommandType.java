package it.uniba.app.command;

<<<<<<< HEAD
import it.uniba.app.controller.Controller;
import it.uniba.app.controller.ExitGame;
import it.uniba.app.controller.InizioPartitaController;
import it.uniba.app.controller.HelpController;
import it.uniba.app.controller.SelezioneParolaSegretaController;
import it.uniba.app.controller.attemptController;
=======

import it.uniba.app.controller.*;

>>>>>>> master

/**
 * Contiene tutti i tipi di comando riconoscibili da un CommandParser.
 */

public enum CommandType {
    // TODO: Aggiungere per ogni comando la classe <control> associata

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
