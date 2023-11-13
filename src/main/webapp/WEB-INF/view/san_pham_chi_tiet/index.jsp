<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html; ISO-8859-1" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="widtd=device-widtd, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body class="container" style=" padding: 2rem">

<div style="display: flex ; flex-direction: row ; justify-content: space-between">
    <div>
        <form class="d-flex" style="flex-direction: row; gap: 0.5rem ; height: 2rem ;align-items: center"
              role="search" method="get" action="/san-pham-chi-tiet/search">
            Tìm kiếm <input name="keyword" type="search" placeholder="Tìm kiếm " aria-label="Search"
                            value="${param.keyword}" required>
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
    </div>
    <div>
        <form method="get" action="/san-pham-chi-tiet/search2"
              style="display: flex; flex-direction: row; gap: 0.5rem ; height: 2rem ;align-items: center">
            Giá bán từ <input type="number" name="keyword2" placeholder="Bắt đầu " aria-label="Search"
                              style="width: 8rem" value="${param.keyword2}" required>
            đến <input type="number" placeholder="Kết thúc " name="keyword3" aria-label="Search"
                       style="width: 8rem" value="${param.keyword3}" required>

            <button style=" display: flex ; align-items: center" class="btn btn-outline-success" type="submit">Search
            </button>
        </form>
    </div>
</div>
<br>
<div style="display: flex ; flex-direction: row ; justify-content: space-between">
<div class="d-flex " style="gap: 1rem">

    <button class="btn btn-outline-success" type="button"><a class="navbar-brand"
                                                             href="/san-pham-chi-tiet/form-add">Thêm </a>
    </button>
    <button class="btn btn-outline-success"><a class="navbar-brand" href="/san-pham-chi-tiet/index">Load</a></button>

</div>
<div class="d-flex " style="gap: 1rem">
    <form class="d-flex" role="search" method="get" action="/san-pham-chi-tiet/search3">
        <button class="btn btn-outline-success" type="submit">Sản phẩm đã hết</button>
    </form>
    <button class="btn btn-outline-success"><a class="navbar-brand" href="/san-pham-chi-tiet/fileAnh">File Images</a>
    </button>

</div>
</div>

<br>
<H1 style="text-align: center ; color: #198754">Danh sách sản phẩm chi tiết </H1>
<c:if test="${ empty param.keyword}">
    <span>Trang ${page + 1}/${page1 }</span>
</c:if>
<table class="table table-hover">
    <tdead>

        <tr>

            <td scope="col">ID</td>
            <td scope="col">Tên sản phẩm</td>
            <td scope="col">Loại sản phẩm</td>
            <td scope="col">Màu sắc</td>
            <td scope="col">Kích thước</td>
            <td scope="col">Thương hiệu</td>
            <td scope="col"> Chất liệu</td>
            <td scope="col"> Giá bán</td>
            <td scope="col"> Số lượng</td>
            <td scope="col"> Mô tả</td>
            <td scope="col"> Ảnh</td>
            <td scope="col">Chức năng</td>
        </tr>
    </tdead>
    <tbody>
    <c:forEach items="${listSpct}" var="spct">
    <tr>

        <td scope="row">${spct.id}</td>
        <td scope="row">${spct.idSanPham.tenSanPham}</td>
        <td scope="row">${spct.idLoaiSanPham.tenLoai}</td>
        <td scope="row">${spct.idMauSac.tenMauSac}</td>
        <td scope="row">${spct.idKichThuoc.tenKichThuoc}</td>
        <td scope="row">${spct.idThuongHieu.tenThuongHieu}</td>
        <td scope="row">${spct.idChatLieu.tenChatLieu}</td>
        <td scope="row">${spct.giaBan}</td>
        <td scope="row">${spct.soLuong}</td>
        <td scope="row">${spct.moTa}</td>
        <td scope="row"><a href="/san-pham-chi-tiet/detail/${spct.id}"><img style="width: 6rem ;height: 8rem"
                                                                            src="${spct.anhSanPham}"></a>
        </td>

        <td scope="row">
            <button class="btn btn-outline-success"><a onclick="confirmAction()" class="navbar-brand"
                                                       href="/san-pham-chi-tiet/delete/${spct.id}">❌</a>
            </button>
            <button class="btn btn-outline-success"><a class="navbar-brand" href="/san-pham-chi-tiet/detail/${spct.id}">👁️‍</a>
            </button>
        </td>

    </tr>
    </c:forEach>

</table>


<div style="display: flex; justify-content: space-between ; ">

    <div>
        <c:if test="${page > 0}">
            <button class="btn btn-outline-success" type="button"><a class="navbar-brand" href="?page=${page - 1 }">Trang
                truoc</a></button>
        </c:if>
    </div>
    <div>
        <c:if test="${ empty param.keyword}">
            <c:forEach begin="0" end="${page1 - 1}" varStatus="i">
                <button class="btn btn-outline-success"><a class="navbar-brand"
                                                           href="/san-pham-chi-tiet/index?page=${i.index}">${i.index + 1}</a>
                </button>
            </c:forEach>
        </c:if>
    </div>


    <div>
        <c:if test="${page < page1 - 1}">
            <button class="btn btn-outline-success" type="submit"><a class="navbar-brand" href="?page=${page + 1 }">Trang
                sau</a></button>
        </c:if>
    </div>
</div>

<script>
    function confirmAction() {
        var xacNhan = confirm("Bạn có chắc chắn muốn xóa sản phẩm này ?");
        if (xacNhan) {
            alert("Xóa thành công ! ")
        } else {
            // Nếu người dùng chọn "Cancel"
            event.preventDefault()
        }
    }
</script>
<style>
    .btn {
        --bs-btn-padding-x: 0.5rem;
        --bs-btn-padding-y: 0.1rem;
    }

    .navbar > .container-fluid {
        justify-content: flex-start;
    }
</style>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"></script>

</body>
</html>