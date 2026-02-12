import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static final int NUM_VETRINI = 4;
    public static final int GENERAZIONI = 1000;
    public static final int LARGHEZZA = 201;
    public static void main(String[] args) {
        // TODO 11: crea la lista condivisa 
        // Crea e fa partire un thread "Produttore"
        // Crea e fa partire i 4 thread "VETRINI"
        List<Automa> lista = new ArrayList<>();
        AtomicBoolean haFinito = new AtomicBoolean(false);
        Produttore produttore = new Produttore(lista, haFinito, LARGHEZZA);
        Vetrino vetrino = new Vetrino(lista, produttore, GENERAZIONI);
        Thread threadProduttore = new Thread(produttore);
        Thread threadVetrino = new Thread(vetrino);
        threadProduttore.start();
        threadVetrino.start();

        // Aspetta che termini tutto
    }
}
