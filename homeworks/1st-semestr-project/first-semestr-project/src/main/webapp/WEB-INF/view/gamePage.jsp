<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/view/parts/_header.jsp" %>

<t:mainLayout title="Main page">

    <div class="card-center" align="center">
        <div class="container">
            <div class="card" style="width: 30rem; height: auto;">
                <img class="card-img-top" src="images/${game.getImageName()}" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title" name="title">${game.getTitle()}</h5>
                    <p class="card-text" name="description" align="center">${game.getDescription()}</p>
                    <p class="card-text" name="price"><small class="text-muted h5">${game.getPrice()} $</small></p>
                    <a href="#" class="btn btn-success btn-sm" role="button" aria-disabled="true">Add to cart</a>
                </div>
            </div>
        </div>
    </div>

</t:mainLayout>

<%@ include file="/WEB-INF/view/parts/_footer.jsp" %>

