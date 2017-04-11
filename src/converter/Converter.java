package converter;

public class Converter {

	/**
	 * Converts a number of any base to the intended base
	 * 
	 * @param num
	 *            The number being converted
	 * @param cBase
	 *            The current base of the number
	 * @param iBase
	 *            The indented base of the number
	 * @return Integer equivalent to the number passed through but of the
	 *         intended base
	 */
	public static int convert(int num, int cBase, int iBase) {
		if (cBase <= 0 || iBase <= 0)
			throw new IllegalArgumentException();
		int newNum;
		if (cBase == 10)
			newNum = convertDecToBase(num, iBase);
		else
			newNum = convertDecToBase(convertToDec(num, cBase), iBase);

		return newNum;

	}

	/**
	 * Converts a number of any base to base 10
	 * 
	 * @param num
	 *            The number being passed through
	 * @param base
	 *            The base of the number being passed through
	 * @return Integer of base 10
	 */
	private static int convertToDec(int num, int cBase) {
		String oldNumS = "";
		int temp = 0;

		int count = 0;
		while (temp <= num) {
			temp = (int) Math.pow(cBase, count);
			count++;
		}

		for (int i = 0; i < oldNumS.length(); i++) {

		}
		return num;
	}

	/**
	 * Converts a number from base 10 to the intended base
	 * 
	 * @param num
	 *            The number being converted
	 * @param base
	 *            The intended base of the number
	 * @return Integer equivalent to the number passed through but of the
	 *         intended base
	 */
	private static int convertDecToBase(int num, int ibase) {
		return num;
	}
}
