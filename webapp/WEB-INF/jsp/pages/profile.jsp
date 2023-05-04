<%@ page import="org.eni_encheres.bo.Utilisateur" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/styles.css">
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
            <div class="col-4 offset-4">
                <div>
                    <p>Pseudo : <%=utilisateur.getUsername()%></p>
                </div>
                <div>
                    <p>Nom : <%=utilisateur.getLastname()%></p>
                </div>
                <div>
                    <p>Prénom : <%=utilisateur.getFirstname()%></p>
                </div>
                <div>
                    <p>Email : <%=utilisateur.getEmail()%></p>
                </div>
                <div>
                    <p>Téléphone : <%=utilisateur.getPhoneNumber()%></p>
                </div>
                <div>
                    <p>Rue : <%=utilisateur.getTown()%></p>
                </div>
                <div>
                    <p>Code Postal : <%=utilisateur.getZipCode()%></p>
                </div>
                <div>
                    <p>Ville : <%=utilisateur.getStreet()%></p>
                </div>
                <div class="text-center">
                    <button type="button" class="btn btn-success">Modifier</button>
                </div>
            </div>
        </main>
	</div>
</body>
</html>