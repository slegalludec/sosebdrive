package com.soseb.drive.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soseb.drive.controllers.ConnectionController;
import com.soseb.drive.models.User;
import com.soseb.drive.responses.ConnectionResponse;

@RestController
@RequestMapping(value = "/authentication")
public class ConnectionREST {

	@Autowired
	private ConnectionController connectionCtrl;
	
	/**
	 * Connect user with login/password (REST)
	 * @return
	 */
	@RequestMapping(value = "/connection", method = RequestMethod.POST)
	public ConnectionResponse connection(@RequestBody final User connection) {
		return connectionCtrl.connection(connection);	
	}
}
