package TestsPackage;

import static org.junit.Assert.*;

import java.awt.Color;

import models.APlotElement;
import models.Ball;
import models.Position;

import org.junit.Test;

public class BallTest {

	@Test
	public void test() {
		assertNotEquals(APlotElement.class, BallTest.getType(new Ball(null,Color.black,0)));
	}
	@Test
	public void ball_Create_Test(){
		Ball ball = new Ball(new Position(1,2,3), null, 0.2);
		assertEquals(1, ball.getPosition().getX(),0.0);
		assertEquals(2, ball.getPosition().getY(),0.0);
		assertEquals(3, ball.getPosition().getZ(),0.0);
		
		
	}
	
	public static Class getType(APlotElement pe){
		return pe.getClass();
	}

}
