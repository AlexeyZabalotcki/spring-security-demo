<%--
  Created by IntelliJ IDEA.
  User: alexz
  Date: 7/25/2022
  Time: 7:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title of homepage</title>
</head>
<body>

<h2>Homepage</h2>

<br>

Welcome to the my homepage!!!

<hr>

<p>
    User: <security:authentication property="principal.username"/>
    <br><br>
    Roles: <security:authentication property="principal.authorities"/>
</p>
<hr>

<security:authorize access="hasRole('ADMIN')">
<p>
    <a href="${pageContext.request.contextPath}/admins">LeaderShip Meeting</a>
    (Only for admins)
</p>
</security:authorize>
<br>
<security:authorize access="hasRole('USERPLUS')">
<p>
    <a href="${pageContext.request.contextPath}/userplus">Upper Users Meeting</a>
    (Only for Upper Users)
</p>
</security:authorize>
<hr>
<br>

<hr>

<form:form action="${pageContext.request.contextPath}/logout"
           method="post">
    <input type="submit" value="Logout"/>

</form:form>
</body>
</html>
