package it.uniba.app.utility;

/**
 * <Boundary>
 * <p>
 * Interagisce con l'utente, mostrando il feedback relativo
 * all'inserimento di una nuova parola segreta.
 */

public final class SelezioneParolaSegretaBoundary {

    private static final String MESSAGGIO_OK = AnsiColors.getBrightGreen() + "[OK] Parola segreta impostata con successo!" + AnsiColors.getReset();
    private static final String MESSAGGIO_PAROLA_MANCANTE =
            new ErrorStringBuilder("Non hai specificato alcuna parola.").toString();
    private static final String MESSAGGIO_PARTITA_IN_CORSO =
            new ErrorStringBuilder("Non è possibile modificare la parola segreta durante una partita.").toString();
    private static final String MESSAGGIO_PAROLA_CORTA =
            new ErrorStringBuilder("Parola segreta troppo corta (deve essere di %d lettere).").toString();
    private static final String MESSAGGIO_PAROLA_LUNGA =
            new ErrorStringBuilder("Parola segreta troppo lunga (deve essere di %d lettere).").toString();
    private static final String MESSAGGIO_PAROLA_INVALIDA =
            new ErrorStringBuilder("Parola segreta non valida (non conteneva solo lettere dell'alfabeto).").toString();

    public void mostraOK() {
        System.out.println(MESSAGGIO_OK);
    }

    public void mostraErroreParolaMancante() {
        System.out.println(MESSAGGIO_PAROLA_MANCANTE);
    }

    public void mostraErrorePartitaInCorso() {
        System.out.println(MESSAGGIO_PARTITA_IN_CORSO);
    }

    public void mostraErroreParolaCorta(final int lunghezzaCorretta) {
        if (lunghezzaCorretta >= 2) {
            System.out.format(MESSAGGIO_PAROLA_CORTA, lunghezzaCorretta);
            System.out.println();
        } else {
            throw new IllegalArgumentException("length is less than 2");
        }
    }

    public void mostraErroreParolaLunga(final int lunghezzaCorretta) {
        if (lunghezzaCorretta >= 2) {
            System.out.format(MESSAGGIO_PAROLA_LUNGA, lunghezzaCorretta);
            System.out.println();
        } else {
            throw new IllegalArgumentException("length is less than 2");
        }
    }

    public void mostraErroreParolaInvalida() {
        System.out.println(MESSAGGIO_PAROLA_INVALIDA);
    }
}
