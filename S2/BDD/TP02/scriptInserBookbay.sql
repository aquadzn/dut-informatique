/* ----------------------------------
-- SCHEMA BOOKBAY 
-- insertion des données
-- version : 1.0
-- ----------------------------------*/
DELETE FROM bookbay.recompense_par;
DELETE FROM bookbay.entrepose;
DELETE FROM bookbay.ecrit_par;
DELETE FROM bookbay.livres;
DELETE FROM bookbay.imprime;
DELETE FROM bookbay.collections;
DELETE FROM bookbay.entrepots;
DELETE FROM bookbay.distinctions;
DELETE FROM bookbay.auteurs;
DELETE FROM bookbay.imprimeurs;

-- Pour que l'insertion des dates se fasse sans problème, elles doivent avoir le format jour-mois-année:
SET DATESTYLE to DMY;

-- Données de la table editions

INSERT INTO bookbay.editions (code_editions,nom,adresse,code_postal,ville,nombre_employes,email_contact,date_creation)
VALUES (7460,'ENI Editions','Rue Franklin',44800,'Saint-Herblain',150,'editions@edieni.com','01-01-1981');

INSERT INTO bookbay.editions (code_editions,nom,adresse,code_postal,ville,nombre_employes,email_contact,date_creation)
VALUES (8210,'La Serpe','43 Quai des Belges',13001,'Marseille',348,'contact@la-serpe-editions.fr','10-08-1959');

INSERT INTO bookbay.editions (code_editions,nom,adresse,code_postal,ville,nombre_employes,email_contact,date_creation)
VALUES (905151,'La Croisée des Mondes','144 Avenue des Armuriers',75017,'Paris Cedex 05',124,'contact@lcdm-fr.com',NULL);

INSERT INTO bookbay.editions (code_editions,nom,adresse,code_postal,ville,nombre_employes,email_contact,date_creation)
VALUES (8359,'Maillard','11 Rue d''Odessa',75006,'Paris',500,'contact@maillard-editeurs.fr','17-05-1901');

INSERT INTO bookbay.editions (code_editions,nom,adresse,code_postal,ville,nombre_employes,email_contact,date_creation)
VALUES (7989,'Pierrot','310 Rue Saint-Martin',75003,'Paris CEDEX 15',568,'info@pierrot-livres.com','01-01-1989');

INSERT INTO bookbay.editions (code_editions,nom,adresse,code_postal,ville,nombre_employes,email_contact,date_creation)
VALUES (85625,'Art & Co',NULL,NULL,NULL,365,'editions@a-et-c.fr','05-10-2001');

INSERT INTO bookbay.editions (code_editions,nom,adresse,code_postal,ville,nombre_employes,email_contact,date_creation)
VALUES (84002,'Terre Neuve','31 Avenue Justinien',69004,'Lyon',600,'contact@tn-editions.eu','17-05-1836');

INSERT INTO bookbay.editions (code_editions,nom,adresse,code_postal,ville,nombre_employes,email_contact,date_creation)
VALUES (7685,'Faux Semblants','61 Rue Saint François',33000,'Bordeaux CEDEX 5',210,'secretariat@fx-semblants.fr','15-01-1970');

INSERT INTO bookbay.editions (code_editions,nom,adresse,code_postal,ville,nombre_employes,email_contact,date_creation)
VALUES (84369,'Concorde','18 Avenue des Saules',31000,'Toulouse CEDEX 2',NULL,NULL,NULL);

INSERT INTO bookbay.editions (code_editions,nom,adresse,code_postal,ville,nombre_employes,email_contact,date_creation)
VALUES (7745,'Humanités','17 Boulevard du Colonel Lestrade',35000,'Rennes',455,'contact@huma-editions.com',NULL);

INSERT INTO bookbay.editions (code_editions,nom,adresse,code_postal,ville,nombre_employes,email_contact,date_creation)
VALUES (37485,'Tempus',NULL,NULL,NULL,25,NULL,NULL);

INSERT INTO bookbay.editions (code_editions,nom,adresse,code_postal,ville,nombre_employes,email_contact,date_creation)
VALUES (309,'Musics',NULL,NULL,NULL,100,'contact@musics.eu','17-08-1983');

INSERT INTO bookbay.editions (code_editions,nom,adresse,code_postal,ville,nombre_employes,email_contact,date_creation)
VALUES (948172,'Educ',NULL,NULL,NULL,780,'contact@educ-editeur.fr','10-05-1986');

-- Données de la table imprimeurs

-- si des données ont précédemment été insérées dans la table, le code_imprimeur (généré par une séquence) a été incrémenté; il faut donc le remettre à 1
-- ALTER SEQUENCE imprimeurs_code_imprimeur_seq restart WITH 1;

INSERT INTO bookbay.imprimeurs (code_imprimeur,nom_imprimeur,coordonnees,nb_employes,web,telephone,fax)
VALUES (DEFAULT,'Imprimerie Hédrard',ROW(135,'Boulevard','Albert Germain',75017,'Paris'),178,NULL,'01.54.25.69.58','01.54.25.69.59');

INSERT INTO bookbay.imprimeurs (code_imprimeur,nom_imprimeur,coordonnees,nb_employes,web,telephone,fax)
VALUES (DEFAULT,'Camteck et fils',ROW(42,'Cours','Martinet',06000,'Nice'),46,'http://www.camteck.eu','04.54.41.25.65',NULL);

INSERT INTO bookbay.imprimeurs (code_imprimeur,nom_imprimeur,coordonnees,nb_employes,web,telephone,fax)
VALUES (DEFAULT,'Print Express',NULL,241,'http://www.printxpress.fr','03.41.75.34.76','03.41.75.34.77');

INSERT INTO bookbay.imprimeurs (code_imprimeur,nom_imprimeur,coordonnees,nb_employes,web,telephone,fax)
VALUES (DEFAULT,'Impressions ENI',ROW(26,'Quai','Magellan',44200,'Nantes'),98,NULL,'02.54.25.23.58','02.54.25.23.65');

INSERT INTO bookbay.imprimeurs (code_imprimeur,nom_imprimeur,coordonnees,nb_employes,web,telephone,fax)
VALUES (DEFAULT,'Offset',NULL,32,NULL,'05.11.47.58.63',NULL);

INSERT INTO bookbay.imprimeurs (code_imprimeur,nom_imprimeur,coordonnees,nb_employes,web,telephone,fax)
VALUES (DEFAULT,'Les graphistes associés',ROW(NULL,'Impasse','Roland Goas',75020,'Paris CEDEX 20'),NULL,'http://www.graphcorp.com','01.42.58.94.25',NULL);

INSERT INTO bookbay.imprimeurs (code_imprimeur,nom_imprimeur,coordonnees,nb_employes,web,telephone,fax)
VALUES (DEFAULT,'Jeux d''encre',NULL,19,NULL,NULL,NULL);

INSERT INTO bookbay.imprimeurs (code_imprimeur,nom_imprimeur,coordonnees,nb_employes,web,telephone,fax)
VALUES (DEFAULT,'Mizenpage',ROW(NULL,'Lieu-dit','Les Hautes Granges',63110,'Beaumont'),57,NULL,NULL,NULL);

INSERT INTO bookbay.imprimeurs (code_imprimeur,nom_imprimeur,coordonnees,nb_employes,web,telephone,fax)
VALUES (DEFAULT,'Charlier et Herbont',ROW(38,'Rue','Aline Spein',71140,'Bourbon-Lancy'),126,NULL,'08.54.25.36.87','08.54.25.36.88');

-- Données de la table auteurs

-- Pour être sûr que le format de date sera accepté sans problème:
SET DATESTYLE to DMY;

-- auteurs fictifs
INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (1,'Arrouas','Henry',DEFAULT,'05-06-1971',NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (2,'Fournier','Louis','belge','15-10-1947',NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (3,'Dausmenil','Alexandre',DEFAULT,NULL,NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (4,'Bernard','Alain','canadien','09-04-1964','16-05-2003');

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (5,'Philippe','Loïc','française','10-03-1978',NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (6,'Franchi','Stéphane',DEFAULT,'28-07-1981',NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (7,'Leroux','Germain','française','05-05-1960',NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (8,'Dunach','Yves','allemande',NULL,NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (9,'Morel','Jeanne',DEFAULT,'05-05-1960',NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (10,'Meynier','Ghislaine','belge',NULL,NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (11,'Herrbach','Claire','allemande',NULL,NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (12,'Holtz','Jean-Jacques','suisse','02-08-1962',NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (13,'Murzeau','Julien',DEFAULT,NULL,NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (14,'Eyglier','Bernard',DEFAULT,NULL,NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (15,'Rossini','Marcello','italienne',NULL,NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (16,'Lorenz','Bernhard','allemande','05-09-1955',NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (17,'Cisa','Pablo','espagnole',NULL,NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (18,'Kennedy','Andrew','anglaise',NULL,NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (19,'Ronchard','Frédéric','suisse','20-04-1953',NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (20,'Dos Santos','Roberto','portugaise','18-09-1963',NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (21,'Arniaud','Joseph','belge','18-11-1960',NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (22,'Plunet','Béatrice','française','25-07-1971',NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (23,'Thierrot','Paul','française','24-03-1955',NULL);

-- auteurs qui n'ont rien écrit
INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (24,'Pamatelian','Christiane',DEFAULT,NULL,NULL);

-- auteurs fictifs
INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (25,'Falque','Annie',DEFAULT,'27-08-1959',NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (26,'Toche','Philippe','française',NULL,NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (27,'Hedeiden','Konrad','autrichien','21-04-1972',NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (28,'de Saint-Victor','Alain','française','28-01-1958',NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (29,'Calquier','Laurence','française','31-03-1980',NULL);

-- auteurs eni
INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (30,'Guérin','Brice-Arnaud','française',NULL,NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (31,'Chassagnac','Martine','française',NULL,NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (32,'Charlet','Christophe','française',NULL,NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (33,'Atelin','Philippe','française',NULL,NULL);

-- auteurs fictifs
INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (34,'Ibanez','Diego','espagnole','25-02-1959',NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (35,'Richards','Michaël','anglaise',NULL,NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (36,'Olafsson','Niels','suédoise','14-06-1966',NULL);

-- vrais auteurs
INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (37,'De Balzac','Honoré','française','20-05-1799','18-08-1850');

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (38,'Voltaire',NULL,'française','21-11-1694','30-05-1778');

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (39,'Dumas','Alexandre','française','24-07-1802','05-12-1870');


-- auteurs eni
INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (40,'Gabillaud','Jérôme','française',NULL,NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (41,'Guillon','Anne','française',NULL,NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (42,'Guérois','Catherine','française',NULL,NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (43,'Pelletier','François','française',NULL,NULL);

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (44,'Guérin','Cyril','française',NULL,NULL);

-- auteurs qui n'ont rien écrit

INSERT INTO bookbay.auteurs (identifiant_auteur,nom,prenom,nationalite,date_naissance,date_deces)
VALUES (45,'Mirac','Olivier',DEFAULT,'13-06-1969',NULL);


-- Données de la table distinctions

INSERT INTO bookbay.distinctions VALUES ('Prix Guthbraud',NULL);

INSERT INTO bookbay.distinctions VALUES ('Linux Book Award','15-07-1997');

INSERT INTO bookbay.distinctions VALUES ('Choix des lecteurs de Philosophiae','05-03-1979');

INSERT INTO bookbay.distinctions VALUES ('Bourse Asden','10-12-1983');

INSERT INTO bookbay.distinctions VALUES ('Grand Prix du Livre Classique','27-04-1959');

INSERT INTO bookbay.distinctions VALUES ('Prix des Etudiants Informaticiens','06-09-2002');

INSERT INTO bookbay.distinctions VALUES ('Prix de la Revue d''Anthropologie','06-11-1935');

INSERT INTO bookbay.distinctions VALUES ('Prix du Livre Informatique','08-06-1985');

INSERT INTO bookbay.distinctions VALUES ('Prix du Festival du Polar','21-10-1976');

INSERT INTO bookbay.distinctions VALUES ('Trophée du Roman','02-01-1975');

INSERT INTO bookbay.distinctions VALUES ('Prix du Livre de Langue Française',NULL);

-- Données de la table entrepots

INSERT INTO bookbay.entrepots (code_entrepot,adresse,code_postal,ville,responsable,employes,code_editions)
VALUES (1,'45 Rue des Ecluses',75006,'Paris',ROW('Dupont','Alfred','15/10/1971'),4,7460);

INSERT INTO bookbay.entrepots (code_entrepot,adresse,code_postal,ville,responsable,employes,code_editions)
VALUES (2,'27 Rue du Pistou',13007,'Marseille',ROW('Marlotti','Jean-Jacques','05/04/1951'),18,8210);

INSERT INTO bookbay.entrepots (code_entrepot,adresse,code_postal,ville,responsable,employes,code_editions)
VALUES (3,'4 Impasse des Amis',83000,'Toulon',ROW('Gergat','Michel','25/06/1979'),NULL,8210);

INSERT INTO bookbay.entrepots (code_entrepot,adresse,code_postal,ville,responsable,employes,code_editions)
VALUES (4,NULL,59000,'Lille',NULL,NULL,8359);

INSERT INTO bookbay.entrepots (code_entrepot,adresse,code_postal,ville,responsable,employes,code_editions)
VALUES (5,NULL,29200,'Brest',NULL,NULL,905151);

INSERT INTO bookbay.entrepots (code_entrepot,adresse,code_postal,ville,responsable,employes,code_editions)
VALUES (6,'9 Cours Mirabeau',31000,'Toulouse',ROW('Jeanlin','Marc',NULL),20,8359);

INSERT INTO bookbay.entrepots (code_entrepot,adresse,code_postal,ville,responsable,employes,code_editions)
VALUES (7,'25 Chemin de Traverse',21000,'Dijon',NULL,NULL,905151);

INSERT INTO bookbay.entrepots (code_entrepot,adresse,code_postal,ville,responsable,employes,code_editions)
VALUES (8,NULL,69000,'Lyon',NULL,NULL,7460);

INSERT INTO bookbay.entrepots (code_entrepot,adresse,code_postal,ville,responsable,employes,code_editions)
VALUES (9,NULL,34000,'Montpellier',NULL,5,8359);

INSERT INTO bookbay.entrepots (code_entrepot,adresse,code_postal,ville,responsable,employes,code_editions)
VALUES (10,NULL,06000,'Nice',NULL,NULL,905151);

INSERT INTO bookbay.entrepots (code_entrepot,adresse,code_postal,ville,responsable,employes,code_editions)
VALUES (11,'55 Avenue des Palmeraies',06000,'Nice',ROW('Wilkins','Matthew',NULL),NULL,8210);

INSERT INTO bookbay.entrepots (code_entrepot,adresse,code_postal,ville,responsable,employes,code_editions)
VALUES (12,NULL,06000,'Nice',NULL,NULL,8359);

INSERT INTO bookbay.entrepots (code_entrepot,adresse,code_postal,ville,responsable,employes,code_editions)
VALUES (13,'23 Cours Martinet',06000,'Nice',ROW('Bernard','Céline','12/05/1969'),NULL,7460);

INSERT INTO bookbay.entrepots (code_entrepot,adresse,code_postal,ville,responsable,employes,code_editions)
VALUES (14,NULL,75006,'Paris',NULL,NULL,8210);

INSERT INTO bookbay.entrepots (code_entrepot,adresse,code_postal,ville,responsable,employes,code_editions)
VALUES (15,'Rue des Empereurs',75006,'Paris',NULL,3,8359);

INSERT INTO bookbay.entrepots (code_entrepot,adresse,code_postal,ville,responsable,employes,code_editions)
VALUES (16,NULL,75006,'Paris',NULL,NULL,905151);

INSERT INTO bookbay.entrepots (code_entrepot,adresse,code_postal,ville,responsable,employes,code_editions)
VALUES (17,NULL,75006,'Paris',NULL,NULL,7685);

INSERT INTO bookbay.entrepots (code_entrepot,adresse,code_postal,ville,responsable,employes,code_editions)
VALUES (18,NULL,06000,'Nice',NULL,NULL,7685);

INSERT INTO bookbay.entrepots (code_entrepot,adresse,code_postal,ville,responsable,employes,code_editions)
VALUES (19,NULL,06000,'Nice',NULL,NULL,7989);

INSERT INTO bookbay.entrepots (code_entrepot,adresse,code_postal,ville,responsable,employes,code_editions)
VALUES (20,NULL,06000,'Nice',NULL,NULL,7745);

INSERT INTO bookbay.entrepots (code_entrepot,adresse,code_postal,ville,responsable,employes,code_editions)
VALUES (21,NULL,06000,'Nice',NULL,NULL,84002);

INSERT INTO bookbay.entrepots (code_entrepot,adresse,code_postal,ville,responsable,employes,code_editions)
VALUES (22,NULL,06000,'Nice',NULL,30,85625);

INSERT INTO bookbay.entrepots (code_entrepot,adresse,code_postal,ville,responsable,employes,code_editions)
VALUES (23,NULL,06000,'Nice',NULL,NULL,84369);

INSERT INTO bookbay.entrepots (code_entrepot,adresse,code_postal,ville,responsable,employes,code_editions)
VALUES (24,NULL,75020,'Paris',NULL,15,7685);

INSERT INTO bookbay.entrepots (code_entrepot,adresse,code_postal,ville,responsable,employes,code_editions)
VALUES (25,NULL,75015,'Paris',NULL,NULL,7685);

INSERT INTO bookbay.entrepots (code_entrepot,adresse,code_postal,ville,responsable,employes,code_editions)
VALUES (26,NULL,75016,'Paris',ROW('Holtz','Franck','02/08/1962'),NULL,7685);

INSERT INTO bookbay.entrepots (code_entrepot,adresse,code_postal,ville,responsable,employes,code_editions)
VALUES (27,NULL,75018,'Paris',NULL,NULL,7685);

INSERT INTO bookbay.entrepots (code_entrepot,adresse,code_postal,ville,responsable,employes,code_editions)
VALUES (28,NULL,75003,'Paris',NULL,10,7685);

INSERT INTO bookbay.entrepots (code_entrepot,adresse,code_postal,ville,responsable,employes,code_editions)
VALUES (29,NULL,75004,'Paris',NULL,NULL,7685);

-- Données de la table collections

INSERT INTO bookbay.collections (code_collection,intitule,code_editions,theme)
VALUES (1,'Les TPS Informatiques',7460,'informatique');

INSERT INTO bookbay.collections (code_collection,intitule,code_editions,theme)
VALUES (2,'Technote',7460,'informatique');

INSERT INTO bookbay.collections (code_collection,intitule,code_editions,theme)
VALUES (3,'Certifications',7460,'enseignement');

INSERT INTO bookbay.collections (code_collection,intitule,code_editions,theme)
VALUES (4,'Ressources Informatiques',7460,'informatique');

INSERT INTO bookbay.collections (code_collection,intitule,code_editions,theme)
VALUES (5,'Microfluo',7460,'informatique');

INSERT INTO bookbay.collections (code_collection,intitule,code_editions,theme)
VALUES (6,'SF',8210,'anticipation');

INSERT INTO bookbay.collections (code_collection,intitule,code_editions,theme)
VALUES (7,'Grands Classiques',8210,'littérature');

INSERT INTO bookbay.collections (code_collection,intitule,code_editions,theme)
VALUES (8,'Lecture Passion',8210,'romans');

INSERT INTO bookbay.collections (code_collection,intitule,code_editions,theme)
VALUES (9,'Architectures',8359,'beaux livres');

INSERT INTO bookbay.collections (code_collection,intitule,code_editions,theme)
VALUES (10,'Réfléxions urbanistes',8359,'beaux livres');

INSERT INTO bookbay.collections (code_collection,intitule,code_editions,theme)
VALUES (11,'Amour toujours',7989,'romans');

INSERT INTO bookbay.collections (code_collection,intitule,code_editions,theme)
VALUES (12,'Homme et société',84002,'sciences humaines');

INSERT INTO bookbay.collections (code_collection,intitule,code_editions,theme)
VALUES (13,'Réfléxions',84002,'essais');

INSERT INTO bookbay.collections (code_collection,intitule,code_editions,theme)
VALUES (14,'La philo facile',84002,'enseignement');

-- Données de la table imprime

INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('1','1');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('2','1');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('3','1');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('4','3');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('5','4');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('6','4');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('7','1');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('1','2');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('9','3');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('10','4');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('11','5');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('12','6');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('13','7');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('5','8');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('6','9');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('8','3');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('12','3');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('11','9');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('2','7');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('2','4');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('3','6');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('4','9');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('5','3');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('6','5');

INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('4','1');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('5','1');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('6','1');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('8','1');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('2','2');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('1','3');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('4','2');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('5','2');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('6','2');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('7','2');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('8','2');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('1','4');
-- INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('1','10');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('1','5');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('1','6');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('1','7');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('1','8');
INSERT INTO bookbay.imprime (code_collection, code_imprimeur) VALUES ('1','9');

-- Données de la table livres

-- les tps informatiques
INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-7460-3526-3','SQL Server 2005',25.65,'02-09-2007','03-10-2007',1,'français','01-01-2007',NULL);

INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-7460-2871-5','Oracle 10g',25.65,'12-04-2005','23-04-2005',1,'français','01-01-2005',NULL);

INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-7460-3410-5','Windows Server 2003',25.65,'04-06-2007','05-07-2007',1,'français','01-01-2007',NULL);

INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-7460-3302-3','AutoCAD 2006',25.65,'05-10-2006','15-10-2006',1,'français','01-01-2006',NULL);

-- technote

INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-7460-3408-2','Wi-Fi, solutions de sécurisation',9.50,'24-04-2007','26-05-2007',2,'français','01-01-2007',NULL);

INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-7460-2752-7','Oracle 10g - PL/SQL',9.50,DEFAULT,DEFAULT,2,'français','01-01-2005',NULL);

-- ressources informatiques

INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-7460-3375-7','ASP.Net 2.0 avec C# 2',25.78,DEFAULT,DEFAULT,4,'français','01-01-2005',ARRAY['espagnol','russe']);

INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-7460-3055-8','Applications serveur sous .NET',NULL,'22-03-2006','30-03-2006',4,'français',NULL,ARRAY['espagnol']);

INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-7460-3704-5','WinDev 11',25.78,DEFAULT,DEFAULT,4,'français',NULL,ARRAY['espagnol']);

-- certifications

INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-7460-2180-8','SQL Server 2000 - Examen 70-229',56.05,'20-02-2000','22-02-2000',3,'français','01-01-2000',NULL);

INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-7460-2051-1','SQL Server 2000 - Examen 70-228',NULL,DEFAULT,DEFAULT,3,'français','01-01-2000',NULL);

-- microfluo

INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-7460-3263-7','FileMaker Pro 8',6.95,'02-08-2006','05-08-2006',5,'français','01-01-2006',NULL);

INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-7460-2996-5','Photoshop CS2 pour PC/Mac',6.95,DEFAULT,DEFAULT,5,'français','01-01-2006',NULL);

-- SF
INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-8210-2315-4','Les méta-hommes',11,'25-04-2001','25-06-2001',6,'français','01-01-2001',ARRAY['italien','anglais','allemand']);

INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-8210-1234-9','Supernovae',8.60,DEFAULT,DEFAULT,'6','anglais','01-01-1998',ARRAY['français','russe']);

INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-8210-1023-9','Chroniques des sept quasars',9,'20-03-1987','25-03-1987',6,'allemand','01-01-1981',ARRAY['anglais','français']);

-- grands classiques
INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-8210-1536-4','La paix du ménage',7.80,DEFAULT,DEFAULT,7,'français','01-01-1830',NULL);

INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-8210-1841-9','Eugénie Grandet',NULL,DEFAULT,DEFAULT,7,'français','01-01-1833',NULL);

INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-8210-1909-6','L''homme aux quarante écus',5.85,'02-03-1999','20-03-1999',7,'français','01-01-1768',NULL);

INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-8210-1120-5','Le comte de Monte-Cristo',7.55,DEFAULT,DEFAULT,7,'français','01-01-1844',ARRAY['anglais','italien','allemand','russe','chinois','japonais']);

INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-8210-1150-2','Impressions de voyage',6.52,DEFAULT,DEFAULT,7,'français','01-01-1847',NULL);

INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-8210-1082-6','Promenades en France',11,DEFAULT,DEFAULT,7,'français','01-01-1839',NULL);

-- INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
-- VALUES ('978-2-8210-4526-2','Dictionnaire des thèmes littéraires',36,'11-10-1998','15-10-1998',7,'français','01-01-1996',NULL);

-- lecture passion
INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-8210-4589-7','Les amis du bout du monde',5.50,DEFAULT,DEFAULT,8,'suédois','01-01-2004',ARRAY['français']);

INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-8210-2785-5','Le coureur à pied',5.50,'10-05-1997','15-05-1997',8,'français','01-01-1997',NULL);

-- architectures
INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-8359-4788-0','Santiago Calatrava',27.30,'26-05-2007','28-05-2007',9,'espagnol','01-01-2007',ARRAY['français','italien']);

INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-8359-3658-7','Vie d''Antonio Gaudi',45.05,'16-03-2006','30-03-2006',9,'français','01-01-2006',NULL);

-- réfléxions urbanistes
INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-8359-1574-2','Le Corbusier et l''urbanisme',38,DEFAULT,DEFAULT,10,'français','01-01-1981',ARRAY['italien','allemand']);

INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-8359-5225-9','L''oeuvre d''Oscar Niemeyer',72.10,'15-09-2007','20-09-2007',10,'français','01-01-2007',ARRAY['anglais','portugais','espagnol','italien']);

-- amour toujours
INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-7989-2674-8','Romance de printemps',4.50,DEFAULT,DEFAULT,11,'anglais','01-01-1995',ARRAY['français']);

INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-7989-2415-7','Le piège de l''amour',6,DEFAULT,DEFAULT,11,'français','01-01-1989',NULL);

INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-7989-1569-8','Le secret de Miranda',NULL,DEFAULT,DEFAULT,11,'français','01-01-1978',ARRAY['italien','anglais']);

INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-7989-3405-7','Un amour impossible',4.55,'01-04-2006','04-04-2006',11,'français','01-01-2005',NULL);

-- homme et société
INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-84002-541-2','La violence urbaine en Europe',18.20,'11-12-2000','15-12-2000',12,'français','01-01-2000',ARRAY['anglais','italien']);

INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-84002-695-2','Quelle place pour la culture?',15.70,DEFAULT,DEFAULT,12,'français',NULL,NULL);

INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-84002-482-8','L''homme et son environnement',16,'14-05-1981','16-05-1981',13,'français',NULL,NULL);

-- réfléxions
INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-84002-985-4','Essai sur la décomposition du tissu social',21,'05-04-2002','07-04-2002',13,'français','01-01-2002',NULL);

INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-84002-489-7','Vie et mort du système scolaire',19.50,DEFAULT,DEFAULT,13,'français','01-01-1983',NULL);

INSERT INTO bookbay.livres (isbn,titre,prix,depot_legal,date_impression,code_collection,langue,annee,traductions)
VALUES ('978-2-84002-499-6','Manuscrits antiques d''auteurs inconnus',15.50,DEFAULT,DEFAULT,13,'français','01-01-1984',NULL);

-- Données de la table ecrit_par

-- editions eni
INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-7460-3375-7',30);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-7460-3055-8',30);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-7460-2996-5',44);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-7460-3302-3',31);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-7460-3302-3',32);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-7460-3526-3',40);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-7460-2871-5',40);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-7460-2752-7',40);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-7460-2180-8',40);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-7460-2051-1',40);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-7460-3410-5',41);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-7460-3263-7',42);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-7460-3704-5',43);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-7460-3408-2',33);


-- auteurs fictifs et réels (décédés)
INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-8210-2315-4',1);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-8210-1234-9',18);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-8210-1023-9',16);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-8210-1536-4',37);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-8210-1841-9',37);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-8210-1909-6',38);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-8210-1120-5',39);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-8210-1150-2',39);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-8210-4589-7',36);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-7989-2674-8',5);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-8210-2785-5',7);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-8359-4788-0',17);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-8359-5225-9',20);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-8359-5225-9',22);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-8359-5225-9',8);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-8359-1574-2',12);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-7989-2415-7',25);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-7989-1569-8',19);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-7989-3405-7',13);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-8359-3658-7',10);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-84002-489-7',23);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-84002-541-2',27);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-84002-541-2',15);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-84002-541-2',29);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-84002-541-2',35);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-84002-695-2',26);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-84002-482-8',9);

INSERT INTO bookbay.ecrit_par (isbn,id_auteur)
VALUES ('978-2-84002-985-4',14);


-- Données de la table entrepose

-- Eugénie Grandet
INSERT INTO bookbay.entrepose (isbn,code_entrepot,quantite,date_modification)
VALUES ('978-2-8210-1841-9',2,25,NULL);

INSERT INTO bookbay.entrepose (isbn,code_entrepot,quantite,date_modification)
VALUES ('978-2-8210-1841-9',11,15,NULL);

-- Le comte de Monte-Cristo
INSERT INTO bookbay.entrepose (isbn,code_entrepot,quantite,date_modification)
VALUES ('978-2-8210-1120-5',14,12,'19-08-2007');

-- Santiago Calatrava
INSERT INTO bookbay.entrepose (isbn,code_entrepot,quantite,date_modification)
VALUES ('978-2-8359-4788-0',4,50,'25-09-2007');

-- Violence en Europe
INSERT INTO bookbay.entrepose (isbn,code_entrepot,quantite,date_modification)
VALUES ('978-2-84002-541-2',21,32,'18-05-2007');

INSERT INTO bookbay.entrepose (isbn,code_entrepot,quantite,date_modification)
VALUES ('978-2-84002-541-2',23,45,'23-11-2007');

INSERT INTO bookbay.entrepose (isbn,code_entrepot,quantite,date_modification)
VALUES ('978-2-84002-541-2',27,87,'10-10-2007');

INSERT INTO bookbay.entrepose (isbn,code_entrepot,quantite,date_modification)
VALUES ('978-2-84002-541-2',8,14,'09-08-2007');

-- Chronique des 7 quasars
INSERT INTO bookbay.entrepose (isbn,code_entrepot,quantite,date_modification)
VALUES ('978-2-8210-1023-9',14,25,NULL);

-- Oracle 10G PL/SQL
INSERT INTO bookbay.entrepose (isbn,code_entrepot,quantite,date_modification)
VALUES ('978-2-7460-2752-7',8,40,NULL);

-- Windows Server 2003
INSERT INTO bookbay.entrepose (isbn,code_entrepot,quantite,date_modification)
VALUES ('978-2-7460-3410-5',1,34,'11-10-2007');

-- Avenir de la culture
INSERT INTO bookbay.entrepose (isbn,code_entrepot,quantite,date_modification)
VALUES ('978-2-84002-695-2',21,10,'24-07-2006');

-- Photoshop CS2
INSERT INTO bookbay.entrepose (isbn,code_entrepot,quantite,date_modification)
VALUES ('978-2-7460-2996-5',1,23,'13-07-2007');

-- Antonio Gaudi
INSERT INTO bookbay.entrepose (isbn,code_entrepot,quantite,date_modification)
VALUES ('978-2-8359-3658-7',6,51,NULL);



-- Données de la table recompense_par

INSERT INTO bookbay.recompense_par VALUES ('Trophée du Roman','978-2-7989-2674-8','01-01-1997');

INSERT INTO bookbay.recompense_par VALUES ('Prix du Livre de Langue Française','978-2-7989-2674-8','01-01-1996');

INSERT INTO bookbay.recompense_par VALUES ('Prix Guthbraud','978-2-8210-1120-5','01-01-1855');

INSERT INTO bookbay.recompense_par VALUES ('Bourse Asden','978-2-8359-3658-7','01-01-2007');

INSERT INTO bookbay.recompense_par VALUES ('Prix des Etudiants Informaticiens','978-2-7460-2752-7','01-01-2006');

INSERT INTO bookbay.recompense_par VALUES ('Prix du Livre Informatique','978-2-7460-2752-7','01-01-2006');

INSERT INTO bookbay.recompense_par VALUES ('Prix du Livre de Langue Française','978-2-84002-482-8','01-01-1997');

INSERT INTO bookbay.recompense_par VALUES ('Prix du Festival du Polar','978-2-7989-1569-8','01-01-2006');
