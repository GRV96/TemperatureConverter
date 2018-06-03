package converters;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConverterTests {
	
	TemperatureConverter tc;

	@Test
	public void CFTest() {
		
		// Instantiates a Celsius to Farenheit converter.
		tc = new CFConverter();
		
		assertTrue(tc.convert(-40) == -40);
		assertTrue(tc.convert(0) == 32);
		assertTrue(tc.convert(100) == 212);
		assertTrue(tc.convert(17) == 62.6);
	}
	
	@Test
	public void CKTests() {
		
		// Instantiates a Celsius to kelvin converter.
		tc = new CKConverter();
		
		System.out.println(""+tc.convert(0));
		
		assertTrue(tc.convert(0) == 273.15);
		assertTrue(tc.convert(100) == 373.15);
	}
}
