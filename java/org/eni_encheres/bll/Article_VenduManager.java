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

    // get all articles
    public List<Article_Vendu> getAllArticles(){
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

}
