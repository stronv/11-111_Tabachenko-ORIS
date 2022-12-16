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
    <div class="card-header my-3 h2">Action Games:</div>
    <div style="display: flex; flex-wrap: wrap; justify-content: space-evenly">
      <c:forEach items="${actionGames}" var="game">
        <div class="card-deck">
          <div class="row g-0">
            <form action="<c:url value="/game-page"/>" method="get">
              <div class="card" style="width: 250px; height: 400px;">
                <img src="images/${game.getImageName()}" class="card-img-top" alt="...">
                <div class="card-body">
                  <h5 class="card-title">${game.getTitle()}</h5>
                  <p class="card-text text-truncate">${game.getDescription()}</p>
                  <button value="button" class="btn btn-outline-secondary btn-sm"> More </button>
                  <input type="hidden" name="id" value="${game.getId()}">
                </div>
              </div>
            </form>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>
  <div class="container">
    <div class="card-header my-3 h2">Adventure Games:</div>
    <div style="display: flex; flex-wrap: wrap; justify-content: space-evenly">
      <c:forEach items="${adventureGames}" var="game">
        <div class="card-deck">
          <div class="row g-0">
            <form action="<c:url value="/game-page"/>" method="get">
              <div class="card" style="width: 250px; height: 400px;">
                <img src="images/${game.getImageName()}" class="card-img-top" alt="...">
                <div class="card-body">
                  <h5 class="card-title">${game.getTitle()}</h5>
                  <p class="card-text text-truncate">${game.getDescription()}</p>
                  <button value="button" class="btn btn-outline-secondary btn-sm"> More </button>
                  <input type="hidden" name="id" value="${game.getId()}">
                </div>
              </div>
            </form>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>
  <div class="container">
    <div class="card-header my-3 h2">Role Play Games:</div>
    <div style="display: flex; flex-wrap: wrap; justify-content: space-evenly">
      <c:forEach items="${rpgGames}" var="game">
        <div class="card-deck">
          <div class="row g-0">
            <form action="<c:url value="/game-page"/>" method="get">
              <div class="card" style="width: 250px; height: 400px;">
                <img src="images/${game.getImageName()}" class="card-img-top" alt="...">
                <div class="card-body">
                  <h5 class="card-title">${game.getTitle()}</h5>
                  <p class="card-text text-truncate">${game.getDescription()}</p>
                  <button value="button" class="btn btn-outline-secondary btn-sm"> More </button>
                  <input type="hidden" name="id" value="${game.getId()}">
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

