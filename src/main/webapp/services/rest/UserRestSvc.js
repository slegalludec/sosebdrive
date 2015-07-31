app.factory('ConnectionRestSvc', ['$resource', function($resource) {
  return $resource('/user/:userId', null, {
	  query: {method:'GET', params:{userId:''}, isArray:true},
	  get : {method : 'GET'},
	  save : {method : 'POST'},
	  remove : {method: 'DELETE'}
  });
}]);