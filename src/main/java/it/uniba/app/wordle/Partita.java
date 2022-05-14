package it.uniba.app.wordle;

/**
 * <Entity>
 * <p>
 * Rappresenta una partita di Wordle.
 */

public class Partita {
    private static Partita partitaInCorso;
    private static int numeroMassimoTentativi = 6;

    private final GrigliaDiGioco grigliaDiGioco = new GrigliaDiGioco();
    private final ParolaSegreta parolaSegreta;

    public Partita(final ParolaSegreta parolaSegreta) {
        this.parolaSegreta = parolaSegreta;
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
