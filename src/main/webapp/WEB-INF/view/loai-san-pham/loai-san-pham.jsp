<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="widtd=device-widtd, initial-scale=1">
  <title>Loại Sản Phẩm</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body class="container">
<nav class="navbar bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand">Tìm Kiếm</a>
    <form class="d-flex" role="search" method="get" action="/loai-san-pham/search">
      <input name="tenLoai" class="form-control me-2" type="search" placeholder="Search" aria-label="Search" required>
      <button class="btn btn-outline-success" type="submit">Search</button>
    </form>
  </div>
</nav>
<br>
<form:form method="POST" action="/loai-san-pham/add" modelAttribute="loaisp">
  <label>Tên Loại Sản Phẩm: </label>
  <input type="text" name="tenLoai" required/><br/>
  <input type="submit" value="Thêm Sản Phẩm"/>
</form:form>
<br>
<br>
<H1 style="text-align: center ; color:#b71540 ">Danh Sách Loại Sản Phẩm</H1>
<table class="table table-hover">
  <tdead>

    <tr>

      <td scope="col">Id</td>
      <td scope="col">Tên Loại</td>
      <td scope="col">Người Tạo</td>
      <td scope="col">Ngày Tạo</td>
      <td scope="col">Ngày Cập Nhật</td>
      <td scope="col">Người Cập Nhật</td>
      <td scope="col">Trạng Thái</td>
      <td scope="col">Thao Tác</td>
    </tr>
  </tdead>
  <tbody>
  <c:forEach items="${lstloaisp}" var="category">
  <tr>

    <td scope="row">${category.id}</td>
    <td scope="row">${category.tenLoai}</td>
    <td scope="row">${category.nguoiTao}</td>
    <td scope="row">${category.ngayTao}</td>
    <td scope="row">${category.ngayCapNhat}</td>
    <td scope="row">${category.nguoiCapNhat}</td>
    <td scope="row">${category.trangThai}</td>
    <td scope="row">
      <button class="btn btn-outline-success"><a class="navbar-brand" href="/loai-san-pham/update/${category.id}">Cập Nhật</a>
      </button>
      <button class="btn btn-outline-success"><a class="navbar-brand" href="/loai-san-pham/delete/${category.id}">Xóa</a>
      </button>
    </td>
  </tr>

  </c:forEach>

</table>


<div style="display: flex; justify-content: space-between ; " >

  <div>
    <c:if test="${page > 0}">
      <button class="btn btn-outline-success" type="button"><a class="navbar-brand" href="?page=${page - 1 }">Trang
        trước</a></button>
    </c:if>
  </div>
  <div>
<c:catch var ="catchException">
    <c:if test="${empty param.tenLoai}">
      <c:forEach begin="0" end="${page1 - 1}" varStatus="i">
        <button class="btn btn-outline-success"><a class="navbar-brand"
                                                   href="/loai-san-pham?page=${i.index}">${i.index + 1}</a>
        </button>
      </c:forEach>
    </c:if>
</c:catch>
  </div>
  <div>
    <c:if test="${page < page1 - 1}">
      <button class="btn btn-outline-success" type="submit"><a class="navbar-brand" href="?page=${page + 1 }">Trang
        sau</a></button>
    </c:if>
  </div>
</div>
</body>
</html>
