<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.eni_encheres.bo.Utilisateur" %>

<nav class="navbar bg-body-tertiary">
    <div class="container-fluid">

        <a href="<%= request.getContextPath()%>" class="navbar-brand">ENI-Enchères</a>


        <%if (utilisateurC != null) {%>
        <div class="d-flex align-items-center">
            <a href="<%= request.getContextPath()%>/connection" class="mx-2">
                <button type="submit" class="btn btn-link">Enchères</button>
            </a>
            <a href="<%= request.getContextPath()%>/connection" class="mx-2">
                <button type="submit" class="btn btn-link">Vendre un article</button>
            </a>
            <a href="<%= request.getContextPath()%>/profil/<%=utilisateurC.getUsername()%>" class="mx-2">Mon
                profil</a>

            <form action="" method="post" class="m-0">
                <a href="<%= request.getContextPath()%>" class="mx-2">
                    <button type="submit" name="deco" value="true" class="btn btn-link">Déconnexion</button>
                </a>
            </form>


        </div>
        <%} else {%>
        <a href="<%= request.getContextPath()%>/connection">
            <button type="submit" name="btn" value="2" class="btn">Déconnexion</button>
        </a>
        <a href="<%= request.getContextPath()%>/connection" class="d-flex">S'inscrire / Se connecter</a>
        <%}%>
    </div>
</nav>