package org.eni_encheres.dal.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eni_encheres.bo.Enchere;
import org.eni_encheres.bo.Utilisateur;
import org.eni_encheres.config.ConnectionProvider;
import org.eni_encheres.dal.EnchereDAO;


public class EnchereDAOImpl implements EnchereDAO {

	private final static String SELECT_ALL_ENCHERES = " SELECT * FROM ENCHERES";
	
	@Override
	public List<Enchere> selectByKeyWord(String key) {
		return null;
	}

	@Override
	public List<Enchere> selectAll() {
		try (Connection connection = ConnectionProvider.getConnection()) {
			List<Enchere> encheres = new ArrayList<>();

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(SELECT_ALL_ENCHERES);
			while(rs.next()) {
				encheres.add(new Enchere(rs.getInt("no_utilisateur"), rs.getInt("no_article"), rs.getDate("date_enchere"), rs.getInt("montant_enchere")));
			}
			return encheres;
		} catch (SQLException e) {
			e.printStackTrace();
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
