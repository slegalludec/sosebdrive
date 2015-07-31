package com.soseb.drive.rest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soseb.drive.common.StatusCode;
import com.soseb.drive.constants.NasConstants;
import com.soseb.drive.responses.ConnectionResponse;

@RestController
@RequestMapping(value = "/authentication")
public class AuthenticationREST {

	private String xmlFile = NasConstants.URL_XML_FILE_AUTHENTICATION + NasConstants.NAME_XML_FILE_AUTHENTICATION;

	/**
	 * 	 * Connect user with login/password
	 * @param login
	 * 			the user login (frontend)
	 * @param password
	 * 			the user password (frontend)
	 * @return
	 */
	@RequestMapping(value = "/connection", method = RequestMethod.POST)
	public ConnectionResponse connection(@RequestParam(value="login") final String login, @RequestParam(value="password") final String password) {

		Document doc = null;
		File file = new File(xmlFile);
		Element rootNode = null;
		ConnectionResponse connectionResponse = new ConnectionResponse();
		
		// login or password is empty
		if (false) {
			connectionResponse.setResponseCode(StatusCode.CODE_100.getCode());
		} else {

			try {

				// file doesn't exist
				if (!file.exists()) {
					//TODO error
				} else {
					
					// get the current xml file
					SAXBuilder builder = new SAXBuilder();		 
					doc = (Document) builder.build(file);
					rootNode = doc.getRootElement();

					// get the list of users
					List<Element> listUsers = rootNode.getChildren("user");

					// check if user is present in authentication file
					for (int i=0 ; i < listUsers.size(); i++) {
						if (listUsers.get(i).getChildText("login").equals(login)
								&& listUsers.get(i).getChildText("password").equals(password)) {
								// TODO check date
							if (true) {
								connectionResponse.setResponseCode(StatusCode.CODE_1.getCode());
								connectionResponse.setUserId(listUsers.get(i).getAttribute("id").getIntValue());
								//connectionResponse.setTrackid(trackid);
							} else {
								// end date of right is expired
								connectionResponse.setResponseCode(StatusCode.CODE_102.getCode());
							}					
							break;
						} else {
							// login or password are bad
							connectionResponse.setResponseCode(StatusCode.CODE_101.getCode());
						}
					}
				}
			} catch (IOException io) {
				io.printStackTrace();
			} catch (JDOMException jdom) {
				jdom.printStackTrace();
			}
		}
		return connectionResponse;

	}
}
