package org.eni_encheres.dal.jdbc;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

import org.eni_encheres.bo.Article_Vendu;
import org.eni_encheres.bo.Utilisateur;
import org.eni_encheres.config.ConnectionProvider;
import org.eni_encheres.dal.UtilisateurDAO;

public class UtilisateurDAOImpl implements UtilisateurDAO{

	private final static String INSERT_UTILISATEUR ="INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_BY_USERNAME = "SELECT * FROM UTILISATEURS WHERE pseudo = ?";

	@Override
	public List<Utilisateur> selectByKeyWord(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utilisateur> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Utilisateur utilisateur) {
		try(Connection connection = ConnectionProvider.getConnection()) {
			System.out.println(utilisateur.getPassword());
			PreparedStatement statement = connection.prepareStatement(INSERT_UTILISATEUR);
			statement.setString(1, utilisateur.getUsername());
			statement.setString(2, utilisateur.getLastname());
			statement.setString(3, utilisateur.getFirstname());
			statement.setString(4, utilisateur.getEmail());
			statement.setString(5, utilisateur.getPhoneNumber());
			statement.setString(6, utilisateur.getStreet());
			statement.setString(7, utilisateur.getZipCode());
			statement.setString(8, utilisateur.getTown());
			statement.setString(9, utilisateur.getPassword());
			statement.setInt(10, 0);
			statement.setBoolean(11, false);
			statement.executeUpdate();

		}catch (SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public Utilisateur selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur selectByUsername(String pseudo) {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = connection.prepareStatement(SELECT_BY_USERNAME);
			pStmt.setString(1, pseudo);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next())
				return new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"),
						rs.getString("nom"), rs.getString("prenom"),
						rs.getString("email"),rs.getString("telephone"),
						rs.getString("rue"),rs.getString("code_postal"),
						rs.getString("ville"),rs.getString("mot_de_passe"),
						rs.getInt("credit"),rs.getBoolean("administrateur"));
		} catch (SQLException e) {//DalException
			e.printStackTrace();
		}
		return null;
	}

}
