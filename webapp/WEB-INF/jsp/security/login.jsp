<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<% List<String> erreurs = (List<String>) request.getAttribute("erreurs");%>
<% String username = request.getParameter("username");
    String password = request.getParameter("password");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/styles.css">
    <title>Se Connecter</title>
</head>
<body>

<div class="container-fluid">
    <div class="container">
        <header class="row mt-6">
            <nav class="navbar bg-body-tertiary">
                <div class="container-fluid">
                    <a class="navbar-brand">ENI-Enchères</a>
                </div>
            </nav>
        </header>
        <!-- formulaire de connexion -->
        <main class="col-10 offset-2">
            <form action="" method="post">
                <div class="row row-form">
                    <% if (erreurs != null) for (String erreur : erreurs) { %>
                    <div class="alert alert-danger">
                        <%= erreur %>
                    </div>
                    <% } %>
                    <div class="col-5">
                        <label for="username">Identifiant :</label>
                    </div>
                    <!--
                        seb
                        modification id username -> pseudo comme dans la bo, change type text en type password pour password et rajout de placeholder
                        -->
                    <div class="col-5">
                        <input type="text" name="username" id="username" placeholder="pseudo"
                               value="<%=(username!=null)?username:""%>">
                    </div>
                </div>
                <div class="row row-form">
                    <div class="col-5">
                        <label for="username">Mot de passe :</label>
                    </div>
                    <div class="col-5">
                        <input type="password" name="password" id="password" placeholder="mot de passe"
                               value="<%=(password!=null)?password:""%>">
                    </div>
                </div>
                <div class="row row-form">
                    <div class="col-5">
                        <!--
                        Seb
                        modif type button -> submit
                        -->
                        <button type="submit" class="btn btn-success">Connexion</button>
                    </div>
                    <div class="col-5">
                        <div class="row">
                            <div class="col-2">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                                    <label class="form-check-label" for="flexCheckDefault">
                                        Se souvenir de moi
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--
                        seb
                        modification déplacement du form du "mdp oublier" et du btn créer un compte
                        -->
            </form>
            <div class="text-center">
                <a href="#">Mot de passe oublié</a>
            </div>
            <div class="row row-form">
                <a class="btn btn-success" href="<%= request.getContextPath()%>/inscription">Créer un compte</a>
            </div>
        </main>

    </div>

</div>

</body>
</html>