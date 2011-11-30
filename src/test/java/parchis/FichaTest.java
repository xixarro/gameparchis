package parchis;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import parchis.Casilla.TipoCasilla;

public class FichaTest {

	private Ficha ficha;
	private Color colorMock;
	private Casilla casillaMock;

	@Before
	public void setUp() {

		this.casillaMock = mock(Casilla.class);
		this.colorMock = mock(Color.class);

		ficha = new Ficha(colorMock);
		ficha.setPosicion(casillaMock);// eso lo pondria asi???

		MockitoAnnotations.initMocks(this);

	}

	// @Test
	// public void testFicha() {
	// // TODO nose bien como hacer este
	// when(colorMock.getColor()).thenReturn("rojo");
	// Ficha fichaP = new Ficha(colorMock);
	//
	// assertEquals("rojo", fichaP.getColorFicha().getColor());
	// }

	@Test
	public void testEstaEnCasillaSalida() {

		when(casillaMock.getTipoCasilla()).thenReturn(TipoCasilla.ENTRADA_META);
		assertFalse(ficha.estaEnCasillaSalida());

		when(casillaMock.getTipoCasilla()).thenReturn(TipoCasilla.META);
		assertFalse(ficha.estaEnCasillaSalida());

		when(casillaMock.getTipoCasilla()).thenReturn(TipoCasilla.NORMAL);
		assertFalse(ficha.estaEnCasillaSalida());

		when(casillaMock.getTipoCasilla()).thenReturn(TipoCasilla.PASILLO);
		assertFalse(ficha.estaEnCasillaSalida());

		when(casillaMock.getTipoCasilla())
				.thenReturn(TipoCasilla.PUNTO_PARTIDA);
		assertTrue(ficha.estaEnCasillaSalida());

		when(casillaMock.getTipoCasilla()).thenReturn(TipoCasilla.SEGURO);
		assertFalse(ficha.estaEnCasillaSalida());

		// Casilla casillaNormal = new Casilla(TipoCasilla.NORMAL, 0);
		// casillaNormal.ponFicha(ficha);
		// assertFalse(ficha.estaEnCasillaSalida());
		//
		// Casilla casillaEntradaMeta = new Casilla(TipoCasilla.ENTRADA_META,
		// 0);
		// casillaEntradaMeta.ponFicha(ficha);
		// assertFalse(ficha.estaEnCasillaSalida());
		//
		// Casilla casillaMeta = new Casilla(TipoCasilla.META, 0);
		// casillaMeta.ponFicha(ficha);
		// assertFalse(ficha.estaEnCasillaSalida());
		//
		// Casilla casillaPasillo = new Casilla(TipoCasilla.PASILLO, 0);
		// casillaPasillo.ponFicha(ficha);
		// assertFalse(ficha.estaEnCasillaSalida());
		//
		// Casilla casillaSeguro = new Casilla(TipoCasilla.SEGURO, 0);
		// casillaSeguro.ponFicha(ficha);
		// assertFalse(ficha.estaEnCasillaSalida());
		//
		// Casilla casillaPuntoPartida = new Casilla(TipoCasilla.PUNTO_PARTIDA,
		// 0);
		// casillaPuntoPartida.ponFicha(ficha);
		// assertTrue(ficha.estaEnCasillaSalida());

	}

	@Test
	public void testEstaSalvada() {

		when(casillaMock.getTipoCasilla()).thenReturn(TipoCasilla.ENTRADA_META);
		assertTrue(ficha.estaSalvada());

		when(casillaMock.getTipoCasilla()).thenReturn(TipoCasilla.META);
		assertTrue(ficha.estaSalvada());

		when(casillaMock.getTipoCasilla()).thenReturn(TipoCasilla.NORMAL);
		assertFalse(ficha.estaSalvada());

		when(casillaMock.getTipoCasilla()).thenReturn(TipoCasilla.PASILLO);
		assertTrue(ficha.estaSalvada());

		when(casillaMock.getTipoCasilla())
				.thenReturn(TipoCasilla.PUNTO_PARTIDA);
		assertTrue(ficha.estaSalvada());

		when(casillaMock.getTipoCasilla()).thenReturn(TipoCasilla.SEGURO);
		assertTrue(ficha.estaSalvada());

	}

	@Test
	public void testEstaEnCasillaMeta() {

		when(casillaMock.getTipoCasilla()).thenReturn(TipoCasilla.ENTRADA_META);
		assertTrue(ficha.estaEnCasillaEntradaMeta());

		when(casillaMock.getTipoCasilla()).thenReturn(TipoCasilla.META);
		assertFalse(ficha.estaEnCasillaEntradaMeta());

		when(casillaMock.getTipoCasilla()).thenReturn(TipoCasilla.NORMAL);
		assertFalse(ficha.estaEnCasillaEntradaMeta());

		when(casillaMock.getTipoCasilla()).thenReturn(TipoCasilla.PASILLO);
		assertFalse(ficha.estaEnCasillaEntradaMeta());

		when(casillaMock.getTipoCasilla())
				.thenReturn(TipoCasilla.PUNTO_PARTIDA);
		assertFalse(ficha.estaEnCasillaEntradaMeta());

		when(casillaMock.getTipoCasilla()).thenReturn(TipoCasilla.SEGURO);
		assertFalse(ficha.estaEnCasillaEntradaMeta());

	}

	@Test
	public void testEstaEnCasillaEntradaMeta() {

		when(casillaMock.getTipoCasilla()).thenReturn(TipoCasilla.ENTRADA_META);
		assertTrue(ficha.estaEnCasillaEntradaMeta());

		when(casillaMock.getTipoCasilla()).thenReturn(TipoCasilla.META);
		assertFalse(ficha.estaEnCasillaEntradaMeta());

		when(casillaMock.getTipoCasilla()).thenReturn(TipoCasilla.NORMAL);
		assertFalse(ficha.estaEnCasillaEntradaMeta());

		when(casillaMock.getTipoCasilla()).thenReturn(TipoCasilla.PASILLO);
		assertFalse(ficha.estaEnCasillaEntradaMeta());

		when(casillaMock.getTipoCasilla())
				.thenReturn(TipoCasilla.PUNTO_PARTIDA);
		assertFalse(ficha.estaEnCasillaEntradaMeta());

		when(casillaMock.getTipoCasilla()).thenReturn(TipoCasilla.SEGURO);
		assertFalse(ficha.estaEnCasillaEntradaMeta());

	}
	@Test
	public void testSiguienteCasilla() {
		Casilla casillaSiguienteMock = mock(Casilla.class);
		when(casillaMock.getCasillaSiguiente())
				.thenReturn(casillaSiguienteMock);

		assertEquals(casillaSiguienteMock, ficha.siguienteCasilla());
	}
	@Test
	public void testGetNumeroPosicion() {
		when(casillaMock.getPosicion()).thenReturn(5);

		assertEquals(5, ficha.getNumeroPosicion());

	}
}
