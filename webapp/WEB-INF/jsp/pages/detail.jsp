<%@page import="java.util.List"%>
<%@page import="org.eni_encheres.bo.Article_Vendu" %>
<%@page import="org.eni_encheres.bo.Enchere" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="ISO-8859-1" %>
<%
     /* Utilisateur utilisateurC = (Utilisateur) request.getAttribute("utilisateurC"); */ 
    List<Utilisateur> utilisateurs = (List<Utilisateur>) request.getAttribute("utilisateurData");
    Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");
   	List<Enchere> encheres = (List<Enchere>) request.getAttribute("encheres"); 
    Article_Vendu article = (Article_Vendu) request.getAttribute("article");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/assets/css/styles.css">
    <title>Detail</title>
</head>
<body>

<header class="container-fluid row">
    <%@ include file="/WEB-INF/jsp/parts/header.jsp" %>
</header>
<div class="container-fluid">
    <main class="row">
        <div class="row text-center">
            <h1>Détail vente</h1>
        </div>
        <div class="col-5 offset-1">
            <div class="row g-0">
                <div class="col-md-4">
                    <img src="" class="img-fluid rounded-start" alt="...">
                </div>
            </div>
        </div>
        <div class="col-3 offset-4">
            <div class="row text-center">
                <p><%= article.getArticleName() %></p>
            </div>
            <div class="form-group">
                <label for="description" class="form-label mt-2">Description
                    :</label>
                <textarea class="form-control" id="description" rows="3"><%= article.getDescription() %></textarea>
            </div>
            <div class="mt-2">
             <p>Catégorie : <%= article.getCategories().getLibelle() %></p>
            </div>
            <div class="mt-2">
             <p id="meilleurOffre">Meilleur offre : <%= article.getEnchersMax(article.getNo_article()) %> par 
               <% if(utilisateurs.get(article.getUser().getNo_user()).getUsername() != "admin"){ %>
              <%= utilisateur.getUsername() %></p>
              <% } %>
            </div>
            <div class="mt-2">
             <p>Mise à prix : <%= article.getOriginal_price() %> points</p>
            </div>
            <div class="mt-2">
             <p>Fin de l'enchère : <%= article.getEnd_auction_date() %></p>
            </div>
            <div class="mt-2">
             <p>Retrait : <%= article.getUser().getStreet() %> <%= article.getUser().getZipCode() %> <%= article.getUser().getTown() %></p>
            </div>
            <div class="mt-2">
             <p>Vendeur : <%= article.getUser().getUsername() %></p>
            </div>
            <div class="mt-2">
            	<label for="proposition" class="form-label mt-2">Ma proposition</label>
            	<input type="number" class="form-control" name="proposition" id="proposition" value="">
            </div>
            <div class="mt-2">
            	<button type="submit" class="btn btn-success">Enchérir</button>
            </div>  
        </div>
    </main>
</div>

	
</body>
</html>