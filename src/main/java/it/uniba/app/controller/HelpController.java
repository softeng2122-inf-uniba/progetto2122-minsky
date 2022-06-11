package it.uniba.app.controller;

import it.uniba.app.exception.FlagException;
import it.uniba.app.wordle.HelpBoundary;

/**
 * <Control>
 * <p>
 * This class is responsible for displaying the user guide.
 */

public class HelpController implements Controller {

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

    HelpBoundary.showHelp();
  }

}
