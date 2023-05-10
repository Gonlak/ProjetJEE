package org.eni_encheres.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

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

import org.eni_encheres.bo.Article_Vendu;
import org.eni_encheres.bo.Categorie;
import org.eni_encheres.bo.Enchere;
import org.eni_encheres.bo.Utilisateur;

@WebServlet("/encheres/detail/*")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String params = request.getPathInfo();
		int id = Integer.parseInt(params.substring(1));
		Article_Vendu article = Article_VenduManager.getInstance().getArticle(id);
		System.out.println(article);

		List<Article_Vendu> articlesData = Article_VenduManager.getInstance().getAllArticlesData();
		List<Utilisateur> utilisateursData = UtilisateurManager.getInstance().getAllUtilisateur();
		Utilisateur utilisateur = UtilisateurManager.getInstance().getUtilisateurMo(id);
		System.out.println(utilisateur);
		List<Enchere> encheres = EnchereManager.getInstance().getAllEnchere();

		// Créer une HashMap pour stocker l'article qui vas utiliser le No_article pour
		// ne plus avoir de doublon
		Map<Integer, Article_Vendu> maxAuctionMap = new HashMap<>();

		// Parcourir la liste des articles vendus
		for (Article_Vendu articleVendu : articlesData) {
			maxAuctionMap.put(articleVendu.getNo_article(), articleVendu);
		}

		// Créer une liste à partir des valeurs de la HashMap
		List<Article_Vendu> articleTotal = new ArrayList<>(maxAuctionMap.values());

		article = maxAuctionMap.get(article.getNo_article());

		request.setAttribute("article", article);
		request.setAttribute("utilisateurData", utilisateursData);
		request.setAttribute("utilisateur", utilisateur);
		request.setAttribute("encheres", encheres);

		List<Categorie> categories = CategorieManager.getInstance().getAllCategorie();
		request.setAttribute("categories", categories);

		request.getRequestDispatcher("/WEB-INF/jsp/pages/detail.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("utilisateurC", null);
		response.sendRedirect(request.getContextPath());

		/*
		 * try { int credit = Integer.valueOf(request.getParameter("proposition")); int
		 * meilleurOffre = Integer.valueOf(request.getParameter("meilleurOffre"));
		 * Utilisateur utilisateur = new Utilisateur(); utilisateur.setNo_user(credit);
		 * 
		 * UtilisateurManager.getInstance().crediterUtilisateur(utilisateur, credit);
		 * 
		 * if(credit > meilleurOffre) {
		 * UtilisateurManager.getInstance().debiterUtilisateur(utilisateur, credit); }
		 * System.err.println("Votre crédit est insuffisant pour faire une offre"); }
		 * catch (Exception e) { e.printStackTrace(); doGet(request, response); }
		 */
	}
}
