package org.eni_encheres.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.eni_encheres.bo.Utilisateur;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eni_encheres.bll.Article_VenduManager;
import org.eni_encheres.bo.Article_Vendu;
import org.eni_encheres.bo.Enchere;


@WebServlet("")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Utilisateur utilisateurC = (Utilisateur) session.getAttribute("utilisateurC");
        request.setAttribute("utilisateurC", utilisateurC);


        List<Article_Vendu> articlesData = Article_VenduManager.getInstance().getAllArticlesData();
        List<Article_Vendu> articles = Article_VenduManager.getInstance().getAllArticle();

//		for (Article_Vendu article : articles) {
//		    List<Enchere> encheres = article.getEncheres();
//		    if (!encheres.isEmpty()) {
//		        int maxAuctionPrice = Collections.max(encheres, Comparator.comparing(Enchere::getAuctionPrice)).getAuctionPrice();
//		        for (Enchere enchere : encheres) {
//		            if (enchere.getAuctionPrice() == maxAuctionPrice) {
//		                enchere.setAuctionPrice(maxAuctionPrice);
//		            }
//		        }
//		    }
//		}

        // Créer une HashMap pour stocker l'article qui vas utiliser le No_article pour ne plus avoir de doublon
        Map<Integer, Article_Vendu> highestAuctionPriceMap = new HashMap<>();

        // Parcourir la liste des articles vendus
        for (Article_Vendu articleVendu : articlesData) {
            highestAuctionPriceMap.put(articleVendu.getNo_article(), articleVendu);
        }

        // Créer une liste à partir des valeurs de la HashMap
        List<Article_Vendu> articleTotal = new ArrayList<>(highestAuctionPriceMap.values());

        request.setAttribute("articlesData", articleTotal);
        request.setAttribute("articles", articles);

        request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("utilisateurC", null);

        doGet(request, response);
    }
}
