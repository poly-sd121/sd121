const app = angular.module("shopping-cart-app", []);
app.controller("shopping-cart-ctrl", function ($scope, $http) {
  $scope.cart = {
    items: [],

    add(id) {
      console.log("id: " + id);
      var item = this.items.find((item) => item.id === id);
      if (item) {
        item.qty++;
        this.saveToLocalStorage();
//        alert("Thêm thành công vào giỏ hàng")
      } else {
        $http.get(`/rest/sanphamchitiet/${id}`).then((reponse) => {
          console.log("abc: " + JSON.stringify(reponse.data));
          reponse.data.qty = 1;
          this.items.push(reponse.data);
//          alert("Thêm thành công vào giỏ hàng")
          this.saveToLocalStorage();
        });
      }
    },
    dathang(isAutho) {

      if (this.items.length === 0) {
        console.log("dìauidoasufois")
        alert("Giỏ hàng trống, không thể đặt hàng.");
      } else {
        if (isAutho) {
          window.location.href = "/dat-hang";
        } else {
          alert("Không phải khách hàng");
        }
      }
    },
    clear1() {
               this.items = [];
                     console.log(this.items);
                     this.saveToLocalStorage();
            },
    remove(id) {
      var index = this.items.findIndex((item) => item.id === id);
      this.items.splice(index, 1);
      this.saveToLocalStorage();
    },
    clear() {
      if (confirm("Bạn có muốn xóa tất cả sản phẩm trong giỏ không?")) {
       $scope.cart.clear1();
      } else {

      }
    },

    get amount() {
      return this.items
        .map((item) => item.qty * item.giaBan)
        .reduce((total, qty) => (total += qty), 0);
    },
    saveToLocalStorage() {
      var json = JSON.stringify(angular.copy(this.items));
      localStorage.setItem("cart", json);
    },
    loadFromLocalStorage() {
      var json = localStorage.getItem("cart");
      this.items = json ? JSON.parse(json) : [];
    },
  };

  $scope.cart.loadFromLocalStorage();

  $scope.order = {
    idKhachHang: { id: $("#username").text() },
    get gioHangChiTiets() {
      return $scope.cart.items.map((item) => {
        return {
          idSanPhamChiTiet: { id: item.id },
          soLuong: item.qty,
        };
      });
    },
    purchase() {
      var order = angular.copy(this);
      console.log(order);
      $http
        .post("/rest/gio-hang", order)
        .then((res) => {
          alert("dat hang thanh cong");
          $scope.cart.clear1();
        })
        .catch((error) => {
          alert("Đặt hàng lỗi");
          console.log(error);
        });
    },
  };
});
