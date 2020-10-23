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
SELECT np FROM soc.puf WHERE (nu, nf) IN (SELECT nu, nf FROM soc.usine AS u, soc.fournisseur AS f WHERE u.ville = f.ville);
--  np 
-- ----
--   4
-- (1 row)

-- 9.
SELECT DISTINCT nomu FROM soc.usine AS u, soc.fournisseur AS f WHERE u.ville != f.ville;
--   nomu  
-- --------
--  usine4
--  usine1
--  usine2
--  usine3
--  usine5
-- (5 rows)

-- 10.
SELECT * FROM soc.fournisseur WHERE nf in (SELECT nf FROM soc.puf WHERE nu = 1 AND nf IN (SELECT nf FROM soc.puf WHERE nu = 2));
--  nf | nomf | statut | ville 
-- ----+------+--------+-------
-- (0 rows)

-- 11.
SELECT nomu FROM soc.usine WHERE nu IN (SELECT nu from soc.puf WHERE np IN (SELECT nf FROM soc.puf WHERE NF = 3));
--   nomu
-- --------
--  usine3
-- (1 row)

-- 12.
SELECT * FROM soc.usine WHERE nu NOT IN (SELECT nu FROM soc.usine WHERE nu IN (SELECT nu FROM soc.puf WHERE np IN (SELECT np FROM soc.produit WHERE couleur LIKE 'rouge') AND nf IN (SELECT nf FROM soc.fournisseur WHERE ville LIKE 'Londres')));
--  nu |  nomu  |   ville
-- ----+--------+-----------
--   2 | usine2 | Paris
--   3 | usine3 | Londres
--   4 | usine4 | Londres
--   5 | usine5 | Bruxelles
-- (4 rows)

-- 13.


-- 14.


-- 15.
SELECT DISTINCT * FROM soc.usine WHERE nu IN (SELECT nu FROM soc.puf WHERE nf = 3 AND nu NOT IN (SELECT nu FROM soc.puf WHERE nf != 3));
--  nu |  nomu  |  ville  
-- ----+--------+---------
--   3 | usine3 | Londres
-- (1 row)

-- Exercice 3

-- 1.
select nom, prenom, acronyme, ville FROM candidat INNER JOIN baccalaureat ON candidat.idbac = baccalaureat.idbac INNER JOIN ville ON candidat.cp = ville.cp;
--        nom       |            prenom            | acronyme |                 ville                 
-- -----------------+------------------------------+----------+---------------------------------------
--  TOA GHANDERI    | Mah                          | PRO      | (92600,"ASNIERES SUR SEINE")
--  MON             | Fouad                        | PRO      | (93190,"LIVRY GARGAN")
--  MAQLIL          | Idriss                       | PRO      | (95490,VAUREAL)
-- ...
-- (2803 rows)

-- 2.
select DISTINCT nomville FROM candidat INNER JOIN baccalaureat ON candidat.idbac = baccalaureat.idbac INNER JOIN ville ON candidat.cp = ville.cp ;
--           nomville           
-- -----------------------------
--  VILLENEUVE ST GEORGES
--  CLERY ST ANDRE
--  ROZAY EN BRIE
-- ...
-- (369 rows)

-- 3.
