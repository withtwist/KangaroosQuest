package se.chalmers.kangaroo.utils;

import java.awt.event.KeyEvent;

import se.chalmers.kangaroo.io.OptionsIO;

/**
 * This is a singleton that hold the key binding for GameController. it has
 * setters and getters for each function requiring a key-press.
 * 
 * @author pavlov
 * 
 */
public class CustomKeys {
	private static CustomKeys instance;
	private int jumpKey, leftKey, rightKey, itemKey;
	private OptionsIO io;

	/**
	 * Sets the default scheme for the control.
	 */
	private CustomKeys() {
		io = OptionsIO.getInstance();
		loadFromFile();
	}

	/**
	 * This is for getting the singleton
	 * 
	 * @return the singleton
	 */
	public static synchronized CustomKeys getInstance() {
		if (instance == null) {
			instance = new CustomKeys();
		}
		return instance;
	}

	/**
	 * Sets key binding for jump key.
	 * 
	 * @param jumpKey
	 *            is the key you perform the action jump with.
	 */
	public void setJumpKey(int jumpKey) {
		this.jumpKey = jumpKey;
		writeToFile();
	}

	/**
	 * Getter for jump key
	 * 
	 * @return the key for jump.
	 */
	public int getJumpKey() {
		return jumpKey;
	}
	
	public String getJumpKeyName() {
		return KeyEvent.getKeyText(getJumpKey());
	}

	/**
	 * Sets key binding for left key.
	 * 
	 * @param leftKey
	 *            is the key you perform the action go left with.
	 */
	public void setLeftKey(int leftKey) {
		this.leftKey = leftKey;
		writeToFile();
	}

	/**
	 * Getter for go left key
	 * 
	 * @return the key for go left.
	 */
	public int getLeftKey() {
		return leftKey;
	}
	
	public String getLeftKeyName() {
		return KeyEvent.getKeyText(getLeftKey());
	}

	/**
	 * Sets key binding for right key.
	 * 
	 * @param rightKey
	 *            is the key you perform the action go right with.
	 */
	public void setRightKey(int rightKey) {
		this.rightKey = rightKey;
		writeToFile();
	}

	/**
	 * Getter for go right key
	 * 
	 * @return the key for go right.
	 */
	public int getRightKey() {
		return rightKey;
	}
	
	public String getRightKeyName() {
		return KeyEvent.getKeyText(getRightKey());
	}

	/**
	 * Sets key binding for item key.
	 * 
	 * @param itemKey
	 *            is the key you perform the action use item with.
	 */
	public void setItemKey(int itemKey) {
		this.itemKey = itemKey;
		writeToFile();
	}

	/**
	 * Getter for use item key
	 * 
	 * @return the key for use item.
	 */
	public int getItemKey() {
		return itemKey;
	}
	
	public String getItemKeyName() {
		return KeyEvent.getKeyText(getItemKey());
	}

	private void writeToFile() {
		int[] keys = { leftKey, rightKey, jumpKey, itemKey };
		io.setKeys(keys);
		loadFromFile();
	}

	private void loadFromFile() {
		int[] keys = io.getKeys();
		leftKey = keys[0];
		rightKey = keys[1];
		jumpKey = keys[2];
		itemKey = keys[3];
	}

}
