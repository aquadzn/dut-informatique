<?php
if (!defined('CONST_INCLUDE')) {
    die('Accès interdit');
}
include_once "vue_generique.php";

class VueEquipes extends VueGenerique
{
    public function __construct()
    {
        parent::__construct();
    }

    public function affiche_liste($tab)
    {
        echo "<br></br>";
        echo "<ul>";
        foreach ($tab as $t) {
            echo '<li><a href="index.php?module=equipes&action=details&id=' . $t['id'] . '">' . $t['nom'] . '</a></li>';
        }
        echo "</ul>";
    }

    public function affiche_equipe($tab)
    {
        echo "<br></br>";
        foreach ($tab as $t) {
            echo '<h1 class="title">' . $t['nom'] . '</h1>';
            echo !empty($t['description']) ? '<p class="subtitle">' . $t['description'] . '</p>' : '<p>pas de description</p>';
        }
        
    }

    public function menu()
    {
        echo '<br></br>';
        echo '<a class="title is-4 is-underlined" href="index.php?module=equipes&action=liste">Liste des équipes</a>';
    }
}
