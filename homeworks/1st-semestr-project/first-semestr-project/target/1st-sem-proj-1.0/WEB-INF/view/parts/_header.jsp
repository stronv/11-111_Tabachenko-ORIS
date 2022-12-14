
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="Models.*" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.GameDao" %>
<%@ page import="util.ConnectionProvider" %>

<% User authUser = (User) request.getSession().getAttribute("authUser");
    if (authUser != null) {
        request.setAttribute("authUser", authUser);
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="<c:url value="/style/css/bootstrap.css"/>">
    <link rel="stylesheet" href="<c:url value="/style/js/bootstrap.bundle.min.js"/>">
    <link rel="stylesheet" href="<c:url value="/style/css/main.css"/>">
</head>
<body>
    <%@ include file="/WEB-INF/view/parts/navbar.jsp" %>
