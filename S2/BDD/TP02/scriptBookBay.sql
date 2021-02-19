-- Ce fichier contient le script destiné à créer la base de données le schéma "bookbay", et les utilisateurs.

\echo [INFO] Début du script

DROP SCHEMA IF EXISTS bookbay cascade ;

drop domain url, numtel, email ;
drop type adresse, personne ;

\echo [INFO] Création du schéma bookbay
CREATE SCHEMA bookbay;

\echo [INFO] Création extension ISN pour isbn
create extension if not exists isn ;

\echo [INFO] Création du domaine numtel avec des regex
create domain numtel as varchar(14) check (value ~* E'0\\d{1}\.\\d{2}\.\\d{2}\.\\d{2}\.\\d{2}');

\echo [INFO] Création du domaine email avec des regex
create domain email as varchar(50) check (value ~* E'^[a-z][a-z0-9_-]+\.?[a-z0-9_-]+@[a-z0-9_-]+\.[a-z]{2,4}$');

\echo [INFO] Création du domaine url avec des regex
create domain url as varchar(200) check (value ~* E'^http[s]?://[a-z0-9]+\.[a-z0-9]+\.[a-z]{2,4}$');

\echo [INFO] Création du type personne
create type personne as (nom varchar(32), prenom varchar(32), naissance date) ;

\echo [INFO] Création du type adresse
create type adresse as (numero smallint, type_de_voie varchar(16), nom_de_voie varchar(32), 
	code_postal integer, ville varchar(32) ) ;

-- \echo [INFO] Création des droits de lecture sur le schéma bookbay
-- GRANT USAGE ON SCHEMA bookbay TO PUBLIC;

-- EDITIONS
\echo [INFO] Création de la table bookbay.editions
CREATE TABLE bookbay.editions(
	code_editions integer CONSTRAINT pk_bookbay_editions PRIMARY KEY CONSTRAINT ck_bookbay_editions_code_editions CHECK(code_editions > 0 AND code_editions < 10000000),
	nom varchar(40) UNIQUE NOT NULL,
	adresse varchar(50),
	code_postal integer CONSTRAINT ck_bookbay_editions_code_postal CHECK(code_postal BETWEEN 1000 AND 99000),
	ville varchar(25),
	nombre_employes smallint CONSTRAINT ck_bookbay_editions_nombre_employes CHECK(nombre_employes > 0),
	email_contact varchar(30),
	date_creation date CONSTRAINT ck_bookbay_editions_date CHECK(date_part('year', date_creation) > 1500) );

-- \echo [INFO] Création des droits de lecture sur la table editions du schéma bookbay
-- GRANT SELECT ON TABLE bookbay.editions TO PUBLIC;

-- IMPRIMEURS
\echo [INFO] Création de la table bookbay.imprimeurs
CREATE TABLE bookbay.imprimeurs(
	code_imprimeur serial CONSTRAINT pk_bookbay_imprimeur PRIMARY KEY,
	nom_imprimeur varchar(40) UNIQUE NOT NULL,
	coordonnees adresse,		-- type adresse
	nb_employes integer CONSTRAINT ck_bookbay_imprimeurs_nb_employes CHECK(nb_employes > 0), 
	web url, 		-- domaine url
	telephone numtel,	-- domaine numtel
	fax numtel, 	-- domaine numtel
	CONSTRAINT ck_bookbay_imprimeurs_adresse_type_voie CHECK((coordonnees).type_de_voie in ('Lieu-dit', 'Faubourg', 'Quai', 'Chemin', 'Impasse', 'Rue', 'Boulevard', 'Avenue', 'Allée', 'Cours')) );

-- COLLECTIONS
\echo [INFO] Création de la table bookbay.collections
CREATE TABLE bookbay.collections(
	code_collection smallint constraint pk_bookbay_collections PRIMARY KEY CONSTRAINT ck_bookbay_code_collections CHECK(code_collection > 0), 
	intitule varchar(32) not null,
	code_editions integer,
	theme varchar(32),
	constraint fk_bookbay_collections_editions foreign key (code_editions) references bookbay.editions (code_editions) 
	on delete restrict on update cascade) ;

-- LIVRES
\echo [INFO] Création de la table bookbay.livres
CREATE TABLE bookbay.livres(
	isbn isbn13 CONSTRAINT pk_bookbay_livres_isbn PRIMARY KEY,
	titre varchar(150) NOT NULL,
	prix numeric(4,2) constraint ck_bookbay__livres_prix check (prix > 0),
	depot_legal date default null constraint ck_bookbay_livre_depot_legal check (depot_legal <= date_impression),
	date_impression date default null CONSTRAINT ck_bookbay_livres_date_impression CHECK (current_date >= date_impression), 
	langue varchar(32) not null,
	annee date constraint ck_bookbay_livres_date check ( date_part('year',annee) > 1500 and annee <= depot_legal ), 
	traductions varchar[], 
	code_collection smallint, 
	constraint fk_bookbay_livres_collections foreign key (code_collection) references bookbay.collections (code_collection) on delete restrict on update cascade );

-- AUTEURS
\echo [INFO] Création de la table bookbay.auteurs
CREATE TABLE bookbay.auteurs (
	identifiant_auteur smallint CONSTRAINT pk_bookbay_auteurs_identifiant_auteur PRIMARY KEY,
	CONSTRAINT ck_bookbay_auteurs_identifiant_auteur CHECK ( identifiant_auteur > 0 ),
	nom varchar(32) NOT NULL,
	prenom varchar(32),
	nationalite varchar(32) not null default 'inconnue',
	date_naissance date,
	CONSTRAINT ck_bookbay_auteurs_date_naissance CHECK (date_part('year', current_date) - date_part('year', date_naissance) > 7),
	date_deces date,
	CONSTRAINT ck_bookbay_auteurs_decesInfNaiss CHECK ((date_naissance < date_deces) and (date_deces <= current_date)),
	lieu_naissance varchar(64) );

-- ECRIT_PAR
\echo [INFO] Création de la table bookbay.ecrit_par
CREATE TABLE bookbay.ecrit_par (
	isbn isbn13, id_auteur integer, 
	constraint pk_bookbay_ecrit_par primary key (isbn, id_auteur), 
	constraint fk_bookbay_ecrit_par_livres foreign key (isbn) references bookbay.livres (isbn) 
	on delete restrict on update cascade,
 	constraint fk_bookbay_ecrit_par_auteurs foreign key (id_auteur) references bookbay.auteurs (identifiant_auteur) 
	on delete restrict on update cascade );

-- ENTREPOTS
\echo [INFO] Création de la table bookbay.entrepots
CREATE TABLE bookbay.entrepots (
	code_entrepot smallint CONSTRAINT pk_bookbay_entrepots PRIMARY KEY, 
	CONSTRAINT ck_bookbay_entrepots_code_entrepots CHECK(code_entrepot > 0),
	adresse varchar(50),
	code_postal integer CONSTRAINT ck_bookbay_entrepot_code_postal CHECK(code_postal BETWEEN 1000 AND 99000),
	ville varchar(25),
	responsable personne, -- type personne
	employes smallint CONSTRAINT ck_bookbay_entrepots_employes CHECK(employes > 0),
	code_editions integer,
	CONSTRAINT fk_bookbay_entrepot_editions foreign key (code_editions) references bookbay.editions (code_editions) on delete restrict on update cascade );

-- IMPRIME
\echo [INFO] Création de la table bookbay.imprime
create table bookbay.imprime (
	code_collection smallint, code_imprimeur integer, 
	constraint pk_bookbay_imprime primary key (code_collection, code_imprimeur), 
	constraint fk_bookbay_imprime_collections foreign key (code_collection) references bookbay.collections (code_collection) on delete restrict on update cascade, 
	constraint fk_bookbay_imprime_imprimeur foreign key (code_imprimeur) references bookbay.imprimeurs (code_imprimeur) on delete cascade on update cascade ); 

-- ENTREPOSE
\echo [INFO] Création de la table bookbay.entrepose
create table bookbay.entrepose (isbn isbn13, code_entrepot smallint, quantite integer, date_modification date, 
	constraint pk_bookbay_entrepose primary key (isbn, code_entrepot), 
	CONSTRAINT fk_bookbay_entrepose_livres foreign key (isbn) references bookbay.livres (isbn) on delete restrict on update cascade, 
CONSTRAINT fk_bookbay_entrepose_entrepot foreign key (code_entrepot) references bookbay.entrepots (code_entrepot) on delete restrict on update cascade ); 

-- DISTINCTIONS
\echo [INFO] Création de la table bookbay.distinctions
create table bookbay.distinctions ( prix varchar(64) constraint pk_bookbay_distinctions primary key, 
	annee_creation date, lieu_creation varchar(32) ); 

-- RECOMPENSE_PAR
\echo [INFO] Création de la table bookbay.recompense_par
create table bookbay.recompense_par ( prix varchar(64), isbn isbn13, annee date not null, 
	constraint pk_bookbay_recompense_par primary key (prix, isbn), 
	CONSTRAINT fk_bookbay_recompense_par_prix foreign key (prix) references bookbay.distinctions (prix) on delete cascade on update cascade,
	CONSTRAINT fk_bookbay_recompense_par_livres foreign key (isbn) references bookbay.livres (isbn) on delete restrict on update cascade );

-------------------------------------------------------------------------------------
-- \echo [INFO] Style des dates Jour/Mois/Année
-- ALTER USER postgres SET DATESTYLE to SQL;

-------------------------------------------------------------------------------------
-- \echo [INFO] Création des utilisateurs
-- DROP ROLE antoine;
-- CREATE ROLE antoine PASSWORD 'mot2passe' LOGIN CONNECTION LIMIT 5;
-- ALTER ROLE antoine SET DATESTYLE to SQL,DMY;

-- DROP ROLE marie;
-- CREATE ROLE marie PASSWORD 'essap2tom' LOGIN CONNECTION LIMIT 5;
-- ALTER ROLE marie SET DATESTYLE to SQL,DMY;

-- \echo [INFO] Création des droits de création sur la base de données
-- GRANT CREATE ON DATABASE centralivres TO PUBLIC;

-------------------------------------------------------------------------------------
-- \echo [INFO] Création du langage plpgsql sur la base de données
-- DROP FUNCTION IF EXISTS carre_plpgsql(integer);
-- DROP LANGUAGE plpgsql;

-- CREATE TRUSTED LANGUAGE plpgsql;

-- Une fonction de test qui renvoie un entier au carré (juste là pour les besoins de test de bon fonctionnement, si vous souhaitez vous assurer que le langage est bien installé et que tout fonctionne)
/*CREATE FUNCTION carre_plpgsql (integer) RETURNS integer AS '
    BEGIN
        RETURN $1 * $1;
    END;
' LANGUAGE 'plpgsql'; 
*/
-------------------------------------------------------------------------------------
/*
\echo [INFO] Création du langage perl sur la base de données
-- (il faut bien sûr que Perl soit installé sur le système Windows ou Linux que vous utilisez)
DROP FUNCTION carre_plperl(int4);
DROP LANGUAGE plperl;

CREATE TRUSTED LANGUAGE plperl;

-- Une fonction de test, pour vérifier que tout est bien installé:
CREATE FUNCTION carre_plperl (int4) RETURNS int4 AS '
  return $_[0] * $_[0]
' LANGUAGE 'plperl';
*/
\echo Fin du script
