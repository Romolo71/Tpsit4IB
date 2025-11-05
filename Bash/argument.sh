#!/bin/bash

if [ -z $1 ] then
	echo "Non ho nessun argument, aggiungine!!!!!"
	exit 2
fi

if [ -z $2 ] then
	filename=$2

	if [ -z $3 ] then
		word=$3
		result=$(grep "$word" "filename")
		echo $result
	else
		echo "Non ho la parola come argomento!"
	fi

else
	echo "Non ho il secondo argument"
	exit 2
fi
