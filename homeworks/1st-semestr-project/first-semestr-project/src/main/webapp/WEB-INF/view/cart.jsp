<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/view/parts/_header.jsp" %>
<t:mainLayout title="Cart page">
    <div class="container">
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col"></th>
                <th scope="col">Title</th>
                <th scope="col">Description</th>
                <th scope="col">Price</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${cart}" var="item">
                <tr>
                    <th>
                        <img src="images/${item.getImageName()}" style="max-width: 500px; max-height: 205px;" class="img-fluid rounded-start" alt="...">
                    </th>
                    <th class="col-4">${item.getTitle()}</th>
                    <th class="col-9">${item.getDescription()}</th>
                    <th class="col-2">${item.getPrice()} $</th>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</t:mainLayout>

<%@ include file="/WEB-INF/view/parts/_footer.jsp" %>