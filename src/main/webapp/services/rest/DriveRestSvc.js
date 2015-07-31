app.factory('DriveRestSvc', ['$resource', function($resource) {
  return $resource('/drive/list/:nameRoot', {nameRoot: '@nameRoot'}, {
	  get : {method : 'GET', isArray: false}
  });
}]);