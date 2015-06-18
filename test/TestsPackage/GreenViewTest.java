package TestsPackage;

import static org.junit.Assert.*;

import java.util.ArrayList;

import models.Ball;
import models.GreenView;
import models.Position;

import org.junit.Test;

public class GreenViewTest {

	@Test
	public void test() {
		GreenView gv = new GreenView(new Position(-5,0.5,2), 2.75, 2, new Position(0,0,200), 10);
		Ball ball = new Ball(new Position(0,0,200));
		ArrayList<Position> positions = new ArrayList<Position>();
		positions.add(new Position(0,0,200));
		positions.add(new Position(0,0,200));
		positions.add(new Position(0,0,200));
		ball.setTrajectory(positions);
		ball.hit();
		ball.tickAction();
		ball.tickAction();
		ball.tickAction();
		
		gv.updateBall(ball);
		double x = gv.getFlyBallAbsoluteX();
		double z = gv.getFlyBallAbsoluteZ();
		assertEquals(5, x,0);
		
	}

}
