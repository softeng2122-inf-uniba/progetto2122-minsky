package it.uniba.app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import it.uniba.app.exception.LetteraInvalidaException;
import it.uniba.app.exception.ParolaCortaException;
import it.uniba.app.exception.ParolaLungaException;
import it.uniba.app.exception.PartitaInCorsoException;
import it.uniba.app.utility.ErrorStringBuilder;
import it.uniba.app.wordle.Parola;
import it.uniba.app.wordle.Partita;

public class attemptController implements Controller{


    @Override
    public void control(String[] args){


        try{

            if(Partita.getPartitaInCorso() != null){

                int attemptCount = 0;
                List<Parola> attempt = new ArrayList<>();

                while(attemptCount < Partita.getNumeroMassimoTentativi()){

                    System.out.println(args[attemptCount]);

                }
   


            }else{
                throw new PartitaInCorsoException();
            }
            

        }catch(PartitaInCorsoException px){

            System.out.println(new ErrorStringBuilder(px.showMessage()));

        }/*catch (ParolaCortaException e) {

            System.out.println(new ErrorStringBuilder(e.showMessage()));

        } catch (ParolaLungaException e) {

            System.out.println(new ErrorStringBuilder(e.showMessage()));

        } catch (LetteraInvalidaException e) {

            System.out.println(new ErrorStringBuilder(e.showMessage()));

        } */

    }

}
