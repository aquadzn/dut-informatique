-- Auteur: wjacques
-- 6 Novembre 2020
-- Le dépot du TP est pas le bon, celui du B1 est bloqué!
SET search_path TO genealogie;

-- Exercice 1

-- A)

-- 1.
SELECT * FROM parents;

-- 2.
SELECT COUNT(*) FROM parents;
-- 32 tuples de 2 éléments

-- 3.
SELECT COUNT(DISTINCT enfant) FROM parents;
--  count 
-- -------
--     16
-- (1 row)

-- 4.
SELECT MIN(age), MAX(age) FROM personne WHERE pers in (SELECT DISTINCT enfant FROM parents);
--  min | max 
-- -----+-----
--    2 |  35
-- (1 row)

-- 5.
SELECT AVG(age) FROM personne;
--          avg         
-- ---------------------
--  32.2857142857142857
-- (1 row)

-- 6.
SELECT AVG(age) FROM personne GROUP BY genre;
--          avg         | genre 
-- ---------------------+-------
--  32.3571428571428571 | F
--  32.2142857142857143 | M
-- (2 rows)

-- 7.
SELECT COUNT(enfant) FROM ecoles;
--  count 
-- -------
--      8
-- (1 row)

-- 8.
SELECT COUNT(enfant), ecole FROM ecoles GROUP BY ecole;
--  count |   ecole   
-- -------+-----------
--      2 | Paris
--      2 | Fontenay
--      4 | Montreuil
-- (3 rows)

-- B)

-- 9.
SELECT DISTINCT p.enfant, e.ecole FROM parents AS p INNER JOIN ecoles AS e ON p.enfant=e.enfant;
--    enfant    |   ecole   
-- -------------+-----------
--  Pierre      | Montreuil
--  Pierrette   | Montreuil
--  Jacques     | Paris
--  Annick      | Fontenay
--  Anne        | Montreuil
--  Jean-Michel | Fontenay
--  Pierrick    | Montreuil
--  Annette     | Paris
-- (8 rows)

-- 10.
SELECT parent FROM parents GROUP BY parent HAVING COUNT(enfant) > 2;
--      parent     
-- ----------------
--  Jacques_GP1_P1
--  Anne_P1
--  Pierre_M1
--  Pierre_P1
--  Jacques_GM1_P1
--  Anne_M1
-- (6 rows)

-- 11.
SELECT p.parent, e.ecole FROM parents AS p INNER JOIN ecoles AS e ON p.enfant=e.enfant;
-- parent   |   ecole   
-- ------------+-----------
--  Michel     | Fontenay
--  Michelle   | Fontenay
--  Jacques_P1 | Paris
--  Jacques_M1 | Paris
--  Pierre_P1  | Montreuil
--  Pierre_M1  | Montreuil
--  Pierre_P1  | Montreuil
--  Pierre_M1  | Montreuil
--  Pierre_P1  | Montreuil
--  Pierre_M1  | Montreuil
--  Anne_P1    | Montreuil
--  Anne_M1    | Montreuil
--  Anne_P1    | Paris
--  Anne_M1    | Paris
--  Anne_P1    | Fontenay
--  Anne_M1    | Fontenay
-- (16 rows)

-- 12.


-- 13.


-- 14.
SELECT p.parent FROM parents AS p LEFT JOIN ecoles AS e ON p.enfant=e.enfant WHERE e.enfant IS NULL;
-- parent
-- ----------------
--  Michel_P1
--  Michel_M1
--  Michel_P1
--  Michel_M1
--  Michelle_P2
--  Michelle_M2
--  Jacques_GP1_P1
--  Jacques_GM1_P1
--  Jacques_GP2_M1
--  Jacques_GM2_M1
--  Jacques_GP1_P1
--  Jacques_GM1_P1
--  Jacques_GP1_P1
--  Jacques_GM1_P1
--  Jacques_GP2_M1
--  Jacques_GM2_M1
-- (16 rows)

-- 15.



-- 16.

