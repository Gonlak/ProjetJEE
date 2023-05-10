package org.eni_encheres.dal.jdbc;

import java.sql.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import org.eni_encheres.bo.Categorie;
import org.eni_encheres.config.ConnectionProvider;
import org.eni_encheres.dal.CategorieDAO;

import org.eni_encheres.config.ConnectionProvider;

public class CategorieDAOImpl implements CategorieDAO{

	private final static String SELECT_ALL_CATEGORIE = "SELECT * FROM CATEGORIES;";
	private final static String SELECT_BY_ID_CATEGORIE = "SELECT * FROM CATEGORIES WHERE no_categorie = ?;";

	private final static String SELECT_ALL_CATEGORIES = "SELECT * FROM CATEGORIES;";

	@Override
	public List<Categorie> selectByKeyWord(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categorie> selectAll() {

		try (Connection connection = ConnectionProvider.getConnection()) {
			List<Categorie> categories = new ArrayList<>();

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_ALL_CATEGORIE);

			while (resultSet.next()){
				categories.add(new Categorie(resultSet.getInt("no_categorie"),
						resultSet.getString("libelle")));
			}
			return categories;

		} catch (SQLException e) {
			e.printStackTrace();
		}

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
		try (Connection connection = ConnectionProvider.getConnection()) {

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_CATEGORIE);
			preparedStatement.setInt(1,id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()){
				return new Categorie(resultSet.getInt("no_categorie"),resultSet.getString("libelle"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
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
