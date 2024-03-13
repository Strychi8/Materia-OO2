CREATE DATABASE  IF NOT EXISTS `bdAeropuerto` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bdAeropuerto`;
-- MySQL dump 10.13  Distrib 8.0.32, for Linux (x86_64)
--
-- Host: localhost    Database: bdAeropuerto
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `Carga`
--

DROP TABLE IF EXISTS `Carga`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Carga` (
  `idCarga` int NOT NULL AUTO_INCREMENT,
  `aeropuertoOrigen` varchar(3) NOT NULL,
  `aeropuertoDestino` varchar(3) NOT NULL,
  `peso` int NOT NULL,
  `idCliente` int NOT NULL,
  `idVuelo` int NOT NULL,
  PRIMARY KEY (`idCarga`),
  KEY `fk_Carga_1_idx` (`idCliente`),
  KEY `fk_Carga_2_idx` (`idVuelo`),
  CONSTRAINT `fk_Carga_1` FOREIGN KEY (`idCliente`) REFERENCES `Cliente` (`idCliente`),
  CONSTRAINT `fk_Carga_2` FOREIGN KEY (`idVuelo`) REFERENCES `Vuelo` (`idVuelo`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Carga`
--

LOCK TABLES `Carga` WRITE;
/*!40000 ALTER TABLE `Carga` DISABLE KEYS */;
INSERT INTO `Carga` VALUES (1,'AEP','COR',15,5,1),(2,'AEP','JUJ',35,3,1),(3,'AEP','COR',15,4,1),(4,'AEP','JUJ',30,2,2),(5,'AEP','COR',52,2,4),(6,'AEP','COR',10,1,2),(7,'AEP','COR',42,2,5);
/*!40000 ALTER TABLE `Carga` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Cliente`
--

DROP TABLE IF EXISTS `Cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Cliente` (
  `idCliente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `dni` bigint NOT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cliente`
--

LOCK TABLES `Cliente` WRITE;
/*!40000 ALTER TABLE `Cliente` DISABLE KEYS */;
INSERT INTO `Cliente` VALUES (1,'Jorge','Newbery',12345678),(2,'Teodoro','Fells',12569874),(3,'Bartolomé','Cattaneo',13456987),(4,'Raúl','Goubat',11321654),(5,'Alfedo','Agneta',13987523);
/*!40000 ALTER TABLE `Cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Envio`
--

DROP TABLE IF EXISTS `Envio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Envio` (
  `idCarga` int NOT NULL,
  `domicilioEntrega` varchar(50) NOT NULL,
  PRIMARY KEY (`idCarga`),
  KEY `FK5C30ED339603D79` (`idCarga`),
  CONSTRAINT `fk_Envio_1` FOREIGN KEY (`idCarga`) REFERENCES `Carga` (`idCarga`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Envio`
--

LOCK TABLES `Envio` WRITE;
/*!40000 ALTER TABLE `Envio` DISABLE KEYS */;
INSERT INTO `Envio` VALUES (1,'Sáenz 2222 Buenos Aires'),(3,'Cabildo 342 Avellaneda'),(5,'Colombres 596 Lomas de Zamora'),(7,'29 de Septiembre 3901 Remedios de Escalada');
/*!40000 ALTER TABLE `Envio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Equipaje`
--

DROP TABLE IF EXISTS `Equipaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Equipaje` (
  `idCarga` int NOT NULL,
  `excedePeso` tinyint(1) NOT NULL,
  PRIMARY KEY (`idCarga`),
  KEY `FK2319E32C39603D79` (`idCarga`),
  CONSTRAINT `fk_equipaje_1` FOREIGN KEY (`idCarga`) REFERENCES `Carga` (`idCarga`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Equipaje`
--

LOCK TABLES `Equipaje` WRITE;
/*!40000 ALTER TABLE `Equipaje` DISABLE KEYS */;
INSERT INTO `Equipaje` VALUES (2,1),(4,1),(6,0);
/*!40000 ALTER TABLE `Equipaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Vuelo`
--

DROP TABLE IF EXISTS `Vuelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Vuelo` (
  `idVuelo` int NOT NULL AUTO_INCREMENT,
  `vuelo` varchar(10) NOT NULL,
  `fechaHoraArribo` datetime DEFAULT NULL,
  `fechaHoraPartida` datetime NOT NULL,
  `pesoMaximoEquipaje` int NOT NULL,
  PRIMARY KEY (`idVuelo`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Vuelo`
--

LOCK TABLES `Vuelo` WRITE;
/*!40000 ALTER TABLE `Vuelo` DISABLE KEYS */;
INSERT INTO `Vuelo` VALUES (1,'AR2234','2023-06-26 00:00:00','2023-06-25 22:20:00',10),(2,'AR6678','2023-06-26 23:59:59','2023-06-25 22:40:00',15),(3,'AR2356',NULL,'2023-08-30 15:42:00',12),(4,'AR4234','2023-06-27 00:00:00','2023-06-26 21:20:00',10),(5,'AR9678','2023-06-27 23:59:59','2023-06-26 21:41:00',15);
/*!40000 ALTER TABLE `Vuelo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-19 17:58:26
select*from Vuelo;
select*from Cliente;
select*from Carga;
select*from Envio;
select*from Equipaje;