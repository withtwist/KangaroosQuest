package se.chalmers.kangaroo.model;

/**
 * 
 * InteractiveTile is a tile that is related to an InteractiveObject. An
 * InteractiveTile will appear or disappear when the InteractiveObject is
 * triggered.
 * 
 * @author pavlov
 * 
 */
public class InteractiveTile extends Tile {
	private boolean collidable;

	/**
	 * 
	 * The constructor sets all variables.
	 * 
	 * @param a
	 *            is the tile-ID.
	 * 
	 * @param intObj
	 *            is the InteractiveObject that the InteractiveTile is referring
	 *            to
	 * 
	 */
	public InteractiveTile(int id, int x, int y) {
		super(id, x, y);
		collidable = (id % 2 == 1);
	}

	/**
	 * Method that change the state of collidable.
	 */
	public void onTrigger() {
		int newId = getId() % 2 == 1 ? getId() + 1 : getId() - 1;
		changeId(newId);
		collidable = !collidable;
	}

	@Override
	public int hashCode() {
		return super.hashCode() * 19;
	}

	@Override
	public String toString() {
		return super.toString() + "InteractiveTile";
	}

	@Override
	public boolean isCollidable() {
		return collidable;
	}
}
