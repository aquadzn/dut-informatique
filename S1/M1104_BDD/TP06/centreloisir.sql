/************************************************************
** BASE DE DONNEES CENTRE LOISIR Arthur Ashe
** Auteur : M. Lamolle
** Version : 1.0 date : 2020
************************************************************/
drop schema if exists centre cascade ;
create schema centre ;
-- DROP TABLE centre.gain;
-- DROP TABLE centre.rencontre;
-- drop table centre.membre;

-- Table: "MEMBRE"
CREATE TABLE centre.membre (
  idMem int,
  nom varchar(32) NOT NULL,
  prenom varchar(32),
  adresse text,
  parrain int,
  datArriv date,
  CONSTRAINT pk_membre PRIMARY KEY (idMem),
  constraint fk_membre_parrain foreign key (parrain) references centre.membre (idmem)
) ;

-- Table: "EQUIPEMENT"
CREATE TABLE centre.equipement (
  idEqt int,
  nom varchar(32) NOT NULL,
  prixMembre float,
  prixInvite float,
  coutInitial int,
  coutentretienMateriel int,  
  CONSTRAINT pk_rencontre PRIMARY KEY (idEqt)
);

-- Table: "RESERVER"
CREATE TABLE centre.reserver (
  idEqt int,
  idMem int,
  datDebut date,
  duree time,
  CONSTRAINT pk_reserver PRIMARY KEY (idEqt, idMem, datDebut),
  constraint fk_reserver_equipement foreign key (idEqt) references centre.equipement (idEqt),
  constraint fk_reserver_membre foreign key (idMem) references centre.membre (idMem)  
)  ;


-- INSERTION DES TUPLES
-- MEMBRE
insert into centre.membre values (104, 'FONT', 'Henry', 'Fontenay', null, '2012-09-17 12:27:15');
insert into centre.membre values (105, 'PUR', 'Anne','Montreuil', null, '2012-09-18 19:04:01');
insert into centre.membre values (106, 'TUPE', 'Marie', 'Montreuil', null, '2012-08-18 19:32:05');
insert into centre.membre values (100, 'SAR', 'Ramna', 'Paris', 105, '2012-10-02 18:43:05');
insert into centre.membre values (103, 'FARE', 'David', 'Paris', 100, '2012-10-15 08:22:05');
insert into centre.membre values (108, 'CROS', 'Erica', 'Montreuil', 103, '2012-09-22 08:36:38');  


insert into centre.membre values (101, 'JON', 'Doug', 'Paris', 106, '2012-09-02 18:43:05');
insert into centre.membre values (102, 'RUM', 'Henri', 'Montreuil', 106, '2012-09-05 08:42:35');

insert into centre.membre values (107, 'NIC', 'Jean', 'Nogent', 106, '2012-09-19 11:32:45'), 
(1000, 'invité', 'invité', null, 105, null) ;

-- EQUIPEMENT
insert into centre.equipement values (0, 'Court Tennis 1', 5, 25, 10000, 200), 
(1, 'Court Tennis 2', 5, 25, 8000, 200), 
(2, 'Court badminton', 0, 15.5, 4000, 50), 
(3, 'Tennis de table', 0, 5, 320, 10),
(4, 'Sauna 1', 35, 80, 4000, 3000), 
(5, 'Sauna 2', 35, 80, 4000, 3000), 
(6, 'Court Squash', 3.5, 10.5, 5000, 80), 
(7, 'Billard Snooker', 0, 5, 450, 15), 
(8, 'Billard', 0, 5, 400, 15) ;

-- RESERVER
insert into centre.reserver values (0, 108, '2012-10-02 18:00:00', '01:00:00'), 
(1, 105, '2012-10-02 18:00:00', '01:00:00'), 
(0, 108, '2012-10-05 08:30:00', '01:00:00'),
(1, 105, '2012-10-15 09:00:00', '01:00:00'), 
(7, 104, '2012-10-17 12:30:00', '01:30:00'), 
(8, 107, '2012-10-18 19:00:00', '01:00:00'), 
(4, 101, '2012-09-18 19:30:00', '00:20:00'),
(0, 100, '2012-10-19 11:00:00', '01:00:00'), 
(1, 108, '2012-09-22 09:00:00', '01:00:00'), 
(6, 106, '2012-09-02 18:00:00', '00:30:00') ;

-- FIN SCRIPT

