<?php
if (!isset($_SESSION)) {
    session_start();
}

if (!defined('CONST_INCLUDE')) {
    die('Accès interdit');
}
include_once "modele_joueurs.php";
include_once "vue_joueurs.php";

class ContJoueurs
{

    private $modele;
    private $vue;

    public function __construct()
    {
        $this->modele = new ModeleJoueurs();
        $this->vue = new VueJoueurs();
        $this->vue->menu(
            isset($_SESSION['id']) and isset($_SESSION['pseudo'])
        );
    }

    public function liste()
    {
        $tab = $this->modele->getListe();
        $this->vue->affiche_liste($tab);
    }

    public function details()
    {
        $id = $_GET['id'];

        $tab = $this->modele->getDetailsJoueur($id);
        $this->vue->affiche_joueur($tab);
    }

    public function formulaire()
    {
        $this->vue->form_ajout();
    }

    public function ajout()
    {
        $nom = $_POST['nom'];
        $desc = $_POST['desc'];

        // if (!empty($nom) && !empty($desc))

        $this->modele->ajouterJoueur($nom, $desc);
        $this->vue->ajout();
    }

    public function form_connexion()
    {
        $this->vue->form_connexion();
    }


    public function connexion()
    {
        $res = $this->modele->connexion(
            $_POST['pseudo'],
            $_POST['mdp']
        );

        $mdpCorrect = password_verify($_POST['mdp'], $res['mdp']);

        if ($res) {
            if ($mdpCorrect) {
                $_SESSION['id'] = $res['id'];
                $_SESSION['pseudo'] = $_POST['pseudo'];
            }
        }

        $this->vue->connexion($mdpCorrect);
    }

    public function form_inscription()
    {
        $this->vue->form_inscription();
    }


    public function inscription()
    {
        $pseudo = $_POST['pseudo'];
        $mdp = $_POST['mdp'];

        // if (!empty($nom) && !empty($desc))

        $this->vue->inscription(
            $this->modele->inscription($pseudo, password_hash($mdp, PASSWORD_DEFAULT))
        );
    }

    public function deconnexion()
    {
        $_SESSION = array();
        session_destroy();

        setcookie('login', '');
        setcookie('mdp', '');
    }
}
