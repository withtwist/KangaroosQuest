package se.chalmers.kangaroo.model.creatures;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import org.junit.Test;

import se.chalmers.kangaroo.model.creatures.BlackAndWhiteCreature;
import se.chalmers.kangaroo.model.utils.Direction;
import se.chalmers.kangaroo.model.utils.Position;

public class BlackAndWhiteCreatureTest {

	
	@Test
	public void testIsKillable() {
		BlackAndWhiteCreature b = new BlackAndWhiteCreature(new Position(1,1));
		assertTrue(!b.isKillable());
	}
	
	@Test
	public void testChangeDirection() {
		BlackAndWhiteCreature b = new BlackAndWhiteCreature(new Position(1,1));
		BlackAndWhiteCreature bawc = new BlackAndWhiteCreature(new Position(1,1));
		b.changeDirection();
		b.changeDirection();
		bawc.changeDirection();
		assertTrue(b.getDirection() == Direction.DIRECTION_WEST && bawc.getDirection() == Direction.DIRECTION_EAST);
	}
	
	@Test
	public void testGetId() {
		BlackAndWhiteCreature b = new BlackAndWhiteCreature(new Position(1,1));
		assertTrue(b.getId() == 113);
	}
	
	@Test
	public void testMove() {
		BlackAndWhiteCreature b = new BlackAndWhiteCreature(new Position(10,10));
		BlackAndWhiteCreature bawc = new BlackAndWhiteCreature(new Position(10,10));
		b.move();
		bawc.changeDirection();
		bawc.move();
		assertTrue(b.getPosition().equals(new Position(3,10)) && bawc.getPosition().equals(new Position(17,10)));
	}
	
	@Test
	public void testGetDirection() {
		BlackAndWhiteCreature b = new BlackAndWhiteCreature(new Position(10,10));
		BlackAndWhiteCreature bawc = new BlackAndWhiteCreature(new Position(10,10));
		bawc.changeDirection();
		assertTrue(b.getDirection() == Direction.DIRECTION_WEST && bawc.getDirection() == Direction.DIRECTION_EAST);
	}
	
	@Test
	public void testGetPosition() {
		BlackAndWhiteCreature b = new BlackAndWhiteCreature(new Position(10,10));
		BlackAndWhiteCreature bawc = new BlackAndWhiteCreature(new Position(42,1337));
		assertTrue(b.getPosition().equals(new Position(10,10)) && bawc.getPosition().equals(new Position(42,1337)));
	}

}
