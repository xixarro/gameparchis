package parchis;

import java.util.ArrayList;
import java.util.List;

import parchis.Casilla.TipoCasilla;

public class TableroFabrica {
	private Casilla carril[];

	private Casilla pasilloAmarillo[];
	private Casilla pasilloAzul[];
	private Casilla pasilloRojo[];
	private Casilla pasilloVerde[];

	private Casilla salidaAmarilla;
	private Casilla salidaAzul;
	private Casilla salidaRoja;
	private Casilla salidaVerde;

	private Casilla metaAmarilla;
	private Casilla metaAzul;
	private Casilla metaRoja;
	private Casilla metaVerde;

	private List<Ficha> fichasAm;
	private List<Ficha> fichasAz;
	private List<Ficha> fichasR;
	private List<Ficha> fichasV;

	
	/**
	 * TODO estas costantes son privates??
	 * cada vez q pongo un numero tengo que poner estas costantes?
	 */
	static final int POSICION_CASILLA_META = 99;
	static final int LENGTH_PASILLO = 7;

	private static final int LENGTH_CARRIL =68 ;

	public TableroFabrica() {

	}

	public Tablero createTablero() {

		Tablero tablero = new Tablero();
		createEstructuras();
		createCarril();
		createMetas();
		createSalidas();
		createPasillos();
		createFichas();

		tablero.setCarril(carril);
		tablero.setPasilloAmarillo(pasilloAmarillo);
		tablero.setPasilloAzul(pasilloAzul);
		tablero.setPasilloRojo(pasilloRojo);
		tablero.setPasilloVerde(pasilloVerde);

		tablero.setFichasAmarillas(fichasAm);
		tablero.setFichasAzules(fichasAz);
		tablero.setFichasRojas(fichasR);
		tablero.setFichasVerdes(fichasV);

		tablero.setSalidaAmarilla(salidaAmarilla);
		tablero.setSalidaAzul(salidaAzul);
		tablero.setSalidaRoja(salidaRoja);
		tablero.setSalidaVerde(salidaVerde);

		tablero.setMetaAmarilla(metaAmarilla);
		tablero.setMetaAzul(metaAzul);
		tablero.setMetaRoja(metaRoja);
		tablero.setMetaVerde(metaVerde);

		return tablero;

	}

	private void createMetas() {
		metaAmarilla = new Casilla(TipoCasilla.META, POSICION_CASILLA_META);
		metaAzul = new Casilla(TipoCasilla.META, POSICION_CASILLA_META);
		metaRoja = new Casilla(TipoCasilla.META, POSICION_CASILLA_META);
		metaVerde = new Casilla(TipoCasilla.META, POSICION_CASILLA_META);
	}

	private void createFichas() {

		Color amarillo = new Color("amarillo");

		fichasAm = new ArrayList<Ficha>(4);

		fichasAm.add(new Ficha(amarillo));
		fichasAm.add(new Ficha(amarillo));
		fichasAm.add(new Ficha(amarillo));
		fichasAm.add(new Ficha(amarillo));

		for (Ficha ficha : fichasAm) {
			ficha.setPosicion(salidaAmarilla);
		}
		salidaAmarilla.setFichas(fichasAm);

		Color azul = new Color("azul");
		fichasAz = new ArrayList<Ficha>(4);
		fichasAz.add(new Ficha(azul));
		fichasAz.add(new Ficha(azul));
		fichasAz.add(new Ficha(azul));
		fichasAz.add(new Ficha(azul));
		for (Ficha ficha : fichasAz) {
			ficha.setPosicion(salidaAzul);
		}
		salidaAzul.setFichas(fichasAz);

		Color rojo = new Color("rojo");
		fichasR = new ArrayList<Ficha>(4);
		fichasR.add(new Ficha(rojo));
		fichasR.add(new Ficha(rojo));
		fichasR.add(new Ficha(rojo));
		fichasR.add(new Ficha(rojo));
		for (Ficha ficha : fichasR) {
			ficha.setPosicion(salidaRoja);
		}
		salidaRoja.setFichas(fichasR);

		Color verde = new Color("verde");

		fichasV = new ArrayList<Ficha>(4);
		fichasV.add(new Ficha(verde));
		fichasV.add(new Ficha(verde));
		fichasV.add(new Ficha(verde));
		fichasV.add(new Ficha(verde));
		for (Ficha ficha : fichasV) {
			ficha.setPosicion(salidaVerde);
		}
		salidaVerde.setFichas(fichasV);
	}

	private void createSalidas() {

		salidaAmarilla = new Casilla(TipoCasilla.PUNTO_PARTIDA, 0);
		salidaAzul = new Casilla(TipoCasilla.PUNTO_PARTIDA, 0);
		salidaRoja = new Casilla(TipoCasilla.PUNTO_PARTIDA, 0);
		salidaVerde = new Casilla(TipoCasilla.PUNTO_PARTIDA, 0);

		salidaAmarilla.setCasillaSiguiente(carril[5 - 1]);
		salidaAzul.setCasillaSiguiente(carril[22 - 1]);
		salidaRoja.setCasillaSiguiente(carril[39 - 1]);
		salidaVerde.setCasillaSiguiente(carril[56 - 1]);
	}

	private void createPasillos() {

		createPasilloAmarillo();
		createPasilloAzul();
		createPasilloRojo();
		createPasilloVerde();

	}

	private void createPasilloVerde() {

		for (int i = 0; i < pasilloVerde.length; i++) {
			pasilloVerde[i] = new Casilla(TipoCasilla.PASILLO, i + 1);
		}

		for (int i = 1; i < pasilloVerde.length; i++) {
			Casilla casilla = pasilloVerde[i - 1];
			casilla.setCasillaSiguiente(pasilloVerde[i]);
		}
		Casilla casilla = pasilloVerde[pasilloVerde.length - 1];
		casilla.setCasillaSiguiente(metaVerde);
	}

	private void createPasilloRojo() {

		for (int i = 0; i < pasilloRojo.length; i++) {
			pasilloRojo[i] = new Casilla(TipoCasilla.PASILLO, i + 1);
		}
		for (int i = 1; i < pasilloRojo.length; i++) {
			Casilla casilla = pasilloRojo[i - 1];
			casilla.setCasillaSiguiente(pasilloRojo[i]);
		}
		Casilla casilla = pasilloRojo[pasilloRojo.length - 1];
		casilla.setCasillaSiguiente(metaRoja);
	}

	private void createPasilloAzul() {
		for (int i = 0; i < pasilloAzul.length; i++) {
			pasilloAzul[i] = new Casilla(TipoCasilla.PASILLO, i + 1);
		}

		for (int i = 1; i < pasilloAzul.length; i++) {
			Casilla casilla = pasilloAzul[i - 1];
			casilla.setCasillaSiguiente(pasilloAzul[i]);
		}
		Casilla casilla = pasilloAzul[pasilloAzul.length - 1];
		casilla.setCasillaSiguiente(metaAzul);
	}

	private void createPasilloAmarillo() {

		for (int i = 0; i < pasilloAmarillo.length; i++) {
			pasilloAmarillo[i] = new Casilla(TipoCasilla.PASILLO, i + 1);
		}

		for (int i = 1; i < pasilloAmarillo.length; i++) {
			Casilla casilla = pasilloAmarillo[i - 1];
			casilla.setCasillaSiguiente(pasilloAmarillo[i]);
		}
		Casilla casilla = pasilloAmarillo[pasilloAmarillo.length - 1];
		casilla.setCasillaSiguiente(metaAmarilla);

	}

	private void createEstructuras() {
		carril = new Casilla[LENGTH_CARRIL];
		pasilloAmarillo = new Casilla[LENGTH_PASILLO];
		pasilloAzul = new Casilla[LENGTH_PASILLO];
		pasilloVerde = new Casilla[LENGTH_PASILLO];
		pasilloRojo = new Casilla[LENGTH_PASILLO];

	}

	private void createCarril() {

	//	carril = new Casilla[68];

		for (int i = 1; i <= carril.length; i++) {

			if (i == 12 || i == 29 || i == 46 || i == 63) {
				carril[i - 1] = new Casilla(Casilla.TipoCasilla.SEGURO, i);
			} else if (i == 68 || i == 17 || i == 34 || i == 51) {
				carril[i - 1] = new Casilla(Casilla.TipoCasilla.ENTRADA_META, i);
			} else if (i == 5 || i == 22 || i == 39 || i == 56) {
				carril[i - 1] = new Casilla(Casilla.TipoCasilla.PUNTO_PARTIDA,
						i);
			} else {
				carril[i - 1] = new Casilla(Casilla.TipoCasilla.NORMAL, i);
			}
		}

		for (int i = 1; i < carril.length; i++) {
			Casilla casilla = carril[i - 1];
			casilla.setCasillaSiguiente(carril[i]);
		}
		Casilla casilla = carril[carril.length - 1];
		Casilla sig = carril[0];

		casilla.setCasillaSiguiente(sig);
	}

}
