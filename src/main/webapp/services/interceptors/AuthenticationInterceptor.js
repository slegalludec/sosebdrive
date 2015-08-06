app.factory('AuthenticationInterceptor', ['$q', '$location', function($q, $location) {
	return {
		responseError: function(rejection) {
			if (rejection.status == 401) {
				$location.path('/');
			}
			return $q.reject(rejection);
		}
	}
}]);