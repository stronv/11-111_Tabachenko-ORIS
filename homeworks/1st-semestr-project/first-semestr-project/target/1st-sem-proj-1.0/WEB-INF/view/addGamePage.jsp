<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/view/parts/_header.jsp" %>

<t:mainLayout title="Add game page">
    <div class="main">
        <form method="post" action="<c:url value="/addGame"/>" enctype="multipart/form-data">
            <input type="file" name="file" placeholder="Put your image here">
            <input type="submit" placeholder="Upload">
        </form>
    </div>

</t:mainLayout>

<%@ include file="/WEB-INF/view/parts/_footer.jsp" %>