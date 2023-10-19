<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DANG NHAP</title>
</head>
<body>
<h1>DANG NHAP</h1>
<p>New here? Click
    <a href="/auth/dang-ky">here</a> to register.</p>
<form:form action="/login">
    <label for="username">Ten tai khoan: </label>
    <input type="text" name="username" id="username" /><br/>
    <label for="password">Mat khau: </label>
    <input type="password" name="password" id="password" /><br/>
    <input type="submit" value="Dang nhap"/>
</form:form>
</body>
</html>