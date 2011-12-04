package parchis;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * @brief Esta clase representa a un Jugador.
 * 
 *  La Clase Jugador es un ArrayList<Ficha> que contendr� las fichas de las que dispone el Jugador 
 *
 */

public class Jugador {
	
	private ArrayList<Ficha> fichas;/**< ArrayList<Fichas> que contiene las fichas del jugador */

	/**@brief Constructor
	 * 
	 * @param fichas ArrayList de las Fichas con las que se crea el Jugador
	 */
	public Jugador(ArrayList<Ficha> fichas) {
		super();
		this.fichas = new ArrayList<Ficha>();
		this.fichas.addAll(fichas);
	}

	@Override
	public String toString() {
		return "Jugador [fichas=" + fichas + ", getColor()=" + getColor() + "]";
	}
	
	/**
	 * @brief Observador
	 * @return Las Fichas del Jugador
	 */
	public ArrayList<Ficha> getFichas() {
		return fichas;
	}
	/**@brief Calcula el color con el que juega el jugador
	 * 
	 * Calcula el color de la ficha con la que juega el Jugador a partir de una
	 * ficha de las que dispone.
	 * @return el color de la ficha
	 * @see Ficha.getColorFicha()
	 */
	public Color getColor() {
		return this.fichas.get(0).getColorFicha();
	}

	/**
	 * @brief Devuelve una Ficha de la Casilla de Salida.
	 * 
	 * Este m�todo busca si alguna Ficha del Jugador esta en la casilla de salida,
	 * si encuentra una te la devuelve, si no encuentra ninguna devuelve null
	 * @return una Ficha de la casilla de salida. Null si no hay
	 * @see Ficha.estaEnCasillaSalida()
	 */
	public Ficha getFichaEnSalida() {
		Ficha result = null;
		boolean isFound = false;
		Iterator<Ficha> itf = fichas.iterator();
		while (itf.hasNext() && !isFound) {
			Ficha actual = itf.next();
			if (actual.estaEnCasillaSalida()) {
				result = actual;
				isFound = true;
			}
		}
		return result;
	}

	
	/**
	 * @brief Calcula si todas las Fichas est�n en la Casilla de salida.
	 * 
	 * Recorre todas las Fichas del Jugador, si alguna no esta en la Casilla de
	 * Salida devuelve null.
	 * @return true si todas las fichas del Jugador est�n en la Casilla de salida.
	 */
	public boolean TodasEnSalida() {
		boolean allInExit = true;
		Iterator<Ficha> itf = fichas.iterator();
		while (itf.hasNext() & allInExit) {
			Ficha actual = itf.next();
			if (!actual.estaEnCasillaSalida())
				allInExit = false;
		}
		return allInExit;
	}
	
	/**
	 * @brief Calcula si tiene dos fichas en la casilla de punto de partida.
	 * 
	 * Este m�todo pregunta el color de la ficha que tiene el Jugador y
	 * Seg�n el color va a la posici�n de la casilla de punto de partida correspondiente.
	 * @return true si tiene dos de sus fichas en su casilla de salida.
	 */
	public boolean tieneDosFichasEnPP() {
		boolean tieneDosFichasEnPP = false;
		int numeroDeFichas = 0;
		int idCasillaInicial = 0;
		
		Color color = this.getColor();
		if (color.equals(Tablero.AMARILLO)) {
			idCasillaInicial = 5;
		} else if (color.equals(Tablero.AZUL)) {
			idCasillaInicial = 22;
		} else if (color.equals(Tablero.ROJO)) {
			idCasillaInicial = 39;
		} else if (color.equals(Tablero.VERDE)) {
			idCasillaInicial = 56;
		}
		for (Ficha ficha : fichas) {
			if (ficha.getNumeroPosicion() == idCasillaInicial) {
				numeroDeFichas++;
			}
			if (numeroDeFichas == 2) {
				tieneDosFichasEnPP = true;
			}
		}
		return tieneDosFichasEnPP;	
	}
	
	/**@brief Calcula el numero de fichas que est�n en la Casilla de salida.
	 * 
	 * Recorre las fichas del jugador preguntando si la posici�n de la casilla donde se encuentra la ficha es 0.
	 * @return El numero de fichas que est�n en la Casilla de Salida.
	 */
	public int getNumeroDeFichasEnSalida() {
		int i = 0;
		for (Ficha ficha : fichas) {
			if (ficha.getNumeroPosicion() == 0) {
				i++;
			}
		}
		return i;
	}
	
	/**@brief Calcula si el Jugador tiene fichas en casa.
	 * 
	 * Recorre las Fichas del Jugador preguntado si tiene alguna Ficha en la Casilla de Salida,
	 * si encuentra una la devuelve true.
	 * 
	 * @return true si al menos una Ficha esta en Casilla de Salida.
	 */
	
	public boolean tieneFichaEnCasillaSalida() {
		boolean oneInExit = false;
		Iterator<Ficha> itf = fichas.iterator();
		while (itf.hasNext() & !oneInExit) {
			Ficha actual = itf.next();
			if (!actual.estaEnCasillaSalida())
				oneInExit = true;
		}
		return oneInExit;
	}

	/**
	 * @brief Elige una Ficha no salvada.
	 * 
	 * Recorre las Fichas del Jugador comprobando si est�n
	 * salvadas si encuentra una, la devuelve.
	 * 
	 * @return La una Ficha que no est� salvada, si no hay devuelve null.
	 */
	public Ficha elegirFichaNoSalvada() {
		Ficha fichaNoSalvada = null;
		ArrayList<Ficha> fichas = this.getFichas();
		for (Ficha ficha : fichas) {
			if (!ficha.estaSalvada()) {
				fichaNoSalvada = ficha;
			}
		}
		return fichaNoSalvada;
	}

}
