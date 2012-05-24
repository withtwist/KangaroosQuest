package se.chalmers.kangaroo.model;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;


public class InteractiveTileTest {


	@Test
	public void testOnTrigger() {
		InteractiveTile it = new InteractiveTile(42, 1, 1);
		it.onTrigger();
		assertTrue((it.getId()== 41) && it.isCollidable());
	}
	
	@Test
	public void testIsCollidable() {
		InteractiveTile it = new InteractiveTile(1337, 4, 2);
		assertTrue(it.isCollidable());
	}
	

}
