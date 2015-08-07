package com.soseb.drive.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soseb.drive.controllers.UserController;
import com.soseb.drive.models.User;
import com.soseb.drive.responses.UserResponse;

@RestController
@RequestMapping(value = "/user")
public class UserREST {

	@Autowired
	private UserController userCtrl;
	
	/**
	 * Create user (REST)
	 * @param userToCreate
	 * 			the user with elements to create
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public UserResponse createUser(@RequestBody final User userBdd) {
		return userCtrl.create(userBdd);
	}
	
	/**
	 * Update user (REST)
	 * @param userId
	 * 			the user id
	 * @param userToUpdate
	 * 			the user with elements to update
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public UserResponse updateUser(@RequestBody final User userBdd) {
		return userCtrl.update(userBdd);
	}

	/**
	 * Delete user (REST)
	 * @param userId
	 * 			the user id
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}/{trackid}", method = RequestMethod.DELETE)
	public UserResponse deleteUser(@PathVariable(value = "id") final Integer userId, @PathVariable(value = "trackid") final String trackid) {
		return userCtrl.delete(userId, trackid);
	}

	/**
	 * Get list of users (REST)
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public UserResponse getUsers() {
		return userCtrl.list();
	}
}
