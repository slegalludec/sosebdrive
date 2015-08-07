package com.soseb.drive.controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.soseb.drive.common.StatusCode;
import com.soseb.drive.constants.NasConstants;
import com.soseb.drive.models.User;
import com.soseb.drive.responses.UserResponse;

@Component
public class UserController {	

	private String xmlFile = NasConstants.URL_XML_FILE_AUTHENTICATION + NasConstants.NAME_XML_FILE_AUTHENTICATION;

	/**
	 * Create user
	 * @param userToCreate
	 * 			the user with elements to create
	 * @return
	 */
	public UserResponse create(@RequestBody final User userBdd) {

		UserResponse userResponse = null;
		Document doc = null;
		File file = new File(xmlFile);
		Element rootNode = null;
		Element user = null;
		boolean fistInsert = false;

		try {

			if (!checkField(userBdd)) {
				userResponse = new UserResponse();
				userResponse.setResponseCode(StatusCode.CODE_104.getCode());
				userResponse.setResponseError(StatusCode.CODE_104.getDescription());
			} else {
				// File doesn't exist
				if (!file.exists()) {

					// root element
					rootNode = new Element("users-group");
					doc = new Document();
					doc.setRootElement(rootNode);

					// user element
					user = new Element("user");
					user.setAttribute(new Attribute("id", "1"));

					// first insertion
					fistInsert = true;

				} else {

					// Get the current xml file
					SAXBuilder builder = new SAXBuilder();		 
					doc = (Document) builder.build(file);
					rootNode = doc.getRootElement();

					// get the last id
					List<Element> listUsers = rootNode.getChildren("user");
					int nextId = Integer.parseInt(listUsers.get(listUsers.size()-1).getAttributeValue("id")) + 1;

					// user element
					user = new Element("user");
					user.setAttribute(new Attribute("id", String.valueOf(nextId)));
				}

				user.addContent(new Element("login").setText(userBdd.getLogin()));
				user.addContent(new Element("password").setText(userBdd.getPassword()));
				user.addContent(new Element("right").setText(String.valueOf(userBdd.getRight())));
				user.addContent(new Element("rightStartDate").setText(String.valueOf(userBdd.getRightStartDate())));
				user.addContent(new Element("rightEndDate").setText(String.valueOf(userBdd.getRightEndDate())));

				doc.getRootElement().addContent(user);

				XMLOutputter xmlOutput = new XMLOutputter();
				xmlOutput.setFormat(Format.getPrettyFormat());
				xmlOutput.output(doc, new FileWriter(xmlFile));

				userResponse = list();

				// indicate the first insertion
				if (fistInsert) {
					userResponse.setResponseCode(StatusCode.COD_10.getCode());
					userResponse.setResponseError("New file " + xmlFile + " is created !");
				} else {
					userResponse.setResponseCode(StatusCode.CODE_3.getCode());
					userResponse.setResponseError("User " + userBdd.getLogin() + " is created !");
				}
			}



		} catch (IOException io) {
			io.printStackTrace();
			userResponse = new UserResponse();
			userResponse.setResponseCode(StatusCode.CODE_111.getCode());
			userResponse.setResponseError(io.getMessage());
		} catch (JDOMException jdom) {
			jdom.printStackTrace();
			userResponse = new UserResponse();
			userResponse.setResponseCode(StatusCode.CODE_111.getCode());
			userResponse.setResponseError(jdom.getMessage());
		}
		return userResponse;
	}

	/**
	 * Update user
	 * @param userId
	 * 			the user id
	 * @param userToUpdate
	 * 			the user with elements to update
	 * @return
	 */
	public UserResponse update(@RequestBody final User userBdd) {

		UserResponse userResponse = null;
		Document doc = null;
		File file = new File(xmlFile);
		Element rootNode = null;

		try {

			// file doesn't exist
			if (!file.exists()) {
				userResponse = new UserResponse();
				userResponse.setResponseCode(StatusCode.CODE_103.getCode());
				userResponse.setResponseError(StatusCode.CODE_103.getDescription()); 
			} else if (!checkField(userBdd)) {
				userResponse = new UserResponse();
				userResponse.setResponseCode(StatusCode.CODE_104.getCode());
				userResponse.setResponseError(StatusCode.CODE_104.getDescription()); 			
			} else {

				// get the current xml file
				SAXBuilder builder = new SAXBuilder();		 
				doc = (Document) builder.build(file);
				rootNode = doc.getRootElement();

				// get the last id
				List<Element> listUsers = rootNode.getChildren("user");

				// remove the element passing in parameter
				for (int i=0 ; i < listUsers.size(); i++) {
					if (listUsers.get(i).getAttributeValue("id").equals(String.valueOf(userBdd.getUserId()))) {
						updateUser(userBdd, doc, listUsers.get(i));
						break;
					}
				}
				userResponse = list();
				userResponse.setResponseCode(StatusCode.CODE_4.getCode());
				userResponse.setResponseError("User " + userBdd.getLogin() + " is updated !");
			}

		} catch (IOException io) {
			io.printStackTrace();
			userResponse = new UserResponse();
			userResponse.setResponseCode(StatusCode.CODE_111.getCode());
			userResponse.setResponseError(io.getMessage());
		} catch (JDOMException jdom) {
			jdom.printStackTrace();
			userResponse = new UserResponse();
			userResponse.setResponseCode(StatusCode.CODE_111.getCode());
			userResponse.setResponseError(jdom.getMessage());
		}
		return userResponse;
	}

	/**
	 * Delete user
	 * @param userId
	 * 			the user id
	 * @return
	 */
	public UserResponse delete(final Integer userId, final String trackid) {

		UserResponse userResponse = null;

		//if (TrackidUtils.trackidIsValid(userTrackid, trackid)) {
			Document doc = null;
			Element rootNode = null;
			File file = new File(xmlFile);
			boolean isRemoved = false;

			try {

				// file doesn't exist
				if (!file.exists()) {
					userResponse = new UserResponse();
					userResponse.setResponseCode(StatusCode.CODE_103.getCode());
					userResponse.setResponseError(StatusCode.CODE_103.getDescription()); 
				} else if (userId == null || userId == 0) {
					userResponse = new UserResponse();
					userResponse.setResponseCode(StatusCode.CODE_104.getCode());
					userResponse.setResponseError(StatusCode.CODE_104.getDescription()); 								
				} else {

					// get the current xml file
					SAXBuilder builder = new SAXBuilder();		 
					doc = (Document) builder.build(file);
					rootNode = doc.getRootElement();

					// get the last id
					List<Element> listUsers = rootNode.getChildren("user");
					Iterator<Element> itr = listUsers.iterator();

					while (itr.hasNext()) {
						Element child = (Element) itr.next();
						String att = child.getAttributeValue("id"); 
						if( Integer.parseInt(att) == userId){
							itr.remove();
							isRemoved = true;
							break;
						}
					}

					XMLOutputter xmlOutput = new XMLOutputter();
					xmlOutput.setFormat(Format.getPrettyFormat());

					xmlOutput.output(doc, new FileWriter(xmlFile));

					userResponse = list();
					if (isRemoved) {					
						userResponse.setResponseCode(StatusCode.CODE_5.getCode());
						userResponse.setResponseError("User with id " + userId + " is removed !");
					} else {
						userResponse.setResponseCode(StatusCode.CODE_105.getCode());
						userResponse.setResponseError(StatusCode.CODE_105.getDescription());
					}
				}

			} catch (IOException io) {
				io.printStackTrace();
				userResponse = new UserResponse();
				userResponse.setResponseCode(StatusCode.CODE_111.getCode());
				userResponse.setResponseError(io.getMessage());
			} catch (JDOMException jdom) {
				jdom.printStackTrace();
				userResponse = new UserResponse();
				userResponse.setResponseCode(StatusCode.CODE_111.getCode());
				userResponse.setResponseError(jdom.getMessage());
			}
		/**} else {
			userResponse = new UserResponse();
			userResponse.setResponseCode(StatusCode.CODE_112.getCode());
			userResponse.setResponseError(StatusCode.CODE_112.getDescription());
		}*/


		return userResponse;
	}

	/**
	 * Get list of users
	 * @return
	 */
	public UserResponse list() {

		UserResponse userResponse = new UserResponse();
		List<User> listUsers = new ArrayList<User>();
		Document doc = null;
		File file = new File(xmlFile);
		Element rootNode = null;

		try {

			// file doesn't exist
			if (!file.exists()) {
				userResponse.setResponseCode(StatusCode.CODE_103.getCode());
			} else {

				// get the current xml file
				SAXBuilder builder = new SAXBuilder();		 
				doc = (Document) builder.build(file);
				rootNode = doc.getRootElement();

				// get the last id
				List<Element> listUsersXml = rootNode.getChildren("user");

				// remove the element passing in parameter
				for (int i=0 ; i < listUsersXml.size(); i++) {
					User currentUser = new User();
					currentUser.setUserId(listUsersXml.get(i).getAttribute("id").getIntValue());
					currentUser.setLogin(listUsersXml.get(i).getChild("login").getValue());
					currentUser.setPassword(listUsersXml.get(i).getChild("password").getValue());
					currentUser.setRight(Integer.parseInt(listUsersXml.get(i).getChild("right").getValue()));
					currentUser.setRightStartDate(listUsersXml.get(i).getChild("rightStartDate").getValue());
					currentUser.setRightEndDate(listUsersXml.get(i).getChild("rightEndDate").getValue());
					listUsers.add(currentUser);
				}				

				// Success 
				userResponse.setResponseCode(StatusCode.CODE_2.getCode());
				userResponse.setUsersList(listUsers);
			}

		} catch (IOException io) {
			io.printStackTrace();
			userResponse.setResponseCode(StatusCode.CODE_111.getCode());
			userResponse.setResponseError(io.getMessage());
		} catch (JDOMException jdom) {
			jdom.printStackTrace();
			userResponse.setResponseCode(StatusCode.CODE_111.getCode());
			userResponse.setResponseError(jdom.getMessage());
		}
		return userResponse;
	}

	/**
	 * Update user with new values
	 * @param userToUpdate
	 * 		the user to update
	 * @param doc
	 * 		the current document
	 * @param element
	 * 		the current element
	 */
	private void updateUser(final User userToUpdate, final Document doc, final Element element) {
		try {
			element.getChild("login").setText(userToUpdate.getLogin());
			element.getChild("password").setText(userToUpdate.getPassword());
			element.getChild("right").setText(String.valueOf(userToUpdate.getRight()));
			element.getChild("rightStartDate").setText(String.valueOf(userToUpdate.getRightStartDate()));
			element.getChild("rightEndDate").setText(String.valueOf(userToUpdate.getRightEndDate()));

			XMLOutputter xmlOutput = new XMLOutputter();
			xmlOutput.setFormat(Format.getPrettyFormat());

			xmlOutput.output(doc, new FileWriter(xmlFile));
		} catch (IOException io) {
			io.printStackTrace();
		}		
	}

	/**
	 * Check if fields received of front are not empty or null
	 * @param user
	 * 		the current user
	 * @return boolean to indicate if ok or not
	 */
	private boolean checkField(final User user) {
		if (StringUtils.isNotBlank(user.getLogin()) ||
				StringUtils.isNotBlank(user.getPassword()) ||
				user.getRightStartDate() != null || 
				user.getRightEndDate() != null || 
				user.getRight() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
}
