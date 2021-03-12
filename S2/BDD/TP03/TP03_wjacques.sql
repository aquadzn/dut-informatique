-- Exercice 1

-- 1.
CREATE OR REPLACE FUNCTION circonference(IN rayon int)
RETURNS numeric AS $$
DECLARE
    PI float = pi();
begin
    return (PI * 2 * rayon)::numeric;
end
$$
IMMUTABLE
LANGUAGE plpgsql;

SELECT circonference(1);
SELECT circonference(30);

-- 2.
CREATE OR REPLACE FUNCTION decodeTitre(code int DEFAULT 1, abreviation VARCHAR(4) DEFAULT 'M')
RETURNS varchar(12) AS $$
begin
    RETURN CASE
        WHEN code = 1 THEN 'Monsieur' 
        WHEN code = 2 THEN 'Madame' 
        WHEN code = 3 THEN 'Mademoiselle' 
        WHEN code = 4 THEN 'Maître' 
        WHEN code = 5 THEN 'Monseigneur' 
        WHEN code = 6 THEN 'Son altesse' 
        WHEN code = 7 THEN 'Sa majesté' 
        WHEN UPPER(abreviation) IN ('M', 'MR') THEN 'Monsieur' 
        WHEN UPPER(abreviation) = 'MME' THEN 'Madame' 
        WHEN UPPER(abreviation) = 'MLE' THEN 'Mademoiselle' 
        WHEN UPPER(abreviation) = 'DR' THEN 'Docteur' 
        WHEN UPPER(abreviation) = 'MS' THEN 'Monseigneur' 
        WHEN UPPER(abreviation) = 'SA' THEN 'Son altesse' 
        WHEN UPPER(abreviation) = 'SM' THEN 'Sa majesté'
        ELSE ''
    end;
end
$$
LANGUAGE plpgsql;

SELECT decodeTitre(), decodeTitre(2), decodeTitre(NULL, 'mle');

-- 2.
-- Sans paramètres elle utilise les valeurs par défaut sinon elle utilise les paramètres passés en arguments

-- Exercice 3

-- 1.
CREATE OR REPLACE FUNCTION total_responsabilite(nomArg varchar(32) default '', prenomArg varchar(32) default '')
RETURNS text AS $$
DECLARE
    nb_modules int = 0;
    enseignant_row enseignant%rowtype;
begin
    select * from enseignant into enseignant_row
    where nom like nomArg and prenom like prenomArg;

    if not found then
        return 'Le prof n existe pas 0';
    else
        select count(*) into nb_modules
        from module natural join enseignant
        where nom like nomArg and prenom like prenomArg;
        return upper(nomArg) || ' ' || prenomArg || ' ' || nb_modules;
    end if;
end
$$
LANGUAGE plpgsql;

-- 2.
SELECT total_responsabilite('Toto');
SELECT total_responsabilite('Dubrulle', 'Philippe');
SELECT total_responsabilite('Lamolle', 'Myriam');

-- Exercice 4

-- 1.
CREATE OR REPLACE FUNCTION total_responsabilites()
RETURNS SETOF text AS $$
begin
    return query
        select upper(nom) || ' ' || prenom || ' ' || count(*) from enseignant e
        inner join module m on e.idens = m.idens
        group by (prenom, nom)
        order by nom asc;
    return query
        select upper(nom) || ' ' || prenom || ' ' || count(*) - 1 from enseignant e
        left join module m on e.idens = m.idens
        where m.idens is null
        group by (prenom, nom)
        order by nom asc;
end
$$
LANGUAGE plpgsql;

-- 2.
SELECT total_responsabilites();