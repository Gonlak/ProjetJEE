package org.eni_encheres.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.eni_encheres.bll.SecurityService;
import org.eni_encheres.bll.UtilisateurManager;
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

            if (request.getParameter("deco").equals("true")){
                session.setAttribute("utilisateurC", null);
                SecurityService.getInstance().cookieCDelete(response);
                response.sendRedirect(request.getContextPath());
                return;
            }
            // button enregistrer
            if(request.getParameter("btn").equals("1")){
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

                session.setAttribute("utilisateurC", utilisateur);

                SecurityService.getInstance().editUser(utilisateur, passwordModif, mdpConf, utilisateurC);

                //button supp
            }else if(request.getParameter("btn").equals("2")) {
                SecurityService.getInstance().deleteUser(utilisateurC);
                session.setAttribute("utilisateurC", null);
            }

            response.sendRedirect(request.getContextPath());
        } catch (BLLException e) {
            request.setAttribute("erreurs", e.getErreurs());
            doGet(request, response);
        }
    }
}
