package se.chalmers.kangaroo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import se.chalmers.kangaroo.constants.Constants;

/**
 * This is a class that will save your custom keys to a file. You will of course
 * be able to load them as well.
 * 
 * @author alburgh
 * @modifiedby simonal, pavlov
 * 
 */
public class OptionsIO {
	private static OptionsIO instance;
	private String settings_file_dir = "resources/"
			+ Constants.SETTINGS_FILE_NAME;
	File settingsFile = new File(settings_file_dir);
	String sep = System.getProperty("line.separator");

	/* Private constructor, so only one instance will be created. */
	private OptionsIO() {
		if (!settingsFile.exists()) {
			try {
				settingsFile.createNewFile();
				BufferedWriter output = new BufferedWriter(new FileWriter(
						settings_file_dir));
				String defaultSettings = "///SETTINGS///" + sep + sep;
				defaultSettings += "#KEYS" + sep + "Go_Left=37" + sep
						+ "Go_Right=39" + sep + "Jump=38" + sep + "Use_Item=67"
						+ sep + sep;
				defaultSettings += "#SOUND" + sep + "BGM_Volume=0.57" + sep + "SFX_Volume=0.62" + sep + sep;
				defaultSettings += "#MAPPACK" + sep + "Map=default";
				output.write(defaultSettings);
				output.flush();
				output.close();
			} catch (IOException e) {
				System.out.println("IO Exception when creating the file.");
			}
		}
	}

	/**
	 * Returns the only instance of this class.
	 * 
	 * @return
	 */
	public static synchronized OptionsIO getInstance() {
		if (instance == null)
			instance = new OptionsIO();
		return instance;
	}

	/**
	 * Used to reload the file.
	 * 
	 * @throws IOException
	 */
	private void replaceValue(String attribute, Object value) {
		String newString = "";
		String line;
		String[] splitParams;
		try {
			BufferedReader input = new BufferedReader(new FileReader(
					settings_file_dir));
			while ((line = input.readLine()) != null) {
				splitParams = line.split("=", 2);
				if (splitParams[0].equals(attribute)) {
					if (value instanceof Integer) {
						newString += splitParams[0] + "=" + (Integer) value
								+ sep;
					} else if (value instanceof Double) {
						newString += splitParams[0] + "=" + (Double) value
								+ sep;
					} else {
						newString += splitParams[0] + "=" + (String) value
								+ sep;
					}

				} else {
					newString += line + "\n";
				}
			}
			input.close();
			BufferedWriter output = new BufferedWriter(new FileWriter(
					settings_file_dir));
			output.write(newString);
			output.flush();
			output.close();
		} catch (IOException e) {
			System.out.println("Couldn't read IO in replaceValue");
		}
	}

	private Object getValue(String attribute, int type) {
		try {
			BufferedReader input = new BufferedReader(new FileReader(
					settings_file_dir));
			Object obj = "";
			String line;
			String[] params;
			while ((line = input.readLine()) != null) {
				params = line.split("=", 2);
				if (params[0].equals(attribute)) {
					if(type == Constants.SETTINGS_INTEGER){
						obj = Integer.parseInt(params[1]);
					} else if(type == Constants.SETTINGS_DOUBLE){
						obj = Double.parseDouble(params[1]);
					}else{
						obj = params[1];
					}
				}
			}
			return obj;
		} catch (FileNotFoundException e) {
			System.out.println("Take care of this later");
		} catch (NumberFormatException e) {
			System.out.println("Take care of this later");
		} catch (IOException e) {
			System.out.println("Take care of this later");
		}
		return -1;
	}

	/**
	 * Returns the current keys set in the file.
	 * 
	 * @return the key codes.
	 */
	public int[] getKeys() {
		int[] keys = new int[Constants.NUMBER_OF_KEYS];
		keys[0] = (Integer) getValue("Go_Left", Constants.SETTINGS_INTEGER);
		keys[1] = (Integer) getValue("Go_Right", Constants.SETTINGS_INTEGER);
		keys[2] = (Integer) getValue("Jump", Constants.SETTINGS_INTEGER);
		keys[3] = (Integer) getValue("Use_Item", Constants.SETTINGS_INTEGER);
		return keys;
	}

	/**
	 * Use the KeyEvent.keycodes to set your keys. You can then use getKeys to
	 * return them.
	 * 
	 * @param key
	 *            , the array of key codes.
	 */
	public void setKeys(int[] key) {
		replaceValue("Go_Left", key[0]);
		replaceValue("Go_Right", key[1]);
		replaceValue("Jump", key[2]);
		replaceValue("Use_Item", key[3]);
	}

	/**
	 * A method for setting the backgorund and soundeffets volumes.
	 * 
	 * @param bg
	 *            , the background volume
	 * @param sfx
	 *            , the sound effects volume
	 */
	public void saveVolume(double bg, double sfx) {
		replaceValue("BGM_Volume", bg);
		replaceValue("SFX_Volume", sfx);
	}

	/**
	 * A method that will return the background volume Will return -1 if the
	 * value cannot be read.
	 * 
	 * @return a value between 0 and 1
	 */
	public double getBgVolume() {
		return (Double) getValue("BGM_Volume", Constants.SETTINGS_DOUBLE);
	}

	/**
	 * A method that will return the sound effects volume Will return -1 if the
	 * value cannot be read.
	 * 
	 * @return a value between 0 and 1
	 */
	public double getSfxVolume() {
		return (Double) getValue("SFX_Volume", Constants.SETTINGS_DOUBLE);
	}

}
