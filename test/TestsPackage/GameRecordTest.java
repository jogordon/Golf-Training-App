package TestsPackage;

import static org.junit.Assert.*;

import java.util.Date;

import models.GameRecord;
import models.User;

import org.junit.Test;

public class GameRecordTest {

	@Test
	public void test() {
		User u1 = new User("John");
		GameRecord g1 = new GameRecord(u1, 4, new Date(0));
		GameRecord g2 = new GameRecord(u1, 10, new Date(0));
		assertEquals(4, g1.getScore());
		assertEquals(10, g2.getScore());
		assertEquals(2, g2.setScore(2));
		assertEquals(10, g1.setScore(10));
		
	}

}
