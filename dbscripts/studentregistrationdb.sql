CREATE DATABASE IF NOT EXISTS `studentregistrationdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `studentregistrationdb`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: studentregistrationdb
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students`
(
    `student_id`     bigint(20) NOT NULL AUTO_INCREMENT,
    `admission_date` date         DEFAULT NULL,
    `cgpa`           float        DEFAULT NULL,
    `name`           varchar(255) DEFAULT NULL,
    `student_number` bigint(20) NOT NULL,
    PRIMARY KEY (`student_id`),
    UNIQUE KEY `UK_h7gboo6v79gig1eo7lt1fubew` (`student_number`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students`
    DISABLE KEYS */;
INSERT INTO `students`
VALUES (1, '2018-10-24', 3.94, 'John A. Smith', 980001),
       (2, '2019-03-15', 3.05, 'Anna-Marie Jones', 980002),
       (3, '2018-10-24', 2.9, 'Peter Harrington', 980003),
       (4, '2018-10-24', 3.77, 'Ducarmel R. Saint-Jean', 980004),
       (5, '2019-03-13', 3.26, 'Mary W. Washington', 980005);
/*!40000 ALTER TABLE `students`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transcripts`
--

DROP TABLE IF EXISTS `transcripts`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transcripts`
(
    `transcript_id` bigint(20) NOT NULL AUTO_INCREMENT,
    `degree_title`  varchar(255) DEFAULT NULL,
    `student_id`    bigint(20)   DEFAULT NULL,
    PRIMARY KEY (`transcript_id`),
    KEY `FKmgay21yrdmlkyq5q7akg7hr5f` (`student_id`),
    CONSTRAINT `FKmgay21yrdmlkyq5q7akg7hr5f` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transcripts`
--

LOCK TABLES `transcripts` WRITE;
/*!40000 ALTER TABLE `transcripts`
    DISABLE KEYS */;
INSERT INTO `transcripts`
VALUES (1, 'BS Computer Science', NULL),
       (2, 'MS Computer Science', NULL),
       (3, 'BS Mathematics', NULL),
       (4, 'PhD Vedic Science', NULL),
       (5, 'MA Film Production', NULL);
/*!40000 ALTER TABLE `transcripts`
    ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2019-06-06 22:19:16
