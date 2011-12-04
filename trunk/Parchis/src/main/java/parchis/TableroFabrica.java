package parchis;

import java.util.ArrayList;
import java.util.List;

import parchis.Casilla.TipoCasilla;

public class TableroFabrica {
	private static final int SIETE = 7;

	private static final int NN = 99;

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

	private Color amarillo = new Color("amarillo");

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
		metaAmarilla = new Casilla(TipoCasilla.META, NN);
		metaAzul = new Casilla(TipoCasilla.META, NN);
		metaRoja = new Casilla(TipoCasilla.META, NN);
		metaVerde = new Casilla(TipoCasilla.META, NN);
	}

	private void createFichas() {

		fichasAm = new ArrayList<Ficha>(CUATRO);

		fichasAm.add(new Ficha(amarillo));
		fichasAm.add(new Ficha(amarillo));
		fichasAm.add(new Ficha(amarillo));
		fichasAm.add(new Ficha(amarillo));

		for (Ficha ficha : fichasAm) {
			ficha.setPosicion(salidaAmarilla);
		}
		salidaAmarilla.setFichas(fichasAm);

		Color azul = new Color("azul");
		fichasAz = new ArrayList<Ficha>(CUATRO);
		fichasAz.add(new Ficha(azul));
		fichasAz.add(new Ficha(azul));
		fichasAz.add(new Ficha(azul));
		fichasAz.add(new Ficha(azul));
		for (Ficha ficha : fichasAz) {
			ficha.setPosicion(salidaAzul);
		}
		salidaAzul.setFichas(fichasAz);

		Color rojo = new Color("rojo");
		fichasR = new ArrayList<Ficha>(CUATRO);
		fichasR.add(new Ficha(rojo));
		fichasR.add(new Ficha(rojo));
		fichasR.add(new Ficha(rojo));
		fichasR.add(new Ficha(rojo));
		for (Ficha ficha : fichasR) {
			ficha.setPosicion(salidaRoja);
		}
		salidaRoja.setFichas(fichasR);

		Color verde = new Color("verde");

		fichasV = new ArrayList<Ficha>(CUATRO);
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

		salidaAmarilla = new Casilla(TipoCasilla.INICIO, 0);
		salidaAzul = new Casilla(TipoCasilla.INICIO, 0);
		salidaRoja = new Casilla(TipoCasilla.INICIO, 0);
		salidaVerde = new Casilla(TipoCasilla.INICIO, 0);

		salidaAmarilla.setCasillaSiguiente(carril[CINCO - 1]);
		salidaAzul.setCasillaSiguiente(carril[VEINTIDOS - 1]);
		salidaRoja.setCasillaSiguiente(carril[TRENTAINUEVE - 1]);
		salidaVerde.setCasillaSiguiente(carril[CINCUENTAISEIS - 1]);
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
		carril = new Casilla[SESENTAIOCHO];
		pasilloAmarillo = new Casilla[SIETE];
		pasilloAzul = new Casilla[SIETE];
		pasilloVerde = new Casilla[SIETE];
		pasilloRojo = new Casilla[SIETE];

	}

	private static final int DOCE = 12;
	private static final int DIECISIETE = 17;
	private static final int VEINTIDOS = 22;
	private static final int VEINTINUEVE = 29;
	private static final int TRENTAICUATRO = 34;
	private static final int TRENTAINUEVE = 39;
	private static final int CUATRO = 4;
	private static final int CUARENTAISEIS = 46;
	private static final int CINCO = 5;
	private static final int CINCUENTAIUNO = 51;
	private static final int SESENTAITRES = 63;
	private static final int SESENTAIOCHO = 68;

	private static final int CINCUENTAISEIS = 56;

	private void createCarril() {
		carril = new Casilla[SESENTAIOCHO];
		for (int i = 1; i <= carril.length; i++) {
			if (i == DOCE || i == VEINTINUEVE || i == CUARENTAISEIS
					|| i == SESENTAITRES) {
				carril[i - 1] = new Casilla(Casilla.TipoCasilla.SEGURO, i);
			} else if (i == SESENTAIOCHO || i == DIECISIETE
					|| i == TRENTAICUATRO || i == CINCUENTAIUNO) {
				carril[i - 1] = new Casilla(Casilla.TipoCasilla.ENTRADA_META, i);
			} else if (i == CINCO || i == VEINTIDOS || i == TRENTAINUEVE
					|| i == CINCUENTAISEIS) {
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
