package converter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * The test class for the Converter class
 * @author Domenick DiBiase
 *
 */
public class ConverterTest {

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test the convert method
	 */
	@Test
	public void testConvert() {
		Converter test = Converter.getInstance();
		assertEquals("D", test.convert("01101", 2, 16)); 
		assertEquals("349", test.convert("15D", 16, 10));
	}

	/**
	 * Test the convert to decimal method
	 */
	@Test
	public void testConvertToDec() {
		Converter test = Converter.getInstance();
		assertEquals(13, test.convertToDec("01101", 2)); 
		assertEquals(349, test.convertToDec("15D", 16)); 
		assertEquals(13, test.convertToDec("01101", 2)); 
		assertEquals(13, test.convertToDec("01101", 2)); 
	}

	/**
	 * Test the convert decimal to intended base method
	 */
	@Test
	public void testConvertDecToBase() {
		Converter test = Converter.getInstance();
		assertEquals("10001", test.convertDecToBase(17, 2));
		assertEquals("15D", test.convertDecToBase(349, 16));
		
		//Try to convert base 10 to base 0
		try{
			test.convertDecToBase(349, 0);
			fail();
		} catch(IllegalArgumentException e){
			assertEquals("Cannot compute the base of a number with the base of 0", e.getMessage());
		}
		
		//Try to convert base 10 to base 36
		try{
			test.convertDecToBase(349, 36);
			fail();
		} catch(IllegalArgumentException e){
			assertEquals("Cannot compute the base of a number with the base of 36", e.getMessage());
		}
	}

}
