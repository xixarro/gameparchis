package parchis;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DadoTest {
	private Dado dado;

	@Before
	public void setUp() {
		dado = new Dado();
	}

	@Test
	public void testTirarDado() {
		int tirada = dado.tirarDado();
		assertTrue((tirada <= 6) && (tirada >= 0));

	}

}
