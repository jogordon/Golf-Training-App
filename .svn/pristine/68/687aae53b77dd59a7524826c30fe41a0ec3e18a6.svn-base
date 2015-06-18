package TestsPackage;

import static org.junit.Assert.*;

import java.awt.Color;

import models.Ball;
import models.BallStatusInfo;
import models.Position;

import org.junit.Test;

public class BallStatusInfoTest {

	@Test
	public void test() {
		Position p1 = new Position(1,2,3);
		BallStatusInfo bStatus = new BallStatusInfo(p1, 2.0, 3.0);
		Ball b1 = new Ball(p1,Color.BLACK, 2.0);
		bStatus.updateInfo(b1);
		
		assertEquals(3.0, bStatus.getBallDistance(),0);
		assertEquals(2.0, bStatus.getBallHeight(),0);
		
		
	
	}

}
