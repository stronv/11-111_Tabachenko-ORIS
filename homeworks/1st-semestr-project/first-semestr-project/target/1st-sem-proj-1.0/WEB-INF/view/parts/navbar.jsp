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
      <%--Left buttons--%>
      <ul class="navbar-nav">
        <li class="nav-item disabled">
          <a class="nav-link" href="<c:url value="/mainPage"/>">
            Main
          </a>
        </li>
        <li class="nav-item disabled">
          <a class="nav-link" href="<c:url value="/catalog"/>">
            All Games
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


          <%--Right buttons--%>
      <ul class="navbar-nav ms-lg-auto mx-3">
        <c:if test="${authUser != null}">
          <c:if test="${authUser.getRole() == 'admin'}">
            <li class="nav-item disabled">
              <a class="nav-link" href="<c:url value="/addGame"/>">
                Add Game
              </a>
            </li>
          </c:if>
        </c:if>

        <% if (authUser != null) {%>
        <li class="nav-item disabled">
          <a class="nav-link" href="<c:url value="/profile"/>">
            Profile
          </a>
        </li>
        <li class="nav-item disabled">
          <a class="nav-link" href="<c:url value="/log-out"/>">
            Logout
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

