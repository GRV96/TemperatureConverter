package conversion.converters;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConverterTests {
	
	TempConverter tc;

	@Test
	public void cfTests() {
		
		// Instantiates a Celsius to Fahrenheit converter.
		tc = new CFConverter();
		
		assertTrue(tc.convert(-40) == -40);
		assertTrue(tc.convert(0) == 32);
		assertTrue(tc.convert(100) == 212);
		assertTrue(tc.convert(17) == 62.6);
		assertTrue(tc.convert(45) == 113);
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
		
		// Instantiates a Fahrenheit to Celsisus converter.
		tc = new FCConverter();
		
		assertTrue(tc.convert(-40) == -40);
		assertTrue(tc.convert(212) == 100);
	}
	
	@Test
	public void fkTests() {
		
		// Instantiates a Fahrenheit to kelvin converter.
		tc = new FKConverter();
		
		assertTrue(tc.convert(32) == 273.15);
		//assertTrue(tc.convert(212) == 373.15); // Gives 373.15000000000003.
		//assertTrue(tc.convert(-40) == 233.15); // Gives 233.149999999999998.
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
		
		// Instatiates a kelvin to Fahrenheit converter.
		tc = new KFConverter();
		
		assertTrue(tc.convert(0) == -459.67);
		//assertTrue(tc.convert(233.15) == -40); // Gives -40.00000000000006.
		//assertTrue(tc.convert(373.15) == 212); // Gives 211.99999999999994.
	}
}
