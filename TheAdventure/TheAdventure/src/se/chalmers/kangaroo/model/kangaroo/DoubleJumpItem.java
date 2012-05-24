package se.chalmers.kangaroo.model.kangaroo;

import se.chalmers.kangaroo.model.utils.Position;

/**
 * The item with the doublejump-effect.
 * 
 * @author simonal
 * 
 */
public class DoubleJumpItem implements Item {

	private Position pos;
	private int id;
	/**
	 * The default constructor, taking the id and the x and y cordinate.
	 * @param id
	 * @param x
	 * @param y
	 */
	public DoubleJumpItem(int id, int x, int y) {
		this.id = id;
		this.pos = new Position(x, y);
	}

	@Override
	public void onPickup(Kangaroo k) {
		k.enableDoubleJump();
	}

	@Override
	public void onDrop(Kangaroo k) {
		k.disableDoubleJump();
		k.removeItem();

	}

	@Override
	public void onUse(Kangaroo k) {
		//

	}

	@Override
	public Position getPosition() {
		return pos;
	}

	@Override
	public int getId() {
		return id;
	}

}
