-- script: TP2_wjacques.sql
-- auteur: William JACQUES
-- date: 18/09/2020

-- Exercice 1

-- 4.

/*
 * departement[@(idDept: varchar(12), titre: varchar(64)]
 * 
 * personnel[@(idPers: int), nom: varchar(32), prenom: varchar(32),
 * fonction: varchar(64), #idDept: varchar(12)]
 *
 * enseignant[@(idEns: int), nom: varchar(32), prenom: varchar(32), titulaire:
 * boolean, #idDept: varchar(12)]
 *
 * etudiant[@(idEtud: int), nom: varchar(32), prenom: varchar(32), classe:
 * varchar(12)]
 *
 * module[@(refMod: varchar(8)), intitule: varchar(128), classe: varchar(12),
 * coef: float, volHoraireCM: int, volHoraireTD: int, volHoraireTP: int, #idEns:
 * int]
 *
 * interro[@(idInter: int), #refMod: varchar(6), coefInterro: float]
 *
 * notes[@(#idInter: int, #idEtud: int), note: float(2), ]
 */

-- 5.
SELECT * FROM departement;

/*
 * iddept  |                      titre                       
 * --------+--------------------------------------------------
 * INFO    | Informatique
 * QLIO    | Qualité, Logistique Industrielle et Organisation
 * INFOCOM | Information et Communication
 * GACO    | Gestion des Administrations et Commerce
 * (4 rows)
 */

SELECT * FROM etudiant;

/*
 *  idetud |    nom     |  prenom  | classe 
 * --------+------------+----------+--------
 *       1 | Turing     | Alan     | S3
 *       2 | Lovelace   | Ada      | S3
 *       3 | Baggage    | Charles  | S3
 *       6 | Berry      | Gérard   | S3
 *       8 | Berner-Lee | Tim      | S1
 *       4 | Meyer      | Bertrand | S1
 *       5 | Wirth      | Niklaus  | S1
 *       7 | TALON      | Achille  | S1
 */

SELECT * FROM personnel;
SELECT * FROM notes;
SELECT * FROM modulo;
SELECT * FROM enseignant;
SELECT * FROM interro;

-- Ajout de tuples () dans toutes les tables

-- Exercice 2

-- 1.
\c mycompanies
-- You are now connected to database "mycompanies" as user "wjacques".

-- 2a.
\dn
--   Name  |  Owner   
--  -------+---------
--   comp  | lamolle
--  public | postgres
-- (2 rows)
--
-- Le nom est comp

-- 2b.
\dt comp.*
-- List of relations
-- Schema |  Name   | Type  |  Owner  
-- -------+---------+-------+---------
-- comp   | company | table | lamolle
-- comp   | contact | table | lamolle
-- (2 rows)

-- 2c.

/*
 * comp.company[@(idcomp: bigint), nom: varchar(255), activecomp: boolean,
 * date_creation: timestamp, date_modif: timestamp]
 *
 * comp.contact[@(idcontact: bigint), nom: varchar(100), prenom: varchar(50),
 * mail: varchar(255), actif: boolean, #idcomp: bigint, commentaire: text,
 * status: contact_type, date_deb_interaction: timestamp, date_fin_interaction:
 * timestamp, date_creation: timestamp, date_modif: timestamp]
 *
 */

-- 3a.
\d comp.company
-- 5 attributs
\d comp.contact
-- 13 attributs


-- 3b.
SELECT COUNT(*) FROM comp.company;
-- 6379 rows (tuples)
SELECT COUNT(*) FROM comp.contact;
-- 63 rows (tuples)

-- 3c.
SELECT DISTINCT nom FROM comp.company ORDER BY nom ASC;
-- je ne vais pas coller le résultat car il y a 6379 noms de companies
-- différentes

