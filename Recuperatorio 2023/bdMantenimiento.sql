CREATE DATABASE  IF NOT EXISTS `bdMantenimiento` /*!40100 DEFAULT CHARACTER SET latin1 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bdMantenimiento`;
-- MySQL dump 10.13  Distrib 8.0.32, for Linux (x86_64)
--
-- Host: localhost    Database: bdMantenimiento
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
-- Table structure for table `Ambiente`
--

DROP TABLE IF EXISTS `Ambiente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Ambiente` (
  `idAmbiente` int NOT NULL AUTO_INCREMENT,
  `ambiente` varchar(25) NOT NULL,
  PRIMARY KEY (`idAmbiente`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ambiente`
--

LOCK TABLES `Ambiente` WRITE;
/*!40000 ALTER TABLE `Ambiente` DISABLE KEYS */;
INSERT INTO `Ambiente` VALUES (2,'Cocina'),(3,'Loby'),(4,'Bar'),(5,'Restaurant'),(6,'1A'),(7,'1B'),(8,'1C'),(9,'2A'),(10,'2B'),(11,'2C');
/*!40000 ALTER TABLE `Ambiente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Habitacion`
--

DROP TABLE IF EXISTS `Habitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Habitacion` (
  `idHabitacion` int NOT NULL,
  `plazas` int NOT NULL,
  PRIMARY KEY (`idHabitacion`),
  CONSTRAINT `fk_Habitacion_1` FOREIGN KEY (`idHabitacion`) REFERENCES `Ambiente` (`idAmbiente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Habitacion`
--

LOCK TABLES `Habitacion` WRITE;
/*!40000 ALTER TABLE `Habitacion` DISABLE KEYS */;
INSERT INTO `Habitacion` VALUES (6,2),(7,3),(8,4),(9,2),(10,3),(11,4);
/*!40000 ALTER TABLE `Habitacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `OrdenMantenimiento`
--

DROP TABLE IF EXISTS `OrdenMantenimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `OrdenMantenimiento` (
  `idOrdenMantenimiento` int NOT NULL AUTO_INCREMENT,
  `nroOrdenMantenimiento` varchar(16) NOT NULL,
  `motivo` varchar(45) NOT NULL,
  `fechaDeInicio` date NOT NULL,
  `fechaDeFin` date DEFAULT NULL,
  `costoDeReparacion` double DEFAULT NULL,
  `terminada` tinyint(1) NOT NULL,
  `pagada` tinyint(1) NOT NULL,
  `estadoDuranteLaReparacion` varchar(25) NOT NULL,
  `idAmbiente` int NOT NULL,
  PRIMARY KEY (`idOrdenMantenimiento`),
  KEY `fk_OrdenMantenimiento_Ambiente1_idx` (`idAmbiente`),
  CONSTRAINT `fk_OrdenMantenimiento_Ambiente1` FOREIGN KEY (`idAmbiente`) REFERENCES `Ambiente` (`idAmbiente`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `OrdenMantenimiento`
--

LOCK TABLES `OrdenMantenimiento` WRITE;
/*!40000 ALTER TABLE `OrdenMantenimiento` DISABLE KEYS */;
INSERT INTO `OrdenMantenimiento` VALUES (1,'001-0001','Mantenimiento de Cocinas','2023-02-10','2023-02-13',124000,1,1,'en Mantenimiento',2),(2,'001-0002','Limpieza de Extractores','2023-06-14','2023-06-18',235000,0,0,'en Mantenimiento',2),(3,'001-0003','Reparación de Climatización','2023-06-10','2023-06-18',357000,0,0,'Fuera de Servicio',9),(4,'001-0004','Remodelación Baño','2023-06-13','2023-08-14',772000,0,0,'Fuera de Servicio',8),(5,'001-0005','Reparación Frigobar','2023-06-20','2023-06-26',51500,0,0,'en Mantenimiento',7),(6,'001-0006','Reparación de Climatización','2023-06-16','2023-06-17',357000,0,1,'en Mantenimiento',8);
/*!40000 ALTER TABLE `OrdenMantenimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Salon`
--

DROP TABLE IF EXISTS `Salon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Salon` (
  `idSalon` int NOT NULL,
  `cantidadDeMesas` int NOT NULL,
  `cantidadDeSillas` int NOT NULL,
  `capacidad` int NOT NULL,
  PRIMARY KEY (`idSalon`),
  CONSTRAINT `fk_Salon_1` FOREIGN KEY (`idSalon`) REFERENCES `Ambiente` (`idAmbiente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Salon`
--

LOCK TABLES `Salon` WRITE;
/*!40000 ALTER TABLE `Salon` DISABLE KEYS */;
INSERT INTO `Salon` VALUES (2,1,4,12),(3,2,8,16),(4,6,18,18),(5,10,32,32);
/*!40000 ALTER TABLE `Salon` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-09 16:15:08

select*from ambiente;
select*from habitacion;
select*from ordenmantenimiento;
select*from salon;
