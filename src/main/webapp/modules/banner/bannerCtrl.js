app.controller('BannerCtrl', ['$scope', '$location', '$window', '$rootScope', function ($scope, $location, $window, $rootScope){

    $scope.login = $window.sessionStorage.login;

    // Check if user have removed session 
    if ($scope.login == undefined) {
    	 $location.path("/connectionPage");
    }
    
    /**
     * Manage disconnection
     */
    $scope.disconnect = function() {
		sessionStorage.removeItem($window.sessionStorage.login);
		$rootScope.login = "";
		$window.sessionStorage.removeItem("login");
		
        $location.path("/connectionPage");
    };

}]);