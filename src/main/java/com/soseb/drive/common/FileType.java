package com.soseb.drive.common;

public enum FileType {
	
	FOLDER_TYPE(1, "fol"),
	PDF_TYPE(2, "pdf"),
    WORD_TYPE(3, "doc"),
    EXCEL_TYPE(4, "xls"),
    PICTURE_TYPE(5, "png"),
    VIDEO_TYPE(6, "mp4"),
    POWERPOINT_TYPE(7, "ppt");

	/**
	 * file type
	 */
	private int fileType;
	
	/**
	 * file extension
	 */
	private String fileExtension;
	
	private FileType (int fileType, String fileExtension) {
		this.fileType = fileType;
		this.fileExtension = fileExtension;		
	}

	/**
	 * @return the fileType
	 */
	public int getFileType() {
		return fileType;
	}

	/**
	 * @param fileType the fileType to set
	 */
	public void setFileType(int fileType) {
		this.fileType = fileType;
	}

	/**
	 * @return the fileExtension
	 */
	public String getFileExtension() {
		return fileExtension;
	}

	/**
	 * @param fileExtension the fileExtension to set
	 */
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}
}
