var translations = {
    'en' : {
        'LOGIN' : 'login',
        'PASSWORD' : 'password',
        'CONNECTION' : 'connection',
        'ADMIN' : 'manage users',
        'WELCOME' : 'welcome',
        'ADMINISTRATION' : 'Administration',
        'FOLDERS' : 'Folders',
        'START_DATE' : 'start date',
        'END_DATE' : 'end date',
        'USER_RIGHT' : 'user right',
        'DISCONNECT' : 'You are disconnected !',
        'USER_CONNECTED' : ' is connected !',

        'TITLE_MANAGEMENT' : 'Users management',
        'TITLE_USERS' : 'Users list',
        'TITLE_DETAIL' : 'User detail',

        'BUTTON_ADD_USER' : 'Add',
        'BUTTON_UPDATE_USER' : 'update',
        'BUTTON_REMOVE_USER' : 'remove',
        'BUTTON_CANCEL_USER' : 'Cancel',

        'PATTERN_DATE' : 'MM/dd/yyyy',

        'ERROR_MSG_100' : 'login or password empty',
        'ERROR_MSG_101' : 'bad login or bad password',
        'ERROR_MSG_102' : 'user right expired',
        'ERROR_MSG_103' : 'authentication file is not founded',
        'ERROR_MSG_110' : 'unknow error',
        'ERROR_MSG_111' : 'ws error'
    },
    'fr' : {
        'LOGIN': 'identifiant',
        'PASSWORD': 'mot de passe',
        'CONNECTION': 'connexion',
        'ADMIN': 'gestion utilisateurs',
        'WELCOME': 'bienvenue',
        'ADMINISTRATION': 'Administration',
        'FOLDERS': 'Dossiers',
        'START_DATE' : 'date de début',
        'END_DATE' : 'date de fin',
        'USER_RIGHT' : 'droit utilisateur',
        'DISCONNECT' : 'Vous êtes déconnecté !',
        'USER_CONNECTED' : ' est connecté !',

        'TITLE_MANAGEMENT' : 'Gestion utilisateurs',
        'TITLE_USERS' : 'Liste utilisateurs',
        'TITLE_DETAIL' : 'Détail utilisateur',

        'BUTTON_ADD_USER' : 'Ajouter',
        'BUTTON_UPDATE_USER' : 'Modifier',
        'BUTTON_REMOVE_USER' : 'Supprimer',
        'BUTTON_CANCEL_USER' : 'Annuler',

        'PATTERN_DATE' : 'dd/MM/yyyy',

        'ERROR_MSG_100' : 'login ou mot de passe vide',
        'ERROR_MSG_101' : 'mauvais login ou mauvais mot de passe',
        'ERROR_MSG_102' : 'droit utilisateur expiré',
        'ERROR_MSG_103' : 'fichier authentification non trouvé',
        'ERROR_MSG_110' : 'erreur inconnue',
        'ERROR_MSG_111' : 'erreur ws'
    }
};

var app = angular.module('sosebDrive', ['pascalprecht.translate', 'ngResource', 'ngRoute', 'ui.bootstrap', 'pickadate']);

/* translate configuration */
/* routing configuration */
app.config(function($translateProvider, $routeProvider, $httpProvider) {

    for(lang in translations){
        $translateProvider.translations(lang, translations[lang]);
    }

    $translateProvider.preferredLanguage('en');

    $httpProvider.interceptors.push([
        '$injector',
        function ($injector) {
    	    return $injector.get('AuthenticationInterceptor');
        }
    ]);
    
    $routeProvider
        .when('/mainPage', {
        templateUrl: 'templates/mainPage.html'
        })
        .when('/userManagementPage', {
            templateUrl: 'templates/userManagementPage.html'
        })
        .when('/connectionPage', {
            templateUrl: 'templates/connectionPage.html'
        })
        .otherwise({
           redirectTo: '/connectionPage'
        });
});