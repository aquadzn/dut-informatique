-- TP10
-- wjacques 07/01/2021

-- Exercice 1

-- 2.
DELETE FROM bookbay.Ecrire;
DELETE FROM bookbay.Appartenir;
DELETE FROM bookbay.Obtenir;
DELETE FROM bookbay.Imprimer;
DELETE FROM bookbay.Stocker;
DELETE FROM bookbay.Distinction;
DELETE FROM bookbay.Imprimeur;
DELETE FROM bookbay.Editeur;
DELETE FROM bookbay.Entrepot;
DELETE FROM bookbay.Collection;
DELETE FROM bookbay.Livre;
DELETE FROM bookbay.Auteur;

-- 3.
insert into bookbay.auteur values (default, 'Berners-Lee', 'Tim', 'anglais', '08-06-1955');
insert into bookbay.livre values ('978-0-0625-1586-5', 'Weaving the web : …', 20, true, '20-02-1990', 'anglais', 1991);
insert into bookbay.ecrire values ( currval(' bookbay.auteur_idAuteur_seq'), '978-0-0625-1586-5');

-- 4.
insert into bookbay.auteur values (default, 'Roques', 'Pascal', 'francais', '08-06-1955');
insert into bookbay.livre values ('978-2-2121-3344-8', 'UML2 par la pratique', 20, true, '20-01-2000', 'francais', 2000);
insert into bookbay.ecrire values ( currval(' bookbay.auteur_idAuteur_seq'), '978-2-2121-3344-8');

-- Exercice 2

-- 1.
-- \i insertLivre.sql

-- 3.
insert into bookbay.auteur values (default, 'Doe', 'John', 'anglais', '18-02-1985');
insert into bookbay.auteur values (default, 'Koerhornou', 'Lucien', 'francais', '18-02-1985');
insert into bookbay.auteur values (default, 'Pratchett', 'Terry', 'anglais', '18-02-1985');

-- 4.
-- 5.
insert into bookbay.livre values ('978-2-33282-551-3', 'Les fractions au clair', 7, true, '20-01-2000', 'francais', 2000);
insert into bookbay.ecrire values (currval(' bookbay.auteur_idAuteur_seq') - 1, '978-2-33282-551-3');
insert into bookbay.livre values ('978-2-36793-275-0', 'La science du disque du monde', 7, true, '20-01-2000', 'francais', 2000);
insert into bookbay.ecrire values (currval(' bookbay.auteur_idAuteur_seq'), '978-2-36793-275-0');

-- 6.
select l.titre, a.nomAuteur, a.prenomAuteur from bookbay.livre l join bookbay.ecrire e on l.isbn = e.isbn join bookbay.auteur a on e.idAuteur = a.idAuteur;

-- 7.
UPDATE bookbay.auteur SET nationalite = 'apatride' WHERE prenomAuteur LIKE 'John' AND nomAuteur LIKE 'Doe';

-- 8.
UPDATE bookbay.auteur SET nomAuteur =  UPPER(nomAuteur);
SELECT nomAuteur from bookbay.auteur;

-- 9.
UPDATE bookbay.livre SET datImpression = NOW() WHERE datImpression IS NULL;

-- 10.
INSERT INTO bookbay.Collection VALUES (DEFAULT, 'CollectSweden');

-- 11.
UPDATE bookbay.livre SET codecollection = currval('bookbay.collection_codeCollection_seq') WHERE langue LIKE 'suedois';

-- 12.
UPDATE bookbay.collection SET codeedition = e.codeedition FROM bookbay.editeur e WHERE e.nomedition LIKE 'Terre Neuve';

-- 13.
DELETE FROM bookbay.collection WHERE intitule LIKE 'CollectSweden';

-- 14.
-- INSERT INTO bookbay.Entrepot VALUES (1, '45 Rue des Écluses', 75006, 'Paris', 'Dupont Alfred', 4, 7460);
-- INSERT INTO bookbay.Entrepot VALUES (2, '27 Rue du Pistou', 13007, 'Marseille', 'Marlotti Jean-Jacques', 8210);
-- INSERT INTO bookbay.Entrepot VALUES (3, '4 Impasse des Amis', 83000, 'Toulon', 'Gergat Michel', 8210);
