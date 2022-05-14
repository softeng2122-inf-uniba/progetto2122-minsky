package it.uniba.app.utility;

import it.uniba.app.exception.InvalidConfirmationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <Boundary>
 * <p>
 * Interagisce con l'utente, chiedendo una conferma per una operazione da eseguire.
 */

public final class ConfirmationRequest {

    /**
     * Richiede all'utente una conferma per una operazione da eseguire.
     *
     * @return {@code true} se l'utente ha confermato l'operazione;
     * {@code false} se l'utente ha rifiutato l'operazione.
     * @throws IOException                  Se si verifica un errore di I/O;
     * @throws InvalidConfirmationException Se l'utente non ha risposto correttamente alla richiesta di conferma.
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
