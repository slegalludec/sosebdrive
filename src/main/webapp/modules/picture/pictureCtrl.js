app.controller('PictureCtrl', ['$scope', '$http', function ($scope, $http){

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
          console.log("success picture: " + status);
          $scope.files = data;
        }).
        error(function(error, status) {
	          console.log("error picture: " + status);
        });
    }

}]);