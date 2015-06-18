package TestsPackage;

import static org.junit.Assert.*;
import models.APlotElement;
import models.Cloud;
import models.DistanceComparator;
import models.Position;

import org.junit.Test;

public class DistanceComparatorTest {

	@Test
	public void test() {
		Position p1 = new Position(1,2,3);
		Position p2 = new Position(4,5,6);
		Cloud c1 = new Cloud(p1, 8, 10, 2.0,"left");
		Cloud c2 = new Cloud(p1, 9, 11, 3.0,"right");
		Cloud c3 = new Cloud(p2, 9, 11, 3.0,"right");
		DistanceComparator discComp = new DistanceComparator();
		
	
		assertEquals(0, discComp.compare((APlotElement) c1, (APlotElement) c2));
		assertEquals(1, discComp.compare((APlotElement) c1, (APlotElement) c3));
	}

}
