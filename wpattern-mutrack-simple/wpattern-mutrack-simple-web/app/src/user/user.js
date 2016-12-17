'use strict';

angular.module('mutrack').controller(
		'UserController',
		function($scope, $http, RestService) {
			$scope.users = [];
			$scope.user = {};
			$scope.showAddEditUser = false;
			
			$scope.show = function(){
				$scope.showAddEditUser = true;
			};
			
			$scope.hide = function(){
				$scope.showAddEditUser = false;
				$scope.user = {};
			};
			
			$scope.saveUser = function(user){
				if(user.id){
					
				} else {
					RestService.add('http://localhost:8086/api/private/user', user, function(response){
						$scope.users.push(response);
						$scope.hide();
					});
				}
			};

			RestService.find('http://localhost:8086/api/private/user',
					function(response) {
						$scope.users = response;
					});

		});
