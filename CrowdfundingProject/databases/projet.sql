CREATE TABLE IF NOT EXISTS `projet` (
  	`nom` varchar(30) NOT NULL,
  	`typeProject` varchar(30) NOT NULL,
  	`montantTotal` int(11) NOT NULL,
  	`dateFin` date NOT NULL,
  	`description` varchar(255) NOT NULL,
	`montantRecolte` int(11) DEFAULT '0',
  	`idProjet` int(11) NOT NULL AUTO_INCREMENT,
	`idPromoteur` int(11) NOT NULL,
  	PRIMARY KEY (`idProjet`),
  	FOREIGN KEY (`idPromoteur`) REFERENCES `utilisateur`(`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1698 COMMENT='Table définissant un projet du site.';


CREATE TABLE IF NOT EXISTS `participant` (
	`idParticipant` int(11) NOT NULL,
  	`idProjet` int(11) NOT NULL,
	`montantDonne` int(11) NOT NULL DEFAULT '10' COMMENT='Participation à 10 euro par défaut.',  
  FOREIGN KEY (`idParticipant`) REFERENCES `utilisateur`(`idUser`), 
  FOREIGN KEY (`idProjet`) REFERENCES `projet`(`idProjet`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Table pour la jointure entre projet et utilisateur.';
