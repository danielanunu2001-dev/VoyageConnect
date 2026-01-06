<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gérer les Destinations - VoyageConnect</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
    <style>
        body { font-family: 'Poppins', sans-serif; background-color: #F5F5F5; }
        .navbar-brand { color: #005B96 !important; font-weight: 600; }
        .sidebar { background-color: #fff; height: 100vh; padding-top: 1rem; }
        .nav-link { color: #333; }
        .nav-link.active { color: #005B96; font-weight: 600; }
        .btn-primary { background-color: #005B96; border-color: #005B96; }
    </style>
</head>
<body>

<header class="navbar navbar-expand-lg navbar-light bg-white shadow-sm">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">✈️ VoyageConnect [Admin]</a>
        <form action="<c:url value='/perform_logout'/>" method="post" class="d-flex">
            <button class="btn btn-outline-danger" type="submit">Déconnexion</button>
        </form>
    </div>
</header>

<div class="container-fluid">
    <div class="row">
        <nav id="sidebar" class="col-md-3 col-lg-2 d-md-block sidebar collapse">
            <div class="position-sticky">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value='/admin/dashboard'/>">
                            <i class="bi bi-speedometer2"></i> Dashboard
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="<c:url value='/admin/destinations'/>">
                            <i class="bi bi-geo-alt-fill"></i> Gérer les Destinations
                        </a>
                    </li>
                </ul>
            </div>
        </nav>

        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4 py-4">
            <h1 class="h2 mb-4">Gérer les Destinations</h1>

            <div class="card">
                <div class="card-header">
                    Ajouter une nouvelle destination
                </div>
                <div class="card-body">
                    <form action="<c:url value='/admin/destinations'/>" method="post">
                        <div class="row">
                            <div class="col-md-4 mb-3"><input type="text" class="form-control" name="nom" placeholder="Nom" required></div>
                            <div class="col-md-4 mb-3"><input type="text" class="form-control" name="pays" placeholder="Pays" required></div>
                            <div class="col-md-4 mb-3"><input type="text" class="form-control" name="ville" placeholder="Ville" required></div>
                        </div>
                        <div class="mb-3"><textarea class="form-control" name="description" placeholder="Description"></textarea></div>
                        <div class="mb-3"><input type="text" class="form-control" name="image" placeholder="URL de l'image"></div>
                        <button type="submit" class="btn btn-primary">Ajouter</button>
                    </form>
                </div>
            </div>

            <hr class="my-4">

            <h2 class="h3">Liste des destinations</h2>
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nom</th>
                            <th>Pays</th>
                            <th>Ville</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${destinations}" var="dest">
                            <tr>
                                <td>${dest.id}</td>
                                <td>${dest.nom}</td>
                                <td>${dest.pays}</td>
                                <td>${dest.ville}</td>
                                <td>
                                    <form action="<c:url value='/admin/destinations'/>" method="post" style="display:inline;">
                                        <input type="hidden" name="action" value="delete">
                                        <input type="hidden" name="id" value="${dest.id}">
                                        <button type="submit" class="btn btn-sm btn-outline-danger"><i class="bi bi-trash"></i></button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </main>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
