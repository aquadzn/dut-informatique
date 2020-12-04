-- TP8 wjacques
-- 4/12/2020

-- Exercice 1
DROP SCHEMA IF EXISTS cook CASCADE;
CREATE SCHEMA IF NOT EXISTS cook;

CREATE TABLE cook.ingredient (
    idIngr serial PRIMARY KEY,
    libelle varchar(100) NOT NULL,
    calorie integer,
    glucide integer,
    lipide integer,
    protide integer
);

CREATE TABLE cook.typeplat (
    idTyp varchar(32) PRIMARY KEY, 
    constraint ck_idTyp CHECK (idTyp IN ('entrée', 'légume', 'viande', 'poisson', 'dessert'))
);

CREATE TABLE cook.recette (
    idRec serial PRIMARY KEY,
    titre varchar(100) NOT NULL,
    niveau integer,
    nbPers smallint,
    pays varchar(32),
    tps_prepa integer,
    tps_cuisson integer,
    idTyp varchar(32),
    constraint fk_idTyp FOREIGN KEY (idTyp) REFERENCES cook.typeplat (idTyp)
);

CREATE TABLE cook.necessiter (
    idRec integer,
    idIngr integer,
    quantite integer,
    constraint pk_necessiter PRIMARY KEY (idRec, idIngr),
    constraint fk_necessiter_idRec FOREIGN KEY (idRec) REFERENCES cook.recette (idRec),
    constraint fk_necessiter_idIngr FOREIGN KEY (idIngr) REFERENCES cook.ingredient (idIngr)
);

-- Exercice 2
DROP SCHEMA IF EXISTS imdb CASCADE;
CREATE SCHEMA IF NOT EXISTS imdb;

CREATE TABLE imdb.realisateur (
    noReal serial PRIMARY KEY,
    nomReal varchar(32),
    prenomReal varchar(32)
);

CREATE TABLE imdb.acteur (
    noAct serial PRIMARY KEY,
    nomAct varchar(32),
    prenomAct varchar(32)
);

CREATE TABLE imdb.abonne (
    noAbon serial PRIMARY KEY,
    nom varchar(32),
    prenom varchar(32),
    email varchar(64) UNIQUE
);

CREATE TABLE imdb.film (
    idFilm serial PRIMARY KEY,
    titre varchar(64) NOT NULL,
    synopsis text,
    anneeCreation smallint,
    dateSortie date,
    image varchar(64),
    duree smallint,
    classification varchar(6),
    noReal integer,
    constraint ck_classification CHECK (classification IN ('G', 'PG', 'PG-13', 'R', 'NC-17')),
    constraint fk_noReal FOREIGN KEY (noReal) REFERENCES imdb.realisateur (noReal)
);

CREATE TABLE imdb.jouer (
    idFilm integer,
    noAct integer,
    constraint pk_jouer PRIMARY KEY (idFilm, noAct),
    constraint fk_jouer_idFilm FOREIGN KEY (idFilm) REFERENCES imdb.film (idFilm),
    constraint fk_jouer_noAct FOREIGN KEY (noAct) REFERENCES imdb.acteur (noAct)
);

CREATE TABLE imdb.noter (
    noAbon integer,
    idFilm integer,
    vu boolean DEFAULT false,
    note smallint NOT NULL,
    datNotation timestamp DEFAULT now(),
    constraint pk_noter PRIMARY KEY (noAbon, idFilm),
    constraint fk_noter_noAbon FOREIGN KEY (noAbon) REFERENCES imdb.abonne (noAbon),
    constraint fk_noter_idFilm FOREIGN KEY (idFilm) REFERENCES imdb.film (idFilm),
    constraint ck_note CHECK (note BETWEEN 0 AND 10)
);

-- Exercice 3

DROP SCHEMA IF EXISTS comics CASCADE;
CREATE SCHEMA IF NOT EXISTS comics;

-- CREATE TABLE comics.langue (

-- );