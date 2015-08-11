app.controller('InfoCtrl', ['$translate', '$scope', '$window', '$rootScope', function ($translate, $scope, $window, $rootScope) {

	if ($rootScope.isDisconnected != undefined) {
		
		// Update text in alert
		if ($rootScope.isDisconnected == false) {
			$scope.newMsg = $window.sessionStorage.login + $scope.msg;
		} else {
			$scope.newMsg = $scope.msg;		
			sessionStorage.removeItem($window.sessionStorage.login);
		}

		// Update background 
		$scope.newClass = $scope.background;
		
		$rootScope.isDisconnected = undefined;
	}

}]);