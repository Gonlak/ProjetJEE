package org.eni_encheres.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.eni_encheres.bll.SecurityService;
import org.eni_encheres.bll.exception.BLLException;
import org.eni_encheres.bo.Utilisateur;

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eni_encheres.bll.Article_VenduManager;
import org.eni_encheres.bll.CategorieManager;
import org.eni_encheres.bll.EnchereManager;
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
        Utilisateur utilisateurC = (Utilisateur) session.getAttribute("utilisateurC");
        request.setAttribute("utilisateurC", utilisateurC);
        // Récupérer la valeur du bouton radio sélectionné
	     String selection = request.getParameter("selection");
	     String enchereOuverte = request.getParameter("enchereOuverte");
//         String enchereEnCours = request.getParameter("enchereEnCours");
//         String enchereRemportee = request.getParameter("enchereRemportee");
	     
        if (request.getParameter("deco")!=null) {
            session.setAttribute("utilisateurC", null);
            SecurityService.getInstance().cookieCDelete(response);
            response.sendRedirect(request.getContextPath());
            return;
        }
        
        List<Categorie> categories = CategorieManager.getInstance().getAllCategorie();
        List<Article_Vendu> articlesData = Article_VenduManager.getInstance().getAllArticlesData();
        List<Enchere> encheres = EnchereManager.getInstance().getAllEnchere();
        List<Article_Vendu> allArticles = Article_VenduManager.getInstance().getAllArticle();
         
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
        
//	   //Filtre les articles en fonction des checkboxes
//	  // Vérifie si le bouton radio "Achats" est sélectionné
//	     if ("achats".equals(selection)) {
//	    	 if (enchereOuverte != null) {
//	    		 System.out.println(enchereOuverte);
//	    		
//	         	}
//	    	 
//	    	 if (enchereEnCours != null) {
//	        	 System.out.println(enchereEnCours);
//	        	// Effectue le traitement pour les enchères en cours
//	             // Récupére l'utilisateur connecté
//	             session = request.getSession();
//	             utilisateurC = (Utilisateur) session.getAttribute("utilisateurC");
//
//	             // Filtrer les articles en cours pour l'utilisateur connecté
//	             List<Article_Vendu> enchereEnCoursArticles = new ArrayList<>();
////	             for (Article_Vendu article : articlesData) {
////	            	 System.out.println("c bon");
////	            	 System.out.println(article.getArticleName());
////	            	 System.out.println(article.getUser().getNo_user()+" "+utilisateurC.getNo_user());
////	            	 
////					}
//	             for (Article_Vendu article : allArticles) {
//            		 System.out.println(article.getUser().getNo_user());
//            		 for (Enchere enchere : encheres) {
//						if (enchere.getUser() == article.getUser().getNo_user()) {
//							System.out.println(enchere.getUser()+" "+article.getUser().getNo_user());
//							enchereEnCoursArticles.add(article);
//						}
//					}
//	             }
//
//	             articles = enchereEnCoursArticles;
//				}
//	         
//	         if (enchereRemportee != null) {
//	        	 System.out.println(enchereRemportee);	
//				}
//	      // Vérifie si le bouton radio "Ventes" est sélectionné   
//	     }else if ("ventes".equals(selection)) {
//         // Récupérer les valeurs des cases à cocher pour les ventes
//	         String venteEnCours = request.getParameter("venteEnCours");
//	         String venteNonDebutee = request.getParameter("venteNonDebutee");
//	         String venteTerminee = request.getParameter("venteTerminee");
//	         
//	         if (venteEnCours != null) {
//	        	 System.out.println(venteEnCours);	
//				}
//	        
//	         if (venteNonDebutee != null) {
//	        	 System.out.println(venteNonDebutee);	
//				}
//	         
//	         if (venteTerminee != null) {
//	        	 System.out.println(venteTerminee);	
//				}
//	     }
	     
	     
	    request.setAttribute(selection, articles); 
	    request.setAttribute("enchereOuverte", enchereOuverte); 
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
