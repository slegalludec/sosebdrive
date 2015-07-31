app.directive('alertTimeout', function ($timeout) {
    return {
        restrict: 'E',
        scope: {
            type: '=',
            textValue: '='
        },
        template: '<alert type="alertTimeout">textValue</alert>',
        link: function(scope, element, attrs) {
            $timeout(function () {
                element.remove();
            }, 100000);
        }
    };
});