package se.chalmers.kangaroo.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameModelTest {

	@Test
	public void deathCountTest(){
		GameModel gm = new GameModel();
		gm.start();
		for(int i = 1; i <= 10; i++)
			gm.restartLevel();
		assertTrue(gm.getDeathCount() == 10);
	}

}
