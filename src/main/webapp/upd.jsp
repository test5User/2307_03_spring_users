<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update User</title>
</head>
<body>
    <sf:form action="/saveUpd" method="post" modelAttribute="user">
        <sf:input path="id" type="hidden"/><br>
        <sf:input path="name"/><br>
        <sf:input path="age"/><br>
        <input type="submit" value="Save">
    </sf:form>
</body>
</html>
