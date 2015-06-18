package TestsPackage;

import static org.junit.Assert.*;
import models.AchievementRecord;
import models.User;

import org.junit.Test;

public class AchievementRecordTest {

	@Test
	public void test() {
		User u1 = new User("AJ");
		AchievementRecord achRecord1 = new AchievementRecord(u1, true, false, true, false, true, false, true, false,true);
		
		assertEquals(u1, achRecord1.getUser());
		assertEquals("AJ", achRecord1.getUser().getName());
		assertEquals(true, achRecord1.getTwoHundred());
		assertEquals(false, achRecord1.getPowerShot());
		assertEquals(true, achRecord1.getInOrbit());
		assertEquals(false, achRecord1.getSteadyForm());
		assertEquals(true, achRecord1.getSharpShooter());
		assertEquals(false, achRecord1.getTheRobot());
		assertEquals(true, achRecord1.getAmateurChamp());
		assertEquals(false, achRecord1.getTourPro());
		assertEquals(true, achRecord1.getMajorChamp());
		
	}

}
