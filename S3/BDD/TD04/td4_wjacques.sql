/*
-- auteur: William JACQUES
-- date création: 27/09/2021
-- sujet: TD04
*/

-- Ex 1

-- 2.
drop table if exists enseignant1;
drop table if exists module1;
create table if not exists enseignant1 as select * from enseignant;
create table if not exists module1 as select * from module;

-- 4
drop function check_pk_enseignant() cascade;

create function check_pk_enseignant() returns trigger as $$
    begin
        perform idens from enseignant1 where idens = NEW.idens;
        if (FOUND) then
            raise exception 'numéro déjà affecté à un enseignant';
        end if;
        return new;
    end;
$$ language plpgsql;

create TRIGGER trig_pkEnseignant1
    before insert or update of idens on enseignant1
    for each row
    execute procedure check_pk_enseignant();

-- 5.
insert into enseignant1(idens) values (null);
-- ca marche
update enseignant1 set idens = null where idens = 5;
-- ca marche
insert into enseignant1(idens) values (5);
-- ca marche
update enseignant1 set idens = 5 where idens = 7;
-- ca marche pas car on a déjà un enseignant avec 5
insert into enseignant1(idens) values (100);
-- ca marche
update enseignant1 set nom = 'William' where idens = 100;
-- ca marche pas
delete from enseignant1 where idens = 100;
-- ca marche

-- 6.
drop function check_fk_ens_mod() cascade;

create function check_fk_ens_mod() returns trigger as $$
    begin
        if (TG_OP = 'INSERT' or TG_OP = 'UPDATE') then
            perform idens from enseignant1 where idens = NEW.idens;
            if (not FOUND) then
                raise exception 'clé étrangère inexistante';
            end if;
            return new;        
        elsif (TG_OP = 'DELETE') then
            perform idens from module1 where idens = OLD.idens;
            if (FOUND) then
                raise exception 'idens du tuple supprimé est présent dans module1';
            end if;
            return old;
        end if;
    end;
$$ language plpgsql;

create TRIGGER trig_fkModule1
    before insert or update of idens on module1
    for each row
    execute procedure check_fk_ens_mod();

create TRIGGER trig_fkDeleteModule1
    before delete on enseignant1
    for each row
    execute procedure check_fk_ens_mod();

-- 7.
insert into module1(refmod, idens) values ('M5', 100);
-- ca marche pas
update module1 set idens = 100 where refmod like 'M3103';
-- ca marche pas
update module1 set idens = 15 where refmod like 'M3103';
-- ca marche
update enseignant1 set idens = 110 where idens = 7;
-- ca marche
delete from enseignant1 where idens = 7;
-- ca marche mais rien à supprimer


-- Ex 2

-- pas accès au script bookbay
-- set search_path to bookbay;

-- -- 1.
-- drop function verifDateEditPublie() cascade;

-- create function verifDateEditPublie() returns trigger as $$
--     begin
--         if (NEW.depot_legal > select date_creation from editions where date_creation = NEW.) then
--             raise exception 'clé étrangère inexistante';
--         end if;
--         return new;        
--     end;
-- $$ language plpgsql;

-- create TRIGGER trig_verifDateEditPublie
--     before insert or update of depot_legal on module1
--     for each row
--     execute procedure verifDateEditPublie();
