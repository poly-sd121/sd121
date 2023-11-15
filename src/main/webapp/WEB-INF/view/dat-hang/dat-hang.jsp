<%--
  Created by IntelliJ IDEA.
  User: Quang Huy
  Date: 11/14/2023
  Time: 10:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${isAuth == true}">

    <div class="main-banner" ><div class="container-fluid">
        <div class="row justify-content-center">
            <div class="col-12 col-lg-11">
                <div class="card card0 rounded-0">
                    <div class="row">
                        <div class="col-md-5 d-md-block d-none p-0 box">
                            <div class="card rounded-0 border-0 card1" id="bill">
                                <h3 id="heading1">Payment Summary</h3>
                                <div class="row">
                                    <div class="col-lg-7 col-8 mt-4 line pl-4">
                                        <h2 class="bill-head">Electronics</h2>
                                        <small class="bill-date">2017 Feb 10 at 10:30 PM</small>
                                    </div>
                                    <div class="col-lg-5 col-4 mt-4">
                                        <h2 class="bill-head px-xl-5 px-lg-4">CAF</h2>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-7 col-8 mt-4 line pl-4">
                                        <h2 class="bill-head">Food</h2>
                                        <small class="bill-date">2017 Feb 25 at 11:30 PM</small>
                                    </div>
                                    <div class="col-lg-5 col-4 mt-4">
                                        <h2 class="bill-head px-xl-5 px-lg-4">JFK</h2>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-7 col-8 mt-4 line pl-4">
                                        <h2 class="bill-head">Grocery</h2>
                                        <small class="bill-date">2017 Mar 17 at 10:45 PM</small><br>
                                        <small class="bill-date">2017 Mar 18 at 11:45 PM</small>
                                    </div>
                                    <div class="col-lg-5 col-4 mt-4">
                                        <h2 class="bill-head px-xl-5 px-lg-4">LHR</h2>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-7 col-8 mt-4 line pl-4">
                                        <h2 class="bill-head">Accessories</h2>
                                        <small class="bill-date">2017 Apr 13 at 05:30 PM</small>
                                    </div>
                                    <div class="col-lg-5 col-4 mt-4">
                                        <h2 class="bill-head px-xl-5 px-lg-4">JFK</h2>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12 red-bg">
                                        <p class="bill-date" id="total-label">Total Price</p>
                                        <h2 class="bill-head" id="total">$ 523.65</h2>
                                        <small class="bill-date" id="total-label">Price includes all taxes</small>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-7 col-sm-12 p-0 box">
                            <div class="card rounded-0 border-0 card2" id="paypage">
                                <div class="form-card">
                                    <h2 id="heading2" class="text-danger">Payment Method</h2>
                                    <div class="radio-group">
                                        <div class='radio' data-value="credit"><img src="https://i.imgur.com/28akQFX.jpg" width="200px" height="60px"></div>
                                        <div class='radio' data-value="paypal"><img src="https://i.imgur.com/5QFsx7K.jpg" width="200px" height="60px"></div>
                                        <br>
                                    </div>

                                    <div class="row">
                                        <div class="col-8 col-md-6">
                                            <label class="pay">Order Date</label>
                                            <div name="cardno" id="cr_no"></div>
                                        </div>
                                        <div class="col-4 col-md-6">
                                            <label class="pay">CVV</label>
                                            <input type="password" name="cvcpwd" placeholder="&#9679;&#9679;&#9679;" class="placeicon" minlength="3" maxlength="3">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <label class="pay">Shipping Address</label>
                                        </div>
                                        <div class="col-md-12">
                                            <textarea  type="text" name="exp" id="exp"></textarea>
                                        </div>
                                    </div>
                                                    <div id="username" style="display: none">${idKh}</div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <input ng-click="order.purchase()" type="submit" value="Purchase" class="btn btn-info placeicon">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div></div>
</c:if>

</body>
</html>
