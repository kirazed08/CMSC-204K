package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

 public class TownStudentTest {

	 @Test
		public void testGetName() {
			Town t1 = new Town("Town1");
			Town t2 = new Town("Town2");
			assertEquals("Town1", t1.getName());
			assertEquals("Town2", t2.getName());
		}

		

		@Test
		public void testToString() {
			Town t1 = new Town("Town1");
			t1.adjacentTowns.values();
			Town t2 = new Town("Town2");
			assertEquals("Name = Town1", t1.toString());
			assertEquals("Name = Town2", t2.toString());
		}

		@Test
		public void testEqualsTown() {
			Town t1 = new Town("Town1");
			Town t2 = new Town("Town2");
			assertFalse(t1.equals(t2));
			assertTrue(t2.equals(t2));
		}
}
