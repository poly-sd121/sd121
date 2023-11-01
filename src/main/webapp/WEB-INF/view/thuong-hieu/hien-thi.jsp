<%--
  Created by IntelliJ IDEA.
  User: Quang Huy
  Date: 10/23/2023
  Time: 8:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

</head>
<body>
<h2>Quan ly thuong hieu</h2>
<form action="/thuong-hieu/tim-kiem" method="get">
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Ten Thuong Hieu</label>
        <input type="text" class="form-control" name="ten" id="exampleInputEmail1" aria-describedby="emailHelp">
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<form:form action="/thuong-hieu/add" method="post" modelAttribute="thuongHieu">
    Ten Thuong Hieu:<form:input path="tenThuongHieu"/> <form:errors path="tenThuongHieu"/>
    <br>
    <form:button>add</form:button>
</form:form>

<h3>Danh sach</h3>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Ten Thương Hiệu</th>
        <th scope="col">Người Tạo</th>
        <th scope="col">Ngày tạo</th>
        <th scope="col">Ngày sửa</th>
        <th scope="col">Xóa</th>
        <th scope="col">AC</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${listThuongHieu.content != null}">
        <c:forEach items="${listThuongHieu.content}" var="kh" varStatus="stt">
            <tr>
                <th scope="row">${stt.index+1}</th>
                <td>${kh.tenThuongHieu}</td>
                <td>${kh.nguoiTao}</td>
                <td>${kh.ngayTao}</td>
                <td>${kh.ngayCapNhat}</td>
                <td>${kh.daXoa}</td>
                <td><a href="/thuong-hieu/delete/${kh.id}">delete</a> <a href="/thuong-hieu/update/${kh.id}">update</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
    <c:if test="${listThuongHieuTK.content  != null}">
        <c:forEach items="${listThuongHieuTK.content}" var="kh" varStatus="stt">
            <tr>
                <th scope="row">${stt.index+1}</th>
                <td>${kh.tenThuongHieu}</td>
                <td>${kh.nguoiTao}</td>
                <td>${kh.ngayTao}</td>
                <td>${kh.ngayCapNhat}</td>
                <td>${kh.daXoa}</td>
                <td><a href="/thuong-hieu/delete/${kh.id}">delete</a>
                    <a href="/thuong-hieu/update/${kh.id}">update</a></td>
            </tr>
        </c:forEach>
    </c:if>


    </tbody>
</table>
<c:if test="${listThuongHieuTK.totalPages >= 0}">
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <c:forEach begin="0" end="${listThuongHieuTK.totalPages - 1}" varStatus="lopp">
                <li class="page-item">
                    <a class="page-link" href="/thuong-hieu/tim-kiem?ten=${tentk}&page=${lopp.begin + lopp.count - 1}">
                            ${lopp.begin + lopp.count}
                    </a>
                </li>
            </c:forEach>
        </ul>
    </nav>
</c:if>
<c:if test="${listThuongHieu.content != null}">
    <nav aria-label="Page navigation example">
        <ul class="pagination">

            <c:forEach begin="0" end="${listThuongHieu.totalPages -1}" varStatus="lopp">
                <li class="page-item"><a class="page-link"
                                         href="/thuong-hieu/hien-thi?page=${lopp.begin+lopp.count-1}">${lopp.begin+lopp.count}</a>
                </li>
            </c:forEach>

        </ul>
    </nav>
</c:if>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>

</body>
</html>
