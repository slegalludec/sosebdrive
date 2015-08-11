app.controller('ConnectionCtrl', ['$translate', '$scope', '$location', '$window', 'ConnectionRestSvc', 'LoggerSvc', function ($translate, $scope, $location, $window, ConnectionRestSvc, LoggerSvc){

	$scope.credentials = {};
	$scope.errorMsg = {};
	$scope.error = false;
	var userInfo = {};

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
						
						userInfo = JSON.stringify({'userId' : response.userSession.userId, 'right' : response.userSession.right, 'trackid' : response.userSession.trackid});
						
						$window.sessionStorage.login = response.userSession.login;
						sessionStorage.setItem(response.userSession.login, userInfo);
						
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