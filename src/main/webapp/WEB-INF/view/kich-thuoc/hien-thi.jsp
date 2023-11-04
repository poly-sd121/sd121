<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

</head>
<body class="container">
<form action="/kich-thuoc/add" method="post">

    <div>
        <label>Tên Kích Thước</label>
        <input type="text" name="tenKichThuoc">
    </div>
    <div>
        <label>Người Tạo</label>
        <input type="text" name="nguoiTao">
    </div>
    <div>T
        <label>Ngày Tạo</label>
        <input type="date" name="ngayTao">
    </div>
    <div>
        <label>Người Cập Nhật</label>
        <input type="text" name="nguoiCapNhat">
    </div>
    <div>
        <label>Ngày Cập Nhật</label>
        <input type="date" name="ngayCapNhat">
    </div>
    <div>
        <label>Trạng Thái</label>
        <input type="text" name="trangThai">
    </div>
    <div>
        <label>Đã Xóa</label>
        <input type="text" name="daXoa">
    </div>
    <button type="submit" class="btn btn-success">ADD</button>
</form>

</button>
<div class="panel panel-primary">
    <nav class="navbar bg-body-tertiary">
        <div class="container-fluid">
            <a class="navbar-brand">Tim Kiem</a>
            <form class="d-flex" role="search" method="get" action="/kich-thuoc/search">
                <input name="tenKichThuoc" class="form-control me-2" type="search" placeholder="Search"
                       aria-label="Search"
                       value="${param.tenKichThuoc}">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </nav>
    <div class="panel-heading">
        <h3>List Kích Thước </h3>
    </div>
    <div class="panel-body">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>Tên Kích Thước</th>
                <th>Người Tạo</th>
                <th>Ngày Tạo</th>
                <th>Người Cập Nhật</th>
                <th>Ngày Cập Nhật</th>
                <th>Trạng Thái</th>
                <th>Đã Xóa</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listkt}" var="dc">
                <tr>
                    <td>${dc.id}</td>
                    <td>${dc.tenKichThuoc}</td>
                    <td>${dc.nguoiTao}</td>
                    <td>${dc.ngayTao}</td>
                    <td>${dc.nguoiCapNhat}</td>
                    <td>${dc.ngayCapNhat}</td>
                    <td>${dc.trangThai}</td>
                    <td>${dc.daXoa ? 'Đã xóa' : 'Chưa xóa'}</td>
                    <td>
                        <a type="button" class="btn btn-success"
                           href="/kich-thuoc/detail/${dc.id}">👁️‍</a>
                        <a type="button" class="btn btn-warning"
                           href="/kich-thuoc/delete/${dc.id}">❌</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div style="display: flex; justify-content: space-between ; ">
            <div>
                <c:if test="${page > 0}">
                    <button class="btn btn-outline-success" type="button"><a class="navbar-brand"
                                                                             href="?page=${page - 1 }">Trang truoc</a>
                    </button>
                </c:if>
            </div>
            <div>
                <c:catch var ="catchException">
                <c:if test="${ empty param.tenKichThuoc}">
                    <c:forEach begin="0" end="${page1 - 1}" varStatus="i">
                        <button class="btn btn-outline-success"><a class="navbar-brand"
                                                                   href="/kich-thuoc/hien-thi?page=${i.index}">${i.index + 1}</a>
                        </button>
                    </c:forEach>
                </c:if>
                </c:catch>
            </div>
            <div>
                <c:if test="${page < page1 - 1}">
                    <button class="btn btn-outline-success" type="submit"><a class="navbar-brand"
                                                                             href="?page=${page + 1 }">Trang
                        sau</a></button>
                </c:if>
            </div>
        </div>
    </div>
</div>
</body>
</html>
