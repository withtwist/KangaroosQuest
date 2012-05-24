package se.chalmers.kangaroo.model;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import se.chalmers.kangaroo.model.creatures.Creature;
import se.chalmers.kangaroo.model.iobject.InteractiveObject;
import se.chalmers.kangaroo.model.kangaroo.Item;

public class GameMapTest {


	@Test(expected = IndexOutOfBoundsException.class)
	public void itemTest(){
		GameMap gm = new GameMap("resources/maps/level0.tmx");
		for(int i = 0; i < gm.amountOfItems(); i++){
			assertTrue(gm.getItem(i) instanceof Item);
		}
		gm.getItem(gm.amountOfItems()+1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void creatureTest(){
		GameMap gm = new GameMap("resources/maps/level0.tmx");
		for(int i = 0; i < gm.getCreatureSize(); i++){
			int size = gm.getCreatureSize();
			assertTrue(gm.getCreatureAt(i) instanceof Creature);
			if(i % 2 == 1){
				gm.killCreature(gm.getCreatureAt(i));
				assertTrue(size > gm.getCreatureSize());
			}
		}
		
		gm.getCreatureAt(gm.getCreatureSize());
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void iObjectTest(){
		GameMap gm = new GameMap("resources/maps/level0.tmx");
		for(int i = 0; i < gm.getIObjectSize(); i++){
			assertTrue(gm.getIObject(i) instanceof InteractiveObject);
		}
		gm.getIObject(gm.getIObjectSize());
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void tileTest(){
		GameMap gm = new GameMap("resources/maps/level0.tmx");
		for(int i = 0; i < gm.getTileHeight(); i++)
			for(int j = 0; j < gm.getTileWidth(); j++){
				assertTrue(gm.getTile(j, i) instanceof Tile);
			}
		gm.getTile(gm.getTileWidth(), gm.getTileHeight());
	}
	
	
}
