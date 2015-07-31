package com.soseb.drive.common;

public enum StatusCode {
	
	CODE_1(1, "user connected"),
	CODE_100(100, "login or pasword empty"),
	CODE_101(101, "bad login or bad password"),
	CODE_102(102, "user right expired"),
	CODE_110(110, "unknow error");

	/**
	 * status code
	 */
	private int code;
	
	/**
	 * status description
	 */
	private String description;
	
	private StatusCode (int code, String description) {
		this.code = code;
		this.description = description;		
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
