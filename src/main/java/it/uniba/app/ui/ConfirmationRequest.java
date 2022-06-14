package it.uniba.app.ui;

import it.uniba.app.exception.InvalidConfirmationException;
import it.uniba.app.utility.ErrorStringBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * <Boundary>
 * <p>
 * A {@code ConfirmationRequest} is used to ask the user for confirmation
 * before performing a particularly important
 * (typically non-reversible) operation.
 */

public final class ConfirmationRequest {

    /** String used in {@link #showExitMessage}. */
    private static final String EXIT_MESSAGE =
        "Sei sicuro di voler uscire da Wordle?";

    /** String used in {@link #showInputError}. */
    private static final String INPUT_ERROR =
        "Errore nell'input";


    /**
     * Asks the user for confirmation before performing an operation.
     *
     * @return {@code true} if the user accepted the confirmation request;
     * {@code false} if the user declined the confirmation request.
     * @throws IOException                  if an I/O error occurs;
     * @throws InvalidConfirmationException If the user did not answer correctly
     *                                      to this request.
     */
    public boolean askUserConfirmation()
        throws IOException, InvalidConfirmationException {

        System.out.print("[y/n]: ");

        BufferedReader commandLineInputStream = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String answer = commandLineInputStream.readLine();
        if (answer != null) {
            answer = answer.trim();

            if (answer.equalsIgnoreCase("y")
                    || answer.equalsIgnoreCase("yes")
                    || answer.equalsIgnoreCase("si")) {
                return true;
            } else if (answer.equalsIgnoreCase("n")
                    || answer.equalsIgnoreCase("no")) {
                return false;
            } else {
                throw new InvalidConfirmationException();
            }
        } else {
            throw new NullPointerException();
        }

    }

    /** Method used to display the exit confirmation message. */
    public void showExitMessage() {

        System.out.println(EXIT_MESSAGE);

    }

    /** Method used to display the Input error message. */
    public void showInputError() {
        System.out.println(new ErrorStringBuilder(INPUT_ERROR));
    }

}
