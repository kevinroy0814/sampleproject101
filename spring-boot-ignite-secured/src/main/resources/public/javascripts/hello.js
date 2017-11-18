function Hello($scope, $http) {
    $http.get('http://localhost:8080/greetingservice').
        success(function(data) {
            $scope.greeting = data;
        });
}