app.controller('ConnectionCtrl', ['$translate', '$scope', '$location', '$rootScope', 'ConnectionRestSvc', 'LoggerSvc', function ($translate, $scope, $location, $rootScope, ConnectionRestSvc, LoggerSvc){

	$scope.credentials = {};
	$scope.errorMsg = {};
	$scope.error = false;
	$scope.user = {};

	/**
	 * Connect to the application
	 * @param connection
	 */
	$scope.connect = function(connectionForm, credentials) {
		if (connectionForm.$valid) {
			ConnectionRestSvc.connection.connect(credentials,
				function(response) {
					if (response.responseCode == 1) {
						LoggerSvc.log('success connect');
						
						// Update user response in scope
						$rootScope.userId = response.userSession.userId;
						$rootScope.login = response.userSession.login;
						$rootScope.right = response.userSession.right;
						$rootScope.trackid = response.userSession.trackid;
						
						$location.path('/mainPage');
					} else {
						LoggerSvc.log('error connect : [code=' + response.responseCode + ']', 'e');
						$scope.errorMsg = 'ERROR_MSG_' + response.responseCode;
						$scope.error = true;
					}				
				},
				function(response) {
					LoggerSvc.log('error connect : ' + response.data.status, 'e');
			});
		}
	};

	
	
	/**
	 * Manage language change
	 * @param key
	 */
	$scope.changeLanguage = function (key) {
		$translate.use(key);
		$location.path('/');
	};

}]);