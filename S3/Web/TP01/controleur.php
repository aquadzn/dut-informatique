<?php
include_once "modele.php";
include_once "vue.php";

class Controleur
{

    private $modele;
    private $vue;

    public function __construct()
    {
        $this->modele = new Modele();
        $this->vue = new Vue();
        $this->vue->menu();
    }

    public function liste()
    {
        $tab = $this->modele->getListe();
        $this->vue->affiche_liste($tab);
    }

    public function bienvenue()
    {
        echo "<br></br><h1>Bienvenue</h1>";
    }

    public function details()
    {
        $id = $_GET['id'];

        $tab = $this->modele->getDetailsJoueur($id);
        $this->vue->affiche_joueur($tab);
    }
}
