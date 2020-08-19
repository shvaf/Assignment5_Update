import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {
	public TwoDimRaggedArrayUtility() {
	}

	private static int MAX_ROW = 10;
	private static int MAX_COL = 10;
	private static Scanner inputFile;

	// private static int lines = 0;
	// private static int numCol = 0;
	/**
	 * reads file into 2D array
	 * 
	 * @param file - file passed into array
	 * @return - a double 2D array of sales data from file
	 * @throws FileNotFoundException
	 */

	public static double[][] readFile(File file) throws FileNotFoundException {
		double[][] a = null;
		FileReader readFile = null;
		int i, j;
		int lines = 0;
		// System.out.println("Parsing gives you " + Double.parseDouble(null));
		try {
			// readFile = new BufferedReader(new FileReader(file));
			readFile = new FileReader(file);
			inputFile = new Scanner(readFile);

			String[][] stringArray = null;
			stringArray = new String[MAX_ROW][MAX_COL];

			// determine number of rows
			for (int b = 0; b < stringArray[b].length; b++) {
				if (inputFile.hasNextLine() == true) {
					stringArray[b][0] = inputFile.nextLine();
					String[] splitString = stringArray[b][0].split(" ");
					stringArray[b] = splitString;
//					for (int c = 0; c < splitString.length; c++) {
//						stringArray[b][c] = splitString[c];
//					}
					lines++;
				} else
					break;
			}

			// take string array and parse the strings and convert into double array

			a = new double[lines][];
			for (i = 0; i < lines; i++) {
				if (stringArray[i] != null) {

					a[i] = new double[stringArray[i].length];
					for (j = 0; j < stringArray[i].length; j++) {
						a[i][j] = Double.parseDouble(stringArray[i][j]);

					}
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return a;
	}

	/**
	 * writes array data to file
	 * 
	 * @param data       -2D sales data array
	 * @param outputFile - location for data array
	 * @throws FileNotFoundException
	 */
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
		int numCol = 0;
		char[] a;
		String str;

		try {

			Writer writeFile = new PrintWriter(outputFile);
			// determine num of columns
			for (int i = 0; i < data.length; i++) {
				// System.out.println("data.length "+data.length);
				if (numCol < data[i].length) {
					numCol = data[i].length;
					// System.out.println("data[i].length: "+data[i].length);
				}
			}
	
			for (int i = 0; i < data.length; i++) {
				for (int j = 0; j < numCol; j++) {
					if (j >= data[i].length) {
						continue;
					} 
					else 
					{

						str = Double.toString(data[i][j]);
						a = str.toCharArray();
						writeFile.write(a + " ");

					}
					//System.out.println(Arrays.deepToString(other));
				}
				writeFile.write("\n");
				// System.out.println(outputFile);
			}
			writeFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * determines the total value of sales in data array
	 * 
	 * @param data - 2D sales array
	 * @return - the total amount of sales
	 */

	public static double getTotal(double[][] data) {
		// int lines = 0, numCol = 0;
		double total = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				total += data[i][j];
			}
		}
		return total;
	}

	/**
	 * returns the average of elements
	 * 
	 * @param data - 2D sales array
	 * @return
	 */

	public static double getAverage(double[][] data) {
		// int lines = 0, numCol = 0;
		int numElements = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				numElements++;
			}
		}
		return getTotal(data) / numElements;
	}

	/**
	 * Calculated the total sales for a given store
	 * 
	 * @param data - array of sales passed in
	 * @param row  - each row represents a store
	 * @return the total value of sales for the row
	 */
	public static double getRowTotal(double[][] data, int row) {
		// int lines = 0, numCol = 0;
		double rowTotal = 0;
		for (int i = 0; i < data[row].length; i++) {
			rowTotal += data[row][i];
		}
		return rowTotal;
	}

	/**
	 * calculates the total value of sales of a specific item
	 * 
	 * @param data - the array of sales data passed in
	 * @param col  - represents the item sold
	 * @return the total value of sales of a specific item as a double
	 */
	public static double getColumnTotal(double[][] data, int col) {
		int lines = data.length;
		double columnTotal = 0;
		// System.out.println("lines" + lines);
		// System.out.println(Arrays.deepToString(data));
		for (int j = 0; j < lines; j++) {
			try {
				columnTotal += data[j][col];
			} catch (ArrayIndexOutOfBoundsException e) {
				columnTotal += 0;
				continue;
			}
		}
		return columnTotal;
	}

	/**
	 * determine the highest values in the row
	 * 
	 * @param data - 2D array of store sales
	 * @param row  - the store evaluated in this method
	 * @return the highest value of sales as a double
	 */
	public static double getHighestInRow(double[][] data, int row) {
		// int lines = 0, numCol = 0;
		double highestInRow = data[row][0];
		for (int i = 0; i < data[row].length; i++) {
			if (highestInRow < data[row][i]) {
				highestInRow = data[row][i];
			}
		}
		return highestInRow;
	}

	/**
	 * determine the index of the highest value in row
	 * 
	 * @param data - 2D array of sales
	 * @param row  - store being evaluated in method
	 * @return index of the highest Value in row
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {
		int index = 0;
		for (int i = 0; i < data[row].length; i++) {
			if (getHighestInRow(data, row) == data[row][i]) {
				index = i;
			}
		}
		return index;
	}

	/**
	 * determines lowest value in row
	 * 
	 * @param data - 2D array of sales
	 * @param row  - store being evaluated
	 * @return lowest value in row
	 */
	public static double getLowestInRow(double[][] data, int row) {
		double lowestInRow = data[row][0];
		for (int i = 0; i < data[row].length; i++) {
			if (lowestInRow > data[row][i]) {
				lowestInRow = data[row][i];
			}
		}
		return lowestInRow;
	}

	/**
	 * determines the index of the lowest value in the row
	 * 
	 * @param data - 2D array of sales
	 * @param row  - store being evaluated
	 * @return index of lowest value
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {
		int index = 0;
		for (int i = 0; i < data[row].length; i++) {
			if (getLowestInRow(data, row) > data[row][i]) {
				index = i;
			}
		}
		return index;
	}

	/**
	 * determine the value of the largest in the colum
	 * 
	 * @param data - 2D array of sales
	 * @param col  - toy/item sold being evaluated
	 * @return the largest element in the column
	 */
	public static double getHighestInColumn(double[][] data, int col) {
		int lines = 0;
		double highestInColumn = Double.NEGATIVE_INFINITY;
		lines = data.length;
		for (int i = 0; i < lines; i++) {

			try {
				if (col >= data[i].length) {
					continue;
				} else if (highestInColumn < data[i][col]) {
					highestInColumn = data[i][col];
				}
			} catch (NullPointerException e) {
				continue;
			}
		}

		return highestInColumn;
	}

	/**
	 * determine index of highest value in column
	 * 
	 * @param data - 2D array of sales
	 * @param col  - column to find the largest element
	 * @return index of the largest element
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {
		int lines = 0, numCol = 0, j, i;
		double highVal = getHighestInColumn(data, col);
		int index = 0;
		lines = data.length;
		for (i = 0; i < data.length; i++) {
			if (numCol < data[i].length)
				numCol = data[i].length;
		}
		for (j = 0; j < numCol; j++) {
			for (i = 0; i < lines; i++) {
				try {
					if (j >= data[i].length) {
						continue;
					} else if (data[i][j] == highVal) {
						index = i;
					}
				} catch (NullPointerException e) {
					continue;
				}
			}
		}
		return index;
	}

	/**
	 * determine lowest value in index
	 * 
	 * @param data - 2D sales array
	 * @param col  - column being evaluated
	 * @return lowest element in the column
	 */
	public static double getLowestInColumn(double[][] data, int col) {
		int lines = 0;
		double lowestInColumn = Double.POSITIVE_INFINITY;
		lines = data.length;

		// System.out.println("lines" + lines);
		for (int i = 0; i < lines; i++) {
			try {
				if (col >= data[i].length) {
					continue;
				} else if (lowestInColumn > data[i][col]) {
					lowestInColumn = data[i][col];
				}
			} catch (NullPointerException e) {
				continue;
			}
		}

		return lowestInColumn;
	}

	/**
	 * determine index of lowest value in the column
	 * 
	 * @param data - 2D sales array
	 * @param col  - column being evaluated
	 * @return index of the lowest element in the column
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {
		int lines = 0, numCol = 0, j, i;
		double highVal = getLowestInColumn(data, col);
		int index = 0;
		lines = data.length;
		for (i = 0; i < data.length; i++) {
			if (numCol < data[i].length)
				numCol = data[i].length;
		}
		for (j = 0; j < numCol; j++) {
			for (i = 0; i < lines; i++) {
				try {
					if (j >= data[i].length) {
						continue;
					} else if (data[i][j] == highVal) {
						index = i;
					}
				} catch (NullPointerException e) {
					continue;
				}
			}
		}
		return index;
	}

	/**
	 * determines highest value in the array
	 * 
	 * @param data - 2D sales array
	 * @return highest value in array as double
	 */
	public static double getHighestInArray(double[][] data) {
		double highest = data[0][0];
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[i].length; j++) {
				if (highest < data[i][j]) {
					highest = data[i][j];
				}
			}
		return highest;
	}

	/**
	 * determines lowest value in array
	 * 
	 * @param data - 2D sales array
	 * @return lowest value in array as double
	 */

	public static double getLowestInArray(double[][] data) {
		double lowest = data[0][0];
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[i].length; j++) {
				if (lowest > data[i][j]) {
					lowest = data[i][j];
				}
			}
		return lowest;
	}
}
