app.factory('DriveRestSvc', ['$resource', function($resource) {
  return $resource('/drive/list/:nameRoot', {}, {
	  get : {method:'GET', params:{nameRoot:'@nameRoot'}, isArray:true}
  });
}]);