<%@ page import="org.eni_encheres.bo.Utilisateur" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    Utilisateur utilisateurC = (Utilisateur) request.getAttribute("utilisateurC");
    Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");

%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/assets/css/styles.css">
    <title>Profil utilisateur</title>
</head>
<body>
<div class="container-fluid">
    <header class="row">
        <nav class="navbar bg-body-tertiary">
            <div class="container-fluid">
                <a class="navbar-brand">ENI-Enchères</a>
            </div>
        </nav>
    </header>

    <main>
        <!-- Section Affichage profil -->
        <div class="row col-sm">
            <div class="col">
                <p class="text-end">Pseudo :</p>
            </div>
            <div class="col">
                <p><%=utilisateur.getUsername()%>
                </p>
            </div>
        </div>
        <div class="row col-sm">
            <div class="col">
                <p class="text-end">Nom :</p>
            </div>
            <div class="col">
                <p><%=utilisateur.getLastname()%>
                </p>
            </div>
        </div>
        <div class="row col-sm">
            <div class="col">
                <p class="text-end">Prénom :</p>
            </div>
            <div class="col">
                <p><%=utilisateur.getFirstname()%>
                </p>
            </div>
        </div>
        <div class="row col-sm">
            <div class="col">
                <p class="text-end">Email :</p>
            </div>
            <div class="col">
                <p><%=utilisateur.getEmail()%>
                </p>
            </div>
        </div>
        <div class="row col-sm">
            <div class="col">
                <p class="text-end">Téléphone :</p>
            </div>
            <div class="col">
                <p><%=utilisateur.getPhoneNumber()%>
                </p>
            </div>
        </div>
        <div class="row col-sm">
            <div class="col">
                <p class="text-end">Rue :</p>
            </div>
            <div class="col">
                <p><%=utilisateur.getStreet()%>
                </p>
            </div>
        </div>
        <div class="row col-sm">
            <div class="col">
                <p class="text-end">Code Postal :</p>
            </div>
            <div class="col">
                <p><%=utilisateur.getZipCode()%>
                </p>
            </div>
        </div>
        <div class="row col-sm">
            <div class="col">
                <p class="text-end">Ville :</p>
            </div>
            <div class="col">
                <p><%=utilisateur.getTown()%>
                </p>
            </div>
        </div>

            <% if (utilisateurC != null && utilisateurC.getUsername().equals(utilisateur.getUsername())) {%>
        <div class="text-center">
            <a class="btn btn-success" href="<%= request.getContextPath()%>/modification">Modifier</a>
        </div>
            <%}%>
</div>
</main>
</div>
</body>
</html>