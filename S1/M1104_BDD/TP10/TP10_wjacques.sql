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
\i insertLivre.sql

