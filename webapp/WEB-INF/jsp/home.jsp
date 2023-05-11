<%@page import="java.util.List" %>
<%@page import="org.eni_encheres.bo.Article_Vendu" %>
<%@page import="org.eni_encheres.bo.Enchere" %>
<%@ page import="org.eni_encheres.bo.Utilisateur" %>
<%@ page import="org.eni_encheres.bo.Categorie" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    /* Utilisateur utilisateurC = (Utilisateur) request.getAttribute("utilisateurC"); */
    List<Article_Vendu> articlesData = (List<Article_Vendu>) request.getAttribute("articlesData");
    List<Article_Vendu> articles = (List<Article_Vendu>) request.getAttribute("articles");
    List<Categorie> categories = (List<Categorie>) request.getAttribute("Categories");
%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/assets/css/styles.css">
    <title>Liste des enchères</title>
</head>
<body>
<header class="container-fluid row">
    <%@ include file="/WEB-INF/jsp/parts/header.jsp" %>
</header>
<div class="container-fluid">

    <main class="row">
        <div class="row text-center mt-6">
            <h1>Liste des enchères</h1>
        </div>

        <section class="filter search row">
            <div class="row mt-6">
                <h2>Filtres :</h2>
            </div>

            <!-- Section Recherche par filtre -->
            <form action="" method="post">
            <div class="row mt-3">
                <div class="col-4">
                    <div class="input-group">
                        <span class="input-group-text" id="basic-addon1">@</span>
                        <input type="text" class="form-control" placeholder="Le nom de l'article contient"
                               aria-label="Username" aria-describedby="basic-addon1" name="keyword">
                    </div>
                    <div class="row">
                        <!-- Categories -->
                        <div class="form-group">
                            <label for="categorie" class="form-label mt-4">Catégories :</label>
                            <select class="form-select" id="categorie" name="categorieId" >
                            	<option value="-1"></option>
                                <%for(Categorie categorie : categories){%>
								<option value="<%=categorie.getNo_categorie()%>"><%=categorie.getLibelle()%></option>
								<%}%>
                            </select>
                        </div>
                    </div>

                </div>

                <div class="col-4">
                    <button type="submit" class="btn btn-success">Rechercher</button>
                </div>
            </div>
            </form>
        </section>

        <!-- Affichage -->
        <section class="display mt-6 col-12">
            <div class="row ">
            <% if (articles != null && !articles.isEmpty() ) { %>
                <%
                    for (Article_Vendu article : articles) {
                        int noArticle = article.getNo_article();
                        Article_Vendu vendeurArticle = null;
                %>
				 
                <div class="col-4">
                    <div class="card mb-3" style="max-width: 540px;">
                        <div class="row g-0">
                            <div class="col-md-4">
                                <img src="assets/img/radio.jpg" class="img-fluid rounded-start"
                          
                                     alt="...">
                            </div>
                            <div class="col-md-8">
                                <div class="card-body">
                                    <h5 class="card-title"><%=article.getArticleName()%>
                                    </h5>
                                     <% if (article.getEncheres() != null) { %>
                                    <p class="card-text">Prix : <%=(article.getEnchersMax(article.getNo_article())>0)? article.getEnchersMax(article.getNo_article()): article.getOriginal_price()%>
                                     points </p>
                                     <% } %>
                                    <p class="card-text">
                                        Fin de l'enchère :
                                        <%=article.getEnd_auction_date()%>
                                    </p>
                                    <p class="card-text">
                                        Vendeur :
                                        <% // Affichage du vendeur
                                            for (Article_Vendu article_vendu : articles) {
                                                if (article_vendu.getNo_article() == noArticle) {
                                                    vendeurArticle = article_vendu;
                                                    break;
                                                }
                                            }
                                            if (vendeurArticle != null) {
                                        %>
                                        <a href="<%= request.getContextPath()%>/profil/<%=vendeurArticle.getUser().getUsername()%>"><%=vendeurArticle.getUser().getUsername()%>
                                        </a>
                                        <% } %>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <% } %>	
                <% } else { %>	
        	<div>
        	<p>Aucun article trouvé.</p>
        	</div>
    		<% } %>
                <!-- fin boucle -->
            </div>
        </section>
    </main>
</div>

</body>
</html>