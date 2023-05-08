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
        verifAddArticle(article_vendu);
        DAOFactory.getArticleVenduDAO().insert(article_vendu);
    }

    private void verifAddArticle(Article_Vendu article_vendu) throws BLLException {
        BLLException bll = new BLLException("Utilisateur non trouvé!");

        checkFiled(article_vendu.getArticleName(), "Article", bll);
        checkFiled(article_vendu.getDescription(), "Description", bll);
        checkFiled(String.valueOf(article_vendu.getCategories()), "Catégorie", bll);
        checkFiled(String.valueOf(article_vendu.getOriginal_price()), "Mise à prix", bll);
        checkFiled(String.valueOf(article_vendu.getStart_auction_date()), "Début de l'enchère", bll);
        checkFiled(String.valueOf(article_vendu.getEnd_auction_date()), "Fin de l'enchère", bll);
        checkFiled(article_vendu.getUser().getStreet(), "Rue", bll);
        checkFiled(article_vendu.getUser().getStreet(), "Code Postal", bll);
        checkFiled(article_vendu.getUser().getStreet(), "Ville", bll);

        messageError(bll);
    }

    private void checkFiled(String field, String name, BLLException bll) {
        if (field.isBlank()) {
            bll.ajouterErreur("Le champs " + name + " ne peut pas etre vide!");
        }
    }

    private void messageError(BLLException bll) throws BLLException {
        if (bll.getErreurs().size() > 0) {
            throw bll;
        }
    }
}
