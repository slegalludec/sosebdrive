app.controller('MenuCtrl', ['$translate', '$scope', '$location', '$window', function ($translate, $scope, $location, $window){
    
    if ($window.sessionStorage.login != undefined) {
    	  $scope.isAdmin = JSON.parse(sessionStorage.getItem($window.sessionStorage.login)).right;
    }

}]);