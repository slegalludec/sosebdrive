package com.soseb.drive.responses;

import java.io.Serializable;

import com.soseb.drive.session.UserSession;

/**
 * Connection response
 * @author slegalludec
 *
 */
public class ConnectionResponse implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * response code
	 */
	private int responseCode;
	
	/**
	 * user session
	 */
	private UserSession userSession;
	
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
	 * @return the userSession
	 */
	public UserSession getUserSession() {
		return userSession;
	}

	/**
	 * @param userSession the userSession to set
	 */
	public void setUserSession(UserSession userSession) {
		this.userSession = userSession;
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
