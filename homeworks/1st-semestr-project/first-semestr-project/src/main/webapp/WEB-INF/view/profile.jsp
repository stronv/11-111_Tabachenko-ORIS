<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/view/parts/_header.jsp" %>

<t:mainLayout title="Profile page">
    <div class="container">
        <div class="row justify-content-center align-items-center inner-row">
            <div class="col-md-5">
                <div class="form-box">
                    <div class="form-title">
                        <h2 class="fw-bold mb-3">Change your information here:</h2>
                    </div>
                    <form action="<c:url value="/profile"/>" method="post">
                        <div class="form-floating mb-3">
                            <input name="username" type="text" class="form-control form-control-sm" placeholder="Username" id="floatingUsername">
                            <label for="floatingUsername">Username</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input name="email" type="email" class="form-control form-control-sm" placeholder="Email" id="floatingEmail">
                            <label for="floatingEmail">Email</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input name="password" type="password" class="form-control form-control-sm" placeholder="Password" id="floatingPass">
                            <label for="floatingPass">Password</label>
                        </div>
                        <div class="mt-3">
<%--                            <button type="submit" class="btn btn-outline-primary"> Submit </button>--%>
                            <input type="submit" class="btn btn-success" value="Submit">
                        </div>
                    </form> <br>
                    <form action="<c:url value="/deleteUser"/>" method="get">
                        <div class="mt-3">
                            <span>You can </span>
                            <input type="submit" class="btn btn-danger" value="Delete your account">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</t:mainLayout>

<%@ include file="/WEB-INF/view/parts/_footer.jsp" %>