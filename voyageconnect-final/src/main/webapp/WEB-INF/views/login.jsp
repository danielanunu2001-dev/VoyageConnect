<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Connexion - VoyageConnect</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background-color: #F5F5F5;
            color: #333;
        }
        .navbar-brand {
            color: #005B96 !important;
            font-weight: 600;
        }
        .login-container {
            max-width: 450px;
            margin: 5rem auto;
            padding: 2rem;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        }
        .btn-primary {
            background-color: #005B96;
            border-color: #005B96;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm">
    <div class="container">
        <a class="navbar-brand" href="#">✈️ VoyageConnect</a>
    </div>
</nav>

<div class="container">
    <div class="login-container">
        <h2 class="text-center mb-4">Connexion</h2>

        <c:if test="${param.error}">
            <div class="alert alert-danger" role="alert">
                Email ou mot de passe incorrect.
            </div>
        </c:if>
        <c:if test="${param.logout}">
            <div class="alert alert-success" role="alert">
                Vous avez été déconnecté avec succès.
            </div>
        </c:if>
        <c:if test="${param.registrationSuccess}">
            <div class="alert alert-success" role="alert">
                Inscription réussie ! Vous pouvez maintenant vous connecter.
            </div>
        </c:if>

        <form action="<c:url value='/perform_login'/>" method="post">
            <div class="mb-3">
                <label for="email" class="form-label">Adresse Email</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Mot de passe</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <button type="submit" class="btn btn-primary w-100">Se connecter</button>
        </form>
        <div class="text-center mt-3">
            <p>Pas encore de compte ? <a href="<c:url value='/register'/>">Inscrivez-vous</a></p>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
