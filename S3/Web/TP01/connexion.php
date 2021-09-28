<?php

class Connexion
{

    protected static $bdd;

    public function __construct()
    {
    }

    public static function initConnexion()
    {
        self::$bdd = new PDO(
            "mysql:host=database-etudiants.iut.univ-paris8.fr;dbname=dutinfopw20166;port=",
            "dutinfopw20166",
            "jebesymy"
        );
    }
}
