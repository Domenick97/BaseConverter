package converter;

/**
 * The Converter class converts numbers of a any base to a specified base. If
 * the number is base ten then it converts to to the specified base, else the
 * number is converted to base ten then converted to the specified base.
 *
 * @author Domenick DiBiase
 */
public class Converter {
    /**
     * Instance of the converter
     */
    private static Converter singleton = new Converter();

    /**
     * Gets the instance of the
     *
     * @return the instance of the Converter
     */
    public static Converter getInstance() {
        return singleton;
    }

    /**
     * Converts a number of any base to the intended base
     *
     * @param number The number being converted
     * @param cBase  The current base of the number
     * @param iBase  The indented base of the number
     * @return String equivalent to the number passed through but of the intended
     * base
     */
    public String convert(String number, int cBase, int iBase) {
        if (number == null || number.equals(""))
            return "";
        if (cBase <= 1 || cBase > 35 || iBase <= 1 || iBase > 35)
            return "Bases must be between 2 and 35";

        if (cBase == 10) {
            try {
                return convertDecToBase(Integer.parseInt(number), iBase);
            } catch (NumberFormatException e) { // If the number provided is not of base 10
                return "The number provided is not of base 10";
            } catch (IllegalArgumentException e) { // Error when converting
                return e.getMessage();
            }
        } else {
            try {
                return convertDecToBase(convertToDec(number, cBase), iBase);
            } catch (IllegalArgumentException e) { // Error when converting
                return e.getMessage();
            }
        }
    }

    /**
     * Converts a number of any base to base 10
     *
     * @param inputNumber The number being passed through
     * @param cBase       The base of the number being passed through
     * @return Integer of base 10
     */
    private int convertToDec(String inputNumber, int cBase) throws IllegalArgumentException {
        inputNumber = inputNumber.trim().toLowerCase();
        int size = inputNumber.length();

        int decNum = 0;
        int indexNum;

        for (int i = size - 1; i >= 0; i--) {

            if (Character.isLetter(inputNumber.charAt(i))) {

                // The character at the position in the string is a char
                indexNum = Character.getNumericValue(inputNumber.charAt(i));

            } else if (Character.isDigit(inputNumber.charAt(i))) {

                // The character at the position in the string is a number
                indexNum = Integer.parseInt("" + inputNumber.charAt(i));

            } else {

                // If the character at the position is not a char or integer
                throw new IllegalArgumentException("Number can only contain letters and numbers");
            }

            // The number that was the remainder cannot be greater than the base
            if (indexNum >= cBase)
                throw new IllegalArgumentException("The number provided is not of base " + cBase);

            // System.out.println(num1 * Math.pow(cBase, i));
            decNum += indexNum * Math.pow(cBase, size - i - 1);

        }
        return decNum;
    }

    /**
     * Converts a number from base 10 to the intended base
     *
     * @param num   The number being converted
     * @param iBase The intended base of the number
     * @return String equivalent to the number passed through but of the intended
     * base
     */
    private String convertDecToBase(int num, int iBase) throws IllegalArgumentException {

        int remainder;
        int number = num;
        StringBuilder newNum = new StringBuilder();

        // Loops until the number can not be divided by the intended base anymore
        while (number >= iBase) {
            remainder = number % iBase;
            number = number / iBase;

            if (remainder > 9) {
                remainder -= 9;

                // Case: Base is above 35
                if (remainder > 26)
                    throw new IllegalArgumentException("The base cannot exceed 35");

                newNum = newNum.insert(0, (char) (remainder + 64));
            } else {
                newNum = newNum.insert(0, remainder);
            }
        }

        // Number is the final remainder
        if (number > 9) {
            number -= 9;

            // Case: Base is above 35
            if (number > 26)
                throw new IllegalArgumentException("The base cannot exceed 35");

            newNum = newNum.insert(0, (char) (number + 64));
        } else {
            newNum = newNum.insert(0, number);
        }

        return newNum.toString();
    }
}
