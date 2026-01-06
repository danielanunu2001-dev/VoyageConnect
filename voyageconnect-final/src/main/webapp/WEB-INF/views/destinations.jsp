<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nos Destinations - VoyageConnect</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
    <style>
        body { font-family: 'Poppins', sans-serif; background-color: #F5F5F5; }
        .navbar-brand { color: #005B96 !important; font-weight: 600; }
        .hero {
            background: url('https://images.unsplash.com/photo-1488085061387-422e29b40080?q=80&w=1931&auto=format&fit=crop') no-repeat center center;
            background-size: cover;
            color: white;
            padding: 6rem 0;
            text-align: center;
        }
        .card {
            transition: transform 0.2s;
        }
        .card:hover {
            transform: translateY(-5px);
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm">
    <div class="container">
        <a class="navbar-brand" href="#">✈️ VoyageConnect</a>
        <div class="ms-auto">
            <a href="<c:url value='/login'/>" class="btn btn-outline-primary">Connexion</a>
            <a href="<c:url value='/register'/>" class="btn btn-primary">Inscription</a>
        </div>
    </div>
</nav>

<div class="hero">
    <div class="container">
        <h1 class="display-4">Découvrez le Monde</h1>
        <p class="lead">Explorez nos destinations de rêve et trouvez votre prochaine aventure.</p>
    </div>
</div>

<div class="container py-5">
    <h2 class="text-center mb-5">Toutes nos destinations</h2>
    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
        <c:forEach items="${destinations}" var="dest">
            <div class="col">
                <div class="card h-100 shadow-sm border-0">
                    <img src="${not empty dest.image ? dest.image : 'https://via.placeholder.com/400x250'}" class="card-img-top" alt="${dest.nom}">
                    <div class="card-body">
                        <h5 class="card-title">${dest.nom}</h5>
                        <p class="card-text text-muted">${dest.ville}, ${dest.pays}</p>
                        <p class="card-text">${dest.description}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<footer class="text-center py-4 bg-white">
    <p>&copy; 2024 VoyageConnect. Tous droits réservés.</p>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
