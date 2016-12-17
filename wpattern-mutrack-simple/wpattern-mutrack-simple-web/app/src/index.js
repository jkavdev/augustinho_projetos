'use strict';

angular.module('mutrack', ['ngRoute']).config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'src/home/home.html',
		controller : 'HomeController'
	}).otherwise({
		redirectTo : '/'
	});
});