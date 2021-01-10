-- TP9
-- wjacques 18/12/2020

-- Exercice 1

-- 1.
DROP SCHEMA IF EXISTS BOOKBAY CASCADE;
CREATE SCHEMA IF NOT EXISTS BOOKBAY;

-- 2.
DROP DOMAIN IF EXISTS numtel;
DROP DOMAIN IF EXISTS url;
DROP DOMAIN IF EXISTS email;
CREATE DOMAIN numtel AS text CHECK (VALUE ~* E'0\\d{1}\.\\d{2}\.\\d{2}\.\\d{2}\.\\d{2}');
CREATE DOMAIN url AS text CHECK (VALUE ~* E'^http[s]?://[a-z0-9]+\.[a-z0-9]+\.[a-z]{2,4}$');
CREATE DOMAIN email AS text CHECK (VALUE  ~* E'^[a-z][a-z0-9_-]+\.?[a-z0-9_-]+@[a-z0-9_-]+\.[a-z]{2,4}$');

-- 3.
DROP TYPE IF EXISTS coordType;
CREATE TYPE coordType AS (
    numero int,
    typeVoie varchar(32),
    nomVoie varchar(64),
    codePostal int,
    ville varchar(64)
);

-- 4.

-- CREATE TABLE seulement
CREATE TABLE bookbay.Auteur (
    idAuteur serial PRIMARY KEY,
    nomAuteur varchar(32),
    prenomAuteur varchar(32),
    nationalite varchar(32),
    dateNais date NOT NULL,
    dateDeces date,
    lieuNais varchar(32)
);

CREATE TABLE bookbay.Distinction (
    titreDistinction varchar(64) PRIMARY KEY,
    anneeCreation int,
    lieuCreation varchar(32)
);

CREATE TABLE bookbay.Imprimeur (
    codeImprimeur serial PRIMARY KEY,
    nomImprimeur varchar(64),
    coordonnees coordType,
    nbEmployeImp int,
    siteWeb url,
    telephone numtel,
    fax numtel
);

CREATE TABLE bookbay.Editeur (
    codeEdition serial PRIMARY KEY,
    nomEdition varchar(64),
    adresse varchar(64),
    codePostal int,
    ville varchar(32),
    nbEmploye int,
    emailContact email,
    dateCreation date
);

CREATE TABLE bookbay.Livre (
    isbn varchar(17) PRIMARY KEY,
    titre varchar(64),
    prix int,
    depotlegal boolean,
    datImpression date,
    langue varchar(16),
    annee int,
    traduction varchar(32)
);

CREATE TABLE bookbay.Collection (
    codeCollection serial PRIMARY KEY,
    intitule varchar(64)
);

CREATE TABLE bookbay.Entrepot (
    codEntrepot int PRIMARY KEY,
    adresse varchar(64),
    codPost varchar(5),
    villeEntrep varchar(32),
    responsable varchar(64)
);

-- Tables avec des FK en PK
CREATE TABLE bookbay.Ecrire ();
CREATE TABLE bookbay.Obtenir ();
CREATE TABLE bookbay.Appartenir ();
CREATE TABLE bookbay.Stocker ();
CREATE TABLE bookbay.Imprimer ();

-- ALTER TABLE pour rajouter les colonnes avec contraintes
ALTER TABLE bookbay.Livre
    ADD COLUMN codeCollection int,
    ADD CONSTRAINT ck_prix CHECK (prix > 0),
    ADD CONSTRAINT fk_codeCollection FOREIGN KEY (codeCollection) REFERENCES bookbay.Collection (codeCollection);

ALTER TABLE bookbay.Collection
    ADD COLUMN codEdition int,
    ALTER COLUMN intitule SET NOT NULL,
    ADD COLUMN theme varchar(32),
    ADD CONSTRAINT ck_theme CHECK (
        theme IN (
            'roman',
            'sciences humaines',
            'informatique',
            'enseignement',
            'littérature',
            'anticipation',
            'essais',
            'beaux livres'
        )
    ),
    ADD CONSTRAINT fk_codEdition FOREIGN KEY (codEdition) REFERENCES bookbay.Editeur (codeEdition);

ALTER TABLE bookbay.Entrepot
    ADD COLUMN codEdition int,
    ADD CONSTRAINT fk_codEdition FOREIGN KEY (codEdition) REFERENCES bookbay.Editeur (codeEdition);


ALTER TABLE bookbay.Ecrire
    ADD COLUMN idAuteur int,
    ADD COLUMN isbn varchar(17),
    ADD CONSTRAINT fk_idAuteur FOREIGN KEY (idAuteur) REFERENCES bookbay.Auteur (idAuteur),
    ADD CONSTRAINT fk_isbn FOREIGN KEY (isbn) REFERENCES bookbay.Livre (isbn),
    ADD PRIMARY KEY (idAuteur, isbn);

ALTER TABLE bookbay.Obtenir
    ADD COLUMN isbn varchar(17),
    ADD COLUMN titreDistinction varchar(64),
    ADD COLUMN datePrixObtenu date,
    ADD CONSTRAINT fk_isbn FOREIGN KEY (isbn) REFERENCES bookbay.Livre (isbn),
    ADD CONSTRAINT fk_titreDistinction FOREIGN KEY (titreDistinction) REFERENCES bookbay.Distinction (titreDistinction),
    ADD PRIMARY KEY (isbn, titreDistinction);

ALTER TABLE bookbay.Appartenir
    ADD COLUMN isbn varchar(17),
    ADD COLUMN codeCollection int,
    ADD CONSTRAINT fk_isbn FOREIGN KEY (isbn) REFERENCES bookbay.Livre (isbn),
    ADD CONSTRAINT fk_codeCollection FOREIGN KEY (codeCollection) REFERENCES bookbay.Collection (codeCollection),
    ADD PRIMARY KEY (isbn, codeCollection);

ALTER TABLE bookbay.Stocker
    ADD COLUMN isbn varchar(17),
    ADD COLUMN codEntrepot int,
    ADD COLUMN quantiteEnStock int,
    ADD COLUMN dateModifStock date,
    ADD CONSTRAINT ck_quantite CHECK (quantiteEnStock >= 0),
    ADD CONSTRAINT fk_isbn FOREIGN KEY (isbn) REFERENCES bookbay.Livre (isbn),
    ADD CONSTRAINT fk_codEntrepot FOREIGN KEY (codEntrepot) REFERENCES bookbay.Entrepot (codEntrepot),
    ADD PRIMARY KEY (isbn, codEntrepot);

ALTER TABLE bookbay.Imprimer
    ADD COLUMN codeCollection int,
    ADD COLUMN codeImprimeur int,
    ADD CONSTRAINT fk_codeCollection FOREIGN KEY (codeCollection) REFERENCES bookbay.Collection (codeCollection),
    ADD CONSTRAINT fk_codeImprimeur FOREIGN KEY (codeImprimeur) REFERENCES bookbay.Imprimeur (codeImprimeur),
    ADD PRIMARY KEY (codeCollection, codeImprimeur);

ALTER TABLE bookbay.Auteur
    ALTER COLUMN nationalite SET DEFAULT 'inconnue';

ALTER TABLE bookbay.Editeur
    ADD CONSTRAINT ck_codePostal CHECK (codePostal BETWEEN 1000 AND 99000);

-- INSERT ...
insert into bookbay.auteur (nomAuteur, prenomAuteur, nationalite, dateNais, dateDeces, lieuNais) values ('Snow', 'John', 'FR', '08-03-2000', '07-01-2020', 'Paris');
insert into bookbay.livre values ('0101010101010', 'ahhahah', 20, true, '10-12-2020', 'FR', 2021);
insert into bookbay.ecrire values (1, '0101010101010');

SELECT a.nomAuteur, l.titre FROM bookbay.Livre l JOIN bookbay.Ecrire e ON l.isbn = e.isbn JOIN bookbay.Auteur a ON e.idAuteur = a.idAuteur GROUP BY a.nomAuteur, l.titre;
