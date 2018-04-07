package converter;

/**
 * The Converter class converts numbers of a any base to a specified base. If
 * the number is base ten then it converts to to the specified base, else the
 * number is converted to base ten then converted to the specified base.
 * 
 * @author Domenick DiBiase
 *
 */
public class Converter {
	/** Instance of the converter */
	private static Converter singlton = new Converter();

	/**
	 * Gets the instance of the
	 * 
	 * @return the instance of the Converter
	 */
	public static Converter getInstance() {
		return singlton;
	}

	/**
	 * Converts a number of any base to the intended base
	 * 
	 * @param num
	 *            The number being converted
	 * @param cBase
	 *            The current base of the number
	 * @param iBase
	 *            The indented base of the number
	 * @return String equivalent to the number passed through but of the intended
	 *         base
	 */
	public String convert(String number, int cBase, int iBase) {
		if (number == null || number.equals(""))
			return "";
		
		if (cBase == 10) {
			try {
				return convertDecToBase(Integer.parseInt(number), iBase);
			} catch (NumberFormatException e) {
				return number + " is not of base 10";
			} catch (IllegalArgumentException e) {
				return e.getMessage();
			} 
		} else {
			try {
				return convertDecToBase(convertToDec(number, cBase), iBase);
			} catch (IllegalArgumentException e) {
				return e.getMessage();
			}
		}
	}

	/**
	 * Converts a number of any base to base 10
	 * 
	 * @param inputNumber
	 *            The number being passed through
	 * @param base
	 *            The base of the number being passed through
	 * @return Integer of base 10
	 */
	public int convertToDec(String inputNumber, int cBase) throws IllegalArgumentException {
		inputNumber = inputNumber.trim().toLowerCase();
		int size = inputNumber.length();

		int decNum = 0;
		int indexNum = 0;

		for (int i = inputNumber.length() - 1; i >= 0; i--) {

			if (Character.isLetter(inputNumber.charAt(i))) {
				// The character at the position in the string is a char
				indexNum = Character.getNumericValue(inputNumber.charAt(i));
			} else if (Character.isDigit(inputNumber.charAt(i))) {
				// The character at the position in the string is a number
				indexNum = Integer.parseInt("" + inputNumber.charAt(i));
			} else {
				// If the character at the position is not a char or integer
				throw new IllegalArgumentException("Number can only contain letters and numbers.");
			}

			// The number that was the remainder cannot be greater than the base
			if (indexNum > cBase)
				throw new IllegalArgumentException("There was an issue converting");

			// System.out.println(num1 * Math.pow(cBase, i));
			decNum += indexNum * Math.pow(cBase, size - i + 1);

		}
		return decNum;
	}

	/**
	 * Converts a number from base 10 to the intended base
	 * 
	 * @param num
	 *            The number being converted
	 * @param base
	 *            The intended base of the number
	 * @return String equivalent to the number passed through but of the intended
	 *         base
	 */
	public String convertDecToBase(int num, int iBase) throws IllegalArgumentException {
		if (iBase > 35 || iBase < 2)
			throw new IllegalArgumentException("Cannot compute the base of a number with the base of " + iBase);

		int remainder;
		int number = num;
		String newNum = "";

		while (number >= iBase) {
			remainder = number % iBase;
			number = number / iBase;

			if (remainder > 9) {
				remainder -= 9;
				if (remainder > 26)
					throw new IllegalArgumentException("The base cannot exceed 35");

				newNum = (char) (remainder + 64) + newNum;
			} else {
				newNum = remainder + newNum;
			}
		}
		if (number > 9) {
			number -= 9;
			if (number > 26)
				throw new IllegalArgumentException("The base cannot exceed 35");

			newNum = (char) (number + 64) + newNum;
		} else {
			newNum = number + newNum;
		}

		return newNum;
	}

	/**
	 * Flips the order of the characters in the string. The front becomes the back
	 * and the back becomes the front.
	 * 
	 * @param flip
	 *            The string to be mirrored
	 * @return String The mirrored version of flip
	 */
	public String mirror(String flip) {
		/** The new string that will be the mirrored version */
		String flipped = "";
		for (int i = flip.length() - 1; i >= 0; i--) {
			flipped += flip.charAt(i);
		}
		return flipped;
	}
}
