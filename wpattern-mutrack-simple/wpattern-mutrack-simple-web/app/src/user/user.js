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

			RestService.find('http://localhost:8086/api/private/user',
					function(response) {
						$scope.users = response;
					});

		});
