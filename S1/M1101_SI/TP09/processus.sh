#!/bin/bash

echo "Bonjour"
read -p "Votre nom ? : " nom
read -p "Bienvenue $nom, quel processus voulez vous afficher ? : " pid

ps -ely | grep "$pid"