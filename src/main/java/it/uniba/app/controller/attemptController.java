package it.uniba.app.controller;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import it.uniba.app.exception.LetteraInvalidaException;
import it.uniba.app.exception.NessunaPartitaInCorsoException;
import it.uniba.app.exception.ParolaCortaException;
import it.uniba.app.exception.ParolaLungaException;
import it.uniba.app.exception.PartitaInCorsoException;
import it.uniba.app.utility.AnsiColors;
import it.uniba.app.utility.ErrorStringBuilder;
import it.uniba.app.wordle.Parola;
import it.uniba.app.wordle.ParolaSegreta;
import it.uniba.app.wordle.Partita;

/**
 * <Control>
 * <p>
 * Permette di eseguire i tentativi 
 */

public class attemptController implements Controller {

    private static int attemptCount = 0;
    private static boolean win = false;
    public static List<String[]> attempt = new ArrayList<>();

    public static void addCount(){attemptCount++;}
    public static void reduceCount(){attemptCount--;}
    public static int getCount(){return attemptCount;}
    public static boolean getWin(){return win;}
    public static void setWin(){win = true;}
    public static void reserWin(){win = false;}
    public static void resetAttemptCount(){attemptCount = 0;}
    public static void clearAttempt(){attempt.clear();}

    @Override
    public void control(String[] args){

        try {

            if (Partita.getPartitaInCorso() != null) {


                if (args[0].length() == Parola.getLength()) {

                    Parola parola = new Parola(args[0]);
                    String[] coloredLetter;

                    coloredLetter = compereLetters(ParolaSegreta.getAttualeParolaSegreta(), parola);

                    attempt.add(coloredLetter);

                    printGrid(attempt);

                    attemptController.endAttempts();

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

            attemptController.reduceCount();
            System.out.println(new ErrorStringBuilder(e.showMessage()));

        } catch (ParolaLungaException e) {

            attemptController.reduceCount();
            System.out.println(new ErrorStringBuilder(e.showMessage()));

        } catch (LetteraInvalidaException e) {

            attemptController.reduceCount();
            System.out.println(new ErrorStringBuilder(e.showMessage()));

        }catch (NessunaPartitaInCorsoException e){}

    }

    public String[] compereLetters(Parola parolaSegreta, Parola tentativo) throws NessunaPartitaInCorsoException {

        String[] coloredWord = new String[5];
        boolean flagLettera = false;

        if (tentativo.equalsIgnoreCaseAndColors(ParolaSegreta.getAttualeParolaSegreta())) {

            for (int i = 0; i < Parola.getLength(); i++) {
                coloredWord[i] = AnsiColors.makeBackgourdGreen(tentativo.getLettere()[i].getCarattere());
            }
            System.out.println(AnsiColors.getBrightGreen() +"Parola segreta indovinata, complimenti! Numero tentativi : "  + attemptController.getCount() + AnsiColors.getReset());
            attemptController.setWin();
            Partita.AbbandonaPartita();
        } else {

            for (int i = 0; i < Parola.getLength(); i++) {

                int j = 0;

                flagLettera = false;

                while (j < Parola.getLength() && flagLettera == false) {

                    if (parolaSegreta.getLettere()[j].getCarattere() == tentativo.getLettere()[i].getCarattere()) {

                        flagLettera = true;

                        if (i == j) {

                            coloredWord[i] = AnsiColors.makeBackgourdGreen(tentativo.getLettere()[i].getCarattere());
                        } else {

                            j = i;
                            if (parolaSegreta.getLettere()[j].getCarattere() == tentativo.getLettere()[i]
                                    .getCarattere()) {
                                coloredWord[i] = AnsiColors
                                        .makeBackgourdGreen(tentativo.getLettere()[i].getCarattere());
                            } else {

                                coloredWord[i] = AnsiColors
                                        .makeBackgourdYellow(tentativo.getLettere()[i].getCarattere());
                            }

                        }

                    }

                    j++;
                }

                if (flagLettera == false) {
                    coloredWord[i] = AnsiColors.makeBackgourdGray(tentativo.getLettere()[i].getCarattere());
                }

            }

        }

        return coloredWord;

    }

    public static void endAttempts() throws NessunaPartitaInCorsoException{

        if(attemptController.getCount() == 6 && attemptController.getWin() == false){
            System.out.println(new ErrorStringBuilder("Hai raggiunto il numero massimo di tentativi, per maggiori informazioni digitare /help"));
            System.out.println("\nLa parola segreta è: " + ParolaSegreta.getAttualeParolaSegreta().toString());
            Partita.AbbandonaPartita();
        }
    }

    public static void printGrid(List<String[]> attempt){


        System.out.println("┌───────────────────┐");
        System.out.println("│ GRIGLIA DI GIOCO  │");
        System.out.println("├───┬───┬───┬───┬───┤");

        for(int i = 0; i < attempt.size(); i++){

            System.out.println(MessageFormat.format("│{0}│{1}│{2}│{3}│{4}│", attempt.get(i)[0],
            attempt.get(i)[1],  attempt.get(i)[2],  attempt.get(i)[3],  attempt.get(i)[4]));
            System.out.println("├───┼───┼───┼───┼───┤");

        }

        System.out.println("│   │   │   │   │   │");
        System.out.println("└───┴───┴───┴───┴───┘");

    }

}