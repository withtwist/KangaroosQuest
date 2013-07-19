package se.chalmers.kangaroo.model.creatures;

import java.awt.Polygon;

import se.chalmers.kangaroo.model.utils.Direction;
import se.chalmers.kangaroo.model.utils.Position;

/**
 * This enemy is the standard enemy, a crab, but bigger.
 * 
 * @author pavlov
 * 
 */
public class GiantCrabCreature implements Creature {
	private static final int id = 120;
	private Position pos;
	private Position startPos;
	private Direction direction;
	private int speed = 3;
	public static final int BOSS_ZONE_LEFT = 8416;
	public static final int BOSS_ZONE_RIGHT = 10176;
	private boolean isOutOfBounds = false;

	public GiantCrabCreature(Position pos) {
		startPos = pos;
		this.pos = pos;
		direction = Direction.DIRECTION_WEST;
	}

	@Override
	public boolean isKillable() {
		return false;
	}

	@Override
	public Polygon getPolygon() {
		int polyX[] = { pos.getX() + 0, pos.getX() + 512, pos.getX() + 512,
				pos.getX() + 0 };
		int polyY[] = { pos.getY() + 0, pos.getY() + 0, pos.getY() + 256,
				pos.getY() + 256 };
		return new Polygon(polyX, polyY, 4);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCreature() {
		if (direction == Direction.DIRECTION_WEST) {
			pos = new Position(pos.getX() - speed, pos.getY());
		} else {
			pos = new Position(pos.getX() + speed, pos.getY());
		}
		if (pos.getX() <= BOSS_ZONE_LEFT && !isOutOfBounds) {
			setDirection(Direction.DIRECTION_EAST);
			isOutOfBounds = true;
		} else if (pos.getX() + 512 >= BOSS_ZONE_RIGHT && !isOutOfBounds) {
			setDirection(Direction.DIRECTION_WEST);
			isOutOfBounds = true;
		} else {
			if (pos.getX() >= BOSS_ZONE_LEFT + 10
					&& pos.getX() + 512 <= BOSS_ZONE_RIGHT - 10) {
				isOutOfBounds = false;
			}
		}
		if (Math.random() * 600 > 594 && !isOutOfBounds) {
			oppositeDirection();
		}
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public Position getPosition() {
		return pos;
	}

	@Override
	public void changeDirection() {
		// if (direction == Direction.DIRECTION_WEST) {
		// direction = Direction.DIRECTION_EAST;
		// } else {
		// direction = Direction.DIRECTION_WEST;
		// }

	}

	/*
	 * Automatic changeDirection doesn't work. Use this when random occurs.
	 */
	private void oppositeDirection() {
		if (direction == Direction.DIRECTION_WEST) {
			direction = Direction.DIRECTION_EAST;
		} else {
			direction = Direction.DIRECTION_WEST;
		}
	}

	private void setDirection(Direction d) {
		direction = d;
	}

	public Direction getDirection() {
		return this.direction;
	}

	public void resetPosition() {
		pos = startPos;
	}
}
