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
			
			$scope.deleteUser = function(user){
				RestService.delete('http://localhost:8086/api/private/user', user, function(){
					$scope.users.splice($scope.users.indexOf(user), 1);
				});
			};
			
			$scope.editUser = function(user){
				$scope.user = angular.copy(user);
				$scope.show();
			};
		
			$scope.saveUser = function(user){
				if(user.id){
					RestService.edit('http://localhost:8086/api/private/user', user, function(response){
						delete user.password;

						//Buscando objeto na lista e atribuindo ao objeto encontrado usuário alterado
						for (var i = 0; i < $scope.users.length; i++) {
							if($scope.users[i].id === user.id) { 
								$scope.users[i] = user;
							}
						}

						$scope.hide();
					});	
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
