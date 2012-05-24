package se.chalmers.kangaroo.model.kangaroo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import se.chalmers.kangaroo.constants.Constants;

public class ItemFactoryTest {

	@Test
	public void itemsTest(){
		for(int i = 0; i < 200; i++)
			if( Constants.ITEM_IDS.contains(" "+i+" ") ){
				assertTrue(ItemFactory.createItem(i, 10, 10) != null);
			}else{
				assertTrue(ItemFactory.createItem(i, 10, 10) == null);
			}
	}

}
