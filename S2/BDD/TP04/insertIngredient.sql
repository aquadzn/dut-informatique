-- ----------------------------------	--
-- SCHEMA DIET												--
-- objet : suivi diététique						--
-- création : 2016-02	version : V1.0	--
-- auteur : M. Lamolle								--
-- ----------------------------------	--

-- -----------------------
-- INSERTION DES ALLERGIES
insert into rec.allergie values ('gluten'), ('soja'), ('lactose'), ('fraise'), ('crustacé');

-- -----------------------
-- INSERTION DES TYPES de PLAT
insert into rec.typeplat values ('entrée chaude'), ('entrée froide'), ('viande'), ('poisson'), ('oeuf'), ('légume'), ('dessert'), ('fromage'), ('fruit'), ('soupe');


-- INSERTION DES INGREDIENTS
-- idingr,nomingr,quantite,Protide,Lipide,Glucide,Calorie,NA,K,PH,CA,MatierGrasse,FE,VitC,VitB1,VitB2,VitPP,VitA,VitD,Eau
insert into rec.ingredient values (default,  'Abricot (Boîte, sucre)', 100, 0.6, 0.1, 22, 91.3, 2, 256, 15, 11, 7, 0.3, 4, 0.02, 0.02, 0.3, 1.044, null, 76.9);
insert into rec.ingredient values (default,  'Abricot (frais)', 100,0.9,0.2,12.8,56.6,1,440,23,17,9,0.5,7,0.03,0.05,0.7,1.62, null, 85.3);
 insert into rec.ingredient values (default,  'Abricot (sec)', 100,5,0.5,66.5,290.5, null, 1700,119,67,65,5.5,12,0.01,0.16,3.3,6.54, null, 25);
 insert into rec.ingredient values (default,  'Agrumes', 100,0.7,0.2,10,44.6,3,175,20,30,0.04,0.4,45,0.07,0.04,0.2,0.52, null, 89.1);
 insert into rec.ingredient values (default,  'Akènes (noix, noisette, amande)', 100,16.5,57,16,643,3,550,400,170,200,3, null, 0.4,0.4,2.5, null, null,10.5);
 insert into rec.ingredient values (default,  'Ananas (Boîte, sucre)', 100,0.3,0.1,19.4,79.7,1,120,5,11,8,0.3,7,0.08,0.02,0.2,0.03, null, 79.9);
 insert into rec.ingredient values (default,  'Ananas (frais)', 100,0.4,0.2,12.2,52.2,0,210,8,17,17,0.5,17,0.08,0.03,0.2,0.042, null, 87.2);
 insert into rec.ingredient values (default,  'Artichaut', 100,2.7,0.2,10.6,55, null, 430,94,51, null, 13,90,0.08,0.05,1,0.096, null, 86.5);
 insert into rec.ingredient values (default,  'Aubergine', 100,1.2,0.2,5.6,29,1,190,26,17,10,0.4, null, 0.05,0.05,0.6,0.6, null, 93);
 insert into rec.ingredient values (default,  'Avocat', 100,2.2,17,6,185.8,0,340,42,10,30,0.6,14,0.11,0.2,1.6, null, null,74.8);
 insert into rec.ingredient values (default,  'Avoine (flocons)', 100,14,7,66,383,3,350,400,60,140,3, null, 0.45,0.14,1, null, null,13);
 insert into rec.ingredient values (default,  'Banane', 100,1.4,0.2,23,99.4,1,400,30,8,31,0.5,11,0.05,0.05,0.6,0.4, null, 75.4);
 insert into rec.ingredient values (default,  'Betterave rouge', 100,1.6,0.1,9.9,46.9, null, 303,33,25,23,0.7,10,0.03,0.04,0.4,0.012, null, 87.3);
 insert into rec.ingredient values (default,  'Beurre', 100,0.8,84,0.5,761.2, null, 6,15,12,1, null, null, null, null, null, 1,0.0024,14.7);
 insert into rec.ingredient values (default,  'Biscotte', 100,11,7,75,407, null, 170,200,25,16,2.3, null, 0.24,0.08,1, null, null,7);
 insert into rec.ingredient values (default,  'Boeuf bourguignon', 100,34.5,23,9,381, null, null, null, null, null, null, null, null, null, null, null, null, null);
 insert into rec.ingredient values (default,  'Boeuf cervelle', 100,10.4,8,0.8,116.8, null, 191,265,11,12,1.6,14,0.15,0.23,1.8,0.348, null, 80.8);
 insert into rec.ingredient values (default,  'Boeuf coeur', 100,17,6,0.6,124.4, null, 286,200, null, 17, null, null, null, null, null, null, null, 76.4);
 insert into rec.ingredient values (default,  'Boeuf langue', 100,19,16,0.4,221.6, null, 260,200,10,10,2.8, null, 0.2,0.3,7.5, null, null,64.6);
 insert into rec.ingredient values (default,  'Boeuf maigre', 100,20,9, null, 161, null, 380,170,10,20,3,1,0.13,0.18,0.45,0.02, null, 71);
 insert into rec.ingredient values (default,  'Boeuf rognon', 100,15.4,6.7,0.9,125.5, null, 231,219,11,11,5.5,11,0.25,2.1,6.4,0.6, null, 77);
 insert into rec.ingredient values (default,  'Boeuf tripes', 100,19,2, null, 94, null, 19,132,69, null, 0.9, null, 0.01,0.09,3, null, null,79);
 insert into rec.ingredient values (default,  'Cacahuète grillée', 100,26.2,48.7,20.6,625.5,3,740,407,74,181,2.2, null, 0.32,0.13,17.1,0.216, null, 4.5);
 insert into rec.ingredient values (default,  'Cacao', 100,19,24,38,444, null, 2500,620,130,420,14, null, 0.06,0.12,1.9, null, 0.0025,19);
 insert into rec.ingredient values (default,  'Cake',1,4.94,14.72,29.37,269.72, null, 46.25,56.54,15.22,4.9,0.68,0.02,0.05,0.08,0.2,0.32, null, 18.51);
 insert into rec.ingredient values (default,  'Canard', 100,16,28.6, null, 321.4, null, 285,188,15, null, 1.8,8,0.1,0.24,5.6, null, null,55.4);
 insert into rec.ingredient values (default,  'Carotte (Boîte)',1,0.8,0.3,6.7,32.7,2,110,22,26,0.7, null, 3,0.03,0.02,0.3,9, null, 91.2);
 insert into rec.ingredient values (default,  'Carotte (fraîche)', 100,1.2,0.2,8.5,40.6, null, 300,35,40,21,1.1,12,0.06,0.05,0.4,7,0,90.1);
 insert into rec.ingredient values (default,  'Céleri (cote)', 100,1.3,0.2,3.7,21.8, null, 290,40,60,25,0.5,7,0.05,0.04,0.4,0.1, null, 94.8);
 insert into rec.ingredient values (default,  'Céleri (rave)', 100,1.8,0.3,8.5,43.9, null, 300,60,60,12,0.9,8,0.03,0.03,0.7,0.0096, null, 88.4);
 insert into rec.ingredient values (default,  'Cerise', 100,1.2,0.4,14.6,66.8,2,260,19,19,14,0.03,10,0.05,0.05,0.3,60, null, 83.4);
 insert into rec.ingredient values (default,  'Champignon Paris', 100,2.8,0.24,0.9,16.96,5,520,116,9,13,0.8,5,0.1,0.44,6.2, null, null, null);
 insert into rec.ingredient values (default,  'Charcuterie (pâté)',40,160,560,64,5936, null, null, null, null, null, null, null, null, null, null, null, null, null);
 insert into rec.ingredient values (default,  'Châtaigne, Marron', 100,4,2.6,40,199.4,7,530,85,40,42,1,25,0.2,0.2,0.4, null, null,53.4);
 insert into rec.ingredient values (default,  'Cheval', 100,22,2.7,0.5,114.3, null, 335,190,13, null, 2.5,1,0.05,0.1,5, null, null,74.8);
 insert into rec.ingredient values (default,  'Chips', 100,5.3,39.8,50,579.4, null, 880,139,40,48,1.8,16,0.21,0.07,4.8, null, null,4.9);
 insert into rec.ingredient values (default,  'Chocolat au lait', 100,7.7,32.3,56.9,549.1, null, 420,251,228,58,1.1, null, 0.06,0.34,0.3,0.162, null, 3.1);
 insert into rec.ingredient values (default,  'Chocolat noir', 100,4,28,64,524, null, 420,230,50,150,2.7, null, 0.04,0.13,0.6, null, null,4);
 insert into rec.ingredient values (default,  'Chou blanc', 100,1.4,0.2,5.7,30.2, null, 227,28,46,23,0.5,46,0.05,0.04,0.32,0.042, null, 92.1);
 insert into rec.ingredient values (default,  'Chou brocoli', 100,3.6,0.3,5.9,40.7, null, 400,78,103,24,1.1,113,0.1,0.23,0.9,1.5, null, 89.1);
 insert into rec.ingredient values (default,  'Chou Bruxelle', 100,4.7,0.4,8.7,57.2, null, 450,80,29,20,1.5, 100,0.1,0.16,0.9,0.33, null, 84.8);
 insert into rec.ingredient values (default,  'Chou fleur', 100,2.7,0.2,5.2,33.4, null, 400,56,25,7,1.1,78,0.11,0.1,0.6,0.036, null, 91);
 insert into rec.ingredient values (default,  'Chou rouge', 100,1.5,0.2,5.9,31.4,4,266,30,35,18,0.5,50,0.07,0.05,0.4,0.03, null, 91.8);
 insert into rec.ingredient values (default,  'Choucroute', 100,1,0.2,4,21.8, null, 140,18,140,36,0.5,14,0.03,0.04,0.2,0.03, null, 94.8);
 insert into rec.ingredient values (default,  'Clafouti', 100,7.09,3.81,48,254.65, null, 293.24,120.05,68.65,11.62,1.7,0.51,0.13,0.22,0.75,0.75, null, 55.18);
 insert into rec.ingredient values (default,  'Coca', 100, null, null,10,40, null, null, null, null, null, null, null, null, null, null, null, null,90);
 insert into rec.ingredient values (default,  'Compote de pommes',1,0.5,4,74,334, null, null, null, null, null, null, null, null, null, null, null, null, null);
insert into rec.ingredient values (default,  'Concombre', 100,0.8,0.1,3,16.5,5,140,27,25,9,1.1,8,0.04,0.05,0.2,0.18, null, 96.1);
 insert into rec.ingredient values (default,  'Confiture', 100,0.5,0.1,70,282.9, null, 12,12,12,10,0.25,5,0.02,0.02,0.2, null, null,29.4);
 insert into rec.ingredient values (default,  'Coq au vin',1,53.5,24,8,462, null, null, null, null, null, null, null, null, null, null, null, null, null);
 insert into rec.ingredient values (default,  'Corn flakes', 100,7.9,0.04,85.3,373.16, null, 160,45,10,17,1.4, null, 0.43,0.1,2.1, null, null,3.8);
 insert into rec.ingredient values (default,  'Cornichon', 100,0.8,0.1,3,16.1,5,140,27,25,9,1.1,8,0.04,0.05,0.2,0.18, null, 96.1);
 insert into rec.ingredient values (default,  'Courge', 100,0.8,0.1,3.5,18.1,1,457,44,21,12,0.8,9,0.05,0.11,0.6,0.96, null, 95);
 insert into rec.ingredient values (default,  'Courgette', 100,1.2,0.1,3.6,20.1,1,202,29,28, null, 0.4,19,0.05,0.09,0.1,0.192, null, 94.6);
 insert into rec.ingredient values (default,  'Crabe', 100,17.4,2.5,1.1,96.5, null, 110,182,45,48,0.8, null, 0.08,0.08,2.5, null, null,79);
 insert into rec.ingredient values (default,  'Crème (30% MG)', 100,3,30,3.5,296, null, 70,50,75, null, null, null, null, null, null,0.22,0.0013,63.5);
 insert into rec.ingredient values (default,  'Crêpe au jambon',1,7.4,5.8,21.5,167.8, null, null, null, null, null, null, null, null, null, null, null, null, null);
 insert into rec.ingredient values (default,  'Cresson', 100,1.7,0.3,3.3,22.7, null, 300,50,200,40,2.5,75,0.1,0.17,0.8, null, null,94.7);
 insert into rec.ingredient values (default,  'Crevette grise', 100,18.7,2.2, null, 94.6, null, 258,300,63,42,2,2,0.07,0.05,1.25,0.006, null, 79.1);
 insert into rec.ingredient values (default,  'Croque Monsieur',1,9.7,15.62,17.15,247.98, null, 117.6,166.9,209,20.1,1.24, null, 0.36,0.13,1.27,0.1, null, 33.65);
 insert into rec.ingredient values (default,  'Datte', 100,2.2,0.6,73,306.2,1,790,50,71,65,2.1,3,0.09,0.05,2.2,0.06, null, 24.2);
 insert into rec.ingredient values (default,  'Dinde', 100,20.1,14.7,0.4,214.3, null, 315,212,8, null, 1.5, null, 0.13,0.14,7.9, null, null,64.8);
 insert into rec.ingredient values (default,  'Eclair',1,1.6,8,25,178.4, null, null, null, null, null, null, null, null, null, null, null, null, null);
 insert into rec.ingredient values (default,  'Epinard', 100,2.3,0.3,3.5,25.9, null, 500,55,120,40,4,50,0.1,0.2,0.4,5.5, null, 93.9);
 insert into rec.ingredient values (default,  'Escargot', 100,15,0.8,2,75.2, null, null, null, 170,250,3.5, null, null, null, null, null, null,82.2);
 insert into rec.ingredient values (default,  'Far Breton',1,11.04,16.79,64.65,453.87, null, 302.48,178.2,129.07,27.88,1.65,0.88,0.15,0.27,0.69,0.66, null, 110.43);
 insert into rec.ingredient values (default,  'Farine', 100,10.5,1,76.1,355.4,2,95,87,16,25,0.8, null, 0.06,0.05,0.9, null, null,12.4);
 insert into rec.ingredient values (default,  'Figue sèche', 100,3.6,1.2,62,273.2, null, 780,116,190,82,3, null, 0.16,0.12,1.7,0.4, null, 33.2);
 insert into rec.ingredient values (default,  'Figue fraîche', 100,1,0.4,17,75.6,2,220,25,20,70,0.6,4,0.05,0.04,0.03, null, 81.6,81.6);
 insert into rec.ingredient values (default,  'Fraise', 100,0.7,0.5,8.4,40.9,1,145,21,21,12,1,60,0.03,0.07,0.6,0.036, null, 89.9);
 insert into rec.ingredient values (default,  'Framboise', 100,0.9,0.7,11,53.9,2,283,30,40,23,0.3,40,0.08,0.02,0.2,0.35, null, 87.4);
 insert into rec.ingredient values (default,  'Brie', 100,18,22,4,286, null,  100,160,250,18,0.3, null, 0.04,0.4,1, null, 0.001,56);
 insert into rec.ingredient values (default,  'Camembert', 100,18,22,4,286, null,  100,160,250,18,0.3, null, 0.04,0.4,1, null, 0.001,56);
 insert into rec.ingredient values (default,  'Livarot', 100,26,23,7,339, null, 125,250,540,18, null, null,0.03,0.3, null, null,0.001,44);
 insert into rec.ingredient values (default,  'Munster', 100,26,23,7,339, null, 125,250,540,18, null, null,0.03,0.3, null, null,0.001,44);
 insert into rec.ingredient values (default,  'Pont-L''Evêque', 100,26,23,7,339, null, 125,250,540,18, null, null,0.03,0.3, null, null,0.001,44);
 insert into rec.ingredient values (default,  'Cantal', 100,27,28,3,372, null, 125,440,730,18,1.5, null, 0.04,0.3, null, 0.01,0.001,42);
 insert into rec.ingredient values (default,  'St Paulin', 100,27,28,3,372, null, 125,440,730,18,1.5, null, 0.04,0.3, null, 0.01,0.001,42);
 insert into rec.ingredient values (default,  'Hollande', 100,27,28,3,372, null, 125,440,730,18,1.5, null, 0.04,0.3, null, 0.01,0.001,42);
 insert into rec.ingredient values (default,  'Gruyère', 100,29,30,3,398, null, 125,600,1000,55,2, null, 0.03,0.3, null, 0.015,0.001,38);
 insert into rec.ingredient values (default,  'Comté', 100,27,28,3,372, null, 125,440,730,18,1.5, null, 0.04,0.3, null, 0.01,0.001,42);
 insert into rec.ingredient values (default,  'Fromage blanc', 100,9,10,4,142, null, 80,250,150, null, null, null, null, null, 0.3,0.087,0.005,77);
 insert into rec.ingredient values (default,  'Fruit à noyau', 100,0.8,0.2,13,57,2,257,20,12,0.1,0.4,10,0.04,0.05,0.5,2, null, 86);
 insert into rec.ingredient values (default,  'Fruit au sirop',1, null, null,31,124, null, null, null, null, null, null, null, null, null, null, null, null, null);
 insert into rec.ingredient values (default,  'Gelatine sèche', 100,85.6,0.1, null, 343.3, null, null, null, null, null, null, null, null, null, null, null, null,14.3);
 insert into rec.ingredient values (default,  'Gnocchi',1,0.1245,0.092,0.2216,2.2124, null, 261.82,268.9,280.95,22.19,1.44,0.27,0.15,0.3,0.58,0.36, null, 139.7);
 insert into rec.ingredient values (default,  'Gratin dauphinois',1,0.1901,0.2344,0.6314,5.3956, null, 1367,457.5,495.25,93,3.82,42.08,0.39,0.32,3.68,0.13, null, 282.41);
 insert into rec.ingredient values (default,  'Haricot sec', 100,21,1.8,59.6,338.6,1,1300,400,106,180,6.7, null, 0.54,18,2.1, null, null,17.6);
 insert into rec.ingredient values (default,  'Huile', 100, null, 99, null, 891, null, null, null, null, null, null, null, null, null, null, null, null,1);
 insert into rec.ingredient values (default,  'Huitre',12,1.08,0.144,0.576,7.92,9,13.2,17.16,11.28,5.04,0.66, null, 0.0216,0.0276,0.3,0.02232, null, 10.2);
 insert into rec.ingredient values (default,  'Jambon cru', 100,15.2,31, null, 339.8, null, 339,168,9,18,2.3, null, 0.74,0.18,4, null, null,53.8);
 insert into rec.ingredient values (default,  'Jambon cuit', 100,28,4.9, null, 156.1, null, 310,92,9, null, 2.7, null, 1.7,0.26,5.1, null, null,67.1);
 insert into rec.ingredient values (default,  'Jambon fumé', 100,16.9,35,0.3,383.8, null, 248,207,10,20,2.5, null, 0.7,0.19,4, null, null,47.8);
 insert into rec.ingredient values (default,  'Jambon salé', 100,19.5,20.6, null, 263.4, null, 348,150,10, null, 2.5, null, 0.54,0.26,4.2, null, null,59.9);
 insert into rec.ingredient values (default,  'Jardinière de légumes',1,7.5,7,48,285, null, null, null, null, null, null, null, null, null, null, null, null, null);
 insert into rec.ingredient values (default,  'Lait 1/2 écrémé', 100,3.5,1.7,5,49.3, null, 150,95,130,13,0.05,0.2,0.05,0.13,0.22, null, null,89.8);
 insert into rec.ingredient values (default,  'Lait écrémé', 100,3.7,0.2,5,36.6, null, 150,95,130,13,0.05,0.2,0.05,0.13,0.22, null, null,91.9);
 insert into rec.ingredient values (default,  'Lait entier', 100,3.3,3.5,5,64.7, null, 150,90,125,13,0.05,2,0.05,0.13,2.2,0.034,0.0002,88.2);
 insert into rec.ingredient values (default,  'Lapin', 100,22,5,0.5,135, null, 385,210,14, null, 2.5, null, 0.18,0.18,12.8, null, null,72.5);
 insert into rec.ingredient values (default,  'Lard 1/2 gras', 100,91,65, null, 949, null, 225,108,13,15,1.2, null, 0.36,0.11,1.8, null, null,25.9);
 insert into rec.ingredient values (default,  'Légume vert', 100,2.7,0.3,6,37.5, null, 314,55,45,23,1.2,50,0.08,0.1,0.8,0.5, null, 91);
 insert into rec.ingredient values (default,  'Lentille', 100,24,1.8,58,344.2,3,1200,400,60,180,7, null, 0.5,0.25,1.8, null, null,16.2);
insert into rec.ingredient values (default,  'Maïs', 100,2.6,0.8,19.8,96.8, null, 97,49,5,19,0.5,4,0.03,0.05,0.9,0.21, null, 75.9);
 insert into rec.ingredient values (default,  'Margarine', 100, null, 83,0.4,748.6, null, null,0.6,10,13, null, null, null, null, null, null, null, 16.6);
 insert into rec.ingredient values (default,  'Mayonnaise', 100,1.1,78.9,3,726.5, null, 53,28,18,2,0.5, null, 0.02,0.04, null, 0.168, null, 17);
 insert into rec.ingredient values (default,  'Melon', 100,0.5,0.2,6.4,29.4,0, 100,10,7,8,0.5,7,0.03,0.03,0.2,0.354, null, 92.9);
 insert into rec.ingredient values (default,  'Miel', 100,5,0.2,75,321.8,7,10,19,4,3,0.7, null, 2,0.05,0.2, null, null,24.3);
 insert into rec.ingredient values (default,  'Mortadelle', 100,12.4,32.8, null, 344.8, null, 207,238,12, null, 3.1, null, 0.1,0.15,2.6, null, null,54.8);
 insert into rec.ingredient values (default,  'Mouton cotelette', 100,14.9,32, null, 347.6, null, 345,138,9,14,22, null, 1.3,0.18,4.3, null, null,53.1);
 insert into rec.ingredient values (default,  'Mouton foie', 100,21,3.9,2.9,130.7, null, 170,349,13,14,10.9,33,0.4,3.28,16.9,30.3, null, 72.2);
 insert into rec.ingredient values (default,  'Mouton gigot', 100,18,18, null, 234, null, 380,213,10,16,2.7, null, 0.16,0.22,5.2, null, null,64);
 insert into rec.ingredient values (default,  'Mouton rognon', 100,16.8,3.3,0.9,100.5, null, 205,218, null, 13,7.5,15,0.51,2.42,7.4,0.414, null, 79);
 insert into rec.ingredient values (default,  'Oeuf blanc',2,7.6,0.116, null, 31.44, null, 96,7.6,8.4,0.22,0.056, null, 0.012,0.124,0.06, null, null,52.284);
 insert into rec.ingredient values (default,  'Oeuf entier',2,15,12, null, 168, null, 140,200,55,0.26,2.8, null, 0.19,0.35,0.15,0.9,0.002,73);
 insert into rec.ingredient values (default,  'Oeuf jaune',2,6.4,13.24, null, 144.76, null, 48,236,56,0.32,3.2, null, 0.16,0.22,0.016,1.2,0.002,20.36);
 insert into rec.ingredient values (default,  'Paella',1,12.9,30.3,34.7,463.1, null, 658.85,509,62.74,61.04,4.36,4.6,0.19,0.32,13.95,0.17, null, 177.35);
 insert into rec.ingredient values (default,  'Pain blanc', 100,7,0.8,55,255.2, null,  100,90,20,30,1, null, 0.06,0.06,0.85, null, null,37.2);
 insert into rec.ingredient values (default,  'Pâte', 100,12,0.9,74.1,352.5,6,170,145,22, null, 1.1, null, 0.1,0.06,2, null, null,13);
 insert into rec.ingredient values (default,  'Petit pois (boîte)',1,0.034,0.004,0.127,0.68,3,2.01,0.67,0.25,0.25,1.8,9,0.11,0.06,0.9,0.264, null, 83.5);
 insert into rec.ingredient values (default,  'Pizza',1,0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
 insert into rec.ingredient values (default,  'Poire', 100,0.3,0.4,14,60.8,3,125,10,7,5,0.3,5,0.04,0.03,0.15,0.03, null, 85.3);
 insert into rec.ingredient values (default,  'Poisson gras : hareng, maquereau, alose, thon, saumon, murène, lamproie, rouget, sardine', 100,19,15, null, 211, null, 350,243,15,25,0.8,2.7,0.07,0.38,3.5,0.05, null, 66);
 insert into rec.ingredient values (default,  'Poisson maigre : carrelet, cabillaud, colin, merlan, merlu, sole, limande, lieu, raie, dorade, roussette, grondin, truite', 100,16,9, null, 145, null, 294,203,37,15,0.8,1.5,0.07,0.1,2.5, null, null,83.1);
 insert into rec.ingredient values (default,  'Pomme', 100,0.3,0.4,14,60.8,3,125,10,7,5,0.3,5,0.04,0.03,0.15,0.03, null, 85.3);
 insert into rec.ingredient values (default,  'Pomme de terre', 100,2,0.1,20,88.9,4,420,60,15,22,1,14,0.12,0.05,1.2, null, null,77.9);
 insert into rec.ingredient values (default,  'Porc cervelle', 100,10.6,9, null, 123.4, null, 312,300,10,11,3.6,18,0.16,0.28,4.3, null, null,80.4);
 insert into rec.ingredient values (default,  'Porc coeur', 100,16.9,4.8,0.4,112.4, null, 257,132,6,15,3.3,3,0.43,1.24,6.6,0.018, null, 77.9);
 insert into rec.ingredient values (default,  'Porc cotelette', 100,15.2,30.6, null, 336.2, null, 326,170,9,19,2.3, null, 0.8,0.19,4.3, null, null,54.2);
 insert into rec.ingredient values (default,  'Porc filet', 100,18.6,9.9, null, 163.5, null, 348,234,12,22,3, null, 1.1,0.31,6.5, null, null,71.5);
 insert into rec.ingredient values (default,  'Porc foie', 100,20.6,4.8,2.6,136, null, 350,316,10,18,19,27,0.43,2.7,16.4,6.54, null, 72);
 insert into rec.ingredient values (default,  'Porc langue', 100,16.8,15.6,0.5,209.6, null, 234,186,9, null, 1.4, null, 0.17,0.29,5, null, null,67.1);
 insert into rec.ingredient values (default,  'Porc rognon', 100,16.4,5.2,0.8,115.6, null, 242,218,11,16,6.7,12,0.34,1.8,0.8,0.078, null, 77.6);
 insert into rec.ingredient values (default,  'Poulet', 100,21,4.5, null, 124.5, null, 300,200,12,37,1,2,0.1,0.2,7, null, null,74.5);
 insert into rec.ingredient values (default,  'Pruneau', 100,2.4,0.5,70,294.1,6,660,95,45,13,2.9,1.5,0.2,0.3,1.7,1.75, null, 27.1);
 insert into rec.ingredient values (default,  'Purée',200,6,17,60,417, null, null, null, null, null, null, null, null, null, null, null, null, null);
 insert into rec.ingredient values (default,  'Quiche lorraine',1,14,16,18,272, null, 124.05,107.64,41.9,8.48,1.09, null, 0.08,0.11,0.86,0.33, null, 55.29);
 insert into rec.ingredient values (default,  'Raisin', 100,1,0.4,17,75.6,2,220,25,20,70,0.6,4,0.05,0.04,0.03, null, 81.6,81.6);
 insert into rec.ingredient values (default,  'Riz au lait',1,6,4,54,276, null, null, null, null, null, null, null, null, null, null, null, null, null);
 insert into rec.ingredient values (default,  'Riz blanc', 100,7.6,0.5,79,350.9,5,115,180,8,28,0.9, null, 0.06,0.03,1.5, null, null,12.9);
 insert into rec.ingredient values (default,  'Salade', 100,1.5,0.5,5,30.5, null, 300,40,50,11,0.7,11,0.05,0.05, null, 2, null, 93);
 insert into rec.ingredient values (default,  'Saucisse de Francfort', 100,12.5,27.6,1.8,305.6, null, 230,133,7, null, 1.9, null, 0.16,0.2,2.7, null, null,58.1);
 insert into rec.ingredient values (default,  'Saucisse en sachet', 100,13,19.6, null, 228.4, null, null,185,10, null, 2.7, null, 0.03,0.08,3.1, null, null,67.4);
 insert into rec.ingredient values (default,  'Semoule', 100,10.3,0.8,76,352.4,1,112,87,17, null, 1, null, 0.12,0.04,1.3, null, null,12.9);
 insert into rec.ingredient values (default,  'Semoule Maïs', 100,7.5,0.8,78, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
 insert into rec.ingredient values (default,  'Soja', 100,34.1,17.7,33.5,429.7,4,19,5.54,226,235,8.4, null, 1.14,0.31,2.1,80, null, 10);
 insert into rec.ingredient values (default,  'Soufflé au fromage',1,16.28,21.7,33.02,392.5, null, 119.69,352.86,360.54,32.01,2.29,0.15,0.14,0.29,0.51,0.64, null, 91.43);
 insert into rec.ingredient values (default,  'Sucre',50, null, null,50,200,1,1.5, null, null, null, null, null, null, null, null, null, null, null);
 insert into rec.ingredient values (default,  'Tomate', 100,0.9,0.3,4,22.3,3,280,27,12,11,0.4,25,0.06,0.04,0.3,0.4, null, 94.8);
 insert into rec.ingredient values (default,  'Veau cervelle', 100,10.2,8.3,0.8,118.7, null, 265,353,9,14,2.6,18,0.2,0.2,3.7, null, null,80.7);
 insert into rec.ingredient values (default,  'Veau coeur', 100,12.2,7.6,0.8,120.4, null, 230,350,16,18,2.2,5,0.6,1.05,6.3,0.018, null, 79.4);
 insert into rec.ingredient values (default,  'Veau escalope panée', 100,21.6,15,5,241.4, null, null, null, null, null, null, null, null, null, null, null, null, null);
 insert into rec.ingredient values (default,  'Veau foie', 100,19,4.5,4,132.5, null, 295,300,6,15,5,35,0.3,3,15,5,0.0005,72.5);
 insert into rec.ingredient values (default,  'Veau langue', 100,18.5,5.3,0.9,125.3, null, 200,190,9, null, 3, null, null, null, null, null, null,75.3);
 insert into rec.ingredient values (default,  'Veau maigre', 100,19,5, null, 121, null, 350,200,13,16,3,1.5,0.16,0.2,6,0.02, null, 76);
 insert into rec.ingredient values (default,  'Veau ris', 100,19.6,3, null, 105.4, null, 519, null, null, null, 0.9, null, 0.08,0.17,2.6, null, null,77.4);
 insert into rec.ingredient values (default,  'Veau rognon', 100,16.7,6.4,0.8,127.6, null, 290,171,10, null, 3.4,13,0.37,2.5,6.5,0.042, null, 76.1);
insert into rec.ingredient values (default, 'Yaourth', 100, 4.2, 1, 5, 45.8, null, 190, 135, 150, null, 0.2 ,2 , 0.045 , 0.024 , 0.18, 0.087, null, 86.9);
insert into rec.ingredient values (default, 'Moutarde'); -- 158
insert into rec.ingredient values (default, 'Poivre');	-- 159
insert into rec.ingredient values (default, 'Sel');		-- 160
insert into rec.ingredient values (default, 'Vinaigre de vin');	--161
insert into rec.ingredient values (default, 'Oignon');	--162
insert into rec.ingredient values (default, 'Lait de coco (Boîte)');	--163
insert into rec.ingredient values (default, 'Coriandre fraîche');	--164
insert into rec.ingredient values (default, 'Bifteck');	--165
insert into rec.ingredient values (default, 'Quinoa');	--166
insert into rec.ingredient values (default, 'Oignon rouge');	--167
insert into rec.ingredient values (default, 'Orange');	--168
insert into rec.ingredient values (default, 'Citron (jus)');	--169
insert into rec.ingredient values (default, 'Sucre vanillé');	--170
insert into rec.ingredient values (default, 'Levure');	--171
insert into rec.ingredient values (default, 'Rhum');	--172
--173 insert into rec.ingredient values (default, 'Lait écrémé');	
--174 insert into rec.ingredient values (default, 'Lait 1/2 écrémé');
--175 insert into rec.ingredient values (default, 'Lait entier');	
insert into rec.ingredient values (default, 'Vanille (liquide)');	--176
insert into rec.ingredient values (default, 'Aïl');	--177

\echo RAISE INFO 'FIN SCRIPT INSERTION INGREDIENT'
-- FIN SCRIPT
