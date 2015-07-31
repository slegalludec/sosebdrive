app.factory('LoggerSvc', function() {
	var logger = {};

	/**
	 * Return current date and currrent hour
	 */
	var currentDateTime = function() {
		var currentdate = new Date();
		var datetime = currentdate.getDate() + '/' +
		(currentdate.getMonth() + 1) + '/' +
		currentdate.getFullYear() + ' ' +
		currentdate.getHours() + ':' +
		currentdate.getMinutes() + ':' +
		currentdate.getSeconds();
		return datetime;
	}
	
	/**
 	* Return message received with date and hour and alert level 
 	*/	
	logger.log = function(msg, type) {
		var type = type || '';

		if(console) { // if JS console exist and service is on
			var message = currentDateTime() + ' - ' + msg;

			switch (type) {
			case 'e':
				console.error(message);
				break;
			case 'w':
				console.warn(message);
				break;
			case 'd':
				console.debug(message);
				break;
			default:
				console.log(message);
			break;
			}
		}
	};

	return logger;
});