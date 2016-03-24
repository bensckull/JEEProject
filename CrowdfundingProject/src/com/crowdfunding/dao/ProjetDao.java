package com.crowdfunding.dao;

import com.crowdfunding.beans.Projet;

public interface ProjetDao {
	void creerProjet(Projet p, int idUser) throws DAOException;
	Projet chercherParType(String type) throws DAOException;
	Projet chercherParUtilisateur(int idUser) throws DAOException;
	void participation(int idUser, int idProject, int montant) throws DAOException;

}
