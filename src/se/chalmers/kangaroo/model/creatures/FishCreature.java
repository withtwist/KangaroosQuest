package se.chalmers.kangaroo.model.creatures;

import java.awt.Polygon;

import se.chalmers.kangaroo.model.utils.Direction;
import se.chalmers.kangaroo.model.utils.Position;

/**
 * This enemy is the standard in water.
 * 
 * @author pavlov
 * 
 */
public class FishCreature implements Creature {
	private static final int id = 114;
	private Position pos;
	private Position startPos;
	private Direction direction;
	private int speed = 2;
	private boolean isOutOfBounds = false;

	public FishCreature(Position pos) {
		startPos = pos;
		this.pos = pos;
		direction = Direction.DIRECTION_WEST;
	}

	@Override
	public boolean isKillable() {
		return true;
	}

	@Override
	public Polygon getPolygon() {
		int polyX[] = { pos.getX() + 0, pos.getX() + 2, pos.getX() + 2, pos.getX() + 4, pos.getX() + 4, pos.getX() + 6, pos.getX() + 6, pos.getX() + 8, pos.getX() + 8, pos.getX() + 16, pos.getX() + 16, pos.getX() + 18, pos.getX() + 18, pos.getX() + 20, pos.getX() + 20, pos.getX() + 22, pos.getX() + 22, pos.getX() + 24, pos.getX() + 24, pos.getX() + 26, pos.getX() + 26, pos.getX() + 28, pos.getX() + 28, pos.getX() + 32, pos.getX() + 32, pos.getX() + 28, pos.getX() + 28, pos.getX() + 26, pos.getX() + 26, pos.getX() + 24, pos.getX() + 24, pos.getX() + 22, pos.getX() + 22, pos.getX() + 20, pos.getX() + 20, pos.getX() + 18, pos.getX() + 18, pos.getX() + 16, pos.getX() + 16, pos.getX() + 8, pos.getX() + 8, pos.getX() + 6, pos.getX() + 6, pos.getX() + 4, pos.getX() + 4, pos.getX() + 2, pos.getX() + 2, pos.getX() + 0 };
		
		int polyY[] = { pos.getY() + 12, pos.getY() + 12, pos.getY() + 8, pos.getY() + 8, pos.getY() + 4, pos.getY() + 4, pos.getY() + 2, pos.getY() + 2, pos.getY() + 0, pos.getY() + 0, pos.getY() + 2, pos.getY() + 2, pos.getY() + 4, pos.getY() + 4, pos.getY() + 8, pos.getY() + 8, pos.getY() + 10, pos.getY() + 10, pos.getY() + 8, pos.getY() + 8, pos.getY() + 6, pos.getY() + 6, pos.getY() + 4, pos.getY() + 4, pos.getY() + 28, pos.getY() + 28, pos.getY() + 26, pos.getY() + 26, pos.getY() + 24, pos.getY() + 24, pos.getY() + 22, pos.getY() + 22, pos.getY() + 24, pos.getY() + 24, pos.getY() + 28, pos.getY() + 28, pos.getY() + 30, pos.getY() + 30, pos.getY() + 32, pos.getY() + 32, pos.getY() + 30, pos.getY() + 30, pos.getY() + 28, pos.getY() + 28, pos.getY() + 24, pos.getY() + 24, pos.getY() + 20, pos.getY() + 20 };
		return new Polygon(polyX, polyY, 47);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}
	
	public boolean isOutOfBounds(){
		return isOutOfBounds;
	}

	@Override
	public void updateCreature() {
		if(pos.getX() <= 2){
			isOutOfBounds = true;
		}else{
			if (direction == Direction.DIRECTION_WEST) {
				pos = new Position(pos.getX() - speed, pos.getY());
			} else {
				pos = new Position(pos.getX() + speed, pos.getY());
			}
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
	public void changeDirection() {}
	
	public Direction getDirection(){
		return this.direction;
	}
	
	public void resetPosition(){
		pos = startPos;
		isOutOfBounds = false;
	}
}
