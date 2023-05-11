package org.eni_encheres.dal;

import java.util.List;

import org.eni_encheres.bo.Article_Vendu;

public interface ArticleVenduDAO extends DAO<Article_Vendu>{
	
//	List<Article_Vendu> selectByKeyWordAndCategory(int noCategory,String key);
	
	List<Article_Vendu> selectAll();
	List<Article_Vendu> selectAllData();
	
	void insert(Article_Vendu article);

	List<Article_Vendu> selectAllByID(int id);

	Article_Vendu selectById(int id);

	void update(Article_Vendu article);

	void delete(int id);

//	List<Article_Vendu> selectByKewWord(String keyword);
	

}
