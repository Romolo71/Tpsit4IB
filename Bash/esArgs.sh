#!/bin/bash

if [ -z $1 ] then
	echo "Non esiste!!"
fi

if [ -z $2 ] then
	echo "Manca un argomento (il primo: nome)"
	exit 2

else
	if [ -z $3 ] then
		echo "Manca un argomento (il secondo: cognome"
		exit 2
	else
		touch output.txt

		date =$(date + '%d-%m-%Y')
		echo date > output.txt
		args=$($2)$($3)
		echo "$args" > output.txt

		touch backup.txt
		cp output.txt backup.txt
		exit 123
	fi
fi
