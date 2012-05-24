package se.chalmers.kangaroo.model.iobject;



import static org.junit.Assert.*;

import org.junit.Test;

import se.chalmers.kangaroo.model.GameMap;
import se.chalmers.kangaroo.model.iobject.RedBlueButton;
import se.chalmers.kangaroo.model.utils.Position;


public class RedBlueButtonTest {
	
	
	@Test
	public void testGetChangedId() {
		Position p = new Position(2, 2);
		int id = 71;
		GameMap gm = new GameMap("resources/maps/level0.tmx");
		RedBlueButton rb = new RedBlueButton(p, id, gm);
		assertTrue(rb.getChangedId(id) == 72);
	}
	
	@Test
	public void testGetPosition() {
		Position p = new Position(2, 2);
		int id = 71;
		GameMap gm = new GameMap("resources/maps/level0.tmx");
		RedBlueButton rb = new RedBlueButton(p, id, gm);
		assertTrue(rb.getPosition().equals(new Position(2, 2)));
	}
	
	@Test
	public void testGetId(){
		Position p = new Position(2, 2);
		int id = 71;
		GameMap gm = new GameMap("resources/maps/level0.tmx");
		RedBlueButton rb = new RedBlueButton(p, id, gm);
		assertTrue(rb.getId() == 71);
	}
	
	@Test
	public void testChangeId() {
		Position p = new Position(2, 2);
		int id = 71;
		GameMap gm = new GameMap("resources/maps/level0.tmx");
		RedBlueButton rb = new RedBlueButton(p, id, gm);
		rb.changeId();
		assertTrue(rb.getId() == id + 1);
	}
}
