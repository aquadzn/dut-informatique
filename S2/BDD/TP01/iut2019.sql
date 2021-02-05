/* -----------------------------------------------------------------------
BASE de DONNEES : IUT
Version : 2.0
Auteur : Myriam Lamolle
Date création : 10/10/2009
Révision : 01/09/2019 tenant compte du PPN2013 et des nouveaux enseignants
------------------------------------------------------------------------- */
/* Essai de BD SQL.*/
create schema if not exists iut;
SET search_path TO iut;

drop table if exists notes cascade ; -- CASCADE car objet VIEW, etc. possible pour ma BD
drop table if exists interro cascade ;
drop table if exists module cascade ;
drop table if exists personnel cascade ;
drop table if exists enseignant cascade ;
drop table if exists etudiant cascade ;
drop table if exists interrogation cascade ;
drop table if exists departement ;

create table departement (idDept varchar(12), titre varchar(64), 
	constraint pk_departement PRIMARY KEY (idDept)
);

create table personnel (
	idPers INT,
	nom VARCHAR(32),
	prenom VARCHAR(32),
	fonction varchar(64),
	idDept varchar(12),
	constraint pk_personnel PRIMARY KEY (idPers),
    constraint fk_personnel_departement FOREIGN KEY (idDept) REFERENCES departement (idDept)
      
);

create table enseignant (
	idEns INT,
	nom VARCHAR(32) ,
	prenom VARCHAR(32) ,
	titulaire boolean default true,
	idDept varchar(12),
    constraint pk_enseignant PRIMARY KEY (idEns),
    constraint fk_enseignant_departement FOREIGN KEY (idDept) REFERENCES departement (idDept)
);

create table etudiant (
	idEtud INT,
	nom VARCHAR(32),
	prenom VARCHAR(32),
	classe VARCHAR(12),
    constraint pk_etudiant PRIMARY KEY (idEtud),
	constraint cc_classe check (classe in ('S1', 'S2', 'S3', 'S4', 's1', 's2', 's3', 's4','CIM', 'cim', 'CSID', 'csid', 'CAPE', 'cape', 'Ecommerce'))
);

create table module (
	refMod varchar(8),
	intitule VARCHAR(128),
 	classe VARCHAR(12),
	coef float,
	volHoraireCM int default 0,
	volHoraireTD int,
	volHoraireTP int,
	idEns INT,
      constraint pk_module PRIMARY KEY (refMod),
	constraint fk_module_enseignant foreign key (idEns) references enseignant (idEns),
constraint cc_classe check (classe in ('S1', 'S2', 'S3', 'S4', 's1', 's2', 's3', 's4','CIM', 'cim', 'CSID', 'csid', 'CAPE', 'cape', 'Ecommerce'))
);

create table interro (
	idInter INT,
	refMod varchar(6),
	coefInterro FLOAT DEFAULT 1,
    constraint pk_interro PRIMARY KEY (idInter),
	constraint fk_interro_module foreign key (refMod) references module (refMod)
);

create table notes (
	idInter INT,
	idEtud INT,
	note FLOAT(2),
	constraint pk_notes PRIMARY KEY (idInter, idEtud),
	constraint fk_notes_etudiant foreign key (idEtud) references etudiant (idEtud),
	constraint fk_notes_interro foreign key (idInter) references interro (idInter)
);

-- table departement
insert into departement VALUES ('INFO', 'Informatique'), 
	('QLIO', 'Qualité, Logistique Industrielle et Organisation'), 
	('INFOCOM', 'Information et Communication'), 
	('GACO', 'Gestion des Administrations et Commerce');

-- table personnel
insert into personnel (idPers, nom, prenom, fonction) VALUES 
	(1, 'Boulanger', 'Max', 'Directeur'),
	(2, 'Flauraud','Khamphou', 'Responsable d''administration'),
	(3, 'Hassoun', 'Abdallah', 'Responsable CCRI'),
	(4, 'Filoche','Eddy', 'Responsable Hygiène et Sécurité'),
	(30, 'Kamal','Rachida', 'Chargé de mission');

insert into personnel (idPers, nom, prenom, fonction, idDept) VALUES 
	(6, 'Bayoud','Khadija', 'Secrétaire Informatique', 'INFO'),
	(7, 'Lamolle','Myriam', 'Cheffe de département', 'INFO'),
	(200, 'Dafaoui','El Mouloudi', 'Chef de département', 'QLIO'),	
	(300, 'Baboulall','Marielle', 'Cheffe de département', 'GACO'),
	(400, 'Kaiser','Marc', 'Chef de département', 'INFOCOM'),
	(15, 'Bonnot','Philippe', 'Directreur des études 1A','INFO'),
	(10, 'Ricordeau', 'Anne', 'Responsable Apprentissage DUT', 'INFO'),
	(11, 'Georges','Rémi', 'Responsable stage','INFO'),
	(19, 'Cataldi','Mario', 'Responsable licence prof. CIM', 'INFO'),
	(5, 'Rety','Jean-Hugues', 'Responsable licence prof. CSID','INFO'),
	(14, 'Emonides','Mireille', 'Responsable Contrat Apprentissage', 'INFO');


-- table enseignant
insert into enseignant (idEns, nom, prenom, iddept) VALUES 
	(5, 'Rety', 'Jean-Hugues','INFO'),
	(7, 'Lamolle','Myriam','INFO'),
	(8, 'Homps','Marc','INFO'),
	(9, 'Simonot','Marianne','INFO'),
	(10, 'Ricordeau', 'Anne','INFO'),
	(11, 'Georges','Rémi','INFO'),
	(12, 'Delmas','Guylain','INFO'),
	(13, 'Nauwynck','Nédra','INFO'),
	(15, 'Bonnot','Philippe','INFO'),
	(16, 'Clément-Comparot','Véronique','INFO'),
	(17, 'Le Duc','Chan','INFO'),
	(18, 'Bossard','Aurélien','INFO'),
	(19, 'Cataldi','Mario','INFO'),
	(20, 'Golven', 'Amélie','INFO'),
	(21, 'Ballay-Dally', 'Charlotte', 'QLIO'), 
	(23, 'Groff', 'Geoffrey','INFO') ;

insert into enseignant values 
	(22, 'Chebbi', 'Imen', 'f'), 
	(24, 'Tobbelem', 'Jocelin', 'f'), 
	(25, 'Mockel', 'Mehdi', 'f'), 
	(26, 'Mourel', 'Frédéric', 'f'), 
	(27, 'Nyzam', 'Valentin', 'f'),
	(30, 'Kamal','Rachida', 'f') ;

-- table etudiant
insert into etudiant (idEtud, nom, prenom, classe) VALUES 
(1, 'Turing','Alan', 'S3'), (2, 'Lovelace', 'Ada', 'S3'), (3, 'Baggage', 'Charles', 'S3'),
(6, 'Berry', 'Gérard', 'S3'), (8, 'Berner-Lee', 'Tim', 'S1');
insert into etudiant (idEtud, nom, prenom, classe) VALUES 
(4, 'Meyer', 'Bertrand', 'S1'), (5, 'Wirth', 'Niklaus', 'S1'), (7, 'TALON', 'Achille', 'S1');

-- table module[refmod, intitule, classe, coef, volHoraireCM, volHoraireTD, volHoraireTP, idens]
-- idEns représente le responsable du module
insert into module VALUES 
	('M1101', 'Introduction aux systèmes informatiques', 'S1', '3.5', 10, 20, 30, 12),
	('M1102', 'Introduction à l''algorithmique et à la programmation', 'S1', '3.5', 10, 20, 30, 5),
	('M1103', 'Structures de données et algorithmes fondamentaux', 'S1', '2.5', 10, 15, 20, 5),
	('M1104', 'Introduction aux bases de données', 'S1', '3.5', 10, 25, 25, 7),
	('M1105', 'Conception de documents et d''interfaces numériques', 'S1', '2.5', 0, 20, 25, 5),
	('M1106', 'Projet Tutoré - Découverte', 'S1', '1.5', 0, 0, 0, 5);
insert into module VALUES 
	('M1201', 'Mathématiques discrètes', 'S1', '2.5', 10, 18, 17, 8),
	('M1202', 'Algèbre linéaire', 'S1', '2.0', 6, 12, 12, 15),	
	('M1203', 'Environnement économique', 'S1', '1.5', 10, 10, 10, 16),
	('M1204', 'Fonctionnement des organisations', 'S1', '2.5', 10, 20, 15, 15),	
	('M1205', 'Expression communication - Fondamentaux de la communication', 'S1', '2.0', 0, 15, 15, 20),	
	('M1206', 'Anglais et Informatique', 'S1', '1.5', 0, 15, 15, 20),
	('M1207', 'PPP - Connaître le monde professionnel', 'S1', '1.0', 0, 10, 10, 20);	

insert into module VALUES 
	('M2101', 'Architecture et programmation des mécanismes de base d''un système informatique', 'S2', '1.5', 8, 10, 12, 17),
	('M2102', 'Architecture des réseaux', 'S2', '1.5', 8, 10, 12, 12),
	('M2103', 'Base de la programmation orientée objet', 'S2', '3.5', 10, 20, 30, 5),
	('M2104', 'Base de la conception orientée objet', 'S2', '2.5', 10, 15, 20, 9),
	('M2105', 'Introduction aux interfaces Homme-Machine (IHM)', 'S2', '2.5', 10, 15, 20, 5),
	('M2106', 'Programmation et administration des bases de données', 'S2', '2.5', 10, 15, 20, 7),
	('M2107', 'Projet tutoré - Description et planification de projet', 'S2', '2.0', 0, 0, 0, 11);
insert into module VALUES 
	('M2201', 'Graphes et langages', 'S2', '2.5', 11, 16, 18, 8),
	('M2202', 'Anlyse et méthodes numériques', 'S2', '2.0', 8, 12, 10, 15),	
	('M2203', 'Environnement comptable, financier, juridique et social', 'S2', '3.0', 12, 18, 15, 16),
	('M2204', 'Gestion de projet informatique', 'S2', '1.5', 8, 12, 10, 11),	
	('M2205', 'Expression-Communication - Communication, information et argumentation', 'S2', '1.5', 0, 15, 15, 20),	
	('M2206', 'Communiquer en anglais', 'S2', '2.5', 0, 23, 22, 20),
	('M2207', 'PPP - Identifier ses compétences', 'S2', '1.0', 0, 10, 10, 20);

insert into module VALUES 
	('M3101', 'Principe des systèmes d''exploitation', 'S3', '2.5', 15, 14, 16, 17),
	('M3102', 'Services réseaux', 'S3', '1.5', 8, 10, 12, 13),
	('M3103', 'Algorithmique avancée', 'S3', '1.5', 8, 10, 12, 5),
	('M3104', 'Programmation Web côté serveur', 'S3', '2.5', 15, 14, 16, 18),
	('M3105', 'Conception et programmation objet avancées', 'S3', '2.5', 15, 14, 16, 9),
	('M3106C', 'Bases de données avancées', 'S3', '1.5', 8, 10, 12, 7);
insert into module VALUES 
	('M3201', 'Probabilités et statistiques', 'S3', '2.5', 15, 16, 14, 8),
	('M3202C', 'Modélisations mathématiques', 'S3', '1.5', 0, 16, 14, 10),	
	('M3203', 'Droit des technologies de l''information et de la communication (TIC)', 'S3', '1.5', 10, 10, 10, 16),
	('M3204', 'Gestion des systèmes d''information', 'S3', '2.5', 15, 15, 15, 7),	
	('M3205', 'Expression-Communication - Communication, professionnelle', 'S3', '1.5', 0, 15, 15, 20),	
	('M3206', 'Collaborer en anglais', 'S3', '2.5', 0, 23, 22, 20);
insert into module VALUES 
	('M3301', 'Méthodologies de la production d''applications', 'S3', '3.0', 14, 22, 24, 11),
	('M3302', 'Projet tutoré - Mise en situation professionnelle', 'S3', '2.0', 0, 0, 0, 11),
	('M3303', 'PPP - Préciser son projet', 'S3', '1.0', 0, 10, 10, 20)	;

-- MODULES OPTIONNELS
insert into module VALUES ('M4101', 'XML', 'S4', '2.0', 0, '30', '0', 7);

-- table interro (6 tuples)
insert into interro VALUES (1,'M1201');
insert into interro VALUES (2,'M1104');
insert into interro VALUES (3,'M1203');
insert into interro VALUES (4,'M3103');
insert into interro VALUES (5,'M3104');
insert into interro VALUES (6,'M3106C');

-- table notes (12 tuples)
insert into notes VALUES (1, 4, 12);
insert into notes VALUES (1, 5, 13);
insert into notes VALUES (2, 4, 14);
insert into notes VALUES (2, 5, 9);
insert into notes VALUES (3, 1, 12);
insert into notes VALUES (3, 2, 16);
insert into notes VALUES (3, 3, 10);
insert into notes VALUES (4, 4, 12);
insert into notes VALUES (4, 5, NULL);
insert into notes VALUES (5, 4, 8);
insert into notes VALUES (5, 5, 12);
insert into notes VALUES (6, 4, 8);





