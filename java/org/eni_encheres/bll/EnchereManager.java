package org.eni_encheres.bll;

import org.eni_encheres.bll.exception.BLLException;
import org.eni_encheres.bo.Article_Vendu;
import org.eni_encheres.bo.Enchere;
import org.eni_encheres.bo.Utilisateur;
import org.eni_encheres.dal.DAOFactory;

import java.util.List;

public class EnchereManager {
    // Singleton
    //1
    private static EnchereManager instance;

    //2
    private EnchereManager() {
    }

    //3
    public static EnchereManager getInstance() {
        if (instance == null) {
            instance = new EnchereManager();
        }
        return instance;
    }

    // get all enchere
    public List<Enchere> getAllEnchere() {
        return DAOFactory.getEnchereDAO().selectAll();
    }

    // recup un enchere
    public Enchere getEnchere(int id) {
        return DAOFactory.getEnchereDAO().selectById(id);
    }

    // ajoute un enchere
    public void addEnchere(Enchere enchere, Utilisateur utilisateurC) throws BLLException {
        BLLException bll = new BLLException("Ajout enchère Impossible");
        List<Article_Vendu> article_vendus = Article_VenduManager.getInstance().getAllArticle();

        int totalCredit = verifCredit(article_vendus, utilisateurC);
        totalCredit = totalCredit - enchere.getAuctionPrice();
        System.out.println(totalCredit);
        if (totalCredit < 0) {
            bll.ajouterErreur("Il vous manque " + totalCredit + " crédit");
            messageError(bll);
        }

        DAOFactory.getEnchereDAO().insert(enchere);
    }

    public int getCredit(Utilisateur utilisateurC){
        List<Article_Vendu> article_vendus = Article_VenduManager.getInstance().getAllArticle();
        int totalCredit = verifCredit(article_vendus, utilisateurC);
        return totalCredit;
    }

    private int verifCredit(List<Article_Vendu> article_vendus, Utilisateur utilisateurC) {
        int totalCredit = 0;
        for (Article_Vendu articleVendu : article_vendus) {
            int meilleurOffre = 0;
            int idUtilisateur = -1;
            for (Enchere enchere : EnchereManager.getInstance().getAllEncherByIDArticle(articleVendu.getNo_article())) {
                if (enchere.getAuctionPrice() > meilleurOffre) {
                    meilleurOffre = enchere.getAuctionPrice();
                    idUtilisateur = enchere.getNoUtilisateur();
                }
            }
            if (idUtilisateur == utilisateurC.getNo_user()) {
                totalCredit = totalCredit + meilleurOffre;
            }
        }
        return utilisateurC.getCredit() - totalCredit;
    }

    //récupe tout les encher d'un article
    public List<Enchere> getAllEncherByIDArticle(int id) {
        return DAOFactory.getEnchereDAO().selectAllByIdArticle(id);
    }


    private void messageError(BLLException bll) throws BLLException {
        if (bll.getErreurs().size() > 0) {
            throw bll;
        }
    }

}
