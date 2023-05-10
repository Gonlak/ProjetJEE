package org.eni_encheres.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.eni_encheres.bll.SecurityService;
import org.eni_encheres.bll.exception.BLLException;
import org.eni_encheres.bo.Utilisateur;

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


@WebServlet(name = "home", urlPatterns = {"", "/encheres"})
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();

        String cookieC = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("ProjetJEE")) {
                    cookieC = cookie.getValue();
                    break;
                }
            }
        }

        try {
            if (cookieC != null) {
                String[] valeurs = cookieC.split(":");
                String cookieCID = valeurs[0];
                String cookieCPass = valeurs[1];

                Utilisateur utilisateurC = SecurityService.getInstance().cookieC(cookieCID, cookieCPass);
                session.setAttribute("utilisateurC", utilisateurC);
                request.setAttribute("utilisateurC", utilisateurC);
            } else {
                Utilisateur utilisateurC = (Utilisateur) session.getAttribute("utilisateurC");
                session.setAttribute("utilisateurC", utilisateurC);
                request.setAttribute("utilisateurC", utilisateurC);
            }
        } catch (BLLException e) {
            request.setAttribute("erreurs", e.getErreurs());
        }


        List<Article_Vendu> articlesData = Article_VenduManager.getInstance().getAllArticlesData();
        List<Article_Vendu> articles = Article_VenduManager.getInstance().getAllArticle();
        List<Categorie> categories = CategorieManager.getInstance().getAllCategorie();

        // Créer une liste à partir des valeurs de la HashMap
        List<Article_Vendu> articleTotal = getMaxAuction(articlesData);

        request.setAttribute("articlesData", articleTotal);
        request.setAttribute("articles", articles);
        request.setAttribute("Categories", categories);

        request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utilisateur utilisateurC = (Utilisateur) session.getAttribute("utilisateurC");
        request.setAttribute("utilisateurC", utilisateurC);

        if (request.getParameter("deco")!=null) {
            session.setAttribute("utilisateurC", null);
            SecurityService.getInstance().cookieCDelete(response);
            response.sendRedirect(request.getContextPath());
            return;
        }
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

        request.setAttribute("articlesData", articleTotal);
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
