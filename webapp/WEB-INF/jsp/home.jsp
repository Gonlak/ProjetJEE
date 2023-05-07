<%@page import="java.util.List" %>
<%@page import="org.eni_encheres.bo.Article_Vendu" %>
<%@page import="org.eni_encheres.bo.Enchere" %>
<%@ page import="org.eni_encheres.bo.Utilisateur" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    Utilisateur utilisateurC = (Utilisateur) request.getAttribute("utilisateurC");
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<% List<Article_Vendu> articles = (List<Article_Vendu>) request.getAttribute("articles"); %>


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
<div class="container-fluid">
    <header class="row">
        <nav class="navbar bg-body-tertiary">
            <div class="container-fluid">
                <a class="navbar-brand">ENI-Enchères</a>
                <%if (utilisateurC != null) {%>
                <div class="d-flex align-items-center">
                    <a href="<%= request.getContextPath()%>/connection" class="mx-2">Enchères</a>
                    <a href="<%= request.getContextPath()%>/connection" class="mx-2">Vendre un article</a>
                    <a href="<%= request.getContextPath()%>/profil/<%=utilisateurC.getUsername()%>" class="mx-2">Mon
                        profil</a>
                    <a href="<%= request.getContextPath()%>/connection" class="mx-2">Déconnexion</a>
                </div>
                <%} else {%>
                <a href="<%= request.getContextPath()%>/connection" class="d-flex">S'inscrire / Se connecter</a>
                <%}%>
            </div>
        </nav>
    </header>

    <main class="row">
        <div class="row text-center mt-6">
            <h1>Liste des enchères</h1>
        </div>

        <%--<<<<<<< HEAD--%>

        <%--        <section class="filter search row">--%>
        <%--            <div class="row mt-6">--%>
        <%--                <h2>Filtres :</h2>--%>
        <%--            </div>--%>

        <%--            <!-- Section Recherche par filtre -->--%>
        <%--            <div class="row mt-3">--%>
        <%--                <div class="col-4">--%>
        <%--                    <div class="input-group">--%>
        <%--                        <span class="input-group-text" id="basic-addon1">@</span>--%>
        <%--                        <input type="text" class="form-control" placeholder="Le nom de l'article contient"--%>
        <%--                               aria-label="Username" aria-describedby="basic-addon1">--%>
        <%--                    </div>--%>
        <%--                    <div class="row">--%>
        <%--                        <!-- Categories -->--%>
        <%--                        <div class="form-group">--%>
        <%--                            <label for="exampleSelect1" class="form-label mt-4">Catégories :</label>--%>
        <%--                            <select class="form-select" id="exampleSelect1">--%>
        <%--                                <option>1</option>--%>
        <%--                                <option>2</option>--%>
        <%--                                <option>3</option>--%>
        <%--                                <option>4</option>--%>
        <%--                                <option>5</option>--%>
        <%--                            </select>--%>
        <%--                        </div>--%>
        <%--                    </div>--%>

        <%--                </div>--%>

        <%--                <div class="col-4">--%>
        <%--                    <button type="button" class="btn btn-success">Rechercher</button>--%>
        <%--                </div>--%>
        <%--            </div>--%>
        <%--        </section>--%>

        <%--        <!-- Affichage -->--%>
        <%--        <section class="display mt-6 row">--%>
        <%--            <div class="col-5 offset-1">--%>
        <%--                <div class="card mb-3" style="max-width: 540px;">--%>
        <%--                    <div class="row g-0">--%>
        <%--                        <div class="col-md-4">--%>
        <%--                            <img src="assets/img/radio.jpg" class="img-fluid rounded-start" alt="...">--%>
        <%--                        </div>--%>
        <%--                        <div class="col-md-8">--%>
        <%--                            <div class="card-body">--%>
        <%--                                <h5 class="card-title">Card name</h5>--%>
        <%--                                <p class="card-text">Prix :</p>--%>
        <%--                                <p class="card-text">Fin de l'enchère : </p>--%>
        <%--                                <p class="card-text">Vendeur : </p>--%>
        <%--                            </div>--%>
        <%--                        </div>--%>
        <%--                    </div>--%>
        <%--                </div>--%>
        <%--            </div>--%>

        <%--            <div class="col-5 offset-1">--%>
        <%--                <div class="card mb-3" style="max-width: 540px;">--%>
        <%--                    <div class="row g-0">--%>
        <%--                        <div class="col-md-4">--%>
        <%--                            <img src="assets/img/camera.jpg" class="img-fluid rounded-start" alt="...">--%>
        <%--                        </div>--%>
        <%--                        <div class="col-md-8">--%>
        <%--                            <div class="card-body">--%>
        <%--                                <h5 class="card-title">Card title</h5>--%>
        <%--                                <p class="card-text">Prix :</p>--%>
        <%--                                <p class="card-text">Fin de l'enchère : </p>--%>
        <%--                                <p class="card-text">Vendeur : </p>--%>
        <%--                            </div>--%>
        <%--                        </div>--%>
        <%--                    </div>--%>
        <%--                </div>--%>
        <%--            </div>--%>
        <%--        </section>--%>
        <%--    </main>--%>
        <%--</div>--%>


        <section class="filter search row">
            <div class="row mt-6">
                <h2>Filtres :</h2>
            </div>

            <!-- Section Recherche par filtre -->
            <div class="row mt-3">
                <div class="col-4">
                    <div class="input-group">
                        <span class="input-group-text" id="basic-addon1">@</span>
                        <input type="text" class="form-control" placeholder="Le nom de l'article contient"
                               aria-label="Username" aria-describedby="basic-addon1">
                    </div>
                    <div class="row">
                        <!-- Categories -->
                        <div class="form-group">
                            <label for="exampleSelect1" class="form-label mt-4">Catégories :</label>
                            <select class="form-select" id="exampleSelect1">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>
                        </div>
                    </div>

                </div>

                <div class="col-4">
                    <button type="button" class="btn btn-success">Rechercher</button>
                </div>
            </div>
        </section>

        <!-- Affichage -->
        <section class="display mt-6 col-12">
            <div class="row ">
                <%
                    int i = 0;
                    for (Article_Vendu article : articles) {
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
                                    <p class="card-text">Prix : <%=article.getEnchersMax(article.getNo_article())%>
                                    </p>
                                    <p class="card-text">
                                        Fin de l'enchère :
                                        <%=article.getEnd_auction_date()%>
                                    </p>
                                    <p class="card-text">
                                        Vendeur :
                                        <a href="<%= request.getContextPath()%>/profil/<%=article.getUser().getUsername()%>"><%=article.getUser().getUsername()%>
                                        </a>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>


                <% } %>
                <!-- fin boucle -->
            </div>


        </section>


    </main>
</div>

</body>
</html>