app.factory('DriveRestSvc', ['$resource', function($resource) {
  return $resource('/ws/drive/list/:nameRoot', {}, {
	  get : {method:'GET', params:{nameRoot:'@nameRoot'}}
  });
}]);