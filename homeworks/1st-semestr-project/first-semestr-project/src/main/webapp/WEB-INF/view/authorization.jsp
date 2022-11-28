<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/view/_header.jsp" %>

<t:mainLayout title="Authorization page">
    <div class="authorizationForm">
        <form action="<c:url value="authorization"/>" method="post">
            <div class="logo">
                <p>Sign in to GameShop with one of your  accounts. </p><br>
<%--                <img src="assets/images/game-shop-logo.png" height="400" width="400"><br>--%>
                <input name="email" type="email" placeholder="email"><br>
                <input name="password" type="password" placeholder="password"><br>
                <input name="nextButton" type="submit" value="Next"><br>
                <input name="createAccount" type="submit" value="Create New Account">
            </div>
        </form>
    </div>
</t:mainLayout>

<%@ include file="/WEB-INF/view/_footer.jsp" %>