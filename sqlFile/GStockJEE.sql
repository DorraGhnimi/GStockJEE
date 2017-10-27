-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Oct 27, 2017 at 02:26 AM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `GStockJEE`
--

-- --------------------------------------------------------

--
-- Table structure for table `PRODUITS`
--

CREATE TABLE `PRODUITS` (
  `ID` int(11) NOT NULL,
  `DESIGNATION` varchar(90) NOT NULL,
  `PRIX` double NOT NULL,
  `QUANTITE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `PRODUITS`
--

INSERT INTO `PRODUITS` (`ID`, `DESIGNATION`, `PRIX`, `QUANTITE`) VALUES
(1, 'Lenovo', 1360, 10),
(2, 'Mac', 2360, 20),
(3, 'ASUS', 1000, 30),
(4, 'Lenovo2', 1360, 10),
(5, 'Mac2', 2360, 20),
(6, 'ASUS2', 1000, 30),
(7, 'Dell8', 8000, 400),
(10, 'myPC', 0, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `PRODUITS`
--
ALTER TABLE `PRODUITS`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `PRODUITS`
--
ALTER TABLE `PRODUITS`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
