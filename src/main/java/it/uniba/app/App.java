package it.uniba.app;

import it.uniba.app.ui.CommandLineShell;

/**
 * <noECB>
 * <p>
 * Main class of the application.
 */
public final class App {

    private App() {
    }

    /**
     * Entrypoint of the application.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        new CommandLineShell().execute(args);
    }
}
