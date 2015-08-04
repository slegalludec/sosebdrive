app.controller('PictureCtrl', ['$scope', '$http', 'LoggerSvc', 'DriveRestSvc', function ($scope, $http, LoggerSvc, DriveRestSvc){

    $scope.ext = 'icon_' + $scope.extension;
    $scope.currentCol = 'col' + $scope.position;
    $scope.currentRaw = 'raw' + $scope.raw;

    $scope.isFolder = false;    
    $scope.isImage = false;

    if ($scope.extension == 'fol') {
        $scope.isFolder = true;
    }
    
    if ($scope.extension == 'png') {
        $scope.isImage = true;
    }

    $scope.openDoc = function(url) {
        var win = window.open(url, '_blank');
        //win.focus();
    }

    $scope.openFolder = function(nameFolder) {
    	$scope.files = DriveRestSvc.get({rootName : nameFolder}, function() {
    		LoggerSvc.log('success picture', 'w');
    	});
    }
}]);