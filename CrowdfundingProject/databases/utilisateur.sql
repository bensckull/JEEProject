--
-- Base de données: `crowdfundingproject`
--

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `age` int(11) NOT NULL,
  `actif` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'définit si un utilisateur est en ligne. Par défaut, false.',
  `adresse` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Table définissant un utilisateur du site.';

