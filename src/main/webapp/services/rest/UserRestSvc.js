app.factory('UserRestSvc', ['$resource', function($resource) {
	
	var factory = {
		usersList : $resource('/user/list/:trackid', {}, {
			list: {method:'GET', isArray:false, params: { trackid : '@trackid'}},
		}),
		userRemove : $resource('/user/delete/:id/:trackid', {}, {
			remove: {method:'DELETE', isArray:false, params: { id: '@id', trackid : '@trackid'}},
		}),
		userAdd : $resource('/user/create/:trackid', {}, {
			add: {method:'POST', params: { trackid : '@trackid'}},
		}), 
		userUpdate : $resource('/user/update/:trackid', {}, {
			update: {method:'PUT', params: { trackid : '@trackid'}},
		})
	}
	
	return factory;
}]);