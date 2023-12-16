-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: sclalertech
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `tblemployee`
--

DROP TABLE IF EXISTS `tblemployee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblemployee` (
  `EmployeeID` bigint NOT NULL AUTO_INCREMENT,
  `EmployeeName` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Mobile` mediumtext NOT NULL,
  `Age` varchar(255) NOT NULL,
  `SubOrganizationID` bigint unsigned NOT NULL,
  `DepartmentID` bigint unsigned NOT NULL,
  `RoleID` bigint unsigned NOT NULL,
  PRIMARY KEY (`EmployeeID`),
  KEY `SubOrganizationID` (`SubOrganizationID`),
  KEY `DepartmentID` (`DepartmentID`),
  KEY `RoleID` (`RoleID`),
  CONSTRAINT `tblemployee_ibfk_1` FOREIGN KEY (`SubOrganizationID`) REFERENCES `tblsuborganization` (`SubOrganizationID`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `tblemployee_ibfk_2` FOREIGN KEY (`DepartmentID`) REFERENCES `tbldepartment` (`DepartmentID`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `tblemployee_ibfk_3` FOREIGN KEY (`RoleID`) REFERENCES `tblrole` (`RoleID`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblemployee`
--

LOCK TABLES `tblemployee` WRITE;
/*!40000 ALTER TABLE `tblemployee` DISABLE KEYS */;
INSERT INTO `tblemployee` VALUES (1,'Mr Sanjay','sanjay@Gmail.com','7016226818','19',1,1,1),(3,'Mr Ramesh','sanjay@Gmail.com','7016226817','19',1,1,1),(4,'Mr Ramesh','sanjay@Gmail.com','+197016226817','19',1,1,1),(5,'Mr Ramesh','sanjay@Gmail.com','+197016226817','18',1,1,1);
/*!40000 ALTER TABLE `tblemployee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-16 21:08:21
