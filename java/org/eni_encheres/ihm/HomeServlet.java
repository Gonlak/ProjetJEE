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
import org.eni_encheres.bo.Article_Vendu;
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
                request.setAttribute("utilisateurC", utilisateurC);

            } else {
                Utilisateur utilisateurC = (Utilisateur) session.getAttribute("utilisateurC");
                request.setAttribute("utilisateurC", utilisateurC);
            }
        } catch (BLLException e) {
            request.setAttribute("erreurs", e.getErreurs());
        }


        List<Article_Vendu> articlesData = Article_VenduManager.getInstance().getAllArticlesData();
        List<Article_Vendu> articles = Article_VenduManager.getInstance().getAllArticle();

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

        request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("utilisateurC", null);
        SecurityService.getInstance().cookieCDelete(response);
        doGet(request, response);
    }
}
