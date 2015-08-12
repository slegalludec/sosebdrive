app.controller('PictureCtrl', ['$scope', '$http', '$window', 'LoggerSvc', 'DriveRestSvc', function ($scope, $http, $window, LoggerSvc, DriveRestSvc){

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
    	$window.open(url, '_blank');
    }

    $scope.openFolder = function(nameFolder) {
    	$scope.files = DriveRestSvc.get({rootName : nameFolder}, function() {
    		LoggerSvc.log('success picture', 'w');
    	});
    }
}]);