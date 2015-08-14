package com.soseb.drive.user;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.soseb.drive.common.StatusCode;
import com.soseb.drive.controllers.UserController;
import com.soseb.drive.models.User;
import com.soseb.drive.responses.UserResponse;

/**
 * 
 * user test class
 * 
 * @author slegalludec
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class UserTest {

	@InjectMocks
	private UserController userCtrl;

	private User user;
	private User user2;
	private User user3;
	private User user4;
	private User user5;
	private User user6;

	private UserResponse userResponse;

	@Before
	public void setUp() {

		// Create new user (1)
		user = new User();
		user.setUserId(10000);
		user.setLogin("Dupont");
		user.setPassword("dupont");
		user.setRight(1);
		user.setRightStartDate("23/05/2015");
		user.setRightEndDate("23/05/2016");

		// Create new user (2)
		user2 = new User();
		user2.setUserId(10001);
		user2.setLogin(null);
		user2.setPassword("dupont");
		user2.setRight(1);
		user2.setRightStartDate("23/05/2015");
		user2.setRightEndDate("23/05/2016");

		// Create new user (3)
		user3 = new User();
		user3.setUserId(10002);
		user3.setLogin("Dupont");
		user3.setPassword(null);
		user3.setRight(1);
		user3.setRightStartDate("23/05/2015");
		user3.setRightEndDate("23/05/2016");

		// Create new user (4)
		user4 = new User();
		user4.setUserId(10003);
		user4.setLogin("Dupont");
		user4.setPassword("dupont");
		user4.setRight(0);
		user4.setRightStartDate("23/05/2015");
		user4.setRightEndDate("23/05/2016");

		// Create new user (5)
		user5 = new User();
		user5.setUserId(10004);
		user5.setLogin("Dupont");
		user5.setPassword("dupont");
		user5.setRight(1);
		user5.setRightStartDate(null);
		user5.setRightEndDate("23/05/2016");

		// Create new user (6)
		user6 = new User();
		user6.setUserId(10005);
		user6.setLogin("Dupont");
		user6.setPassword("dupont");
		user6.setRight(1);
		user6.setRightStartDate("23/05/2015");
		user6.setRightEndDate(null);
	}

	@After
	public void tearDown() {

		// Remove all actions
		userCtrl.delete(user.getUserId());
		userCtrl.delete(user2.getUserId());
		userCtrl.delete(user3.getUserId());
		userCtrl.delete(user4.getUserId());
		userCtrl.delete(user5.getUserId());
		userCtrl.delete(user6.getUserId());
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// CREATE USER TEST
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Test
	public void createUserTest() {

		// Call method create (user ok)
		userResponse = userCtrl.create(user);
		Assert.assertEquals(StatusCode.CODE_3.getCode(), userResponse.getResponseCode());
		Assert.assertEquals("User " + userResponse.getUsersList().get(5).getLogin() + " is created !", userResponse.getResponseError());
		Assert.assertEquals(6, userResponse.getUsersList().size());

		// User Dupont
		Assert.assertEquals("Dupont", userResponse.getUsersList().get(5).getLogin());
		Assert.assertEquals("dupont", userResponse.getUsersList().get(5).getPassword());
		Assert.assertEquals(1, userResponse.getUsersList().get(5).getRight());
		Assert.assertEquals("23/05/2015", userResponse.getUsersList().get(5).getRightStartDate());
		Assert.assertEquals("23/05/2016", userResponse.getUsersList().get(5).getRightEndDate());

	}

	@Test
	public void createUserNullFieldsTest() {

		// Call method create (object user is null)
		userResponse = userCtrl.create(null);
		Assert.assertEquals(StatusCode.CODE_104.getCode(), userResponse.getResponseCode());
		Assert.assertEquals(StatusCode.CODE_104.getDescription(), userResponse.getResponseError());
		Assert.assertEquals(null, userResponse.getUsersList());

		// Call method create (login is null)
		userResponse = userCtrl.create(user2);
		Assert.assertEquals(StatusCode.CODE_104.getCode(), userResponse.getResponseCode());
		Assert.assertEquals(StatusCode.CODE_104.getDescription(), userResponse.getResponseError());
		Assert.assertEquals(null, userResponse.getUsersList());

		// Call method create (password is null)
		userResponse = userCtrl.create(user3);
		Assert.assertEquals(StatusCode.CODE_104.getCode(), userResponse.getResponseCode());
		Assert.assertEquals(StatusCode.CODE_104.getDescription(), userResponse.getResponseError());
		Assert.assertEquals(null, userResponse.getUsersList());

		// Call method create (right is equal 0)
		userResponse = userCtrl.create(user4);
		Assert.assertEquals(StatusCode.CODE_104.getCode(), userResponse.getResponseCode());
		Assert.assertEquals(StatusCode.CODE_104.getDescription(), userResponse.getResponseError());
		Assert.assertEquals(null, userResponse.getUsersList());

		// Call method create (startDate is null)
		userResponse = userCtrl.create(user5);
		Assert.assertEquals(StatusCode.CODE_104.getCode(), userResponse.getResponseCode());
		Assert.assertEquals(StatusCode.CODE_104.getDescription(), userResponse.getResponseError());
		Assert.assertEquals(null, userResponse.getUsersList());

		// Call method create (endDate is null)
		userResponse = userCtrl.create(user6);
		Assert.assertEquals(StatusCode.CODE_104.getCode(), userResponse.getResponseCode());
		Assert.assertEquals(StatusCode.CODE_104.getDescription(), userResponse.getResponseError());
		Assert.assertEquals(null, userResponse.getUsersList());
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// UPDATE USER TEST
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Test
	public void updateUserTest() {

		// Call method create (user ok)
		userResponse = userCtrl.create(user);

		// Call method update (change login)
		user.setLogin("Anna");
		userResponse = userCtrl.update(user);
		Assert.assertEquals(StatusCode.CODE_4.getCode(), userResponse.getResponseCode());
		Assert.assertEquals("User " + userResponse.getUsersList().get(5).getLogin() + " is updated !", userResponse.getResponseError());
		Assert.assertEquals(6, userResponse.getUsersList().size());

		// User Anna
		Assert.assertEquals("Anna", userResponse.getUsersList().get(5).getLogin());
		Assert.assertEquals("dupont", userResponse.getUsersList().get(5).getPassword());
		Assert.assertEquals(1, userResponse.getUsersList().get(5).getRight());
		Assert.assertEquals("23/05/2015", userResponse.getUsersList().get(5).getRightStartDate());
		Assert.assertEquals("23/05/2016", userResponse.getUsersList().get(5).getRightEndDate());

		// Call method update (change password)
		user.setPassword("azerty");
		userResponse = userCtrl.update(user);
		Assert.assertEquals(StatusCode.CODE_4.getCode(), userResponse.getResponseCode());
		Assert.assertEquals("User " + userResponse.getUsersList().get(5).getLogin() + " is updated !", userResponse.getResponseError());
		Assert.assertEquals(6, userResponse.getUsersList().size());

		// User Anna
		Assert.assertEquals("Anna", userResponse.getUsersList().get(5).getLogin());
		Assert.assertEquals("azerty", userResponse.getUsersList().get(5).getPassword());
		Assert.assertEquals(1, userResponse.getUsersList().get(5).getRight());
		Assert.assertEquals("23/05/2015", userResponse.getUsersList().get(5).getRightStartDate());
		Assert.assertEquals("23/05/2016", userResponse.getUsersList().get(5).getRightEndDate());

		// Call method update (change right)
		user.setRight(2);
		userResponse = userCtrl.update(user);
		Assert.assertEquals(StatusCode.CODE_4.getCode(), userResponse.getResponseCode());
		Assert.assertEquals("User " + userResponse.getUsersList().get(5).getLogin() + " is updated !", userResponse.getResponseError());
		Assert.assertEquals(6, userResponse.getUsersList().size());

		// User Anna
		Assert.assertEquals("Anna", userResponse.getUsersList().get(5).getLogin());
		Assert.assertEquals("azerty", userResponse.getUsersList().get(5).getPassword());
		Assert.assertEquals(2, userResponse.getUsersList().get(5).getRight());
		Assert.assertEquals("23/05/2015", userResponse.getUsersList().get(5).getRightStartDate());
		Assert.assertEquals("23/05/2016", userResponse.getUsersList().get(5).getRightEndDate());

		// Call method update (change start date)
		user.setRightStartDate("12/12/2012");
		userResponse = userCtrl.update(user);
		Assert.assertEquals(StatusCode.CODE_4.getCode(), userResponse.getResponseCode());
		Assert.assertEquals("User " + userResponse.getUsersList().get(5).getLogin() + " is updated !", userResponse.getResponseError());
		Assert.assertEquals(6, userResponse.getUsersList().size());

		// User Anna
		Assert.assertEquals("Anna", userResponse.getUsersList().get(5).getLogin());
		Assert.assertEquals("azerty", userResponse.getUsersList().get(5).getPassword());
		Assert.assertEquals(2, userResponse.getUsersList().get(5).getRight());
		Assert.assertEquals("12/12/2012", userResponse.getUsersList().get(5).getRightStartDate());
		Assert.assertEquals("23/05/2016", userResponse.getUsersList().get(5).getRightEndDate());

		// Call method update (change end date)
		user.setRightEndDate("11/11/2021");
		userResponse = userCtrl.update(user);
		Assert.assertEquals(StatusCode.CODE_4.getCode(), userResponse.getResponseCode());
		Assert.assertEquals("User " + userResponse.getUsersList().get(5).getLogin() + " is updated !", userResponse.getResponseError());
		Assert.assertEquals(6, userResponse.getUsersList().size());

		// User Anna
		Assert.assertEquals("Anna", userResponse.getUsersList().get(5).getLogin());
		Assert.assertEquals("azerty", userResponse.getUsersList().get(5).getPassword());
		Assert.assertEquals(2, userResponse.getUsersList().get(5).getRight());
		Assert.assertEquals("12/12/2012", userResponse.getUsersList().get(5).getRightStartDate());
		Assert.assertEquals("11/11/2021", userResponse.getUsersList().get(5).getRightEndDate());
	}

	@Test
	public void updateUserNullFieldsTest() {

		// Call method create (user ok)
		userResponse = userCtrl.create(user);

		// Call method update (object user is null)
		userResponse = userCtrl.update(null);
		Assert.assertEquals(StatusCode.CODE_104.getCode(), userResponse.getResponseCode());
		Assert.assertEquals(StatusCode.CODE_104.getDescription(), userResponse.getResponseError());
		Assert.assertEquals(null, userResponse.getUsersList());

		// Call method update (change login to null)
		user.setLogin(null);
		userResponse = userCtrl.update(user);
		Assert.assertEquals(StatusCode.CODE_104.getCode(), userResponse.getResponseCode());
		Assert.assertEquals(StatusCode.CODE_104.getDescription(), userResponse.getResponseError());
		Assert.assertEquals(null, userResponse.getUsersList());

		// Call method update (object password to null)
		user.setPassword(null);
		userResponse = userCtrl.update(user);
		Assert.assertEquals(StatusCode.CODE_104.getCode(), userResponse.getResponseCode());
		Assert.assertEquals(StatusCode.CODE_104.getDescription(), userResponse.getResponseError());
		Assert.assertEquals(null, userResponse.getUsersList());

		// Call method update (object right to null)
		user.setRight(-12);
		userResponse = userCtrl.update(user);
		Assert.assertEquals(StatusCode.CODE_104.getCode(), userResponse.getResponseCode());
		Assert.assertEquals(StatusCode.CODE_104.getDescription(), userResponse.getResponseError());
		Assert.assertEquals(null, userResponse.getUsersList());

		// Call method update (object start date to null)
		user.setRightStartDate(null);
		userResponse = userCtrl.update(user);
		Assert.assertEquals(StatusCode.CODE_104.getCode(), userResponse.getResponseCode());
		Assert.assertEquals(StatusCode.CODE_104.getDescription(), userResponse.getResponseError());
		Assert.assertEquals(null, userResponse.getUsersList());

		// Call method update (object end date to null)
		user.setRightEndDate(null);
		userResponse = userCtrl.update(user);
		Assert.assertEquals(StatusCode.CODE_104.getCode(), userResponse.getResponseCode());
		Assert.assertEquals(StatusCode.CODE_104.getDescription(), userResponse.getResponseError());
		Assert.assertEquals(null, userResponse.getUsersList());
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// REMOVE USER TEST
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Test
	public void removeUserTest() {

		// Call method create (user ok)
		userCtrl.create(user);

		// Call method remove (id ok)
		userResponse = userCtrl.delete(user.getUserId());
		Assert.assertEquals(StatusCode.CODE_5.getCode(), userResponse.getResponseCode());
		Assert.assertEquals("User with id " + user.getUserId() + " is removed !", userResponse.getResponseError());
		Assert.assertEquals(5, userResponse.getUsersList().size());
	}

	@Test
	public void removeUserNullFieldsTest() {

		// Call method create (user ok)
		userCtrl.create(user);

		// Call method remove (null)
		userResponse = userCtrl.delete(null);
		Assert.assertEquals(StatusCode.CODE_104.getCode(), userResponse.getResponseCode());
		Assert.assertEquals(StatusCode.CODE_104.getDescription(), userResponse.getResponseError());
		Assert.assertEquals(null, userResponse.getUsersList());

		// Call method remove (0)
		userResponse = userCtrl.delete(0);
		Assert.assertEquals(StatusCode.CODE_104.getCode(), userResponse.getResponseCode());
		Assert.assertEquals(StatusCode.CODE_104.getDescription(), userResponse.getResponseError());
		Assert.assertEquals(null, userResponse.getUsersList());

		// Call method remove (-12)
		userResponse = userCtrl.delete(-12);
		Assert.assertEquals(StatusCode.CODE_104.getCode(), userResponse.getResponseCode());
		Assert.assertEquals(StatusCode.CODE_104.getDescription(), userResponse.getResponseError());
		Assert.assertEquals(null, userResponse.getUsersList());
	}

	@Test
	public void removeUserIdNotExist() {

		// Call method create (user ok)
		userCtrl.create(user);

		// Call method remove (999999999)
		userResponse = userCtrl.delete(999999999);
		Assert.assertEquals(StatusCode.CODE_105.getCode(), userResponse.getResponseCode());
		Assert.assertEquals(StatusCode.CODE_105.getDescription(), userResponse.getResponseError());
		Assert.assertEquals(6, userResponse.getUsersList().size());
	}
}
