package org.eni_encheres.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.List;

import jakarta.servlet.http.HttpSession;
import org.eni_encheres.bll.Article_VenduManager;
import org.eni_encheres.bll.CategorieManager;
import org.eni_encheres.bll.EnchereManager;
import org.eni_encheres.bll.UtilisateurManager;

import org.eni_encheres.bll.SecurityService;
import org.eni_encheres.bll.exception.BLLException;
import org.eni_encheres.bo.Article_Vendu;
import org.eni_encheres.bo.Categorie;
import org.eni_encheres.bo.Enchere;
import org.eni_encheres.bo.Utilisateur;

@WebServlet("/encheres/detail/*")
public class DetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utilisateur utilisateurC = (Utilisateur) session.getAttribute("utilisateurC");
        request.setAttribute("utilisateurC", utilisateurC);

        String params = request.getPathInfo();
        int id = Integer.parseInt(params.substring(1));
        Article_Vendu article = Article_VenduManager.getInstance().getArticle(id);

        List<Article_Vendu> articlesData = Article_VenduManager.getInstance().getAllArticlesData();
        List<Utilisateur> utilisateursData = UtilisateurManager.getInstance().getAllUtilisateur();
        Utilisateur utilisateur = UtilisateurManager.getInstance().getUtilisateurMo(id);

        List<Enchere> encheres = EnchereManager.getInstance().getAllEnchere();

        int credit = EnchereManager.getInstance().getCredit(utilisateurC);



        // Créer une HashMap pour stocker l'article qui vas utiliser le No_article pour
        // ne plus avoir de doublon
        Map<Integer, Article_Vendu> maxAuctionMap = new HashMap<>();

        // Parcourir la liste des articles vendus
        for (Article_Vendu articleVendu : articlesData) {
            maxAuctionMap.put(articleVendu.getNo_article(), articleVendu);
        }

        // Créer une liste à partir des valeurs de la HashMap
        List<Article_Vendu> articleTotal = new ArrayList<>(maxAuctionMap.values());



        request.setAttribute("articleVendeur", article);

        article = maxAuctionMap.get(article.getNo_article());

        request.setAttribute("article", article);
        request.setAttribute("utilisateurData", utilisateursData);
        request.setAttribute("utilisateur", utilisateur);
        request.setAttribute("credit", credit);


        List<Categorie> categories = CategorieManager.getInstance().getAllCategorie();
        request.setAttribute("categories", categories);

        request.getRequestDispatcher("/WEB-INF/jsp/pages/detail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            Utilisateur utilisateurC = (Utilisateur) session.getAttribute("utilisateurC");
            //request.setAttribute("utilisateurC", utilisateurC);

            if (request.getParameter("deco") != null) {
                session.setAttribute("utilisateurC", null);
                SecurityService.getInstance().cookieCDelete(response);
                response.sendRedirect(request.getContextPath());
                return;
            }


            String params = request.getPathInfo();
            int id = Integer.parseInt(params.substring(1));
            Article_Vendu article = Article_VenduManager.getInstance().getArticle(id);

            int credit = Integer.valueOf(request.getParameter("proposition"));

            int meilleurOffre = 0;
            for (Enchere enchere : EnchereManager.getInstance().getAllEncherByIDArticle(id)) {
                if (enchere.getAuctionPrice() > meilleurOffre) {
                    meilleurOffre = enchere.getAuctionPrice();
                }
            }

            Enchere enchere = new Enchere(utilisateurC.getNo_user(),article.getNo_article(), LocalDate.now(),credit);
            EnchereManager.getInstance().addEnchere(enchere,utilisateurC);



            doGet(request, response);
       } catch (BLLException e) {
            request.setAttribute("erreurs", e.getErreurs());
            doGet(request, response);
        }

    }
}
