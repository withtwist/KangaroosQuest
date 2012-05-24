package se.chalmers.kangaroo.model.minigame;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MiniGameTest {
	
	@Test
	public void pushColumnTest(){
		EqualSumsMinigame esg = new EqualSumsMinigame(3);
		
		int topLeft = esg.getNbr(0, 0);
		int secondLeft = esg.getNbr(0, 1);
		int thirdLeft = esg.getNbr(0, 2);
		
		int topRight = esg.getNbr(2, 0);
		int secondRight = esg.getNbr(2, 1);
		int thirdRight = esg.getNbr(2, 2);
		esg.pushColumn(0, 1);
		assertTrue(esg.getNbr(0, 2) == topLeft);
		assertTrue(esg.getNbr(0, 0) == secondLeft);
		assertTrue(esg.getNbr(0, 1) == thirdLeft);
		
		assertTrue(esg.getNbr(2, 0) == topRight);
		assertTrue(esg.getNbr(2, 1) == secondRight);
		assertTrue(esg.getNbr(2, 2) == thirdRight);
	}
	
	@Test
	public void isSumsEqualTest(){
		EqualSumsMinigame esg = new EqualSumsMinigame(3);
		assertTrue(!esg.isSumsEqual());
		while(esg.getNbr(0, 0) != 8)
			esg.pushColumn(0, 1);
		while(esg.getNbr(1, 0) != 1)
			esg.pushColumn(1, 1);
		while(esg.getNbr(2, 0) != 6)
			esg.pushColumn(2, 1);
		
		assertTrue(esg.isSumsEqual());
	}

}
