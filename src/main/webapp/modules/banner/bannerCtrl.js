app.controller('BannerCtrl', ['$scope', '$location', '$window', '$rootScope', function ($scope, $location, $window, $rootScope){

    $scope.login = $window.sessionStorage.login;
    
    // Check if user have removed session 
    if ($scope.login == undefined) {
    	 $scope.msg = $scope.login + 'is diconnected. Redirect to authent';
    	 $location.path("/connectionPage");
    } else {
    	$scope.msg = $scope.login + 'is connected.';
    }
    
    /**
     * Manage disconnection
     */
    $scope.disconnect = function() {
		$rootScope.isDisconnected = true;    	
        $location.path("/connectionPage");
    };

}]);