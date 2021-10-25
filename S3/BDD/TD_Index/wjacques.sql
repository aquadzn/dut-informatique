-- Partie 1
-- 1.
CREATE TABLE T1 (id INT, A INT);
CREATE TABLE T2 (id INT, B INT);
INSERT INTO T1 SELECT generate_series(1, 20000) AS id, (1000 * random())::INT AS A;
INSERT INTO T2 SELECT generate_series(1,  1000) AS id, (1000 * random())::INT AS B;-- 2.
select * from t1 limit 10;
-- 3.
-- select * from t1, t2 where t1.a = t2.b;
-- 4.
-- plan d'exec 0.3ms et temps d'exec 11ms

-- avec index btree sur t1.a, plan d'exec 0.27ms et temps d'exec 18ms
-- plus de valeurs dans t1 donc l'index de t1 utilisé
-- en enlevant l'index t1.a, l'index t2.b est utlisé. tps d'exec 50ms
-- le hash index est utile pour comparer l'égalité
SET enable_hashjoin TO on;
create index on t1 using hash (a);

-- Partie 2
-- Ex 1.
-- 1)
create text search configuration fr (COPY = french);
-- 2)
-- T, F
-- 3)
alter text search configuration fr alter mapping for hword, hword_part, word with unaccent, french_stem ;
-- 4)
select to_tsvector('fr', 'une fois dans le répertoire contrib/unaccent du répertoire des sources') @@ to_tsquery('fr', 'répertoire');
select to_tsvector('fr', 'une fois dans le répertoire contrib/unaccent du répertoire des sources') @@ to_tsquery('fr', 'repertoire');
-- T, T
-- 5)
alter table bookbay.livres add column titre_vectorise tsvector;
update bookbay.livres set titre_vectorise = to_tsvector(titre);
-- 7)
explain select titre, titre_vectorise from bookbay.livres;
-- 8)
create index idxLivres_titreVectorise on bookbay.livres using gin(titre_vectorise);
-- 9)
-- le cout ne change pas
-- 10)
select titre, ts_rank(titre_vectorise, to_tsquery('amour')) from bookbay.livres where titre_vectorise @@ to_tsquery('amour') ;