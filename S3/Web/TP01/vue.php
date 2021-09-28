<?php

class Vue
{
    public function __construct()
    {
    }

    public function affiche_liste($tab)
    {
        echo "<br></br>";
        echo "<h1>Liste de joueurs</h1>";
        echo "<ul>";
        foreach ($tab as $t) {
            echo '<li><a href="index.php?action=details&id=' . $t['id'] . '">' . $t['nom'] . '</a></li>';
        }
        echo "</ul>";
    }

    public function affiche_joueur($tab)
    {
        echo "<br></br>";
        foreach ($tab as $t) {
            echo '<u><h1>' . $t['nom'] . '</h1></u>';
            echo !empty($t['description']) ? '<p>' . $t['description'] . '</p>' : '<p>pas de description</p>';
        }
        
    }

    public function menu()
    {
        echo '<a href="index.php?action=bienvenue">Bienvenue</a>';
        echo ' ';
        echo '<a href="index.php?action=liste">Liste</a>';
    }
}
