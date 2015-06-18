package TestsPackage;

import static org.junit.Assert.*;
import models.GameSession;
import models.User;

import org.junit.Test;

public class GameSessionTest {

	@Test
	public void test() {
		User u1 = new User("Jay");
		GameSession g1 = new GameSession(u1);
		g1.incrementScore(30);
		g1.decrementShotsLeft();
		
		assertEquals(30, g1.getTotalScore());
		assertEquals(19, g1.getShotsLeft());
		
		}

}
