app.controller('ThumbnailsCtrl', ['$scope', '$http', '$rootScope', 'LoggerSvc', 'DriveRestSvc', function ($scope, $http, $rootScope, LoggerSvc, DriveRestSvc){

	$rootScope.files = null;
	$rootScope.isEmpty = false;
	$rootScope.paths = [];
	
	/**
	 * Change list of document with rootName
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
	
	/**
	 * Change folder in path
	 */
	$scope.changeFolder = function(index) {
		var currentName = $rootScope.paths.valueOf()[index];

		DriveRestSvc.get({rootName : currentName}, 
			function(response) {
			
				if(response.responseCode == 1) {
	    			$rootScope.files = response.contentsList;
	    			$rootScope.isEmpty = false;
	    			$rootScope.paths.splice(index+1, $rootScope.paths.length);
					LoggerSvc.log('success thumbnails');
				} else {
					$rootScope.isEmpty = true;
					$rootScope.paths.splice(index+1, $rootScope.paths.length);
	    			LoggerSvc.log('success thumbnails but folder empty', 'w');
				}
							
			}, function(response) {
				LoggerSvc.log('error thumbnails : ' + response.data.status, 'e');
			}
		);
	};
	
}]);