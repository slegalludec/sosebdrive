app.filter("formatPath", function() {
	return function(path) {
		var splitPath = path.split('/');
		return splitPath[splitPath.length-1];
	}
});