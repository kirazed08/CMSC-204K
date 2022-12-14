package application;

import static org.junit.Assert.*;
import org.junit.Test;


public class RoadStudentTest {
	@Test
	public void testGetName() {
		Road r = new Road(new Town("Town1"), new Town("Town2"), 35, "Road1");
		assertEquals("Road1", r.getName());
	}

	@Test
	public void testGetSource() {
		Town t1 = new Town("Town1");
		Town t2 = new Town("Town2");
		Road r = new Road(t1, t2, 35, "Road2");
		assertEquals(t1, r.getSource());
	}

	@Test
	public void testGetDestination() {
		Town t1 = new Town("Town1");
		Town t2 = new Town("Town2");
		Road r = new Road(t1, t2, 35, "Road2");
		assertEquals(t2, r.getDestination());
	}

	@Test
	public void testGetWeight() {
		Road r = new Road(new Town("Town1"), new Town("Town2"), 25, "Road3");
		assertEquals(25, r.getWeight());
	}

	

	@Test
	public void testToString() {
		Road r = new Road(new Town("Town1"), new Town("Town2"), 15, "Road4");
		assertEquals("town name: Road4, source: Town1, destination: Town2, degrees: 15", r.toString());
	}

	@Test
	public void testContains() {
		Town t1 = new Town("Town1");
		Town t2 = new Town("Town2");
		Road r = new Road(t1, t2, 95, "Road2");
		assertEquals(true, r.contains(t2));
		assertEquals(false, r.contains(new Town("False Town")));
	}
}