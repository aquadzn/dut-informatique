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
    note smallint,
    datNotation timestamp DEFAULT now(),
    constraint pk_noter PRIMARY KEY (noAbon, idFilm),
    constraint fk_noter_noAbon FOREIGN KEY (noAbon) REFERENCES imdb.abonne (noAbon),
    constraint fk_noter_idFilm FOREIGN KEY (idFilm) REFERENCES imdb.film (idFilm),
    constraint ck_note CHECK (note BETWEEN 0 AND 10)
);

-- Exercice 3

DROP SCHEMA IF EXISTS comics CASCADE;
CREATE SCHEMA IF NOT EXISTS comics;

CREATE TABLE comics.langue (
    lid varchar(16) PRIMARY KEY,
    nom varchar(64)
);

CREATE TABLE comics.collection (
    cid varchar(8) PRIMARY KEY,
    cnom varchar(64)
);

CREATE TABLE comics.editeur (
    eid integer PRIMARY KEY,
    enom varchar(64)
);

CREATE TABLE comics.auteur (
    idAuth serial PRIMARY KEY,
    nom varchar(32),
    prenom varchar(32),
    pseudo varchar(32)
);

CREATE TABLE comics.ouvrage (
    no serial PRIMARY KEY,
    titre varchar(64),
    annee integer,
    cid varchar(8),
    lid varchar(16),
    eid integer,
    constraint fk_comics_cid FOREIGN KEY (cid) REFERENCES comics.collection (cid),
    constraint fk_comics_lid FOREIGN KEY (lid) REFERENCES comics.langue (lid),
    constraint fk_comics_eid FOREIGN KEY (eid) REFERENCES comics.editeur (eid)
);

INSERT INTO comics.langue (lid, nom) VALUES
    ('en_US', 'américain'),
    ('fr_FR', 'français'),
    ('en_GB', 'anglais')
;

INSERT INTO comics.collection (cid, cnom) VALUES
    ('C1', 'Astérix'),
    ('C2', 'Donjon'),
    ('C3', 'Winch')
;

INSERT INTO comics.editeur (eid, enom) VALUES
    (10, 'Dargaud'),
    (20, 'Delcourt'),
    (30, 'Casterman')
;

INSERT INTO comics.ouvrage (titre, annee, cid, lid, eid) VALUES
    ('Astérix le Gaulois', 1959, 'C1', 'fr_FR', 10),
    ('Largo Winch', 1977, 'C3', 'fr_FR', 30),
    ('Donjon Potron-Minet', 1998, 'C2', 'fr_FR', 20)
;

INSERT INTO comics.auteur (nom, prenom, pseudo) VALUES
    ('Chabosy', 'Laurent', 'Lewis Trondheim'),
    ('Sfar', 'Joann', 'Joann Sfar'),
    ('Goscinny', 'René', 'Agostini'),
    ('Van Hamme', 'Jean', NULL)
;

-- Optionnel

-- 1.
SELECT * FROM comics.langue;

-- 2.
SELECT DISTINCT cnom FROM comics.collection ORDER BY cnom ASC;

-- 3.
SELECT nom FROM comics.auteur WHERE prenom LIKE 'J%';

-- 4.
SELECT COUNT(*) FROM comics.ouvrage;

-- 5.
SELECT titre, annee FROM comics.ouvrage WHERE annee BETWEEN 1973 AND 1975 ORDER BY titre ASC;

-- 6.
SELECT no, titre, annee, cid, lid, eid FROM comics.ouvrage NATURAL JOIN comics.editeur WHERE enom LIKE 'Casterman' AND annee >= 1970 ORDER BY annee DESC;

-- 7.
SELECT * from comics.auteur WHERE pseudo IS NULL;

-- 8.
SELECT eid, enom FROM comics.editeur NATURAL JOIN comics.ouvrage GROUP BY eid HAVING COUNT(eid) > 1;
