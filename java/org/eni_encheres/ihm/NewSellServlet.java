package org.eni_encheres.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.eni_encheres.bll.Article_VenduManager;
import org.eni_encheres.bll.CategorieManager;
import org.eni_encheres.bll.RetraitManager;
import org.eni_encheres.bll.exception.BLLException;
import org.eni_encheres.bo.Article_Vendu;
import org.eni_encheres.bo.Categorie;
import org.eni_encheres.bo.Retrait;
import org.eni_encheres.bo.Utilisateur;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/nouvelle-vente")
public class NewSellServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utilisateur utilisateurC = (Utilisateur) session.getAttribute("utilisateurC");
        request.setAttribute("utilisateurC", utilisateurC);

        List<Categorie> categories = CategorieManager.getInstance().getAllCategorie();
        request.setAttribute("Categories", categories);


        request.getRequestDispatcher("/WEB-INF/jsp/pages/new_sell.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            Utilisateur utilisateurC = (Utilisateur) session.getAttribute("utilisateurC");

            List<Categorie> categories = CategorieManager.getInstance().getAllCategorie();

            if (request.getParameter("deco")!=null) {
                session.setAttribute("utilisateurC", null);
                response.sendRedirect(request.getContextPath());
                return;
            }

            String article = request.getParameter("article");
            String description = request.getParameter("description");
            String categoriePara = request.getParameter("categorie");
            String photo = request.getParameter("photo");
            int miseaprix = Integer.parseInt(request.getParameter("miseaprix"));
            String debutenchere = request.getParameter("debutenchere");
            String finenchere = request.getParameter("finenchere");
            String street = request.getParameter("street");
            String zipcode = request.getParameter("zipcode");
            String town = request.getParameter("town");

            System.out.println(categoriePara);

            for (Categorie categorie: categories){
                if (categorie.getLibelle().equals(categoriePara)){

                    Article_Vendu article_vendu = new Article_Vendu(article, description, Date.valueOf(debutenchere), Date.valueOf(finenchere), miseaprix, 0, 1, utilisateurC, categorie);
                    Article_VenduManager.getInstance().addArticle(article_vendu);

                    if (article_vendu.getNo_article() > 0) {
                        Retrait retrait = new Retrait(article_vendu, street, zipcode, town);
                        RetraitManager.getInstance().addRetrait(retrait);
                    }
                }
            }

        } catch (BLLException e) {
            request.setAttribute("erreurs", e.getErreurs());
            doGet(request, response);
        }

        response.sendRedirect(request.getContextPath());
    }
}
