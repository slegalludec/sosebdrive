package com.soseb.drive.responses;

import java.io.Serializable;
import java.util.List;

import com.soseb.drive.models.Content;

/**
 * Drive response
 * @author slegalludec
 *
 */
public class DriveResponse implements Serializable{

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
	private List<Content> contentsList;
	
	/**
	 * 
	 */
	private String rootName;
	
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
	 * @return the contentsList
	 */
	public List<Content> getContentsList() {
		return contentsList;
	}

	/**
	 * @param contentsList the contentsList to set
	 */
	public void setContentsList(List<Content> contentsList) {
		this.contentsList = contentsList;
	}
	
	/**
	 * @return the rootName
	 */
	public String getRootName() {
		return rootName;
	}

	/**
	 * @param rootName the rootName to set
	 */
	public void setRootName(String rootName) {
		this.rootName = rootName;
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
