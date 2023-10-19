<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TRANG CHU</title>
</head>
<body>
<h1>TRANG CHU</h1>
<a href="/auth/dang-nhap">dang nhap</a>
<c:if test="${isAdmin}">
    <a href="/admin">admin page</a>
</c:if>
</body>
</html>