app.controller('BannerCtrl', ['$scope', '$location', '$rootScope', function ($scope, $location, $rootScope){

    //$scope.user = {'login' : 'slegalludec'};

    $scope.login = $rootScope.login;
    
    /**
     * Manage xhr connection
     */
    $scope.disconnect = function() {
		$rootScope.userId = "";
		$rootScope.login = "";
		$rootScope.right = "";
		$rootScope.trackid = "";
    	
        $location.path("/connectionPage");
    };

}]);