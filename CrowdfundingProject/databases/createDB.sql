--Cree la base de donnee ainsi qu'un utilisateur sur celle-ci 
CREATE DATABASE crowdfundingproject DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';
GRANT ALL ON crowdfundingproject.* TO 'admin'@'localhost' IDENTIFIED BY 'admin';
