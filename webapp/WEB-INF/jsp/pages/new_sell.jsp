<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
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
                    <img src="assets/img/radio.jpg" class="img-fluid rounded-start"
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
                    <!-- Robin revoir pour integrer les catégories -->
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                </select>
                </div>
                <div class="form-group">
                    <label for="photo" class="form-label mt-2">Photo de
                        l'article</label> <input type="file" class="form-control" id="customFile"/>
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
                <div class="mt-3">
                    <button type="button" class="btn btn-success">Enregistrer</button>
                    <button type="button" class="btn btn-success">Annuler</button>
                </div>

            </form>
        </div>
    </main>
</div>
</body>
</html>