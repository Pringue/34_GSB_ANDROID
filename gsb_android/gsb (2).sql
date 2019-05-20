-- phpMyAdmin SQL Dump
-- version 4.7.6
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le :  Dim 19 mai 2019 à 23:17
-- Version du serveur :  10.1.29-MariaDB
-- Version de PHP :  7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gsb`
--

-- --------------------------------------------------------

--
-- Structure de la table `antibiotique`
--

CREATE TABLE `antibiotique` (
  `id` int(11) NOT NULL,
  `libelle` text NOT NULL,
  `libelleG` text NOT NULL,
  `unite` text NOT NULL,
  `nombreParJour` int(11) NOT NULL,
  `dosePrise` float NOT NULL,
  `doseKilo` float NOT NULL,
  `idCateg` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `antibiotique`
--

INSERT INTO `antibiotique` (`id`, `libelle`, `libelleG`, `unite`, `nombreParJour`, `dosePrise`, `doseKilo`, `idCateg`) VALUES
(1, 'Amikacine', 'Amiklin', 'mg', 1, 0, 15, 1),
(2, 'Gentamicine', 'Garamycine', 'mg', 1, 0, 6, 1),
(3, 'Netilmicine', 'Netromycine', 'mg', 1, 0, 6, 1),
(4, 'Tobramycine', 'Obracine', 'mg', 1, 0, 6, 1),
(5, 'Amphotéricine B', 'Fungizone', 'mg', 1, 0, 0.7, 2),
(6, 'Fluconazole', 'Diflucan', 'mg', 1, 300, 0, 2),
(7, 'Itraconazole', 'Sporanox', 'mg', 1, 200, 0, 2),
(8, 'Voriconazole', 'Vfend', 'mg', 2, 0, 5, 2),
(9, 'Aciclovir', 'Zovirax i.v', 'mg', 3, 0, 7, 3),
(10, 'Aciclovir p.o', 'Zovirax', 'mg', 3, 0, 200, 3),
(11, 'Valaciclovir', 'Valtrex', 'mg', 2, 700, 0, 3),
(12, 'Ertapénem', 'Invanz', 'g', 1, 1, 0, 4),
(13, 'Imipénem', 'Tienam', 'mg', 4, 0.75, 0, 4),
(14, 'Méropénem', 'Meronem', 'g', 3, 1, 0, 4),
(17, 'Céfaclor', 'Ceclor', 'mg', 3, 400, 0, 5),
(18, 'Céfazoline', 'Kefzol', 'g', 3, 1.5, 0, 5),
(19, 'Céfépime', 'Maxipime', 'g', 2, 2, 0, 5),
(20, 'Céféxime', 'Céphoral', 'mg', 2, 200, 0, 5),
(21, 'Céfotaxime', 'Claforan', 'g', 3, 1.5, 0, 5),
(22, 'Celpodoxime', 'Podomexef', 'mg', 2, 200, 0, 5),
(23, 'Ceftazidime', 'Fortam', 'g', 3, 1.5, 0, 5),
(24, 'Cefuroxime', 'Zinacef', 'g', 3, 1.2, 0, 5),
(25, 'Clarithromycine', 'Klacid', 'mg', 2, 500, 0, 6),
(26, 'Erythromycine', 'Erythrocin', 'mg', 3, 400, 0, 6),
(27, 'Amoxilline', 'Clamoxyl', 'mg', 3, 500, 0, 7),
(28, 'Amoxilline/clavulanate', 'Augmentin', 'mg', 3, 300, 0, 7),
(29, 'Benzylpénicilline', 'Pénicilline G', 'millions d\'UI', 4, 2, 0, 7),
(30, 'Pipéracilline/tazobactam', 'Tazobac', 'g', 3, 4.5, 0, 7),
(31, 'Ciprofloxacine', 'Ciproxine', 'mg', 2, 500, 0, 8),
(32, 'Lévofloxacine', 'Tavanic', 'mg', 1, 500, 0, 8),
(33, 'Norfloxacine', 'Noroxin', 'mg', 2, 400, 0, 8),
(34, 'Ofloxacine', 'Tarivid', 'mg', 2, 300, 0, 8),
(35, 'Sulfaméthoxazole i.v', 'Bactrim i.v', 'mg', 3, 0, 5, 9),
(36, 'Sulfaméthoxazole p.o', 'Bactrim p.0', 'mg', 2, 500, 0, 9),
(37, 'Aztréonam', 'Azactam', 'g', 3, 1.5, 0, 10),
(38, 'Métronidazole', 'Flagyl', 'mg', 3, 500, 0, 10),
(39, 'Nitrofurantoïne', 'Furadantime', 'mg', 4, 75, 0, 10),
(40, 'Teicoplanine', 'Targocid', 'mg', 1, 0, 6, 10),
(41, 'Vancomycine', 'Vancocine', 'g', 2, 1, 0, 10);

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `id` int(11) NOT NULL,
  `libelle` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`id`, `libelle`) VALUES
(1, 'Aminoglycosides'),
(2, 'AntiFongiques'),
(3, 'Antiviraux'),
(4, 'Carbapénèmes'),
(5, 'Céphalosporines'),
(6, 'Macrolides'),
(7, 'Pénicillines'),
(8, 'Quinolones'),
(9, 'Sulfamidés'),
(10, 'Autres');

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `id` int(11) NOT NULL,
  `nom` text NOT NULL,
  `mdp` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`id`, `nom`, `mdp`) VALUES
(1, 'test', 'test');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `antibiotique`
--
ALTER TABLE `antibiotique`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idCateg` (`idCateg`);

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `antibiotique`
--
ALTER TABLE `antibiotique`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `compte`
--
ALTER TABLE `compte`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `antibiotique`
--
ALTER TABLE `antibiotique`
  ADD CONSTRAINT `antibiotique_ibfk_1` FOREIGN KEY (`idCateg`) REFERENCES `categorie` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
