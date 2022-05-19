package it.uniba.app.controller;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import it.uniba.app.exception.LetteraInvalidaException;
import it.uniba.app.exception.ParolaCortaException;
import it.uniba.app.exception.ParolaLungaException;
import it.uniba.app.exception.PartitaInCorsoException;
import it.uniba.app.utility.ErrorStringBuilder;
import it.uniba.app.wordle.Parola;
import it.uniba.app.wordle.ParolaSegreta;
import it.uniba.app.wordle.Partita;

public class attemptController implements Controller {

    @Override
    public void control(String[] args) {

        try {

            if (Partita.getPartitaInCorso() != null) {

                int attemptCount = 0;
                List<Parola> attempt = new ArrayList<>();

                if (args[0].length() == Parola.getLength()) {

                    String parola = args[0];
                    System.out.println("┌───────────────────┐");
                    System.out.println("│ GRIGLIA DI GIOCO  │");
                    System.out.println("├───┬───┬───┬───┬───┤");

                    System.out.println(MessageFormat.format("│ {0} │ {1} │ {2} │ {3} │ {4} │", parola.charAt(0),  parola.charAt(1),  parola.charAt(2),  parola.charAt(3),  parola.charAt(4)));
                    System.out.println("├───┼───┼───┼───┼───┤");
                    

                    System.out.println("│   │   │   │   │   │");
                    System.out.println("└───┴───┴───┴───┴───┘");


                } else if (args[0].length() < Parola.getLength()) {

                    throw new ParolaCortaException();

                } else if (args[0].length() > Parola.getLength()) {

                    throw new ParolaLungaException();

                } else {

                    throw new LetteraInvalidaException();
                }

            } else {

                throw new PartitaInCorsoException();
            }

        } catch (PartitaInCorsoException px) {

            System.out.println(new ErrorStringBuilder(px.showMessage()));

        } catch (ParolaCortaException e) {

            System.out.println(new ErrorStringBuilder(e.showMessage()));

        } catch (ParolaLungaException e) {

            System.out.println(new ErrorStringBuilder(e.showMessage()));

        } catch (LetteraInvalidaException e) {

            System.out.println(new ErrorStringBuilder(e.showMessage()));

        }

    }
}

