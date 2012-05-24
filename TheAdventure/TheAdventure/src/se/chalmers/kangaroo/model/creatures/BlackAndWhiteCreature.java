package se.chalmers.kangaroo.model.creatures;

import java.awt.Polygon;

import se.chalmers.kangaroo.model.utils.Direction;
import se.chalmers.kangaroo.model.utils.Position;

/**
 * The B&WCreature will toggle between black and white. When he is white he is killable. 
 * He is also very fast. 
 * @author Grubla
 *
 */
public class BlackAndWhiteCreature implements Creature {
	private Position pos;
	private final static int ID = 113;
	private static final int speed = 7;
	private Direction direction;
	private boolean killable;

	/**
	 * Creates a new BlackAndWhiteCreature with the given position at start.
	 * The creature will start off by moving west. 
	 * @param spawnPos
	 */
	public BlackAndWhiteCreature(Position spawnPos) {
		this.pos = spawnPos;
		this.direction = Direction.DIRECTION_WEST;
		this.killable = false;
		new Thread() {
			@Override
			public void run() {
				while (true)
					try {
						sleep(600);
						killable = !killable;
					} catch (InterruptedException e) {
					}

			};
		}.start();
	}

	/**
	 * Returns the polygon for this creature.
	 * @return the polygon
	 */
	public Polygon getPolygon() {
		int[] xs = { pos.getX(), pos.getX() + 31, pos.getX() + 31, pos.getX() };
		int[] ys = { pos.getY(), pos.getY(), pos.getY() + 31, pos.getY() + 31 };
		return new Polygon(xs, ys, 4);
	}

	/**
	 * Return true if the creature is in a killable state.
	 */
	public boolean isKillable() {
		return killable;
	}


	/**
	 * Return the string containing the position and killable state of him. 
	 */
	@Override
	public String toString() {
		return "BlackAndWhiteCreature [pos=" + pos + "] " + "Killable: " +killable;
	}

	/**
	 * Changes the direction of the creature
	 */
	@Override
	public void changeDirection() {
		direction = direction == Direction.DIRECTION_WEST ? Direction.DIRECTION_EAST
				: Direction.DIRECTION_WEST;
	}

	/**
	 * Moves the creature
	 */
	@Override
	public void move() {
		if (direction == Direction.DIRECTION_WEST) {
			pos = new Position(pos.getX() - speed, pos.getY());
		} else {
			pos = new Position(pos.getX() + speed, pos.getY());
		}
	}

	/**
	 * Updates the creature (moves it)
	 */
	@Override
	public void updateCreature() {
		move();
	}

	/**
	 * Returns the static id of this creature
	 */
	@Override
	public int getId() {
		return ID;
	}

	/**
	 * Returns the position of this creature.
	 */
	@Override
	public Position getPosition() {
		return pos;
	}
	@Override
	public Direction getDirection(){
		return direction;
	}
}
