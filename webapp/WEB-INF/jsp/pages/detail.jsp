<%@page import="org.eni_encheres.bo.Article_Vendu"%>
<%@page import="org.eni_encheres.bo.Enchere"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
Enchere enchere = (Enchere) request.getAttribute("enchere");
%>
<%
Article_Vendu article = (Article_Vendu) request.getAttribute("article");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/styles.css">
<title>Detail</title>
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
					<p>Nom de l'article
					<p>
				</div>
				<div class="form-group">
					<label for="description" class="form-label mt-2">Description
							:</label>
						<textarea class="form-control" id="description" rows="3"></textarea>
				</div>
			</div>
		</main>
	</div>
</body>
</html>