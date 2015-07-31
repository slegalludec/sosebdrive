app.controller('UserManagementCtrl', ['$scope', '$translate', function ($scope, $translate){

    $scope.isCreationMode = true;
    $scope.userBdd = {};
    $scope.buttons = 'buttonsOnly';

    /* current language */
    var language =  $translate.use();

    /* Initialize input position */
    $scope.inputLoginUser = 'inputLoginUser_' + language;
    $scope.inputPasswordUser = 'inputPasswordUser_' + language;
    $scope.inputRight = 'inputRight_' + language;

    $scope.positionLogin = 'inputLoginEn';
    $scope.positionPassword = 'inputPasswordEn';

    $scope.users = [
        {
            'id' : 1,
            'login' : 'slegalludec',
            'password' : 'f97sd8f',
            'startDate' : '14/07/2015 12:30',
            'endDate' : '14/07/2016 12:30',
            'userRight' : 1
        },
        {
            'id' : 2,
            'login' : 'mdurant',
            'password' : '897fzef',
            'startDate' : '14/03/2014 12:30',
            'endDate' : '14/07/2014 12:30',
            'userRight' : 2
        },
        {
            'id' : 4,
            'login' : 'jpoirie',
            'password' : '897fz85',
            'startDate' : '14/07/2015 12:30',
            'endDate' : '14/07/2016 12:30',
            'userRight' : 2
        },
        {
            'id' : 5,
            'login' : 'fpeche',
            'password' : '5z6fzapl',
            'startDate' : '14/07/2015 12:30',
            'endDate' : '14/07/2016 12:30',
            'userRight' : 2
        }
    ];

    $scope.rights = [
        {
            'id' : 1,
            'label' : 'administrator'
        },
        {
            'id' : 2,
            'label' : 'simple user'
        }
    ];

    $scope.selectedRight = $scope.rights[0];

    /**
     * Add a new user
     * @param userBdd
     */
    $scope.add = function(userBdd) {
        $scope.users.push(userBdd);
        $scope.userBdd = {};
    };

    /**
     * Update the user selected
     * @param userBdd
     */
    $scope.update = function(userBdd) {

    };

    /**
     * Remove the user selected
     * @param userBdd
     */
    $scope.remove = function(userBdd) {
        for(var i=0; i<$scope.users.length; i++) {
            if ($scope.users[i].id == userBdd.id) {
                delete $scope.users[i];
                $scope.init();
            }
        }
    };

    /**
     * Show user details
     * @param id
     */
    $scope.details = function(id) {
        for(var i=0; i<$scope.users.length; i++) {
            if ($scope.users[i].id == id) {
                $scope.userBdd = $scope.users[i];
                $scope.isCreationMode = false;
                $scope.buttons = 'buttonsMutli';
                $scope.selectedRight = $scope.rights[$scope.users[i].userRight-1];
            }
        }
    };

    /**
     * Cancel updating mode
     */
    $scope.init = function() {
        $scope.isCreationMode = true;
        $scope.userBdd = {};
        $scope.buttons = 'buttonsOnly';
    }

}]);