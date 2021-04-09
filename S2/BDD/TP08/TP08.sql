set search_path to stock;

-- Ex 1.
create or replace view operationsEmploye as
    select o.* from operation o
    inner join effectuer ef on o.id = ef.idOperation
    inner join employe em on ef.idEmploye = em.id
    where em.nom like CURRENT_USER;

create or replace view operationsToday as
    select *
    from operationsEmploye
    where dateOp = CURRENT_DATE;

create or replace view operationsParJour as
    select dateOp, count(*)
    from operationsEmploye
    group by dateOp
    order by dateOp;

create or replace view operationsParSemaine as
    select date_part('year', dateOp::date) as annee,
    date_part('week', dateOp::date) as semaine,
    count(*)
    from operationsEmploye
    group by annee, semaine
    order by annee, semaine;

-- Ex 2.
create or replace view operationsUnite1 as
    select o.*, p.volume
    from operation o
    inner join produit p on o.idProduit = p.id
    where o.idUnite = 1;

create or replace view volumeEntree as
    select sum(p.volume)
    from operation o
    inner join produit p on o.idProduit = p.id
    where o.idUnite = 1 and nature like 'entree';

create or replace view volumeSortie as
    select sum(p.volume)
    from operation o
    inner join produit p on o.idProduit = p.id
    where o.idUnite = 1 and nature like 'sortie';

create or replace view volumeDisponible as
    select
    (select * from volumeEntree) - (select * from volumeSortie)
    as volumeDisponible;

-- Vue

create or replace view listeProduitsUnite1 as
    select distinct p.id, p.nom, p.volume
    from produit p
    inner join operation o on p.id = o.idProduit
    where o.idUnite = 1;

-- Ex 3.
create or replace view volumeProduitsEntree as
    select o.idUnite, p.nom, p.volume
    from operation o
    inner join produit p on o.idProduit = p.id
    where o.nature like 'entree'
    group by o.idUnite, p.nom, p.volume;

create or replace view volumeProduitsSortie as
    select o.idUnite, p.nom, p.volume
    from operation o
    inner join produit p on o.idProduit = p.id
    where o.nature like 'sortie'
    group by o.idUnite, p.nom, p.volume;

-- Vue

-- Ex 4.