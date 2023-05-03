package org.eni_encheres.bll;

import org.eni_encheres.bll.exception.BLLException;
import org.eni_encheres.bo.Article_Vendu;

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
        //return DaoFactory.getArticleDao().selectAll();
        // Seb a remplasser le return null par celui de haut dessus
        return null;
    }

    // recup un article
    public Article_Vendu getArticle(int id){
        //return DaoFactory.getArticleDao().selectOne(id);
        // Seb a remplasser le return null par celui de haut dessus
        return null;
    }

    // ajoute un article
    public void addArticle(Article_Vendu article_vendu) throws BLLException {
        // check all fields
        // verifAddArticle(article_vendu);
        //DaoFactory.getArticleDao().insert(article_vendu);
    }

}
