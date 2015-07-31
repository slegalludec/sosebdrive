package com.soseb.drive.responses;

import java.io.Serializable;

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
	 * user id
	 */
	private int userId;
	
	/**
	 * user trackid
	 */
	private String trackid;

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
	
}
