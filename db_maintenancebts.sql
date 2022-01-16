-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 16, 2022 at 06:06 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_maintenancebts`
--

-- --------------------------------------------------------

--
-- Table structure for table `bts`
--

CREATE TABLE `bts` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `id_merkbts` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bts`
--

INSERT INTO `bts` (`id`, `name`, `address`, `city`, `id_merkbts`) VALUES
(1, 'Tower TSEL56DD', 'Jl. Lingkar Jati No. 56', 'Medan', 1),
(7, 'Tower XL42FGH', 'Jl. Mataram No. 14', 'Makassar', 2),
(8, 'Tower TSEL34BB', 'Jl. Antariksa No. 34', 'Medan', 1);

-- --------------------------------------------------------

--
-- Table structure for table `checklist`
--

CREATE TABLE `checklist` (
  `id` int(11) NOT NULL,
  `id_maintenance` int(11) DEFAULT NULL,
  `id_technician` int(11) DEFAULT NULL,
  `battery` varchar(255) DEFAULT NULL,
  `genset_fuel` varchar(255) DEFAULT NULL,
  `grounding` varchar(255) DEFAULT NULL,
  `date_check` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `checklist`
--

INSERT INTO `checklist` (`id`, `id_maintenance`, `id_technician`, `battery`, `genset_fuel`, `grounding`, `date_check`) VALUES
(5, 13, 1, 'Baik', 'Penuh', 'Baik', '2023-3-4');

-- --------------------------------------------------------

--
-- Table structure for table `merk_bts`
--

CREATE TABLE `merk_bts` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `merk_bts`
--

INSERT INTO `merk_bts` (`id`, `name`) VALUES
(1, 'TELKOMSEL'),
(2, 'XL');

-- --------------------------------------------------------

--
-- Table structure for table `order_maintenance`
--

CREATE TABLE `order_maintenance` (
  `id` int(11) NOT NULL,
  `id_user` int(11) DEFAULT NULL,
  `id_bts` int(11) DEFAULT NULL,
  `problem` varchar(255) DEFAULT NULL,
  `solution` varchar(255) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `finish_date` varchar(255) DEFAULT NULL,
  `approval` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order_maintenance`
--

INSERT INTO `order_maintenance` (`id`, `id_user`, `id_bts`, `problem`, `solution`, `notes`, `finish_date`, `approval`) VALUES
(10, 1, 8, '- Gangguan koneksi 4G\n- Baterai lemah', '-', '-', '-', NULL),
(13, 1, 7, '- Genset Mati\n- Jaringan bermasalah', 'Perbaiki receiver', '-', '2022-1-16', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `schedule`
--

CREATE TABLE `schedule` (
  `id` int(11) NOT NULL,
  `id_bts` int(11) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `schedule`
--

INSERT INTO `schedule` (`id`, `id_bts`, `date`, `status`) VALUES
(5, 8, '2022-1-7', 'Done'),
(7, 7, '2022-1-31', 'On-process');

-- --------------------------------------------------------

--
-- Table structure for table `technician`
--

CREATE TABLE `technician` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `team_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `technician`
--

INSERT INTO `technician` (`id`, `name`, `username`, `password`, `phone`, `team_name`) VALUES
(2, 'Felix Itanakimas', 'felix', 'felix', '081212121212', 'sicepat'),
(3, 'iwan', 'iwan', 'iwan', '081345454466', 'sicepat'),
(6, 'ridho', 'ridho', 'ridho', '081243464534', 'jayajaya');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `username`, `password`, `phone`, `position`) VALUES
(1, 'Admin', 'admin', 'admin', '081188888', 'Admin'),
(2, 'Irwansyah', 'irwan', 'irwan', '08133434363', 'Manager'),
(3, 'Rafif', 'rafif', 'rafif', '08124454535', 'Staff');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bts`
--
ALTER TABLE `bts`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `checklist`
--
ALTER TABLE `checklist`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `merk_bts`
--
ALTER TABLE `merk_bts`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `order_maintenance`
--
ALTER TABLE `order_maintenance`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `technician`
--
ALTER TABLE `technician`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bts`
--
ALTER TABLE `bts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `checklist`
--
ALTER TABLE `checklist`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `merk_bts`
--
ALTER TABLE `merk_bts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `order_maintenance`
--
ALTER TABLE `order_maintenance`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `schedule`
--
ALTER TABLE `schedule`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `technician`
--
ALTER TABLE `technician`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
