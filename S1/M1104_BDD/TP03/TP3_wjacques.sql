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
select nom, prenom, intitule from etudiant e, module m, interro i, notes n where n.idinter = i.idinter and n.idetud = e.idetud and m.refmod = i.refmod;
/*
   nom    |  prenom  |             intitule              
----------+----------+-----------------------------------
 Meyer    | Bertrand | Mathématiques discrètes
 Wirth    | Niklaus  | Mathématiques discrètes
 Meyer    | Bertrand | Introduction aux bases de données
 Wirth    | Niklaus  | Introduction aux bases de données
 Turing   | Alan     | Environnement économique
 Lovelace | Ada      | Environnement économique
 Baggage  | Charles  | Environnement économique
 Meyer    | Bertrand | Algorithmique avancée
 Wirth    | Niklaus  | Algorithmique avancée
 Meyer    | Bertrand | Programmation Web côté serveur
 Wirth    | Niklaus  | Programmation Web côté serveur
 Meyer    | Bertrand | Bases de données avancées
(12 rows)
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

-- 15.
SELECT * FROM etudiant INNER JOIN enseignant ON (etudiant.nom, etudiant.prenom) = (enseignant.nom, enseignant.prenom);
-- idetud | nom | prenom | classe | idens | nom | prenom | titulaire | iddept 
-- --------+-----+--------+--------+-------+-----+--------+-----------+--------
-- (0 rows)

-- Exercice 2

-- 1.
\dt entelec.*
/*
             List of relations
 Schema  |     Name      | Type  |  Owner   
---------+---------------+-------+----------
 entelec | absence       | table | wjacques
 entelec | affecter      | table | wjacques
 entelec | avoirhabilit  | table | wjacques
 entelec | avoirqualif   | table | wjacques
 entelec | chantier      | table | wjacques
 entelec | client        | table | wjacques
 entelec | contrat       | table | wjacques
 entelec | habilitation  | table | wjacques
 entelec | personnel     | table | wjacques
 entelec | qualification | table | wjacques
(10 rows)
*/

-- 2.
SELECT DISTINCT pays FROM entelec.client;
/*
       pays        
-------------------
 France
 kanto
 equestria
 systeme Deneb
 PayDuSoleilLevant
 PayDuCaillou
 Beaucoup
 Lycee
(8 rows)
*/

-- 3.
SELECT * FROM entelect.client WHERE LOWER(rue) LIKE '%rue%';
/*
 idclt |     nomclt     |  prenom  |       rue        |  cp   |         ville         |       pays        
-------+----------------+----------+------------------+-------+-----------------------+-------------------
     1 | Pokemon        | Pikachu  | rue DuBuisson    |   717 | Bourg Palette         | kanto
     2 | Transistor     | Mos      | rue DuRadin      |     0 | STI2D                 | Lycee
     3 | Silver         | Surfer   | rue Spaceways    | 45689 | acoteDePluton         | systeme Deneb
     4 | La             | Chose    | rue DuCaillou    | 99999 | ToujoursDansLeCaillou | PayDuCaillou
     5 | WAS            | JaVoll   | rue Stalingrad   | 66666 | Berlin                | PayDuSoleilLevant
     6 | Pokemon        | Salamech | rue DuBuisson    |   717 | Bourg Palette         | kanto
     9 | LePetitBonhome | EnMousse | rue de la mousse | 44444 | CaMousse              | Beaucoup
    10 | Homps          | Marc     | rue tropbien     | 31415 | Montreuil             | France
(8 rows)
*/

-- 4.
SELECT DISTINCT nom, prenom from entelec.personnel;
/*
    nom    |  prenom   
-----------+-----------
 Lagaffe   | Gaston
 James     | Jesse
 Curie     | Marie
 Darc      | Jeanne
 Jane      | Calamity
 Plombier  | Mario
 Skywalker | Luke
 Princesse | Leïa
 Wookie    | Chewbacca
 Skywalker | Anakin
 Flam      | Capitaine
(11 rows)
*/

-- 5.
SELECT * FROM entelec.contrat WHERE duree LIKE 'CDD';
/*
 idcontrat |                 libelle                  | duree |  datedeb   |  datefin   
-----------+------------------------------------------+-------+------------+------------
         1 | remise aux normes des prises électriques | CDD   | 2002-06-10 | 2008-06-10
         3 | rénovation du système électrique         | CDD   | 2003-06-10 | 2009-06-10
         5 | responsable logistique                   | CDD   | 2004-06-10 | 2008-06-10
         7 | ingénierie électrique                    | CDD   | 2005-06-10 | 2008-06-10
         9 | installation structure                   | CDD   | 2006-06-10 | 2008-06-10
(5 rows)
*/

-- 6.
SELECT * FROM entelec.personnel WHERE idcontrat IS NULL;
/*
 idpers |    nom    |  prenom   | salaire | idcontrat 
--------+-----------+-----------+---------+-----------
      6 | Princesse | Leïa      |    1300 |          
      7 | Darc      | Jeanne    |    2000 |          
      8 | Flam      | Capitaine |    1200 |          
      9 | Curie     | Marie     |    2000 |          
(4 rows)
*/

-- 7.
SELECT nomclt FROM entelec.client WHERE ville LIKE 'ponyville';
/*
 nomclt 
--------
 Hooves
(1 row)
*/

-- 8.
SELECT * FROM entelec.chantier WHERE datefin < '2011-01-01';
/*
 idcht |   intitule   | description |  datedeb   |  datefin   | dureeprevu |     rue     |  cp   | ville  |    pays    | idclt 
-------+--------------+-------------+------------+------------+------------+-------------+-------+--------+------------+-------
     2 | Château Fort | solide      | 1200-02-02 | 1250-02-02 | 30 ans     | rue MonFort | 45455 |  Lyon  | France     |     9
     4 | Pont         | utile       | 1995-02-05 | 2000-09-09 | 2 ans      | rue Hoche   | 95310 | Paris  | France     |     1
     6 | Parc         | lol         | 1452-02-03 | 1520-12-13 | 50 ans     | rue LOL     | 78954 | TROLOL | PatDuTroll |     6
(3 rows)
*/

-- 9.
SELECT * FROM entelec.chantier WHERE datedeb >= '2000-01-01' and datefin < '2011-01-01';
/*
 idcht | intitule | description | datedeb | datefin | dureeprevu | rue | cp | ville | pays | idclt 
-------+----------+-------------+---------+---------+------------+-----+----+-------+------+-------
(0 rows)
*/

-- 10.
SELECT * from entelec.chantier WHERE datefin < datedeb;
/*
 idcht | intitule | description | datedeb | datefin | dureeprevu | rue | cp | ville | pays | idclt 
-------+----------+-------------+---------+---------+------------+-----+----+-------+------+-------
(0 rows)
*/

-- 11.
SELECT intitule, couthoraire FROM entelec.qualification;
/*
                               intitule                                | couthoraire 
-----------------------------------------------------------------------+-------------
 Classif-Qualif Bâtiment / Ouvrier Exécution niv. I pos. 1 coef 150    |         8.3
 Classif-Qualif Bâtiment / Ouvrier Exécution niv. I pos. 2 coef 170    |         8.4
 Classif-Qualif Bâtiment / Ouvrier Profess. niv.II coef 185            |         9.4
 Classif-Qualif Bâtiment / Compagnon Profess. niv. III pos. 1 coef 210 |        10.4
 Classif-Qualif Bâtiment / Compagnon Profess. niv. III pos. 2 coef 230 |       10.85
 Classif-Qualif Bâtiment / Chef Equipe niv. IV pos. 1 coef 250         |       11.55
 Classif-Qualif Bâtiment / Chef Equipe niv. IV pos. 2 coef 270         |        12.5
 Classif-Qualif Bâtiment / ETAM niv. A                                 |       16.45
 Classif-Qualif Bâtiment / ETAM niv. B                                 |       18.72
 Classif-Qualif Bâtiment / Ingénieur ou assimilé débutant pos. A       |        10.5
(10 rows)
*/

-- 12.
SELECT DISTINCT nom, prenom FROM entelec.personnel INNER JOIN entelec.absence ON entelec.personnel.idpers = entelec.absence.idpers;
/*
    nom    |  prenom   
-----------+-----------
 James     | Jesse
 Darc      | Jeanne
 Plombier  | Mario
 Skywalker | Luke
 Wookie    | Chewbacca
 Flam      | Capitaine
 Skywalker | Anakin
(7 rows)
*/

-- 13.


-- 14.


-- 15.
