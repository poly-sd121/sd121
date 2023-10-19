<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DANG KY</title>
</head>
<body>
<h1>DANG KY</h1>
<form:form method="POST" action="/auth/dang-ky" id="registerForm" modelAttribute="registerForm">
    <form:label for="tenTaiKhoan" path="tenTaiKhoan">Ten tai khoan: </form:label>
    <form:input type="text" name="tenTaiKhoan" path="tenTaiKhoan"/><br/>
    <form:label for="matKhau" path="matKhau">Mat khau: </form:label>
    <form:input type="password" name="matKhau" path="matKhau"/><br/>
    <form:label for="sdt" path="sdt">Sdt: </form:label>
    <form:input type="text" name="sdt" path="sdt"/><br/>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
