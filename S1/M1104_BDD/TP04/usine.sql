/* ------------------------------------------------------------------------------------------
--	SCHEMA RELATIONEL soc pour la BD Usine vu en TD
-- 
-- auteur : M. Lamolle dateCreation : 2016-10-09

*/
-- vider la B.D.
drop schema if exists soc cascade;
create schema if not exists soc;

-- créer les tables
create table soc.usine (nu int, nomU varchar(128), ville varchar(32),
	constraint pk_nu primary key (nu) );

create table soc.produit (np int, nomP varchar(32), couleur varchar(12), poids int,
	constraint pk_np primary key (np) );

create table soc.fournisseur (nf int, nomF varchar(32), statut varchar(32), ville varchar(32),
	constraint pk_nf primary key (nf) );

create table soc.puf(np int, nu int, nf int, quantite int,
	constraint pk_puf primary key (np, nu, nf),
	constraint fk_puf_np foreign key (np) references soc.produit (np),
 	constraint fk_puf_nu foreign key (nu) references soc.usine (nu),
 	constraint fk_puf_nf foreign key (nf) references soc.fournisseur (nf) );


-- INSERTION 
insert into soc.usine values (1, 'usine1', 'Paris');
insert into soc.usine values ('2', 'usine2', 'Paris');
insert into soc.usine values ('3', 'usine3', 'Londres');
insert into soc.usine values ('4', 'usine4', 'Londres');
insert into soc.usine values ('5', 'usine5', 'Bruxelles');

insert into soc.produit values ('1', 'Lego1', 'rouge', 1);
insert into soc.produit values ('2', 'Lego2', 'bleu', 2);
insert into soc.produit values ('3', 'Lego3', 'vert', 3);
insert into soc.produit values ('4', 'Lego4', 'jaune', 4);
insert into soc.produit values ('5', 'Lego5', 'blanc', 5);
insert into soc.produit values ('6', 'Meccano1', 'rouge', 10);
insert into soc.produit values ('7', 'Meccano2', 'bleu', 20);
insert into soc.produit values ('8', 'Meccano3', 'vert', 30);
insert into soc.produit values ('9', 'Meccano4', 'jaune', 40);
insert into soc.produit values ('10', 'Meccano5', 'blanc', 50);
insert into soc.produit values ('11', 'Duplo1', 'rouge', 2);
insert into soc.produit values ('12', 'Duplo2', 'bleu', 4);
insert into soc.produit values ('13', 'Duplo3', 'vert', 6);
insert into soc.produit values ('14', 'Duplo4', 'jaune', 8);
insert into soc.produit values ('15', 'Duplo5', 'blanc', 10);

insert into soc.fournisseur values ('1', 'frs1', 'premier', 'Londres');
insert into soc.fournisseur values ('2', 'frs2', 'deuxième', 'Londres');
insert into soc.fournisseur values ('3', 'frs3', 'premier', 'Paris');
insert into soc.fournisseur values ('4', 'frs4', 'deuxième', 'Bruxelles');
insert into soc.fournisseur values ('5', 'frs5', 'premier', 'Copenhague');

insert into soc.puf values ('1', '1', '1', '100');
insert into soc.puf values ('2', '2', '2', '200');
insert into soc.puf values ('3', '3', '3', '300');
insert into soc.puf values ('4', '4', '4', '400');
insert into soc.puf values ('5', '5', '5', '500');
insert into soc.puf values ('1', '1', '5', '100');
insert into soc.puf values ('2', '2', '4', '200');
insert into soc.puf values ('13', '3', '3', '300');
insert into soc.puf values ('4', '4', '2', '400');
insert into soc.puf values ('5', '5', '1', '500');


