# Bréviaire CLI


## Commandes principales


Commande | Description | Exemple
--- | --- | ---
**ls** | permet de lister le contenu d’un répertoire | <ul><li>**ls** -a: affiche également les fichiers/répertoires cachés</li><li>**ls** -l: affiche en ligne</li></ul>
**touch** | créer un fichier vide | **touch** nom_fichier
**mkdir** | créer un dossier | **mkdir** mon_dossier
**rm** | supprimer un fichier / dossier | <ul><li>**rm** nom_fichier</li><li>**rm** -r nom_dossier: supprimer un dossier</li></ul>
**cp** | copier un fichier / dossier | <ul><li>**cp** nom_fichier</li><li>**cp** -r nom_dossier: copier un dossier</li></ul>
**more** | affiche le contenu d'un fichier prenant la largeur de l'écran | **more** mon_fichier
**head** | affiche la première partie d'un fichier | **head** -n 5 mon_fichier: affiche les 5 premières lignes d'un fichier 
**tail** | affiche la dernière partie d'un fichier | **tail** -n 5 mon_fichier: affiche les 5 dernières lignes d'une fichier
**cat** | affiche tout le contenu d'un fichier | **cat** mon_fichier
**echo** | affiche une ligne dans le terminal | **echo** "Bonjour!"


## Autres


Commande | Description | Exemple
--- | --- | ---
**>** | écrase et envoie l'output d'une commande vers un fichier | echo "Bonjour" **>** mon_fichier
**>>** | ajoute l'output d'une commande à la fin d'un fichier | echo "Bonjour" **>>** mon_fichier
