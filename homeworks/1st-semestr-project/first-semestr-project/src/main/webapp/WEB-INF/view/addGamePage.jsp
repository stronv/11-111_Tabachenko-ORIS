<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/view/parts/_header.jsp" %>

<t:mainLayout title="Add game page">
    <div class="container">
        <div class="input-group-row justify-content-center align-items-center inner-row">
            <div class="col-md-5">
                <div class="form-box">
                    <div class="form-title">
                        <h2 class="fw-bold mb-3">Add new game here:</h2>
                    </div>
                    <form method="post" action="<c:url value="/addGame"/>" enctype="multipart/form-data">
                        <div class="mb-3">
                            <label for="formFile" class="form-label">Choose image: </label>
                            <input class="form-control" name="image" type="file" id="formFile">
                        </div>
                        <div class="form-floating mb-3">
                            <input name="title" type="text" class="form-control form-control-sm"
                                   placeholder="Email" id="floatingTitle">
                            <label for="floatingTitle">Title</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input name="genre" type="text" class="form-control form-control-sm"
                                   placeholder="Genre" id="floatingGenre">
                            <label for="floatingTitle">Genre</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input name="description" type="text" class="form-control form-control-sm"
                                   placeholder="Description" id="floatingDescription">
                            <label for="floatingTitle">Description</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input name="price" type="text" class="form-control form-control-sm"
                                   placeholder="Description" id="floatingPrice">
                            <label for="floatingTitle">Price</label>
                        </div>
                        <div class="mt-3">
                            <button type="submit" class="btn btn-primary"> Submit </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</t:mainLayout>

<%@ include file="/WEB-INF/view/parts/_footer.jsp" %>