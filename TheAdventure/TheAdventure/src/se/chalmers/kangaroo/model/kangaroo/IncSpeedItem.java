package se.chalmers.kangaroo.model.kangaroo;

import se.chalmers.kangaroo.model.utils.Position;

/**
 * A class representing an item that increases the speed of the kangaroo"
 * @author simonal
 *
 */
public class IncSpeedItem implements Item, Runnable {

	private Position pos;

	private Thread t;

	private Kangaroo k;

	private int id;
	/**
	 * The default constructor, taking the id nad the x and y cordinate of where the item is placed.
	 * @param id
	 * @param x
	 * @param y
	 */
	public IncSpeedItem(int id, int x, int y) {
		this.id = id;
		this.pos = new Position(x, y);
		t = new Thread();
	}

	@Override
	public void onPickup(Kangaroo k) {
		this.k = k;
	}

	@Override
	public void onDrop(Kangaroo k) {
		;

	}

	@Override
	public void onUse(Kangaroo k) {
		k.setMaxSpeed(15f);
		t.start();

	}

	@Override
	public Position getPosition() {
		return pos;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
		}
		k.setMaxSpeed(10f);

	}

	@Override
	public int getId() {

		return id;
	}

}
