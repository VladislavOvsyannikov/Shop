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

});

app.controller('postController', function ($scope, $http, $location, $window) {

    $scope.submitRegistration = function () {
        var url = "submitRegistration";
        var data = {
            name: $scope.name,
            password: $scope.password
        };
        if ($scope.name==null || $scope.password==null)
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
    $scope.setId = function (foodId) {
        id = foodId;
    };
    $scope.addFoodToCart = function () {
        var url = "addFoodToCart";
        var data = {
            id: id
        };
        $http.post(url, data, config).then(function (response) {
        });
    };

    $scope.deleteFromCart = function () {
        var url = "deleteFromCart";
        var data = {
            id: id
        };
        $http.post(url, data, config).then(function (response) {
        });
    };

    $scope.confirmCart = function () {
        var url = "confirmCart";
        $http.post(url, config).then(function (response) {
        });
    };

    $scope.goToLogin = function () {
        $window.location.href = '/login';
    };

});
