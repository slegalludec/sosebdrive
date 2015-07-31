app.directive('datepickerPerso', function () {
    return {
        restrict: 'E',
        scope: {
            model: '=',
            classInput: '=',
            classCalendar: '=',
            nameLabel: '='
        },
        controller: 'DatepickerCtrl',
        templateUrl: 'modules/datepicker/datepicker.html'
    };
});