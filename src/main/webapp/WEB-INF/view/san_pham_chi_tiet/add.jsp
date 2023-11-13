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

<a href="/san-pham-chi-tiet/index" style="text-decoration: none ;color: black "> ↩ Danh sách sản phẩm chi tiết </a>
<c:if test="${empty spct.id}">

<h2 style="text-align: center ; margin-top: 20px">Thêm sản phẩm chi tiết </h2>
    <p style="color: #1c7430">${pass}</p>
    <form class="row needs-validation" novalidate method="post" action="/san-pham-chi-tiet/add" enctype="multipart/form-data">

    <div class="input-group input-group-sm mb-3">
        <label class="input-group-text">San Pham</label>
        <select name="idSanPham" class="form-select form-select-sm" aria-label="Small select example">
            <c:forEach items="${listSp}" var="sp">
                <option value="${sp.id}" selected>${sp.tenSanPham}</option>
            </c:forEach>
        </select>
    </div>

    <div class="input-group input-group-sm mb-3">
        <label class="input-group-text">Loai San Pham</label>
        <select name="idLoaiSanPham" class="form-select form-select-sm" aria-label="Small select example">
            <c:forEach items="${listLsp}" var="lsp">
                <option value="${lsp.id}" selected>${lsp.tenLoai}</option>
            </c:forEach>
        </select>
    </div>

    <div class="input-group input-group-sm mb-3">
        <label class="input-group-text">Mau Sac</label>
        <select name="idMauSac" class="form-select form-select-sm" aria-label="Small select example">
            <c:forEach items="${listMs}" var="ms">
                <option value="${ms.id}" selected>${ms.tenMauSac}</option>
            </c:forEach>
        </select>
    </div>

    <div class="input-group input-group-sm mb-3">
        <label class="input-group-text">Kich Thuoc</label>
        <select name="idKichThuoc" class="form-select form-select-sm" aria-label="Small select example">
            <c:forEach items="${listKt}" var="kt">
                <option value="${kt.id}" selected>${kt.tenKichThuoc}</option>
            </c:forEach>
        </select>
    </div>

    <div class="input-group input-group-sm mb-3">
        <label class="input-group-text">Thuong Hieu</label>
        <select name="idThuongHieu" class="form-select form-select-sm" aria-label="Small select example">
            <c:forEach items="${listTh}" var="th">
                <option value="${th.id}" selected>${th.tenThuongHieu}</option>
            </c:forEach>
        </select>
    </div>


    <div class="input-group input-group-sm mb-3">
        <label class="input-group-text">Chat Lieu</label>
        <select name="idChatLieu" class="form-select form-select-sm" aria-label="Small select example">
            <c:forEach items="${listCl}" var="cl">
                <option value="${cl.id}" selected>${cl.tenChatLieu}</option>
            </c:forEach>
        </select>
    </div>


    <div class="input-group input-group-sm mb-3">
        <span class="input-group-text" for="validationCustom03" class="form-label">Gia Ban</span>
        <input type="number" name="giaBan" maxlength="50" class="form-control" id="validationCustom03"
               value="${spct.giaBan}" required>
    </div>

    <div class="input-group input-group-sm mb-3">
        <label class="input-group-text" for="validationCustom03" class="form-label">So Luong</label>
        <input type="number" name="soLuong" maxlength="50" class="form-control" id="validationCustom03"
               value="${spct.soLuong}" required>
    </div>

    <div class="input-group input-group-sm mb-3">
        <label class="input-group-text" for="validationCustom03" class="form-label">Mo Ta</label>
        <input type="text" name="moTa" maxlength="50" class="form-control" id="validationCustom03"
               value="${spct.moTa}" required>
    </div>

    <div class="input-group input-group-sm mb-3">
        <label class="input-group-text" for="validationCustom03" class="form-label">Anh</label>
        <input type="file" name="file"  class="form-control"
               value="${paramValues}" >
    </div>

    <c:if test="${not empty errors}">
        <ul>
            <c:forEach var="errors" items="${errors}">
                <span style="color: red ; list-style: none">${errors.defaultMessage } ,</span>
            </c:forEach>
        </ul>
    </c:if>

    <br>
    <button class="btn btn-outline-success" type="submit">Thêm </button>
</form>
</c:if>

<c:if test="${not empty spct.id}">
    <h2 style="text-align: center ; margin-top: 20px">Cập nhât sản phẩm chi tiết </h2>
    <p style="color: #1c7430">${pass}</p>

    <form class="row needs-validation" novalidate method="post" enctype="multipart/form-data"  action="/san-pham-chi-tiet/update/${spct.id}">
    <div class="input-group input-group-sm mb-3">
        <label class="input-group-text">ID</label>
        <input disabled name="id" type="text" class="form-control" value=" ID : ${spct.id}">
        <br>
    </div>

    <div class="input-group input-group-sm mb-3">
        <label class="input-group-text">San Pham</label>
        <select name="idSanPham" class="form-select form-select-sm" aria-label="Small select example">
            <c:forEach items="${listSp}" var="sp">
                <option  ${spct.idSanPham.tenSanPham == sp.tenSanPham ? 'selected' : ''}  value="${sp.id}" >${sp.tenSanPham}</option>
            </c:forEach>
        </select>
    </div>

    <div class="input-group input-group-sm mb-3">
        <label class="input-group-text">Loai San Pham</label>
        <select name="idLoaiSanPham" class="form-select form-select-sm" aria-label="Small select example">
            <c:forEach items="${listLsp}" var="lsp">
                <option  ${spct.idLoaiSanPham.tenLoai == lsp.tenLoai ? 'selected' : ''} value="${lsp.id}" >${lsp.tenLoai}</option>
            </c:forEach>
        </select>
    </div>

    <div class="input-group input-group-sm mb-3">
        <label class="input-group-text">Mau Sac</label>
        <select name="idMauSac" class="form-select form-select-sm" aria-label="Small select example">
            <c:forEach items="${listMs}" var="ms">
                <option value="${ms.id}"  ${spct.idMauSac.tenMauSac == ms.tenMauSac ? 'selected' : ''}>${ms.tenMauSac}</option>
            </c:forEach>
        </select>
    </div>

    <div class="input-group input-group-sm mb-3">
        <label class="input-group-text">Kich Thuoc</label>
        <select name="idKichThuoc" class="form-select form-select-sm" aria-label="Small select example">
            <c:forEach items="${listKt}" var="kt">
                <option value="${kt.id}"  ${spct.idKichThuoc.tenKichThuoc == kt.tenKichThuoc ? 'selected' : ''}>${kt.tenKichThuoc}</option>
            </c:forEach>
        </select>
    </div>

    <div class="input-group input-group-sm mb-3">
        <label class="input-group-text">Thuong Hieu</label>
        <select name="idThuongHieu" class="form-select form-select-sm" aria-label="Small select example">
            <c:forEach items="${listTh}" var="th">
                <option value="${th.id}"  ${spct.idThuongHieu.tenThuongHieu == th.tenThuongHieu ? 'selected' : ''}>${th.tenThuongHieu}</option>
            </c:forEach>
        </select>
    </div>


    <div class="input-group input-group-sm mb-3">
        <label class="input-group-text">Chat Lieu</label>
        <select name="idChatLieu" class="form-select form-select-sm" aria-label="Small select example">
            <c:forEach items="${listCl}" var="cl">
                <option value="${cl.id}" ${spct.idChatLieu.tenChatLieu == cl.tenChatLieu ? 'selected' : ''}>${cl.tenChatLieu}</option>
            </c:forEach>
        </select>
    </div>

    <div class="input-group input-group-sm mb-3">
        <span class="input-group-text" for="validationCustom03" class="form-label">Gia Ban</span>
        <input type="number" name="giaBan" maxlength="50" class="form-control" id="validationCustom03"
               value="${spct.giaBan}" required>
    </div>

    <div class="input-group input-group-sm mb-3">
        <label class="input-group-text" for="validationCustom03" class="form-label">So Luong</label>
        <input type="number" name="soLuong" maxlength="50" class="form-control" id="validationCustom03"
               value="${spct.soLuong}" required>
    </div>

    <div class="input-group input-group-sm mb-3">
        <label class="input-group-text" for="validationCustom03" class="form-label">Mo Ta</label>
        <input type="text" name="moTa" maxlength="50" class="form-control" id="validationCustom03"
               value="${spct.moTa}" required>
    </div>



        <div class="input-group input-group-sm mb-3">
            <label class="input-group-text" for="validationCustom03" class="form-label">Anh</label>
            <input type="file" name="file"  class="form-control" >
        </div>


        <c:if test="${not empty errors}">
            <ul>
                <c:forEach var="errors" items="${errors}">
                    <span style="color: red ; list-style: none">${errors.defaultMessage } ,</span>
                </c:forEach>
            </ul>
        </c:if>

        <img  style="height: 1.9rem ; position: absolute; width: 3.5rem"  id="anh" onclick="phongToAnh()" onmouseout="phongNhoAnh()" src="${spct.anhSanPham}">

    <br>
    <button class="btn btn-outline-success" type="submit" onclick="confirmAction()">Cập nhật </button>
</form>
</c:if>



<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"></script>

<script>
    (() => {
        'use strict'

        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        const forms = document.querySelectorAll('.needs-validation')

        // Loop over them and prevent submission
        Array.from(forms).forEach(form => {
            form.addEventListener('submit', event => {
                if (!form.checkValidity()) {
                    event.preventDefault()
                    event.stopPropagation()
                }

                form.classList.add('was-validated')
            }, false)
        })
    })()
</script>
<script>
    function phongToAnh() {
        var anh = document.getElementById("anh");
        // Thay đổi kích thước của ảnh khi con trỏ chuột vào
        anh.style.width = "20rem"; // Ví dụ phóng to ảnh lên gấp đôi kích thước ban đầu
        anh.style.height = "auto"; // Đảm bảo tỉ lệ hình ảnh không bị biến dạng
    }

    function phongNhoAnh() {
        var anh = document.getElementById("anh");
        // Đặt lại kích thước ảnh khi con trỏ chuột rời khỏi
        anh.style.width = "3.5rem"; // Đặt lại kích thước ban đầu của ảnh
        anh.style.height = "1.9rem";
    }

</script>
<script>
    function confirmAction() {
        var xacNhan = confirm("Bạn có chắc chắn muốn cập nhật ?");
        if (xacNhan) {

        } else {
            // Nếu người dùng chọn "Cancel"
            event.preventDefault()
        }
    }
</script>

</body>
</html>