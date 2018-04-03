var app = angular.module('app', []);
var config = {headers: {'Content-Type': 'application/json;charset=utf-8;'}};

app.controller('appController', function ($scope, $http) {

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

});
