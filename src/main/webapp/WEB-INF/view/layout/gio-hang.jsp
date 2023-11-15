<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="main-banner" id="top">
  <table id="cart">
    <thead>
      <tr>
        <th class="second">Qty</th>
        <th class="third">Product</th>
        <th class="fourth">Line Total</th>
        <th class="fifth">&nbsp;</th>
      </tr>
    </thead>
    <tbody>
      <!-- shopping cart contents -->
      <tr ng-repeat="item in cart.items" class="productitm">
        <td>
          <input
            ng-change="cart.saveToLocalStorage()"
            ng-model="item.qty"
            type="number"
            value="1"
            min="1"
            max="99"
            class="qtyinput"
          />
        </td>
        <td>{{ item.tenSanPham }}</td>
        <td>{{ item.qty * item.giaBan }}</td>
        <td>
          <span class="remove" ng-click="cart.remove(item.id)"
            ><img src="https://i.imgur.com/h1ldGRr.png" alt="X"
          /></span>
        </td>
      </tr>

      <!--            &lt;!&ndash; tax + subtotal &ndash;&gt;-->
      <!--            <tr class="extracosts">-->
      <!--              <td class="light">Shipping &amp; Tax</td>-->
      <!--              <td colspan="2" class="light"></td>-->
      <!--              <td>$35.00</td>-->
      <!--              <td>&nbsp;</td>-->
      <!--            </tr>-->
      <tr class="totalprice">
        <td class="light">Total:</td>
        <td colspan="2">&nbsp;</td>
        <td colspan="2">
          <span class="thick">{{ cart.amount }}</span>
        </td>
      </tr>

      <!-- checkout btn -->
      <tr class="checkoutrow">
        <td colspan="5" class="checkout">
          <button ng-click="cart.clear()" id="submitbtn">Clear</button>
        </td>
        <a href="/dat-hang" ng-click="cart.dathang(${isAuth})" class="btn btn-primary"> Checkout </a>
      </tr>
    </tbody>
  </table>
</div>
