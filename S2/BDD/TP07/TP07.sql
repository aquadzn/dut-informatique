-- Ex 1
create view vueEtudS2 as
    select *
    from etudiant
    where classe like 'S2';

-- 1.
insert into etudiant values (100, 'Toto', null, 'S2');
insert into etudiant values (101, 'Truc', null, 'S4');

-- 2.
insert into vueEtudS2 values (200, 'Fourcade', 'Martin', 'S4');

-- 3.
select * from vueEtudS2 order by idetud;
select * from etudiant order by idetud;

-- 4.
delete from vueEtudS2 where idetud = 200;
drop view if exists vueEtudS2;

-- 5.
create view vueEtudS2 as
    select *
    from etudiant
    where classe like 'S2'
    with check option;

insert into vueEtudS2 values (200, 'Fourcade', 'Martin', 'S4');
delete from etudiant where idetud = 101;

-- 6.
select * from vueEtudS2 order by idetud;
select * from etudiant order by idetud;
-- permet de modifier les données cachées utilisées par une vue
delete from etudiant where idetud = 100;
delete from etudiant where idetud = 200;

-- Ex 2

drop view if exists vuePersonnel;

-- 1.
create view vuePersonnel as
    select *
    from personnel;

-- 2.
select * from vuePersonnel;

-- 3.
alter table personnel
    add column if not exists dept varchar(32) default 'Informatique';

-- 4.
select * from personnel;

-- 5.
select * from vuePersonnel;
-- vue pas à jour avec la table personnel

-- 6.
drop view if exists vuePersonnel;

-- 7.
create view vuePersonnel as
    select *
    from personnel;

-- 8.
select * from vuePersonnel;

-- 9.
ALTER TABLE personnel
    ALTER COLUMN dept
        SET DEFAULT 'IUT';

-- 10.
insert into personnel values (100, 'Toto', null, 'chomeur');

-- 11.
insert into vuePersonnel values (101, 'Titi', null, 'chomeur');

-- 12.
select * from personnel;
select * from vuePersonnel;
-- Pareil

-- 13.
alter view vuePersonnel rename to listPersonnel;

-- 14.
alter table personnel
    alter column dept
        drop default;

-- 15.
insert into listPersonnel values (102, 'Tata', null, 'chomeuse');

-- 16.
select * from personnel;

-- 17.
delete from personnel where idpers in (100, 101, 102);

-- 18.
select table_name from information_schema.views where table_schema = 'public';

create or replace function retainView(viewNameToRetain varchar)
returns void as $$
declare
    tblName varchar;
begin
    for tblName in
        select table_name from information_schema.views 
        where table_schema = 'public' and 
        view_definition is not null and table_name <> viewNameToRetain
    loop
        execute 'DROP VIEW IF EXISTS ' || tblName || ' ;';
    end loop;
    return;
end;
$$ language plpgsql;

select retainView('vueetuds2');
select table_name from information_schema.views where table_schema = 'public';
