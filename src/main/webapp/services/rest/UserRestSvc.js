app.factory('UserRestSvc', ['$resource', function($resource) {
	
	var factory = {
		usersList : $resource('/user/list', {}, {
			list: {method:'GET', isArray:false},
		}),
		userRemove : $resource('/user/delete/:id', {}, {
			remove: {method:'DELETE', isArray:false, params: { id: '@id'}},
		}),
		userAdd : $resource('/user/create', {}, {
			add: {method:'POST'},
		}), 
		userUpdate : $resource('/user/update/:id', {}, {
			update: {method:'PUT', isArray:false, params: { id: '@id'}},
		})
	}
	
	return factory;
}]);