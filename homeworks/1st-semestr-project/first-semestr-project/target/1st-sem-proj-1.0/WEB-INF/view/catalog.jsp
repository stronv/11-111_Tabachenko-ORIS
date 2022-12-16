<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/view/parts/_header.jsp" %>

<style>
    .card:hover {
        box-shadow: 20px 20px 80px -44px #0c4128;
        transition: .5s ease-in-out;
        cursor: pointer;
    }
</style>

<t:mainLayout title="Catalog page">
    <div class="container">
        <div class="card-header my-3 h2">All products</div>
        <div style="display: flex; flex-wrap: wrap; justify-content: space-evenly">
            <c:forEach items="${games}" var="game">
                <div class="card-deck">
                    <div class="row g-0">

                        <form action="<c:url value="/game-page"/>" method="get">
                            <div class="card m-3" style="max-width: 500px; max-height: 205px;">
                                <div class="row g-0">
                                    <div class="col-md-5">
                                        <img src="images/${game.getImageName()}" class="img-fluid rounded-start" alt="...">
                                    </div>
                                    <div class="col-md-6">
                                        <div class="card-body">
                                            <h5 class="card-title" name="title">${game.getTitle()}</h5>
                                            <p class="card-text text-truncate" name="description">${game.getDescription()}</p>
                                            <p class="card-text" name="price"><small class="text-muted h4">${game.getPrice()} $</small></p>
<%--                                            <button value="button" class="btn btn-success btn-sm"> More </button>--%>
                                            <a href="<c:url value="/game-page?id=${game.getId()}"/>" class="btn btn-success btn-sm" role="button" aria-disabled="true"> more </a>
                                            <input type="hidden" name="id" value="${game.getId()}">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</t:mainLayout>

<%@ include file="/WEB-INF/view/parts/_footer.jsp" %>
