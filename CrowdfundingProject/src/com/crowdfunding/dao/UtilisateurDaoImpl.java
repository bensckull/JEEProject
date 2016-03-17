package com.crowdfunding.dao;
import static com.crowdfunding.dao.DAOUtilitaire.*;
import com.crowdfunding.beans.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.crypto.Data;

public class UtilisateurDaoImpl implements UtilisateurDao {

	private static final String SQL_SELECT_PAR_EMAIL = "SELECT pseudo, email, nom, prenom, motdepasse FROM utilisateur WHERE email = ?";
    private static final String SQL_INSERT           = "INSERT INTO utilisateur (nom, prenom, pseudo, email, motdepasse) VALUES (?, ?, ?, ?, ?)";

    private DAOFactory          daoFactory;

    UtilisateurDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Utilisateur trouver( String email ) throws DAOException {
        return trouver( SQL_SELECT_PAR_EMAIL, email );
    }

    @Override
    public void creer( Utilisateur utilisateur ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true, utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getPseudo(), utilisateur.getEmail(), utilisateur.getMotdepasse()/*, DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT)*/);
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table." );
            }
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
                utilisateur.setId( valeursAutoGenerees.getInt("idUser"));	//notre id n'est pas auto généré
            } else {
                throw new DAOException( "Échec de la création de l'utilisateur en base, aucun ID auto-généré retourné." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
    }

    /*
     * Méthode générique utilisée pour retourner un utilisateur depuis la base
     * de données, correspondant à la requête SQL donnée prenant en paramètres
     * les objets passés en argument.
     */
    private Utilisateur trouver( String sql, Object... objets ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Utilisateur utilisateur = null;

        try {
            connexion = daoFactory.getConnection();
            /*
             * Préparation de la requête avec les objets passés en arguments
             * (ici, uniquement une adresse email) et exécution.
             */
            preparedStatement = initialisationRequetePreparee( connexion, sql, false, objets );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données retournée dans le ResultSet */
            if ( resultSet.next() ) {
                utilisateur = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return utilisateur;
    }

    /*
     * Simple méthode utilitaire permettant de faire la correspondance (le
     * mapping) entre une ligne issue de la table des utilisateurs (un
     * ResultSet) et un bean Utilisateur.
     */
    private static Utilisateur map( ResultSet resultSet ) throws SQLException {
        Utilisateur utilisateur = new Utilisateur();
       // utilisateur.setId( resultSet.getLong( "id" ) ); //on utilise pas id de l'utilisateur pour l'instant
        utilisateur.setEmail( resultSet.getString( "email" ) );
        utilisateur.setMotdepasse( resultSet.getString( "motdepasse" ) );
        utilisateur.setNom( resultSet.getString( "nom" ) );
        utilisateur.setPseudo(resultSet.getString("pseudo"));
        utilisateur.setDateInscription( resultSet.getTimestamp( "dateInscription" ) );
        return utilisateur;
    }
}
