package com.soseb.drive.models;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

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
	 * user id
	 */
	private int userId;
	
	/**
	 * user login
	 */
	@NotNull
	private String login;
	
	/**
	 * user password
	 */
	@NotNull
	private String password;
	
	/**
	 * user right
	 */
	@NotNull
	private int right;
	
	/**
	 * right start date
	 */
	@NotNull
	private String rightStartDate;
	
	/**
	 * right end date
	 */
	@NotNull
	private String rightEndDate;
	
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

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
	 * @return the right
	 */
	public int getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(int right) {
		this.right = right;
	}

	/**
	 * @return the rightStartDate
	 */
	public String getRightStartDate() {
		return rightStartDate;
	}

	/**
	 * @param rightStartDate the rightStartDate to set
	 */
	public void setRightStartDate(String rightStartDate) {
		this.rightStartDate = rightStartDate;
	}

	/**
	 * @return the rightEndDate
	 */
	public String getRightEndDate() {
		return rightEndDate;
	}

	/**
	 * @param rightEndDate the rightEndDate to set
	 */
	public void setRightEndDate(String rightEndDate) {
		this.rightEndDate = rightEndDate;
	}	
}
