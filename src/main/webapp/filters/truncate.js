app.filter("truncate", function() {
	return function(nameDoc) {
		return nameDoc.length > 9 ? nameDoc.substring(0,9) : nameDoc;
	}
});