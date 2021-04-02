-- Exercice 1.

-- 1.
create or replace view vueEns as
    select *
    from enseignant;

select * from vueEns;
insert into vueEns values (99, 'doe', 'john', 't', 'INFO');
select * from vueEns;
update vueEns set idens = 999 where nom like 'doe';
select * from vueEns;
delete from vueEns where idens = 999;

-- 2.
create or replace view vueNomPreEtud as
    select nom, prenom
    from etudiant;

select * from vueNomPreEtud;
insert into vueNomPreEtud values ('doe', 'john');
-- pas possible contrainte null pour les 2 autres attributs
select * from vueNomPreEtud;
update vueNomPreEtud set prenom = 'jean' where nom like 'doe';
select * from vueNomPreEtud;
delete from vueNomPreEtud where nom like 'doe';

-- 3.
create or replace view vueEtudS2 as
    select *
    from etudiant
    where classe like 'S2';

select * from vueEtudS2;
insert into vueEtudS2 values (99, 'doe', 'john', 'S2');
select * from vueEtudS2;
update vueEtudS2 set prenom = 'jean' where nom like 'doe';
select * from vueEtudS2;
delete from vueEtudS2 where nom like 'doe';

-- 4.
create or replace view vueNotInf8 as
    select idinter
    from interro
    natural join notes
    where note < 8
    group by idinter;

select * from vueNotInf8;
-- erreur
-- insert into vueNotInf8 values (99);
-- select * from vueNotInf8;
-- update vueNotInf8 set idinter = 999 where idinter = 99;
-- select * from vueNotInf8;
-- delete from vueNotInf8 where idinter = 99;

-- 5.
create or replace view vueMoyenEtud as
    select nom, prenom, avg(note) moyenne
    from etudiant
    natural join notes
    group by nom, prenom;

select * from vueMoyenEtud;
-- erreur

-- 6.
create or replace view vueModInterro as
    select *
    from module
    where refmod in
        (select refmod from interro);

select * from vueModInterro;
insert into vueModInterro values ('M1199', 'Test', 'S1', 4.5, 10, 25, 25, 7);
update vueModInterro set intitule = 'TEST' where refmod like 'M1199';
--erreur update
select * from vueModInterro;
delete from vuemodinterro where refmod like 'M1199';
-- erreur delete
delete from module where refmod like 'M1199';

-- 7.
create or replace view vueModResp as
    select refmod, intitule, classe, nom
    from enseignant
    natural join module;

select * from vueModResp;
-- erreur

-- 8.
create or replace view vueEtudAbsent as
    select *
    from etudiant
    natural join notes
    where note is null;

select * from vueEtudAbsent;
-- erreur

-- 9.
create or replace view vueNonEns as
    select distinct *
    from personnel
    where nom not in
        (select nom from enseignant);

select * from vueNonEns;
-- erreur update
-- erreur delete