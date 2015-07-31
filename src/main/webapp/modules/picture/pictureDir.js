app.directive('picture', function () {
    return {
        restrict: 'E',
        scope: {
            name: '=',
            extension: '=',
            url: '=',
            position: '=',
            raw: '='
        },
        templateUrl: 'modules/picture/picture.html',
        controller: 'PictureCtrl'

    };
});