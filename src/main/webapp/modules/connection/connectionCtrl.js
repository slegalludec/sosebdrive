app.controller('ConnectionCtrl', ['$translate', '$scope', '$location', 'ConnectionRestSvc', 'LoggerSvc', function ($translate, $scope, $location, ConnectionRestSvc, LoggerSvc){

	$scope.connection = {};
	$scope.errorMsg = {};
	$scope.error = false;

	$scope.mock = false;

	/**
	 * Connect to the application
	 * @param connection
	 */
	$scope.connect = function(connectionForm, connection) {
		if (connectionForm.$valid) {
			ConnectionRestSvc.connection.connect(connection,
				function(response) {
					LoggerSvc.log('success connect');
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