app.controller('ConnectionCtrl', ['$translate', '$scope', '$location',  function ($translate, $scope, $location){

    $scope.connection = {};
    $scope.errorMsg = {};
    $scope.error = false;

    $scope.mock = false;

    /**
     * Manage xhr connection
     */
    $scope.connect = function(connection) {
        if (connection.$valid) {
            console.log("xhr");

            if($scope.mock) {
                $scope.error = true;
                $scope.errorMsg = 'ERROR_MSG_102';
            } else {
                $location.path('/mainPage');
            }

        } else {
            $scope.error = true;
            console.log("error");
        }
    };

    /**
     * Manage language change
     * @param key
     */
    $scope.changeLanguage = function (key) {
        $translate.use(key);
        $location.path('/');
    };

}]);