package se.chalmers.kangaroo.model;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class AnimatedTile extends Tile{
	private Timer t;
	private int nbrOfTiles, currentTile, animationCycle;
	private ArrayList<Integer> tiles;
	
	public AnimatedTile(int i, int x, int y) {
		super(i, x, y);
		currentTile = 0;
		tiles = new ArrayList<Integer>(); 
		switch(i){
		case 76:
			nbrOfTiles = 2;
			animationCycle = 1000;
			tiles.add(76);
			tiles.add(165);
			break;
		case 77:
			nbrOfTiles = 2;
			animationCycle = 1000;
			tiles.add(77);
			tiles.add(166);
			break;
		default:
			nbrOfTiles = 1;
			animationCycle = 1000;
			tiles.add(42);
		}
		changeId(tiles.get(nbrOfTiles-1));
		t = new Timer();
		t.schedule(new Animation(), 0, animationCycle/(nbrOfTiles-1));
	}
	class Animation extends TimerTask{
		@Override
		public void run() {
			changeId(tiles.get(currentTile));
			if(currentTile >= nbrOfTiles-1){
				currentTile = 0;
			}else{
				currentTile++;
			}
			
		}
		
	}

}
