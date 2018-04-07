var app = angular.module('app', []);
var config = {headers: {'Content-Type': 'application/json;charset=utf-8;'}};

app.controller('getController', function ($scope, $http) {

    $scope.getUsername = function () {
        var url = "getUsername";
        $http.get(url, config).then(function (response) {
            $scope.username = response.data;
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
            $scope.foods = response.data;
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

});
