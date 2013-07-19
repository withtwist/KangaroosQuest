package se.chalmers.kangaroo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import se.chalmers.kangaroo.constants.Constants;

public class Stats {
	private static Stats instance;
	private String stats_file_dir = "resources/" + Constants.STATS_FILE_NAME;
	File statsFile = new File(stats_file_dir);

	private int jumps;
	private int finishedCourses;
	private long time;
	private int enemyKilled;
	private int killedByEnemy;
	private int killedByRespawn;
	private int killedByOther;

	private Stats() {
		if (!statsFile.exists()) {
			try {
				statsFile.createNewFile();
				resetSettings();
			} catch (IOException e) {
				System.out.println("IO Exception when creating the file.");
			}
		} else {
			readFile();
		}
	}

	public static synchronized Stats getInstance() {
		if (instance == null) {
			instance = new Stats();
		}
		return instance;
	}

	/*
	 * Jumps;FinishedCourses;Time;EnemyKilled;KilledByEnemy;KilledByRespawn;
	 * KilledByOther
	 */
	private void resetSettings() {
		jumps = 0;
		finishedCourses = 0;
		time = 0;
		enemyKilled = 0;
		killedByEnemy = 0;
		killedByRespawn = 0;
		killedByOther = 0;
		writeToFile();
	}

	private void readFile() {
		try {
			BufferedReader input = new BufferedReader(new FileReader(
					stats_file_dir));
			Object obj = "";
			String line;
			line = input.readLine();
			String[] params;
			params = line.split(";");
			jumps = Integer.parseInt(params[0]);
			finishedCourses = Integer.parseInt(params[1]);
			time = Integer.parseInt(params[2]);
			enemyKilled = Integer.parseInt(params[3]);
			killedByEnemy = Integer.parseInt(params[4]);
			killedByRespawn = Integer.parseInt(params[5]);
			killedByOther = Integer.parseInt(params[6]);
		} catch (FileNotFoundException e) {
			System.out.println("Stats file not found.");
		} catch (IOException e) {
			System.out.println("Error when reading line from stats.");
		} catch (NumberFormatException e) {
			System.out.println("Could not convert stats to Integers.");
		}
	}

	private void writeToFile() {
		StringBuilder outputText = new StringBuilder();
		outputText.append(jumps);
		outputText.append(";");
		outputText.append(finishedCourses);
		outputText.append(";");
		outputText.append(time);
		outputText.append(";");
		outputText.append(enemyKilled);
		outputText.append(";");
		outputText.append(killedByEnemy);
		outputText.append(";");
		outputText.append(killedByRespawn);
		outputText.append(";");
		outputText.append(killedByOther);
		try {
			BufferedWriter output = new BufferedWriter(new FileWriter(
					stats_file_dir));
			output.write(outputText.toString());
			output.flush();
			output.close();
		} catch (IOException e) {
			System.out.println("Couldn't write to file");
		}
	}

	public int getJumps() {
		return jumps;
	}

	public void increaseJumps() {
		jumps++;
		writeToFile();
	}

	public int getFinishedCourses() {
		return finishedCourses;
	}

	public void increaseFinishedCourses() {
		finishedCourses++;
		writeToFile();
	}

	public long getTime() {
		return time;
	}

	public void increaseTime(long session) {
		time += session;
		writeToFile();
	}

	public int getEnemyKilled() {
		return enemyKilled;
	}

	public void increaseEnemyKilled() {
		enemyKilled++;
		writeToFile();
	}

	public int getKilledByEnemy() {
		return killedByEnemy;
	}

	public void increaseKilledByEnemy() {
		killedByEnemy++;
		writeToFile();
	}

	public int getKilledByRespawn() {
		return killedByRespawn;
	}

	public void increaseKilledByRespawn() {
		killedByRespawn++;
		writeToFile();
	}

	public int getKilledByOther() {
		return killedByOther;
	}

	public void increaseKilledByOther() {
		killedByOther++;
		writeToFile();
	}

}
