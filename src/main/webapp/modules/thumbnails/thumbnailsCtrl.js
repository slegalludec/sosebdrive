app.controller('ThumbnailsCtrl', ['$scope', '$http', '$rootScope', 'LoggerSvc', 'DriveRestSvc', function ($scope, $http, $rootScope, LoggerSvc, DriveRestSvc){

	$rootScope.files = null;
	$rootScope.isEmpty = false;
	$rootScope.paths = [];
	
	/**
	 * change list of document with rootName
	 */
	$scope.initList = function(rootName) {
		
		var currentName = rootName;

		DriveRestSvc.get({rootName : currentName}, 
			function(response) {
				$rootScope.files = response.contentsList;
				$rootScope.paths.push(response.rootName);
				LoggerSvc.log('success thumbnails');
			}, function(response) {
				LoggerSvc.log('error thumbnails : ' + response.data.status, 'e');
			}
		);
	};
	
	$scope.changeFolder = function(index) {
		var currentName = $rootScope.paths.valueOf()[index];

		DriveRestSvc.get({rootName : currentName}, 
			function(response) {
				$rootScope.files = response.contentsList;
				$rootScope.paths.pop(response.rootName);
				LoggerSvc.log('success thumbnails');
			}, function(response) {
				LoggerSvc.log('error thumbnails : ' + response.data.status, 'e');
			}
		);
	};
	
}]);