package se.chalmers.kangaroo.constants;

import java.awt.Dimension;

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
	public static final String COLLIDE_IDS = " 1 2 3 4 5 6 7 8 9 10 ";
	public static final String ITEM_IDS = " 51 52 53 54 ";
	public static final String CREATURE_IDS = " 111 112 113 114 115 116 ";
	public static final String IOBJECTS_IDS = " 71 72 73 74 ";
	public static final String IOBJECTS_IDS_REDBLUE = " 71 72 ";
	public static final String IOBJECTS_IDS_ONOFF = " 73 74 ";
	public static final String INTERACTIVE_TILES = " 91 92 93 94 95 96 ";
	public static final String INTERACTIVE_TILES_REDBLUE = " 91 92 93 94 ";
	public static final String INTERACTIVE_TILES_ONOFF = " 95 96 ";
	public static final String BACKGROUND_MISC_TILES = " 131 132 133 134 135 136 137 138 139 140 151 152 153 154 155 156 157 158 159 160 161 162 163 164 ";

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
	public static final Dimension RESOLUTION = new Dimension(1024, 576);

	/*
	 * Constants for Custom Key-button dimension.
	 */
	public static final int BUTTON_RESOLUTION_WIDTH = 150;
	public static final int BUTTON_RESOLUTION_HEIGHT = 50;
	public static final Dimension BUTTON_RESOLUTION = new Dimension(150, 50);

	/*
	 * Constants for title preferences.
	 */

	public static final String TITLE_START = "<html><body><font size='45'>";
	public static final String TITLE_END = "</font></body></html>";

	public static final int NUMBER_OF_LEVELS = 7;

	public static final int NUMBER_OF_HIGHSCORENAMES = 10;
}
