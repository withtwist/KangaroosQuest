package se.chalmers.kangaroo.model.creatures;

import java.awt.Polygon;

import se.chalmers.kangaroo.model.utils.Direction;
import se.chalmers.kangaroo.model.utils.Position;

/**
 * An enemy in the form of a bull. These creatures has health, so it takes 4
 * strikes to kill them.
 * 
 * @author Arvid
 * 
 */
public class BullCreature implements Creature {

	private static final int id = 114;
	private Position currentPos;
	private Direction currentDir;
	private int speed = 1;
	private int health;

	/**
	 * Creates a bull at the given position and direction.
	 * 
	 * @param spawnPos
	 * @param currentDir
	 */
	public BullCreature(Position spawnPos) {
		this.currentPos = spawnPos;
		health = 100;
	}

	/**
	 * Returns the polygin of the bull.
	 */
	public Polygon getPolygon() {
		int polyX[] = { currentPos.getX(), currentPos.getX() + 14, currentPos.getX() + 14,
				currentPos.getX() + 20, currentPos.getX() + 20, currentPos.getX() + 44,
				currentPos.getX() + 44, currentPos.getX() + 50, currentPos.getX() + 50,
				currentPos.getX() + 64, currentPos.getX() + 64, currentPos.getX() + 54,
				currentPos.getX() + 54, currentPos.getX() + 10, currentPos.getX() + 10, currentPos.getX() };
		int polyY[] = { currentPos.getY() + 2, currentPos.getY() + 2, currentPos.getY(), currentPos.getY(),
				currentPos.getY() + 6, currentPos.getY() + 6, currentPos.getY(), currentPos.getY(),
				currentPos.getY() + 2, currentPos.getY() + 2, currentPos.getY() + 16,
				currentPos.getY() + 16, currentPos.getY() + 32, currentPos.getY() + 32,
				currentPos.getY() + 16, currentPos.getY() + 16 };
		return new Polygon(polyX, polyY, 16);
	}

	/**
	 * Returns the ammount of health the bull has left.
	 * 
	 * @return
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * Returns the hashCode of the bulls.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + health;
		return result;
	}

	/**
	 * The overrided equals. A method to see of two bulls are equally.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BullCreature other = (BullCreature) obj;
		if (health != other.health)
			return false;
		return true;
	}

	/**
	 * The overridet toString method. Returns the data from the bull in the form
	 * of health remaining.
	 */
	@Override
	public String toString() {
		return super.toString() + "health left: " + health;
	}

	@Override
	public void move() {
		if (this.currentDir == Direction.DIRECTION_EAST) {
			this.currentPos = new Position(currentPos.getX() + speed,
					currentPos.getY());
		} else if (this.currentDir == Direction.DIRECTION_WEST) {
			this.currentPos = new Position(currentPos.getX() - speed,
					currentPos.getY());

		}

	}

	@Override
	public void updateCreature() {
		if (currentDir == Direction.DIRECTION_WEST) {
			currentPos = new Position(currentPos.getX() - speed, currentPos.getY());
		} else {
			currentPos = new Position(currentPos.getX() + speed, currentPos.getY());
		}

	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public Position getPosition() {
		return currentPos;
	}

	@Override
	public void changeDirection() {
		if (currentDir == Direction.DIRECTION_WEST) {
			currentDir = Direction.DIRECTION_EAST;
		} else {
			currentDir = Direction.DIRECTION_WEST;
		}
	}

	/**
	 * Desides if the creature is killable. The bull is.
	 */
	public boolean isKillable() {
		return true;
	}

	public Direction getDirection(){
		return currentDir;
	}
}
