package it.uniba.app.controller;

import it.uniba.app.exception.InvalidConfirmationException;
import it.uniba.app.utility.ConfirmationRequest;

import java.io.IOException;

/**
 * <Control>
 * <p>
 * This class is responsible for shutting down the application.
 */

public class ExitGame implements Controller  {

    /**
     * Instance of {@code ConfirmationRequest}
     * used to request an exit confirmation.
     */
    private ConfirmationRequest exitConfirmation = new ConfirmationRequest();

    /**
     * Method used to handle the shutdown
     * of the application using {@link #exitConfirmation}.
     * @param args
     */
    public void control(final String[] args) {
        exitConfirmation.showExitMessage();
        try {
            if (exitConfirmation.askUserConfirmation()) {
                Runtime.getRuntime().exit(0);
            }
        } catch (IOException | InvalidConfirmationException ex) {
            exitConfirmation.showInputError();
        }

    }

}
