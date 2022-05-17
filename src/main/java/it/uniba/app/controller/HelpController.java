package it.uniba.app.controller;

import it.uniba.app.exception.FlagException;

public class HelpController implements Controller {

  public static void showHelp() {

    System.out.println("\nDESCRIZIONE APPLICAZIONE: Videogame Wordle in command line interface. \n\n" +

        "Il gioco consiste nell'indovinare una parola preimpostata (parola segreta) in un massimo di 6 tentativi. \n" +
        "Dopo ogni tentativo i colori delle lettere cambieranno per mostrare il feedback, in particolare \n\n" +

        " * VERDE rappresenta una lettera della parola segreta posizionata correttamente, \n" +
        " * GIALLO una lettera in parola ma non nella posizione corretta, \n" +
        " * GRIGIO una lettera non in parola. \n\n" +

        "OPZIONI: \n\n" +

        " -h, --help  Visualizza questa guida. \n\n" +

        "COMANDI IN APP: \n\n" +

        " /nuova <parola>  Imposta <parola> come nuova parola segreta. \n" +
        " /mostra	  Visualizza la parola segreta attuale. \n" +
        " /help		  Visualizza questa guida. \n" +
        " /gioca 	  Inizio di una nuova partita. \n" +
        " /abbandona	  Termina la partita correntemente in esecuzione. \n" +
        " /esci		  Termina l'applicazione. \n"

    );

  }

  public static boolean checkFlagOnStart(String[] args) throws FlagException {

    if (args.length > 0) {

      if (args[0].equals("-h") || args[0].equals("--help")) {

        return true;
      } else {

        throw new FlagException();
      }

    } else {

      return false;
    }

  }

  public void control(String[] args) {

    HelpController.showHelp();
  }

}
