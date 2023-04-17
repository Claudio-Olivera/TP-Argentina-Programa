CREATE TABLE pronosticos (
ronda INT,
nmr INT,
  Participante VARCHAR(50),
  Equipo1 VARCHAR(50),
  Gana_Equipo1 VARCHAR(1),
  Empate VARCHAR(1),
  Gana_Equipo2 VARCHAR(1),
  Equipo2 VARCHAR(50),
  resultado VARCHAR(50)
  
);

UPDATE pronosticos
SET resultado = CASE
    WHEN Gana_Equipo1 = 'x' THEN CONCAT('gana ', Equipo1, ronda, nmr)
    WHEN Gana_Equipo2 = 'x' THEN CONCAT('gana ', Equipo2, ronda, nmr)
    ELSE CONCAT('empate ', ronda, nmr)
END;

INSERT INTO Pronosticos (ronda,nmr,Participante, Equipo1, Gana_Equipo1, Empate, Gana_Equipo2, Equipo2) VALUES
(1,1,'Mariana', 'Argentina', 'x', NULL, NULL, 'Arabia Saudita'),
(1,2,'Mariana', 'Polonia', 'x', NULL, NULL, 'Mexico'),
(1,3,'Mariana', 'Argentina', 'x', NULL, NULL, 'Mexico'),
(1,4,'Mariana', 'Arabia Saudita', NULL, NULL, 'x', 'Polonia'),

(1,1,'Pedro', 'Argentina', NULL, NULL,'x', 'Arabia Saudita'),
(1,2,'Pedro', 'Polonia', NULL, 'x', NULL, 'Mexico'),
(1,3,'Pedro', 'Argentina', 'x', NULL, NULL, 'Mexico'),
(1,4,'Pedro', 'Arabia Saudita', NULL, NULL, 'x', 'Polonia'),

(1,1,'Fernanda', 'Argentina', 'x', NULL, NULL, 'Arabia Saudita'),
(1,2,'Fernanda', 'Polonia', NULL, 'x', NULL, 'Mexico'),
(1,3,'Fernanda', 'Argentina', 'x', NULL, NULL, 'Mexico'),
(1,4,'Fernanda', 'Arabia Saudita', NULL, NULL, 'x', 'Polonia'),

(1,1,'Jimena', 'Argentina', 'x', NULL, NULL, 'Arabia Saudita'),
(1,2,'Jimena', 'Polonia', NULL, 'x', NULL, 'Mexico'),
(1,3,'Jimena', 'Argentina', 'x', NULL, NULL, 'Mexico'),
(1,4,'Jimena', 'Arabia Saudita', NULL, NULL, 'x', 'Polonia'),

 
(2,5,'Mariana', 'Argentina', 'x', NULL, NULL, 'Arabia Saudita'),
(2,6,'Mariana', 'Polonia', 'x', NULL, NULL, 'Mexico'),
(2,7,'Mariana', 'Argentina', 'x', NULL, NULL, 'Mexico'),
(2,8,'Mariana', 'Arabia Saudita', NULL, NULL, 'x', 'Polonia'),

(2,5,'Pedro', 'Argentina', NULL, NULL,'x', 'Arabia Saudita'),
(2,6,'Pedro', 'Polonia', NULL, 'x', NULL, 'Mexico'),
(2,7,'Pedro', 'Argentina', 'x', NULL, NULL, 'Mexico'),
(2,8,'Pedro', 'Arabia Saudita', NULL, NULL, 'x', 'Polonia'),

(2,5,'Fernanda', 'Argentina', 'x', NULL, NULL, 'Arabia Saudita'),
(2,6,'Fernanda', 'Polonia', NULL, 'x', NULL, 'Mexico'),
(2,7,'Fernanda', 'Argentina', 'x', NULL, NULL, 'Mexico'),
(2,8,'Fernanda', 'Arabia Saudita', NULL, NULL, 'x', 'Polonia'),

(2,5,'Jimena', 'Argentina', 'x', NULL, NULL, 'Arabia Saudita'),
(2,6,'Jimena', 'Polonia', NULL, 'x', NULL, 'Mexico'),
(2,7,'Jimena', 'Argentina', 'x', NULL, NULL, 'Mexico'),
(2,8,'Jimena', 'Arabia Saudita', NULL, NULL, 'x', 'Polonia');



INSERT INTO partido (Ronda,partido, Equipo1, Goles_Equipo1, Goles_Equipo2, Equipo2)
VALUES 
(1,1,'Argentina', 1, 2, 'Arabia Saudita'),
(1,2,'Polonia', 0, 0, 'Mexico'),
(1,3,'Argentina', 2, 0, 'Mexico'),
(1,4,'Arabia Saudita', 0, 2, 'Polonia'),
(2,5,'Argentina', 1, 2, 'Arabia Saudita'),
(2,6,'Polonia', 0, 0, 'Mexico'),
(2,7,'Argentina', 2, 0, 'Mexico'),
(2,8,'Arabia Saudita', 0, 2, 'Polonia');


CREATE TABLE partido (
  Ronda INT,
  partido INT,
  Equipo1 VARCHAR(50),
  Goles_Equipo1 INT,
  Goles_Equipo2 INT,
  Equipo2 VARCHAR(50),
  resultado VARCHAR(50)
);

  