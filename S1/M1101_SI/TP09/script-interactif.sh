#!/bin/bash

echo "Script $0 – Nombre d’arguments : $#"
read -p "Bonjour, quel est votre nom ? --> " nom
read -p "Bonjour $nom, quel répertoire souhaitez-vous lister aujourd’hui ? --> " repertoire
echo "Vous avez demandé le listing du répertoire $repertoire"
cd "$repertoire"
ls
echo "Le script est à présent terminé"