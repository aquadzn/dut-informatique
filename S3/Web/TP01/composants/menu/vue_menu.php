<?php

include_once "vue_generique.php";

class VueMenu extends VueGenerique {

    public function __construct()
    {
        parent::__construct();
    }

    public function menu()
    {
        echo '<br></br><ul>';
        if (isset($_SESSION['id']) and isset($_SESSION['pseudo'])) {
            echo '<li><a class="title is-4 is-underlined" href="index.php?module=joueurs&action=liste">Liste des joueurs</a></li>';
            echo '<li><a class="title is-4 is-underlined" href="index.php?module=joueurs&action=formulaire">Ajouter un joueur</a></li></ul>';
        }
        else {
            echo '<li><p class="title is-4">Connectez-vous pour accéder aux fonctionnalitées</p></li>';
        }
    }
}

?>