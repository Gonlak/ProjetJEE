package org.eni_encheres.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import jakarta.servlet.http.HttpSession;
import org.eni_encheres.bll.Article_VenduManager;
import org.eni_encheres.bll.EnchereManager;
import org.eni_encheres.bll.SecurityService;
import org.eni_encheres.bo.Article_Vendu;
import org.eni_encheres.bo.Enchere;


@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/pages/detail.jsp")
		.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("utilisateurC", null);
		SecurityService.getInstance().cookieCDelete(response);
		response.sendRedirect(request.getContextPath());
	}
}
