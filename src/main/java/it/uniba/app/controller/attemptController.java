package it.uniba.app.controller;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import it.uniba.app.exception.LetteraInvalidaException;
import it.uniba.app.exception.ParolaCortaException;
import it.uniba.app.exception.ParolaLungaException;
import it.uniba.app.exception.PartitaInCorsoException;
import it.uniba.app.utility.AnsiColors;
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

                    Parola parola = new Parola(args[0]);
                    String[] coloredLetter = new String[5];

                    coloredLetter = compereLetters(ParolaSegreta.getAttualeParolaSegreta(), parola);

                    System.out.println("┌───────────────────┐");
                    System.out.println("│ GRIGLIA DI GIOCO  │");
                    System.out.println("├───┬───┬───┬───┬───┤");

                    System.out.println(MessageFormat.format("│ {0} │ {1} │ {2} │ {3} │ {4} │", coloredLetter[0],  coloredLetter[1],  coloredLetter[2], coloredLetter[3],  coloredLetter[4]));
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

    public String[] compereLetters(Parola parolaSegreta, Parola tentativo){

        String[] coloredWord = new String[5];
        boolean flagLettera = false;

        if(tentativo.equalsIgnoreCaseAndColors(ParolaSegreta.getAttualeParolaSegreta())){
            for(int i = 0; i < Parola.getLength(); i++){
                coloredWord[i] = AnsiColors.makeBackgourdGreen(tentativo.getLettere()[i].getCarattere());
            }
        }else{

            for(int i = 0; i < Parola.getLength(); i++){

                int j = 0;

                flagLettera = false;

                    while(j < Parola.getLength() && flagLettera == false){

                    if(parolaSegreta.getLettere()[j].getCarattere() == tentativo.getLettere()[i].getCarattere()){

                        flagLettera = true;

                        if(i == j){
                            coloredWord[i] = AnsiColors.makeBackgourdGreen(tentativo.getLettere()[i].getCarattere());
                            System.out.println("i == j --> " + i + " - " + j);
                        }else{
                            j = i;
                            if(parolaSegreta.getLettere()[j].getCarattere() == tentativo.getLettere()[i].getCarattere()){
                                coloredWord[i] = AnsiColors.makeBackgourdGreen(tentativo.getLettere()[i].getCarattere());
                            }else{
                                coloredWord[i] = AnsiColors.makeBackgourdYellow(tentativo.getLettere()[i].getCarattere());
                                System.out.println("i != j --> " + i + " - " + j);
                            }


                        }

                        System.out.println(" jjjjjjjjjjjjjjjjjj ");

                    }

                    j++;
                }

                    if(flagLettera == false){
                        coloredWord[i] = AnsiColors.makeBackgourdGray(tentativo.getLettere()[i].getCarattere());
                    }

                    System.out.println(" iiiiiiiiiiiii ");

            }

        }

        return coloredWord;

    }

}