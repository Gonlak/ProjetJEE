
<%@ page import="org.eni_encheres.bo.Categorie" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    /* Utilisateur utilisateurC = (Utilisateur) request.getAttribute("utilisateurC"); */
    List<Categorie> categories = (List<Categorie>) request.getAttribute("Categories");
    List<String> erreurs = (List<String>) request.getAttribute("erreurs");

    String article = request.getParameter("article");
    String description = request.getParameter("description");
    String oneCategorie = request.getParameter("categorie");
    String photo = request.getParameter("photo");
    String miseaprix = request.getParameter("miseaprix");
    String debutenchere = request.getParameter("debutenchere");
    String finenchere = request.getParameter("finenchere");
    String street = request.getParameter("street");
    String zipcode = request.getParameter("zipecode");
    String town = request.getParameter("town");
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
    <% if (erreurs != null) for (String erreur : erreurs) { %>
    <div class="alert alert-danger">
        <%= erreur %>
    </div>
    <% } %>
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
                    <input type="text" class="form-control" name="article" id="article"
                           value="<%=(article!=null)?article:""%>">
                </div>

                <div class="form-group">
                    <label for="description" class="form-label mt-2">Description :</label>
                    <textarea class="form-control" name="description" id="description" rows="3"
                              value="<%=(description!=null)?description:""%>"></textarea>
                </div>

                <div class="form-group">
                    <label for="categorie" class="form-label mt-2">CatÃ©gorie :</label>
                    <select class="form-select" name="categorie" id="categorie">
                        <option value="-1"></option>
                        <%
                            for (Categorie categorie : categories) {
                        %>
                        <option value="<%=categorie.getNo_categorie()%>"><%=categorie.getLibelle()%>
                        </option>
                        <%}%>
                    </select>
                </div>

                <div class="form-group">
                    <label for="photo" class="form-label mt-2">Photo de l'article :</label>
                    <input type="file" class="form-control" name="photo" id="photo" value="<%=(photo!=null)?photo:""%>">
                </div>

                <div class="form-group">
                    <label for="miseaprix" class="form-label mt-2">Mise Ã  prix :</label>
                    <input type="number" class="form-control" name="miseaprix" id="miseaprix"
                           value="<%=(miseaprix!=null)?miseaprix:0%>">
                </div>

                <div class="form-group">
                    <label for="debutenchere" class="form-label mt-2">DÃ©but de l'enchÃ¨re :</label>
                    <input type="date" class="form-control" name="debutenchere" id="debutenchere"
                           value="<%=(debutenchere!=null)?debutenchere:""%>">
                </div>

                <div class="form-group">
                    <label for="finenchere" class="form-label mt-2">Fin de l'enchÃ¨re :</label>
                    <input type="date" class="form-control" name="finenchere" id="finenchere"
                           value="<%=(finenchere!=null)?finenchere:""%>">
                </div>

                <fieldset>
                    <legend>Retrait :</legend>

                    <div class="form-group">
                        <label for="street" class="form-label">Rue :</label>
                        <input type="text" class="form-control" name="street" id="street"
                               value="<%=(street!=null)?street:utilisateurC.getStreet()%>">
                    </div>

                    <div class="form-group">
                        <label for="zipcode" class="form-label">Code Postal :</label>
                        <input type="text" class="form-control" name="zipcode" id="zipcode"
                               value="<%=(zipcode!=null)?zipcode:utilisateurC.getZipCode()%>">
                    </div>

                    <div class="form-group">
                        <label for="town" class="form-label">Ville :</label>
                        <input type="text" class="form-control" name="town" id="town"
                               value="<%=(town!=null)?town:utilisateurC.getTown()%>">
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

	<div class="container-fluid">
		<header class="row">
			<nav class="navbar bg-body-tertiary">
				<div class="container-fluid">
					<a class="navbar-brand">ENI-Enchères</a>
				</div>
			</nav>
		</header>
		<main class="row">
			<div class="row text-center">
				<h1>Nouvelle vente</h1>
			</div>
			<!-- Robin revoir pour l'image -->
			<div class="col-5 offset-1">
				<div class="row g-0">
					<div class="col-md-4">
						<img src="assets/img/camera.jpg" class="img-fluid rounded-start"
							alt="...">
					</div>
				</div>
			</div>
			<!--  Robin revoir la marge top du formulaire  -->
			<div class="col-3 offset-4">
				<form>
					<div class="form-group">
						<label for="article" class="form-label">Article :</label> <input
							type="text" class="form-control" id="article">
					</div>
					<div class="form-group">
						<label for="description" class="form-label mt-2">Description
							:</label>
						<textarea class="form-control" id="description" rows="3"></textarea>
					</div>
					<div class="form-group">
						<label for="categorie" class="form-label mt-2">Catégorie</label> <select
							class="form-select" id="categorie">
							<%
							for (Categorie categorie : categories) {
							%>
							<option><%=categorie.getLibelle()%></option>
							<%
							}
							%>
						</select>
					</div>
					<div class="form-group">
						<label for="photo" class="form-label mt-2">Photo de
							l'article</label> <input type="file" class="form-control" id="customFile" />
					</div>
					<div class="form-group">
						<label for="miseaprix" class="form-label mt-2">Mise à prix</label>
						<input type="number" class="form-control" id="miseaprix">
					</div>
					<div class="form-group">
						<label for="debutenchere" class="form-label mt-2">Début de
							l'enchère</label> <input type="date" class="form-control"
							id="debutenchere">
					</div>
					<div class="form-group">
						<label for="finenchere" class="form-label mt-2">Fin de
							l'enchère</label> <input type="date" class="form-control" id="finenchere">
					</div>
					<div>
						<fieldset>
							<!--  Robin revoir le fieldset il ne marche pas -->
							<legend>Retrait</legend>
							<div class="form-group">
								<label for="street">Rue :</label> <input type="text"
									class="form-control" id="street">
							</div>
							<div class="form-group">
								<label for="zipcode" class="form-label">Code Postal :</label> <input
									type="text" class="form-control" id="zipcode">
							</div>
							<div class="form-group">
								<label for="town" class="form-label">Ville :</label> <input
									type="text" class="form-control" id="town">
							</div>
						</fieldset>
					</div>
					<div class="mt-3 d-flex justify-content-around">
						<button type="button" class="btn btn-success">Enregistrer</button>
						<button type="button" class="btn btn-danger" >Annuler</button>
						<button
							onclick="return confirm('Voulez-vous vraiment annuler la vente?');"
							type="button" class="btn btn-danger">Annuler la vente</button>
					</div>
				</form>

			</div>
		</main>
	</div>

</body>
</html>