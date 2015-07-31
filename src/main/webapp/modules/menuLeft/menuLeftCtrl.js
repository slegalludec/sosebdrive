app.controller('MenuCtrl', ['$translate', '$scope', '$location',  function ($translate, $scope, $location){

    /*$scope.folders = {
        "code": "1",
        "documents": [
            {
                "documentName": "NewR",
                "range": "1",
                "filesList": [
                    {
                        "documentName": "Réservation",
                        "range": "1",
                        "documentUrl": "http://www.google.fr"
                    },
                    {
                        "documentName": "Appel de fond",
                        "range": "2",
                        "documentUrl": "http://www.fcnantes.com"
                    }
                ],
                "folderList": [
                    {
                        "documentName": "KF",
                        "range": "1",
                        "filesList": [
                            {}
                        ]
                    },
                    {
                        "documentName": "SG",
                        "range": "2",
                        "filesList": [
                            {}
                        ]
                    }
                ]
            },
            {
                "documentName": "SLE",
                "range": "1",
            }
        ]
    };*/

    $scope.folders = {
        "documents": [
            {
                "documentName": "Assurance Auto",
                "range": "1",
                "showSubMenu": false,
                "folderList": [
                    {
                        "documentName": "Pièces à fournir",
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
    };

    $scope.displaySubMenu1 = false;
    $scope.subMenu1 = {};

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