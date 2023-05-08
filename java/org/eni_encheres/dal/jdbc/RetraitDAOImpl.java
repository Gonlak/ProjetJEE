package org.eni_encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.eni_encheres.bo.Retrait;
import org.eni_encheres.config.ConnectionProvider;
import org.eni_encheres.dal.RetraitDAO;

public class RetraitDAOImpl implements RetraitDAO{

	private final static String INSERT_RETRAIT = "INSERT INTO RETRAITS (no_article, rue, code_postal, ville) VALUES (?,?,?,?);";

	@Override
	public List<Retrait> selectByKeyWord(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Retrait> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Retrait retrait) {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(INSERT_RETRAIT);
			statement.setInt(1,retrait.getArticle().getNo_article());
			statement.setString(2,retrait.getRue());
			statement.setString(3,retrait.getZipCode());
			statement.setString(4,retrait.getTown());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Retrait selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Retrait retrait) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
