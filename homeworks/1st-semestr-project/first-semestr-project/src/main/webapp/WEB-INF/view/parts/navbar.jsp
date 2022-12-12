<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Navbar</title>
</head>
<body>
  <nav class="navbar navbar-expand-sm navbar-light bg-white">
    <a class="navbar-brand mb-0 h1 mx-3">
      Game Shop
    </a>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item disabled">
          <a class="nav-link" href="<c:url value="/catalog"/>">
            Catalog
          </a>
        </li>

        <% if (authUser != null) { %>
        <li class="nav-item disabled">
          <a class="nav-link" href="<c:url value="/cart"/>">
            Cart
          </a>
        </li>
        <% } %>
      </ul>
      <ul class="navbar-nav ms-lg-auto mx-3">

        <% if (authUser != null) { %>
        <li class="nav-item disabled">
          <a class="nav-link" href="<c:url value="/log-out"/>">
            Logout
          </a>
        </li>
        <li class="nav-item disabled">
          <a class="nav-link" href="<c:url value="/profile"/>">
            Profile
          </a>
        </li>
        <% } else { %>
        <li class="nav-item disabled">
          <a class="nav-link" href="<c:url value="/authorization"/>">
            Login
          </a>
        </li>
        <% } %>
      </ul>
    </div>
  </nav>
</body>
</html>

