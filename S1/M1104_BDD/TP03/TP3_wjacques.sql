-- script: TP3_wjacques.sql
-- auteur: William JACQUES
-- date: 25/09/2020

-- Exercice 1

-- 1.
SELECT * FROM etudiant ORDER BY nom, prenom;
-- idetud |    nom     |  prenom  | classe 
--------+------------+----------+--------
--      3 | Baggage    | Charles  | S3
--      8 | Berner-Lee | Tim      | S1
--      6 | Berry      | Gérard   | S3
--      2 | Lovelace   | Ada      | S3
--      4 | Meyer      | Bertrand | S1
--      7 | TALON      | Achille  | S1
--      1 | Turing     | Alan     | S3
--      5 | Wirth      | Niklaus  | S1
-- (8 rows)

-- 2.
SELECT nom, prenom FROM etudiant ORDER BY nom, prenom;
--    nom     |  prenom  
------------+----------
-- Baggage    | Charles
-- Berner-Lee | Tim
-- Berry      | Gérard
-- Lovelace   | Ada
-- Meyer      | Bertrand
-- TALON      | Achille
-- Turing     | Alan
-- Wirth      | Niklaus
-- (8 rows)

-- 3.
SELECT * FROM etudiant WHERE classe='I2';
-- idetud | nom | prenom | classe 
--------+-----+--------+--------
-- (0 rows)

-- 4.
SELECT * FROM etudiant WHERE classe='S1';
-- idetud |    nom     |  prenom  | classe 
--------+------------+----------+--------
--      8 | Berner-Lee | Tim      | S1
--      4 | Meyer      | Bertrand | S1
--      5 | Wirth      | Niklaus  | S1
--     7 | TALON      | Achille  | S1
-- (4 rows)

SELECT * FROM etudiant WHERE classe='s1';
-- idetud | nom | prenom | classe 
--------+-----+--------+--------
-- (0 rows)


-- 5.
SELECT * FROM etudiant WHERE nom LIKE 'L%' ORDER BY nom, prenom;
--  idetud |   nom    | prenom | classe 
--------+----------+--------+--------
--      2 | Lovelace | Ada    | S3
-- (1 row)

-- 6.
SELECT * FROM module WHERE classe='S1';
/*
 refmod |                          intitule                           | classe | coef | volhorairecm | volhorairetd | volhorairetp | idens 
--------+-------------------------------------------------------------+--------+------+--------------+--------------+--------------+-------
 M1101  | Introduction aux systèmes informatiques                     | S1     |  3.5 |           10 |           20 |           30 |    12
 M1102  | Introduction à l'algorithmique et à la programmation        | S1     |  3.5 |           10 |           20 |           30 |     5
 M1103  | Structures de données et algorithmes fondamentaux           | S1     |  2.5 |           10 |           15 |           20 |     5
 M1104  | Introduction aux bases de données                           | S1     |  3.5 |           10 |           25 |           25 |     7
 M1105  | Conception de documents et d'interfaces numériques          | S1     |  2.5 |            0 |           20 |           25 |     5
 M1106  | Projet Tutoré - Découverte                                  | S1     |  1.5 |            0 |            0 |            0 |     5
 M1201  | Mathématiques discrètes                                     | S1     |  2.5 |           10 |           18 |           17 |     8
 M1202  | Algèbre linéaire                                            | S1     |    2 |            6 |           12 |           12 |    15
 M1203  | Environnement économique                                    | S1     |  1.5 |           10 |           10 |           10 |    16
 M1204  | Fonctionnement des organisations                            | S1     |  2.5 |           10 |           20 |           15 |    15
 M1205  | Expression communication - Fondamentaux de la communication | S1     |    2 |            0 |           15 |           15 |    20
 M1206  | Anglais et Informatique                                     | S1     |  1.5 |            0 |           15 |           15 |    20
 M1207  | PPP - Connaître le monde professionnel                      | S1     |    1 |            0 |           10 |           10 |    20
(13 rows)
*/

-- 7. 
SELECT * FROM module WHERE intitule LIKE '%BD%';
-- refmod | intitule | classe | coef | volhorairecm | volhorairetd | volhorairetp | idens 
--------+----------+--------+------+--------------+--------------+--------------+-------
--(0 rows)

-- 8.
SELECT * FROM notes WHERE note > 10;
/*
 idinter | idetud | note 
---------+--------+------
       1 |      4 |   12
       1 |      5 |   13
       2 |      4 |   14
       3 |      1 |   12
       3 |      2 |   16
       4 |      4 |   12
       5 |      5 |   12
(7 rows)
*/

-- 9.
SELECT * FROM module INNER JOIN interro ON module.refmod=interro.refmod

/*
 refmod |             intitule              | classe | coef | volhorairecm | volhorairetd | volhorairetp | idens | idinter | refmod | coefinterro 
--------+-----------------------------------+--------+------+--------------+--------------+--------------+-------+---------+--------+-------------
 M1201  | Mathématiques discrètes           | S1     |  2.5 |           10 |           18 |           17 |     8 |       1 | M1201  |           1
 M1104  | Introduction aux bases de données | S1     |  3.5 |           10 |           25 |           25 |     7 |       2 | M1104  |           1
 M1203  | Environnement économique          | S1     |  1.5 |           10 |           10 |           10 |    16 |       3 | M1203  |           1
 M3103  | Algorithmique avancée             | S3     |  1.5 |            8 |           10 |           12 |     5 |       4 | M3103  |           1
 M3104  | Programmation Web côté serveur    | S3     |  2.5 |           15 |           14 |           16 |    18 |       5 | M3104  |           1
 M3106C | Bases de données avancées         | S3     |  1.5 |            8 |           10 |           12 |     7 |       6 | M3106C |           1
(6 rows)
*/

-- 10.
SELECT intitule, enseignant.nom, enseignant.prenom FROM module INNER JOIN enseignant ON module.idens=enseignant.idens WHERE classe='S1';
/*
                          intitule                           |       nom        |   prenom    
-------------------------------------------------------------+------------------+-------------
 Introduction aux systèmes informatiques                     | Delmas           | Guylain
 Introduction à l'algorithmique et à la programmation        | Rety             | Jean-Hugues
 Structures de données et algorithmes fondamentaux           | Rety             | Jean-Hugues
 Introduction aux bases de données                           | Lamolle          | Myriam
 Conception de documents et d'interfaces numériques          | Rety             | Jean-Hugues
 Projet Tutoré - Découverte                                  | Rety             | Jean-Hugues
 Mathématiques discrètes                                     | Homps            | Marc
 Algèbre linéaire                                            | Bonnot           | Philippe
 Environnement économique                                    | Clément-Comparot | Véronique
 Fonctionnement des organisations                            | Bonnot           | Philippe
 Expression communication - Fondamentaux de la communication | Golven           | Amélie
 Anglais et Informatique                                     | Golven           | Amélie
 PPP - Connaître le monde professionnel                      | Golven           | Amélie
(13 rows)
*/

-- 11.
SELECT DISTINCT (nom, prenom) FROM etudiant INNER JOIN notes ON etudiant.idetud=notes.idetud;
/*
        row        
-------------------
 (Baggage,Charles)
 (Lovelace,Ada)
 (Meyer,Bertrand)
 (Turing,Alan)
 (Wirth,Niklaus)
(5 rows)
*/

-- 12.
SELECT DISTINCT nom, prenom, module.intitule FROM etudiant, interro INNER JOIN module ON interro.refmod=module.refmod;
/*
    nom     |  prenom  |             intitule              
------------+----------+-----------------------------------
 Baggage    | Charles  | Algorithmique avancée
 Baggage    | Charles  | Bases de données avancées
 Baggage    | Charles  | Environnement économique
 Baggage    | Charles  | Introduction aux bases de données
 Baggage    | Charles  | Mathématiques discrètes
 Baggage    | Charles  | Programmation Web côté serveur
 Berner-Lee | Tim      | Algorithmique avancée
 Berner-Lee | Tim      | Bases de données avancées
 Berner-Lee | Tim      | Environnement économique
 Berner-Lee | Tim      | Introduction aux bases de données
 Berner-Lee | Tim      | Mathématiques discrètes
 Berner-Lee | Tim      | Programmation Web côté serveur
 Berry      | Gérard   | Algorithmique avancée
 Berry      | Gérard   | Bases de données avancées
 Berry      | Gérard   | Environnement économique
 Berry      | Gérard   | Introduction aux bases de données
 Berry      | Gérard   | Mathématiques discrètes
 Berry      | Gérard   | Programmation Web côté serveur
 Lovelace   | Ada      | Algorithmique avancée
 Lovelace   | Ada      | Bases de données avancées
 Lovelace   | Ada      | Environnement économique
 Lovelace   | Ada      | Introduction aux bases de données
 Lovelace   | Ada      | Mathématiques discrètes
 Lovelace   | Ada      | Programmation Web côté serveur
 Meyer      | Bertrand | Algorithmique avancée
 Meyer      | Bertrand | Bases de données avancées
 Meyer      | Bertrand | Environnement économique
 Meyer      | Bertrand | Introduction aux bases de données
 Meyer      | Bertrand | Mathématiques discrètes
 Meyer      | Bertrand | Programmation Web côté serveur
 TALON      | Achille  | Algorithmique avancée
 TALON      | Achille  | Bases de données avancées
 TALON      | Achille  | Environnement économique
 TALON      | Achille  | Introduction aux bases de données
 TALON      | Achille  | Mathématiques discrètes
 TALON      | Achille  | Programmation Web côté serveur
 Turing     | Alan     | Algorithmique avancée
 Turing     | Alan     | Bases de données avancées
 Turing     | Alan     | Environnement économique
 Turing     | Alan     | Introduction aux bases de données
 Turing     | Alan     | Mathématiques discrètes
 Turing     | Alan     | Programmation Web côté serveur
 Wirth      | Niklaus  | Algorithmique avancée
 Wirth      | Niklaus  | Bases de données avancées
 Wirth      | Niklaus  | Environnement économique
 Wirth      | Niklaus  | Introduction aux bases de données
 Wirth      | Niklaus  | Mathématiques discrètes
 Wirth      | Niklaus  | Programmation Web côté serveur
(48 rows)
*/
-- 13.
SELECT nom, prenom FROM etudiant INNER JOIN notes ON etudiant.idetud=notes.idetud WHERE notes IS NULL;
/*
  nom  | prenom  
-------+---------
 Wirth | Niklaus
(1 row)
*/

-- 14.
SELECT DISTINCT nom, prenom FROM personnel WHERE (nom, prenom) NOT IN (SELECT nom, prenom FROM enseignant);
/*
    nom    |   prenom    
-----------+-------------
 Baboulall | Marielle
 Dafaoui   | El Mouloudi
 Filoche   | Eddy
 Kaiser    | Marc
 Hassoun   | Abdallah
 Tudor     | Carmen
 Emonides  | Mireille
 Bayoud    | Khadija
(8 rows)
*/

-- Exercice 2

-- 1.

