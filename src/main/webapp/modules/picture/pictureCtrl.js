app.controller('PictureCtrl', ['$scope', '$http', '$window', '$location', '$rootScope', 'LoggerSvc', 'DriveRestSvc', function ($scope, $http, $window, $location, $rootScope, LoggerSvc, DriveRestSvc){

    $scope.ext = 'icon_' + $scope.extension;
    $scope.currentCol = 'col' + $scope.position;
    $scope.currentRaw = 'raw' + $scope.raw;

    $scope.isFolder = false;    
    $scope.isImage = false;

    if ($scope.extension == 'fol') {
        $scope.isFolder = true;
    }
    
    if ($scope.extension == 'png' || $scope.extension == 'jpg') {
        $scope.isImage = true;
    }

    $scope.openDoc = function(url) {
    	$window.open(url);
    }

    $scope.openFolder = function(nameFolder) {
    	DriveRestSvc.get({rootName : nameFolder}, 
    		function(response) {
    		
    			if(response.responseCode == 1) {
        			$rootScope.files = response.contentsList;
        			$rootScope.paths.push(response.rootName);
        			LoggerSvc.log('success picture');
    			} else {
    				$rootScope.isEmpty = true;
    				$rootScope.paths.push(response.rootName);
        			LoggerSvc.log('success picture but folder empty', 'w');
    			}
    		},
    		function(response) {
    			LoggerSvc.log('error picture : ' + response.data.status, 'e');
    		}
    	);
    }
}]);