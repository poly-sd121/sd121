<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/kich-thuoc/update/${dc.id}" method="post">
    add
    <div>
        <label>Tên Kích Thước</label>
        <input type="text" name="tenKichThuoc" value="${dc.tenKichThuoc}">
    </div>
    <div>
        <label>Người Tạo</label>
        <input type="text" name="nguoiTao" value="${dc.nguoiTao}">
    </div>
    <div>T
        <label>Ngày Tạo</label>
        <input type="date" name="ngayTao" value="${dc.ngayTao}">
    </div>
    <div>
        <label>Người Cập Nhật</label>
        <input type="text" name="nguoiCapNhat" value="${dc.nguoiCapNhat}">
    </div>
    <div>
        <label>Ngày Cập Nhật</label>
        <input type="date" name="ngayCapNhat" value="${dc.ngayCapNhat}">
    </div>
    <div>
        <label>Trạng Thái</label>
        <input type="text" name="trangThai" value="${dc.trangThai}">
    </div>
    <div>
        <label>Đã Xóa</label>
        <input type="text" name="daXoa" value="${dc.daXoa ? 'Đã xóa' : 'Chưa xóa'}">
    </div>
    <button type="submit" class="btn btn-success">Update</button>
</form>
</body>
</html>
