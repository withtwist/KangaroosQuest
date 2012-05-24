package se.chalmers.kangaroo.model.minigame;

/**
 * This is the class for a minigame in the game where you have to "push" the
 * columns in order to get all row's and column's sums to be equal. When they
 * are, you can move forward in game.
 * 
 * @author pavlov
 * 
 */
public class EqualSumsMinigame {
	private int nbrArray[][];
	private int currentPosX;
	private int currentPosY;
	private int size;

	/**
	 * The constructor creates an array with the numbers in its right positions,
	 * then it pushes the columns random times so it is "shuffled".
	 * 
	 * @param size
	 *            is the width/row.
	 */
	public EqualSumsMinigame(int size) {
		this.size = size;
		this.nbrArray = new int[size][size];
		fillArray(size);
		while (isSumsEqual()) {
			for (int i = 0; i < size; i++) {
				pushColumnRandom(i);
			}
		}
	}

	/**
	 * Fills the array with the numbers in right positions.
	 * 
	 * @param size
	 *            is the width/row.
	 */
	private void fillArray(int size) {
		currentPosX = (size - 1) / 2;
		currentPosY = 0;
		nbrArray[currentPosX][currentPosY] = 1;
		for (int i = 2; i <= (size * size); i++) {
			if (nbrArray[(currentPosX + 1 + size) % size][(currentPosY - 1 + size)
					% size] != 0) {
				nbrArray[currentPosX][(currentPosY + 1 + size) % size] = i;
				currentPosY = (currentPosY + 1 + size) % size;
			} else {
				nbrArray[(currentPosX + 1 + size) % size][(currentPosY - 1 + size)
						% size] = i;
				currentPosX = (currentPosX + 1 + size) % size;
				currentPosY = (currentPosY - 1 + size) % size;
			}
		}

	}

	/**
	 * Pushing the column with numbers up. So the first number will be the last,
	 * the second number will be the first and so on.
	 * 
	 * @param column
	 *            is which column in the array that it pushes up.
	 * @param nbrOfTimes
	 *            is how many times it should push up.
	 */
	public void pushColumn(int column, int nbrOfTimes) {
		int temp;
		for (int i = 1; i <= nbrOfTimes; i++) {
			temp = nbrArray[column][0];
			for (int j = 0; j < size - 1; j++) {
				nbrArray[column][j] = nbrArray[column][j + 1];
			}
			nbrArray[column][size - 1] = temp;
		}
	}

	/**
	 * This method push the column with the numbers random times.
	 * 
	 * @param column
	 *            is the column in the array that it oushes up.
	 */
	private void pushColumnRandom(int column) {
		pushColumn(column, (int) (Math.random() * size) + 1);

	}

	/**
	 * Gets the value in given field in the array.
	 * 
	 * @param x
	 *            is the x-position in the array.
	 * @param y
	 *            is the y-position in the array.
	 * @return the value in the field.
	 */
	public int getNbr(int x, int y) {
		return nbrArray[x][y];
	}

	/**
	 * Check if all row's and column's sums are equal.
	 * 
	 * @return a boolean that is true if sums are equal.
	 */
	public boolean isSumsEqual() {
		boolean isRow = true;
		for (int i = 1; i <= 2; i++) {
			for (int j = 0; j < size - 1; j++) {
				if (getSum(j, isRow) != getSum(j + 1, isRow)) {
					return false;
				}
			}
			isRow = false;
		}
		// Also checks if row and column has same sums
		if (getSum(size - 1, true) != getSum(size - 1, false)) {
			return false;
		}
		return true;

	}

	/**
	 * Gets the sum of a row or a column.
	 * 
	 * @param nbr
	 *            is which row/column that it should get the sum of.
	 * @param isRow
	 *            is to check if it is a row or a column.
	 * @return the sum as an integer.
	 */
	private int getSum(int nbr, boolean isRow) {
		int sum = 0;
		for (int i = 0; i < size; i++) {
			if (isRow == true) {
				sum += nbrArray[i][nbr];
			} else {
				sum += nbrArray[nbr][i];
			}
		}
		return sum;
	}

}
