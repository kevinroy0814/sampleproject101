angular.module('serviceConsumer', [])
	.controller('Hello', function($scope, $http) {
		var url = "greetingservice";
		
		$http.get(url).success(function (data) {
			$scope.a = data;
		})
	})