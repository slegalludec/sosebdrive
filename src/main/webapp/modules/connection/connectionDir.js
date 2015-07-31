app.directive('connect', function () {
    return {
        restrict: 'E',
        templateUrl: 'modules/connection/connection.html',
        controller: 'ConnectionCtrl'
    };
});