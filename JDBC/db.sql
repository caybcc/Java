-- MySQL dump 10.16  Distrib 10.1.19-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: localhost
-- ------------------------------------------------------
-- Server version	10.1.19-MariaDB

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `birthday` varchar(20) NOT NULL,
  `money` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=763 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Nick','1998-07-27',456),(2,'Lucy','1998-08-07',345),(3,'Mike','1998-07-27',342),(4,'Maria','1999-07-27',1),(9,'Nick','1998-07-27',456),(10,'Lucy','1998-08-07',345),(11,'Mike','1998-07-27',342),(12,'Maria','1999-07-27',456),(16,'Nick','1998-07-27',456),(17,'Lucy','1998-08-07',345),(18,'Mike','1998-07-27',342),(19,'Maria','1999-07-27',456),(20,'Nick','1998-07-27',456),(21,'Lucy','1998-08-07',345),(22,'Mike','1998-07-27',342),(23,'Maria','1999-07-27',456),(31,'Nick','1998-07-27',456),(32,'Lucy','1998-08-07',345),(33,'Mike','1998-07-27',342),(34,'Maria','1999-07-27',456),(35,'Nick','1998-07-27',456),(36,'Lucy','1998-08-07',345),(37,'Mike','1998-07-27',342),(38,'Maria','1999-07-27',456),(39,'Nick','1998-07-27',456),(40,'Lucy','1998-08-07',345),(41,'Mike','1998-07-27',342),(42,'Maria','1999-07-27',456),(43,'Nick','1998-07-27',456),(44,'Lucy','1998-08-07',345),(45,'Mike','1998-07-27',342),(46,'Maria','1999-07-27',456),(62,'Nick','1998-07-27',456),(63,'Lucy','1998-08-07',345),(64,'Mike','1998-07-27',342),(65,'Maria','1999-07-27',456),(66,'Nick','1998-07-27',456),(67,'Lucy','1998-08-07',345),(68,'Mike','1998-07-27',342),(69,'Maria','1999-07-27',456),(70,'Nick','1998-07-27',456),(71,'Lucy','1998-08-07',345),(72,'Mike','1998-07-27',342),(73,'Maria','1999-07-27',456),(74,'Nick','1998-07-27',456),(75,'Lucy','1998-08-07',345),(76,'Mike','1998-07-27',342),(77,'Maria','1999-07-27',456),(78,'Nick','1998-07-27',456),(79,'Lucy','1998-08-07',345),(80,'Mike','1998-07-27',342),(81,'Maria','1999-07-27',456),(82,'Nick','1998-07-27',456),(83,'Lucy','1998-08-07',345),(84,'Mike','1998-07-27',342),(85,'Maria','1999-07-27',456),(86,'Nick','1998-07-27',456),(87,'Lucy','1998-08-07',345),(88,'Mike','1998-07-27',342),(89,'Maria','1999-07-27',456),(90,'Nick','1998-07-27',456),(91,'Lucy','1998-08-07',345),(92,'Mike','1998-07-27',342),(93,'Maria','1999-07-27',456),(125,'Nick','1998-07-27',456),(126,'Lucy','1998-08-07',345),(127,'Mike','1998-07-27',342),(128,'Maria','1999-07-27',456),(129,'Nick','1998-07-27',456),(130,'Lucy','1998-08-07',345),(131,'Mike','1998-07-27',342),(132,'Maria','1999-07-27',456),(133,'Nick','1998-07-27',456),(134,'Lucy','1998-08-07',345),(135,'Mike','1998-07-27',342),(136,'Maria','1999-07-27',456),(137,'Nick','1998-07-27',456),(138,'Lucy','1998-08-07',345),(139,'Mike','1998-07-27',342),(140,'Maria','1999-07-27',456),(141,'Nick','1998-07-27',456),(142,'Lucy','1998-08-07',345),(143,'Mike','1998-07-27',342),(144,'Maria','1999-07-27',456),(145,'Nick','1998-07-27',456),(146,'Lucy','1998-08-07',345),(147,'Mike','1998-07-27',342),(148,'Maria','1999-07-27',456),(149,'Nick','1998-07-27',456),(150,'Lucy','1998-08-07',345),(151,'Mike','1998-07-27',342),(152,'Maria','1999-07-27',456),(153,'Nick','1998-07-27',456),(154,'Lucy','1998-08-07',345),(155,'Mike','1998-07-27',342),(156,'Maria','1999-07-27',456),(157,'Nick','1998-07-27',456),(158,'Lucy','1998-08-07',345),(159,'Mike','1998-07-27',342),(160,'Maria','1999-07-27',456),(161,'Nick','1998-07-27',456),(162,'Lucy','1998-08-07',345),(163,'Mike','1998-07-27',342),(164,'Maria','1999-07-27',456),(165,'Nick','1998-07-27',456),(166,'Lucy','1998-08-07',345),(167,'Mike','1998-07-27',342),(168,'Maria','1999-07-27',456),(169,'Nick','1998-07-27',456),(170,'Lucy','1998-08-07',345),(171,'Mike','1998-07-27',342),(172,'Maria','1999-07-27',456),(173,'Nick','1998-07-27',456),(174,'Lucy','1998-08-07',345),(175,'Mike','1998-07-27',342),(176,'Maria','1999-07-27',456),(177,'Nick','1998-07-27',456),(178,'Lucy','1998-08-07',345),(179,'Mike','1998-07-27',342),(180,'Maria','1999-07-27',456),(181,'Nick','1998-07-27',456),(182,'Lucy','1998-08-07',345),(183,'Mike','1998-07-27',342),(184,'Maria','1999-07-27',456),(185,'Nick','1998-07-27',456),(186,'Lucy','1998-08-07',345),(187,'Mike','1998-07-27',342),(188,'Maria','1999-07-27',456),(252,'Nick','1998-07-27',456),(253,'Lucy','1998-08-07',345),(254,'Mike','1998-07-27',342),(255,'Maria','1999-07-27',456),(256,'Nick','1998-07-27',456),(257,'Lucy','1998-08-07',345),(258,'Mike','1998-07-27',342),(259,'Maria','1999-07-27',456),(260,'Nick','1998-07-27',456),(261,'Lucy','1998-08-07',345),(262,'Mike','1998-07-27',342),(263,'Maria','1999-07-27',456),(264,'Nick','1998-07-27',456),(265,'Lucy','1998-08-07',345),(266,'Mike','1998-07-27',342),(267,'Maria','1999-07-27',456),(268,'Nick','1998-07-27',456),(269,'Lucy','1998-08-07',345),(270,'Mike','1998-07-27',342),(271,'Maria','1999-07-27',456),(272,'Nick','1998-07-27',456),(273,'Lucy','1998-08-07',345),(274,'Mike','1998-07-27',342),(275,'Maria','1999-07-27',456),(276,'Nick','1998-07-27',456),(277,'Lucy','1998-08-07',345),(278,'Mike','1998-07-27',342),(279,'Maria','1999-07-27',456),(280,'Nick','1998-07-27',456),(281,'Lucy','1998-08-07',345),(282,'Mike','1998-07-27',342),(283,'Maria','1999-07-27',456),(284,'Nick','1998-07-27',456),(285,'Lucy','1998-08-07',345),(286,'Mike','1998-07-27',342),(287,'Maria','1999-07-27',456),(288,'Nick','1998-07-27',456),(289,'Lucy','1998-08-07',345),(290,'Mike','1998-07-27',342),(291,'Maria','1999-07-27',456),(292,'Nick','1998-07-27',456),(293,'Lucy','1998-08-07',345),(294,'Mike','1998-07-27',342),(295,'Maria','1999-07-27',456),(296,'Nick','1998-07-27',456),(297,'Lucy','1998-08-07',345),(298,'Mike','1998-07-27',342),(299,'Maria','1999-07-27',456),(300,'Nick','1998-07-27',456),(301,'Lucy','1998-08-07',345),(302,'Mike','1998-07-27',342),(303,'Maria','1999-07-27',456),(304,'Nick','1998-07-27',456),(305,'Lucy','1998-08-07',345),(306,'Mike','1998-07-27',342),(307,'Maria','1999-07-27',456),(308,'Nick','1998-07-27',456),(309,'Lucy','1998-08-07',345),(310,'Mike','1998-07-27',342),(311,'Maria','1999-07-27',456),(312,'Nick','1998-07-27',456),(313,'Lucy','1998-08-07',345),(314,'Mike','1998-07-27',342),(315,'Maria','1999-07-27',456),(316,'Nick','1998-07-27',456),(317,'Lucy','1998-08-07',345),(318,'Mike','1998-07-27',342),(319,'Maria','1999-07-27',456),(320,'Nick','1998-07-27',456),(321,'Lucy','1998-08-07',345),(322,'Mike','1998-07-27',342),(323,'Maria','1999-07-27',456),(324,'Nick','1998-07-27',456),(325,'Lucy','1998-08-07',345),(326,'Mike','1998-07-27',342),(327,'Maria','1999-07-27',456),(328,'Nick','1998-07-27',456),(329,'Lucy','1998-08-07',345),(330,'Mike','1998-07-27',342),(331,'Maria','1999-07-27',456),(332,'Nick','1998-07-27',456),(333,'Lucy','1998-08-07',345),(334,'Mike','1998-07-27',342),(335,'Maria','1999-07-27',456),(336,'Nick','1998-07-27',456),(337,'Lucy','1998-08-07',345),(338,'Mike','1998-07-27',342),(339,'Maria','1999-07-27',456),(340,'Nick','1998-07-27',456),(341,'Lucy','1998-08-07',345),(342,'Mike','1998-07-27',342),(343,'Maria','1999-07-27',456),(344,'Nick','1998-07-27',456),(345,'Lucy','1998-08-07',345),(346,'Mike','1998-07-27',342),(347,'Maria','1999-07-27',456),(348,'Nick','1998-07-27',456),(349,'Lucy','1998-08-07',345),(350,'Mike','1998-07-27',342),(351,'Maria','1999-07-27',456),(352,'Nick','1998-07-27',456),(353,'Lucy','1998-08-07',345),(354,'Mike','1998-07-27',342),(355,'Maria','1999-07-27',456),(356,'Nick','1998-07-27',456),(357,'Lucy','1998-08-07',345),(358,'Mike','1998-07-27',342),(359,'Maria','1999-07-27',456),(360,'Nick','1998-07-27',456),(361,'Lucy','1998-08-07',345),(362,'Mike','1998-07-27',342),(363,'Maria','1999-07-27',456),(364,'Nick','1998-07-27',456),(365,'Lucy','1998-08-07',345),(366,'Mike','1998-07-27',342),(367,'Maria','1999-07-27',456),(368,'Nick','1998-07-27',456),(369,'Lucy','1998-08-07',345),(370,'Mike','1998-07-27',342),(371,'Maria','1999-07-27',456),(372,'Nick','1998-07-27',456),(373,'Lucy','1998-08-07',345),(374,'Mike','1998-07-27',342),(375,'Maria','1999-07-27',456),(376,'Nick','1998-07-27',456),(377,'Lucy','1998-08-07',345),(378,'Mike','1998-07-27',342),(379,'Maria','1999-07-27',456),(507,'Nick','1998-07-27',456),(508,'Lucy','1998-08-07',345),(509,'Mike','1998-07-27',342),(510,'Maria','1999-07-27',456),(511,'Nick','1998-07-27',456),(512,'Lucy','1998-08-07',345),(513,'Mike','1998-07-27',342),(514,'Maria','1999-07-27',456),(515,'Nick','1998-07-27',456),(516,'Lucy','1998-08-07',345),(517,'Mike','1998-07-27',342),(518,'Maria','1999-07-27',456),(519,'Nick','1998-07-27',456),(520,'Lucy','1998-08-07',345),(521,'Mike','1998-07-27',342),(522,'Maria','1999-07-27',456),(523,'Nick','1998-07-27',456),(524,'Lucy','1998-08-07',345),(525,'Mike','1998-07-27',342),(526,'Maria','1999-07-27',456),(527,'Nick','1998-07-27',456),(528,'Lucy','1998-08-07',345),(529,'Mike','1998-07-27',342),(530,'Maria','1999-07-27',456),(531,'Nick','1998-07-27',456),(532,'Lucy','1998-08-07',345),(533,'Mike','1998-07-27',342),(534,'Maria','1999-07-27',456),(535,'Nick','1998-07-27',456),(536,'Lucy','1998-08-07',345),(537,'Mike','1998-07-27',342),(538,'Maria','1999-07-27',456),(539,'Nick','1998-07-27',456),(540,'Lucy','1998-08-07',345),(541,'Mike','1998-07-27',342),(542,'Maria','1999-07-27',456),(543,'Nick','1998-07-27',456),(544,'Lucy','1998-08-07',345),(545,'Mike','1998-07-27',342),(546,'Maria','1999-07-27',456),(547,'Nick','1998-07-27',456),(548,'Lucy','1998-08-07',345),(549,'Mike','1998-07-27',342),(550,'Maria','1999-07-27',456),(551,'Nick','1998-07-27',456),(552,'Lucy','1998-08-07',345),(553,'Mike','1998-07-27',342),(554,'Maria','1999-07-27',456),(555,'Nick','1998-07-27',456),(556,'Lucy','1998-08-07',345),(557,'Mike','1998-07-27',342),(558,'Maria','1999-07-27',456),(559,'Nick','1998-07-27',456),(560,'Lucy','1998-08-07',345),(561,'Mike','1998-07-27',342),(562,'Maria','1999-07-27',456),(563,'Nick','1998-07-27',456),(564,'Lucy','1998-08-07',345),(565,'Mike','1998-07-27',342),(566,'Maria','1999-07-27',456),(567,'Nick','1998-07-27',456),(568,'Lucy','1998-08-07',345),(569,'Mike','1998-07-27',342),(570,'Maria','1999-07-27',456),(571,'Nick','1998-07-27',456),(572,'Lucy','1998-08-07',345),(573,'Mike','1998-07-27',342),(574,'Maria','1999-07-27',456),(575,'Nick','1998-07-27',456),(576,'Lucy','1998-08-07',345),(577,'Mike','1998-07-27',342),(578,'Maria','1999-07-27',456),(579,'Nick','1998-07-27',456),(580,'Lucy','1998-08-07',345),(581,'Mike','1998-07-27',342),(582,'Maria','1999-07-27',456),(583,'Nick','1998-07-27',456),(584,'Lucy','1998-08-07',345),(585,'Mike','1998-07-27',342),(586,'Maria','1999-07-27',456),(587,'Nick','1998-07-27',456),(588,'Lucy','1998-08-07',345),(589,'Mike','1998-07-27',342),(590,'Maria','1999-07-27',456),(591,'Nick','1998-07-27',456),(592,'Lucy','1998-08-07',345),(593,'Mike','1998-07-27',342),(594,'Maria','1999-07-27',456),(595,'Nick','1998-07-27',456),(596,'Lucy','1998-08-07',345),(597,'Mike','1998-07-27',342),(598,'Maria','1999-07-27',456),(599,'Nick','1998-07-27',456),(600,'Lucy','1998-08-07',345),(601,'Mike','1998-07-27',342),(602,'Maria','1999-07-27',456),(603,'Nick','1998-07-27',456),(604,'Lucy','1998-08-07',345),(605,'Mike','1998-07-27',342),(606,'Maria','1999-07-27',456),(607,'Nick','1998-07-27',456),(608,'Lucy','1998-08-07',345),(609,'Mike','1998-07-27',342),(610,'Maria','1999-07-27',456),(611,'Nick','1998-07-27',456),(612,'Lucy','1998-08-07',345),(613,'Mike','1998-07-27',342),(614,'Maria','1999-07-27',456),(615,'Nick','1998-07-27',456),(616,'Lucy','1998-08-07',345),(617,'Mike','1998-07-27',342),(618,'Maria','1999-07-27',456),(619,'Nick','1998-07-27',456),(620,'Lucy','1998-08-07',345),(621,'Mike','1998-07-27',342),(622,'Maria','1999-07-27',456),(623,'Nick','1998-07-27',456),(624,'Lucy','1998-08-07',345),(625,'Mike','1998-07-27',342),(626,'Maria','1999-07-27',456),(627,'Nick','1998-07-27',456),(628,'Lucy','1998-08-07',345),(629,'Mike','1998-07-27',342),(630,'Maria','1999-07-27',456),(631,'Nick','1998-07-27',456),(632,'Lucy','1998-08-07',345),(633,'Mike','1998-07-27',342),(634,'Maria','1999-07-27',456),(635,'Nick','1998-07-27',456),(636,'Lucy','1998-08-07',345),(637,'Mike','1998-07-27',342),(638,'Maria','1999-07-27',456),(639,'Nick','1998-07-27',456),(640,'Lucy','1998-08-07',345),(641,'Mike','1998-07-27',342),(642,'Maria','1999-07-27',456),(643,'Nick','1998-07-27',456),(644,'Lucy','1998-08-07',345),(645,'Mike','1998-07-27',342),(646,'Maria','1999-07-27',456),(647,'Nick','1998-07-27',456),(648,'Lucy','1998-08-07',345),(649,'Mike','1998-07-27',342),(650,'Maria','1999-07-27',456),(651,'Nick','1998-07-27',456),(652,'Lucy','1998-08-07',345),(653,'Mike','1998-07-27',342),(654,'Maria','1999-07-27',456),(655,'Nick','1998-07-27',456),(656,'Lucy','1998-08-07',345),(657,'Mike','1998-07-27',342),(658,'Maria','1999-07-27',456),(659,'Nick','1998-07-27',456),(660,'Lucy','1998-08-07',345),(661,'Mike','1998-07-27',342),(662,'Maria','1999-07-27',456),(663,'Nick','1998-07-27',456),(664,'Lucy','1998-08-07',345),(665,'Mike','1998-07-27',342),(666,'Maria','1999-07-27',456),(667,'Nick','1998-07-27',456),(668,'Lucy','1998-08-07',345),(669,'Mike','1998-07-27',342),(670,'Maria','1999-07-27',456),(671,'Nick','1998-07-27',456),(672,'Lucy','1998-08-07',345),(673,'Mike','1998-07-27',342),(674,'Maria','1999-07-27',456),(675,'Nick','1998-07-27',456),(676,'Lucy','1998-08-07',345),(677,'Mike','1998-07-27',342),(678,'Maria','1999-07-27',456),(679,'Nick','1998-07-27',456),(680,'Lucy','1998-08-07',345),(681,'Mike','1998-07-27',342),(682,'Maria','1999-07-27',456),(683,'Nick','1998-07-27',456),(684,'Lucy','1998-08-07',345),(685,'Mike','1998-07-27',342),(686,'Maria','1999-07-27',456),(687,'Nick','1998-07-27',456),(688,'Lucy','1998-08-07',345),(689,'Mike','1998-07-27',342),(690,'Maria','1999-07-27',456),(691,'Nick','1998-07-27',456),(692,'Lucy','1998-08-07',345),(693,'Mike','1998-07-27',342),(694,'Maria','1999-07-27',456),(695,'Nick','1998-07-27',456),(696,'Lucy','1998-08-07',345),(697,'Mike','1998-07-27',342),(698,'Maria','1999-07-27',456),(699,'Nick','1998-07-27',456),(700,'Lucy','1998-08-07',345),(701,'Mike','1998-07-27',342),(702,'Maria','1999-07-27',456),(703,'Nick','1998-07-27',456),(704,'Lucy','1998-08-07',345),(705,'Mike','1998-07-27',342),(706,'Maria','1999-07-27',456),(707,'Nick','1998-07-27',456),(708,'Lucy','1998-08-07',345),(709,'Mike','1998-07-27',342),(710,'Maria','1999-07-27',456),(711,'Nick','1998-07-27',456),(712,'Lucy','1998-08-07',345),(713,'Mike','1998-07-27',342),(714,'Maria','1999-07-27',456),(715,'Nick','1998-07-27',456),(716,'Lucy','1998-08-07',345),(717,'Mike','1998-07-27',342),(718,'Maria','1999-07-27',456),(719,'Nick','1998-07-27',456),(720,'Lucy','1998-08-07',345),(721,'Mike','1998-07-27',342),(722,'Maria','1999-07-27',456),(723,'Nick','1998-07-27',456),(724,'Lucy','1998-08-07',345),(725,'Mike','1998-07-27',342),(726,'Maria','1999-07-27',456),(727,'Nick','1998-07-27',456),(728,'Lucy','1998-08-07',345),(729,'Mike','1998-07-27',342),(730,'Maria','1999-07-27',456),(731,'Nick','1998-07-27',456),(732,'Lucy','1998-08-07',345),(733,'Mike','1998-07-27',342),(734,'Maria','1999-07-27',456),(735,'Nick','1998-07-27',456),(736,'Lucy','1998-08-07',345),(737,'Mike','1998-07-27',342),(738,'Maria','1999-07-27',456),(739,'Nick','1998-07-27',456),(740,'Lucy','1998-08-07',345),(741,'Mike','1998-07-27',342),(742,'Maria','1999-07-27',456),(743,'Nick','1998-07-27',456),(744,'Lucy','1998-08-07',345),(745,'Mike','1998-07-27',342),(746,'Maria','1999-07-27',456),(747,'Nick','1998-07-27',456),(748,'Lucy','1998-08-07',345),(749,'Mike','1998-07-27',342),(750,'Maria','1999-07-27',456),(751,'Nick','1998-07-27',456),(752,'Lucy','1998-08-07',345),(753,'Mike','1998-07-27',342),(754,'Maria','1999-07-27',456),(755,'Nick','1998-07-27',456),(756,'Lucy','1998-08-07',345),(757,'Mike','1998-07-27',342),(758,'Maria','1999-07-27',456),(759,'Nick','1998-07-27',456),(760,'Lucy','1998-08-07',345),(761,'Mike','1998-07-27',342),(762,'Maria','1999-07-27',456);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-15 18:56:15
