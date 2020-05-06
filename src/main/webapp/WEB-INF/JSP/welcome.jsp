<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create an account</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">

   <form:form method="POST" modelAttribute="userForm" class="form-signin">
            <h2 class="form-signin-heading">Create your account</h2>
            <spring:bind path="username">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="username" class="form-control" placeholder="Username"
                                autofocus="true"></form:input>

        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <h2>Welcome ${pageContext.request.userPrincipal.name} | <button class="btn btn-outline-danger" type="submit" form="logoutForm" value="Log out">log out</button></h2>
    </c:if>
    </form>

              <div class="form-group" style="margin:35px 0px">
                <label for="exampleInputEmail1">Title</label>
                <input type="email" class="form-control" id="titleInput" aria-describedby="title" placeholder="Enter Title">
                <small id="titlehelp" class="form-text text-muted">Type Title of Sheet</small>
              </div>
              <div class="form-group">
                <label path="body" type="text" for="exampleInputPassword1">Questions (Optional)</label>
                <span type="Question" class="form-control" id="InputQuestion" placeholder="Question">
                 <input type="Question" class="form-control" id="InputQuestion" placeholder="Question">
                  <input type="Question" class="form-control" id="InputQuestion" placeholder="Question">
                   <input type="Question" class="form-control" id="InputQuestion" placeholder="Question">
              </div>

              <div class="form-check">
                <input type="checkbox" class="form-check-input" id="exampleCheck1">
                <label class="form-check-label" for="exampleCheck1">Check me out</label>
              </div>
              <button type="submit" class="btn btn-primary">Submit</button>
            </form>

  </div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
</body>
</html>