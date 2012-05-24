package se.chalmers.kangaroo.model.kangaroo;
/**
 * A factory for creating items.
 * @author grubla
 *
 */
public class ItemFactory {
	/**
	 * Creates different items depending on the ID.
	 * 
	 * @param i
	 *            , the id of the item
	 * @param x, y the position of this item
	 * @return the item created
	 */
	public static Item createItem(int i, int x, int y) {
		switch (i) {
		case 51:
			return new DoubleJumpItem(i, x, y);
		case 52:
			return new StopTimeItem(i, 5, x, y);
		case 53:
			return new ImmortalItem(i, x, y);
		case 54:
			return new IncSpeedItem(i, x, y);
		default:
			return null;
		}
	}
}
