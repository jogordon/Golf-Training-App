package TestsPackage;

import static org.junit.Assert.*;

import java.sql.Date;

import models.ClubEnum;
import models.TrainingRecord;
import models.User;

import org.junit.Test;

public class TrainRecordTest {
	private static final ClubEnum IRON5 = null;
	
	@Test
	public void test_trainingrecord_methods() {

		Date aDate = new Date(System.currentTimeMillis());
		
		TrainingRecord record1 = new TrainingRecord(new User("John"), 
    			aDate, ClubEnum.IRON5, "session", 130, 12, 2, 6000, -30, 170);
    	assertEquals(ClubEnum.IRON5, record1.getIron());
    	assertEquals("session", record1.getSession());
    	assertEquals(130, record1.getVelocity(), 0.1);
    	assertEquals(12, record1.getvertAngle(), 0.1);
    	assertEquals(2, record1.gethorzAngle(), 0.1);
    	assertEquals(6000, record1.getSpin(), 0.1);
    	assertEquals(-30, record1.getxLanding(), 0.1);
    	assertEquals(170, record1.getzLanding(), 0.1);
		
		TrainingRecord record2 = new TrainingRecord(new User("Terry"), 
    			new Date(System.currentTimeMillis()), ClubEnum.IRON9, "session2", 0, 0, 0, 0, 0, 0); 

		record2.setVelocity(100);
		assertEquals(100, record2.getVelocity(), 0.1);
		record2.setLanding(0, 100);
		assertEquals(0, record2.getxLanding(), 0.1);
		assertEquals(100, record2.getzLanding(), 0.1);
		record2.setSpin(300);
		assertEquals(300, record2.getSpin(), 0.1);
		record2.setVelocity(75);
		assertEquals(75, record2.getVelocity(), 0.1);


	}


}
