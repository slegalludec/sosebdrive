app.controller('DatepickerCtrl', ['$translate', '$scope',  function ($translate, $scope){

    /* current language */
    var language =  $translate.use();

    $scope.inputDate = $scope.classInput + '_' + language;
    $scope.calendarDate = $scope.classCalendar + '_' + language;



}]);