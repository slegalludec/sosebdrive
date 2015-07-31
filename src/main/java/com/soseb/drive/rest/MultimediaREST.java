package com.soseb.drive.rest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soseb.drive.common.FileType;
import com.soseb.drive.constants.NasConstants;
import com.soseb.drive.models.Content;

@RestController
@RequestMapping(value = "/drive")
public class MultimediaREST {

	/**
	 * Move in multimedia tree and create a list of folders with files
	 * @return the multimedia content
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Content> listFilesForFolder(@RequestParam(value = "rootName") final String rootName) {

		File rootFolder = new File(NasConstants.URL_MULTIMEDIA__SERVER);

		if (StringUtils.isNotBlank(rootName)) {
			rootFolder = new File(NasConstants.URL_MULTIMEDIA__SERVER + rootName);
		}
		
		List<Content> listFiles = new ArrayList<Content>();

		for (final File fileEntry : rootFolder.listFiles()) {

			String fileName = fileEntry.getName();

			Content content = new Content();
			content.setUrl(rootFolder.getAbsolutePath() + "\\" + fileName);

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

		return listFiles;
	}
}
