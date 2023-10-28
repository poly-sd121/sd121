<%--
  Created by IntelliJ IDEA.
  User: Quang Huy
  Date: 10/23/2023
  Time: 10:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/thuong-hieu/update" method="post" modelAttribute="thuongHieu">
    <%--    Ma hang:<form:select path="hangKhachHang">--%>
    <%--    <c:forEach items="${listHangKH}" var="hang">--%>
    <%--        <form:option value="${hang}">${hang.tenHang}</form:option>--%>
    <%--    </c:forEach>--%>
    <%--    </form:select>--%>
    <%--    <br>--%>
    <form:input path="id" style="display: none;" />
    <form:input path="ngayTao" style="display: none;" />
    <form:input path="daXoa" style="display: none;" />
    <form:input path="trangThai" style="display: none;" />
    Ten Thuong Hieu:<form:input path="tenThuongHieu"/> <form:errors path="tenThuongHieu"/>
    <br>
    <%--    So dien thoai: <form:input path="soDienThoai"/> <form:errors path="soDienThoai"/> <span>${eror}</span>--%>
    <%--    <br>--%>
    <%--    Gioi tinh: <form:radiobutton path="gioiTinh" value="true"/>Nam--%>
    <%--    <form:radiobutton path="gioiTinh" value="false" checked="true"/>Nữ--%>
    <form:button>add</form:button>
</form:form>
</body>
</html>
