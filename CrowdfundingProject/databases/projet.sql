CREATE TABLE IF NOT EXISTS `projet` (
  `nom` varchar(30) NOT NULL,
  `type` varchar(30) NOT NULL,
  `montantTotal` int(11) NOT NULL,
	`montantRecolte` int(11) NOT NULL DEFAULT '0',
	`dateFin` date NOT NULL,
  `idProjet` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
	`idPromoteur` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`idProjet`),
  FOREIGN KEY (`idPromoteur`) REFERENCES `utilisateur`(`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1698 COMMENT='Table définissant un projet du site.';


CREATE TABLE IF NOT EXISTS `participant` (
	`idParticipant` bigint(20) unsigned NOT NULL,
  `idProjet` bigint(20) unsigned NOT NULL,
	`montantDonne` int(11) NOT NULL DEFAULT '10' COMMENT='Participation à 10 euro par défaut.',  
  FOREIGN KEY (`idParticipant`) REFERENCES `utilisateur`(`idUser`), 
  FOREIGN KEY (`idProjet`) REFERENCES `projet`(`idProjet`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1698 COMMENT='Table pour la jointure entre projet et utilisateur.';
