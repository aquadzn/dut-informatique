<?php
if (!defined('CONST_INCLUDE')) {
    die('Accès interdit');
}
include_once "connexion.php";

class ModeleEquipes extends Connexion
{
    public function __construct()
    {
    }

    public function getListe()
    {
        $sth = self::$bdd->prepare('SELECT id, nom FROM Equipes');
        $sth->execute();

        return $sth->fetchAll();
    }

    public function getDetailsEquipe($id) {
        $sth = self::$bdd->prepare("SELECT nom, description FROM Equipes WHERE id = '$id'");
        $sth->execute();

        return $sth->fetchAll();
    }
}
