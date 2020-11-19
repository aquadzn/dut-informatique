-- Auteur: wjacques
-- B1
-- 13 Novembre 2020
SET search_path TO centre;

-- Exercice 1

-- 1.
select nom, prenom from membre where parrain is not null and adresse like 'Montreuil';

-- 2.
select nom from equipement where nom like '%Tennis%' ;

-- 3.
<<<<<<< HEAD

=======
select distinct m3.nom from membre m1 inner join membre m2 on m1.idmem = m2.parrain inner join membre m3 on m3.idmem = m2.parrain;
>>>>>>> 760ada75f9b57c08d7384a0c6378fb3aafd8fcf6

-- 4 .
select nom from equipement where ideqt not in (select ideqt from reserver);
