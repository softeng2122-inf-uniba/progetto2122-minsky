package it.uniba.app.wordle;

import it.uniba.app.exception.NessunaPartitaInCorsoException;
import it.uniba.app.exception.ParolaSegretaMancanteException;
import it.uniba.app.exception.PartitaInCorsoException;

/**
 * <Entity>
 * <p>
 * Rappresenta una partita di Wordle.
 */

public class Partita {
    private static Partita partitaInCorso;
    private static final int numeroMassimoTentativi = 6;

    private final GrigliaDiGioco grigliaDiGioco = new GrigliaDiGioco();
    private final ParolaSegreta parolaSegreta;

    public Partita(final ParolaSegreta parolaSegreta) {
        this.parolaSegreta = parolaSegreta;
    }

    public static void iniziaNuovaPartita() throws PartitaInCorsoException, ParolaSegretaMancanteException {
        if (getPartitaInCorso() == null) {
            if (ParolaSegreta.getAttualeParolaSegreta() != null) {
                partitaInCorso = new Partita(ParolaSegreta.getAttualeParolaSegreta());
            } else {
                throw new ParolaSegretaMancanteException();
            }
        } else {
            throw new PartitaInCorsoException();
        }
    }

    public static void AbbandonaPartita() throws NessunaPartitaInCorsoException {
        if (getPartitaInCorso() != null) {
                partitaInCorso = null;
        } else {
            throw new NessunaPartitaInCorsoException();
        }
    }

    public static Partita getPartitaInCorso() {
        return partitaInCorso;
    }

    public static int getNumeroMassimoTentativi() {
        return numeroMassimoTentativi;
    }

    public GrigliaDiGioco getGrigliaDiGioco() {
        return grigliaDiGioco;
    }

    public ParolaSegreta getParolaSegreta() {
        return parolaSegreta;
    }
}
