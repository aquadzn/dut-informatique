set search_path to zoo;
-- Ex 0

-- on update la table et rollback va faire revenir au début
-- savepoint va suvegarder, rollback a pointControl et revient au dernier savepoint et rollback revient au début de la transaction
-- commit valide et envoi la transaction dans la bdd

-- Ex 1

-- 2) a)
-- i.
--  C2 = transaction annulée commandes ignorées
--  C3 = nombre max d'animaux 100
-- ii.
--  C2 = Nombre d'animaux 120
--  C3 = nombre max d'animaux 50
-- iii.
--  C2 = Nombre d'animaux 170
--  C3 = nombre max d'animaux 100

-- 3. oui c2 et c3 retournent des résultats différents selon là où on commit c1

-- Ex 2
begin transaction;
delete from animal where espece like 'Aigle' and nomanimal like 'Torondor';
prepare transaction 'DeleteTorondor_wjacques';
commit prepared 'DeleteTorondor_wjacques';
-- oui on peut valider la transaction après déconnexion
-- cela permet de valider en deux phases une transaction préalablement préparée

-- Ex 3
-- 1) c'est l'id de la transaction actuelle et comme il y a 5 commandes l'id incremente de 1 à chaque fois
-- 2) xmin est la transaction la moins récente et xmax la plus récente qui n'a pas encore été faite
insert into animal values('30', 'Akela', 'Loup', 't', now(), 'Russie', 3);
-- 3) le xmin de Akela est le même que le txid_current() de la question 2)
-- 6) pas d'erreur t1 validé
-- 7) oui on les voit je pense que c'est normal car on est en read committed, xmin correspond à l'id de la transaction t1
-- 8) non pas changé car pas commit, xmax a pris la valeur de la transaction de t3
-- 9) les insert de t1 ne sont pas dans t2, ils apparaissent seulement après les commit
-- 11) la mouette disparait de t1
-- 12) la mouette est toujours là mais xmax a changé de 0 à txid_current() de t1
-- 13) pas de différence?

-- Ex 4
begin transaction isolation level serializable;
select * from cage where nbmaxanimal > 40 for share;
-- 3) Pas de réponse, T2 se bloque

-- Ex 5
-- C3 a bloqué T1 car soucis de cohérence entre C2 et C3
-- en exécutant C4 dans T2, T1 est débloqué et C3 s'exécute
-- DÉTAIL : Process 24328 waits for ShareLock on transaction 5726382; blocked by process 23930.
-- Process 23930 waits for ShareLock on transaction 5726391; blocked by process 24328.
-- ASTUCE : See server log for query details.
-- CONTEXTE : while updating tuple (0,1) in relation "cage"

-- Ex 6
-- 1)
alter table animal drop constraint fk_animal_cage ;
alter table animal add foreign key (numcage) references cage(numcage) DEFERRABLE INITIALLY deferred;
begin;
set constraints animal_numcage_fkey deferred ;
end;

-- 2)
begin;
insert into animal values (100, 'Gringalas', 'Licorne', null, null, null, 999);
select * from animal;
insert into cage values (999, 'Imaginaire', 'féérique', null);
end;
-- NON car la contrainte de clé étrangère n'aurait pas été respectée

-- 3) set constraints all deferred?