package parchis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @brief Representa una partida de Parchís.
 * 
 * La Clase Parchis gestiona los turnos, y las acciones según la tirada del dado, que hacer si es 5 o 6 o sale 3 veces un 6 etc...
 * Añade Jugadores a la partida y controla cuando se acaba.
 * 
 */
public class Parchis {
	
	private List<Jugador> jugadores;
	private Tablero tablero;
	private Iterator<Jugador> itj;
	
	private Jugador jugadorActual;
	private int tirada = 0;
	private int numeroDeSeis = 0;
	
	/**
	 * @brief Constructor
	 * 
	 * Crea un Tablero a partir de TableroFabricacreateTablero() y un ArrayList<Jugador>() que contendrá los jugadores.
	 */
	public Parchis() {
		TableroFabrica tableroFabrica = new TableroFabrica();
		tablero = tableroFabrica.createTablero();
		jugadores = new ArrayList<Jugador>();
		
	}
	/**
	 * @brief Añade Jugadores a la partida.
	 * 
	 * Según el numero de jugadores añade un jugador con un color de fichas diferente.
	 */
	public void addJugador() {
		Jugador jugador = null ;
		switch (jugadores.size()) {
		case 0:
			jugador = new Jugador(this.tablero.getFichasAmarillas());
			break;
		case 1:
			jugador = new Jugador(this.tablero.getFichasAzules());
			break;
		case 2:
			jugador = new Jugador(this.tablero.getFichasRojas());
			break;
		case 3:
			jugador = new Jugador(this.tablero.getFichasVerdes());
			break;
		default:
			break;
		}
		jugadores.add(jugador);
	}
	/**
	 * @brief Calcula el siguiente Jugador del turno.
	 * @return El jugador siguiente del turno.
	 */
	private Jugador siguienteJugador() {
		if (!itj.hasNext()) {
			itj = jugadores.iterator();
		}
		return itj.next();
	}
	/**
	 * @brief Gestiona el juego.
	 * 
	 * Controla cuando termina el juego, el siguiente Jugador, y que hacer si la tirada es un 5 un 6 u otra.
	 */
	public void jugar() {
		
		itj = jugadores.iterator();
		jugadorActual = siguienteJugador();
		
		
		while (!fin()) {
			System.out.println("Truno del Jugador: " + jugadorActual.getColor());
			tirada = new Dado().tirarDado();
			switch (tirada) {
			case 5:
				esCinco();
				break;
			case 6:
				esSeis();
				break;
			default:
				tablero.eligeFichaYMueve(jugadorActual, tirada);
				jugadorActual = siguienteJugador();
				numeroDeSeis = 0;
				break;
			}

		}
	}

	
	/**
	 * @brief Proceso de la partida si la tirada es un cinco.
	 * 
	 * Este método tiene toda la lógica correspondiente a si la tirada es un cinco.
	 * 
	 *  
	 */
	private void esCinco(){
		if ((jugadorActual.getNumeroDeFichasEnSalida()) == 0) {
			tablero.eligeFichaYMueve(jugadorActual, tirada);
		} else if (jugadorActual.getNumeroDeFichasEnSalida() == 4) {
			tablero.colocarDosFichasEnPuntoPartida(jugadorActual);
		} else {
			if (!jugadorActual.tieneDosFichasEnPP()) {
				tablero.colocarUnaFichaEnPuntoPartida(jugadorActual);
			} else {
				tablero.eligeFichaYMueve(jugadorActual, tirada);
			}

		}
		jugadorActual = siguienteJugador();
		numeroDeSeis = 0;
	}
	
	private void esSeis(){
		numeroDeSeis++;
		if (numeroDeSeis < 3) {
			if (!jugadorActual.tieneFichaEnCasillaSalida()) {
				tirada++;
			}
			tablero.eligeFichaYMueve(jugadorActual, tirada);
		} else {
			tablero.eligeFichaYMueveACasa(jugadorActual, tirada);
			jugadorActual = siguienteJugador();
			numeroDeSeis = 0;
		}
	}
	
	private boolean fin() {
		boolean fin = false;
		if ((tablero.getMetaAmarilla().getFichas().size() == 4)
				|| (tablero.getMetaAzul().getFichas().size() == 4)
				|| (tablero.getMetaRoja().getFichas().size() == 4)
				|| (tablero.getMetaVerde().getFichas().size() == 4)) {
			fin = true;
			System.out.println("Amarillo: "
					+ jugadores.get(0).getFichas());
			System.out.println("Azul: "
					+ jugadores.get(1).getFichas());
			System.out.println("Rojo: "
					+ jugadores.get(2).getFichas());
			System.out.println("Verde: "
					+ jugadores.get(3).getFichas());
		}
	
		return fin;
	}
}
