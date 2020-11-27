#!/bin/bash

if [ -f "$1" ]; then
	echo "Le fichier existe déjà"
else
	touch "$1"
	read -p "Entrez du texte ou rien pour quitter: " text
	while [[ -n "$text" ]]; do
		echo "$text" >> "$1"
		read -p "Entrez du texte ou rien pour quitter: " text
	done
fi
