package org.eni_encheres.dal.jdbc;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.eni_encheres.bo.Article_Vendu;
import org.eni_encheres.bo.Enchere;
import org.eni_encheres.bo.Utilisateur;
import org.eni_encheres.config.ConnectionProvider;
import org.eni_encheres.dal.UtilisateurDAO;

public class UtilisateurDAOImpl implements UtilisateurDAO {

	private final static String SELECT_ALL_UTILISATEUR = "SELECT * FROM UTILISATEURS;";

	  private final static String SELECT_USERNAME_MO = "SELECT umo.pseudo, av.no_utilisateur, av.no_article "
	  + "FROM UTILISATEURS umo INNER JOIN ENCHERES e "
	  + "on e.no_utilisateur = umo.no_utilisateur INNER JOIN UTILISATEURS uv "
	  + "on e.no_utilisateur = uv.no_utilisateur INNER JOIN ARTICLES_VENDUS av "
	  + "on e.no_article = av.no_article "
	  + "WHERE av.no_article = ? AND montant_enchere = (SELECT max(montant_enchere) FROM ENCHERES WHERE no_article = ?);"
	  ;

	private final static String INSERT_UTILISATEUR = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_BY_USERNAME = "SELECT * FROM UTILISATEURS WHERE pseudo = ?";
	private static final String DELETE_BY_ID = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?";
	private static final String SELECT_BY_EMAIL = "SELECT * FROM UTILISATEURS WHERE email = ?";
	private final static String UPDATE_UTILISATEUR = "UPDATE UTILISATEURS SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ?, credit = ?, administrateur = ? WHERE pseudo = ?;";
	private final static String DEBITER_ACHETEUR = "UPDATE UTILISATEURS SET credit = credit - ? WHERE no_utilisateur = ?;";
	private final static String CREDITER_VENDEUR = "UPDATE UTILISATEURS SET credit = credit + ? WHERE no_utilisateur = ?;";
//    private final static String INSERT_UTILISATEUR = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
//    private static final String SELECT_BY_USERNAME = "SELECT * FROM UTILISATEURS WHERE pseudo = ?";
//    private static final String DELETE_BY_ID = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?";
//    private static final String SELECT_BY_EMAIL = "SELECT * FROM UTILISATEURS WHERE email = ?";
//    private final static String UPDATE_UTILISATEUR = "UPDATE UTILISATEURS SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ?, credit = ?, administrateur = ? WHERE pseudo = ?;";

	@Override
	public List<Utilisateur> selectByKeyWord(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utilisateur> selectAll() {
		try (Connection connection = ConnectionProvider.getConnection()) {
			List<Utilisateur> utilisateurs = new ArrayList<>();

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_ALL_UTILISATEUR);

			while (resultSet.next()) {
				utilisateurs.add(new Utilisateur(resultSet.getInt("no_utilisateur"), resultSet.getString("pseudo"),
						resultSet.getString("nom"), resultSet.getString("prenom"), resultSet.getString("email"),
						resultSet.getString("telephone"), resultSet.getString("rue"),
						resultSet.getString("code_postal"), resultSet.getString("ville"),
						resultSet.getString("mot_de_passe"), resultSet.getInt("credit"),
						resultSet.getBoolean("administrateur")));
			}
			return utilisateurs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Utilisateur a) {

	}

    @Override
    public void insert(Utilisateur utilisateur) {
        try (Connection connection = ConnectionProvider.getConnection()) {
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
            statement.setInt(10, 100);
            statement.setBoolean(11, false);
            statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Utilisateur selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Utilisateur utilisateur, String pseudoC) {
		try(Connection connection = ConnectionProvider.getConnection()) {

			PreparedStatement statement = connection.prepareStatement(UPDATE_UTILISATEUR);
			statement.setString(1, utilisateur.getUsername());
			statement.setString(2, utilisateur.getLastname());
			statement.setString(3, utilisateur.getFirstname());
			statement.setString(4, utilisateur.getEmail());
			statement.setString(5, utilisateur.getPhoneNumber());
			statement.setString(6, utilisateur.getStreet());
			statement.setString(7, utilisateur.getZipCode());
			statement.setString(8, utilisateur.getTown());
			statement.setString(9, utilisateur.getPassword());
			statement.setInt(10, utilisateur.getCredit());
			statement.setBoolean(11, utilisateur.getAdministrator());
			statement.setString(12, pseudoC);

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = connection.prepareStatement(DELETE_BY_ID);
			pStmt.setInt(1, id);

			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

    @Override
    public Utilisateur selectByUsername(String pseudo) {
        try (Connection connection = ConnectionProvider.getConnection()) {
            PreparedStatement pStmt = connection.prepareStatement(SELECT_BY_USERNAME);
            pStmt.setString(1, pseudo);
            ResultSet rs = pStmt.executeQuery();
            if (!rs.isBeforeFirst()) {
                pStmt = connection.prepareStatement(SELECT_BY_EMAIL);
                pStmt.setString(1, pseudo);
                rs = pStmt.executeQuery();
            }

			if (rs.next())
				return new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"),
						rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
						rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"),
						rs.getInt("credit"), rs.getBoolean("administrateur"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void debiter(Utilisateur id, int credit) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(DEBITER_ACHETEUR);
			pStmt.setFloat(1, credit);
			pStmt.setInt(2, id.getNo_user());
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void crediter(Utilisateur id, int credit) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(CREDITER_VENDEUR);
			pStmt.setFloat(1, credit);
			pStmt.setInt(2, id.getNo_user());
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Utilisateur selectUsernameMo(int id) {
		try(Connection cnx = ConnectionProvider.getConnection()){

			List<Article_Vendu> articles = new ArrayList<>();
    		PreparedStatement pStmt = cnx.prepareStatement(SELECT_USERNAME_MO);
            pStmt.setInt(1,id);
            pStmt.setInt(2,id);
            ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				return new Utilisateur(rs.getString("pseudo"),
								articles
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
