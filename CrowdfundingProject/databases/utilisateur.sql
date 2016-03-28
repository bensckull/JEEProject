  CREATE TABLE IF NOT EXISTS  `utilisateur` (
 `nom` VARCHAR( 30 ) NOT NULL ,
 `prenom` VARCHAR( 30 ) NOT NULL ,
 `pseudo` VARCHAR( 20 ) DEFAULT NULL ,
 `email` VARCHAR( 30 ) NOT NULL ,
 `motdepasse` CHAR( 56 ) NOT NULL ,
 `dateInscription` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
 `idUser` INT( 11 ) NOT NULL AUTO_INCREMENT ,
 `age` INT( 11 ) ,
 `actif` TINYINT( 1 ) DEFAULT  '0' COMMENT  'definit si un utilisateur est en ligne. Par defaut, false.',
 `adresse` VARCHAR( 40 ) ,
 `photoProfil` VARBINARY( 255 ) ,
PRIMARY KEY (  `idUser` )
) ENGINE = INNODB DEFAULT CHARSET = utf8 AUTO_INCREMENT =2016 COMMENT =  'Table definissant un utilisateur du site.'
