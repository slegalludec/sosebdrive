app.factory('ConnectionRestSvc', ['$resource', function($resource) {
	
	var factory = {
		connection : $resource('/ws/authentication/connection', {}, {
			connect: {method:'POST'}
		}),
		disconnection : $resource('/ws/authentication/disconnection', {}, {
			disconnect: {method:'POST'}
		})
	}
	return factory;
}]);