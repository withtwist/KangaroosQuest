package se.chalmers.kangaroo.utils;

import java.io.File;
import java.util.HashMap;

import kuusisto.tinysound.Music;
import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;
import se.chalmers.kangaroo.io.OptionsIO;


public class GameSound {

	private HashMap<String, Music> musicMap;
	private HashMap<String, Sound> soundMap;
	private Music lastPlayed;
	private double bgDecibel;
	private double sfxDecibel;
	private OptionsIO io;
	private static GameSound soundInstance;
	
	public GameSound(){
		TinySound.init();
		musicMap = new HashMap<String, Music>();
		musicMap.put("empty", TinySound.loadMusic(new File("resources/music/empty.WAV")));
		musicMap.put("menumusic", TinySound.loadMusic(new File("resources/music/menumusic.WAV")));
		musicMap.put("level_1", TinySound.loadMusic(new File("resources/music/1_runner.WAV")));
		musicMap.put("level_2", TinySound.loadMusic(new File("resources/music/2_atributetoolimar.WAV")));
		musicMap.put("level_3", TinySound.loadMusic(new File("resources/music/3_arabicicemountain.WAV")));
		musicMap.put("level_4", TinySound.loadMusic(new File("resources/music/1_runner.WAV")));
		musicMap.put("level_5", TinySound.loadMusic(new File("resources/music/1_runner.WAV")));
		musicMap.put("level_6", TinySound.loadMusic(new File("resources/music/1_runner.WAV")));
		musicMap.put("level_7", TinySound.loadMusic(new File("resources/music/1_runner.WAV")));
		musicMap.put("level_8", TinySound.loadMusic(new File("resources/music/1_runner.WAV")));
		
		soundMap = new HashMap<String, Sound>();
		soundMap.put("jump", TinySound.loadSound(new File("resources/sfx/kangaroo_jump.WAV")));
		soundMap.put("doubleJump", TinySound.loadSound(new File("resources/sfx/kangaroo_doublejump.WAV")));
		soundMap.put("death", TinySound.loadSound(new File("resources/sfx/kangaroo_death.WAV")));
		
		soundMap.put("red", TinySound.loadSound(new File("resources/sfx/redblue_red.WAV")));
		soundMap.put("blue", TinySound.loadSound(new File("resources/sfx/redblue_blue.WAV")));
		soundMap.put("on", TinySound.loadSound(new File("resources/sfx/onoff_on.WAV")));
		soundMap.put("off", TinySound.loadSound(new File("resources/sfx/onoff_off.WAV")));
		
		soundMap.put("creaturedeath", TinySound.loadSound(new File("resources/sfx/creature_death.WAV")));
		soundMap.put("victory", TinySound.loadSound(new File("resources/sfx/victory.WAV")));
		
		io = OptionsIO.getInstance();
		loadFromFile();
	}
	
	public static synchronized GameSound getInstance(){
		if(soundInstance == null)
			soundInstance = new GameSound();
		return soundInstance;
	}
	
	public void playSfx(String name){
		soundMap.get(name).play(sfxDecibel);
	}
	
	public void playBgMusic(String name){
		if(lastPlayed != null)
			lastPlayed.stop();
		lastPlayed = musicMap.get(name);
		if(musicMap.containsKey(name))
			musicMap.get(name).play(true, bgDecibel);
	}
	
	public void setBgVolume(double decibel){
		bgDecibel = decibel;
		writeToFile();
	}

	public void setSfxVolume(double decibel){
		sfxDecibel = decibel;
		writeToFile();
	}

	public double getBgVolume(){
		return bgDecibel;
	}

	public double getSfxVolume(){
		return sfxDecibel;
	}
	
	private void writeToFile() {
		io.saveVolume(bgDecibel, sfxDecibel);
		loadFromFile();
	}
	
	private void loadFromFile() {
		bgDecibel = io.getBgVolume();
		sfxDecibel = io.getSfxVolume();
	}
}
