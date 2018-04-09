package converter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for the Converter class
 *
 * @author Domenick DiBiase
 */
public class ConverterTest {
    /**
     * Instance of the converter for testing
     */
    private Converter testConverter;

    /**
     * Creates instance of the converter class
     */
    @Before
    public void setUp() {
        testConverter = Converter.getInstance();
    }

    /**
     * Converts from base 2 to 16 and 16 to 2
     */
    @Test
    public void testConvertInnerBounds() {

        // Convert from lowest base to highest base
        assertEquals("D", testConverter.convert("01101", 2, 16));

        // Convert from highest base to lowest base
        assertEquals("1011111", testConverter.convert("5F", 16, 2));
    }

    /**
     * Converts from lower base to higher base
     */
    @Test
    public void testCovertLowerToHigher() {

        assertEquals("224", testConverter.convert("1310", 4, 7));
        assertEquals("22", testConverter.convert("1001", 3, 13));
        assertEquals("0", testConverter.convert("0", 6, 8));
    }

    /**
     * Converts from higher to lower base
     */
    @Test
    public void testConvertHigherToLower() {

        assertEquals("275203", testConverter.convert("34AE0", 15, 9));
        assertEquals("13012111", testConverter.convert("1A934", 11, 4));
        assertEquals("0", testConverter.convert("0", 7, 2));
    }

    /**
     * Converts between same base
     */
    @Test
    public void testConvertSameBase() {

        assertEquals("12305", testConverter.convert("12305", 6, 6));
        assertEquals("A21", testConverter.convert("A21", 11, 11));
        assertEquals("0", testConverter.convert("0", 9, 9));
    }

    /**
     * Convert from another base to base 10
     */
    @Test
    public void testConvertToDec() {

        // Convert from lowest base, 2
        assertEquals("13", testConverter.convert("01101", 2, 10));

        // Convert from highest base, 16
        assertEquals("349", testConverter.convert("15D", 16, 10));

        // Convert from an odd base, 9
        assertEquals("5456", testConverter.convert("7432", 9, 10));

        // Convert from a base different base where number doesn't change
        assertEquals("2", testConverter.convert("2", 3, 10));

        // Convert from a number equal to the intended base
        assertEquals("10", testConverter.convert("A", 13, 10));
    }

    /**
     * Convert from decimal to another base
     */
    @Test
    public void testConvertDecToBase() {
        // Convert to lowest base, 2
        assertEquals("10001", testConverter.convert("17", 10, 2));

        // Convert to highest base, 16
        assertEquals("15D", testConverter.convert("349", 10, 16));

        // Convert to base odd number base, 5
        assertEquals("2240421", testConverter.convert("40111", 10, 5));

        // Convert to base same base
        assertEquals("3301", testConverter.convert("3301", 10, 10));

        // Convert to base different base where number doesn't change
        assertEquals("7", testConverter.convert("7", 10, 11));

        // Convert number equal to what its intended base is
        assertEquals("10", testConverter.convert("8", 10, 8));
    }

    /**
     * Invalid number input
     */
    @Test
    public void testConvertInvalidNumber() {
        //Try to convert an empty string of base 3
        assertEquals("", testConverter.convert("", 3, 9));

        //Try to convert an empty string of base 10
        assertEquals("", testConverter.convert("", 10, 12));

        //Try to convert a null string of base 4
        assertEquals("", testConverter.convert(null, 4, 15));

        //Try to convert a null string of base 10
        assertEquals("", testConverter.convert(null, 10, 15));

        // Try to convert from number with a different base than the listed base
        assertEquals("The number provided is not of base 2", testConverter.convert("14", 2, 10));

        // Try to convert from number equal to the base listed
        assertEquals("The number provided is not of base 3", testConverter.convert("3", 3, 14));

        // Try to convert from number that is not of base 10
        assertEquals("The number provided is not of base 10", testConverter.convert("A4", 10, 8));

        // Try to convert from number of letters with a different base than whats listed
        assertEquals("The number provided is not of base 16", testConverter.convert("GF", 16, 4));

        // Try to convert from string other than letters and numbers
        assertEquals("Number can only contain letters and numbers", testConverter.convert("#-+", 5, 8));
    }

    /**
     * Convert base 10 to another base, errors
     */
    @Test
    public void testConvertBaseOutOfBounds() {
        //Try to convert to base 0
        assertEquals("Bases must be between 2 and 35", testConverter.convert("349", 10, 0));

        //Try to convert to base 36
        assertEquals("Bases must be between 2 and 35", testConverter.convert("349", 10, 36));

        //Try to convert from base -1
        assertEquals("Bases must be between 2 and 35", testConverter.convert("349", -1, 9));

        //Try to convert from base 40
        assertEquals("Bases must be between 2 and 35", testConverter.convert("349", 40, 2));
    }
}
