package se.chalmers.kangaroo.utils;

import se.chalmers.kangaroo.io.Stats;

public class GeneralTimer {
	private static GeneralTimer instance;
	private long start;
	private long end;
	private GeneralTimer(){
		
	}
	
	public static synchronized GeneralTimer getInstace() {
		if (instance == null) {
			instance = new GeneralTimer();
		}
		return instance;
	}
	
	public void start(){
		start = System.currentTimeMillis();
	}
	
	public void end(){
		end = System.currentTimeMillis();
	}
	
	public long getTime(){
		return (end-start);
	}

}
