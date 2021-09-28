<?php
if (!defined('CONST_INCLUDE')) {
    die('Accès interdit');
}
include_once "cont_equipes.php";

class Equipes {

    public function __construct()
    {
        $controleur_equipe = new ContEquipes();

        $action = isset($_GET['action']) ? $_GET['action'] : '';

        switch ($action) {
            case 'liste':
                $controleur_equipe->liste();
                break;
            case 'details':
                $controleur_equipe->details();
                break;
            default:
                break;
        }
    }
}
