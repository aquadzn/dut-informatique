<?php

if (!defined('CONST_INCLUDE')) {
    die('Accès interdit');
}
include_once "modele_menu.php";
include_once "vue_menu.php";

class ContMenu {

    private $modele;
    private $vue;
    
    public function __construct()
    {
        $this->modele = new ModeleMenu();
        $this->vue = new VueMenu();
    }

    public function affiche() {
        $this->vue->menu();
    }
}

?>