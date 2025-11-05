#!/bin/bash


#chiedo utente filename


#chiedo utente parola
#trovo parola nel file no casesensitive

echo "Inserisci il nome di un file: "
read filename

echo "Dimmi cosa devo cercare nel file: "
read tofind

find=$(grep -e $tofind $filename)

if [$find != ""]; then
	echo "Trovato!"
else
	echo "Non l'ho Trovato"
fi
