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

    public function reservations()
    {
        $req = self::$db->prepare('SELECT * from reservations');
        $req->execute();

        return $req->fetchAll();
    }

    public function rooms()
    {
        $req = self::$db->prepare('SELECT * from rooms');
        $req->execute();

        return $req->fetchAll();
    }

    public function messages()
    {
        $req = self::$db->prepare('SELECT * from messages');
        $req->execute();

        return $req->fetchAll();
    }

    public function reservations_per_user($username)
    {
        $req = self::$db->prepare('SELECT * from reservations where reserve_par = :reserve_par');
        $req->execute(array('reserve_par' => $username));

        return $req->fetchAll();
    }

    public function default_devices_per_room($id_room)
    {
        $req = self::$db->prepare('SELECT * from defaultdevices where id_room = :id_room');
        $req->execute(array('id_room' => $id_room));

        return $req->fetchAll();
    }

    public function reservation_devices($id_reservation)
    {
        $req = self::$db->prepare('SELECT * from reservationdevices where id_reservation = :id_reservation');
        $req->execute(array('id_reservation' => $id_reservation));

        return $req->fetchAll();
    }
    
    public function reservation_devices_per_user($id_reservation, $username)
    {
        $req = self::$db->prepare(
            'SELECT r.* from reservationdevices r
             INNER JOIN groupes on r.id_groupe = r.id
             INNER JOIN users on g.id = u.
             where r.id_reservation = :id_reservation'
        );
        $req->execute(array('id_reservation' => $id_reservation));

        return $req->fetchAll();
    }
}
