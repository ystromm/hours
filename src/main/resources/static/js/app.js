(function(){
"use strict";
angular.module("app", [])
  .controller("home", function($http) {
    var self = this;
    $http.get("/api/user").success(function(data) {
      self.user = data.userAuthentication.details.displayName;
      self.authenticated = true;
    }).error(function() {
      self.user = "N/A";
      self.authenticated = false;
    });
    self.logout = function() {
      $http.post('/logout', {}).success(function() {
        self.authenticated = false;
        $location.path("/");
      }).error(function(data) {
        console.log("Logout failed")
        self.authenticated = false;
      });
    };
  })
  .controller("times", function($scope) {
    $scope.times = [{checkin: 1, checkout: 2}];
    $scope.checkin = function() {
      $scope.times.push({checkin: Date.now(), checkout: null});
    }
  });
}());