package it.uniba.app.utility;

import it.uniba.app.exception.InvalidConfirmationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <Boundary>
 * <p>
 * A {@code ConfirmationRequest} is used to ask the user for confirmation
 * before performing a particularly important
 * (typically non-reversible) operation.
 */

public final class ConfirmationRequest {

    /**
     * Asks the user for confirmation before performing an operation.
     *
     * @return {@code true} if the user accepted the confirmation request;
     * {@code false} if the user declined the confirmation request.
     * @throws IOException                  if an I/O error occurs;
     * @throws InvalidConfirmationException If the user did not answer correctly
     *                                      to this request.
     */
    public boolean askUserConfirmation() throws IOException, InvalidConfirmationException {
        System.out.print("[y/n]: ");

        BufferedReader commandLineInputStream = new BufferedReader(new InputStreamReader(System.in));
        String answer = commandLineInputStream.readLine();

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

    }
}
