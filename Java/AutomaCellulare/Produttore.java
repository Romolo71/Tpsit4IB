import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Produttore implements Runnable {
    
    // TODO 6: Costruttore e attributi: deve prendere la lista condivisa
    // e gestire una variabile booleana per segnalare che ha finito di inserire 
    // elementi nella lista(vedi pdf). Prendi anche la larghezza degli automi da creare
    private List<Automa> lista; 
    private AtomicBoolean haFinito;
    private int larghezza; 

    public Produttore(List<Automa> lista, AtomicBoolean haFinito, int larghezza) {
        this.lista = lista;
        this.haFinito = haFinito;
        this.larghezza = larghezza;
    }

    @Override
    public void run() {

        // TODO 7: Crea un thread produttore che:
        //   - Crea 256 oggetti Automa (regole da 0 a 255) con larghezza LARGHEZZA
        //   - Li inserisce nella lista condivisa
        //   - Alla fine, deve segnalare che ha finito agli altri thread (vedi pdf)
        //   - Stampa un messaggio tipo "Produttore: tutti gli automi creati"
        for (int i = 0; i < 256; i++) {
            lista.add(new Automa(larghezza, i));
        }
        haFinito.set(true);
        System.out.println("Produttore: tutti gli automi creati");
    }

}
