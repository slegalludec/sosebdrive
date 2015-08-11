app.controller('UserManagementCtrl', ['$scope', '$translate', 'UserRestSvc', 'LoggerSvc', 'RedirectSvc', '$rootScope', '$location', '$window', function ($scope, $translate, UserRestSvc, LoggerSvc, RedirectSvc, $rootScope, $location, $window){

	$scope.isCreationMode = true;
	$scope.userBdd = {};
	$scope.buttons = 'buttonsOnly';
	$scope.msg = '';

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
	
	$scope.showTop = false;
	$scope.showBottom = false;

	/* rights list */
	$scope.rights = [{ 'id' : 1, 'label' : 'administrator' }, { 'id' : 2, 'label' : 'simple user' }];

	/* right selected by default */
	$scope.selectedRight = $scope.rights[1];

	/**
	 * Init users list
	 */
	$scope.initList = function() {
		UserRestSvc.usersList.list(
			function(response) {
				LoggerSvc.log('success list user');
				$scope.users = response.usersList;
			},
			function(response) {
				LoggerSvc.log('error list user : ' + response.data.status, 'e');
			}
		);
	}

	/**
	 * Add a new user
	 * @param userBdd
	 */
	$scope.add = function(userBdd) {		
		if (JSON.parse(sessionStorage.getItem($window.sessionStorage.login)).right == undefined) {
			LoggerSvc.log('error add user[login=' + userBdd.login + '] : 401', 'e');
			RedirectSvc.redirect();
		} else {
			userBdd.right = $scope.selectedRight.id;
			UserRestSvc.userAdd.add(userBdd, 
					function(response) {
				if (response.responseCode == '104') {
					LoggerSvc.log('error add : ' + response.responseCode, 'w');
					$scope.initList();
					$scope.classCSS = 'alert-warning';
					$scope.msg = response.responseError;
				} else {
					LoggerSvc.log('success add user');
					$scope.users = response.usersList;
					resetFields();
					$scope.classCSS = 'alert-info';
					$scope.msg = response.responseError;
				}
			},
			function(response) {
				LoggerSvc.log('error add user[login=' + userBdd.login + '] : ' + response.data.status, 'e');
			});
		}
		

	};

	/**
	 * Update the user selected
	 * @param userBdd
	 */
	$scope.update = function(userBdd) {
		if (JSON.parse(sessionStorage.getItem($window.sessionStorage.login)).right == undefined) {
			LoggerSvc.log('error update user[login=' + userBdd.login + '] : 401', 'e');
			$location.path('/error');
		} else {
			userBdd.right = $scope.selectedRight.id;
			UserRestSvc.userUpdate.update(userBdd, 
			function(response) {			
				if (response.responseCode == '104') {
					LoggerSvc.log('error update : ' + response.responseCode, 'w');
					$scope.initList();
					$scope.classCSS = 'alert-warning';
					$scope.msg = response.responseError;
				} else {
					LoggerSvc.log('success update user');
					$scope.users = response.usersList;
					resetFields();
					$scope.classCSS = 'alert-info';
					$scope.msg = response.responseError;
				}
			},
			function(response) {
				LoggerSvc.log('error update user[id=' + userBdd.userId + '] : ' + response.data.status, 'e');
			});
		}
	};

	/**
	 * Remove the user selected
	 * @param userBdd
	 */
	$scope.remove = function(userBdd) {
		if (JSON.parse(sessionStorage.getItem($window.sessionStorage.login)).right == undefined) {
			LoggerSvc.log('error remove user[id=' + userBdd.userId + '] : 401', 'e');
			$location.path('/error');
		} else {
			UserRestSvc.userRemove.remove({id:userBdd.userId, trackid : $rootScope.trackid}, 
				function(response) {
	
					if (response.responseCode == 1) {
						LoggerSvc.log('success remove user');
						$scope.users = response.usersList;
						resetFields();
					} else if(response.responseCode == 112) {
						$location.path('/error');
					} else {
						LoggerSvc.log('error connect : [code=' + response.responseCode + ']', 'e');
						$scope.classCSS = 'alert-info';
						$scope.msg = response.responseError;
					}				
	
				},
				function(response) {
					LoggerSvc.log('error remove user[id=' + userBdd.userId + '] : ' + response.data.status, 'e');
				});
		}
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

	/**
	 * Display or not the calendar top
	 */
	$scope.showCalendarTop = function(state) {
		if (state) {
			$scope.showTop = false;
		} else {
			$scope.showTop == true;
		}
	}
	
	/**
	 * Display or not the calendar top
	 */
	$scope.showCalendarBottom = function(state) {
		if (state) {
			$scope.showBottom = false;
		} else {
			$scope.showBottom == true;
		}
	}
	
	/**
	 * reset fields value
	 */
	var resetFields = function() {
		$scope.userBdd.login = "";
		$scope.userBdd.password = "";
		$scope.userBdd.rightStartDate = "";
		$scope.userBdd.rightEndDate = "";
		$scope.isCreationMode = true;
	}

}]);