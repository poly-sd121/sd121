<%@page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Dashboard - SB Admin</title>
    <link
            href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css"
            rel="stylesheet"
    />
    <link href="/assets/css/styles.css" rel="stylesheet" />
    <script
            src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
            crossorigin="anonymous"
    ></script>
</head>
<body class="sb-nav-fixed" >
<div id="layoutSidenav">
    <div id="layoutSidenav_nav">
        <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
            <div class="sb-sidenav-menu">
                <div class="nav">
                    <div class="sb-sidenav-menu-heading">Cửa hàng quần áo</div>
                    <a class="nav-link" href="index.html" style="color: aquamarine">
                        <div class="sb-nav-link-icon">
                            <i class="fas fa-tachometer-alt"></i>
                        </div>
                        Bán hàng
                    </a>
                    <div class="sb-sidenav-menu-heading">Quản lí</div>
                    <a
                            class="nav-link collapsed"
                            href="#"
                            data-bs-toggle="collapse"
                            data-bs-target="#collapseLayouts"
                            aria-expanded="false"
                            aria-controls="collapseLayouts"
                    >
                        <div class="sb-nav-link-icon">
                            <i class="fas fa-columns"></i>
                        </div>
                        Sản phẩm
                        <div class="sb-sidenav-collapse-arrow">
                            <i class="fas fa-angle-down"></i>
                        </div>
                    </a>
                    <div
                            class="collapse"
                            id="collapseLayouts"
                            aria-labelledby="headingOne"
                            data-bs-parent="#sidenavAccordion"
                    >
                        <nav class="sb-sidenav-menu-nested nav">
                            <!--bảng spct-->
                            <a class="nav-link" href="/san-pham-chi-tiet/index"
                            >Sản phẩm chi tiết</a
                            >

                            <a
                                    class="nav-link collapsed"
                                    href="#"
                                    data-bs-toggle="collapse"
                                    data-bs-target="#pagesCollapseAuth"
                                    aria-expanded="false"
                                    aria-controls="pagesCollapseAuth"
                            >
                                Thuộc tính
                                <div class="sb-sidenav-collapse-arrow">
                                    <i class="fas fa-angle-down"></i>
                                </div>
                            </a>
                            <div
                                    class="collapse"
                                    id="pagesCollapseAuth"
                                    aria-labelledby="headingOne"
                                    data-bs-parent="#sidenavAccordionPages"
                            >
                                <nav class="sb-sidenav-menu-nested nav">
                                    <!--bảng sp-->
                                    <a class="nav-link" href="/san-pham/index"
                                    >Sản phẩm
                                    </a>
                                    <!--bảng lsp-->
                                    <a class="nav-link" href=""
                                    >Loại sản phẩm
                                    </a>
                                    <!--bảng kt-->
                                    <a class="nav-link" href=""
                                    >Kích thước
                                    </a>
                                    <!--bảng ms-->
                                    <a class="nav-link" href=""
                                    >Màu Sắc
                                    </a>
                                    <!--bảng cl-->
                                    <a class="nav-link" href=""
                                    >Chất liệu
                                    </a>
                                    <!--bảng th-->
                                    <a class="nav-link" href=""
                                    >Thương Hiệu
                                    </a>
                                </nav>
                            </div>
                        </nav>
                    </div>
                    <a
                            class="nav-link collapsed"
                            href="#"
                            data-bs-toggle="collapse"
                            data-bs-target="#collapsePages"
                            aria-expanded="false"
                            aria-controls="collapsePages"
                    >
                        <div class="sb-nav-link-icon">
                            <i class="fas fa-book-open"></i>
                        </div>
                        Người dùng
                        <div class="sb-sidenav-collapse-arrow">
                            <i class="fas fa-angle-down"></i>
                        </div>
                    </a>
                    <div
                            class="collapse"
                            id="collapsePages"
                            aria-labelledby="headingTwo"
                            data-bs-parent="#sidenavAccordion"
                    >
                        <nav
                                class="sb-sidenav-menu-nested nav accordion"
                                id="sidenavAccordionPages"
                        >
                            <a class="nav-link" href="">Nhân viên</a> <!--bảng nv-->
                            <a class="nav-link" href="">Khách hàng</a> <!--bảng kh-->
                        </nav>
                    </div>
                    <a class="nav-link" href=""> <!--bảng km-->
                        <div class="sb-nav-link-icon">
                            <i class="fas fa-chart-area"></i>
                        </div>
                        Khuyến mại
                    </a>
                    <div class="sb-sidenav-menu-heading">Lịch sử</div>
                    <a class="nav-link" href=""> <!--bảng hd-->
                        <div class="sb-nav-link-icon">
                            <i class="fas fa-chart-area"></i>
                        </div>
                        Hóa đơn
                    </a>
                    <a class="nav-link" href=""> <!--bảng tk-->
                        <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                        Thống kê
                    </a>
                    <div class="sb-sidenav-menu-heading">Setting</div>
                    <a class="nav-link" href=""> <!--bảng hd-->
                        <div class="sb-nav-link-icon">
                            <i class="fas fa-chart-area"></i>
                        </div>
                        LayOut
                    </a>
                </div>
            </div>
        </nav>
    </div>
</div>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"
></script>
<script src="/assets/js/scripts.js"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
        crossorigin="anonymous"
></script>
<script src="/assets/demo/chart-area-demo.js"></script>
<script src="/assets/demo/chart-bar-demo.js"></script>
<script
        src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
        crossorigin="anonymous"
></script>
<script src="js/datatables-simple-demo.js"></script>
</body>
</html>
