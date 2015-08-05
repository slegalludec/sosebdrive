app.controller('ConnectionCtrl', ['$translate', '$scope', '$location', 'ConnectionRestSvc', 'LoggerSvc', function ($translate, $scope, $location, ConnectionRestSvc, LoggerSvc){

	$scope.connection = {};
	$scope.errorMsg = {};
	$scope.error = false;

	/**
	 * Connect to the application
	 * @param connection
	 */
	$scope.connect = function(connectionForm, connection) {
		if (connectionForm.$valid) {
			ConnectionRestSvc.connection.connect(connection,
				function(response) {
					if (response.responseCode == 1) {
						LoggerSvc.log('success connect');
						
						// Update user response in scope
						
						
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