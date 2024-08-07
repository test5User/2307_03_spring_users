<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Nane</th>
            <th>Age</th>
            <th>Passport Number</th>
            <th>Passport Expired Data</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.passport.number}</td>
                <td>${user.passport.expired}</td>
                <td>
                    <a href="/delete?id=${user.id}">delete</a>
                    <a href="/upd?id=${user.id}&name=${user.name}&age=${user.age}">update</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
