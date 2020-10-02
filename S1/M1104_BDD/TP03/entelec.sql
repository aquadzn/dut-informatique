-- -------------------------------------------------------- --
-- SCHEMA RELATIONNEL : gestion entreprise électrique       --
-- auteurs : M. Lamolle, T. Roberjot, H. Hongois, F. Thaveau--
-- version : 1.1											--
-- date création : 2014										--
-- date dernière modification : 2018						--
-- -------------------------------------------------------- --

drop schema entelec cascade;
create schema entelec;

-- création de Client
create table entelec.Client (idClt int, nomClt varchar(32), prenom varchar(32), rue varchar(128), cp int, ville varchar(64), pays varchar(64),constraint pk_entelec_idClt primary key (idClt));

-- table Qualification
create table entelec.Qualification (
idQualif varchar(8), 
intitule varchar(128), 
nbheureMois int, 
coutMensuel float, 
coutHoraire float,
constraint pk_idQualif primary key (idQualif));

-- table Habilitation
create table entelec.Habilitation (idHabit int, titre varchar(16),
constraint pk_idHabit primary key (idHabit));

-- table contrat
create table entelec.Contrat (idContrat int, libelle varchar(128), duree varchar(32), dateDeb date,dateFin date,
constraint pk_idContrat primary key (idContrat) );

-- table personnel
create table entelec.Personnel (idPers int, nom varchar (32), prenom varchar (32), salaire int, idContrat int,
constraint pk_idPers primary key (idPers),
constraint fk_personnel_contrat foreign key (idContrat) references entelec.contrat (idcontrat) );



--Table: "ABSENCE"

CREATE TABLE entelec.Absence(idAbs int not null,typAbs varchar(20) not null, dateDeb date,datFin date,idPers int not null,
constraint pk_abscenceAbs primary key(idAbs),
constraint pk_abscencePers foreign key(idPers) references entelec.Personnel (idPers));

-- création de AvoirQualif--
create table entelec.AvoirQualif(idPers int, idQualif varchar(8), 
constraint pk_AvoirQualif primary key (idPers, idQualif),
constraint fk_AvoirQualif_Personnel foreign key (idPers) references entelec.Personnel (idPers),
constraint fk_AvoirQualif_Qualification foreign key (idQualif) references entelec.Qualification (idQualif));

-- création de AvoirHabilit--
create table entelec.AvoirHabilit(idPers int, idHabit int, 
constraint pk_AvoirHabilit primary key (idPers, idHabit),
constraint fk_AvoirHabilit_habilitation foreign key (idHabit) references entelec.Habilitation (idHabit));

-- création de Chantier
create table entelec.Chantier (idCht int,intitule varchar (128), description varchar(248), dateDeb date , dateFin date, dureePrevu varchar (64), rue varchar(128), cp int, ville varchar(64), pays varchar(64), idClt int, constraint pk_entelec_idCht primary key (idCht),constraint fk_entelec_idClt foreign key (idClt) references entelec.Client (idClt));

-- Table: "AFFECTER"

CREATE TABLE entelec.Affecter (
idPers integer not null,
idCht integer not null,
constraint pk_affecter PRIMARY KEY(idPers,idCht),
constraint pk_affecterPers foreign key(idPers) references entelec.Personnel (idPers),
constraint pk_affecterCht foreign key(idCht) references entelec.Chantier (idCht));

-- insert Client *10 .
-- attributs = idClt, nomClt, prenomClt, rue, cp, ville, pays
insert into entelec.Client values (01,'Pokemon','Pikachu','rue DuBuisson',00717,'Bourg Palette','kanto');
insert into entelec.Client values (02,'Transistor','Mos','rue DuRadin',00000,'STI2D','Lycee');
insert into entelec.Client values (03,'Silver','Surfer','rue Spaceways' , 45689, 'acoteDePluton', 'systeme Deneb');
insert into entelec.Client values (04,'La','Chose','rue DuCaillou',99999, 'ToujoursDansLeCaillou','PayDuCaillou');
insert into entelec.Client values (05,'WAS','JaVoll','rue Stalingrad', 66666, 'Berlin','PayDuSoleilLevant');

insert into entelec.Client values (06,'Pokemon','Salamech','rue DuBuisson',00717,'Bourg Palette','kanto');
insert into entelec.Client values (07,'Hooves','Derpy','Muffing street',54136,'ponyville','equestria');
insert into entelec.Client values (08,'Dash','Rainbow','Rainbow street',95416,'cloudsdale','equestria');
insert into entelec.Client values (09,'LePetitBonhome','EnMousse','rue de la mousse', 44444, 'CaMousse','Beaucoup');
insert into entelec.Client values (10,'Homps','Marc','rue tropbien', 31415, 'Montreuil','France');


--insert Qualification
insert into entelec.Qualification values 
('OE1','Classif-Qualif Bâtiment / Ouvrier Exécution niv. I pos. 1 coef 150',150,1258.86,8.30), 
('OE2','Classif-Qualif Bâtiment / Ouvrier Exécution niv. I pos. 2 coef 170',170,1274.03,8.40),
('OP','Classif-Qualif Bâtiment / Ouvrier Profess. niv.II coef 185',185,1425.70,9.40),
('CP1','Classif-Qualif Bâtiment / Compagnon Profess. niv. III pos. 1 coef 210',210,1577.37,10.40),
('CP2','Classif-Qualif Bâtiment / Compagnon Profess. niv. III pos. 2 coef 230',230,1645.62,10.85),
('CE1','Classif-Qualif Bâtiment / Chef Equipe niv. IV pos. 1 coef 250',250,1751.79,11.55), 
('CE2','Classif-Qualif Bâtiment / Chef Equipe niv. IV pos. 2 coef 270',270,1895.88,12.50),
('ETAMA','Classif-Qualif Bâtiment / ETAM niv. A',240,1354.65,16.45),
('ETAMB','Classif-Qualif Bâtiment / ETAM niv. B',290,1732.27,18.72),
('A', 'Classif-Qualif Bâtiment / Ingénieur ou assimilé débutant pos. A', 135,1358.55,10.50);


--insert Habilitation
insert into entelec.Habilitation values
(01, 'B0T'),
(02, 'H2V'),
(03, 'BCX'),
(04, 'BPN'),
(05, 'H1X'),
(06, 'BST'),
(07, 'H0V'),
(08, 'BET'),
(09, 'HRX'),
(10, 'HSX');

--insert Contrat--
insert into entelec.Contrat (idContrat,libelle,duree,dateDeb,dateFin) values ('1','remise aux normes des prises électriques','CDD','2002-06-10','2008-06-10'),('2','installation domotique','CDI','2002-06-10',null),('3','rénovation du système électrique','CDD','2003-06-10','2009-06-10'),('4','administration technique','CDI','2003-06-10',null),('5','responsable logistique','CDD','2004-06-10','2008-06-10'),('6','technicien électronique','CDI','2004-06-10',null),('7','ingénierie électrique','CDD','2005-06-10','2008-06-10'),('8','rénovation bâtiments','CDI','2005-06-10',null),('9','installation structure','CDD','2006-06-10','2008-06-10'),('10','technicien de surface','CDI','2006-06-10',null);

--insert Personnel--
insert into entelec.Personnel values ('1','James','Jesse','1380', 6),('2','Jane','Calamity','1750', 10),('3','Skywalker','Luke','1000', 4),('4','Skywalker','Anakin','1200', 3),('5','Wookie','Chewbacca','1500', 1),('6','Princesse','Leïa','1300', null),('7','Darc','Jeanne','2000', null),('8','Flam','Capitaine','1200', null),('9','Curie','Marie','2000', null),('10','Plombier','Mario','1450', 9), ('11', 'Lagaffe', 'Gaston', '1000', 1);

-- Insertions pour la table abscence--

INSERT INTO entelec.Absence (idAbs, typAbs, dateDeb, datFin,idPers)
	VALUES(1,'Congé maternité',null,null,1);
INSERT INTO entelec.Absence (idAbs, typAbs, dateDeb, datFin,idPers)
	VALUES(2,'maladie',null,null,10);
INSERT INTO entelec.Absence (idAbs, typAbs, dateDeb, datFin,idPers)
	VALUES(3,'maladie',null,null,7);
INSERT INTO entelec.Absence (idAbs, typAbs, dateDeb, datFin,idPers)
	VALUES(4,'Accident de travail',null,null,5);
INSERT INTO entelec.Absence (idAbs, typAbs, dateDeb, datFin,idPers)
	VALUES(5,'Arrêt de travail',null,null,1);
INSERT INTO entelec.Absence (idAbs, typAbs, dateDeb, datFin,idPers)
	VALUES(6,'Formation',null,null,8);
INSERT INTO entelec.Absence (idAbs, typAbs, dateDeb, datFin,idPers)
	VALUES(7,'Congé parental',null,null,4);
INSERT INTO entelec.Absence (idAbs, typAbs, dateDeb, datFin,idPers)
	VALUES(8,'retard non excusé',null,null,3);
INSERT INTO entelec.Absence (idAbs, typAbs, dateDeb, datFin,idPers)
	VALUES(9,'problème transport',null,null,3);
INSERT INTO entelec.Absence (idAbs, typAbs, dateDeb, datFin,idPers)
	VALUES(10,'Passage du permis',null,null,10);


-- Insertions pour la table AvoirQualif--
INSERT INTO entelec.AvoirQualif values(02,'OE2');
INSERT INTO entelec.AvoirQualif values(04,'CP1');
INSERT INTO entelec.AvoirQualif values(06,'CE1');
INSERT INTO entelec.AvoirQualif values(07,'CE2');
INSERT INTO entelec.AvoirQualif values(08,'ETAMA');
INSERT INTO entelec.AvoirQualif values(09,'ETAMB');
INSERT INTO entelec.AvoirQualif values(10,'A');


--Insertions pour la table AvoirHabilit--
INSERT INTO entelec.AvoirHabilit values(01,1);
INSERT INTO entelec.AvoirHabilit values(03,1);
INSERT INTO entelec.AvoirHabilit values(05,3);
INSERT INTO entelec.AvoirHabilit values(07,4);
INSERT INTO entelec.AvoirHabilit values(08,5);
INSERT INTO entelec.AvoirHabilit values(09,6);
INSERT INTO entelec.AvoirHabilit values(10,7);


-- insert Chantier *10 .
--dCht, intitule, description, dateDeb, dateFin, dureePrevu, rue, cp, ville, pays,#idClt
insert into entelec.Chantier values (01,'étoile de la mort', 'ça tue à mort' , '1020-02-02', '4020-02-02', '20 ans', 'DarkWay', 99999, 'CaTueCity', 'DansLesEtoiles',05);
insert into entelec.Chantier values (02,'Château Fort', 'solide', '1200-02-02', '1250-02-02', '30 ans', 'rue MonFort', 45455,' Lyon', 'France', 09);
insert into entelec.Chantier values (03,'Building', 'grand', '2012-02-02', '2015-03-04','10 ans','rue Stalingrad', 66666, 'Berlin', 'PayDuSoleilLevant', 05);
insert into entelec.Chantier values (04,'Pont','utile', '1995-02-05', '2000-09-09', '2 ans', 'rue Hoche', 95310, 'Paris', 'France', 01);
insert into entelec.Chantier values (05,'SuperMarché','tropbien', '2100-12-05', '2112-12-02', '50 ans',' rue CaBuy', 89898, 'DepensLand', 'Suisse', 10);

insert into entelec.Chantier values (06,'Parc', 'lol', '1452-02-03', '1520-12-13', '50 ans', 'rue LOL', 78954, 'TROLOL', 'PatDuTroll', 06);
insert into entelec.Chantier values (07,'Café muffing', 'ça roxx du poney', '2010-10-10', '2014-09-11','3 ans', 'Muffing street',54136,'ponyville','equestria',07);
insert into entelec.Chantier values (08,'rainbow cascade', 'ça roxx du poney', '2010-10-10', '2014-09-11','3 ans','Rainbow street',95416,'cloudsdale','equestria',08);
insert into entelec.Chantier values (09,'Local STI',' aight', '2013-02-01', '2015-02-02',' 2 ans', 'Rue Transistor', 77940, 'Mos', 'France', 02);
insert into entelec.Chantier values (10,'Planète', 'très grand', '2015-12-12', '2090-02-10', '40 ans', 'rue DuSurfer',89899, 'SilverWay', 'SilverLand',03);


-- Insertions pour la table Affecter--

INSERT INTO  entelec.Affecter (idPers,idCht)
	VALUES(1, 1);
INSERT INTO  entelec.Affecter (idPers,idCht)
	VALUES(1, 2);
INSERT INTO  entelec.Affecter (idPers,idCht)
	VALUES(2, 1);
INSERT INTO  entelec.Affecter (idPers,idCht)
	VALUES(2, 2);
INSERT INTO  entelec.Affecter (idPers,idCht)
	VALUES(3, 7);
INSERT INTO  entelec.Affecter (idPers,idCht)
	VALUES(3, 5);
INSERT INTO  entelec.Affecter (idPers,idCht)
	VALUES(4, 5);
INSERT INTO  entelec.Affecter (idPers,idCht)
	VALUES(7, 8);
INSERT INTO  entelec.Affecter (idPers,idCht)
	VALUES(8, 5);
INSERT INTO  entelec.Affecter (idPers,idCht)
	VALUES(10, 5);
	

