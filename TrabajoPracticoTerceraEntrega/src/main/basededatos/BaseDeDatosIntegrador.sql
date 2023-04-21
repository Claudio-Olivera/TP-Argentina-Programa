-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: trabajointegrador3
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `equipos`
--

DROP TABLE IF EXISTS `equipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipos` (
  `nombre` varchar(70) DEFAULT NULL,
  `descripcion` varchar(70) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipos`
--

LOCK TABLES `equipos` WRITE;
/*!40000 ALTER TABLE `equipos` DISABLE KEYS */;
INSERT INTO `equipos` VALUES ('Argentina','Selección nacional de fútbol de Argentina'),('Arabia Saudita','Selección nacional de fútbol de Arabia Saudita'),('Polonia','Selección nacional de fútbol de Polonia'),('México','Selección nacional de fútbol de México');
/*!40000 ALTER TABLE `equipos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partido`
--

DROP TABLE IF EXISTS `partido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partido` (
  `Ronda` int DEFAULT NULL,
  `partido` int DEFAULT NULL,
  `Equipo1` varchar(50) DEFAULT NULL,
  `Goles_Equipo1` int DEFAULT NULL,
  `Goles_Equipo2` int DEFAULT NULL,
  `Equipo2` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partido`
--

LOCK TABLES `partido` WRITE;
/*!40000 ALTER TABLE `partido` DISABLE KEYS */;
INSERT INTO `partido` VALUES (1,1,'Argentina',1,2,'Arabia Saudita'),(1,2,'Polonia',0,0,'Mexico'),(1,3,'Argentina',2,0,'Mexico'),(1,4,'Arabia Saudita',0,2,'Polonia'),(1,5,'Argentina',0,2,'Polonia'),(2,6,'Argentina',1,2,'Arabia Saudita'),(2,7,'Polonia',0,0,'Mexico'),(2,8,'Argentina',2,0,'Mexico'),(2,9,'Arabia Saudita',0,2,'Polonia'),(2,10,'Argentina',0,2,'Polonia');
/*!40000 ALTER TABLE `partido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pronosticos`
--

DROP TABLE IF EXISTS `pronosticos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pronosticos` (
  `ronda` int DEFAULT NULL,
  `nmr` int DEFAULT NULL,
  `Participante` varchar(50) DEFAULT NULL,
  `Equipo1` varchar(50) DEFAULT NULL,
  `Gana_Equipo1` varchar(1) DEFAULT NULL,
  `Empate` varchar(1) DEFAULT NULL,
  `Gana_Equipo2` varchar(1) DEFAULT NULL,
  `Equipo2` varchar(50) DEFAULT NULL,
  `resultado` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pronosticos`
--

LOCK TABLES `pronosticos` WRITE;
/*!40000 ALTER TABLE `pronosticos` DISABLE KEYS */;
INSERT INTO `pronosticos` VALUES (1,1,'Mariana','Argentina','x',NULL,NULL,'Arabia Saudita','gana Argentina11'),(1,2,'Mariana','Polonia','x',NULL,NULL,'Mexico','gana Polonia12'),(1,3,'Mariana','Argentina','x',NULL,NULL,'Mexico','gana Argentina13'),(1,4,'Mariana','Arabia Saudita',NULL,NULL,'x','Polonia','gana Polonia14'),(1,5,'Mariana','Argentina',NULL,NULL,'x','Polonia','gana Polonia15'),(1,1,'Pedro','Argentina',NULL,NULL,'x','Arabia Saudita','gana Arabia Saudita11'),(1,2,'Pedro','Polonia',NULL,'x',NULL,'Mexico','empate 12'),(1,3,'Pedro','Argentina','x',NULL,NULL,'Mexico','gana Argentina13'),(1,4,'Pedro','Arabia Saudita',NULL,NULL,'x','Polonia','gana Polonia14'),(1,5,'Pedro','Argentina',NULL,NULL,'x','Polonia','gana Polonia15'),(1,1,'Fernanda','Argentina','x',NULL,NULL,'Arabia Saudita','gana Argentina11'),(1,2,'Fernanda','Polonia',NULL,'x',NULL,'Mexico','empate 12'),(1,3,'Fernanda','Argentina','x',NULL,NULL,'Mexico','gana Argentina13'),(1,4,'Fernanda','Arabia Saudita',NULL,NULL,'x','Polonia','gana Polonia14'),(1,5,'Fernanda','Argentina',NULL,NULL,'x','Polonia','gana Polonia15'),(1,1,'Jimena','Argentina','x',NULL,NULL,'Arabia Saudita','gana Argentina11'),(1,2,'Jimena','Polonia',NULL,'x',NULL,'Mexico','empate 12'),(1,3,'Jimena','Argentina','x',NULL,NULL,'Mexico','gana Argentina13'),(1,4,'Jimena','Arabia Saudita',NULL,NULL,'x','Polonia','gana Polonia14'),(1,5,'Jimena','Argentina',NULL,NULL,'x','Polonia','gana Polonia15'),(2,6,'Mariana','Argentina','x',NULL,NULL,'Arabia Saudita','gana Argentina26'),(2,7,'Mariana','Polonia','x',NULL,NULL,'Mexico','gana Polonia27'),(2,8,'Mariana','Argentina','x',NULL,NULL,'Mexico','gana Argentina28'),(2,9,'Mariana','Arabia Saudita',NULL,NULL,'x','Polonia','gana Polonia29'),(2,10,'Mariana','Argentina',NULL,NULL,'x','Polonia','gana Polonia210'),(2,6,'Pedro','Argentina',NULL,NULL,'x','Arabia Saudita','gana Arabia Saudita26'),(2,7,'Pedro','Polonia',NULL,'x',NULL,'Mexico','empate 27'),(2,8,'Pedro','Argentina','x',NULL,NULL,'Mexico','gana Argentina28'),(2,9,'Pedro','Arabia Saudita',NULL,NULL,'x','Polonia','gana Polonia29'),(2,10,'Pedro','Argentina',NULL,NULL,'x','Polonia','gana Polonia210'),(2,6,'Fernanda','Argentina','x',NULL,NULL,'Arabia Saudita','gana Argentina26'),(2,7,'Fernanda','Polonia',NULL,'x',NULL,'Mexico','empate 27'),(2,8,'Fernanda','Argentina','x',NULL,NULL,'Mexico','gana Argentina28'),(2,9,'Fernanda','Arabia Saudita',NULL,NULL,'x','Polonia','gana Polonia29'),(2,10,'Fernanda','Argentina',NULL,NULL,'x','Polonia','gana Polonia210'),(2,6,'Jimena','Argentina','x',NULL,NULL,'Arabia Saudita','gana Argentina26'),(2,7,'Jimena','Polonia',NULL,'x',NULL,'Mexico','empate 27'),(2,8,'Jimena','Argentina','x',NULL,NULL,'Mexico','gana Argentina28'),(2,9,'Jimena','Arabia Saudita',NULL,NULL,'x','Polonia','gana Polonia29'),(2,10,'Jimena','Argentina',NULL,NULL,'x','Polonia','gana Polonia210');
/*!40000 ALTER TABLE `pronosticos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rondas`
--

DROP TABLE IF EXISTS `rondas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rondas` (
  `punto` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rondas`
--

LOCK TABLES `rondas` WRITE;
/*!40000 ALTER TABLE `rondas` DISABLE KEYS */;
INSERT INTO `rondas` VALUES (1);
/*!40000 ALTER TABLE `rondas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-20 22:19:00
