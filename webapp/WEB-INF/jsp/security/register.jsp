<%--
  Created by IntelliJ IDEA.
  User: schiron2023
  Date: 03/05/2023
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<% List<String> erreurs = (List<String>) request.getAttribute("erreurs");%>
<%  String pseudo = request.getParameter("pseudo");
    String nom = request.getParameter("nom");
    String prenom = request.getParameter("prenom");
    String email = request.getParameter("email");
    String telephone = request.getParameter("telephone");
    String rue = request.getParameter("rue");
    String codePostal = request.getParameter("codePostal");
    String ville = request.getParameter("ville");
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/styles.css">
    <title>Inscription</title>
</head>
<body>
<div class="container-fluid text-center">
    <header class="row mt-6 m-5">
        <nav class="navbar bg-body-tertiary">
            <div class="container-fluid">
                <a class="navbar-brand">ENI-Enchères</a>
            </div>
        </nav>
    </header>
    <main class="mx-5">
        <% if (erreurs != null) for (String erreur : erreurs) { %>
        <div class="alert alert-danger">
            <%= erreur %>
        </div>
        <% } %>
        <form action="" method="post">
            <div class="row mb-4 mx-5">
                <div class="col">
                    <div class="input-group mb-3 form-outline">
                        <span class="input-group-text">Pseudo: </span>
                        <input
                                type="text"
                                class="form-control"
                                aria-label="Username"
                                aria-describedby="basic-addon1"
                                id="pseudo" name="pseudo"
                                value="<%=(pseudo!=null)?pseudo:""%>"
                        />
                    </div>
                </div>
                <div class="col">
                    <div class="input-group mb-3 form-outline">
                        <span class="input-group-text">Nom: </span>
                        <input
                                type="text"
                                class="form-control"
                                aria-label="Username"
                                aria-describedby="basic-addon1"
                                id="nom" name="nom"
                                value="<%=(nom!=null)?nom:""%>"
                        />
                    </div>
                </div>
            </div>
            <div class="row mb-4 mx-5">
                <div class="col">
                    <div class="input-group mb-3 form-outline">
                        <span class="input-group-text">Prénom: </span>
                        <input
                                type="text"
                                class="form-control"
                                aria-label="Username"
                                aria-describedby="basic-addon1"
                                id="prenom" name="prenom"
                                value="<%=(prenom!=null)?prenom:""%>"
                        />
                    </div>
                </div>
                <div class="col">
                    <div class="input-group mb-3 form-outline">
                        <span class="input-group-text">Email: </span>
                        <input
                                type="email"
                                class="form-control"
                                aria-label="Username"
                                aria-describedby="basic-addon1"
                                id="email" name="email"
                                value="<%=(email!=null)?email:""%>"
                        />
                    </div>
                </div>
            </div>
            <div class="row mb-4 mx-5">
                <div class="col">
                    <div class="input-group mb-3 form-outline">
                        <span class="input-group-text">Téléphone: </span>
                        <input
                                type="text"
                                class="form-control"
                                aria-label="Username"
                                aria-describedby="basic-addon1"
                                id="telephone" name="telephone"
                                value="<%=(telephone!=null)?telephone:""%>"
                        />
                    </div>
                </div>
                <div class="col">
                    <div class="input-group mb-3 form-outline">
                        <span class="input-group-text">Rue: </span>
                        <input
                                type="text"
                                class="form-control"
                                aria-label="Username"
                                aria-describedby="basic-addon1"
                                id="rue" name="rue"
                                value="<%=(rue!=null)?rue:""%>"
                        />
                    </div>
                </div>
            </div>
            <div class="row mb-4 mx-5">
                <div class="col">
                    <div class="input-group mb-3 form-outline">
                        <span class="input-group-text">Code Postal: </span>
                        <input
                                type="text"
                                class="form-control"
                                aria-label="Username"
                                aria-describedby="basic-addon1"
                                id="codePostal" name="codePostal"
                                value="<%=(codePostal!=null)?codePostal:""%>"
                        />
                    </div>
                </div>
                <div class="col">
                    <div class="input-group mb-3 form-outline">
                        <span class="input-group-text">Ville: </span>
                        <input
                                type="text"
                                class="form-control"
                                aria-label="Username"
                                aria-describedby="basic-addon1"
                                id="ville" name="ville"
                                value="<%=(ville!=null)?ville:""%>"
                        />
                    </div>
                </div>
            </div>
            <div class="row mb-4 mx-5">
                <div class="col">
                    <div class="input-group mb-3 form-outline">
                        <span class="input-group-text">Mot de passe:</span>
                        <input
                                type="password"
                                class="form-control"
                                aria-label="Username"
                                aria-describedby="basic-addon1"
                                id="password" name="password"
                        />
                    </div>
                </div>
                <div class="col">
                    <div class="input-group mb-3 form-outline">
                        <span class="input-group-text">Confirme :</span>
                        <input
                                type="password"
                                class="form-control"
                                aria-label="Username"
                                aria-describedby="basic-addon1"
                                id="passwordConf" name="passwordConf"
                        />
                    </div>
                </div>
                <div class="row mb-4 mx-5">
                    <div class="col">
                        <button type="submit" class="btn btn-primary">Créer</button>
                    </div>
                    <div class="col">
                        <a href="<%= request.getContextPath()%>/connection">
                            <button type="button" class="btn btn-primary">Annuler</button>
                        </a>
                    </div>
                </div>
            </div>
        </form>
    </main>
</div>
</body>
</html>
