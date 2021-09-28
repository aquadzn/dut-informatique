<?php
session_start();
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mon site</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
</head>

<body>
    <section class="hero is-white is-fullheight">

        <div class="hero-head">
            <header class="navbar">
                <div class="container">
                    <div class="navbar-brand">
                        <a href="index.php" class="navbar-item">
                            <p>Accueil</p>
                        </a>
                        <a href="index.php?module=joueurs&action=form_inscription" class="navbar-item">
                            <p>Inscription</p>
                        </a>
                        <?php
                        if (isset($_SESSION['id']) and isset($_SESSION['pseudo'])) {
                            echo '
                            <a href="index.php?module=joueurs&action=deconnexion" class="navbar-item">
                                <p>Déconnexion</p>
                            </a>
                            ';
                        } else {
                            echo '
                            <a href="index.php?module=joueurs&action=form_connexion" class="navbar-item">
                                <p>Connexion</p>
                            </a>
                            ';
                        }
                        ?>

                        <div class="navbar-item">
                            <div class="buttons">
                                <a href="index.php?module=joueurs" class="button is-danger">Joueurs</a>
                                <a href="index.php?module=equipes" class="button is-link">Equipes</a>
                            </div>
                        </div>
                    </div>
                </div>
            </header>
        </div>

        <div class="hero-body">
            <div class="container has-text-centered">
                <?php
                define('CONST_INCLUDE', NULL);
                include_once "connexion.php";

                Connexion::initConnexion();

                $action = isset($_GET['module']) ? $_GET['module'] : 'default';

                switch ($action) {
                    case 'joueurs':
                        include_once "modules/joueurs/joueurs.php";
                        $controleur = new Joueurs();
                        break;
                    case 'equipes':
                        include_once "modules/equipes/equipes.php";
                        $controleur = new Equipes();
                        break;
                    default:
                        break;
                }

                ?>

                <br></br>

                <div>
                </div>
            </div>
        </div>

        <div class="hero-foot">
            <nav class="tabs is-boxed is-fullwidth">
                <div class="container">
                    <ul>
                        <li><a>Contact</a></li>
                        <li><a>Mentions légales</a></li>
                    </ul>
                </div>
            </nav>
        </div>
    </section>
</body>

</html>