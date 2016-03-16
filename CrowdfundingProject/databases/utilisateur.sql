CREATE TABLE IF NOT EXISTS `utilisateur` (
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `pseudo` varchar(20) DEFAULT NULL,
  `email` varchar(30) NOT NULL,
  `motdepasse` char(56) NOT NULL,
  `dateInscription` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `age` int(11) NOT NULL,
  `actif` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'définit si un utilisateur est en ligne. Par défaut, false.',
  `adresse` varchar(40) NOT NULL,
  `idUser` int(11) NOT NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE KEY `idUser` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=2016 COMMENT='Table définissant un utilisateur du site.';

