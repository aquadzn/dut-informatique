<?php
if (!defined('CONST_INCLUDE')) {
    die('Accès interdit');
}
include_once "vue_generique.php";

class VueJoueurs extends VueGenerique
{
    public function __construct()
    {
        parent::__construct();
    }

    public function form_inscription()
    {
        echo '
        <br></br>
        <form action="index.php?module=joueurs&action=inscription" method="post">
        <div class="field">
        <label class="label">Pseudo</label>
        <div class="control">
            <input name="pseudo" class="input" type="text" required>
        </div>
        </div>
        <div class="field">
        <label class="label">Mot de passe</label>
        <div class="control">
            <input name="mdp" class="input" type="password" required>
        </div>
        <br></br>
        <div class="control">
            <button type="submit" class="button is-success is-outlined is-rounded">Inscription</button>
        </div>
        </div>
        ';
    }

    public function inscription($success)
    {
        if ($success) {
            echo '
            <br></br>
            <p class="subtitle has-text-success">Votre compte a été crée. Vous pouvez désormais vous connecter</p>
            ';
        }
        else {
            echo '
            <br></br>
            <p class="subtitle has-text-danger is-underlined">Nom d\'utilisateur déjà pris</p>
            ';
        }
    }

    public function form_connexion()
    {
        echo '
        <br></br>
        <form action="index.php?module=joueurs&action=connexion" method="post">
        <div class="field">
        <label class="label">Pseudo</label>
        <div class="control">
            <input name="pseudo" class="input" type="text" required>
        </div>
        </div>
        <div class="field">
        <label class="label">Mot de passe</label>
        <div class="control">
            <input name="mdp" class="input" type="password" required>
        </div>
        <br></br>
        <div class="control">
            <button type="submit" class="button is-success is-outlined is-rounded">Se connecter</button>
        </div>
        </div>
        ';
    }

    public function connexion($success)
    {
        if (! $success) {
            echo '
            <br></br>
            <p class="subtitle has-text-danger is-underlined">Mauvais identifiant ou mot de passe!</p>
            ';
        }
        else {
            echo '
            <br></br>
            <p class="subtitle has-text-success">Vous êtes bien connecté au site</p>
            ';
        }
    }

    public function form_ajout()
    {
        echo '
        <br></br>
        <form action="index.php?module=joueurs&action=ajout" method="post">
        <div class="field">
        <label class="label">Nom</label>
        <div class="control">
            <input name="nom" class="input" type="text" placeholder="Sergio Aguero">
        </div>
        </div>
        <div class="field">
        <label class="label">Description</label>
        <div class="control">
            <input name="desc" class="input" type="text" placeholder="Le meilleur buteur de Premier League">
        </div>
        <br></br>
        <div class="control">
            <button type="submit" class="button is-primary">Envoyer</button>
        </div>
        </div>
        ';
    }

    public function ajout()
    {
        echo '
        <br></br>
        <p class="subtitle">Données du joueur ajoutées</p>
        ';
    }

    public function affiche_liste($tab)
    {
        echo "<br></br>";
        echo "<ul>";
        foreach ($tab as $t) {
            echo '<li><a href="index.php?module=joueurs&action=details&id=' . $t['id'] . '">' . $t['nom'] . '</a></li>';
        }
        echo "</ul>";
    }

    public function affiche_joueur($tab)
    {
        echo "<br></br>";
        foreach ($tab as $t) {
            echo '<h1 class="title">' . $t['nom'] . '</h1>';
            echo !empty($t['description']) ? '<p class="subtitle">' . $t['description'] . '</p>' : '<p>pas de description</p>';
        }
    }

    public function menu($connected)
    {
        echo '<br></br><ul>';
        if ($connected) {
            echo '<li><a class="title is-4 is-underlined" href="index.php?module=joueurs&action=liste">Liste des joueurs</a></li>';
            echo '<li><a class="title is-4 is-underlined" href="index.php?module=joueurs&action=formulaire">Ajouter un joueur</a></li></ul>';
        }
        else {
            echo '<li><p class="title is-4">Connectez-vous pour accéder aux fonctionnalitées</p></li>';
        }
    }
}
