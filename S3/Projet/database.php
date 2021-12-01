<?php

class Database
{

    protected static $db;

    public function __construct()
    {
    }

    public static function connect()
    {
        self::$db = new PDO(
            "mysql:host=database-etudiants.iut.univ-paris8.fr;dbname=dutinfopw20166;port=",
            "dutinfopw20166",
            "jebesymy"
        );
    }
}
