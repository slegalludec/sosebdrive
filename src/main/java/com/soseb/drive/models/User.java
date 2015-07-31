package com.soseb.drive.models;

import java.io.Serializable;
import java.util.Date;

/**
 * User model
 * @author slegalludec
 *
 */
public class User implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * user login
	 */
	private String login;
	
	/**
	 * user password
	 */
	private String password;
	
	/**
	 * user right
	 */
	private boolean isAuthorized;
	
	/**
	 * right start date
	 */
	private Date rightStartDate;
	
	/**
	 * right end date
	 */
	private Date rightEndDate;

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the isAuthorized
	 */
	public boolean isAuthorized() {
		return isAuthorized;
	}

	/**
	 * @param isAuthorized the isAuthorized to set
	 */
	public void setAuthorized(boolean isAuthorized) {
		this.isAuthorized = isAuthorized;
	}

	/**
	 * @return the rightStartDate
	 */
	public Date getRightStartDate() {
		return rightStartDate;
	}

	/**
	 * @param rightStartDate the rightStartDate to set
	 */
	public void setRightStartDate(Date rightStartDate) {
		this.rightStartDate = rightStartDate;
	}

	/**
	 * @return the rightEndDate
	 */
	public Date getRightEndDate() {
		return rightEndDate;
	}

	/**
	 * @param rightEndDate the rightEndDate to set
	 */
	public void setRightEndDate(Date rightEndDate) {
		this.rightEndDate = rightEndDate;
	}	
}
