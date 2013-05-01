package se.chalmers.kangaroo.model.creatures;

import java.awt.Polygon;

import se.chalmers.kangaroo.model.utils.Direction;
import se.chalmers.kangaroo.model.utils.Position;

/**
 * Represents an unkillable smurf.
 * @author simonal
 *
 */
public class SmurfCreature implements Creature {

	private Position currentPos;
	private Position startPos;

	private Direction currentDir;

	private int speed = 3;
	/**
	 * The default constructor taking the spawnposition.
	 * @param spawnPos
	 */
	public SmurfCreature(Position spawnPos) {
		this.currentDir = Direction.DIRECTION_EAST;
		startPos = spawnPos;
		currentPos = spawnPos;
	}
	
	@Override
	public boolean isKillable() {
		return false;
	}

	@Override
	public Polygon getPolygon() {
		int[] polyX = { currentPos.getX() + 0, currentPos.getX() + 31,
				currentPos.getX() + 0, currentPos.getX() + 31 };
		int[] polyY = { currentPos.getY() + 0, currentPos.getY() + 0,
				currentPos.getY() + 31, currentPos.getY() + 31 };
		return new Polygon(polyX, polyY, 4);
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
		this.move();

	}

	@Override
	public int getId() {
		return 116;
	}

	@Override
	public Position getPosition() {
		return currentPos;
	}

	@Override
	public void changeDirection() {
		if (this.currentDir == Direction.DIRECTION_EAST) {
			this.currentDir = Direction.DIRECTION_WEST;
		} else if (this.currentDir == Direction.DIRECTION_WEST) {
			this.currentDir = Direction.DIRECTION_EAST;
		}

	}
	/**
	 * Returns in which direction the smurf is movning.
	 * @return
	 */
	public Direction getDirection() {
		return currentDir;
	}
	
	public void resetPosition(){
		currentPos = startPos;
	}

}
