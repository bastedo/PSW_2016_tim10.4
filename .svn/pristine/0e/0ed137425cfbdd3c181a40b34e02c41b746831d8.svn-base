package snezana;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import model.Column;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import view.Status;
import view.StatusBar;

@RunWith(Parameterized.class)
public class StatusBarTest {
	

	private Status dateAndTime;
	private Status username;
	private int index;
	private Status[] datumi;
	private Status[] users;
	
	@Parameters
	public static Collection<Object[]> data() {
		
		String datum1 = "10.01.2016";
		String datum2 = "10.02.2016";
		String datum3 = "10.03.2016";
		
		Status date1 = new Status(datum1);
		Status date2 = new Status(datum2);
		Status date3 = new Status(datum3);
		
		String username1 = "Anica Sutic";
		String username2 = "Zorana Babic";
		String username3 = "Atina Grk";
		
		Status user1 = new Status(username1);
		Status user2 = new Status(username2);
		Status user3 = new Status(username3);
		
		return Arrays.asList(
				new Object[]{0,date1, user1},
				new Object[]{1,date2, user2},
				new Object[]{2,date3, user3});
	}
	
	public StatusBarTest(int index,Status date, Status user) {
		this.dateAndTime = date;
		this.username = user;
		this.index = index;
	}
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		Status dateTest1 = new Status("10.01.2016");
		Status dateTest2 = new Status("10.02.2016");
		Status dateTest3 = new Status("10.03.2016");
		
		Status[] datumi = new Status[3];
		datumi[0] = dateTest1;
		datumi[1] = dateTest2;
		datumi[2] = dateTest3;
		
		String username1 = "Anica Sutic";
		String username2 = "Zorana Babic";
		String username3 = "Atina Grk";
		
		Status user1 = new Status(username1);
		Status user2 = new Status(username2);
		Status user3 = new Status(username3);
		
		Status users[] = new Status[3];
		users[0] = user1;
		users[1] = user2;
		users[2] = user3;
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInitComponents() {
		dateAndTime.setText("19.03.2016");
		assertEquals("19.03.2016", dateAndTime.getText());
	}
	

	@Test
	public void testGetDateAndTime() {
		assertEquals("19.03.2016", dateAndTime.getText());
	}

	@Test
	public void testSetUsername() {
		username.setText("Milica");
		assertEquals("Milica", username.getText());	
	}

	@Test
	public void testGetUsername() {
		assertEquals("Milica", username.getText());
	}

	

}

