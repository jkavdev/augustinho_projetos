'use strict';

angular.module('mutrack')
  .controller('UserController', function($scope, $http) {
    $scope.users = [];
    
    $http.get('http://localhost:8086/api/private/user')
    	.then(function(response){
    		$scope.users = response.data;
    	});
    
  });
