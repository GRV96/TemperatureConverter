package converters;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConverterTests {
	
	TemperatureConverter tc;

	@Test
	public void cfTest() {
		
		// Instantiates a Celsius to Farenheit converter.
		tc = new CFConverter();
		
		assertTrue(tc.convert(-40) == -40);
		assertTrue(tc.convert(0) == 32);
		assertTrue(tc.convert(100) == 212);
		assertTrue(tc.convert(17) == 62.6);
	}
	
	@Test
	public void ckTests() {
		
		// Instantiates a Celsius to kelvin converter.
		tc = new CKConverter();
		
		assertTrue(tc.convert(0) == 273.15);
		assertTrue(tc.convert(100) == 373.15);
	}
	
	@Test
	public void fcTests() {
		
		// Instantiates a Farenheit to Celsisus converter.
		tc = new FCConverter();
		
		assertTrue(tc.convert(-40) == -40);
		assertTrue(tc.convert(212) == 100);
	}
	
	@Test
	public void fkTests() {
		
		// Instantiates a Farenheit to kelvin converter.
		tc = new FKConverter();
		
		assertTrue(tc.convert(32) == 273.15);
		assertTrue(tc.convert(212) == 373.15);
		// tc.convert(-40) gives 233.149999999999998.
	}
	
	@Test
	public void kcTests() {
		
		//Instantiates a kelvin to Celsisus converter.
		tc = new KCConverter();
		
		assertTrue(tc.convert(0) == -273.15);
		assertTrue(tc.convert(273.15) == 0);
		// tc.convert(100) gives -173.1499999999998.
	}
	
	@Test
	public void kfTests() {
		
		// Instatiates a kelvin to Farenheit converter.
		tc = new KFConverter();
		
		/*
		assertTrue(tc.convert(0) == -459.66999999999996);
		assertTrue(tc.convert(233.15) == -40);
		//*/
		// Results: -459.66999999999996 and -39.99999999999996
	}
}
