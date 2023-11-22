<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html; ISO-8859-1" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="widtd=device-widtd, initial-scale=1">
    <title>BÁN HÀNG</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body style="background-color: #bebebe; margin: 0; padding: 0">
<header>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <form class="d-flex" role="search">
                    <input class="form-control me-2" type="search" placeholder="Tìm kiếm sản phẩm" aria-label="Search">
                    <button class="btn btn-outline-secondary" type="submit"><svg style="margin-top: -3px" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                        <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                    </svg></button>
                </form>

                <div ><a href="#" style="padding: 5px; margin: 0 8px; background-color: #c7c7c7; text-decoration: none; color: black; border-radius: 5px">Hóa đơn A</a></div>
                <div><a href="#" style="padding: 5px; margin: 0 8px; background-color: #c7c7c7; text-decoration: none; color: black; border-radius: 5px">Hóa đơn B</a></div>

            </div>
            <div><p7><svg style="margin-top: -3px" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
            </svg> Tungf03</p7></div>
        </div>
    </nav>
</header>
<section>
    <div class="row" style="height: calc(100vh - 54px); margin: 0; padding: 10px 0 0 0">
        <div class="col-9" style="height: 100%;">
            <div class="w-100" style="height: 50%; background-color: #ffffff">
                <table class="table w-100">
                    <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>Mark</td>
                        <td>Otto</td>
                        <td>@mdo</td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>Jacob</td>
                        <td>Thornton</td>
                        <td>@fat</td>
                    </tr>
                    <tr>
                        <th scope="row">3</th>
                        <td>Larry</td>
                        <td>the Bird</td>
                        <td>@twitter</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="w-100" style="height: 50%; background-color: #bebebe; position: relative">
                <div style="position: absolute; top: 5px; right: 0; display: flex">
                    <div style="margin-top: 4px">${pageSp.getNumber() + 1}/${pageSp.getTotalPages()}</div>
                    <c:if test="${pageSp.getNumber() + 1 > 1}">
                        <a href="?page=${pageSp.getNumber()}&tenSp=${param.tenSp}" style="padding: 2px 7px 7px 7px; margin: 0 6px 0 12px; border-radius: 5px; background-color: #ffffff; text-decoration: none; color: black"><</a>
                    </c:if>
                    <c:if test="${pageSp.getNumber() + 1 lt pageSp.getTotalPages()}">
                        <a href="?page=${pageSp.getNumber() + 2}&tenSp=${param.tenSp}" style="padding: 2px 7px 7px 7px; border-radius: 5px; background-color: #ffffff; text-decoration: none; color: black">></a>
                    </c:if>
                </div>

                <div class="row" style="height: 100%">

                    <c:if test="${not pageSp.isEmpty()}">
                    <c:forEach items="${pageSp.getContent()}" var="sp">
                        <div class="col-2 pt-5">
                            <div>
                                <div class="card">
                                    <img class="card-img-top" height="150px" src="../../assets/images/imgSp/${sp.getAnh()}" alt="Card image cap">
                                    <div class="card-body">
                                        <p class="card-title" style="font-weight: bolder; max-height: 3em; overflow: hidden; line-height: 1.5em;">${sp.getTen()}</p>
                                        <p class="card-text" style=""> ${sp.getGia()} VNĐ</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    </c:if>

                    <c:if test="${pageSp.isEmpty()}">
                        <h3 style="text-align: center; margin-top: 100px">Không tìm thấy sản phẩm</h3>
                    </c:if>
                </div>
            </div>
        </div>
        <div class="col-3" style="height: 100%; background-color: #ffffff">
            <h5 class="m-3">Hóa Đơn</h5>
            <form>
                <p>Tổng tiền hàng: 900.000VNĐ</p>
                <p>Giảm giá: 0VNĐ</p>
                <p>Thu khác: 0VNĐ</p>
                <p>Khách cần trả: 900.000VNĐ</p>
                <p>Khách trả: 1000.000VNĐ</p>
                <p>Tiền thừa trả khách: 100.000VNĐ</p>
                <p>Ghi chú:</p>
                <button>Chờ Thanh Toán</button>
                <button>Thanh Toán</button>
            </form>
        </div>
    </div>
</section>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>