INSERT INTO Nature(id,code,description) VALUES (1,'WORKS_01', 'Works');
INSERT INTO Nature(id,code,description) VALUES (2,'SUP_01', 'Supplies');
INSERT INTO Nature(id,code,description) VALUES (3,'SER_01', 'Services');

INSERT INTO Cpv(id,code,description) VALUES (1,'123456789', 'Fruit');
INSERT INTO Cpv(id,code,description) VALUES (2,'223456789', 'Furniture');
INSERT INTO Cpv(id,code,description) VALUES (3,'323456789', 'Computers');

INSERT INTO ProcedureType(id,code,name) VALUES (1,'open', 'open procedure');
INSERT INTO ProcedureType(id,code,name) VALUES (2,'restricted', 'restricted procedure');
INSERT INTO ProcedureType(id,code,name) VALUES (3,'negotiated', 'negotiated procedure');

INSERT INTO PublicOfficer(id,email,name) VALUES (1,'roel.arys@bosa.fgov.be', 'Roel Arys');
INSERT INTO PublicOfficer(id,email,name) VALUES (2,'stefan.vandermeulen@bosa.fgov.be', 'Stefan Van der Meulen');
INSERT INTO PublicOfficer(id,email,name) VALUES (3,'michael.dewinne@bosa.fgov.be', 'Michaël De Winne');

INSERT INTO Organisation(id,acronym,name) VALUES (1,'BOSA', 'FPS Policy and Support');
INSERT INTO Organisation(id,acronym,name) VALUES (2,'ECO', 'FPS Economy');
INSERT INTO Organisation(id,acronym,name) VALUES (3,'AIBZ', 'FPS Domestic affaires');