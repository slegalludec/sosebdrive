app.controller('UserManagementCtrl', ['$scope', '$translate', 'UserRestSvc', 'LoggerSvc', function ($scope, $translate, UserRestSvc, LoggerSvc){

	$scope.isCreationMode = true;
	$scope.userBdd = {};
	$scope.buttons = 'buttonsOnly';

	/* current language */
	var language =  $translate.use();

	/* Initialize input position */
	$scope.inputLoginUser = 'inputLoginUser_' + language;
	$scope.inputPasswordUser = 'inputPasswordUser_' + language;
	$scope.inputRight = 'inputRight_' + language;
	$scope.inputStartDate = 'inputStartDate_' + language;
	$scope.inputEndDate = 'inputEndDate_' + language;
	$scope.positionLogin = 'inputLoginEn';
	$scope.positionPassword = 'inputPasswordEn';

	$scope.rights = [
	     {
	    	 'id' : 1,
	    	 'label' : 'administrator'
	     },
	     {
	    	 'id' : 2,
	    	 'label' : 'simple user'
	     }
	];

	$scope.selectedRight = $scope.rights[1];

	/**
	 * Init users list
	 */
	$scope.initList = function() {
		UserRestSvc.usersList.list(function(response) {
			LoggerSvc.log('success list user');
			$scope.users = response.usersList;
		},
		function(response) {
			LoggerSvc.log('error list user : ' + response.data.status, 'e');
		});
	}

	/**
	 * Add a new user
	 * @param userBdd
	 */
	$scope.add = function(userBdd) {
		UserRestSvc.userAdd.add({'userToCreate':userBdd}, function(response) {
			LoggerSvc.log('success add user');
			$scope.users = response.usersList;
			userBdd = "";
		},
		function(response) {
			LoggerSvc.log('error add user[login=' + userBdd.login + '] : ' + response.data.status, 'e');
		});
	};

	/**
	 * Update the user selected
	 * @param userBdd
	 */
	$scope.update = function(userBdd) {
		UserRestSvc.userUpdate.update({'userToUpdate':userBdd, 'userid':userBdd.id}, function(response) {
			LoggerSvc.log('success update user');
			$scope.users = response.usersList;
			userBdd = "";
		},
		function(response) {
			LoggerSvc.log('error update user[id=' + userBdd.userId + '] : ' + response.data.status, 'e');
		});
	};

	/**
	 * Remove the user selected
	 * @param userBdd
	 */
	$scope.remove = function(userBdd) {
		UserRestSvc.userRemove.remove({id: userBdd.userId}, function(response) {
			LoggerSvc.log('success remove user');
			$scope.users = response.usersList;
		},
		function(response) {
			LoggerSvc.log('error remove user[id=' + userBdd.userId + '] : ' + response.data.status, 'e');
		});
	};

	/**
	 * Show user details
	 * @param id
	 */
	$scope.details = function(id) {
		var userList = $scope.users;

		for (var item in userList) {
			if (userList[item].userId == id) {
				$scope.userBdd = userList[item];
				$scope.isCreationMode = false;
				$scope.buttons = 'buttonsMutli';
				$scope.selectedRight = $scope.rights[userList[item].right-1];
			}

		}
	};

	/**
	 * Cancel updating mode
	 */
	$scope.init = function() {
		$scope.isCreationMode = true;
		$scope.userBdd = {};
		$scope.buttons = 'buttonsOnly';
	}

}]);