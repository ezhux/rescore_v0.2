INSERT INTO YachtClasses(name, coefficient) SELECT * FROM CSVREAD('modeliai.tsv', NULL, 'UTF-8', chr(9));
INSERT INTO Regattas (name, region) VALUES ('Pilypo regata', 'Vakarų Lietuvos');
INSERT INTO Yachts (sailNumber, yachtClass, name, captain, owner) VALUES ('LTU2018', 314, 'Gafsan', 'Kapitonas Kapitonauskas', 'Savininkė Savininkienė');
INSERT INTO Yachts (sailNumber, yachtClass, name, captain, owner) VALUES ('LTU1547', 271, 'Piranija', 'Kapitonė Kapitonienė', 'Savininkas Savininkauskas');
