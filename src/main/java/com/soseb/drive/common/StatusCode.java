package com.soseb.drive.common;

public enum StatusCode {
	
	CODE_1(1, "user connected"),
	CODE_2(2, "users list"),
	CODE_3(3, "new user created"),
	CODE_4(4, "user is updated"),
	CODE_5(5, "user is removed"),
	COD_10(10, "new file multimediaAuthent.xml is created"),
	CODE_100(100, "login or pasword empty"),
	CODE_101(101, "bad login or bad password"),
	CODE_102(102, "user right expired"),
	CODE_103(103, "authentication file not founded !"),
	CODE_104(104, "fields are empty or null"),
	CODE_105(105, "error during removed element"),
	CODE_110(110, "unknow error"),
	CODE_111(111, "ws error"),
	CODE_112(112, "trackid is invalid");

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
