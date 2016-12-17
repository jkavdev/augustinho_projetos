'use strict';

angular.module('mutrack')

	//HttpRequestService - apenas realizará requisição http
	//informando quatro parâmetros - url, o tipo de requisição, conteúdo se houver e método status retorno 
  .service('HttpRequestService', function($http) {
    return function(url, method, data, callback) {
      var requestParams = {
        method: method,
        url: url,
        headers: { 'Content-Type': 'application/json' },
        data: data
      };

      $http(requestParams).then(
        function successCallback(response) {
          callback && callback(response.data);
        },
        function errorCallback(response) {
        });
    };
  })
  
  //RestService - Serviço que será usado, que depende de HttpRequestService
  .service('RestService', function(HttpRequestService) {
    var restFactory = {};

    // Find all data.
    restFactory.find = function(url, callback) {
    	HttpRequestService(url, 'GET', {}, callback);
    };

    // Add a new data.
    restFactory.add = function(url, data, callback) {
    	HttpRequestService(url, 'POST', data, callback);
    };

    // Edit a data.
    restFactory.edit = function(url, data, callback) {
    	HttpRequestService(url, 'PUT', data, callback);
    };

    // Delete a data.
    restFactory.delete = function(url, data, callback) {
    	HttpRequestService(url, 'DELETE', data, callback);
    };

    return restFactory;
  });
