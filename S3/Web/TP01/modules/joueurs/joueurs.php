<?php
if (!defined('CONST_INCLUDE')) {
    die('Accès interdit');
}
include_once "cont_joueurs.php";
include_once "vue_joueurs.php";

class Joueurs
{
    public $vue;

    public function __construct()
    {
        $controleur_joueur = new ContJoueurs();
        $this->vue = $controleur_joueur->vue;

        $action = isset($_GET['action']) ? $_GET['action'] : '';

        switch ($action) {
            case 'liste':
                $controleur_joueur->liste();
                break;
            case 'details':
                $controleur_joueur->details();
                break;
            case 'formulaire':
                $controleur_joueur->formulaire();
                break;
            case 'ajout':
                $controleur_joueur->ajout();
                break;
            case 'form_inscription':
                $controleur_joueur->form_inscription();
                break;    
            case 'form_connexion':
                $controleur_joueur->form_connexion();
                break;
            case 'inscription':
                $controleur_joueur->inscription();
                break;    
            case 'connexion':
                $controleur_joueur->connexion();
                break;
            case 'deconnexion':
                $controleur_joueur->deconnexion();
                break;
            default:
                break;
        }
    }
}
