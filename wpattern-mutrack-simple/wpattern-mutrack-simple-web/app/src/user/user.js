'use strict';

angular.module('mutrack').controller(
		'UserController',
		function($scope, $http, RestService) {
			$scope.users = [];

			RestService.find('http://localhost:8086/api/private/user',
					function(response) {
						$scope.users = response;
					});

		});
