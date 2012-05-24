package se.chalmers.kangaroo.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * This is a class handling the map-files. It is used to take a .tmx file (maybe
 * more in the future) and make them readable by putting them in a matrix of
 * IDs.
 * 
 * @author alburgh
 * @modifiedby simonal
 * 
 */
public class FileToMap {

	/**
	 * A method for reading a tmx-file to a matrix of IDs. It is important that
	 * the layer in the .tmx is called "tiles" and that it is not compressed or
	 * encoded.
	 * 
	 * @param fileName
	 *            , the filename to the map
	 * @return null if unsuccessful, otherwise a matrix of ints where each int
	 *         is an id.
	 */
	public static int[][] readTmxFileToMap(String fileName) {
		int[][] tileId = null;
		try {
			InputStream in = new FileInputStream(fileName);
			Scanner sc = new Scanner(in);

			while (sc.hasNextLine()) {
				String tmp = sc.nextLine();
				if (tmp.contains("name=\"tiles\"")) {
					String[] split = tmp.split("\"");
					int width = Integer.parseInt(split[3]);
					int height = Integer.parseInt(split[5]);
					tileId = new int[width][height];
					sc.nextLine(); // Jump over the <data> line
					for (int i = 0; i < height; i++) {
						for (int j = 0; j < width; j++) {
							String tiles = sc.nextLine().substring(14);
							tiles = tiles.substring(0, tiles.length() - 3);
							tileId[j][i] = Integer.parseInt(tiles);
						}
					}
				}
			}
			sc.close();
			in.close();

		} catch (IOException e) {
			System.out.println("Wrong filename!");
		}
		return tileId;
	} 
}
