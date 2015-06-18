package TestsPackage;

import static org.junit.Assert.*;
import models.Ball;
import models.Cloud;
import models.Position;
import old.stuff.Green;
import old.stuff.Hole;
import old.stuff.Tree;

import org.junit.Test;

public class APlotElementTest {

	@Test
	public void test() {
		Position point = new Position(1,1,1);
		Position point2 = new Position(2,2,2);
		Cloud c1 = new Cloud(point, 8, 10, 2.0,"left");
		Cloud c2 = new Cloud(point, 8, 10, 2.0,"right");
		assertNotEquals(c1,c2);
		
		
	}

}
