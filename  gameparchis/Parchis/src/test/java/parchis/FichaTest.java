package parchis;

import static org.junit.Assert.*;

import org.junit.Test;

import parchis.Casilla.TipoCasilla;

public class FichaTest {
	private Ficha ficha = new Ficha(new Color("rojo"));
	
	
	
	

	@Test
	public void testFicha() {
		//TODO nose bien como hacer este
		Ficha fichaP = new Ficha(new Color("azul"));
		assertEquals("azul", fichaP.getColorFicha().getColor());
	}

	@Test
	public void testEstaEnCasillaSalida() {
		
		Casilla casillaNormal = new Casilla(TipoCasilla.NORMAL, 0);
		casillaNormal.ponFicha(ficha);
		assertFalse(ficha.estaEnCasillaSalida());
		
		Casilla casillaEntradaMeta = new Casilla(TipoCasilla.ENTRADA_META, 0);
		casillaEntradaMeta.ponFicha(ficha);
		assertFalse(ficha.estaEnCasillaSalida());
		
		Casilla casillaMeta = new Casilla(TipoCasilla.META, 0);
		casillaMeta.ponFicha(ficha);
		assertFalse(ficha.estaEnCasillaSalida());
		
		Casilla casillaPasillo = new Casilla(TipoCasilla.PASILLO, 0);
		casillaPasillo.ponFicha(ficha);
		assertFalse(ficha.estaEnCasillaSalida());
				
		Casilla casillaSeguro = new Casilla(TipoCasilla.SEGURO, 0);
		casillaSeguro.ponFicha(ficha);
		assertFalse(ficha.estaEnCasillaSalida());

		Casilla casillaPuntoPartida = new Casilla(TipoCasilla.PUNTO_PARTIDA, 0);
		casillaPuntoPartida.ponFicha(ficha);
		assertTrue(ficha.estaEnCasillaSalida());
		
	}

	@Test
	public void testEstaSalvada() {
		Casilla casillaNormal = new Casilla(TipoCasilla.NORMAL, 0);
		casillaNormal.ponFicha(ficha);
		assertFalse(ficha.estaSalvada());
		
		Casilla casillaEntradaMeta = new Casilla(TipoCasilla.ENTRADA_META, 0);
		casillaEntradaMeta.ponFicha(ficha);
		assertTrue(ficha.estaSalvada());
		
		Casilla casillaMeta = new Casilla(TipoCasilla.META, 0);
		casillaMeta.ponFicha(ficha);
		assertTrue(ficha.estaSalvada());
		
		Casilla casillaPasillo = new Casilla(TipoCasilla.PASILLO, 0);
		casillaPasillo.ponFicha(ficha);
		assertTrue(ficha.estaSalvada());
				
		Casilla casillaPuntoPartida = new Casilla(TipoCasilla.PUNTO_PARTIDA, 0);
		casillaPuntoPartida.ponFicha(ficha);
		assertTrue(ficha.estaSalvada());
		
		Casilla casillaSeguro = new Casilla(TipoCasilla.SEGURO, 0);
		casillaSeguro.ponFicha(ficha);
		assertTrue(ficha.estaSalvada());
		
		
		
		
	}

	@Test
	public void testEstaEnCasillaMeta() {
		Casilla casillaNoMeta = new Casilla(TipoCasilla.NORMAL, 0);
		casillaNoMeta.ponFicha(ficha);
		assertFalse(ficha.estaEnCasillaMeta());
		
		Casilla casillaMeta = new Casilla(TipoCasilla.META, 0);	
		casillaMeta.ponFicha(ficha);
		assertTrue(ficha.estaEnCasillaMeta());
		
		
		
		
	}

	@Test
	public void testEstaEnCasillaEntradaMeta() {
		
		Casilla casillaNoEntradaMeta = new Casilla(TipoCasilla.NORMAL, 0);
		casillaNoEntradaMeta.ponFicha(ficha);
		assertFalse(ficha.estaEnCasillaMeta());
		
		Casilla casillaEntradaMeta = new Casilla(TipoCasilla.META, 0);	
		casillaEntradaMeta.ponFicha(ficha);
		assertTrue(ficha.estaEnCasillaMeta());
		
	}

}
