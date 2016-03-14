CREATE TABLE IF NOT EXISTS `utilisateur` (
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `age` int(11) NOT NULL,
  `pseudo` varchar(20),
  `email`varchar(30) NOT NULL,
  `motdepasse` varchar(20) NOT NULL,
  `actif` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'définit si un utilisateur est en ligne. Par défaut, false.',
  `adresse` varchar(40) NOT NULL,
  `idUser` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idUser`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=2016 COMMENT='Table définissant un utilisateur du site.';

