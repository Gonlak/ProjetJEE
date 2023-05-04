package org.eni_encheres.dal.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.eni_encheres.bo.Enchere;
import org.eni_encheres.dal.DAOFactory;
import org.eni_encheres.dal.EnchereDAO;
import org.eni_encheres.dal.UtilisateurDAO;
import org.eni_encheres.config.ConnectionProvider;

public class EnchereDAOImpl implements EnchereDAO {
	
	
	private final static String SELECT_ALL = "SELECT u.no_utilisateur,nom_article,date_fin_encheres,montant_enchere,pseudo "
												+ "FROM ARTICLES_VENDUS av "
												+ "INNER JOIN ENCHERES e "
												+ "ON av.no_article = e.no_article "
												+ "INNER JOIN UTILISATEURS u "
												+ "ON e.no_utilisateur = u.no_utilisateur "
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
			
			PreparedStatement stmt = connection.prepareStatement(SELECT_ALL);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				
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
