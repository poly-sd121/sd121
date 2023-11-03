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
<body class="container" >


<h2 style="text-align: center ; margin-top: 20px">Add Chi tiet san pham</h2>


<form class="row needs-validation" novalidate method="post" action="/san-pham-chi-tiet/add">

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
        <span class="input-group-text" id="inputGroup-sizing-sm">Gia Nhap</span>
        <input type="text" name="giaNhap" maxlength="50" class="form-control" id="validationCustom03"
               value="${spct.giaNhap}" required>
    </div>

    <div class="input-group input-group-sm mb-3">
        <span class="input-group-text" for="validationCustom03" class="form-label">Gia Ban</span>
        <input type="text" name="giaBan" maxlength="50" class="form-control" id="validationCustom03"
               value="${spct.giaBan}" required>
    </div>

    <div class="input-group input-group-sm mb-3">
        <label class="input-group-text" for="validationCustom03" class="form-label">So Luong</label>
        <input type="text" name="soLuong" maxlength="50" class="form-control" id="validationCustom03"
               value="${spct.soLuong}" required>
    </div>

    <div class="input-group input-group-sm mb-3">
        <label class="input-group-text" for="validationCustom03" class="form-label">Mo Ta</label>
        <input type="text" name="moTa" maxlength="50" class="form-control" id="validationCustom03"
               value="${spct.moTa}" required>
    </div>

    <div class="input-group input-group-sm mb-3">
        <label class="input-group-text" for="validationCustom03" class="form-label">Anh</label>
        <input type="text" name="linkAnh" maxlength="50" class="form-control" id="validationCustom03"
               value="${spct.linkAnh}" required>
    </div>


    <div class="invalid-feedback">
        Please provide a valid Anh
    </div>
    <br>
    <button class="btn btn-outline-success" type="submit">Add</button>
</form>


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
</body>
</html>