package com.soseb.drive.models;

import java.io.Serializable;
import java.util.List;

/**
 * folder model
 * @author slegalludec
 *
 */
public class Folder implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * folder name
	 */
	private String name;
	
	/**
	 * folders list
	 */
	private List<Folder> foldersList;
	
	/**
	 * files list
	 */
	private List<Content> filesList;

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
	 * @return the foldersList
	 */
	public List<Folder> getFoldersList() {
		return foldersList;
	}

	/**
	 * @param foldersList the foldersList to set
	 */
	public void setFoldersList(List<Folder> foldersList) {
		this.foldersList = foldersList;
	}

	/**
	 * @return the filesList
	 */
	public List<Content> getFilesList() {
		return filesList;
	}

	/**
	 * @param filesList the filesList to set
	 */
	public void setFilesList(List<Content> filesList) {
		this.filesList = filesList;
	}	
}
