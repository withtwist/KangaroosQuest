package se.chalmers.kangaroo.view;

import java.awt.Graphics;

/**
 * An interface for handling all the different animations.
 * 
 * @author simonal
 * 
 */
public interface Animation {
	/**
	 * Draws the current frame of the sprite in the view.
	 * 
	 * @param g
	 */
	public void drawSprite(Graphics g, int x, int y);


}
