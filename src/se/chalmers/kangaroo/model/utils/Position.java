package se.chalmers.kangaroo.model.utils;

/**
 * This is a class to represent the position. The class will take either two
 * coordinates or a position in the constructor, and then make a new position to
 * apply on another object.
 * 
 * @author arvidk
 * 
 */

public class Position {

	/*
	 * The x-coordinate with the origo at the top left corner
	 */
	private int x;

	/*
	 * The y-coordinate with origo in the top left corner
	 */
	private int y;

	/**
	 * Creates a new position with another position. Makes a deep clone of
	 * another position so it can be applied on different objects.
	 * 
	 * @param pos
	 */
	public Position(Position pos) {
		this.x = pos.getX();
		this.y = pos.getY();
	}

	/**
	 * Creates a new position with two coordinates. Makes a new position with
	 * the help of two integers.
	 * 
	 * @param x
	 * @param y
	 */

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * 
	 * @return the x-coordinate.
	 */
	public int getX() {
		return x;
	}

	/**
	 * 
	 * @return the y-coordinate.
	 */
	public int getY() {
		return y;
	}

	@Override
	/**
	 * The toString-method in Position.
	 * @return the coordinates as a String.
	 */
	public String toString() {
		return "x: " + x + ". y: " + y + ".";
	}

	@Override
	/**
	 * @return the hashCode of the coordinates as an int.
	 */
	public int hashCode() {
		// TODO fix hashCode
		return super.hashCode() * x * 7 + y * 11;
	}

	@Override
	/**
	 * @return a boolean value if two positions are
	 * equals or not.
	 */
	public boolean equals(Object obj) {
		// TODO fix equals

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}