package org.eni_encheres.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.eni_encheres.bo.Utilisateur;
import org.eni_encheres.dal.DAOFactory;

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eni_encheres.bll.Article_VenduManager;
import org.eni_encheres.bll.CategorieManager;
import org.eni_encheres.bo.Article_Vendu;
import org.eni_encheres.bo.Categorie;




/**
 * @author dfonsat2021
 *
 */
@WebServlet(name = "home", urlPatterns = {"","/encheres"})
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Utilisateur utilisateurC = (Utilisateur) session.getAttribute("utilisateurC");
        request.setAttribute("utilisateurC", utilisateurC);


        List<Article_Vendu> articlesData = Article_VenduManager.getInstance().getAllArticlesData();
        List<Article_Vendu> articles = Article_VenduManager.getInstance().getAllArticle();
        List<Categorie> categories = CategorieManager.getInstance().getAllCategorie();

        // Créer une liste à partir des valeurs de la HashMap
        List<Article_Vendu> articleTotal = getMaxAuction(articlesData);
        
        articles = articleTotal;
        
        request.setAttribute("articles", articles);
        request.setAttribute("Categories", categories);

        request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("utilisateurC", null);
        List<Categorie> categories = CategorieManager.getInstance().getAllCategorie();
        List<Article_Vendu> articlesData = Article_VenduManager.getInstance().getAllArticlesData();
        
     // Créer une HashMap pour stocker l'article qui vas utiliser le No_article pour ne plus avoir de doublon
        List<Article_Vendu> articleTotal = getMaxAuction(articlesData);

        //on récupère le no de categorie
        int categorieId = Integer.parseInt(request.getParameter("categorieId"));
      //on récupère le mot de recherche
        String keyWord = request.getParameter("keyword");

     // Filtre les articles en fonction de la catégorie et du mot clé
	     List<Article_Vendu> articles = new ArrayList<>();
	     if (categorieId == -1 && keyWord.isEmpty()) {
     // Affiche tous les articles si aucune catégorie ni mot clé n'est spécifié
	         articles.addAll(articleTotal);
	     } else {
	         for (Article_Vendu article : articleTotal) {
	             if ((categorieId == -1 || article.getCategories().getNo_categorie() == categorieId)
	                     && (keyWord.isEmpty() || article.getArticleName().toLowerCase().contains(keyWord.toLowerCase()))) {
	                 articles.add(article);
	             }
	         }
	     }
        
        request.setAttribute("articles", articles);
        request.setAttribute("Categories", categories);
        request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
    }

    
    //on récuperes les enchères max selon les articles
	private List<Article_Vendu> getMaxAuction(List<Article_Vendu> articlesData) {
		// Créer une HashMap pour stocker l'article qui vas utiliser le No_article pour ne plus avoir de doublon
		Map<Integer, Article_Vendu> maxAuctionMap = new HashMap<>();

		// Parcourir la liste des articles vendus
        for (Article_Vendu articleVendu : articlesData) {
        	maxAuctionMap.put(articleVendu.getNo_article(), articleVendu);
        }

        
        List<Article_Vendu> articleTotal = new ArrayList<>(maxAuctionMap.values());
		return articleTotal;
	}

}
