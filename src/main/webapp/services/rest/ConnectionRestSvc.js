app.factory('ConnectionRestSvc', ['$resource', function($resource) {
	
	var factory = {
		connection : $resource('/authentication/connection', {}, {
			connect: {method:'POST'}
		}),
		disconnection : $resource('/authentication/disconnection', {}, {
			disconnect: {method:'POST'}
		})
	}
	return factory;
}]);