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


-- 4 .
select nom from equipement where ideqt not in (select ideqt from reserver);
