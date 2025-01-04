-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 04. Jan 2025 um 16:15
-- Server-Version: 10.4.32-MariaDB
-- PHP-Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `ghostnet-db`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `bergendeperson`
--

CREATE TABLE IF NOT EXISTS `bergendeperson` (
  `benutzerName` varchar(255) DEFAULT NULL,
  `passwort` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `geisternetz`
--

CREATE TABLE IF NOT EXISTS `geisternetz` (
  `id` int(11) NOT NULL,
  `groesse` int(11) DEFAULT NULL,
  `lfdNr` int(11) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `bergendePerson_id` int(11) DEFAULT NULL,
  `gps_id` int(11) DEFAULT NULL,
  `meldendePerson_id` int(11) DEFAULT NULL,
  `verschollenMeldendePerson_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_8gerx2bq6gsefqky3jy5owxfk` (`gps_id`),
  KEY `FKsk3yh9raoxc0jrdu3e5w9ncmt` (`bergendePerson_id`),
  KEY `FKg6sis7driuy5awta88a8iqe5b` (`meldendePerson_id`),
  KEY `FKi9d11t19v6ucrv2kv4jjcigpc` (`verschollenMeldendePerson_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Daten für Tabelle `geisternetz`
--

INSERT INTO `geisternetz` (`id`, `groesse`, `lfdNr`, `status`, `bergendePerson_id`, `gps_id`, `meldendePerson_id`, `verschollenMeldendePerson_id`) VALUES
(1, 500, 1, 0, NULL, 1, 1, NULL),
(2, 899, 2, 0, NULL, 2, 1, NULL),
(52, 5508, 3, 0, NULL, 52, 2, NULL),
(53, 555, 4, 0, NULL, 53, 3, NULL),
(54, 4212, 5, 0, NULL, 54, 4, NULL),
(55, 820, 6, 0, NULL, 55, 5, NULL),
(56, 893, 7, 0, NULL, 56, 6, NULL),
(57, 5500, 8, 0, NULL, 57, 7, NULL),
(58, 58480, 9, 0, NULL, 58, 8, NULL),
(59, 68468, 10, 0, NULL, 59, 9, NULL),
(60, 54884, 11, 0, NULL, 60, 10, NULL);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `geisternetz_seq`
--

CREATE TABLE IF NOT EXISTS `geisternetz_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Daten für Tabelle `geisternetz_seq`
--

INSERT INTO `geisternetz_seq` (`next_val`) VALUES
(151);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `gps`
--

CREATE TABLE IF NOT EXISTS `gps` (
  `id` int(11) NOT NULL,
  `breitengrad` double DEFAULT NULL,
  `laengengrad` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Daten für Tabelle `gps`
--

INSERT INTO `gps` (`id`, `breitengrad`, `laengengrad`) VALUES
(1, 12.045654, 120.456406),
(2, 20.045654, 155.0566),
(52, 12.465465, 55.45545),
(53, 15, 54.4564),
(54, 48.408646, 23.4688),
(55, -44.65654, -123.4654),
(56, 88.45465, 21.54654),
(57, 72.465, 117.45656),
(58, 17.4084, 121.468988),
(59, 75.4789, 114.4686),
(60, 50.84068, 50.4684);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `gps_seq`
--

CREATE TABLE IF NOT EXISTS `gps_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Daten für Tabelle `gps_seq`
--

INSERT INTO `gps_seq` (`next_val`) VALUES
(151);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `meldendeperson`
--

CREATE TABLE IF NOT EXISTS `meldendeperson` (
  `istAnonym` bit(1) NOT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Daten für Tabelle `meldendeperson`
--

INSERT INTO `meldendeperson` (`istAnonym`, `id`) VALUES
(b'0', 1),
(b'0', 2),
(b'0', 3),
(b'0', 4),
(b'0', 5),
(b'0', 6),
(b'0', 7),
(b'0', 8),
(b'0', 9),
(b'0', 10);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `person`
--

CREATE TABLE IF NOT EXISTS `person` (
  `id` int(11) NOT NULL,
  `nachname` varchar(255) DEFAULT NULL,
  `telefonnummer` varchar(255) DEFAULT NULL,
  `vorname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Daten für Tabelle `person`
--

INSERT INTO `person` (`id`, `nachname`, `telefonnummer`, `vorname`) VALUES
(1, 'Schmalenberger', '+4915124052489', 'Dennis'),
(2, 'Teach', '+44584646545', 'Edward'),
(3, 'Bonny', '+35324848455', 'Anne'),
(4, 'Morgan', '+4484684684', 'Henry'),
(5, 'Bonnet', '+15684684684', 'Stede'),
(6, 'Low', '+447082358486', 'Edward'),
(7, 'Luffy', '+815187435135', 'Monkey'),
(8, 'Roger', '+8184654684', 'Gold'),
(9, 'Graaf', '+31848465105', 'Laurens'),
(10, 'Braziliano', '+5587498468', 'Roche');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `person_seq`
--

CREATE TABLE IF NOT EXISTS `person_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Daten für Tabelle `person_seq`
--

INSERT INTO `person_seq` (`next_val`) VALUES
(101);

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `bergendeperson`
--
ALTER TABLE `bergendeperson`
  ADD CONSTRAINT `FKakr7jjfou989204byp0p7e1hm` FOREIGN KEY (`id`) REFERENCES `person` (`id`);

--
-- Constraints der Tabelle `geisternetz`
--
ALTER TABLE `geisternetz`
  ADD CONSTRAINT `FK802237ev2563h9ty0u23g7gyv` FOREIGN KEY (`gps_id`) REFERENCES `gps` (`id`),
  ADD CONSTRAINT `FKg6sis7driuy5awta88a8iqe5b` FOREIGN KEY (`meldendePerson_id`) REFERENCES `meldendeperson` (`id`),
  ADD CONSTRAINT `FKi9d11t19v6ucrv2kv4jjcigpc` FOREIGN KEY (`verschollenMeldendePerson_id`) REFERENCES `person` (`id`),
  ADD CONSTRAINT `FKsk3yh9raoxc0jrdu3e5w9ncmt` FOREIGN KEY (`bergendePerson_id`) REFERENCES `bergendeperson` (`id`);

--
-- Constraints der Tabelle `meldendeperson`
--
ALTER TABLE `meldendeperson`
  ADD CONSTRAINT `FKmo5xsk1gtfryreu0nqdkv09ud` FOREIGN KEY (`id`) REFERENCES `person` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
