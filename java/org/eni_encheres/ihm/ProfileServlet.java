package org.eni_encheres.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eni_encheres.bll.UtilisateurManager;
import org.eni_encheres.bo.Utilisateur;
import org.eni_encheres.dal.DAOFactory;

import java.io.IOException;

@WebServlet("/profil/*")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String params = request.getPathInfo();
		String pseudo = params.substring(1);
		Utilisateur utilisateur = DAOFactory.getUtilisateurDAO().selectByUsername(pseudo);
		request.setAttribute("utilisateur",utilisateur);
		request.getRequestDispatcher("/WEB-INF/jsp/pages/profile.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
