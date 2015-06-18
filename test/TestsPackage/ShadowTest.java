package TestsPackage;

import static org.junit.Assert.*;
import models.APlotElement;
import models.Cloud;
import models.Position;
import models.Shadow;

import org.junit.Test;

public class ShadowTest {

	@Test
	public void test() {
		Position p1 = new Position(2,2,2);
		Cloud c1 = new Cloud(p1, 8, 10, 2.0,"left");
		Shadow s1 = new Shadow((APlotElement) c1, 2.0, 3.0, 4.0, 5.0);
		s1.setPosition(8, 9);
		
		assertEquals(null, s1.getShadow());
		assertEquals(8,s1.getPosition().x, 0);
		assertEquals(9,s1.getPosition().z, 0);
		
	}

}
