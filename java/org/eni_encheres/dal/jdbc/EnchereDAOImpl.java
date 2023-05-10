package org.eni_encheres.dal.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eni_encheres.bo.Article_Vendu;
import org.eni_encheres.bo.Enchere;
import org.eni_encheres.bo.Utilisateur;
import org.eni_encheres.config.ConnectionProvider;
import org.eni_encheres.dal.EnchereDAO;


public class EnchereDAOImpl implements EnchereDAO {
	
	private static final String SELECT_ALL_AUCTIONS = "SELECT * FROM encheres;";
	
	
	
	@Override
	public List<Enchere> selectByKeyWord(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enchere> selectAll() {
		
		try (Connection connection = ConnectionProvider.getConnection()) {
            List<Enchere> encheres = new ArrayList<>();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_AUCTIONS);

            while (resultSet.next()) {
                encheres.add(new Enchere(resultSet.getInt("no_utilisateur"),
            							resultSet.getInt("no_article"),
            							resultSet.getDate("date_enchere"),
            							resultSet.getInt("montant_enchere")));
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
