var app = angular.module('app', []);
var config = {headers: {'Content-Type': 'application/json;charset=utf-8;'}};

app.controller('getController', function ($scope, $http, $location, $window) {

    $scope.getUsername = function () {
        var url = "getUsername";
        $http.get(url, config).then(function (response) {
            $scope.username = response.data;
        });
    };

    $scope.getCurrentUser = function () {
        var url = "getCurrentUser";
        $http.get(url, config).then(function (response) {
            $scope.user = response.data;
        });
    };

    $scope.getUsers = function () {
        var url = "getUsers";
        $http.get(url, config).then(function (response) {
            $scope.users = response.data;
        });
    };

    $scope.getDrivers = function () {
        var url = "getDrivers";
        $http.get(url, config).then(function (response) {
            $scope.drivers = response.data;
        });
    };

    $scope.getTypes = function () {
        var url = "getTypes";
        $http.get(url, config).then(function (response) {
            $scope.types = response.data;
        });
    };

    $scope.getFoods = function () {
        var url = "getFoods";
        $http.get(url, config).then(function (response) {
            $scope.sort = 'Все товары';
            $scope.foods = response.data;

            $scope.setSort = function (sortName) {
                $scope.sort = sortName;
            };
        });
    };

    $scope.getLastCart = function () {
        var url = "getLastCart";
        $http.get(url, config).then(function (response) {
            $scope.cart = response.data;
        });
    };

    $scope.getCarts = function () {
        var url = "getCarts";
        $http.get(url, config).then(function (response) {
            $scope.carts = response.data;
        });
    };

    $scope.getAllCarts = function () {
        var url = "getAllCarts";
        $http.get(url, config).then(function (response) {
            $scope.carts = response.data;
        });
    };

    $scope.getFreeDrivers = function () {
        var url = "getFreeDrivers";
        $http.get(url, config).then(function (response) {
            $scope.drivers = response.data;
        });
    };

    $scope.getCartsForDelivery = function () {
        var url = "getCartsForDelivery";
        $http.get(url, config).then(function (response) {
            $scope.cartsForDelivery = response.data;
        });
    };

    $scope.getDate = function (t) {
        return new Date(t).toLocaleString();
    };

    $scope.getStatus = function (status) {
        switch (status){
            case 'confirm':
                return "Заказ обрабатывается";
            case 'in delivery':
                return "Заказ доставляется";
            case 'delivered':
                return "Заказ доставлен";
        }
    };

    $scope.getCost = function (foods) {
        var sum = 0;
        for (i = 0; i < foods.length; i++) {
            sum += foods[i].price;
        }
        return sum;
    };

});

app.controller('postController', function ($scope, $http, $location, $window) {

    $scope.submitRegistration = function () {
        var url = "submitRegistration";
        var data = {
            name: $scope.name,
            password: $scope.password
        };
        if ($scope.name == null || $scope.password == null)
            $scope.postResultMessage = "Введите имя пользователя и пароль";
        $http.post(url, data, config).then(function (response) {
            $scope.answer = response.data;
            if ($scope.answer === "true") {
                $window.location.href = '/login';
            } else {
                $scope.postResultMessage = "Такой пользователь уже существует";
            }
        });
    };

    var id;
    $scope.setId = function (Id) {
        id = Id;
    };

    $scope.addFoodToCart = function () {
        var url = "addFoodToCart";
        var data = {
            id: id
        };
        $http.post(url, data, config).then(function (response) {
            $window.location.href = '/cart';
        });
    };

    $scope.deleteFromCart = function () {
        var url = "deleteFromCart";
        var data = {
            id: id
        };
        $http.post(url, data, config).then(function (response) {
            $window.location.href = '/cart';
        });
    };

    var cartId;
    $scope.setCartId = function (CartId, FoodId) {
        cartId = CartId + " " + FoodId;
    };

    $scope.deleteFromUserCart = function () {
        var url = "deleteFromUserCart";
        var data = cartId;
        $http.post(url, data, config).then(function (response) {
            $window.location.href = '/man';
        });
    };

    $scope.deleteUser = function () {
        var url = "deleteUser";
        var data = {
            id: id
        };
        $http.post(url, data, config).then(function (response) {
            $window.location.href = '/admin';
        });
    };

    $scope.deleteDriver = function () {
        var url = "deleteDriver";
        var data = {
            id: id
        };
        $http.post(url, data, config).then(function (response) {
            $window.location.href = '/admin';
        });
    };

    $scope.updateUser = function () {
        var url = "updateUser";
        var name1 = $scope.name;
        var password1 = $scope.password;
        var data = {
            id: id,
            name: name1,
            password: password1,
            address: $scope.address1
        };
        if($scope.address1 == null) {
            document.getElementById("blabla").innerHTML = "*Поле 'Адрес' при изменении не может быть пуcтым.";
            document.getElementById("blabla").style.color = "#ff0000";
        }
        else {
            document.getElementById("blabla").innerHTML = "Данные изменены";
            document.getElementById("blabla").style.color = "#000000";
            $http.post(url, data, config).then(function (response) {
                if ((name1 != null && name1 !== "") || (password1 != null && password1 !== "")) {
                    $window.location.href = '/logout';
                } else {
                    $window.location.href = '/information';
                }
            });
        }
    };

    $scope.confirmCart = function () {
        var url = "confirmCart";
        $http.post(url, config).then(function (response) {
            $window.location.href = '/cart';
        });
    };

    $scope.goToLogin = function () {
        $window.location.href = '/login';
    };

    $scope.goToInformation = function () {
        $window.location.href = '/information';
    };

    $scope.addCartsToDriver = function () {
        var url = "addCartsToDriver";
        var data = id + " " + $scope.ids;
        $http.post(url, data).then(function (response) {
            $window.location.href = '/man';
        });
    };

    $scope.addDriver = function () {
        var url = "addDriver";
        var data = {
            name: $scope.name,
            phone: $scope.phone
        };
        $http.post(url, data, config).then(function (response) {
            $window.location.href = '/admin';
        });
    };

    $scope.addManager = function () {
        var url = "addManager";
        var data = {
            name: $scope.name,
            password: $scope.password
        };
        $http.post(url, data, config).then(function (response) {
            $window.location.href = '/admin';
        });
    };

});
