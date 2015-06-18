package TestsPackage;

import static org.junit.Assert.*;

import java.util.ArrayList;

import models.APlotElement;
import models.Ball;
import models.Cloud;
import models.DistanceSign;
import models.Orc;
import models.Position;
import models.Scenario;
import models.WelcomeScenario;

import org.junit.Test;

public class ScenarioTest {

	@Test
	public void test() {
		ArrayList<APlotElement> plot1 = new ArrayList<APlotElement>();
		Scenario s1 = new WelcomeScenario();
		Cloud cloud = new Cloud(new Position(-2500, 1000, 299.5), 200, 400, 0.5, "");
		final int WIDTH = 4;
		DistanceSign sign100L = new DistanceSign(new Position(-WIDTH, 0, 100), 0.5, 0.5);
		DistanceSign sign100R = new DistanceSign(new Position(WIDTH, 0, 100), 0.5, 0.5);
		DistanceSign sign150L = new DistanceSign(new Position(-WIDTH, 0, 150), 0.5, 0.5);
		DistanceSign sign150R = new DistanceSign(new Position(WIDTH, 0, 150), 0.5, 0.5);
		DistanceSign sign200L = new DistanceSign(new Position(-WIDTH, 0, 200), 0.5, 0.5);
		DistanceSign sign200R = new DistanceSign(new Position(WIDTH, 0, 200), 0.5, 0.5);
		DistanceSign sign250L = new DistanceSign(new Position(-WIDTH, 0, 250), 0.5, 0.5);
		DistanceSign sign250R = new DistanceSign(new Position(WIDTH, 0, 250), 0.5, 0.5);
		Orc orc1 = new Orc(10, new Position(0,0,200), 1,1);
		Orc orc = new Orc(10, new Position(0,0,100), 1,1);
		Ball ball = new Ball(new Position(0,0,0), null, 0.1);
		
	
		
		plot1.add(cloud);
		plot1.add(sign100L);
		plot1.add(sign100R);
		plot1.add(sign150L);
		plot1.add(sign150R);
		plot1.add(sign200L);
		plot1.add(sign200R);
		plot1.add(sign250L);
		plot1.add(sign250R);
		plot1.add(orc1);
		plot1.add(orc);
		plot1.add(ball);
		
		//s1.setup();
		//assertEquals(plot1, s1.getPlotElements());
		
	}

}
