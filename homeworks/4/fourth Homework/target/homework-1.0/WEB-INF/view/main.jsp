<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/view/_header.jsp" %>

<t:mainLayout title="Main page">
    <form action="<c:url value="registration"/>" method="get">
        <input type="submit" value="Registration">
    </form>

    <form action="<c:url value="signin"/>" method="get">
        <input type="submit" value="Sign in">
    </form>

</t:mainLayout>

<%@ include file="/WEB-INF/view/_footer.jsp" %>
