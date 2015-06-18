package TestsPackage;

import static org.junit.Assert.*;
import models.Cloud;
import models.Position;

import org.junit.Test;

public class CloudTest {

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		Position p1 = new Position(2,2,2);
		Cloud c1 = new Cloud(p1, 8, 10, 2.0,"left");
		c1.setDirection("right");
		c1.setSpeed(4);
		System.out.println(c1.getSpeed());
		assertEquals("right", c1.getDir());
	}

}
