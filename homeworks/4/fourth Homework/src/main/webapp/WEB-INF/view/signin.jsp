<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/view/_header.jsp" %>

<t:mainLayout title="Signin page">
  <form action="<c:url value="registration"/>" method="post">
    <input name="email" type="email" placeholder="E-MAIL"<c:if test="${not empty email}"> value="<c:out value="${email}"/>"</c:if>><br>
    <input name="password" type="password" placeholder="Password"><br>
    <input type="submit" value="Sing In">
  </form>
</t:mainLayout>

<%@ include file="/WEB-INF/view/_footer.jsp" %>