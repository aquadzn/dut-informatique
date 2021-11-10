/*
Base de données sur le cinéma
Auteur : Philippe Bonnot
Date création : 2015
D'après 'Bases de données, de la modélisation au SQL' Ed Ellipses
*/
drop schema if exists cinema_schema cascade;
create schema cinema_schema;
drop table if exists cinema_schema.personne cascade;
drop table if exists cinema_schema.film cascade;
drop table if exists cinema_schema.jouer cascade;
drop table if exists cinema_schema.cinema cascade;
drop table if exists cinema_schema.projection cascade;

create table cinema_schema.personne (
	id_personne INT PRIMARY KEY,
	nom VARCHAR(32),
	prenom VARCHAR(32)
);

create table cinema_schema.film (
	id_film INT PRIMARY KEY,
	id_realisateur INT references cinema_schema.personne(id_personne),
	titre VARCHAR(64) ,
    genre varchar(32),
	annee int
);

create table cinema_schema.jouer(
	id_acteur INT references cinema_schema.personne(id_personne),
	id_film INT references cinema_schema.film(id_film),
	primary key(id_acteur,id_film),
	role varchar(32)
);

create table cinema_schema.cinema (
	id_cinema int primary key,
	nom VARCHAR(32),
 	adresse VARCHAR(144)
);

create table cinema_schema.projection (
	id_cinema INT references cinema_schema.cinema(id_cinema),
	id_film int references cinema_schema.film(id_film),
	jour date,
	primary key(id_cinema,id_film,jour)
);

-- table personne
insert into cinema_schema.personne (id_personne,nom, prenom) VALUES 
	(1, 'Kidman','Nicole'),
	(2, 'Bettany','Paul'),
	(3, 'Watson','Emily'),
	(4, 'Skarsgard','Stellan'),
	(5,'Huston','John'),
	(6,'L.Jackson','Samuel'),
	(7,'Willis','Bruce'),
	(8,'Irons','Jeremy'),
	(9,'Spader','James'),
	(10,'Hunter','Holly'),
	(11,'Arquette','Rosanna'),
	(12,'Wayne','John'),
	(13,'Von Trier','Lars'),
	(14,'Tarantino','Quentin'),
	(15,'Cronenberg','David'),
	(16,'Mazursky','Paul'),
	(17,'Jones','Grace'),
	(18,'Glen','John'),
	(19,'Eastwood','Clint'),
	(20,'Spacey','Kevin'),
	(21,'Mendes','Sam'),
	(22,'Jolie','Angelina'),
	(23,'Steward','James'),
	(24,'Daves','Delmer'),
	(25,'Hepburn','Audrey'),
	(26,'Cukor','Georges');


-- table film
insert into cinema_schema.film (id_film,id_realisateur,titre,genre,annee) VALUES 
	(1,15,'Crash','Drame',1996),
	(2,15,'Faux-Semblants','Epouvante',1988),
	(3,14,'Pulp Fiction','Policier',1994),
	(4,13,'Breaking the waves','Drame',1996),
	(5,13,'Dogville','Drame',2002),
	(6,12,'Alamo','Western',1960),
	(7,18,'Dangereusement vôtre','Espionnage',1985),
	(8,19,'Chasseur blanc, coeur noir','Drame',1989),
	(9,19,'Minuit dans le jardin du bien et du mal','policier,Drame',1997),
	(10,21,'American beauty','Drame',1999),
	(11,24,'La flèche brisée','Western',1953),
	(12,26,'My fair lady','Comédie musicale',1964),
	(13,5,'Le vent de la plaine','Western',1960);
	
-- table jouer
insert into cinema_schema.jouer (id_acteur,id_film,role) VALUES 
	(1,5,'Grace'),(2,5,'Tom Edison'),(3,4,'Bess'),(4,4,'Jan'),(25,13,'Rachel'),
	(6,3,'Jules Winnfield'),(7,3,'Butch Coolidge'),(8,2,'Beverly et Elliot Mantle'),
	(9,1,'James Ballard'),(10,1,'Helen Remington'),(11,1,'Gabrielle'),(4,5,'Chuck'),
	(16,7,'May Day'),(19,8,'John Wilson'),(20,9,'Jim Williams'),(20,10,'Lester Burnham'),
	(23,11,'Tom Jeffords'),(25,12,'Eliza Doolittle');




--table cinema
insert into cinema_schema.cinema (id_cinema,nom,adresse) values
	(1,'Le Meliès','93100 Montreuil'),
	(2,'Pathé Beaux Arts','25000 Besançon'),
	(3,'Le Kosmos','94120 Fontenay-sous-bois'),
	(4,'Espace Ciné','93800 Epinay siur Seine');

--table projection vide
	









