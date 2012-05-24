package se.chalmers.kangaroo.model.iobject;

import se.chalmers.kangaroo.model.GameMap;
import se.chalmers.kangaroo.model.utils.Position;

/**
 * A factory for creating Interactive Objects
 * @author grubla
 *
 */
public class IObjectFactory {
	/**
	 * 
	 * @param i
	 *            , the id of the creature
	 * @return the interactive object created
	 */
	public static InteractiveObject createIObjects(int i, int x, int y, GameMap gm) {
		switch (i) {
		case 71:
			return new RedBlueButton(new Position(x, y), i, gm);
		case 72:
			return new RedBlueButton(new Position(x, y), i, gm);
		case 73:
			return new OnOffButton(new Position(x, y), i, gm);
		case 74:
			return new OnOffButton(new Position(x, y), i, gm);
		default:
			return null;
		}
	}
}
