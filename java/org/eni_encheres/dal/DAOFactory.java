package org.eni_encheres.dal;

import org.eni_encheres.dal.jdbc.*;

public class DAOFactory {

	public static ArticleVenduDAO getArticleVenduDAO() {
		return new ArticleVenduDAOImpl();
	}
	
	public static CategorieDAO getCategorieDAO() {
		return new CategorieDAOImpl();
	}
	
	public static EnchereDAO getEnchereDAO() {
		return new EnchereDAOImpl();
	}
	
	public static RetraitDAO getRetraitDAO() {
		return new RetraitDAOImpl();
	}
	
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOImpl();
	}
	
}
