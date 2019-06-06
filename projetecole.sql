-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: May 30, 2019 at 09:48 AM
-- Server version: 5.7.25
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `projetecole`
--

-- --------------------------------------------------------

--
-- Table structure for table `AnneeScolaire`
--

CREATE TABLE `AnneeScolaire` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Bulletin`
--

CREATE TABLE `Bulletin` (
  `id` int(11) NOT NULL,
  `idTrimestre` int(11) NOT NULL,
  `idInscription` int(11) NOT NULL,
  `appreciation` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Classe`
--

CREATE TABLE `Classe` (
  `id` int(11) NOT NULL,
  `nom` varchar(45) NOT NULL,
  `idNiveau` int(11) NOT NULL,
  `idAnneeScolaire` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `DetailBulletin`
--

CREATE TABLE `DetailBulletin` (
  `id` int(11) NOT NULL,
  `idBulletin` int(11) NOT NULL,
  `idEnseignement` int(11) NOT NULL,
  `appreciation` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Discipline`
--

CREATE TABLE `Discipline` (
  `id` int(11) NOT NULL,
  `nom` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Enseignement`
--

CREATE TABLE `Enseignement` (
  `id` int(11) NOT NULL,
  `idClasse` int(11) NOT NULL,
  `idDiscipline` int(11) NOT NULL,
  `idPersonne` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Evaluation`
--

CREATE TABLE `Evaluation` (
  `id` int(11) NOT NULL,
  `idDetailBulletin` int(11) NOT NULL,
  `note` int(11) NOT NULL,
  `appreciation` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `inscription`
--

CREATE TABLE `inscription` (
  `id` int(11) NOT NULL,
  `idClasse` int(11) NOT NULL,
  `idPersonne` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Niveau`
--

CREATE TABLE `Niveau` (
  `id` int(11) NOT NULL,
  `nom` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Personne`
--

CREATE TABLE `Personne` (
  `id` int(11) NOT NULL,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Trimestre`
--

CREATE TABLE `Trimestre` (
  `id` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `debut` int(11) NOT NULL,
  `fin` int(11) NOT NULL,
  `idAnneeScolaire` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `AnneeScolaire`
--
ALTER TABLE `AnneeScolaire`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Bulletin`
--
ALTER TABLE `Bulletin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Classe`
--
ALTER TABLE `Classe`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `DetailBulletin`
--
ALTER TABLE `DetailBulletin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Discipline`
--
ALTER TABLE `Discipline`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Enseignement`
--
ALTER TABLE `Enseignement`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Evaluation`
--
ALTER TABLE `Evaluation`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `inscription`
--
ALTER TABLE `inscription`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Niveau`
--
ALTER TABLE `Niveau`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Personne`
--
ALTER TABLE `Personne`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Trimestre`
--
ALTER TABLE `Trimestre`
  ADD PRIMARY KEY (`id`);
