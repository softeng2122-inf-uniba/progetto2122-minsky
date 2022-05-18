package it.uniba.app.controller;

import javax.naming.PartialResultException;

import it.uniba.app.exception.PartitaInCorsoException;
import it.uniba.app.utility.ErrorStringBuilder;
import it.uniba.app.wordle.Partita;

public class attemptController implements Controller{

    public void control(String[] args){


        try{

            if(Partita.getPartitaInCorso() != null){

                System.out.println("PARTITA IN ESECUZIONE");

                


            }else{
                throw new PartitaInCorsoException();
            }
            

        }catch(PartitaInCorsoException px){

            System.out.println(new ErrorStringBuilder(px.showMessage()));
        }

    }

}
