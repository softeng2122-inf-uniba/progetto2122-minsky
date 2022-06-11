package it.uniba.app.wordle;

public final class HelpBoundary {

    private HelpBoundary() {
    }

    /**
     * Help guide message.
     */

    private static final String HELP_MESSAGE =

        "\nDESCRIZIONE APPLICAZIONE: "
        +
        "Videogame Wordle in command line interface. \n\n"
        +
        "Il gioco consiste nell'indovinare una parola preimpostata "
        +
        "(parola segreta) in un massimo di 6 tentativi. \n"
        +
        "Dopo ogni tentativo i colori delle lettere "
        +
        "cambieranno per mostrare il feedback, in particolare \n\n"
        +
        " * VERDE rappresenta una lettera della "
        +
        "parola segreta posizionata correttamente, \n"
        +
        " * GIALLO una lettera in parola ma non "
        +
        " nella posizione corretta, \n"
        +
        " * GRIGIO una lettera non in parola. \n\n"
        +
        "OPZIONI: \n\n"
        +
        " -h, --help  Visualizza questa guida. \n\n"
        +
        "COMANDI IN APP: \n\n"
        +
        " /nuova <parola>  Imposta <parola> come nuova parola segreta. \n"
        +
        " /mostra \t  Visualizza la parola segreta attuale. \n"
        +
        " /help \t\t  Visualizza questa guida. \n"
        +
        " /gioca \t  Inizio di una nuova partita. \n"
        +
        " /abbandona \t  Termina la partita correntemente in esecuzione. \n"
        +
        " /esci \t\t  Termina l'applicazione. \n";

   /**
   * Print the help message.
   */

  public static void showHelp() {

    System.out.println(HELP_MESSAGE);

  }

}
