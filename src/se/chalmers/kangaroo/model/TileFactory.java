package se.chalmers.kangaroo.model;

import se.chalmers.kangaroo.constants.Constants;

/**
 * Creates tiles or interactiveTiles depending on ID.
 * 
 * @author alburgh
 * 
 */
public class TileFactory {
	/**
	 * Creates a simple factory.
	 */
	public TileFactory() {
		super();
		//Not needed
	}

	/**
	 * Creates Tiles (or interactiveTiles) based on ID.
	 * 
	 * @param i
	 *            , the id of the tile
	 * @param x, y the position of the tile
	 * @return the tile created
	 */
	public Tile createTile(int i, int x, int y) {
		if (Constants.INTERACTIVE_TILES.contains(" " + i + " ")) {
			return new InteractiveTile(i, x, y);
		} else if (Constants.ITEM_IDS.contains(" " + i + " ")
				|| Constants.IOBJECTS_IDS_REDBLUE.contains(" " + i + " ")
				|| Constants.CREATURE_IDS.contains(" " + i + " ")) {
			return new Tile(0, x, y);
		} else {

			return new Tile(i, x, y);
		}
	}
}
