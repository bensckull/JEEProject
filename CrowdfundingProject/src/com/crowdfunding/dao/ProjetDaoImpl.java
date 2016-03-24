package com.crowdfunding.dao;
import static com.crowdfunding.dao.DAOUtilitaire.*;
import com.crowdfunding.beans.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.crowdfunding.beans.Projet;

public class ProjetDaoImpl implements ProjetDao {
	private static final String SQL_SELECT_PAR_TYPE = "SELECT * FROM projet WHERE typeProject = ?";
	private static final String SQL_SELECT_PAR_UTILISATEUR = "SELECT * FROM projet WHERE idUser = ?";
    private static final String SQL_INSERT           = "INSERT INTO projet (nom, typeProject, montantTotal, dateFin, description) VALUES (?, ?, ?, ?, ?)";

    private DAOFactory          daoFactory;
    
    public ProjetDaoImpl(DAOFactory daoFactory) {
    	this.daoFactory = daoFactory;
    }

	@Override
	public void creerProjet(Projet p) throws DAOException {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true, p.getNom(), p.getTypeProject(), p.getMontantTotal(), p.getDateFin(), p.getDescription());
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la création du projet, aucune ligne ajoutée dans la table." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses(preparedStatement, connexion );
        }

	}

	@Override
	public Projet chercherParType(String type) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Projet chercherParUtilisateur(int idUser) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
