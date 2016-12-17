'use strict';

angular.module('mutrack', ['ngRoute']).config(function($routeProvider) {
	$routeProvider
	.when('/', {
		templateUrl : 'src/home/home.html',
		controller : 'HomeController'
	})
	.when('/user', {
		templateUrl : 'src/user/user.html',
		controller : 'UserController'
	})
	.otherwise({
		redirectTo : '/'
	});
});