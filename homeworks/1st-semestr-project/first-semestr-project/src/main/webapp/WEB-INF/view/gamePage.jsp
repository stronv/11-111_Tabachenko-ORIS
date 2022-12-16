<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/view/parts/_header.jsp" %>

<t:mainLayout title="Main page">

    <div class="card-center" align="center">
        <div class="container">
            <form  action="<c:url value="/add-to-cart"/>" method="get">
                <div class="card" style="width: 30rem; height: auto;">
                    <img class="card-img-top" src="images/${game.getImageName()}" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title" name="title">${game.getTitle()}</h5>
                        <p class="card-text" name="description" align="center">${game.getDescription()}</p>
                        <p class="card-text" name="price"><small class="text-muted h5">${game.getPrice()} $</small></p>

                        <c:if test="${authUser != null}">
<%--                            <a href="<c:url value="/game-page?id=${game.getId()}"/>" class="btn btn-success btn-sm" role="button" aria-disabled="true"> Add to Cart </a>--%>
                            <input type="hidden" name="id" value="${game.getId()}">
                            <input type="submit" class="btn btn-success btn-sm" value="Add to cart">
                        </c:if>
                        <c:if test="${authUser == null}">
                            <div class="mt-3">
                                <span>You must </span>
                                <a href="<c:url value="/authorization"/>">Log in</a>
                            </div>
                        </c:if>
                    </div>
                </div>
            </form>
        </div>
    </div>

</t:mainLayout>

<%@ include file="/WEB-INF/view/parts/_footer.jsp" %>

