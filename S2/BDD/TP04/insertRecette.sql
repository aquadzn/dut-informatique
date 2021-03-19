-- ----------------------------------	--
-- SCHEMA DIET												--
-- objet : suivi diététique						--
-- création : 2016-02	version : V1.0	--
-- auteur : M. Lamolle								--
-- ----------------------------------	--

-- MISE EN PLACE du SCHEMA
-- ----------------------------------------
-- INSERSION DES RECETTES
\echo RAISE INFO 'INSERTION DES RECETTES'
-- 	idRect, titre, note,image, nbPartMin, nbPartMax, cout, tpsPrepa, tpsCuisson, pays, niveau,  textRec, conseil, categorie, idauteur
\echo RAISE INFO 'SALADE DE MAÏS ET DE BETTERAVES'
insert into rec.recette (idRect, titre, nbPartMax, niveau,  textRec, conseil, categorie) values (default, 'SALADE DE MAÏS ET DE BETTERAVES', 4, 'facile', 'Ouvrir la boîte de maïs et en égoutter soigneusement le contenu.
Éliminer la base des betteraves cuites puis les peler et les couper en petits dés.
Déposer tous les légumes dans un saladier.
Préparer la vinaigrette, la verser dans le saladier et mélanger.
Servir.
Confectionner la vinaigrette en délayant la moutarde avec le vinaigre, le sel et le poivre. Émulsionner avec l''huile. Mélanger et déguster sans attendre.', 'Les betteraves cuites sont également disponibles sous vide.', 'entrée froide');
-- 103 => id de maïs ; 13 => id de betterave, huile, moutarde, poivre, sel, vinaigre de vin
insert into rec.necessiter values (currval('rec.recette_idrect_seq'::regclass), 103, 1, 'petite boîte'), (currval('rec.recette_idrect_seq'::regclass), 13, 180, 'gr'), (currval('rec.recette_idrect_seq'::regclass), 89, 2, 'cuillère à soupe'), (currval('rec.recette_idrect_seq'::regclass), 158, 2, 'cuillère à café'), (currval('rec.recette_idrect_seq'::regclass), 159, 1, 'pincée'), (currval('rec.recette_idrect_seq'::regclass), 160, 1, 'pincée'), (currval('rec.recette_idrect_seq'::regclass), 161, 1, 'cuillère à soupe'); 

\echo RAISE INFO 'BIFTECK grillé sauce coco et coriandre'
insert into rec.recette (idRect, titre, nbPartMax, niveau,  textRec, categorie) values (default,
upper('Bifteck grillé sauce coco et coriandre'), 4, 'facile', 'Éplucher et émincer l''oignon finement.
Dans une poêle, le faire fondre 5 min dans de l''huile d''olive, puis ajouter le lait de coco et la coriandre hachée pour 5 min de cuisson.
Faire fondre à feu vif une noix de margarine dans une poêle et saisir la viande 2 min de chaque côté (la retourner sans la piquer).
Une fois la viande dorée, continuer à feu doux selon la cuisson désirée : bleue (1 min), saignante (2 min), à point (3 min) ou bien cuite (5 min).
Saler et poivrer, ajouter la sauce et déguster.', 'viande');
-- 162 => id de oignon ; 163 => lait de coco, coriandre, margarine ; 165 => boeuf
insert into rec.necessiter values (currval('rec.recette_idrect_seq'::regclass), 162, 1, 'pièce'), (currval('rec.recette_idrect_seq'::regclass), 163, 10, 'cl'), (currval('rec.recette_idrect_seq'::regclass), 164, 2, 'cuillères à soupe'), (currval('rec.recette_idrect_seq'::regclass), 104, 1, 'noix'), (currval('rec.recette_idrect_seq'::regclass), 165, 480, 'gr');

\echo RAISE INFO 'COEUR de veau braisé aux carottes'
insert into rec.recette (idRect, titre, nbPartMax, niveau,  textRec, categorie, tpsprepa, tpscuisson) values (default,
upper('COEUR de veau braisé aux carottes'), 6, 'moyen', 'Nettoyer le coeur à l''eau courante, couper si besoin les vaisseaux... 
Peler les carottes et les couper en bâtonnets de 5cm. Peler les oignons et les couper en 4. 
Faire fondre le beurre dans une cocotte et y faire saisir le coeur rapidement à feu vif. Une fois grillé sur toutes les faces, baisser le feu au minimum. 
Rajouter dans la cocotte les oignons, les gousses d''ail non pelées, les carottes, le poivre et le sel. 
Fermer la cocotte et faire cuire 1h0 à 2h à feu très doux en retournant le coeur 2 ou 3 fois pendant la cuisson. 
Servir bien chaud avec les gousses d''ail qu chacun ouvrira dans son assiette.', 'viande', '00:30:00', '01:30:00');
-- 162 => id de coeur de veau ; 163 => carotte, oignon, ail, poivre noir en grain, beurre, sel 
insert into rec.necessiter values (currval('rec.recette_idrect_seq'::regclass), 150, 1, 'pièce'), 
(currval('rec.recette_idrect_seq'::regclass), 28, 800, 'gr'), (currval('rec.recette_idrect_seq'::regclass), 162, 2, 'pièces'), (currval('rec.recette_idrect_seq'::regclass), 174, 6, 'gousses'), (currval('rec.recette_idrect_seq'::regclass), 159, 1, 'cuillère à café'), (currval('rec.recette_idrect_seq'::regclass), 14, 1, 'cuillère à soupe');

\echo RAISE INFO 'CAROTTES AU QUINOA CROQUANT'
insert into rec.recette (idRect, titre, nbPartMax, niveau,  textRec, categorie) values (default,
upper('Carottes au quinoa croquant'), 4, 'facile', 'Faire cuire le quinoa dans de l''eau bouillante salée le temps indiqué sur le paquet.
Éplucher les carottes, les couper en rondelles et les placer dans le panier du cuit-vapeur pour 15 min de cuisson.
Faire fondre le beurre jusqu''à ce qu''il mousse. Puis faire dorer les carottes dans une sauteuse avec le beurre moussant.
Ajouter le quinoa égoutté et faire dorer 3 à 4 min. Assaisonner et servir chaud.', 'légume');
-- 166 => id quinoa ; 28 => carotte, coriandre, margarine
insert into rec.necessiter values (currval('rec.recette_idrect_seq'::regclass), 166, 160, 'gr'), (currval('rec.recette_idrect_seq'::regclass), 28, 8, 'pièces'), (currval('rec.recette_idrect_seq'::regclass), 104, 15, 'gr'); 

\echo RAISE INFO 'OEUFS MOLLETS'
insert into rec.recette (idRect, titre, nbPartMax, niveau,  textRec, categorie) values (default,
upper('OEUFS MOLLETS'), 4, 'facile', 'Dans une casserole, faire bouillir un grand volume d''eau vinaigrée.
Plonger doucement les œufs dans l''eau bouillante et les faire cuire 5 min.
Sortir les oeufs et les plonger dans un récipient d''eau très froide pour stopper la cuisson.
Faire rouler délicatement chaque oeuf sur la table pour fendiller la coquille sur toute la surface et en faciliter l''écalage.
Assaisonner à son goût et déguster.', 'oeuf');
-- 114 => id oeuf ; 157 => sel, poivre, vinaigre de vin
insert into rec.necessiter values (currval('rec.recette_idrect_seq'::regclass), 114, 8, 'pièces'), (currval('rec.recette_idrect_seq'::regclass), 160, 1, 'pincée'), 
(currval('rec.recette_idrect_seq'::regclass), 159, 1, 'pincée'), (currval('rec.recette_idrect_seq'::regclass), 161, 1, 'cuillère à soupe'); 

\echo RAISE INFO 'BROCOLIS ET SEMOULE'
insert into rec.recette (idRect, titre, nbPartMax, niveau,  textRec, categorie) values (default,
upper('brocolis et semoule'), 4, 'facile', 'Préparer les brocolis : les laver, les égoutter et les détailler en fleurettes (sans conserver la tige), puis les déposer dans le panier du cuit-vapeur pour 15 min de cuisson.
Pendant la cuisson des légumes, préparer la semoule selon les indications portées sur l''emballage.
Ajouter l''huile d''olive et assaisonner à son goût.
Servir sans attendre avec les brocolis cuits.', 'légume');
-- 40 => id brocolis ; 143 => semoule, sel, poivre, huile
insert into rec.necessiter values (currval('rec.recette_idrect_seq'::regclass), 40, 600, 'gr'), (currval('rec.recette_idrect_seq'::regclass), 143, 260, 'gr'), (currval('rec.recette_idrect_seq'::regclass), 160, 1, 'pincée'), (currval('rec.recette_idrect_seq'::regclass), 159, 1, 'pincée'), (currval('rec.recette_idrect_seq'::regclass), 89, 2, 'cuillères à soupe'); 

\echo RAISE INFO 'POUSSES d''EPINARDS à l''orange'
insert into rec.recette (idRect, titre, nbPartMax, niveau,  textRec, categorie) values (default,
upper('Pousses d''épinards à l''orange'), 4, 'facile', 'Laver et essorer les pousses d’épinards.
Peler l''orange de table à vif et détacher les segments.
Éplucher l''oignon et l''émincer finement.
Réunir tous les ingrédients dans un saladier.
Préparer la vinaigrette : verser le jus de citron et le miel dans un bol.
Saler, poivrer et émulsionner avec l''huile.
Verser la sauce dans le saladier, mélanger et servir aussitôt.', 'entrée froide');
-- 64 => id épinard ; 143 => orange, oignon rouge, jus de citron, miel, sel, poivre, huile
insert into rec.necessiter values (currval('rec.recette_idrect_seq'::regclass), 64, 150, 'gr'), (currval('rec.recette_idrect_seq'::regclass), 168, 1, 'pièce'), (currval('rec.recette_idrect_seq'::regclass), 167, 1, 'pièce'), (currval('rec.recette_idrect_seq'::regclass), 169, 1, 'cuillère à soupe'), (currval('rec.recette_idrect_seq'::regclass), 107, 1, 'cuillères à café'), (currval('rec.recette_idrect_seq'::regclass), 160, 1, 'pincée'), (currval('rec.recette_idrect_seq'::regclass), 159, 1, 'pincée'), (currval('rec.recette_idrect_seq'::regclass), 89, 3, 'cuillère à soupe'); 

\echo RAISE INFO 'GRATIN de jambon au fromage blanc'
insert into rec.recette (idRect, titre, note, nbPartMax, niveau,  textRec, categorie, tpsprepa, tpscuisson) values (default, 
upper('GRATIN de jambon au fromage blanc'), 4, 1, 'facile', 'Mélangez dans une jatte le fromage blanc, les oeufs en omelette, le sel, le poivre. Battez bien, jusqu''à l''obtention d''une pâte lisse. 
Ajoutez alors le jambon en dés et la moutarde. 
Beurrez le plat allant au four. 
Chauffez le four à 180°C (thermostat 6). Versez le mélange dans le plat et enfournez pendant 20 à 25 minutes. Répartissez sur le gratin un morceau de jambon ou un champignon émincé pour la décoration 5 minutes avant la fin de cuisson.', 'entrée chaude', '00:10:00', '00:25:00');
-- 82 => id fromage blanc ; 114 => jambon, ..., sel, poivre
insert into rec.necessiter values (currval('rec.recette_idrect_seq'::regclass), 82, 230, 'gr'), (currval('rec.recette_idrect_seq'::regclass), 114, 2, 'pièce'), (currval('rec.recette_idrect_seq'::regclass), 91, 50, 'gr'), (currval('rec.recette_idrect_seq'::regclass), 158, 0.5, 'cuillère à café'), (currval('rec.recette_idrect_seq'::regclass), 14, 10, 'gr'), (currval('rec.recette_idrect_seq'::regclass), 160, 1, 'pincée'), (currval('rec.recette_idrect_seq'::regclass), 159, 1, 'pincée');

\echo RAISE INFO 'CAKE marbré ultra moelleux'
insert into rec.recette (idRect, titre, note, nbPartMax, niveau,  textRec, categorie, tpsprepa, tpscuisson) values (default, 
upper('Cake marbré ultra moelleux'), 5, 4, 'facile', 'Préchauffer le four à 180°C. Séparer les blancs des jaunes de 4 oeufs. Battre les jaunes avec le sucre jusqu''à ce que le mélange blanchisse. 
Ajouter l''oeuf entier et bien remuer puis incorporer le beurre fondu et la farine tamisée. 
Séparer la pâte dans deux saladier. Dans l''un, ajouter le sucre vanillé et dans l''autre le chocolat fondu au bain-marie. 
Monter les blancs en neige puis les incorporer équitablement aux 2 préparations sans les casser. 
Ajouter la levure, la moitié du paquet dans chaque préparation et beurrer un moule à cake. Verser une couche de pâte blanche, un peu de pâte au chocolat, encore de la pâte blanche, etc. 
Faire cuire environ 35 minutes.', 'dessert', '00:20:00', '00:30:00');
-- 114 => id oeufs ; 67 => farine, beurre, sucre, sucre vanillé, chocolat noir, levure
insert into rec.necessiter values (currval('rec.recette_idrect_seq'::regclass), 114, 5, 'pièce'), (currval('rec.recette_idrect_seq'::regclass), 67, 125, 'gr'), (currval('rec.recette_idrect_seq'::regclass), 14, 125, 'gr'), (currval('rec.recette_idrect_seq'::regclass), 147, 125, 'gr'), (currval('rec.recette_idrect_seq'::regclass), 170, 1, 'sachet'), (currval('rec.recette_idrect_seq'::regclass), 38, 125, 'gr'), (currval('rec.recette_idrect_seq'::regclass), 171, 1, 'sachet');

\echo RAISE INFO 'CAKE à la banane'
insert into rec.recette (idRect, titre, note, nbPartMax, niveau,  textRec, categorie, tpsprepa, tpscuisson) values (default, 
upper('CAKE à la banane'), 5, 10, 'facile', 'Faire fondre un morceau de beurre dans une poêle, déposez-y les bananes tranchées et saupoudrez de sucre. Ajoutez 2 cuillères à soupe de rhum et faire revenir 5 minutes. 
Dans un saladier, fouettez les oeufs et le sucre jusqu''à ce que le mélange blanchisse. Ajoutez la farine et la levure. 
Faites fondre le beurre et incorporez-le au mélange. Ajoutez les bananes caramélisés. Mélangez. 
Versez dans un moule à cake puis faites cuire à four 180°C pendant 35 minutes.', 'dessert', '00:10:00', '00:35:00');
-- 114 => id oeufs ; 67 => farine, beurre, sucre, banane, rhum, levure
insert into rec.necessiter values (currval('rec.recette_idrect_seq'::regclass), 114, 3, 'pièce'), (currval('rec.recette_idrect_seq'::regclass), 67, 160, 'gr'), (currval('rec.recette_idrect_seq'::regclass), 14, 130, 'gr'), (currval('rec.recette_idrect_seq'::regclass), 147, 150, 'gr'), (currval('rec.recette_idrect_seq'::regclass), 12, 3, 'pièce'), (currval('rec.recette_idrect_seq'::regclass), 172, 2, 'cuillère à soupe'), (currval('rec.recette_idrect_seq'::regclass), 171, 1/3, 'sachet');

\echo RAISE INFO 'ENTREMET à la semoule'
insert into rec.recette (idRect, titre, note, nbPartMax, niveau,  textRec, categorie, tpsprepa, tpscuisson) values (default, 
upper('ENTREMET à la semoule'), 5, 1, 'facile', 'Faire cuire la semoule dans le lait froid où on aura dissout le sucre. 
En fin de cuisson, ajouter le jaune d''oeuf.
Battre le blanc en neige ferme et l''incorporer à la compote de pomme. 
En remuant doucement, ajouter ce mélange à la semoule encore chaude. Servir froid.', 'dessert', '00:10:00', '00:05:00');
-- 114 => id oeufs ; 143 => semoule, lait, sucre, compote de pomme
insert into rec.necessiter values (currval('rec.recette_idrect_seq'::regclass), 114, 1, 'pièce'), (currval('rec.recette_idrect_seq'::regclass), 143, 25, 'gr'), (currval('rec.recette_idrect_seq'::regclass), 96, 40, 'cl'), (currval('rec.recette_idrect_seq'::regclass), 147, 1, 'cuillère à soupe'), (currval('rec.recette_idrect_seq'::regclass), 47, 3, 'cuillère à soupe');

\echo RAISE INFO 'FLAN aux pêches'
insert into rec.recette (idRect, titre, note, nbPartMax, niveau,  textRec, categorie, tpsprepa, tpscuisson) values (default, 
upper('FLAN aux pêches'), 5, 1, 'facile', 'Faire une marmelade avec les pêches. Ajouter le sucre. 
Battre le lait et l''oeuf. Mélanger la marmelade, le lait et l''oeuf. Ajouter la vanille. 
Mettre dans un moule beurré. 
Faire cuire au bain-marie à four tiède 30 à 35mn.', 'dessert', '00:10:00', '00:35:00');
-- 114 => id oeufs ; 143 => pêche, lait, sucre, vanille
insert into rec.necessiter values (currval('rec.recette_idrect_seq'::regclass), 114, 1, 'pièce'), (currval('rec.recette_idrect_seq'::regclass), 83, 3, 'moitiés'), (currval('rec.recette_idrect_seq'::regclass), 96, 15, 'cl'), (currval('rec.recette_idrect_seq'::regclass), 147, 1, 'cuillère à café'), (currval('rec.recette_idrect_seq'::regclass), 173, null, 'quelques gouttes');

\echo RAISE INFO 'FIN SCRIPT INSERTION RECETTE'
-- FIN SCRIPT
