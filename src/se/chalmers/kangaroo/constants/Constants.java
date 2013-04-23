package se.chalmers.kangaroo.constants;

import java.awt.Dimension;
import java.awt.Font;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * A class to keep track of all constants. A class with only public static final
 * variables.
 * 
 * @author Arvid
 * 
 */
public class Constants {
	/*
	 * A constant to keep track of the tile size so we can check collition.
	 */
	public static final int TILE_SIZE = 32;

	/*
	 * Constant to get specific tiles.
	 */

	public static final int TILE_INVISIBLE = 42;
	public static final String COLLIDE_IDS = " 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 21 22 23 24 25 31 33 34 ";
	public static final String ITEM_IDS = " 51 52 53 54 ";
	public static final String CREATURE_IDS = " 111 112 113 114 115 116 ";
	public static final String IOBJECTS_IDS = " 71 72 73 74 ";
	public static final String IOBJECTS_IDS_REDBLUE = " 71 72 ";
	public static final String IOBJECTS_IDS_ONOFF = " 73 74 ";
	public static final String INTERACTIVE_TILES = " 91 92 93 94 95 96 ";
	public static final String INTERACTIVE_TILES_REDBLUE = " 91 92 93 94 ";
	public static final String INTERACTIVE_TILES_ONOFF = " 95 96 ";
	public static final String BACKGROUND_MISC_TILES = " 131 132 133 134 135 136 137 138 139 140 151 152 153 154 155 156 157 158 159 160 161 162 163 164 165 166 167 168 169 170 171 172 181 182 183 184 185 186 187 188 ";
	public static final String ANIMATED_TILES = " 76 77 ";
	
	/*
	 * Constants that is used normally.
	 */
	public static final double NANO_TO_SECOND = 0.000000001;
	public static final double NANO_TO_MILLI = 0.000001;

	/*
	 * Constants for resolution of the game screen.
	 */
	public static final int RESOLUTION_WIDTH = 1024;
	public static final int RESOLUTION_HEIGHT = 576;
	public static final Dimension RESOLUTION = new Dimension(RESOLUTION_WIDTH, RESOLUTION_HEIGHT);

	/*
	 * Constants for Custom Key-button dimension.
	 */
	public static final int BUTTON_RESOLUTION_WIDTH = 150;
	public static final int BUTTON_RESOLUTION_HEIGHT = 50;
	public static final Dimension BUTTON_RESOLUTION = new Dimension(150, 50);

	/*
	 * Constants for title preferences.
	 */
	public static final Font H1 = new Font("Dialog", Font.PLAIN, 36);
	public static final Font H2 = new Font("Dialog", Font.PLAIN, 24);
	public static final Font P_RANK = new Font("Dialog", Font.PLAIN, 18);

	public static final int NUMBER_OF_LEVELS = 7;

	public static final int NUMBER_OF_HIGHSCORENAMES = 10;
	
	/*
	 * Constants for settings file
	 */
	public static final String SETTINGS_FILE_NAME ="settings.txt";
	public static final int NUMBER_OF_KEYS = 4;
	public static final int NUMBER_OF_SOUNDOPT = 2;
	
	public static final int SETTINGS_INTEGER = 0;
	public static final int SETTINGS_DOUBLE = 1;
	public static final int SETTINGS_STRING = 2;
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	/*
	 * Game data constants
	 */
	public static final Dimension POS_KANGAROO_START = new Dimension(10, 186);
	public static final Dimension POS_CLOCK = new Dimension(10, 20);
	public static final Dimension POS_DEATH = new Dimension(70, 20);
}
