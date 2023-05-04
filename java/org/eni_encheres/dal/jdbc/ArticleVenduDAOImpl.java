package org.eni_encheres.dal.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eni_encheres.bo.Article_Vendu;
import org.eni_encheres.config.ConnectionProvider;
import org.eni_encheres.dal.ArticleVenduDAO;

public class ArticleVenduDAOImpl implements ArticleVenduDAO{

	private final static String SELECT_ALL = "SELECT * FROM ARTICLES_VENDUS;";
	
	@Override
	public List<Article_Vendu> selectByKeyWord(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article_Vendu> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Article_Vendu article) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Article_Vendu selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Article_Vendu article) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
