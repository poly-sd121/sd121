<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 10/25/2023
  Time: 8:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:catch var ="catchException">
<form:form method="POST" action="/loai-san-pham/update" modelAttribute="updloaisp" class="p-3">
    <div>
        <form:input class="form-control" path="id" readonly="true" hidden="true"></form:input>
    </div>
    <div class="mb-3 col-3">
        <label>Tên Loại Sản Phẩm</label>
        <form:input class="form-control" path="tenLoai"></form:input>
    </div>
    <div class="mb-3 col-3">
    <label>Giới Tính SP</label>
    <select name="gioiTinh">
        <option value="Nam">Nam</option>
        <option value="Nữ">Nữ</option>
    </select>
    </div>
    <div class="mb-3 col-3">
        <label>Danh Mục</label>
        <form:input class="form-control" path="danhMuc"></form:input>
    </div>
    <div class="mb-3 col-3">
        <label>Trạng Thái</label>
        <form:input class="form-control" path="trangThai"></form:input>
    </div>
    <div class="mb-3 col-3">
        <form:input class="form-control" path="ngayTao" readonly="true" hidden="true"></form:input>
    </div>
    <button type="submit" class="btn btn-primary">Cập nhật</button>
</form:form>
</c:catch>
<button class="btn btn-outline-success"><a class="navbar-brand" href="/loai-san-pham">Quay lại</a></button>
</body>
</html>
