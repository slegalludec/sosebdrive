app.directive('backImg', function() {
    return {
    	restrict: 'A',
    	link : function (scope, element, attrs){
            var url = attrs.backImg;
            element.css({
                'background-image': 'url(' + url +')',
                'background-size' : 'cover'
            });
    	}
    }
});​