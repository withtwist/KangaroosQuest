package se.chalmers.kangaroo.model.creatures;

import java.awt.Polygon;

import se.chalmers.kangaroo.model.utils.Direction;
import se.chalmers.kangaroo.model.utils.Position;

/**
 * This abstract class represents all the different hostile creatures in the
 * game.
 * 
 * @author simonal
 * @modified by arvidk
 * 
 */
public interface Creature{
	/**
	 * Returns true of the creature is killable and false if it isn't.
	 * 
	 * @return killable
	 */
	public boolean isKillable();

	/**
	 * Returns the specified creatures polygon.
	 * 
	 * @return
	 */
	public Polygon getPolygon();

	/**
	 * Moves the creature according to what direction it is moving in and its
	 * speed.
	 * 
	 * @param dy
	 * @param dx
	 */
	public void move();

	/**
	 * Updates the Creature.
	 */
	public void updateCreature();

	/**
	 * Returns an ID for this creature, the id is specific for the type of creature. 
	 * @return the id of the creature
	 */
	public int getId();

	
	/**
	 * Returns the current position of this creature. 
	 * @return the current position
	 */
	public Position getPosition();

	
	/**
	 * Changes direction of this creature. 
	 */
	public void changeDirection();
	
	/**
	 * The direction of the creature.
	 * @return the current direction
	 */
	public Direction getDirection();

}
