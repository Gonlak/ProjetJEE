package org.eni_encheres.bll;

import org.eni_encheres.bll.exception.BLLException;
import org.eni_encheres.bo.Article_Vendu;
import org.eni_encheres.dal.DAOFactory;

import java.util.List;

public class Article_VenduManager {
    // Singleton
    //1
    private static Article_VenduManager instance;
    //2
    private Article_VenduManager(){}
    //3
    public static Article_VenduManager getInstance(){
        if (instance == null){
            instance = new Article_VenduManager();
        }
        return instance;
    }

    // get all articles Data
    public List<Article_Vendu> getAllArticlesData(){
        return DAOFactory.getArticleVenduDAO().selectAllData();
    }

    // get all articles Data
    public List<Article_Vendu> getAllArticle(){
        return DAOFactory.getArticleVenduDAO().selectAll();
    }

    // recup un article
    public Article_Vendu getArticle(int id){
        return DAOFactory.getArticleVenduDAO().selectById(id);
    }

    // ajoute un article
    public void addArticle(Article_Vendu article_vendu) throws BLLException {
        // check all fields
        // verifAddArticle(article_vendu);
        DAOFactory.getArticleVenduDAO().insert(article_vendu);
    }
    
    //recup un article selon la categorie
//    public List<Article_Vendu> getAllArticlesByCategorieAndKeyword(int no_category, String keyWord){
//    	if (no_category>0) {
//    		return DAOFactory.getArticleVenduDAO().selectByKeyWordAndCategory(no_category, keyWord);
//		}else if (no_category == -1) {
//			return DAOFactory.getArticleVenduDAO().selectByKewWord(keyWord);
//		}
//        return DAOFactory.getArticleVenduDAO().selectAll();
//    }
//    
//    public List<Article_Vendu> getAllArticleByKeyword(String keyword){
//    	
//    	return DAOFactory.getArticleVenduDAO().selectByKewWord(keyword);
//    }
    
}
