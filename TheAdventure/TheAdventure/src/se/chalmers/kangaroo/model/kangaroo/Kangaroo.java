package se.chalmers.kangaroo.model.kangaroo;

import java.awt.Polygon;

import se.chalmers.kangaroo.model.utils.Direction;
import se.chalmers.kangaroo.model.utils.Position;
import se.chalmers.kangaroo.utils.GameSound;

/**
 * This class represents the Kangaroo controlled by the player.
 * 
 * @author simonal
 * @modified by arvidk
 * 
 */
public class Kangaroo{

	private Item item;

	private Position pos;
	private Position spawnPos;

	private float verticalSpeed = 0;
	private float horizontalSpeed = 0;

	private float maxSpeed = 5f;

	private Direction direction = Direction.DIRECTION_NONE;

	private boolean enableDoubleJump = false;

	private boolean isStillJumping = false;
	private boolean isJumping = false;
	private boolean isFalling = false;

	private boolean immortal = false;
	private GameSound s;

	/**
	 * The constructor for Kangaroo.
	 * 
	 * @param spawnPos
	 * @return
	 */
	public Kangaroo(Position spawnPos) {
		this.direction = Direction.DIRECTION_NONE;
		this.pos = spawnPos;
		this.spawnPos = spawnPos;
		this.s = GameSound.getInstance();
	}

	/**
	 * Returns the item currently in use of the Kangaroo.
	 * 
	 * @return currentItem
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * Returns the kangaroos polygon.
	 * 
	 * @return
	 */
	public Polygon getPolygon() {
		int[] xcords = { pos.getX(), pos.getX() + 31, pos.getX() + 31,
				pos.getX() };
		int[] ycords = { pos.getY(), pos.getY(), pos.getY() + 63,
				pos.getY() + 63 };
		return new Polygon(xcords, ycords, 4);
	}

	/**
	 * Sets and if possible replaces the old item with a new one.
	 * 
	 * @param newItem
	 */
	public void setItem(Item newItem) {
		if (this.item != null) {
			this.item.onDrop(this);
		}
		this.item = newItem;
		this.item.onPickup(this);
	}

	/**
	 * Removes the current item on the kangaroo;
	 */
	public void removeItem() {
		this.item = null;
	}

	/**
	 * Moves the Kangaroo with the specified delta-y and delta-x.
	 */
	public void setRelativePosition(int dx, int dy) {
		this.pos = new Position(pos.getX() + dx, pos.getY() + dy);
	}

	/**
	 * Moves the Kangaroo to the specified position.
	 * 
	 * @param p
	 */
	public void setPosition(Position p) {
		this.pos = p;
	}

	/**
	 * Sets the direction that the Kangaroo is moving towards.
	 * 
	 * @param d
	 */
	public void setDirection(Direction d) {
		this.direction = d;
	}

	/**
	 * Returns the vertical speed of the Kangaroo.
	 * 
	 * @return
	 */
	public float getVerticalSpeed() {
		return verticalSpeed;
	}

	/**
	 * Sets the vertical speed of the Kangaroo.
	 * 
	 * @param f
	 */
	public void setVerticalSpeed(Float f) {
		this.verticalSpeed = f;
	}

	/**
	 * Returns the current position of the Kangaroo.
	 * 
	 * @return
	 */
	public Position getPosition() {
		return pos;
	}

	/**
	 * Returns the current direction the kangaroo is facing.
	 * 
	 * @return
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * Returns the spawnposition of the kangaroo.
	 * 
	 * @return
	 */
	public Position getSpawnPosition() {
		return spawnPos;
	}

	/**
	 * Enables doublejump.
	 */
	public void enableDoubleJump() {
		this.enableDoubleJump = true;
	}

	/**
	 * Disables doublejump.
	 */
	public void disableDoubleJump() {
		this.enableDoubleJump = false;
	}
	/**
	 * Returns whether or not the kangaroo should be able to doublejump.
	 * @return true if doublejump is enabled.
	 */
	public boolean isDoubleJumpEnabled() {
		return enableDoubleJump;
	}

	/**
	 * Set to false when the jump is over. 
	 * @param isStillJumping
	 */
	public void setStillJumping(boolean isStillJumping) {
		this.isStillJumping = isStillJumping;
	}
	/**
	 * Return whether or not the kangaroo is still jumping
	 * @return, true if still jumping
	 */
	public boolean getStillJumping() {
		return isStillJumping;
	}

	/**
	 * Makes the Kangaroo jump by setting its vertical speed.
	 */
	public void jump() {
		if (isJumping == false) {
			s.playSfx("jump");
			this.isJumping = true;
			this.isFalling = true;
			new Thread() {
				@Override
				public void start() {
					try {
						while (isStillJumping) {
							verticalSpeed += -0.33f;
							if (verticalSpeed <= -7.2f) {
								isStillJumping = false;
							}
						}
					} finally {
					}
				}
			}.start();

		} else if (enableDoubleJump) {
			s.playSfx("doubleJump");
			this.verticalSpeed = -8.7f;
			enableDoubleJump = false;
		}
	}

	/**
	 * Sets the variable isFalling.
	 * 
	 * @param b
	 */
	public void setFalling(Boolean b) {
		this.isFalling = b;
	}

	/**
	 * Returns true of the kangaroo is immortal.
	 * 
	 * @return
	 */
	public boolean isImmortal() {
		return immortal;
	}

	/**
	 * Sets the kangaroo immortalstatus to either true or false;
	 * 
	 * @param b
	 */
	public void setImmortal(boolean b) {
		this.immortal = b;
	}

	/**
	 * Sets the maximum speed of the kangaroo.
	 * 
	 * @param f
	 */
	public void setMaxSpeed(float f) {
		maxSpeed = f;
	}

	public void updateKangaroo() {
		this.move();

	}

	/**
	 * Resets the kangaroos position to where it was at the begining and also
	 * sets all the speeds to 0.
	 */
	public void reset() {
		this.pos = spawnPos;
		this.horizontalSpeed = 0f;
		this.verticalSpeed = 0f;
		this.isFalling = true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pos == null) ? 0 : pos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kangaroo other = (Kangaroo) obj;
		if (pos == null) {
			if (other.pos != null)
				return false;
		} else if (!pos.equals(other.pos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Kangaroo [pos=" + pos + "]";
	}

	public void move() {

		if (isFalling && Math.abs(verticalSpeed) < 10f) {
			verticalSpeed += 0.32f;
		}

		if (direction == Direction.DIRECTION_EAST) {
			if (horizontalSpeed < maxSpeed) {
				horizontalSpeed += 0.5f;
			}
		}
		if (direction == Direction.DIRECTION_WEST) {
			if (horizontalSpeed > -maxSpeed) {
				horizontalSpeed -= 0.5f;
			}
		}
		if (direction == Direction.DIRECTION_NONE) {
			if (horizontalSpeed < 0) {
				horizontalSpeed += 0.5f;
			} else if (horizontalSpeed > 0) {
				horizontalSpeed -= 0.5f;
			}

		}
		this.setRelativePosition((int) horizontalSpeed, (int) verticalSpeed);
		isJumping = !(verticalSpeed == 0);

	}

}
