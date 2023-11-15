<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="main-banner" id="top">
  <table class="Table">
    <tbody>
    <tr class="line head">
      <td class="wd55 Table-product">
        <b>Tên sản phẩm</b>
      </td>
      <td class="wd15 Table-price price_title text_left"><b>Giá</b></td>
      <td class="wd15 Table-quantity quantity_title"><b>Số lượng</b></td>
      <td class="wd15 Table-price"><b>Xóa</b></td>
      <td class="wd15 Table-price">
        <b>Tổng tiền</b>
      </td>

    </tr>

    <!-- Products -->
    <tr class="line" ng-repeat="item in cart.items">
      <td class="wd55 Table-product">
        {{ item.tenSanPham }}<br />
        <del class="h-color-mid">RRP£54.00</del>&nbsp;
        <b class="h-color-error">You save £75.60</b>
      </td>
      <td class="wd15 Table-price dt">
        {{item.giaBan}}
        <br />
      </td>
      <td class="wd15 Table-quantity">  <input
              ng-change="cart.saveToLocalStorage()"
              ng-model="item.qty"
              type="number"
              value="1"
              min="1"
              max="99"
              class="qtyinput"
      /></td>
      <td  class="wd15 Table-price">
          <span class="remove" ng-click="cart.remove(item.id)"
          ><img src="https://i.imgur.com/h1ldGRr.png" alt="X"
          /></span>
      </td>
      <td class="wd15 Table-price">{{ item.qty * item.giaBan }}</td>

    </tr>

    <tr class="line head">
      <td class="wd55 Table-product">
        <b>Tổng tiền tất cả sản phẩm</b>
      </td>
      <td class="wd15 Table-price price_title text_left"><b></b></td>
      <td class="wd15 Table-quantity quantity_title"><b></b></td>
      <td class="wd15 Table-price"><b></b></td>
      <td class="wd15 Table-price">
        <b>{{cart.amount}}</b>
      </td>
    </tr>
    </tbody>
  </table>
  <button ng-click="cart.clear()" class="custom-btn btn-5"><span>Xóa tât cả sản phẩm</span></button>
  <button  class="custom-btn btn-14" ng-click="cart.dathang(${isAuth})">
    Mua Hàng
  </button>

</div>