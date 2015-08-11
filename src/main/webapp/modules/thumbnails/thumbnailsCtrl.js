app.controller('ThumbnailsCtrl', ['$scope', '$http', 'LoggerSvc', 'DriveRestSvc', function ($scope, $http, LoggerSvc, DriveRestSvc){

	/**
	 * change list of document with rootName
	 */
	$scope.initList = function(rootName) {
		var currentName = rootName;

		$scope.files = DriveRestSvc.get({rootName : currentName}, function() {
			LoggerSvc.log('success thumbnails');
		});
	}
}]);