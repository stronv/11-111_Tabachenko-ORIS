<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/view/parts/_header.jsp" %>
<t:mainLayout title="Cart page">
    <div class="container">
        <div class="d-flex py-3">
            <h3>Total price: 100$</h3>
            <a class="mx-2 btn btn-primary" href="#"> Check Out</a>
        </div>
        <table class="table table-light">
            <thead>
                <tr>
                    <th scope="col">Title</th>
                    <th scope="col">Description</th>
                    <th scope="col">Genre</th>
                    <th scope="col">Price</th>
                    <th scope="col">Buy</th>
                    <th scope="col">Cancel</th>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</t:mainLayout>

<%@ include file="/WEB-INF/view/parts/_footer.jsp" %>