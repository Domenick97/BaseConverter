package converter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * The test class for the Converter class
 * @author Domenick
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
		fail("Not yet implemented");
	}

	/**
	 * Test the convert to decimal method
	 */
	@Test
	public void testConvertToDec() {
		assertEquals(3, Converter.convertToDec(367, 18));
	}

	/**
	 * Test the convert dec to base method
	 */
	@Test
	public void testConvertDecToBase() {
		assertEquals("10001", Converter.convertDecToBase(17, 2));
		assertEquals("15D", Converter.convertDecToBase(349, 16));
		
		//Try to convert base 10 to base 0
		try{
			Converter.convertDecToBase(349, 0);
			fail();
		} catch(IllegalArgumentException e){
			assertEquals("Cannot compute the base of a number with the base of 0", e.getMessage());
		}
		
		//Try to convert base 10 to base 36
		try{
			Converter.convertDecToBase(349, 36);
			fail();
		} catch(IllegalArgumentException e){
			assertEquals("Cannot compute the base of a number with the base of 36", e.getMessage());
		}
	}

}
