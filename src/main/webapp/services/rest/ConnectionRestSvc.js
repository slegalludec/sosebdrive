app.factory('ConnectionRestSvc', ['$resource', function($resource) {
  return $resource('/authentication', null, {
	  connection : {method : 'POST', url: '/authentication/connection'},
	  disconnection : {method: 'POST', url: '/authentication/disconnection'}
  });
}]);