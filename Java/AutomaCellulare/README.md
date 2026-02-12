# Progetto JAVA "CONCORRENZA & THREAD" 🧵

Questo progetto si focalizza sull'implementazione del multithreading in Java per la materia **TPSIT**. L'obiettivo è analizzare la gestione dei processi paralleli, la sincronizzazione delle risorse e l'evitamento di condizioni critiche (Race Conditions).

---

## 👤 Informazioni Progetto

- **Realizzatore:** Riccardo Tonini
- **Richiesto da:** Prof. Martina Zuccon
- **Istituto:** ITIS "C. Zuccante"
- **Materia:** TPSIT (Tecnologie e Progettazione di Sistemi Informatici e di Telecomunicazioni)
- **Data Inizio:** 12 Febbraio 2026
- **Data Fine:** [Inserisci Data]

---

## 📚 Indice

- [Progetto JAVA "CONCORRENZA \& THREAD" 🧵](#progetto-java-concorrenza--thread-)
  - [👤 Informazioni Progetto](#-informazioni-progetto)
  - [📚 Indice](#-indice)
  - [🎯 Obiettivi dell'Esperienza](#-obiettivi-dellesperienza)
  - [📚 Richiami Teorici](#-richiami-teorici)
  - [⚙️ Architettura del Software](#️-architettura-del-software)
  - [💡 Cosa si può apprendere da questo codice](#-cosa-si-può-apprendere-da-questo-codice)
  - [📝 Considerazioni Finali](#-considerazioni-finali)

---

## 🎯 Obiettivi dell'Esperienza

[cite_start]L'obiettivo principale è simulare l'evoluzione di tutte le 256 regole degli automi cellulari 1D di Wolfram per 1000 generazioni[cite: 57]. [cite_start]Si punta a implementare un sistema multithreaded per ottimizzare il calcolo e la scrittura dei risultati su file, gestendo la concorrenza tramite il pattern Producer-Consumer[cite: 58].

---

## 📚 Richiami Teorici

- [cite_start]**Automi Cellulari 1D:** Una striscia di cellule dove ogni cellula può essere viva (1) o morta (0)[cite: 5]. [cite_start]Lo stato successivo dipende dalla cellula stessa e dai suoi due vicini[cite: 6, 10].
- [cite_start]**Regole di Wolfram:** Esistono 256 possibili regole (da 0 a 255) basate sulle 8 combinazioni binarie dei vicini[cite: 23]. [cite_start]Un esempio notevole è la Regola 110, che è Turing-completa[cite: 30].
- [cite_start]**Producer-Consumer:** Un'architettura dove un thread "Produttore" crea i task e più thread "Consumatori" (Vetrini) li elaborano in parallelo[cite: 58].
- [cite_start]**JUnit:** Framework utilizzato per testare la corretta simulazione delle cellule prima dell'implementazione multithread[cite: 41, 42].

---

## ⚙️ Architettura del Software

Il progetto implementa:

- [cite_start]**Classe Automa:** Gestisce la logica di calcolo dello stato (`calcolaStato`) e della generazione successiva (`nextStato`)[cite: 52, 53].
- [cite_start]**Produttore (1 thread):** Crea 256 oggetti `Automa` e li inserisce in una coda di lavoro[cite: 58].
- [cite_start]**Vetrini (4 thread):** Consumano gli automi dalla coda, li fanno evolvere per 1000 generazioni e scrivono il risultato finale in `data/regole/<regola>.txt`[cite: 57, 58].
- [cite_start]**Sincronizzazione:** Utilizzo di un flag booleano (`haFinito`) per segnalare ai thread Vetrino quando il produttore ha terminato il suo compito[cite: 59].

---

## 💡 Cosa si può apprendere da questo codice

1. [cite_start]**Parallelismo:** Gestire 4 "vetrini" simultanei per velocizzare l'elaborazione di task indipendenti[cite: 57, 58].
2. [cite_start]**Manipolazione Binaria:** Convertire numeri decimali in stringhe binarie e viceversa per mappare i pattern alle regole di output[cite: 36, 47, 50].
3. [cite_start]**Gestione I/O:** Comprendere che la stampa a video (`stampaStato`) è estremamente lenta e va evitata durante simulazioni intensive[cite: 43].

---

## 📝 Considerazioni Finali

[cite_start]Il progetto ha permesso di verificare come la sincronizzazione tra thread sia fondamentale per una corretta terminazione del programma[cite: 59, 60]. [cite_start]L'utilizzo dei test JUnit ha garantito l'integrità della logica di transizione delle celle prima di scalare la simulazione su larga scala[cite: 42, 54]. [cite_start]Infine, la simulazione ha dimostrato l'efficienza del multithreading nel gestire operazioni di calcolo e scrittura su file in parallelo[cite: 57, 58].
