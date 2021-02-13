-- William JACQUES
-- B1

SET search_path TO iut;

-- Exercice 1.

-- 1)
CREATE OR REPLACE FUNCTION idPlus1()
RETURNS integer AS $$
    SELECT max(idetud) + 1 FROM etudiant;
$$ LANGUAGE sql;

SELECT idPlus1();

-- 2)
CREATE OR REPLACE FUNCTION moy_idetud(idEtudiant integer)
RETURNS SETOF RECORD AS $$
    SELECT avg(note) from etudiant natural join notes WHERE idEtud = idEtudiant;
$$ LANGUAGE sql;

SELECT moy_idetud(5);

-- 3)
CREATE OR REPLACE FUNCTION moy_nom(nomEtudiant varchar)
RETURNS SETOF RECORD AS $$
    SELECT avg(note) from etudiant natural join notes WHERE nom LIKE nomEtudiant;
$$ LANGUAGE sql;

SELECT moy_nom('Meyer');


-- 4)
CREATE OR REPLACE FUNCTION delbynum(idEnseignant integer)
RETURNS void AS $$
    DELETE FROM enseignant WHERE idens = idEnseignant;
$$ LANGUAGE sql;

SELECT delbynum(23);

-- 5)
CREATE OR REPLACE FUNCTION delbynom(nomEnseignant varchar, prenomEnseignant varchar)
RETURNS void AS $$
    DELETE FROM enseignant WHERE nom LIKE nomEnseignant AND prenom LIKE prenomEnseignant;
$$ LANGUAGE sql;

SELECT delbynom('Georges', 'Rémy');

-- 6)
CREATE OR REPLACE FUNCTION augNot(augmentation integer, numInterro integer)
RETURNS void AS $$
    UPDATE notes n
    SET note = note + augmentation
    FROM interro i
    WHERE n.idinter = i.idinter AND n.idinter = numInterro;
$$ LANGUAGE sql;

SELECT augNot(2, 1);

-- 7)
CREATE OR REPLACE FUNCTION est_resp(idEnseignant integer)
RETURNS boolean AS $$
DECLARE
    module_prof integer;
begin
    select idens into module_prof from module natural join enseignant where idens = idEnseignant;
    if (not found) then
        return false;
    else
        return true;
    end if;
end;
$$ language plpgsql;

SELECT est_resp(5);
SELECT est_resp(0);

-- 8)
CREATE OR REPLACE FUNCTION resp(idModule varchar)
RETURNS text AS $$
DECLARE
    nom_resp text;
begin
    select concat(prenom, ' ', nom) into nom_resp
    from module natural join enseignant
    where refmod LIKE idModule;
    if (found) then
        return nom_resp;
    else
        return 'pas de responsable';
    end if;
end;
$$ language plpgsql;

SELECT resp('M1101');
SELECT resp('0');

-- 9)
CREATE OR REPLACE FUNCTION creerEtud(nomEtudiant varchar, classEtudiant varchar default 'S1')
RETURNS void AS $$
DECLARE
    nom_resp text;
    last_id integer;
begin
    select into last_id idPlus1();
    insert into etudiant (idEtud, nom, classe)
    values (last_id, nomEtudiant, classEtudiant);
end;
$$ language plpgsql;

SELECT creerEtud('TOTO', 'S2');
SELECT creerEtud('TITI', null);
SELECT creerEtud('Doe');

-- 10)
CREATE OR REPLACE FUNCTION delEtud(nomEtudiant varchar, classeEtudiant varchar)
RETURNS void AS $$
begin
    DELETE from notes
    USING etudiant e
    WHERE notes.idetud = e.idetud AND e.nom LIKE nomEtudiant AND e.classe LIKE classeEtudiant;
    DELETE FROM etudiant
    WHERE nom LIKE nomEtudiant AND classe LIKE classeEtudiant;
end;
$$ language plpgsql;

INSERT INTO etudiant VALUES (idPlus1(), 'Gates', 'Bill', 'S1');
INSERT INTO notes VALUES (1, 12, 13);
INSERT INTO notes VALUES (2, 12, 10);

SELECT delEtud('Gates', 'S1');
SELECT delEtud('Doe', '');
