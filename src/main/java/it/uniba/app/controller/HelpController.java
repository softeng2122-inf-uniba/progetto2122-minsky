package it.uniba.app.controller;

import it.uniba.app.exception.FlagException;

/**
 * <Control>
 * <p>
 * This class is responsible for displaying the user guide.
 */

public class HelpController implements Controller {

  /**
   * Print the help message.
   */

  private static void showHelp() {

    System.out.println(

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
            " /esci \t\t  Termina l'applicazione. \n"

    );

  }

  /**
   * Check if the application is invoked with the correct flegs.
   *
   * @param args
   * @return helpFlag
   * @throws FlagException
   */

  public static boolean checkFlagOnStart(final String[] args)
      throws FlagException {

    boolean helpFlag;

    if (args.length > 0) {

      if (args[0].equals("-h") || args[0].equals("--help")) {

        helpFlag = true;
      } else {

        throw new FlagException();
      }

    } else {

      helpFlag = false;
    }

    return helpFlag;

  }

  /**
   * Visualize the help message.
   */

  @Override
  public void control(final String[] args) {

    HelpController.showHelp();
  }

}
