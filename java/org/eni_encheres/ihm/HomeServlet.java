package org.eni_encheres.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
		
		List<Article_Vendu> articles = Article_VenduManager.getInstance().getAllArticles();
//
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
		
		
		request.setAttribute("articles", articles);
		request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
