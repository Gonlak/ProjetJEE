package org.eni_encheres.dal;

import java.util.List;


import org.eni_encheres.bo.Retrait;

public interface RetraitDAO extends DAO<Retrait>{
	
	List<Retrait> selectByKeyWord(String key);
	
	List<Retrait> selectAll();
	
	void insert(Retrait retrait);

	Retrait selectById(int id);

	void update(Retrait retrait);

	void delete(int id);
}
