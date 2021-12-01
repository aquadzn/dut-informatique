<?php
if (!defined('CONST_INCLUDE')) {
    die('Accès interdit');
}
include_once "database.php";

class Model extends Database
{
    public function __construct()
    {
    }

    public function login($username, $password)
    {
        $req = self::$db->prepare('SELECT id, mdp FROM utilisateurs WHERE pseudo = :pseudo');
        $req->execute(array(
            'pseudo' => $password
        ));
        $res = $req->fetch();

        return $res;
    }

    public function signup($firstname, $lastname, $username, $email, $password)
    {
        $req = self::$db->prepare(
            'INSERT INTO utilisateurs(pseudo, mdp, email, prenom, nom)
             VALUES(:pseudo, :mdp, :email, :prenom, :nom)'
        );
        return $req->execute(
            array(
                'pseudo' => $username,
                'mdp' => $password,
                'email' => $email,
                'prenom' => $firstname,
                'nom' => $lastname
            )
        );
    }

    public function get_reservations()
    {
        $req = self::$db->prepare('SELECT * from reservations');
        $req->execute();

        return $req->fetchAll();
    }

    public function get_salles()
    {
        $req = self::$db->prepare('SELECT * from salles');
        $req->execute();

        return $req->fetchAll();
    }

    public function get_messages()
    {
        $req = self::$db->prepare('SELECT * from messages');
        $req->execute();

        return $req->fetchAll();
    }

    public function get_reservations_per_user($username)
    {
        $req = self::$db->prepare('SELECT * from reservations where reserve_par = :reserve_par');
        $req->execute(array('reserve_par' => $username));

        return $req->fetchAll();
    }

    public function get_appareils_per_salle($id_room)
    {
        $req = self::$db->prepare('SELECT * from appareils where id_salle = :id_salle');
        $req->execute(array('id_salle' => $id_room));

        return $req->fetchAll();
    }

    public function get_appareil_attributes($name)
    {
        $req = self::$db->prepare('SELECT * from appareils where id_salle = :id_salle');
        $req->execute(array('id_salle' => $id_room));

        return $req->fetchAll();
    }
}
