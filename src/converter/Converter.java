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
	 * @return String equivalent to the number passed through but of the
	 *         intended base
	 */
	public static String convert(int num, int cBase, int iBase) {
		if (cBase <= 0 || iBase <= 0)
			throw new IllegalArgumentException();
		String newNum;
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
	public static int convertToDec(int num, int cBase) {
		String oldNumS = "" + num;

		int num1 = 0;
		for (int i = 0; i < oldNumS.length(); i++) {
			num1 = Character.getNumericValue(oldNumS.charAt(oldNumS.length() - 1 - i));
			if (num1 > cBase)
				throw new IllegalArgumentException();
		}

		return num1;
	}

	/**
	 * Converts a number from base 10 to the intended base
	 * 
	 * @param num
	 *            The number being converted
	 * @param base
	 *            The intended base of the number
	 * @return String equivalent to the number passed through but of the
	 *         intended base
	 */
	public static String convertDecToBase(int num, int iBase) {
		if(iBase > 35 || iBase < 2)
			throw new IllegalArgumentException("Cannot compute the base of a number with the base of " + iBase);
		
		int remainder;
		int number = num;
		String newNum = "";

		while (number >= iBase) {
			remainder = number % iBase;
			number = number / iBase;
			
			if(remainder > 9){
				remainder -= 9;
				if(remainder > 26)
					throw new IllegalArgumentException("The base cannot exceed 35");
				
				newNum += (char)(remainder + 64);
			} else{
				newNum += remainder;
			}
		}
		if(number > 9){
			number -= 9;
			if(number > 26)
				throw new IllegalArgumentException("The base cannot exceed 35");
			
			newNum += (char)(number  + 64);
		} else{
			newNum += number;
		}
		
		return mirror(newNum);
	}
	
	public static String mirror(String flip){
		String flipped = "";
		for(int i = flip.length() - 1; i >= 0; i--){
			flipped += flip.charAt(i);
		}
		return flipped;
	}
}
