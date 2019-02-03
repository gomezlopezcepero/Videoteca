-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	4.1.19-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema vidioteca
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ vidioteca;
USE vidioteca;

--
-- Table structure for table `vidioteca`.`director`
--

DROP TABLE IF EXISTS `director`;
CREATE TABLE `director` (
  `id` int(10) unsigned NOT NULL default '0',
  `nombre` varchar(45) NOT NULL default '',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vidioteca`.`director`
--

/*!40000 ALTER TABLE `director` DISABLE KEYS */;
INSERT INTO `director` (`id`,`nombre`) VALUES 
 (1,'Alejandro Amenabar'),
 (2,'Pedro Almodobar'),
 (3,'Gillermo del Toro'),
 (4,'J.A. Bayona'),
 (5,'Alex de la Iglesia'),
 (6,'Jose Luis Garci'),
 (7,'Fernando Trueba');
/*!40000 ALTER TABLE `director` ENABLE KEYS */;


--
-- Table structure for table `vidioteca`.`peliculas`
--

DROP TABLE IF EXISTS `peliculas`;
CREATE TABLE `peliculas` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `titulo` varchar(45) NOT NULL default '',
  `director` int(10) unsigned NOT NULL default '0',
  `fecha_estreno` date NOT NULL default '0000-00-00',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vidioteca`.`peliculas`
--

/*!40000 ALTER TABLE `peliculas` DISABLE KEYS */;
INSERT INTO `peliculas` (`id`,`titulo`,`director`,`fecha_estreno`) VALUES 
 (1,'Regresión',1,'2016-01-01'),
 (2,'El mal ajeno',1,'2016-02-01'),
 (3,'Ágora',1,'2016-03-01'),
 (4,'Mar Adentro',1,'2016-04-01'),
 (5,'Julieta',2,'2016-01-01'),
 (6,'Volver',2,'2016-02-01'),
 (7,'Todo sobre mi madre',2,'2016-03-01'),
 (8,'Hable con ella',2,'2016-04-01'),
 (9,'El laberinto del Fauno',3,'2016-01-01'),
 (10,'La invención de cronos',3,'2016-02-01'),
 (11,'La cumbre escarlata',3,'2016-03-01'),
 (12,'El espinazo del diablo',3,'2016-04-01'),
 (13,'Guerra mundial Z2',4,'2016-01-01'),
 (14,'El Mostru viene a verme',4,'2016-02-01'),
 (15,'El orfanato',4,'2016-03-01'),
 (16,'Lo imposible',4,'2016-04-01'),
 (17,'Las brujas de Zugarramundi',5,'2016-05-01'),
 (18,'Balada triste de trompeta',5,'2016-06-01'),
 (19,'Mi gran noche',5,'2016-07-01'),
 (20,'El día de la bestia',5,'2016-08-01'),
 (21,'Volver a empezar',6,'2016-09-01'),
 (22,'El abuelo',6,'2016-10-01'),
 (23,'Luz de domingo',6,'2016-02-01'),
 (24,'Asignatura pendiente',6,'2016-04-01'),
 (25,'La niña de tus ojos',7,'2016-01-01');
INSERT INTO `peliculas` (`id`,`titulo`,`director`,`fecha_estreno`) VALUES 
 (26,'Embrujo de Shangay',7,'2016-02-01'),
 (27,'El sueño del mono loco',7,'2016-03-01'),
 (28,'Calle 54',7,'2016-04-01');
/*!40000 ALTER TABLE `peliculas` ENABLE KEYS */;


--
-- Table structure for table `vidioteca`.`usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `usuario` varchar(45) NOT NULL default '',
  `password` varchar(45) NOT NULL default '',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vidioteca`.`usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
