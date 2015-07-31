app.controller('BannerCtrl', ['$scope', '$location', function ($scope, $location){

    $scope.user = {'login' : 'slegalludec'};

    /**
     * Manage xhr connection
     */
    $scope.disconnect = function() {
        $location.path("/connectionPage");
    };

}]);