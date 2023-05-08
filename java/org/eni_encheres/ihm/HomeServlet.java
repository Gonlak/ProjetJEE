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
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eni_encheres.bll.Article_VenduManager;
import org.eni_encheres.bll.CategorieManager;
import org.eni_encheres.bo.Article_Vendu;
import org.eni_encheres.bo.Categorie;
import org.eni_encheres.bo.Enchere;


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

        // Créer une HashMap pour stocker l'article qui vas utiliser le No_article pour ne plus avoir de doublon
        Map<Integer, Article_Vendu> maxAuctionMap = new HashMap<>();

        // Parcourir la liste des articles vendus
        for (Article_Vendu articleVendu : articlesData) {
        	maxAuctionMap.put(articleVendu.getNo_article(), articleVendu);
        }

        // Créer une liste à partir des valeurs de la HashMap
        List<Article_Vendu> articleTotal = new ArrayList<>(maxAuctionMap.values());

        request.setAttribute("articlesData", articleTotal);
        request.setAttribute("articles", articles);
        request.setAttribute("Categories", categories);

        request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("utilisateurC", null);
        
        int categorieId = Integer.parseInt(request.getParameter("categorieId"));
        List<Article_Vendu> articles = getArticles(categorieId);
        request.setAttribute("articles", articles);
        request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);

        doGet(request, response);
    }

	private List<Article_Vendu> getArticles(int categorieId) {
		List<Article_Vendu> articlesByCategorie = CategorieManager.getInstance().getArticlesByCategorieId(categorieId);
		return articlesByCategorie;
	}
}
