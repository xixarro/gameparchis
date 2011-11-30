package parchis;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ColorTest {
	private Color amarillo; 
	
	@Before
	public void setUp() {
		amarillo = new Color("amarillo");
	}

	@Test
	public void testColor() {
		//TODO nose como hacer esto..
		
		Color rojo = new Color("rojo");
		assertFalse(this.amarillo.equals(rojo));
		
		Color amarillo = new Color("amarillo");
		assertEquals(amarillo, this.amarillo);
		
	
	}

	@Test
	public void testEqualsObject() {
		assertTrue(amarillo.equals(new Color("amarillo")));
		assertFalse(amarillo.equals(new Color("verde")));
	}
}
