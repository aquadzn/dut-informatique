<?php
session_start();

define('CONST_INCLUDE', NULL);
include_once "connexion.php";
include_once "modules/joueurs/vue_joueurs.php";
// include_once "composants/menu/cont_menu.php";

Connexion::initConnexion();

include_once "modules/joueurs/joueurs.php";
$controleur = new Joueurs();
$tampon = $controleur->vue->getAffichage();

include_once "template.php";
?>
