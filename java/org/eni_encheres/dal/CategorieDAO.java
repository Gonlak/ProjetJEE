package org.eni_encheres.dal;

import java.util.List;

import org.eni_encheres.bll.Article_VenduManager;
import org.eni_encheres.bo.Article_Vendu;
import org.eni_encheres.bo.Categorie;


public interface CategorieDAO extends DAO<Categorie>{
	
	List<Categorie> selectByKeyWord(String key);
	
	List<Categorie> selectAll();
	
	void insert(Categorie categorie);

	Categorie selectById(int id);

	void update(Categorie categorie);

	void delete(int id);
	
	List<Article_Vendu> getArticlesByCategorieId(int id);
}
