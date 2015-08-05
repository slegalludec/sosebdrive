app.directive('alertTimeout', function ($timeout) {
    return {
        restrict: 'E',
        scope: {
        	classCSS: '=',
        	msg: '='
        },
        templateUrl: 'modules/alertTimeout/alertTimeout.html',
        link: function(scope, element, attrs) {
            $timeout(function () {
                element.remove();
            }, 15000);
        }
    };
});