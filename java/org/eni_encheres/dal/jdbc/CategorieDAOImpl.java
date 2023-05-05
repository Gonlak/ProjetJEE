package org.eni_encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.eni_encheres.bo.Categorie;
import org.eni_encheres.dal.CategorieDAO;

import org.eni_encheres.config.ConnectionProvider;

public class CategorieDAOImpl implements CategorieDAO{

	private final static String SELECT_ALL_CATEGORIES = "SELECT * FROM CATEGORIES;";
	@Override
	public List<Categorie> selectByKeyWord(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categorie> selectAll() {
		List<Categorie> categories = new ArrayList<>();
		
		try(Connection connection = ConnectionProvider.getConnection()){
			
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_CATEGORIES);
			while(rs.next()) {
				categories.add( new Categorie(rs.getInt("no_categorie"),
											  rs.getString("libelle")
							));
			}
			return categories;
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

	@Override
	public void insert(Categorie categorie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Categorie selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Categorie categorie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
