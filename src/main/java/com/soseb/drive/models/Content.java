package com.soseb.drive.models;

import java.io.Serializable;

/**
 * file model
 * @author slegalludec
 *
 */
public class Content implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * file name
	 */
	private String name;
	
	/**
	 * file url
	 */
	private String url;
	
	/**
	 * file type
	 */
	private String type;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
}
