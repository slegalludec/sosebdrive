app.factory('UserRestSvc', ['$resource', function($resource) {
	
	var factory = {
		usersList : $resource('/user/list', {}, {
			  list: {method:'GET', isArray:false},
		}),
		userRemove : $resource('/user/delete/:id', {}, {
			remove: {method:'GET', isArray:false, params: { id: '@id'}},
		}),
		userAdd : $resource('/user/create', {}, {
			add: {method:'GET', isArray:false},
		}),
		userUpdate : $resource('/user/update', {}, {
			update: {method:'GET', isArray:false},
		})
	}
	
	return factory;
}]);