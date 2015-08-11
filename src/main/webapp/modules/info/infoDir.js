app.directive('info', function ($timeout) {
	return {
		restrict: 'E',
		scope: {
			background: '@background',
			msg: '@msg',
			isconnected: '@isconnected'
		},        
		controller: 'InfoCtrl',
		templateUrl: 'modules/info/info.html',
		link: function(scope, element, attrs) {
			$timeout(function () {
				element.remove();
			}, 3000);
		}
	};
});