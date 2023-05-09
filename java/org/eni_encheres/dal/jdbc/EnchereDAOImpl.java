package org.eni_encheres.dal.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.eni_encheres.bo.Enchere;
import org.eni_encheres.dal.EnchereDAO;


public class EnchereDAOImpl implements EnchereDAO {
	
	private final static String UPDATE_ENCHERE = " UPDATE UTILISATEUR u, ENCHERES e "
											   + " INNER JOIN UTILISATEUR ON u.no_utilisateur = e.no_utilisateur "
											   + " SET credit = credit - ? "
											   + "     montant_enchere = montant_enchere + ? "
											   + " WHERE no_article = ?;";
	
	
	@Override
	public List<Enchere> selectByKeyWord(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enchere> selectAll() {
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
