app.controller('ThumbnailsCtrl', ['$scope', '$http', 'LoggerSvc', 'DriveRestSvc', function ($scope, $http, LoggerSvc, DriveRestSvc){
	
	/**
	 * change list of document with rootName
	 */
    $scope.initList = function(rootName) {
    	DriveRestSvc.get(rootName);
    	/**$http.get('/drive/list?' + 'rootName=' + rootName).
	        success(function(data, status) {
	        	LoggerSvc.log('success thumbnails', 'w');
	        	$scope.files = data;
	        }).
	        error(function(error, status) {
	        	LoggerSvc.log('error thumbnails', 'e');
	        });*/
    }
}]);