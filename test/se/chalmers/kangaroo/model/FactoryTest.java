package se.chalmers.kangaroo.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import se.chalmers.kangaroo.constants.Constants;

public class FactoryTest {
	
	@Test
	public void interactiveTileTest(){
		TileFactory f = new TileFactory();
		for(int i = 0; i < 200; i++)
			if( Constants.INTERACTIVE_TILES.contains(" "+i+" ") ){
				assertTrue(f.createTile(i, 10, 10) instanceof InteractiveTile);
			}else{
				assertTrue(!(f.createTile(i, 10, 10) instanceof InteractiveTile));
			}
	}
}
