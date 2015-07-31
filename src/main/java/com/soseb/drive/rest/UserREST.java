package com.soseb.drive.rest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.xpath.XPath;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soseb.drive.constants.NasConstants;
import com.soseb.drive.models.User;

@RestController
@RequestMapping(value = "/user")
public class UserREST {

	private String xmlFile = NasConstants.URL_XML_FILE_AUTHENTICATION + NasConstants.NAME_XML_FILE_AUTHENTICATION;

	/**
	 * Create user
	 * @param userToCreate
	 * 			the user with elements to create
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public boolean createUser(@RequestParam(value = "userToCreate") final User userToCreate) {

		boolean isInserted = false;	
		Document doc = null;
		File file = new File(xmlFile);
		Element rootNode = null;
		Element user = null;

		try {

			// File doesn't exist
			if (!file.exists()) {

				// root element
				rootNode = new Element("users-group");
				doc = new Document();
				doc.setRootElement(rootNode);

				// user element
				user = new Element("user");
				user.setAttribute(new Attribute("id", "1"));

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


			user.addContent(new Element("login").setText(userToCreate.getLogin()));
			user.addContent(new Element("password").setText(userToCreate.getPassword()));
			user.addContent(new Element("isAuthorized").setText(String.valueOf(userToCreate.isAuthorized())));
			user.addContent(new Element("rightStartDate").setText(String.valueOf(userToCreate.getRightStartDate())));
			user.addContent(new Element("rightEndDate").setText(String.valueOf(userToCreate.getRightEndDate())));

			doc.getRootElement().addContent(user);

			XMLOutputter xmlOutput = new XMLOutputter();
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(doc, new FileWriter(xmlFile));

			isInserted = true;
		} catch (IOException io) {
			io.printStackTrace();
		} catch (JDOMException jdom) {
			jdom.printStackTrace();
		}
		return isInserted;
	}

	/**
	 * Update user
	 * @param userId
	 * 			the user id
	 * @param userToUpdate
	 * 			the user with elements to update
	 * @return
	 */
	@RequestMapping(value = "/update/{userid}", method = RequestMethod.PUT)
	public boolean updateUser(@RequestParam(value = "userToUpdate") final User userToUpdate, @PathVariable(value = "userid") final Integer userId) {

		boolean isUpdated = false;	
		Document doc = null;
		File file = new File(xmlFile);
		Element rootNode = null;

		try {

			// file doesn't exist
			if (!file.exists()) {
				//TODO error
			} else {

				// get the current xml file
				SAXBuilder builder = new SAXBuilder();		 
				doc = (Document) builder.build(file);
				rootNode = doc.getRootElement();

				// get the last id
				List<Element> listUsers = rootNode.getChildren("user");

				// remove the element passing in parameter
				for (int i=0 ; i < listUsers.size(); i++) {
					if (listUsers.get(i).getAttributeValue("id").equals(String.valueOf(userId))) {
						updateUser(userToUpdate, doc, listUsers.get(i));
						break;
					}
				}				
			}

		} catch (IOException io) {
			io.printStackTrace();
		} catch (JDOMException jdom) {
			jdom.printStackTrace();
		}
		return isUpdated;
	}

	/**
	 * Delete user
	 * @param userId
	 * 			the user id
	 * @return
	 */
	@RequestMapping(value = "/delete/{userid}", method = RequestMethod.DELETE)
	public boolean deleteUser(@PathVariable(value = "userid") final Integer userId) {

		boolean isDeleted = false;	
		Document doc = null;
		File file = new File(xmlFile);

		try {

			// file doesn't exist
			if (!file.exists()) {
				//TODO error
			} else {

				// get the current xml file
				SAXBuilder builder = new SAXBuilder();		 
				doc = (Document) builder.build(file);

				@SuppressWarnings("deprecation")
				XPath xpath = XPath.newInstance("//users-group/user[@id=" + userId + "]");
				@SuppressWarnings("deprecation")
				Element el = (Element) xpath.selectSingleNode(doc);
				isDeleted = el.getParent().removeContent(el);
			}

		} catch (IOException io) {
			io.printStackTrace();
		} catch (JDOMException jdom) {
			jdom.printStackTrace();
		}
		return isDeleted;
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
	private void updateUser(User userToUpdate, Document doc, Element element) {
		try {
			element.getChild("login").setText(userToUpdate.getLogin());
			element.getChild("password").setText(userToUpdate.getPassword());
			element.getChild("isAuthorized").setText(String.valueOf(userToUpdate.isAuthorized()));
			element.getChild("rightStartDate").setText(String.valueOf(userToUpdate.getRightStartDate()));
			element.getChild("rightEndDate").setText(String.valueOf(userToUpdate.getRightEndDate()));

			XMLOutputter xmlOutput = new XMLOutputter();
			xmlOutput.setFormat(Format.getPrettyFormat());

			xmlOutput.output(doc, new FileWriter(xmlFile));
		} catch (IOException io) {
			io.printStackTrace();
		}		
	}

}
