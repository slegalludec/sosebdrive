app.controller('PictureCtrl', ['$scope', '$http', 'LoggerSvc', function ($scope, $http, LoggerSvc){

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
    	$http.get('/drive/list?' + 'rootName=' + nameFolder).
        success(function(data, status) {
        	LoggerSvc.log('success picture', 'w');
        }).
        error(function(error, status) {
        	LoggerSvc.log('error picture', 'e');;
        });
    }

}]);