<?php
if (!defined('CONST_INCLUDE')) {
    die('Accès interdit');
}
include_once "connexion.php";

class ModeleJoueurs extends Connexion
{
    public function __construct()
    {
    }

    public function getListe()
    {
        $sth = self::$bdd->prepare('SELECT id, nom FROM JoueursFoot');
        $sth->execute();

        return $sth->fetchAll();
    }

    public function getDetailsJoueur($id)
    {
        $sth = self::$bdd->prepare("SELECT nom, description FROM JoueursFoot WHERE id = '$id'");
        $sth->execute();

        return $sth->fetchAll();
    }

    public function ajouterJoueur($nom, $desc)
    {
        $req = self::$bdd->prepare('INSERT INTO JoueursFoot(nom, description) VALUES(:nom, :description)');
        $req->execute(
            array(
                'nom' => $nom,
                'description' => $desc
            )
        );
    }

    public function connexion($pseudo, $mdp)
    {
        $req = self::$bdd->prepare('SELECT id, mdp FROM utilisateurs WHERE pseudo = :pseudo');
        $req->execute(array(
            'pseudo' => $pseudo
        ));
        $res = $req->fetch();

        return $res;
    }

    public function inscription($pseudo, $mdp)
    {
        $req = self::$bdd->prepare('INSERT INTO utilisateurs(pseudo, mdp) VALUES(:pseudo, :mdp)');
        return $req->execute(
            array(
                'pseudo' => $pseudo,
                'mdp' => $mdp
            )
        );
    }
}
