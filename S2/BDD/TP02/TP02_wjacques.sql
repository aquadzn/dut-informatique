-- Exercice 0

-- 1.
-- Vrai

-- 2.
-- Une fonction VOLATILE peut tout faire, y compris modifier la base de données
-- Une fonction STABLE ne peut pas modifier la base de données et est garantie de renvoyer les mêmes résultats si elle est appelée avec les mêmes arguments pour toutes les lignes à l'intérieur d'une même instruction
-- Une fonction IMMUTABLE ne peut pas modifier la base de données et est garantie de toujours renvoyer les mêmes résultats si elle est appelée avec les mêmes arguments

-- 3.
-- C'est pour informer l'optimiseur sur le comportement de la fonction

-- 4.
-- Vrai

-- 5.
-- e)

-- 6.
-- Next retourne le prochain et query l'ensemble


-- Exercice 1
SET search_path TO bookbay;

-- 1.
CREATE OR REPLACE FUNCTION prixHorsTVA(prix float)
RETURNS numeric(4,2) AS $$
    SELECT round(prix * 0.804);
$$ LANGUAGE sql;

SELECT prixHorsTVA(51.283);

-- 2.
CREATE OR REPLACE FUNCTION nomAuteur(nomA varchar)
RETURNS SETOF RECORD AS $$
    SELECT identifiant_auteur FROM auteurs WHERE nom LIKE nomA LIMIT 1;
$$ LANGUAGE sql;

SELECT nomAuteur('Morel');

-- 3.
CREATE OR REPLACE FUNCTION nomAuteur(nomA varchar)
RETURNS SETOF RECORD AS $$
    SELECT identifiant_auteur FROM auteurs WHERE nom LIKE nomA;
$$ LANGUAGE sql;

SELECT nomAuteur('Gu%');

-- 4.
CREATE OR REPLACE FUNCTION prixMoyen(codeCollection integer)
RETURNS numeric(4,2) AS $$
    SELECT avg(prix) FROM livres WHERE code_collection = codeCollection;
$$ LANGUAGE sql;

SELECT prixMoyen(3);

-- 5. pourquoi ca devrait prendre une personne en argument ??
CREATE OR REPLACE FUNCTION detailsResponsables(codeEntrepot integer)
RETURNS SETOF RECORD AS $$
    SELECT 'Le responsable ' || (responsable).prenom || ' ' || (responsable).nom
        || ' a ' || extract(YEAR FROM age(CURRENT_DATE, (responsable).naissance))
        || ' ans.'
    FROM entrepots
    WHERE code_entrepot = codeEntrepot;
$$ LANGUAGE sql;

SELECT detailsResponsables(1);


-- Exercice 2

-- 1.
CREATE OR REPLACE FUNCTION comptageLignes(nomTable varchar)
RETURNS text AS $$
DECLARE
    nombreLignes integer;
begin
    if (select exists (select relname from pg_class where relname = nomTable)) then 
        execute 'select count(*) FROM ' || nomTable
            into nombreLignes;
        return 'Il y a ' || nombreLignes || ' lignes dans la table ' || nomTable;
    else
        return 'Table inexistante';
    end if;
end;
$$ language plpgsql;

SELECT comptageLignes('livres');
SELECT comptageLignes('AAA');

-- 2.
CREATE OR REPLACE FUNCTION nbColonnesTable(nomTable varchar)
RETURNS text AS $$
DECLARE
    nombreColonnes integer;
begin
    if (select exists (select relname from pg_class where relname = nomTable)) then 
        execute 'select relnatts from pg_class where relname = ' || nomTable
            into nombreColonnes;
        return 'Il y a ' || nombreColonnes || ' colonnes dans la table ' || nomTable;
    else
        return 'Table inexistante';
    end if;
end;
$$ language plpgsql;

SELECT nbColonnesTable('livres');
-- SELECT nbColonnesTable('AAA');
