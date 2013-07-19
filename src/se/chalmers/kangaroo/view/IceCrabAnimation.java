package se.chalmers.kangaroo.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


public class IceCrabAnimation implements Animation{
	private int tick;
	private int currentSprite;
	private Image sheet;
	private int width;
	private int height;
	
	/**
	 * Creates the animation for a crab.
	 * @param c, must be a crabcreature. 
	 */
	public IceCrabAnimation(){
		tick = 0;
		currentSprite = 0;
		this.sheet = Toolkit.getDefaultToolkit().getImage("resources/gfx/sheets/crab_ice_256x32.png");
		this.width = 64;
		this.height = 32;
	}
	@Override
	public void drawSprite(Graphics g, int x, int y) {
		if(tick == 10){
			tick = 0;
			currentSprite++;
			currentSprite = currentSprite % 4;
		}
		g.drawImage(sheet, x, y, x+width, y+height, currentSprite*64, 0, currentSprite*64+width, height, null, null);
		tick++;
	}
	
	/**
	 * Returns the string showing the current animationstate of this creature. 
	 */
	@Override
	public String toString(){
		return "CrabAnimation: " +tick +" "+currentSprite;
	}
}