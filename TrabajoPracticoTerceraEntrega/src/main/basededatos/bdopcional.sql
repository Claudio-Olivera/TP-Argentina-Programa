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



INSERT INTO Pronosticos (ronda,nmr,Participante, Equipo1, Gana_Equipo1, Empate, Gana_Equipo2, Equipo2) VALUES
(1,1,'Mariana', 'Argentina', 'x', NULL, NULL, 'Arabia Saudita'),
(1,2,'Mariana', 'Polonia', 'x', NULL, NULL, 'Mexico'),
(1,3,'Mariana', 'Argentina', 'x', NULL, NULL, 'Mexico'),
(1,4,'Mariana', 'Arabia Saudita', NULL, NULL, 'x', 'Polonia'),
(1,5,'Mariana', 'Argentina',NULL, NULL, 'x', 'Polonia'),
(1,6,'Mariana', 'Arabia Saudita',NULL, NULL, 'x', 'Mexico'),


(1,1,'Pedro', 'Argentina', NULL, NULL,'x', 'Arabia Saudita'),
(1,2,'Pedro', 'Polonia', NULL, 'x', NULL, 'Mexico'),
(1,3,'Pedro', 'Argentina', 'x', NULL, NULL, 'Mexico'),
(1,4,'Pedro', 'Arabia Saudita', NULL, NULL, 'x', 'Polonia'),
(1,5,'Pedro', 'Argentina',NULL, NULL, 'x', 'Polonia'),
(1,6,'Pedro', 'Arabia Saudita',NULL, NULL, 'x', 'Mexico'),

(1,1,'Fernanda', 'Argentina', 'x', NULL, NULL, 'Arabia Saudita'),
(1,2,'Fernanda', 'Polonia', NULL, 'x', NULL, 'Mexico'),
(1,3,'Fernanda', 'Argentina', 'x', NULL, NULL, 'Mexico'),
(1,4,'Fernanda', 'Arabia Saudita', NULL, NULL, 'x', 'Polonia'),
(1,5,'Fernanda', 'Argentina',NULL, NULL, 'x', 'Polonia'),
(1,6,'Fernanda', 'Arabia Saudita',NULL, NULL, 'x', 'Mexico'),

(1,1,'Jimena', 'Argentina', 'x', NULL, NULL, 'Arabia Saudita'),
(1,2,'Jimena', 'Polonia', NULL, 'x', NULL, 'Mexico'),
(1,3,'Jimena', 'Argentina', 'x', NULL, NULL, 'Mexico'),
(1,4,'Jimena', 'Arabia Saudita', NULL, NULL, 'x', 'Polonia'),
(1,5,'Jimena', 'Argentina',NULL, NULL, 'x', 'Polonia'),
(1,6,'Jimena', 'Arabia Saudita',NULL, NULL, 'x', 'Mexico'),

(2,7,'Mariana', 'Argentina', 'x', NULL, NULL, 'Arabia Saudita'),
(2,8,'Mariana', 'Polonia', 'x', NULL, NULL, 'Mexico'),
(2,9,'Mariana', 'Argentina', 'x', NULL, NULL, 'Mexico'),
(2,10,'Mariana', 'Arabia Saudita', NULL, NULL, 'x', 'Polonia'),
(2,11,'Mariana', 'Argentina',NULL, NULL, 'x', 'Polonia'),
(2,12,'Mariana', 'Arabia Saudita',NULL, NULL, 'x', 'Mexico'),


(2,7,'Pedro', 'Argentina', NULL, NULL,'x', 'Arabia Saudita'),
(2,8,'Pedro', 'Polonia', NULL, 'x', NULL, 'Mexico'),
(2,9,'Pedro', 'Argentina', 'x', NULL, NULL, 'Mexico'),
(2,10,'Pedro', 'Arabia Saudita', NULL, NULL, 'x', 'Polonia'),
(2,11,'Pedro', 'Argentina',NULL, NULL, 'x', 'Polonia'),
(2,12,'Pedro', 'Arabia Saudita',NULL, NULL, 'x', 'Mexico'),

(2,7,'Fernanda', 'Argentina', 'x', NULL, NULL, 'Arabia Saudita'),
(2,8,'Fernanda', 'Polonia', NULL, 'x', NULL, 'Mexico'),
(2,9,'Fernanda', 'Argentina', 'x', NULL, NULL, 'Mexico'),
(2,10,'Fernanda', 'Arabia Saudita', NULL, NULL, 'x', 'Polonia'),
(2,11,'Fernanda', 'Argentina',NULL, NULL, 'x', 'Polonia'),
(2,12,'Fernanda', 'Arabia Saudita',NULL, NULL, 'x', 'Mexico'),

(2,7,'Jimena', 'Argentina', 'x', NULL, NULL, 'Arabia Saudita'),
(2,8,'Jimena', 'Polonia', NULL, 'x', NULL, 'Mexico'),
(2,9,'Jimena', 'Argentina', 'x', NULL, NULL, 'Mexico'),
(2,10,'Jimena', 'Arabia Saudita', NULL, NULL, 'x', 'Polonia'),
(2,11,'Jimena', 'Argentina',NULL, NULL, 'x', 'Polonia'),
(2,12,'Jimena', 'Arabia Saudita',NULL, NULL, 'x', 'Mexico');




CREATE TABLE partido (
  Ronda INT,
  partido INT,
  Equipo1 VARCHAR(50),
  Goles_Equipo1 INT,
  Goles_Equipo2 INT,
  Equipo2 VARCHAR(50));

INSERT INTO partido (Ronda,partido, Equipo1, Goles_Equipo1, Goles_Equipo2, Equipo2)
VALUES
(1,1,'Argentina', 1, 2, 'Arabia Saudita'),
(1,2,'Polonia', 0, 0, 'Mexico'),
(1,3,'Argentina', 2, 0, 'Mexico'),
(1,4,'Arabia Saudita', 0, 2, 'Polonia'),
(1,5,'Argentina', 0, 2, 'Polonia'),
(1,6,'Arabia Saudita', 0, 3, 'Mexico'),

(2,7,'Argentina', 1, 2, 'Arabia Saudita'),
(2,8,'Polonia', 0, 0, 'Mexico'),
(2,9,'Argentina', 2, 0, 'Mexico'),
(2,10,'Arabia Saudita', 0, 2, 'Polonia'),
(2,11,'Argentina', 0, 2, 'Polonia'),
(2,12,'Arabia Saudita', 0, 3, 'Mexico');

CREATE TABLE equipos (
nombre varchar(70),
descripcion varchar(70)
);
INSERT INTO equipos (nombre, descripcion)
VALUES
   ('Argentina', 'Selección nacional de fútbol de Argentina'),
   ('Arabia Saudita', 'Selección nacional de fútbol de Arabia Saudita'),
   ('Polonia', 'Selección nacional de fútbol de Polonia'),
   ('México', 'Selección nacional de fútbol de México');
  CREATE TABLE rondas (
   punto INT
   );

   UPDATE pronosticos
   SET resultado = CASE
       WHEN Gana_Equipo1 = 'x' THEN CONCAT('gana ', Equipo1, ronda, nmr)
       WHEN Gana_Equipo2 = 'x' THEN CONCAT('gana ', Equipo2, ronda, nmr)
       ELSE CONCAT('empate ', ronda, nmr)
   END;
   INSERT INTO rondas (punto)
VALUES(1);
SELECT * FROM equipos;
SELECT * FROM rondas;
SELECT * FROM partido;
SELECT * FROM pronosticos;
