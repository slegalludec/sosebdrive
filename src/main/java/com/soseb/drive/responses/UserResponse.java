package com.soseb.drive.responses;

import java.io.Serializable;
import java.util.List;

import com.soseb.drive.models.User;

/**
 * User response
 * @author slegalludec
 *
 */
public class UserResponse implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * response code
	 */
	private int responseCode;
	
	/**
	 * users list
	 */
	private List<User> usersList;
	
	/**
	 * response error
	 */
	private String responseError;

	/**
	 * @return the responseCode
	 */
	public int getResponseCode() {
		return responseCode;
	}

	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @return the usersList
	 */
	public List<User> getUsersList() {
		return usersList;
	}

	/**
	 * @param usersList the usersList to set
	 */
	public void setUsersList(List<User> usersList) {
		this.usersList = usersList;
	}

	/**
	 * @return the responseError
	 */
	public String getResponseError() {
		return responseError;
	}

	/**
	 * @param responseError the responseError to set
	 */
	public void setResponseError(String responseError) {
		this.responseError = responseError;
	}
		
}
