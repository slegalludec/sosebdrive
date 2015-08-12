package com.soseb.drive.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soseb.drive.controllers.DriveController;
import com.soseb.drive.responses.DriveResponse;

@RestController
@RequestMapping(value = "/drive")
public class DriveREST {

	@Autowired
	private DriveController driveCtrl;
	
	/**
	 * Move in multimedia tree and create a list of folders with files
	 * @return the multimedia content
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public DriveResponse listFilesForFolder(@RequestParam(value = "rootName", required = false) final String rootName) {
		return driveCtrl.listFilesForFolder(rootName);
	}
}
