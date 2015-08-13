package com.soseb.drive.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.soseb.drive.common.FileType;
import com.soseb.drive.common.StatusCode;
import com.soseb.drive.constants.NasConstants;
import com.soseb.drive.models.Content;
import com.soseb.drive.responses.DriveResponse;

@Component
public class DriveController {

	/**
	 * Move in multimedia tree and create a list of folders with files
	 * @param rootName : the name of root
	 * @return drive response
	 */
	public DriveResponse listFilesForFolder(final String rootName) {

		DriveResponse driveResponse = null;
		File rootFolder = new File(NasConstants.URL_MULTIMEDIA_SERVER_INTERNAL + NasConstants.ROOT_NAME);
		String currentUrl = NasConstants.URL_MULTIMEDIA_SERVER_EXTERNAL + NasConstants.ROOT_NAME + "/";

		if (StringUtils.isNotBlank(rootName) && !rootName.equals(NasConstants.ROOT_NAME)) {
			rootFolder = new File(NasConstants.URL_MULTIMEDIA_SERVER_INTERNAL + rootName + "/");
			currentUrl = NasConstants.URL_MULTIMEDIA_SERVER_EXTERNAL + rootName + "/";
		}

		List<Content> listFiles = new ArrayList<Content>();

		if (rootFolder.listFiles() == null) {
			driveResponse = new DriveResponse();
			driveResponse.setResponseCode(StatusCode.CODE_106.getCode());
			driveResponse.setResponseError(StatusCode.CODE_106.getDescription());
			driveResponse.setRootName(rootName);
		} else {

			for (final File fileEntry : rootFolder.listFiles()) {

				String fileName = fileEntry.getName();

				Content content = new Content();
				content.setUrl(currentUrl + fileName);

				// Manage the extension file and name
				// Folder case
				if (fileEntry.isDirectory()) {
					content.setName(fileName);
					content.setType(FileType.FOLDER_TYPE.getFileExtension());
				} else {
					content.setName(fileName.substring(0, fileName.length()-4));
					content.setType(fileName.substring(fileName.length()-3, fileName.length()));
				}

				listFiles.add(content);
			}
			
			driveResponse = new DriveResponse();
			driveResponse.setResponseCode(StatusCode.CODE_1.getCode());
			driveResponse.setContentsList(listFiles);
			
			if (StringUtils.isBlank(rootName)) {
				driveResponse.setRootName(NasConstants.ROOT_NAME);
			} else {
				driveResponse.setRootName(rootName);
			}
		}
		return driveResponse;
	}
	
	/**
	 * Create a new folder
	 * @param rootName : the name of root
	 * @return drive response
	 */
	public DriveResponse createFolder(final String rootName, final String newFolder) {

		DriveResponse driveResponse = new DriveResponse();
		
		File rootFolder = new File(NasConstants.URL_MULTIMEDIA_SERVER_INTERNAL + rootName + "/" + newFolder);
		boolean isFolderCreated = rootFolder.mkdir();
		
		if (isFolderCreated) {
			driveResponse.setResponseCode(StatusCode.CODE_11.getCode());
			driveResponse.setResponseError(StatusCode.CODE_11.getDescription());
		} else {
			driveResponse.setResponseCode(StatusCode.CODE_107.getCode());
			driveResponse.setResponseError(StatusCode.CODE_107.getDescription());
		}
		
		return driveResponse;
	}
	
	/**
	 * Rename a folder
	 * @param rootName : the name of root
	 * @param newName : the new name to the folder
	 * @return drive response
	 */
	public DriveResponse renameFolder(final String rootName, final String newName) {

		DriveResponse driveResponse = new DriveResponse();
		
		File rootFolder = new File(NasConstants.URL_MULTIMEDIA_SERVER_INTERNAL + rootName);

		boolean isFolderRemoved =  rootFolder.delete();
		
		if (isFolderRemoved) {
			driveResponse.setResponseCode(StatusCode.CODE_12.getCode());
			driveResponse.setResponseError(StatusCode.CODE_12.getDescription());
		} else {
			driveResponse.setResponseCode(StatusCode.CODE_108.getCode());
			driveResponse.setResponseError(StatusCode.CODE_108.getDescription());
		}
		
		return driveResponse;
	}
	
	/**
	 * Remove a folder
	 * @param rootName : the name of root
	 * @return drive response
	 */
	public DriveResponse removeFolder(final String rootName) {

		DriveResponse driveResponse = new DriveResponse();
		
		File rootFolder = new File(NasConstants.URL_MULTIMEDIA_SERVER_INTERNAL + rootName);
		boolean isFolderRemoved =  rootFolder.delete();
		
		if (isFolderRemoved) {
			driveResponse.setResponseCode(StatusCode.CODE_13.getCode());
			driveResponse.setResponseError(StatusCode.CODE_13.getDescription());
		} else {
			driveResponse.setResponseCode(StatusCode.CODE_109.getCode());
			driveResponse.setResponseError(StatusCode.CODE_109.getDescription());
		}
		
		return driveResponse;
	}
}
