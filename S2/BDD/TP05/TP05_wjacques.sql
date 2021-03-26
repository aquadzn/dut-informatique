-- Exercice 1.

-- 1.
create or replace view vueEns as
    select *
    from enseignant;

delete from vueEns where idens = 99;
insert into vueEns values (99, 'doe', 'john', 't', 'INFO');
select * from vueEns;
-- update vueEns idens = 100 where nom like 'doe';
-- select * from vueEns;

-- 2.
create or replace view vueNomPreEtud as
    select nom, prenom
    from etudiant;

select * from vueNomPreEtud;

-- 3.
create or replace view vueEtudS2 as
    select nom, prenom
    from etudiant
    where classe like 'S2';

select * from vueEtudS2;

-- 4.
create or replace view vueNotInf8 as
    select idinter
    from interro
    natural join notes
    where note < 8
    group by idinter;

select * from vueNotInf8;

-- 5.
create or replace view vueMoyenEtud as
    select nom, prenom, avg(note) moyenne
    from etudiant
    natural join notes
    group by nom, prenom;

select * from vueMoyenEtud;

-- 6.
create or replace view vueModInterro as
    select *
    from module
    where refmod in
        (select refmod from interro);

select * from vueModInterro;

-- 7.
create or replace view vueModResp as
    select refmod, intitule, classe, nom
    from enseignant
    natural join module;

select * from vueModResp;

-- 8.
create or replace view vueEtudAbsent as
    select *
    from etudiant
    natural join notes
    where note is null;

select * from vueEtudAbsent;

-- 9.
create or replace view vueNonEns as
    select distinct *
    from personnel
    where nom not in
        (select nom from enseignant);

select * from vueNonEns;
