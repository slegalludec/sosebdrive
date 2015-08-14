package com.soseb.drive.connection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.soseb.drive.common.StatusCode;
import com.soseb.drive.controllers.ConnectionController;
import com.soseb.drive.controllers.UserController;
import com.soseb.drive.models.User;
import com.soseb.drive.responses.ConnectionResponse;

/**
 * 
 *  connection test class
 * 
 * @author slegalludec
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ConnectionTest {

	@InjectMocks
	private ConnectionController connectionCtrl;
	
	@InjectMocks
	private UserController userCtrl;

	@Mock
	private User user;

	private User user2;
	private User user3;
	private User user4;
	private User user5;
	private User user6;
	private User user7;

	@InjectMocks
	private ConnectionResponse connectionResponse;

	@Before
	public void setUp() {
		// Create new user (1)
		user = new User();
		user.setUserId(10000);
		user.setLogin("Dupont");
		user.setPassword("dupont");
		user.setRight(1);
		user.setRightStartDate("23/05/2015");
		user.setRightEndDate("23/05/2030");

		// Create new user (2) [CODE = 100]
		user2 = new User();
		user2.setUserId(10001);
		user2.setLogin(null);
		user2.setPassword("dupont");
		user2.setRight(1);
		user2.setRightStartDate("23/05/2015");
		user2.setRightEndDate("23/05/2016");

		// Create new user (3) [CODE = 100]
		user3 = new User();
		user3.setUserId(10002);
		user3.setLogin("Dupont");
		user3.setPassword(null);
		user3.setRight(1);
		user3.setRightStartDate("23/05/2015");
		user3.setRightEndDate("23/05/2016");

		// Create new user (4) [CODE = 101]
		user4 = new User();
		user4.setUserId(10003);
		user4.setLogin("azertyuiopmlkjhgfdsqnbvcxw");
		user4.setPassword("dupont");
		user4.setRight(1);
		user4.setRightStartDate("23/05/2015");
		user4.setRightEndDate("23/05/2016");

		// Create new user (5) [CODE = 101]
		user5 = new User();
		user5.setUserId(10004);
		user5.setLogin("Dupont");
		user5.setPassword("azertyuiopmlkjhgfdsqnbvcxw");
		user5.setRight(1);
		user5.setRightStartDate("23/05/2015");
		user5.setRightEndDate("23/05/2016");

		// Create new user (6) [CODE = 102]
		user6 = new User();
		user6.setUserId(10005);
		user6.setLogin("Dupont");
		user6.setPassword("dupont");
		user6.setRight(1);
		user6.setRightStartDate("23/05/2013");
		user6.setRightEndDate("23/05/2014");
		
		// Create new user (7) [CODE = 102]
		user7 = new User();
		user7.setUserId(10006);
		user7.setLogin("Thales");
		user7.setPassword("thales");
		user7.setRight(1);
		user7.setRightStartDate("23/05/2016");
		user7.setRightEndDate("23/05/2018");
	}

	@After
	public void tearDown() {

		// Remove all actions
		userCtrl.delete(user.getUserId());
		userCtrl.delete(user6.getUserId());
		userCtrl.delete(user7.getUserId());
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// CONNECTION USER TEST
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Test
	public void connectUserTest() {

		// Call method create (user ok)
		userCtrl.create(user);
		
		// Call method connection (date expired)
		connectionResponse = connectionCtrl.connection(user);
		Assert.assertEquals(StatusCode.CODE_1.getCode(), connectionResponse.getResponseCode());
		Assert.assertEquals(StatusCode.CODE_1.getDescription(), connectionResponse.getResponseError());
		
		// User Dupont
		Assert.assertEquals("Dupont", connectionResponse.getUserSession().getLogin());
		Assert.assertEquals(10000, connectionResponse.getUserSession().getUserId());
		Assert.assertEquals(1, connectionResponse.getUserSession().getRight());
		
	}

	@Test
	public void connectionUserLoginOrPasswordEmptyTest() {

		// Call method connection (user null)
		connectionResponse = connectionCtrl.connection(null);
		Assert.assertEquals(StatusCode.CODE_100.getCode(), connectionResponse.getResponseCode());
		Assert.assertEquals(StatusCode.CODE_100.getDescription(), connectionResponse.getResponseError());
		
		// Call method create (user login null)
		connectionResponse = connectionCtrl.connection(user2);
		Assert.assertEquals(StatusCode.CODE_100.getCode(), connectionResponse.getResponseCode());
		Assert.assertEquals(StatusCode.CODE_100.getDescription(), connectionResponse.getResponseError());

		// Call method create (user password null)
		connectionResponse = connectionCtrl.connection(user3);
		Assert.assertEquals(StatusCode.CODE_100.getCode(), connectionResponse.getResponseCode());
		Assert.assertEquals(StatusCode.CODE_100.getDescription(), connectionResponse.getResponseError());
	}

	@Test
	public void connectUserLoginOrPasswordBadTest() {

		// Call method connection (bad user login)
		connectionResponse = connectionCtrl.connection(user4);
		Assert.assertEquals(StatusCode.CODE_101.getCode(), connectionResponse.getResponseCode());
		Assert.assertEquals(StatusCode.CODE_101.getDescription(), connectionResponse.getResponseError());
		
		// Call method create (bad user password)
		connectionResponse = connectionCtrl.connection(user5);
		Assert.assertEquals(StatusCode.CODE_101.getCode(), connectionResponse.getResponseCode());
		Assert.assertEquals(StatusCode.CODE_101.getDescription(), connectionResponse.getResponseError());
		
	}

	@Test
	public void connectUserDateExpiredTest() {
		
		// Call method create (user ok)
		userCtrl.create(user6);
		
		// Call method connection (date expired)
		connectionResponse = connectionCtrl.connection(user6);
		Assert.assertEquals(StatusCode.CODE_102.getCode(), connectionResponse.getResponseCode());
		Assert.assertEquals(StatusCode.CODE_102.getDescription(), connectionResponse.getResponseError());
		
		// Call method create (date expired)
		userCtrl.create(user7);
		
		// Call method connection (date expired)
		connectionResponse = connectionCtrl.connection(user7);
		Assert.assertEquals(StatusCode.CODE_102.getCode(), connectionResponse.getResponseCode());
		Assert.assertEquals(StatusCode.CODE_102.getDescription(), connectionResponse.getResponseError());
	}

}
