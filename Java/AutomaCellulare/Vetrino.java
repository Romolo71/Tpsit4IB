import java.io.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Arrays;

/**
 * "Vetrino": prende un automa dalla lista condivisa,
 * lo fa evolvere per N generazioni, e scrive il risultato su file
 * Se la coda è vuota e l produttore ha finito, allora deve terminare
 */
public class Vetrino implements Runnable {
    List<Automa> coda;
    Produttore prod;
    int generazioni;

    public Vetrino(List<Automa> coda, Produttore prod, int generazioni) {
        // TODO 8: completa il costruttore e gli attributi
        this.coda = coda;
        this.prod = prod;
        this.generazioni = generazioni;
    }

    @Override
    public void run() {
        // TODO 9: Finché ci sono automi da "consumare":
        //   - Prendi un automa dalla coda
        //   - Fai evolvere l'automa per 'generazioni' passi
        //   - Scrivi il risultato su file con scriviSuFile(automa)
        //
        //   - Stampa un messaggio di log, per es: System.out.println("Regola " + regola + " completata da " + Thread.currentThread().getName());
        // 
        // Ricorda di gestire le eccezioni (InterruptedException, IOException)
        while (!coda.isEmpty() || !prod.haFinito()) {
            Automa automa = coda.poll();
            if (automa != null) {
                automa.evolvi(generazioni);
                scriviSuFile(automa);
                System.out.println("Regola " + automa.getRegola() + " completata da " + Thread.currentThread().getName());
            }
        }
    }

    private void scriviSuFile(Automa automa) throws IOException {
        // TODO 10: scrivi su file il risultato
        try (PrintWriter out = new PrintWriter(new FileWriter("data/regole/" + automa.getRegola() + ".txt"))) {
            for (int[] riga : automa.getStato()) {
                for (int cella : riga) {
                    out.print(cella);
                }
                out.println();
            }
        }
    }
}
