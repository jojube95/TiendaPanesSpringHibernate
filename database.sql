-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: localhost    Database: panaderiaSimple
-- ------------------------------------------------------
-- Server version	5.7.20-0ubuntu0.16.04.1

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
  `nombre` varchar(45) NOT NULL,
  `localidad` varchar(45) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `usuario` varchar(45) DEFAULT NULL,
  `contrasenya` varchar(45) DEFAULT NULL,
  `online` tinyint(4) NOT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Pepe','Olleria','1987-12-31','pepe','pepe',1),(2,'Pepa','Olleria','1989-01-01','pepa','pepa',1),(3,'Joan','Olleria','1978-01-02','joan','joan',1),(4,'Alfredo','Ontinyent','1968-01-03','alfredo','alfredo',1),(5,'Maria','Ontinyent','1999-01-04','maria','maria',1),(6,'Alvaro','Ontinyent','1967-01-05','alvaro','alvaro',1),(7,'Mariano','Albaida','1968-01-06','mariano','mariano',1),(8,'Cristina','Albaida','1988-01-07','cristina','cristina',1),(9,'Juan','Albaida','1998-01-08','juan','juan',1),(10,'Pablo','Bufali','1988-01-09','pablo','pablo',1),(11,'Alfredo','Bufali','1993-01-10','alfredo','alfredo',1),(12,'Miguel','Bufali','1983-01-11','miguel','miguel',1),(13,'Engique','Sant Vicent del Raspeig','1988-01-12','engique','engique',1),(14,'Javi','Sant Vicent del Raspeig','1976-01-13','javi','javi',1),(15,'Paula','Sant Vicent del Raspeig','1988-01-14','paula','paula',1),(16,'dsafad','gsdfgsd','2012-12-12','pepe','pepe2',0);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `panfabrica`
--

DROP TABLE IF EXISTS `panfabrica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `panfabrica` (
  `idPan` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `precio` decimal(5,2) unsigned NOT NULL,
  PRIMARY KEY (`idPan`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `panfabrica`
--

LOCK TABLES `panfabrica` WRITE;
/*!40000 ALTER TABLE `panfabrica` DISABLE KEYS */;
INSERT INTO `panfabrica` VALUES (1,'Panes suaves','NORMAL 1/4KG',1.97),(2,'Panes suaves','NORMAL 1/2KG',4.17),(3,'Panes suaves','BARRA CEREALES 1/4KG',3.54),(4,'Panes suaves','BARRA CORTA 1/4 KG',0.60),(5,'Panes suaves','REDONDO DE MAQUINA',3.11),(6,'Panes suaves','PAN GRANADA',2.46),(7,'Panes suaves','PAN DE ACEITE',5.25),(8,'Panes suaves','ROSCA',0.49),(9,'Panes suaves','CHUSCO',2.88),(10,'Panes suaves','COCA DE GIRONA',0.30),(11,'Panecillos','HARINA BIOLOGICA',2.00),(12,'Panecillos','PANECILLO CHAPATA',1.00),(13,'Panecillos','PANECILLO REDONDO VIENA',1.00),(14,'Panecillos','PANECILLO DE CEBOLLA',0.30),(15,'Panecillos','PANECILLO DE TRIGO',4.28),(16,'Panecillos','PANECILLO CEREALES',4.07),(17,'Panecillos','PANECILLO HAMBURGUER',4.97),(18,'Panecillos','PANECILLO FRANKFURT',3.44),(19,'Panecillos','PANECILLO DE OLIVAS',2.63),(20,'Panes rústicos','ARTESANA 1/2KG',2.54),(21,'Panes rústicos','ARTESANA 1/4KG',4.55),(22,'Panes rústicos','TORZADE',5.09),(23,'Panes rústicos','TORZADE CON SEMILLAS',1.68),(24,'Panes rústicos','PAYES 1/2 KG',1.59),(25,'Panes rústicos','PAYES 1KG',1.70),(26,'Panes rústicos','TETILLA 1/2KG',0.15),(27,'Panes rústicos','PAN GALLEGO',1.15),(28,'Panes rústicos','TETILLA 1KG',2.99),(29,'Panes rústicos','PAN DEL CURA',4.19),(30,'Semillas o sabores','FOCACCIA OLIVAS',1.93),(31,'Semillas o sabores','MIMOLETTE',1.89),(32,'Semillas o sabores','FOCACCIA ROSE MARIE',0.22),(33,'Semillas o sabores','PAN OLIVAS',3.76),(34,'Semillas o sabores','BARRA SOJA 1/2KG',3.07),(35,'Semillas o sabores','NORLANDER',2.47),(36,'Semillas o sabores','MAIZ Y PIPAS',1.72),(37,'Semillas o sabores','PASAS Y NUECES',3.97),(38,'Semillas o sabores','BARRA SIN SAL 1/4KG',4.50),(39,'Semillas o sabores','PAN CON ESPELTA',1.74),(40,'Semillas o sabores','PAN 5 CEREALES Y SEMILLAS',2.12),(41,'Texturas medias','PAN DE YOGURT Y ESPELTA',1.68),(42,'Texturas medias','CAMPELINE',1.17),(43,'Texturas medias','BARROTE FRANCES CEREALES 2 KG',2.98),(44,'Texturas medias','BARROTE FRANCÉS BLANCO',2.37),(45,'Texturas medias','CHAPATA',3.25),(46,'Texturas medias','BARRA MAQUINA 1/2 KG',3.56),(47,'Texturas medias','CASTELLANA 1/4KG',1.23),(48,'Texturas medias','CASTELLANA 1/2KG',4.92);
/*!40000 ALTER TABLE `panfabrica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `panfabricapedido`
--

DROP TABLE IF EXISTS `panfabricapedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `panfabricapedido` (
  `idPan` int(11) NOT NULL,
  `idPedido` int(11) NOT NULL,
  `cantidad` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idPan`,`idPedido`),
  KEY `fk_panfabrica_has_pedido_pedido1_idx` (`idPedido`),
  KEY `fk_panfabrica_has_pedido_panfabrica1_idx` (`idPan`),
  CONSTRAINT `fk_panfabrica_has_pedido_panfabrica1` FOREIGN KEY (`idPan`) REFERENCES `panfabrica` (`idPan`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_panfabrica_has_pedido_pedido1` FOREIGN KEY (`idPedido`) REFERENCES `pedido` (`idPedido`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `panfabricapedido`
--

LOCK TABLES `panfabricapedido` WRITE;
/*!40000 ALTER TABLE `panfabricapedido` DISABLE KEYS */;
INSERT INTO `panfabricapedido` VALUES (1,1,3),(1,2,3),(1,3,3),(1,4,3),(1,5,3),(2,1,3),(2,2,3),(2,3,3),(2,4,3),(2,5,3),(3,1,3),(3,2,3),(3,3,3),(3,4,3),(3,5,3);
/*!40000 ALTER TABLE `panfabricapedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pantienda`
--

DROP TABLE IF EXISTS `pantienda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pantienda` (
  `idPantienda` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `precio` decimal(5,2) unsigned NOT NULL,
  `cantidad` int(10) unsigned NOT NULL,
  `idPan` int(11) NOT NULL,
  `idTienda` int(11) NOT NULL,
  PRIMARY KEY (`idPantienda`),
  KEY `fk_pantienda_panfabrica1_idx` (`idPan`),
  KEY `fk_pantienda_tienda1_idx` (`idTienda`),
  CONSTRAINT `fk_pantienda_panfabrica1` FOREIGN KEY (`idPan`) REFERENCES `panfabrica` (`idPan`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pantienda_tienda1` FOREIGN KEY (`idTienda`) REFERENCES `tienda` (`idTienda`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pantienda`
--

LOCK TABLES `pantienda` WRITE;
/*!40000 ALTER TABLE `pantienda` DISABLE KEYS */;
INSERT INTO `pantienda` VALUES (1,'Panes suaves','NORMAL 1/4KG',1.97,25,1,1),(2,'Panes suaves','NORMAL 1/2KG',4.17,25,2,1),(3,'Panes suaves','BARRA CEREALES 1/4KG',3.54,25,3,1),(4,'Panes suaves','BARRA CORTA 1/4 KG',0.60,25,4,1),(5,'Panes suaves','REDONDO DE MAQUINA',3.11,25,5,1),(6,'Panes suaves','NORMAL 1/4KG',1.97,25,1,2),(7,'Panes suaves','NORMAL 1/2KG',4.17,25,2,2),(8,'Panes suaves','BARRA CEREALES 1/4KG',3.54,25,3,2),(9,'Panes suaves','BARRA CORTA 1/4 KG',0.60,25,4,2),(10,'Panes suaves','REDONDO DE MAQUINA',3.11,25,5,2),(11,'Panes suaves','NORMAL 1/4KG',1.97,25,1,3),(12,'Panes suaves','NORMAL 1/2KG',4.17,25,2,3),(13,'Panes suaves','BARRA CEREALES 1/4KG',3.54,25,3,3),(14,'Panes suaves','BARRA CORTA 1/4 KG',0.60,25,4,3),(15,'Panes suaves','REDONDO DE MAQUINA',3.11,25,5,3),(16,'Panes suaves','NORMAL 1/4KG',1.97,25,1,4),(17,'Panes suaves','NORMAL 1/2KG',4.17,25,2,4),(18,'Panes suaves','BARRA CEREALES 1/4KG',3.54,25,3,4),(19,'Panes suaves','BARRA CORTA 1/4 KG',0.60,25,4,4),(20,'Panes suaves','REDONDO DE MAQUINA',3.11,25,5,4),(21,'Panes suaves','NORMAL 1/4KG',1.97,25,1,5),(22,'Panes suaves','NORMAL 1/2KG',4.17,25,2,5),(23,'Panes suaves','BARRA CEREALES 1/4KG',3.54,25,3,5),(24,'Panes suaves','BARRA CORTA 1/4 KG',0.60,25,4,5),(25,'Panes suaves','REDONDO DE MAQUINA',3.11,25,5,5);
/*!40000 ALTER TABLE `pantienda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `panventa`
--

DROP TABLE IF EXISTS `panventa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `panventa` (
  `idVenta` int(11) NOT NULL,
  `idPantienda` int(11) NOT NULL,
  `cantidad` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idVenta`,`idPantienda`),
  KEY `fk_venta_has_pantienda_pantienda1_idx` (`idPantienda`),
  KEY `fk_venta_has_pantienda_venta1_idx` (`idVenta`),
  CONSTRAINT `fk_venta_has_pantienda_pantienda1` FOREIGN KEY (`idPantienda`) REFERENCES `pantienda` (`idPantienda`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_venta_has_pantienda_venta1` FOREIGN KEY (`idVenta`) REFERENCES `venta` (`idVenta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `panventa`
--

LOCK TABLES `panventa` WRITE;
/*!40000 ALTER TABLE `panventa` DISABLE KEYS */;
INSERT INTO `panventa` VALUES (1,1,5),(1,2,5),(2,6,5),(2,7,5),(3,11,5),(3,12,5),(4,16,5),(4,17,5),(5,21,5),(5,22,5),(6,1,3),(6,2,2),(7,6,2),(7,7,2),(8,11,1),(8,12,2),(8,13,3),(9,21,4),(9,22,1),(10,6,2),(10,7,2),(11,16,2),(11,17,2),(12,1,2),(12,2,3),(13,1,1),(13,2,1),(14,1,2),(14,2,1);
/*!40000 ALTER TABLE `panventa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `idPedido` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL,
  `precio` decimal(5,2) unsigned NOT NULL,
  `idTienda` int(11) NOT NULL,
  PRIMARY KEY (`idPedido`),
  KEY `fk_pedido_tienda1_idx` (`idTienda`),
  CONSTRAINT `fk_pedido_tienda1` FOREIGN KEY (`idTienda`) REFERENCES `tienda` (`idTienda`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,'2017-06-10 00:00:00',29.04,1),(2,'2017-06-11 00:00:00',29.04,2),(3,'2017-06-12 00:00:00',29.04,3),(4,'2017-06-13 00:00:00',29.04,4),(5,'2017-06-14 00:00:00',29.04,5);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tienda`
--

DROP TABLE IF EXISTS `tienda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tienda` (
  `idTienda` int(11) NOT NULL AUTO_INCREMENT,
  `localidad` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `contrasenya` varchar(45) NOT NULL,
  PRIMARY KEY (`idTienda`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tienda`
--

LOCK TABLES `tienda` WRITE;
/*!40000 ALTER TABLE `tienda` DISABLE KEYS */;
INSERT INTO `tienda` VALUES (1,'Olleria','panolle','panolle'),(2,'Ontinyent','panont','panont'),(3,'Albaida','panalb','panalb'),(4,'Bufali','panbuf','panbuf'),(5,'Sant Vicent Del Raspeig','panvic','panvic');
/*!40000 ALTER TABLE `tienda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venta` (
  `idVenta` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime DEFAULT NULL,
  `online` tinyint(4) NOT NULL,
  `precio` decimal(5,2) unsigned NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idTienda` int(11) NOT NULL,
  PRIMARY KEY (`idVenta`),
  KEY `fk_venta_cliente_idx` (`idCliente`),
  KEY `fk_venta_tienda1_idx` (`idTienda`),
  CONSTRAINT `fk_venta_cliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_venta_tienda1` FOREIGN KEY (`idTienda`) REFERENCES `tienda` (`idTienda`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (1,'2017-06-13 00:00:00',1,38.04,1,1),(2,'2017-06-13 00:00:00',1,38.04,4,2),(3,'2017-06-13 00:00:00',1,38.04,7,3),(4,'2017-06-13 00:00:00',1,38.04,10,4),(5,'2017-06-13 00:00:00',1,38.04,13,5),(6,'2017-09-18 00:00:00',1,14.25,1,1),(7,'2017-09-18 00:00:00',1,12.28,1,2),(8,'2017-09-18 00:00:00',1,20.93,1,3),(9,'2017-09-18 00:00:00',1,12.05,1,5),(10,'2017-09-18 00:00:00',1,12.28,1,2),(11,'2017-09-18 00:00:00',1,12.28,1,4),(12,'2017-09-18 00:00:00',1,16.45,1,1),(13,'2017-09-18 00:00:00',1,6.14,1,1),(14,'2017-09-18 00:00:00',1,8.11,1,1);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-28 18:22:43
