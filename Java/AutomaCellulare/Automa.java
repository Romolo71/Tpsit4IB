import java.util.Arrays;

public class Automa {
    private int[] striscia;
    private int regola;

    public Automa(int larghezza, int regola) {
        this.striscia = new int[larghezza];
        striscia[larghezza / 2] = 1; // partiamo con solo la cellula centrale "viva"
        this.regola = regola;

    }

    public int getRegola() {
        return regola;
    }

    public int[] getStriscia() {
        return Arrays.copyOf(striscia, striscia.length);
    }

    /**
     * Calcola il nuovo stato di una singola cella in base ai vicini e alla regola
     *
     * I 3 valori (sinistra, centro, destra) formano un pattern binario (da 0 a 7)
     * Il bit corrispondente nella regola determina il nuovo stato
     */

    public int calcolaStato(int sinistra, int centro, int destra) {
        int indice = (sinistra << 2) | (centro << 1) | destra;
        return (regola >> indice) & 1;
    }

    public void nextStato() {
        int[] nuovoStato = new int[striscia.length];
        for (int i = 0; i < striscia.length; i++) {
            int sinistra = (i > 0) ? striscia[i - 1] : 0;
            int centro = striscia[i];
            int destra = (i < striscia.length - 1) ? striscia[i + 1] : 0;
            nuovoStato[i] = calcolaStato(sinistra, centro, destra);
        }
        striscia = nuovoStato;
    }

    /**
     * Stampa lo stato corrente
     * Non usare questo metodo quando passi alla parte multithreading
     */
    public void stampaStato() {
        for (int c : striscia) {
            System.out.print(c == 1 ? "█" : " ");
        }
        System.out.println();
    }

    /**
     * Restituisce lo stato come stringa di 0 e 1.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int c : striscia) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Automa a = new Automa(40, 110);

        for (int i = 0; i < 30; i++) {
            a.stampaStato();
            a.nextStato();
        }
    }
}
