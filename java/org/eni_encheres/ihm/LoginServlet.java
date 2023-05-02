package org.eni_encheres.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.eni_encheres.bo.Utilisateur;

import java.io.IOException;
import java.security.MessageDigest;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/login").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // récup data dans le login.jsp
            String pseudo = request.getParameter("pseudo");
            String password = request.getParameter("password");
            Utilisateur utilisateur = new Utilisateur(pseudo, password);

            // Création session
            HttpSession session = request.getSession();
            session.setAttribute("pseudo", pseudo);
            response.sendRedirect(request.getContextPath() + "/mon-compte");
        } catch (Exception e){
            e.getMessage();
        }
    }
}
