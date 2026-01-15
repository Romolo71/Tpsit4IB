import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rullo implements Runnable {
    private String simboloEstratto;
    private final String[] simboliPossibili;
    private final Random random = new Random();
    private boolean inEsecuzione = true;

    public Rullo(String[] simboliPossibili) {
        this.simboliPossibili = simboliPossibili;
    }

    // Colori ANSI forniti
    public static final String RESET = "\u001B[0m";
    public static final String ROSSO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String GIALLO = "\u001B[33m";
    public static final String BLU = "\u001B[34m";
    public static final String CIANO = "\u001B[36m";

    // Simboli Emoji (UTF-16)
    private static final String DIAMANTE = "\uD83D\uDC8E"; // Super Raro
    private static final String CAMPANA = "\uD83D\uDD14";  // Raro
    private static final String LIMONE = "\uD83C\uDF4B";   // Medio
    private static final String CILIEGIA = "\uD83C\uDF52"; // Comune

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Configurazione probabilità (RTP ~65%)
        // Abbiamo 20 slot totali sul rullo per gestire le frequenze
        String[] configurazioneRullo = {
                DIAMANTE,                                           // 1/20  (5%)
                CAMPANA, CAMPANA, CAMPANA,                         // 3/20  (15%)
                LIMONE, LIMONE, LIMONE, LIMONE, LIMONE, LIMONE,    // 6/20  (30%)
                CILIEGIA, CILIEGIA, CILIEGIA, CILIEGIA, CILIEGIA,   // 10/20 (50%)
                CILIEGIA, CILIEGIA, CILIEGIA, CILIEGIA, CILIEGIA
        };

        double budget = 100.0;
        double scommessa = 10.0;

        System.out.println(CIANO + "=== BENVENUTO NELLA JAVA SLOT ===" + RESET);
        System.out.println("Budget iniziale: " + budget + "€\n");

        while (budget >= scommessa) {
            System.out.print("Inserisci la puntata: ");
            scommessa = input.nextDouble();
            budget -= scommessa;
            System.out.println(GIALLO + "Scommessa effettuata: " + scommessa + "€ | Budget rimanente: " + budget + "€" + RESET);
            System.out.print("I rulli girano: ");

            // Creazione e avvio dei Thread (3 rulli)
            Rullo[] rulli = {new Rullo(configurazioneRullo), new Rullo(configurazioneRullo), new Rullo(configurazioneRullo)};
            Thread[] threads = new Thread[3];

            for (int i = 0; i < 3; i++) {
                threads[i] = new Thread(rulli[i]);
                threads[i].start();
            }

            // Attesa termine rotazione
            for (Thread t : threads) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                }
            }

            // Visualizzazione Risultato
            String r1 = rulli[0].getSimboloEstratto();
            String r2 = rulli[1].getSimboloEstratto();
            String r3 = rulli[2].getSimboloEstratto();

            System.out.println("\n[ " + r1 + " | " + r2 + " | " + r3 + " ]");

            // Calcolo Vincita
            double vincita = calcolaVincita(r1, r2, r3, scommessa);

            if (vincita > 0) {
                budget += vincita;
                System.out.println(VERDE + "!!! HAI VINTO: " + vincita + "€ !!!" + RESET);
            } else {
                System.out.println(ROSSO + "Nessuna combinazione. Ritenta!" + RESET);
            }

            System.out.println("---------------------------------------");

            // Pausa
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
            }

            // Condizione di uscita per la demo (fermiamo dopo qualche giro o se finiscono i soldi)
            if (budget <= 0) break;
        }

        System.out.println(ROSSO + "Game Over! Hai esaurito il budget." + RESET);
    }


    private static double calcolaVincita(String s1, String s2, String s3, double bet) {
        if (s1.equals(s2) && s2.equals(s3)) {
            switch (s1) {
                case DIAMANTE:
                    return bet * 150;
                case CAMPANA:
                    return bet * 35;
                case LIMONE:
                    return bet * 10;
                case CILIEGIA:
                    return bet * 2;
            }
        }
        return 0;
    }
    
    @Override
    public void run() {
        try {
            // Simula la rotazione per un tempo variabile (da 1 a 2 secondi)
            int rotazioni = 10 + random.nextInt(10);
            for (int i = 0; i < rotazioni; i++) {
                simboloEstratto = simboliPossibili[random.nextInt(simboliPossibili.length)];
                Thread.sleep(100); // Velocità di rotazione
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            inEsecuzione = false;
        }
    }

    public String getSimboloEstratto() {
        return simboloEstratto;
    }

    public boolean isInEsecuzione() {
        return inEsecuzione;
    }
}