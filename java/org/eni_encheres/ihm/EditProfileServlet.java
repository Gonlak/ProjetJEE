package org.eni_encheres.ihm;

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

@WebServlet("/modification")
public class EditProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utilisateur utilisateurC = (Utilisateur) session.getAttribute("utilisateurC");
        request.setAttribute("utilisateurC", utilisateurC);

        request.getRequestDispatcher("/WEB-INF/jsp/pages/editProfile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            Utilisateur utilisateurC = (Utilisateur) session.getAttribute("utilisateurC");
            String pseudoC = utilisateurC.getUsername();

            String pseudo = request.getParameter("pseudo");
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String email = request.getParameter("email");
            String telephone = request.getParameter("telephone");
            String rue = request.getParameter("rue");
            String codePostal = request.getParameter("codePostal");
            String ville = request.getParameter("ville");
            String password = request.getParameter("password");
            String passwordModif = request.getParameter("passwordModif");
            String mdpConf = request.getParameter("passwordConf");

            Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, password, utilisateurC.getCredit(), utilisateurC.getAdministrator());


            SecurityService.getInstance().editUser(utilisateur, pseudoC, password, passwordModif, mdpConf);

            session.setAttribute("utilisateurC", utilisateur);

            response.sendRedirect(request.getContextPath() + "/connection");
        } catch (BLLException e) {
            request.setAttribute("erreurs", e.getErreurs());
            doGet(request, response);
        }
    }
}
