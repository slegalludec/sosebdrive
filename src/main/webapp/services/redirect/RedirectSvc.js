app.factory('RedirectSvc', function($timeout, $location) {

	/**
	 * Function manage user error when session is expired
	 * Redirect to /error after 5 seconds
	 */
	var redirect = function() {
		$timeout(function() {
			$location.path('/error');
		}, 5000);
	};	

	return redirect;

});