CREATE DATABASE  IF NOT EXISTS `bd-hibernate-uno-a-muchos` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bd-hibernate-uno-a-muchos`;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `dni` int(11) NOT NULL,
  `fechaDeNacimiento` date DEFAULT NULL,
  `baja` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Jaramillo','Ana María',14000000,'1960-09-10','\0');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestamo`
--

DROP TABLE IF EXISTS `prestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prestamo` (
  `idPrestamo` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `monto` double NOT NULL,
  `interes` double NOT NULL,
  `cantCuotas` int(11) NOT NULL,
  `prestamoFinalizado` boolean NOT NULL,
  `idCliente` int(11) NOT NULL,
  PRIMARY KEY (`idPrestamo`),
  KEY `fkCliente_idx` (`idCliente`),
  CONSTRAINT `fkCliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestamo`
--

LOCK TABLES `prestamo` WRITE;
/*!40000 ALTER TABLE `prestamo` DISABLE KEYS */;
INSERT INTO `prestamo` VALUES (1,'2016-01-08',5000,25,10,false,1),(2,'2015-11-02',10000,15,15,false,1);
/*!40000 ALTER TABLE `prestamo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

--
-- Table structure for table `cuota`
--

DROP TABLE IF EXISTS `cuota`;
CREATE TABLE `cuota` (
  `idCuota` int NOT NULL AUTO_INCREMENT,
  `fechaVencimiento` date NOT NULL,
  `saldoPendiente` double NOT NULL,
  `amortizacion` double NOT NULL,
  `interesCuota` double NOT NULL,
  `cuota` double NOT NULL,
  `deuda` double NOT NULL,
  `fechaDePago` date DEFAULT NULL,
  `cancelada` bit(1) NOT NULL DEFAULT b'0',
  `punitorios` double NOT NULL,
  `idPrestamo` int NOT NULL,
  `nroCuota` int NOT NULL,
  PRIMARY KEY (`idCuota`),
  KEY `fkPrestamo_idx` (`idPrestamo`),
  CONSTRAINT `fkPrestamo` FOREIGN KEY (`idPrestamo`) REFERENCES `prestamo` (`idPrestamo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

INSERT INTO `cuota` VALUES (1,'2023-04-06',45000.5,12,15.5,1,10000,'2023-04-06','\0',123,1,1),(2,'2023-04-06',100000,0,0,0,0,'2023-04-06','',2,2,1),(3,'2023-05-06',80000,0,0,0,0,NULL,'\0',0,2,2),(4,'2023-07-06',200000,0,0,0,0,NULL,'\0',0,2,3);

select*from cliente;
select*from prestamo;
select*from cuota;

select*from cuota c where c.fechaVencimiento='2023-04-06' and c.idPrestamo=10;