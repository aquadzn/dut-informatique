-- Auteur: wjacques
-- Il manque l'exercice 1 qui est chez moi

-- Exercice 2

-- 1.
SELECT nu, nomu, ville FROM soc.usine;
--  nu |  nomu  |   ville   
-- ----+--------+-----------
--   1 | usine1 | Paris
--   2 | usine2 | Paris
--   3 | usine3 | Londres
--   4 | usine4 | Londres
--   5 | usine5 | Bruxelles
-- (5 rows)

-- 2.
SELECT nu, nomu, ville FROM soc.usine WHERE ville = 'Londres';
--  nu |  nomu  |  ville  
-- ----+--------+---------
--   3 | usine3 | Londres
--   4 | usine4 | Londres
-- (2 rows)

-- 3.
SELECT nf FROM soc.puf WHERE nu = 1 AND np = 1;
--  nf 
-- ----
--   1
--   5
-- (2 rows)

-- 4.
SELECT nomp, couleur FROM soc.produit WHERE np IN (SELECT np FROM soc.puf WHERE nf = 1);
--  nomp  | couleur 
-- -------+---------
--  Lego1 | rouge
--  Lego5 | blanc
-- (2 rows)

-- 5.
SELECT nf FROM soc.puf WHERE nu = 1 AND np IN (SELECT np FROM soc.produit WHERE couleur LIKE 'rouge');
--  nf 
-- ----
--   1
--   5
-- (2 rows)

-- 6.
SELECT nomf FROM soc.fournisseur WHERE nf IN (SELECT nf FROM soc.puf WHERE nu IN (SELECT nu FROM soc.usine WHERE ville LIKE 'Paris' OR ville LIKE 'Londres')  AND np IN (SELECT np FROM soc.produit WHERE couleur LIKE 'rouge'));
--  nomf 
-- ------
--  frs1
--  frs5
-- (2 rows)

-- 7.
SELECT np FROM soc.puf WHERE nu IN (SELECT nu FROM soc.usine WHERE ville LIKE 'Londres') AND nf IN (SELECT nf FROM soc.fournisseur WHERE ville LIKE 'Londres');
--  np 
-- ----
--   4
-- (1 row)

-- 8.



-- 9.



-- 10.

