<?php
if (!defined('CONST_INCLUDE')) {
    die('Accès interdit');
}
include_once "modele_equipes.php";
include_once "vue_equipes.php";

class ContEquipes
{

    private $modele;
    private $vue;

    public function __construct()
    {
        $this->modele = new ModeleEquipes();
        $this->vue = new VueEquipes();
        $this->vue->menu();
    }

    public function liste()
    {
        $tab = $this->modele->getListe();
        $this->vue->affiche_liste($tab);
    }

    public function details()
    {
        $id = $_GET['id'];

        $tab = $this->modele->getDetailsEquipe($id);
        $this->vue->affiche_equipe($tab);
    }
}
