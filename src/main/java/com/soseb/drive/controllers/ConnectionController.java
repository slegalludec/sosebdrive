package com.soseb.drive.controllers;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.springframework.stereotype.Component;

import com.soseb.drive.common.StatusCode;
import com.soseb.drive.constants.NasConstants;
import com.soseb.drive.models.User;
import com.soseb.drive.responses.ConnectionResponse;
import com.soseb.drive.session.UserSession;
import com.soseb.drive.utils.DateUtils;
import com.soseb.drive.utils.TrackidUtils;

@Component
public class ConnectionController {

	private String xmlFile = NasConstants.URL_XML_FILE_AUTHENTICATION + NasConstants.NAME_XML_FILE_AUTHENTICATION;

	/**
	 * Connect user with login/password
	 * @return
	 */
	public ConnectionResponse connection(final User connection) {

		ConnectionResponse connectionResponse = new ConnectionResponse();
		Document doc = null;
		File file = new File(xmlFile);
		Element rootNode = null;

		// login or password is empty
		if (connection == null || StringUtils.isBlank(connection.getLogin()) || StringUtils.isBlank(connection.getPassword())) {
			connectionResponse.setResponseCode(StatusCode.CODE_100.getCode());
			connectionResponse.setResponseError(StatusCode.CODE_100.getDescription());
		} else {

			try {

				// file doesn't exist
				if (!file.exists()) {
					connectionResponse.setResponseCode(StatusCode.CODE_103.getCode());
					connectionResponse.setResponseError(StatusCode.CODE_103.getDescription()); 
				} else {

					// get the current xml file
					SAXBuilder builder = new SAXBuilder();		 
					doc = (Document) builder.build(file);
					rootNode = doc.getRootElement();

					// get the list of users
					List<Element> listUsers = rootNode.getChildren("user");

					// check if user is present in authentication file
					for (int i=0 ; i < listUsers.size(); i++) {
						if (listUsers.get(i).getChildText("login").equals(connection.getLogin())
								&& listUsers.get(i).getChildText("password").equals(connection.getPassword())) {
							
							// date format
							Date startDate = new Date();
							Date endDate = new Date();
							SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
							startDate = format.parse(listUsers.get(i).getChildText("rightStartDate"));
							endDate = format.parse(listUsers.get(i).getChildText("rightEndDate"));
							
							// check date
							if (DateUtils.checkDate(startDate, endDate)) {
								
								UserSession userSession = new UserSession();
								userSession.setUserId(Integer.parseInt(listUsers.get(i).getAttributeValue("id")));
								userSession.setLogin(listUsers.get(i).getChildText("login"));
								userSession.setRight(Integer.parseInt(listUsers.get(i).getChildText("right")));
								userSession.setTrackid(TrackidUtils.generateTrackId());
								
								connectionResponse.setResponseCode(StatusCode.CODE_1.getCode());
								connectionResponse.setResponseError(StatusCode.CODE_1.getDescription());
								connectionResponse.setUserSession(userSession);
							} else {
								// end date of right is expired
								connectionResponse.setResponseCode(StatusCode.CODE_102.getCode());
								connectionResponse.setResponseError(StatusCode.CODE_102.getDescription());
							}					
							break;
						} else {
							// login or password are bad
							connectionResponse.setResponseCode(StatusCode.CODE_101.getCode());
							connectionResponse.setResponseError(StatusCode.CODE_101.getDescription());
						}
					}
				}
			} catch (IOException io) {
				io.printStackTrace();
				connectionResponse.setResponseCode(StatusCode.CODE_111.getCode());
				connectionResponse.setResponseError(io.getMessage());
			} catch (JDOMException jdom) {
				jdom.printStackTrace();
				connectionResponse.setResponseCode(StatusCode.CODE_111.getCode());
				connectionResponse.setResponseError(jdom.getMessage());
			} catch (ParseException e) {
				e.printStackTrace();
				connectionResponse.setResponseCode(StatusCode.CODE_111.getCode());
				connectionResponse.setResponseError(e.getMessage());
			}
		}
		return connectionResponse;
	}
	
}
