package org.eni_encheres.dal;

import java.util.List;

import org.eni_encheres.bo.Enchere;



public interface EnchereDAO extends DAO<Enchere> {
	
	List<Enchere> selectByKeyWord(String key);
	
	List<Enchere> selectAll();
	
	void insert(Enchere enchere);

	Enchere selectById(int id);

	void update(Enchere enchere);

	void delete(int id);
	
	
}
