package org.eni_encheres.dal.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;
import org.eni_encheres.bo.Article_Vendu;
import org.eni_encheres.bo.Categorie;
import org.eni_encheres.bo.Enchere;
import org.eni_encheres.bo.Utilisateur;
import org.eni_encheres.dal.DAOFactory;
import org.eni_encheres.dal.EnchereDAO;
import org.eni_encheres.dal.UtilisateurDAO;
import org.eni_encheres.config.ConnectionProvider;

public class EnchereDAOImpl implements EnchereDAO {
	
	
	private final static String SELECT_ALL_CURRENT = "SELECT * "
												+ "FROM ARTICLES_VENDUS av "
												+ "INNER JOIN ENCHERES e "
												+ "ON av.no_article = e.no_article "
												+ "INNER JOIN UTILISATEURS u "
												+ "ON e.no_utilisateur = u.no_utilisateur "
												+ "INNER JOIN CATEGORIES c "
												+ "ON c.no_categorie = av.no_article "
												+ "WHERE etat_vente = ?;";
	
	@Override
	public List<Enchere> selectByKeyWord(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enchere> selectAll() {
		
		try(Connection connection = ConnectionProvider.getConnection()) {
			List<Enchere> encheres = new ArrayList<>();
			
			PreparedStatement stmt = connection.prepareStatement(SELECT_ALL_CURRENT);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				encheres.add(new Enchere(
						new Utilisateur(rs.getInt("no_utilisateur"),
								rs.getString("pseudo"),
								rs.getString("nom"),
								rs.getString("prenom"),
								rs.getString("email"),
								rs.getString("telephone"),
								rs.getString("rue"),
								rs.getString("code_postal"),
								rs.getString("ville"),
								rs.getString("mot_de_passe"),
								rs.getInt("credit"),
								rs.getBoolean("administrateur")),
						new Article_Vendu(rs.getInt("no_article"),
										  rs.getString("nom_article"),
										  rs.getString("description"),
										  rs.getDate("date_debut_enchere"),
										  rs.getDate("date_fin_enchere"),
										  rs.getInt("prix_initial"),
										  rs.getInt("prix_vente"),
										  rs.getInt("etat_vente"),
						new Categorie(rs.getInt("no_categorie"),
								  rs.getString("libelle"))),
						rs.getDate("date_enchere"),
						rs.getString("libelle")
						));
						
				
			}
			return encheres;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}

	@Override
	public void insert(Enchere enchere) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Enchere selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Enchere enchere) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
