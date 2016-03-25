package com.crowdfunding.dao;
import static com.crowdfunding.dao.DAOUtilitaire.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.crowdfunding.beans.Projet;

public class ProjetDaoImpl implements ProjetDao {
	private static final String SQL_SELECT_PAR_TYPE = "SELECT * FROM projet WHERE typeProject = ?";
	private static final String SQL_SELECT_ALL = "SELECT * FROM projet LIMIT ?";
	private static final String SQL_SELECT_ALL_PAR_UTILISATEUR = "SELECT * FROM projet WHERE idPromoteur = ?";
	private static final String SQL_SELECT_PAR_UTILISATEUR = "SELECT * FROM projet WHERE idUser = ?";
    private static final String SQL_INSERT           = "INSERT INTO projet (idPromoteur, nom, typeProject, montantTotal, dateFin, description) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SQL_INSERT_PARTICIPANT = "INSERT INTO participant (idParticipant, idProjet, montantDonne) VALUES (?, ?, ?)";
    private static final String SQL_SELECT_PARTICIPANT = "SELECT * FROM participant WHERE idProjet = ?";
    private DAOFactory          daoFactory;
    
	public ProjetDaoImpl(DAOFactory daoFactory) {
    	this.daoFactory = daoFactory;
    }

	@Override
	public void creerProjet(Projet p, int idUser) throws DAOException {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, false, idUser, p.getNom(), p.getTypeProject(), p.getMontantTotal(), p.getDateFin(), p.getDescription());
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
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Projet p = null;
        

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_PAR_TYPE, false, type);
            resultSet = preparedStatement.executeQuery();
            if ( resultSet.next() ) {
                p = map(resultSet);
            	
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
        return p;

	}

	@Override
	public Projet chercherParUtilisateur(int idUser) throws DAOException {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Projet p = null;
        

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_PAR_UTILISATEUR, false, idUser);
            resultSet = preparedStatement.executeQuery();
            if ( resultSet.next() ) {
                p = map(resultSet);
            	
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
        return p;
	}

	@Override
	public void participation(int idUser, int idProject, int montant) throws DAOException {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT_PARTICIPANT, true, idUser, idProject, montant);
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

	private static Projet map(ResultSet resultSet ) throws SQLException {
	   Projet p = new Projet();
	   p.setNom(resultSet.getString("nom"));
	   p.setTypeProject(resultSet.getString("typeProject"));
	   p.setDateFin(resultSet.getTimestamp("dateFin"));
	   p.setMontantRecolte(resultSet.getInt("montantRecolte"));
	   p.setMontantTotal(resultSet.getInt("montantTotal"));
	   p.setDescription(resultSet.getString("description"));
	   p.setIdProjet(resultSet.getInt("idProjet"));
	   p.setIdPromoteur(resultSet.getInt("idPromoteur"));
	   return p;
	   
	   
	}

	@Override
	public List<Projet> listeProjets(int limit) throws DAOException {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Projet> listP = new ArrayList<Projet>();
        

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_ALL, false, limit);
            resultSet = preparedStatement.executeQuery();
            while( resultSet.next() ) {
                listP.add(map(resultSet));
            	
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
        return listP;
	}

	@Override
	public int countParticipants(int idProject) throws DAOException {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int nbre=0;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_PARTICIPANT, false, idProject);
            resultSet = preparedStatement.executeQuery();
            while( resultSet.next()){
                nbre++;
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
        return nbre;
}	
	@Override
	public List<Projet> listeProjetsParUtilisateur(int idUser) throws DAOException {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Projet> listP = new ArrayList<Projet>();
        

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_ALL_PAR_UTILISATEUR, false, idUser);
            resultSet = preparedStatement.executeQuery();
            while( resultSet.next() ) {
                listP.add(map(resultSet));
            	
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
        return listP;
	}
}
