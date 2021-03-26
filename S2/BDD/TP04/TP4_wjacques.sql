-- -- Ex 1

-- -- 1.
-- select * from enseignant order by nom;

-- -- 2.
-- declare
--     curs cursor with hold for
--         select * from enseignant order by nom asc;

-- fetch first curs;
-- fetch 2 curs;
-- move last curs;
-- fetch next curs;
-- move first curs;
-- fetch 0 curs;
-- fetch all curs;
-- fetch prior curs;
-- move backward 5 curs;
-- fetch 0 curs;
-- move absolute 1 curs;
-- fetch prior curs;
-- close curs;

-- Ex 2
set search_path to rec;

-- 1.
CREATE OR REPLACE FUNCTION convertMinut2Int(t time)
RETURNS integer AS
$$
DECLARE
    varHeure2minute INTEGER;
    varMinute INTEGER;
BEGIN
    SELECT (EXTRACT( HOUR FROM  t) * 60) INTO varHeure2minute;
    SELECT (EXTRACT (MINUTES FROM t)) INTO varMinute;
    RETURN varHeure2minute + varMinute;
END;
$$ LANGUAGE plpgsql;

declare
    cursRecette cursor with hold for
        select titre, nbpartmax, categorie, convertMinut2Int(tpsprepa) + convertMinut2Int(tpscuisson) as tpsTotal
        from recette where tpsprepa is not null
        order by tpsTotal desc
        limit 3;

-- fetch all cursRecette;

-- 2.
CREATE OR REPLACE FUNCTION fonctCurseurTempsRecette()
RETURNS refcursor AS
$$
declare
    ref refcursor;
    rec record;
BEGIN
    open ref for
        select titre, max(convertMinut2Int(tpsprepa) + convertMinut2Int(tpscuisson)) as tpsTotal
        from recette where tpsprepa is not null
        group by titre order by tpstotal asc;

    fetch first from ref into rec;
    raise info '%', rec;
    fetch last from ref into rec;
    raise info '%', rec;

    return ref;
END;
$$ LANGUAGE plpgsql;

select fonctCurseurTempsRecette();


close cursRecette;