package snezana;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import model.User;
import model.Users;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class UsersTest {
	
	private Users users;
	private User[] usersList;
	
	private String username;
	private int index;
	private User user;
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(
				new Object[] {"Us1", 0, new User("TestName1", "TestSurname1", "TestUsername1", "TestPassword1", "TestRole1")},
				new Object[] {"Us2", 1, new User("TestName2", "TestSurname2", "TestUsername2", "TestPassword2", "TestRole2")},
				new Object[] {"Us3", 2, new User("TestName3", "TestSurname3", "TestUsername3", "TestPassword3", "TestRole3")},
				new Object[] {"Us4", 3, new User("TestName4", "TestSurname4", "TestUsername4", "TestPassword4", "TestRole4")});
	}
	
	public UsersTest(String username, int index, User user) {
		this.username = username;
		this.index = index;
		this.user = user;
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		usersList = new User[4];
		usersList[0] = new User("Fn1", "Ln1", "Us1", "Ps1", "R1");
		usersList[1] = new User("Fn2", "Ln2", "Us2", "Ps2", "R2");
		usersList[2] = new User("Fn3", "Ln3", "Us3", "Ps3", "R3");
		usersList[3] = new User("Fn4", "Ln4", "Us4", "Ps4", "R4");
		
		users = new Users();
		users.addUser(usersList[0]);
		users.addUser(usersList[1]);
		users.addUser(usersList[2]);
		users.addUser(usersList[3]);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetUser() {
		assertEquals(usersList[index], users.getUser(index));
	}

	@Test
	public void testGetUsers() {
		assertEquals(Arrays.asList(usersList), users.getUsers());
	}

	@Test
	public void testAddUser() {
		users.addUser(user);
		assertEquals(users.getUserByUsername(user.getUsername()), user);
		assertEquals(usersList.length + 1, users.getUsers().size());
	}

	@Test
	public void testGetUserByUsername() {
		assertEquals(usersList[index], users.getUserByUsername(username));
	}

}

