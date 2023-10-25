<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="widtd=device-widtd, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body class="container">


<h2 style="text-align: center ; margin-top: 20px">${update}</h2>


<form class="row g-3 needs-validation" novalidate method="post" action="/chat-lieu/update/${cl.id}">
    <label class="form-label">ID</label>
    <input disabled name="id" type="text" class="form-control" value="${cl.id}">
    <br>
    <label for="validationCustom03" class="form-label">Ten chat lieu</label>
    <input type="text" name="tenChatLieu" maxlength="50" class="form-control" id="validationCustom03"
           value="${cl.tenChatLieu}" required>
    <div class="invalid-feedback">
        Please provide a valid name.
    </div>
    <br>
    <p style="color: red">${errorsUpdate}</p>
    <button class="btn btn-outline-success" type="submit">Update</button>
</form>
<br>
<br>
<button class="btn btn-outline-success" type="button"><a class="navbar-brand" href="/chat-lieu/form-add">Add</a>
</button>
<button class="btn btn-outline-success"><a class="navbar-brand" href="/chat-lieu/index">Load</a></button>
<br>
<br>
<nav class="navbar bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand">Tim Kiem</a>
        <form class="d-flex" role="search" method="get" action="/chat-lieu/search">
            <input name="tenChatLieu" class="form-control me-2" type="search" placeholder="Search" aria-label="Search"
                   value="${param.tenChatLieu}" required>
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
    </div>
</nav>

<br>
<H1 style="text-align: center ; color: #198754">Danh Sach Chat Lieu</H1>
<table class="table table-hover">
    <tdead>

        <tr>

            <td scope="col">ID</td>
            <td scope="col">Tên chất liệu</td>
            <td scope="col">Chuc Nang</td>
        </tr>
    </tdead>
    <tbody>
    <c:forEach items="${listCl}" var="cl">
    <tr>

        <td scope="row">${cl.id}</td>
        <td scope="row">${cl.tenChatLieu}</td>
        <td scope="row">
            <button class="btn btn-outline-success"><a class="navbar-brand" href="/chat-lieu/delete/${cl.id}">❌</a>
            </button>
            <button class="btn btn-outline-success"><a class="navbar-brand" href="/chat-lieu/detail/${cl.id}">👁️‍</a>
            </button>
        </td>
    </tr>

    </c:forEach>

</table>


<div style="display: flex; justify-content: space-between ; " >

    <div>
        <c:if test="${page > 0}">
            <button class="btn btn-outline-success" type="button"><a class="navbar-brand" href="?page=${page - 1 }">Trang
                truoc</a></button>
        </c:if>
    </div>
    <div>
        <c:if test="${ empty param.tenChatLieu}">
        <c:forEach begin="0" end="${page1 - 1}" varStatus="i">
            <button class="btn btn-outline-success"><a class="navbar-brand"
                                                       href="/chat-lieu/index?page=${i.index}">${i.index + 1}</a>
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