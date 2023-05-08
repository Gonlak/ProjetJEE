<%@ page import="org.eni_encheres.bo.Categorie" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    Utilisateur utilisateurC = (Utilisateur) request.getAttribute("utilisateurC");
    List<Categorie> categories = (List<Categorie>) request.getAttribute("Categories");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/assets/css/styles.css">
    <title>Nouvelle Vente</title>
</head>
<body>
<header class="container-fluid row">
    <%@ include file="/WEB-INF/jsp/parts/header.jsp" %>
</header>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12 text-center">
            <h1>Nouvelle vente</h1>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 offset-md-1">
            <img src="assets/img/chopper.jpg" class="img-thumbnail w-100" alt="...">
        </div>

        <div class="col-md-6">
            <form action="" method="post">
                <div class="form-group">
                    <label for="article" class="form-label">Article :</label>
                    <input type="text" class="form-control" name="article" id="article">
                </div>

                <div class="form-group">
                    <label for="description" class="form-label mt-2">Description :</label>
                    <textarea class="form-control" name="description" id="description" rows="3"></textarea>
                </div>

                <div class="form-group">
                    <label for="categorie" class="form-label mt-2">Catégorie :</label>
                    <select class="form-select" name="categorie" id="categorie">
                        <%
                            for(Categorie categorie : categories){
                        %>
                        <option><%=categorie.getLibelle()%></option>
                        <%}%>
                    </select>
                </div>

                <div class="form-group">
                    <label for="photo" class="form-label mt-2">Photo de l'article :</label>
                    <input type="file" class="form-control" name="photo" id="photo">
                </div>

                <div class="form-group">
                    <label for="miseaprix" class="form-label mt-2">Mise à prix :</label>
                    <input type="number" class="form-control" name="miseaprix" id="miseaprix">
                </div>

                <div class="form-group">
                    <label for="debutenchere" class="form-label mt-2">Début de l'enchère :</label>
                    <input type="date" class="form-control" name="debutenchere" id="debutenchere">
                </div>

                <div class="form-group">
                    <label for="finenchere" class="form-label mt-2">Fin de l'enchère :</label>
                    <input type="date" class="form-control" name="finenchere" id="finenchere">
                </div>

                <fieldset>
                    <legend>Retrait :</legend>

                    <div class="form-group">
                        <label for="street" class="form-label">Rue :</label>
                        <input type="text" class="form-control" name="street" id="street">
                    </div>

                    <div class="form-group">
                        <label for="zipcode" class="form-label">Code Postal :</label>
                        <input type="text" class="form-control" name="zipcode" id="zipcode">
                    </div>

                    <div class="form-group">
                        <label for="town" class="form-label">Ville :</label>
                        <input type="text" class="form-control" name="town" id="town">
                    </div>
                </fieldset>

                <div class="mt-3">
                    <button type="submit" class="btn btn-success">Enregistrer</button>
                    <a href="<%= request.getContextPath()%>">
                        <button type="button" class="btn btn-success">Annuler</button>
                    </a>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>