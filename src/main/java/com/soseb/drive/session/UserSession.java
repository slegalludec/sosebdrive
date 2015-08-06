package com.soseb.drive.session;

import java.io.Serializable;

public class UserSession implements Serializable{

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
	private String login;
	
	/**
	 * user trackid
	 */
	private String trackid;
	
	/**
	 * user right
	 */
	private int right;

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
	 * @return the trackid
	 */
	public String getTrackid() {
		return trackid;
	}

	/**
	 * @param trackid the trackid to set
	 */
	public void setTrackid(String trackid) {
		this.trackid = trackid;
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
}
