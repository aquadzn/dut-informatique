# Bréviaire CLI


![Terminal ZSH](https://miro.medium.com/max/4136/1*DUiI66gNESMgRhg97GcuPg.png)


## Commandes principales


Commande | Description | Exemple
--- | --- | ---
**ls** | permet de lister le contenu d’un répertoire | <ul><li>**ls** -a: affiche également les fichiers/répertoires cachés</li><li>**ls** -l: affiche en ligne</li></ul>
**touch** | créer un fichier vide | <ul><li>**touch** *nom_fichier*</li></ul>
**mkdir** | créer un dossier | <ul><li>**mkdir** *mon_dossier*</li></ul>
**rm** | supprimer un fichier / dossier | <ul><li>**rm** nom_fichier</li><li>**rm** -r nom_dossier: supprimer un dossier</li></ul>
**cp** | copier un fichier / dossier | <ul><li>**cp** nom_fichier</li><li>**cp** -r nom_dossier: copier un dossier</li></ul>
**more** | affiche le contenu d'un fichier prenant la largeur du terminal | <ul><li>**more** *mon_fichier*</li></ul>
**head** | affiche la première partie d'un fichier (10 lignes par défaut) | <ul><li>**head** -n 5 *mon_fichier*: affiche les 5 premières lignes d'un fichier</li></ul>
**tail** | affiche la dernière partie d'un fichier (10 lignes par défaut) | <ul><li>**tail** -n 5 *mon_fichier*: affiche les 5 dernières lignes d'une fichier</li></ul>
**cat** | affiche tout le contenu d'un fichier | <ul><li>**cat** *mon_fichier*</li></ul>
**echo** | affiche une ligne dans le terminal | <ul><li>**echo** "Bonjour!"</li></ul>
**ln** | créer un lien qui redirige un fichier vers un autre | <ul><li>**ln** *source* *lien_mat*: créer un lien matériel</li><li>**ln** -s *source* *lien_sym*: créer un lien symbolique</li></ul>
**chmod** | Gérer les droits d'accès des fichiers et répertoires | <ul><li>**chmod** [0-7][0-7][0-7] *fichier_ou_dossier*: attribue les droits d'accès dans l'ordre propriétaire - groupe - autres</li><li>**chmod** 644 *monfichier*: attribue rw-r--r-- à *monfichier*</li></ul>
**umask** | Définit les permissions par défaut lorsqu'un fichier ou dossier est crée | <ul><li>**umask** [0-7][0-7][0-7][0-7]</li><li>**umask** 022: accorde les permissions par défaut 666-022: 644 rw-r--r--</li></ul>
**wc** | Afficher le nombre de lignes, de mots et d'octets d'un fichier | <ul><li>**wc** *mon_fichier*</li><li>**wc** -w *mon_fichier*: compte le nombre de mots dans le fichier</li></ul>
**cut** | Supprimer une partie de chaque ligne d'un fichier | <ul><li>**cut** -c1-10 *mon_fichier*: sélectionne pour chaque ligne du fichier les caractères 1 à 10</li></ul>
**ps** | Liste les processus en cours | <ul><li>**ps**</li><li>**ps** -ely: affiche une liste longue (-l) sans les flags (-y) de tous les processus (-e)</li></ul>
**kill** | Envoyer un signal à un processus | <ul><li>**kill** -9 6868: tue le processus avec le PID 6868</li></ul>


## Autres


Commande | Description | Exemple
--- | --- | ---
**>** | écrase et envoie l'output d'une commande vers un fichier | <ul><li>**echo** "Bonjour" **>** *mon_fichier*</li></ul>
**>>** | ajoute l'output d'une commande à la fin d'un fichier | <ul><li>**echo** "Bonjour" **>>** *mon_fichier*</li></ul>
**|** | permet de passer le résultat d'une commande shell à une autre commande shell | <ul><li>**man** curl **|** **more**: affiche la première partie de man curl</li></ul>
