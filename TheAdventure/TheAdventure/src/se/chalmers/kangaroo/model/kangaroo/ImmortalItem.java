package se.chalmers.kangaroo.model.kangaroo;

import se.chalmers.kangaroo.model.utils.Position;

/**
 * A class representing an item that makes the kangaroo immortal for 5 seconds.
 * 
 * @author simonal
 * 
 */
public class ImmortalItem implements Item {

	private Position pos;
	private Kangaroo kangaroo;
	private int id;

	public ImmortalItem(int id, int x, int y) {
		this.id = id;
		this.pos = new Position(x, y);
	}

	/**
	 * Doesnt do anything on pickup.
	 */
	@Override
	public void onPickup(Kangaroo k) {
		kangaroo = k;

	}

	/**
	 * Doesn't do anything if the item is dropped.
	 */
	@Override
	public void onDrop(Kangaroo k) {
		;

	}

	/**
	 * Makes the kangaroo immortal and starts the thread.
	 */
	@Override
	public void onUse(Kangaroo k) {
		k.setImmortal(true);

		/**
		 * Waits for 5 seconds and then changes the kangaroo to a mere mortal
		 * again.
		 */
		new Thread() {
			@Override
			public void run() {
				try {
					sleep(5000);
				} catch (InterruptedException e) {
				}
				kangaroo.setImmortal(false);
			}
		}.start();
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
