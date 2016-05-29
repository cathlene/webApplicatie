var app = angular.module('status', []);
		app.controller('statusController', function($scope, $http) {
    		$http.get("Controller?action=getStatus")
    		.success(function (response) {
    			$scope.offline = response.offline;
    			$scope.online = response.online;
    			$scope.away = response.away;

    		
    		});
		});