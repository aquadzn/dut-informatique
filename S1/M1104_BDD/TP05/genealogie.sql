/************************************************************
** BASE DE DONNEES GENEALOGIE
** Auteur : M. Lamolle
** Version : 1.0 date : 2013
************************************************************/
drop schema if exists genealogie cascade ;
create schema genealogie;
-- DROP TABLE genealogie.personne;
-- DROP TABLE genealogie.parents;
-- DROP TABLE genealogie.ecoles;

-- Table: "PERSONNE"
CREATE TABLE genealogie.personne (
  pers varchar(32) NOT NULL,
  age int4,
  genre varchar(1),
  CONSTRAINT pk_pers PRIMARY KEY (pers),
  constraint ck_genre check (genre in ('F', 'M'))
)  ;

-- Table: "PARENTS"
CREATE TABLE genealogie.parents (
  parent varchar(32) NOT NULL,
  enfant varchar(32),
  CONSTRAINT pk_parent PRIMARY KEY (parent, enfant)
) ;

-- Table: "ECOLES"
CREATE TABLE genealogie.ecoles (
  enfant varchar(32) NOT NULL,
  ecole varchar(32),
  CONSTRAINT pk_enfant PRIMARY KEY (enfant)
);

/************************************************************/
-- INSERTION DE DONNEES
insert into genealogie.personne values ('Michel_P1', 45, 'M');
insert into genealogie.personne values ('Michel_M1', 45, 'F');
insert into genealogie.personne values ('Michel_P2', 46, 'M');
insert into genealogie.personne values ('Michel_M2', 46, 'F');
insert into genealogie.personne values ('Michel', 25, 'M');
insert into genealogie.personne values ('Micheline', 24, 'F');
insert into genealogie.personne values ('Michelle', 25, 'F');
insert into genealogie.personne values('Jean-Michel', 2, 'M');

insert into genealogie.personne values ('Jacques', 5, 'M');
insert into genealogie.personne values ('Jacques_P1', 35, 'M');
insert into genealogie.personne values ('Jacques_M1', 35, 'F');
insert into genealogie.personne values ('F1_Jacques_P1', 33, 'M');
insert into genealogie.personne values ('F1_Jacques_M1', 33, 'M');
insert into genealogie.personne values ('S1_Jacques_P1', 31, 'F');
insert into genealogie.personne values ('Jacques_GP1_P1', 65, 'M');
insert into genealogie.personne values ('Jacques_GM1_M1', 65, 'F');
insert into genealogie.personne values ('Jacques_GP2_P1', 66, 'M');
insert into genealogie.personne values ('Jacques_GM2_M1', 66, 'F');

insert into genealogie.personne values ('Pierre_P1', 40, 'M'), ('Pierre_M1', 42, 'F');
insert into genealogie.personne values ('Pierre', 10, 'M'), ('Pierrette', 8, 'F'), ('Pierrick', 6, 'M');
insert into genealogie.personne values ('Anne_P1', 40, 'M'), ('Anne_M1', 42, 'F');
insert into genealogie.personne values ('Anne', 10, 'F'), ('Annette', 8, 'F'), ('Annick', 6, 'F');


-- leurs parents
insert into genealogie.parents values ('Michel_P1', 'Michel');
insert into genealogie.parents values ('Michel_M1', 'Michel');
insert into genealogie.parents values ('Michel_P1', 'Micheline');
insert into genealogie.parents values ('Michel_M1', 'Micheline');
insert into genealogie.parents values ('Michelle_P2', 'Michelle');
insert into genealogie.parents values ('Michelle_M2', 'Michelle');
insert into genealogie.parents values ('Michel', 'Jean-Michel');
insert into genealogie.parents values ('Michelle', 'Jean-Michel');

insert into genealogie.parents values ('Jacques_P1', 'Jacques');
insert into genealogie.parents values ('Jacques_M1', 'Jacques');
insert into genealogie.parents values ('Jacques_GP1_P1', 'Jacques_P1');
insert into genealogie.parents values ('Jacques_GM1_P1', 'Jacques_P1');
insert into genealogie.parents values ('Jacques_GP2_M1', 'Jacques_M1');
insert into genealogie.parents values ('Jacques_GM2_M1', 'Jacques_M1');
insert into genealogie.parents values ('Jacques_GP1_P1', 'F1_Jacques_P1');
insert into genealogie.parents values ('Jacques_GM1_P1', 'F1_Jacques_P1');
insert into genealogie.parents values ('Jacques_GP1_P1', 'S1_Jacques_P1');
insert into genealogie.parents values ('Jacques_GM1_P1', 'S1_Jacques_P1');
insert into genealogie.parents values ('Jacques_GP2_M1', 'F1_Jacques_M1');
insert into genealogie.parents values ('Jacques_GM2_M1', 'F1_Jacques_M1');

insert into genealogie.parents values ('Pierre_P1', 'Pierre'), ('Pierre_M1', 'Pierre');
insert into genealogie.parents values ('Pierre_P1', 'Pierrette'), ('Pierre_M1', 'Pierrette');
insert into genealogie.parents values ('Pierre_P1', 'Pierrick'), ('Pierre_M1', 'Pierrick');

insert into genealogie.parents values ('Anne_P1', 'Anne'), ('Anne_M1', 'Anne');
insert into genealogie.parents values ('Anne_P1', 'Annette'), ('Anne_M1', 'Annette');
insert into genealogie.parents values ('Anne_P1', 'Annick'), ('Anne_M1', 'Annick');

-- les écoles
insert into genealogie.ecoles values ('Jean-Michel', 'Fontenay');
insert into genealogie.ecoles values ('Jacques', 'Paris');
insert into genealogie.ecoles values ('Pierre', 'Montreuil');
insert into genealogie.ecoles values ('Pierrette', 'Montreuil');
insert into genealogie.ecoles values ('Pierrick', 'Montreuil');
insert into genealogie.ecoles values ('Anne', 'Montreuil');
insert into genealogie.ecoles values ('Annette', 'Paris');
insert into genealogie.ecoles values ('Annick', 'Fontenay');




