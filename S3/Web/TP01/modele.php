<?php
include_once "connexion.php";

class Modele extends Connexion
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

    public function getDetailsJoueur($id) {
        $sth = self::$bdd->prepare("SELECT nom, description FROM JoueursFoot WHERE id = '$id'");
        $sth->execute();

        return $sth->fetchAll();
    }
}
