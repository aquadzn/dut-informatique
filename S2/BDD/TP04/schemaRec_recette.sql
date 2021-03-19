-- ----------------------------------	--
-- SCHEMA DIET												--
-- objet : suivi diététique						--
-- création : 2016-02	version : V1.0	--
-- auteur : M. Lamolle								--
-- ----------------------------------	--

-- MISE EN PLACE du SCHEMA
drop schema if exists rec cascade;
create schema rec;
/*
drop table if exists rec.recette Cascade;
drop table if exists rec.Ingredient Cascade;
drop table if exists rec.TypePlat Cascade;
drop table if exists rec.Allergie Cascade;
drop table if exists rec.Abonne Cascade;
drop table if exists rec.necessiter Cascade;
drop table if exists rec.provoquer Cascade;
drop table if exists rec.avoir Cascade;
*/
------------------------------------------------------------
-- Table: Recette
------------------------------------------------------------
CREATE TABLE rec.Recette(
	idRect     SERIAL NOT NULL ,
	titre      VARCHAR (250)  ,
	note       INT2   ,
	image      VARCHAR (250)  ,
	nbPartMin  INT2   ,
	nbPartMax  INT2   ,
	cout       MONEY  ,
	tpsPrepa   TIME   ,
	tpsCuisson TIME   ,
	pays       VARCHAR (32)  ,
	niveau     VARCHAR (24)  ,
	calorie    INT2   ,
	gluten     BOOL   ,
	protide    INT2   ,
	lipide     INT2   ,
	glucide    INT2   ,
	fibre      INT2   ,
	textRec    text   ,
	conseil    text   ,
	categorie  VARCHAR (24)  ,
	idauteur   integer,
	CONSTRAINT prk_constraint_Recette PRIMARY KEY (idRect)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Ingredient
------------------------------------------------------------
CREATE TABLE rec.Ingredient(
	idIngr        SERIAL NOT NULL ,
	nomingredient VARCHAR (128) NOT NULL UNIQUE,
	portion       INT2   ,
	Protide       FLOAT   ,
	Lipide        FLOAT   ,
	Glucide       FLOAT   ,
	Calorie       FLOAT   ,
	na            FLOAT   ,
	k             FLOAT   ,
	ph            FLOAT   ,
	ca            FLOAT   ,
	MatGrass      FLOAT   ,
	VitC          FLOAT   ,
	VitB1         FLOAT   ,
	VitB2         FLOAT   ,
	VitPP         FLOAT   ,
	VitA          FLOAT   ,
	VitD          FLOAT   ,
	Eau           FLOAT   ,
	fibre         FLOAT   ,
	CONSTRAINT prk_constraint_Ingredient PRIMARY KEY (idIngr)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: TypePlat
------------------------------------------------------------
CREATE TABLE rec.TypePlat(
	categorie VARCHAR (24) NOT NULL ,
	CONSTRAINT prk_constraint_TypePlat PRIMARY KEY (categorie)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Allergie
------------------------------------------------------------
CREATE TABLE rec.Allergie(
	nomAllergie VARCHAR (32) NOT NULL ,
	CONSTRAINT prk_constraint_Allergie PRIMARY KEY (nomAllergie)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Abonne
------------------------------------------------------------
CREATE TABLE rec.Abonne(
	idabo        SERIAL NOT NULL ,
	nom          VARCHAR (32)  ,
	prenom       VARCHAR (32)  ,
	login        VARCHAR (128) NOT NULL UNIQUE,
	mot2pass     VARCHAR (32) NOT NULL UNIQUE,
	genre        BOOL   ,
	poids        FLOAT   ,
	taille       FLOAT   ,
	dateNais     DATE   ,
	TauxActivite VARCHAR (16)  ,
	CONSTRAINT prk_constraint_Abonne PRIMARY KEY (idabo)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: necessiter
------------------------------------------------------------
CREATE TABLE rec.necessiter(
	idRect   INT  NOT NULL ,
	idIngr   INT  NOT NULL ,
	quantite INT2   ,
	unite    varchar(32)   ,
	CONSTRAINT prk_constraint_necessiter PRIMARY KEY (idRect,idIngr)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: provoquer
------------------------------------------------------------
CREATE TABLE rec.provoquer(
	idIngr      INT  NOT NULL ,
	nomAllergie VARCHAR (32) NOT NULL ,
	CONSTRAINT prk_constraint_provoquer PRIMARY KEY (idIngr,nomAllergie)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: avoir
------------------------------------------------------------
CREATE TABLE rec.avoir(
	idabo       INT  NOT NULL ,
	nomAllergie VARCHAR (32) NOT NULL ,
	CONSTRAINT prk_constraint_avoir PRIMARY KEY (nomAllergie,idabo)
)WITHOUT OIDS;



ALTER TABLE rec.Recette ADD CONSTRAINT FK_Recette_categorie FOREIGN KEY (categorie) REFERENCES rec.TypePlat(categorie);
ALTER TABLE rec.Recette ADD CONSTRAINT FK_Recette_idauteur FOREIGN KEY (idauteur) REFERENCES rec.Abonne(idabo);
ALTER TABLE rec.necessiter ADD CONSTRAINT FK_necessiter_idRect FOREIGN KEY (idRect) REFERENCES rec.Recette(idRect);
ALTER TABLE rec.necessiter ADD CONSTRAINT FK_necessiter_idIngr FOREIGN KEY (idIngr) REFERENCES rec.Ingredient(idIngr);
ALTER TABLE rec.provoquer ADD CONSTRAINT FK_provoquer_idIngr FOREIGN KEY (idIngr) REFERENCES rec.Ingredient(idIngr);
ALTER TABLE rec.provoquer ADD CONSTRAINT FK_provoquer_nomAllergie FOREIGN KEY (nomAllergie) REFERENCES rec.Allergie(nomAllergie);
ALTER TABLE rec.avoir ADD CONSTRAINT FK_avoir_nomAllergie FOREIGN KEY (nomAllergie) REFERENCES rec.Allergie(nomAllergie);
ALTER TABLE rec.avoir ADD CONSTRAINT FK_avoir_idabo FOREIGN KEY (idabo) REFERENCES rec.Abonne(idabo);

