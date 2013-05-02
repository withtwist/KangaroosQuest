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
public class HorseCreature implements Creature {
	private static final int id = 117;
	private Position pos;
	private Position startPos;
	private Direction direction;
	private int speed = 4;
	private boolean isOutOfBounds = false;

	public HorseCreature(Position pos) {
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
		int polyX[] = { pos.getX() + 0, pos.getX() + 96, pos.getX() + 96, pos.getX() + 0 };
		
		int polyY[] = { pos.getY() + 0, pos.getY() + 0, pos.getY() + 96, pos.getY() + 96 };
		return new Polygon(polyX, polyY, 4);
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