-- TP07
-- wjacques

-- Exercice 1

-- 2.
select r.nom, r.prenom from rameur as r inner join testmuscu as t on r.idRameur = t.idRameur group by (r.nom, r.prenom) having count((t.idtest, t.idrameur, t.datetest)) >= 5;

-- 3.
select r.nom, r.prenom from rameur as r inner join footing as f on r.idRameur = f.idRameur WHERE f.distance > 1500  GROUP BY nom, prenom HAVING count((f.idRameur, f.datFooting)) >= 2;

-- 4.
select r.nom, r.prenom from rameur as r inner join ergometre as e on r.idRameur = e.idRameur GROUP BY r.nom, r.prenom HAVING count(e.idErgo) >= 3 and avg(tps2000) < '00:06:00';

-- 5.
select nom, prenom from rameur natural join testmuscu natural join typetest  where  nomtest like 'max squat' group by idRameur having sum(resultat) > 500 and count(idtest)>=3 order by nom, prenom;

-- 6.
       select idRameur from rameur natural join ergometre  group by  idRameur having  count(idErgo)>10   as NombreErgoSup10 ;