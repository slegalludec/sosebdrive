app.controller('MenuCtrl', ['$translate', '$scope', '$location', '$window', function ($translate, $scope, $location, $window){

    /**$scope.folders = {
        "documents": [
            {
                "documentName": "Assurance Auto",
                "range": "1",
                "showSubMenu": false,
                "folderList": [
                    {
                        "documentName": "Pi�ces � fournir",
                        "range": "1",
                        "showSubMenu": false,
                        "folderList": [
                            {
                                "documentName": "CNI",
                                "range": "1"
                            },
                            {
                                "documentName": "Permis",
                                "range": "2"
                            },
                            {
                                "documentName": "Passeport",
                                "range": "3"
                            }
                        ]
                    }
                ]
            },
            {
                "documentName": "NewR",
                "range": "3",
                "showSubMenu": false,
                "folderList": [
                    {
                        "documentName": "Amalia",
                        "range": "1"
                    },
                    {
                        "documentName": "Appels de fond",
                        "range": "2"
                    },
                    {
                        "documentName": "Assurance April",
                        "range": "3"
                    },
                    {
                        "documentName": "Assurance Metlife",
                        "range": "4"
                    },
                    {
                        "documentName": "Cuisinella",
                        "range": "5"
                    }
                ]
            },
            {
                "documentName": "Pacs",
                "range": "5"
            },
            {
                "documentName": "Projet NAS",
                "range": "4"
            },
            {
                "documentName": "Sebastien",
                "range": "2"
            },
            {
                "documentName": "Solene",
                "range": "6"
            }
        ]
    };*/

    $scope.folders = {
        "documents": [
            {
                "documentName": "<<TODO>>",
                "range": "1",
                "showSubMenu": false,
                "folderList": []
            }
        ]
    };
    
    $scope.displaySubMenu1 = false;
    $scope.subMenu1 = {};
    
    if ($window.sessionStorage.login != undefined) {
    	  $scope.isAdmin = JSON.parse(sessionStorage.getItem($window.sessionStorage.login)).right;
    }

    $scope.openSubMenu1 = function(folder) {
        if (folder.showSubMenu == true) {
            folder.showSubMenu = false;
        } else {
            folder.showSubMenu = true;
        }
    }

    $scope.changeFocus = function() {
        $location.path("/mainPage");
    }

}]);