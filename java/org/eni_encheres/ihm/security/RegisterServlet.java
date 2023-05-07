package org.eni_encheres.ihm.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.eni_encheres.bll.SecurityService;
import org.eni_encheres.bll.exception.BLLException;
import org.eni_encheres.bo.Utilisateur;

import java.io.IOException;

@WebServlet("/inscription")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/security/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String pseudo = request.getParameter("pseudo");
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String email = request.getParameter("email");
            String telephone = request.getParameter("telephone");
            String rue = request.getParameter("rue");
            String codePostal = request.getParameter("codePostal");
            String ville = request.getParameter("ville");
            String password = request.getParameter("password");
            String passwordConf = request.getParameter("passwordConf");

            Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, password, 100, false);

            SecurityService.getInstance().addUser(utilisateur, passwordConf);

            // Création session
            HttpSession session = request.getSession();
            session.setAttribute("utilisateurC", utilisateur);

            response.sendRedirect(request.getContextPath() + "/");
        } catch (BLLException e) {
            request.setAttribute("erreurs", e.getErreurs());
            doGet(request, response);
        }
    }
}
