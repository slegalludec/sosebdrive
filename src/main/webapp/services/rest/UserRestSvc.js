app.factory('UserRestSvc', ['$resource', function($resource) {
	
	var factory = {
		usersList : $resource('/ws/user/list', {}, {
			list: {method:'GET', isArray:false},
		}),
		userRemove : $resource('/ws/user/delete/:id', {}, {
			remove: {method:'DELETE', isArray:false, params: { id: '@id'}},
		}),
		userAdd : $resource('/ws/user/create', {}, {
			add: {method:'POST'},
		}), 
		userUpdate : $resource('/ws/user/update', {}, {
			update: {method:'PUT'},
		})
	}
	
	return factory;
}]);