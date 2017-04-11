package converter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConverterTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testConvert() {
		assertEquals(1,Converter.convert(15, 10, 2));
	}

}
