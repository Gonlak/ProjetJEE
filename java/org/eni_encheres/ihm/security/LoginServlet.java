package org.eni_encheres.ihm.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.eni_encheres.bll.SecurityService;
import org.eni_encheres.bll.exception.BLLException;
import org.eni_encheres.bo.Utilisateur;

import java.io.IOException;
import java.security.MessageDigest;

@WebServlet("/connection")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/security/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // récup data dans le login.jsp
            String pseudo = request.getParameter("username");
            String password = request.getParameter("password");
            Utilisateur utilisateurC = SecurityService.getInstance().login(pseudo, password);

            // Création session
            HttpSession session = request.getSession();
            session.setAttribute("utilisateurC", utilisateurC);
            
            session.setMaxInactiveInterval(300);

            response.sendRedirect(request.getContextPath() + "/");
        } catch (BLLException e){
            request.setAttribute("erreurs",e.getErreurs());
            doGet(request,response);
        }
    }
}
