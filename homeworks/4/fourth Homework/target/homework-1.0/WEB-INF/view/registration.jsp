<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/view/_header.jsp" %>

<t:mainLayout title="Registration page">

  <div>
    <h3> Hello, register here!</h3>
  </div>

  <form action="<c:url value="registration"/>" method="post">
    <input name="username" type="text" placeholder="Username"<c:if test="${not empty username}"> value="<c:out value="${username}"/>"</c:if>><br>
    <input name="email" type="email" placeholder="email"<c:if test="${not empty email}"> value="<c:out value="${email}"/>"</c:if>><br>
    <input name="password" type="password" placeholder="Password"<c:if test="${not empty password}"> value="<c:out value="${password}"/>"</c:if>><br>
    <input type="submit" value="Register">
  </form>
</t:mainLayout>

<%@ include file="/WEB-INF/view/_footer.jsp" %>
