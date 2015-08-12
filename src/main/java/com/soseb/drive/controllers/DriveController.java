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
	 * @return the multimedia content
	 */
	public DriveResponse listFilesForFolder(final String rootName) {

		DriveResponse driveResponse = null;
		File rootFolder = new File(NasConstants.URL_MULTIMEDIA_SERVER_INTERNAL);
		String currentUrl = NasConstants.URL_MULTIMEDIA_SERVER_EXTERNAL;

		if (StringUtils.isNotBlank(rootName)) {
			rootFolder = new File(NasConstants.URL_MULTIMEDIA_SERVER_INTERNAL + "/" + rootName);
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
				String[] splitInitUrl = NasConstants.URL_MULTIMEDIA_SERVER_EXTERNAL.split("/");
				driveResponse.setRootName(splitInitUrl[splitInitUrl.length-1]);
			} else {
				driveResponse.setRootName(rootName);
			}
		}
		return driveResponse;
	}
}
