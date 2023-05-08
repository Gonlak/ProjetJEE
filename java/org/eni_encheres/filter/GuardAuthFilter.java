package org.eni_encheres.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.eni_encheres.bo.Utilisateur;

import java.io.IOException;

@WebFilter(
        dispatcherTypes = {
                DispatcherType.REQUEST
        },
        urlPatterns = {
                "/modification",
                "/nouvelle-vente"
        }
)
public class GuardAuthFilter extends HttpFilter implements Filter {
    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpSession session = request.getSession();
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateurC");
        if (utilisateur == null) {
            response.sendRedirect(request.getContextPath());
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("Starting... Filter Guard");
    }
}
