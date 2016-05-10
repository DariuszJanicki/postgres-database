angular.module("app").controller('HomeController', function($scope, $location, $http, AuthenticationService) {
  $scope.title = "Home";
  $scope.message = "Mouse Over these images to see a directive at work";

  $scope.name = '';
  $scope.surname = '';
  $scope.id = '';
  $scope.persons = [];

  $scope.new = function() {
      $http.post('http://localhost:8080/person/create', {name: $scope.name, surname: $scope.surname})
          .then(function(success) {}, function(failure) {});
  };

  $scope.update = function() {
    $http.post('http://localhost:8080/person/update', {id: $scope.id, name: $scope.name, surname: $scope.surname})
        .then(function(success) {}, function(failure) {});
  };

  $scope.fetch = function() {
    $http.get('http://localhost:8080/person')
        .then(function(success) {
          $scope.persons = success.data;
        }, function(failure) {});
  };

  var onLogoutSuccess = function(response) {
    $location.path('/login');
  };

  $scope.logout = function() {
    AuthenticationService.logout().success(onLogoutSuccess);
  };
});
