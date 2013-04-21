package se.chalmers.kangaroo.model;

import java.util.ArrayList;
import java.util.Timer;

public class AnimatedTile extends Tile{
	private Timer t;
	
	public AnimatedTile(int i, int x, int y, ArrayList<Integer> tiles) {
		super(i, x, y);
		t = new Timer();
	}

}
