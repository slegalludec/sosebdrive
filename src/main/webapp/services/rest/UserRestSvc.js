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
		userUpdate : $resource('/user/update', {}, {
			update: {method:'PUT'},
		})
	}
	
	return factory;
}]);