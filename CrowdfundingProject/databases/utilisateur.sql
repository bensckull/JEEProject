CREATE TABLE IF NOT EXISTS `utilisateur` (
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `pseudo` varchar(20) DEFAULT NULL,
  `email` varchar(30) NOT NULL,
  `motdepasse` char(56) NOT NULL,
  `dateInscription` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idUser` int(11) int NOT NULL IDENTITY(2016, 1),
  `age` int(11),
  `actif` tinyint(1) DEFAULT '0' COMMENT 'définit si un utilisateur est en ligne. Par défaut, false.',
  `adresse` varchar(40),
  `photoProfil` VARBINARY(MAX),
  PRIMARY KEY (`idUser`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Table définissant un utilisateur du site.';

