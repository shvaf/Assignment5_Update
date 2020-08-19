import java.util.Arrays;


public class HolidayBonus {

	// private static double[] tempBonus;
	private static double[] bonus;
	// private static int MAX_ROW = 10;
	// private static int MAX_COL = 10;
/**
 * no-args constructor
 */
	public HolidayBonus() {

	}
/**
 * calculates holiday bonuses to be given to each store
 * @param data - 2D sales array
 * @param high - highest bonus
 * @param low - lowest bonus
 * @param other - value of bonus given to everyone else
 * @return double array that represents the bonuses given to each store
 */
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
		/*
		 * Stores are only eligible for bonuses if the sale is above zero so in this
		 * code, all of the zero or negative sales are going to be ignored and a new
		 * array will be made with only the values that are above zero.
		 */
		bonus = new double[data.length];

		int lengthRow = 0;
		// determine length of the longest row
		for (int d = 0; d < data.length; d++) {
			if (data[d].length > lengthRow) {
				lengthRow = data[d].length;
			}
		}
		for (int j = 0; j < lengthRow; j++) { // for loops for columns
			int indexHigh = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, j);
			int indexLow = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, j);
			//System.out.println("Col: "+ j + "\nhightestIndex: " + indexHigh + "\nlowestIndex: "+indexLow);
			try {
				for (int i = 0; i < data.length; i++) {
					if (j >= data[i].length) {// if j/columnIndex is greater than the items in the row, continue
						continue;
					} else {
						// System.out.println(data[i][j]);
						if (i == indexHigh && data[i][j] > 0) { // if the index is the highest AND greater than zero
							bonus[i] += high;
						} else if (i == indexLow && data[i][j] > 0) { // if the index is the lowest and greater than
																		// zero
							bonus[i] += low;
						} else if (data[i][j] > 0) { // if the index is neither and greater than zero
							bonus[i] += other;
						}

					}

				}
			} catch (NullPointerException e) {
				continue;
			}

		}
		return bonus;
	}
/**
 * calculate total bonuses
 * @param data - 2D array of sales
 * @param high - high bonus value
 * @param low - low bonus value
 * @param other - bonus value given to other
 * @return returns total value of bonuses as a double
 */
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
		double[] holidayBonus = null;
		double totalBonus = 0;
		holidayBonus = calculateHolidayBonus(data, high, low, other);
		for (int i = 0; i < holidayBonus.length; i++) {
			totalBonus += holidayBonus[i];
		}
		return totalBonus;
	}
}
