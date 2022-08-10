<%--
  Created by IntelliJ IDEA.
  User: alexz
  Date: 7/25/2022
  Time: 7:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Custom Login Page</title>

    <style>
        .failed{
            color: red;
        }
    </style>
</head>
<body>

<h3>My custom Login Page</h3>

<form:form action="${pageContext.request.contextPath}/authenticateTheUser"
           method="post">

    <c:if test="${param.error != null}">
        <i class="failed">You entered invalid login or password</i>
    </c:if>

    <p>
        Username: <input type="text" name="username">
    </p>
    <p>
        Password: <input type="password" name="password">
    </p>

    <input type="submit" value="Login"/>

</form:form>

</body>
</html>
