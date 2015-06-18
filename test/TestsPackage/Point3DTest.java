package TestsPackage;

import static org.junit.Assert.*;
import models.Position;

import org.junit.Test;

public class Point3DTest {

	@Test
	public void test() {
		Position point = new Position(1,1,1);
		assertEquals(1, point.getX(),0);
		assertEquals(1,point.getX(),0);
		assertEquals(1,point.getX(),0);
		assertEquals(1,point.getX(),0);
	}

}
