-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 04, 2021 at 10:15 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_aplikasiku1811500030`
--

-- --------------------------------------------------------

--
-- Table structure for table `hospital_1811500030`
--

CREATE TABLE `hospital_1811500030` (
  `id` int(10) NOT NULL,
  `nama` varchar(50) CHARACTER SET latin1 NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hospital_1811500030`
--

INSERT INTO `hospital_1811500030` (`id`, `nama`, `latitude`, `longitude`) VALUES
(1, 'RSIA Muhaya', -2.112084897175793, 106.11180176807963),
(2, 'Spesialis Mata Timah', -2.1135634730028183, 106.10923956574884),
(3, 'Sun Clinic', -2.1345518851471597, 106.10783215879462),
(4, 'RS Kalbu Intan Medika', -2.1380859882517265, 106.1160600761881),
(5, 'RSUD Pangkalpinang', -2.143170755052928, 106.12428799399184),
(6, 'Siloam Hospitals', -2.1524026289883897, 106.12952066136275),
(7, 'Rumah Sakit Bhakti Wara', -2.142409718057969, 106.09799097310739),
(8, 'RSUD Ir.Soekarno Provinsi', -2.004076695634254, 106.14307681532955),
(9, 'RSUD Depati Bahrin Sungailiat', -1.8811793323491128, 106.1143042735373),
(10, 'Rumah Bersalin Al Haddi Medika stania', -1.8947332192879067, 106.11108562292969);

-- --------------------------------------------------------

--
-- Table structure for table `restaurant_1811500030`
--

CREATE TABLE `restaurant_1811500030` (
  `id` int(10) NOT NULL,
  `nama` varchar(50) CHARACTER SET latin1 NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `restaurant_1811500030`
--

INSERT INTO `restaurant_1811500030` (`id`, `nama`, `latitude`, `longitude`) VALUES
(1, 'Restoran Jabrik', -2.1590104609027123, 106.13296151045122),
(2, 'Otak Otak Ase Melintas', -2.1325276509828277, 106.11146233285115),
(3, 'RM Asui Seafood', -2.1336748409552913, 106.11344716737847),
(4, 'Kedai Momo', -2.133074442580621, 106.11491701785201),
(5, 'Bakmi Abot', -2.1332459849954333, 106.1133720655765),
(6, 'RM Ameng', -2.1337820549269453, 106.11560366335002),
(7, 'Martabak Acau', -2.135229442833574, 106.11871502565941),
(8, 'Warung Bolak Balik', -2.135604691317405, 106.11899397551612),
(9, 'Tan Kasteel Restaurant & Lounge', -2.118583563997396, 106.10881587667141),
(10, 'Pizza Qq Delivery', -2.1127286491400343, 106.10488045981704);

-- --------------------------------------------------------

--
-- Table structure for table `sekolah_1811500030`
--

CREATE TABLE `sekolah_1811500030` (
  `id` int(10) NOT NULL,
  `nama` varchar(50) CHARACTER SET latin1 NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sekolah_1811500030`
--

INSERT INTO `sekolah_1811500030` (`id`, `nama`, `latitude`, `longitude`) VALUES
(1, 'SD-SMP Theresia', -2.134611434196764, 106.11004138591633),
(2, 'Sekolah Kasih Baptis', -2.1361124281827357, 106.11431146238908),
(3, 'SDN 16', -2.1365841688590432, 106.1092045363728),
(4, 'SDN 54', -2.1387498855313667, 106.12780833794314),
(5, 'Japanese Mathematics Center', -2.1336033085756645, 106.11097390677995),
(6, 'SMK Bakti', -2.1327717563605817, 106.11480498319834),
(7, 'SMA Santo Yosef', -2.1430867334965775, 106.09595528663219),
(8, 'SMAN 1 Pangkalpinang', -2.1161512386426713, 106.10305685352674),
(9, 'SMA Negeri 2 Pangkalpinang', -2.128391293228739, 106.14061878298827),
(10, 'SMA Negeri 3 Pangkalpinang', -2.1316552912561266, 106.09244152645648);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hospital_1811500030`
--
ALTER TABLE `hospital_1811500030`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `restaurant_1811500030`
--
ALTER TABLE `restaurant_1811500030`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sekolah_1811500030`
--
ALTER TABLE `sekolah_1811500030`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
