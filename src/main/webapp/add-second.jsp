<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>
    <form action="/addSecond" method="post">
        <input name="name" required placeholder="Name">
        <input type="number" name="age" required placeholder="Age">
        <input type="submit" value="Add User">
    </form>
</body>
</html>
