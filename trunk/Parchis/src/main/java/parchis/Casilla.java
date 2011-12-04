package parchis;

import java.util.ArrayList;
import java.util.List;

/**
 * @brief Se encarga de gestionar las casillas del tablero de Parchis
 */

public class Casilla {

	private List<Ficha> fichas;	/**< Lista de fichas que contiene la casilla */
	private TipoCasilla tipoCasilla;/**< Tipo de la casilla. */
	private Casilla casillaSiguiente;/**< Siguiente Casilla a la que apunta la casilla actual. */
	private int posicion;/**< Numero de la casilla a la que corresponde. */

	/**
	 * @brief Observador
	 * @return Una Lista con las Fichas de contiene la Casilla
	 */
	public List<Ficha> getFichas() {
		return fichas;
	}

	/**
	 * @brief Modificador
	 */
	public void setFichas(List<Ficha> fichas) {
		this.fichas = fichas;
	}

	/**
	 * @brief M�todo que calcula el numero de la posici�n siguiente.
	 * @return El valor num�rico de la siguiente posici�n.
	 * @note Este m�todo solo se usa para el toString.
	 */
	public int siguientePosicion() {
		return casillaSiguiente.getPosicion();
	}

	/**
	 * Observadora de TipoCasilla
	 * 
	 * @return TipoCasilla de la Casilla
	 */
	public TipoCasilla getTipoCasilla() {
		return tipoCasilla;
	}

	@Override
	public String toString() {
		return "Casilla [Fichas=" + fichas + ", tipoCasilla=" + tipoCasilla
				+ ", siguientePosicion()=" + siguientePosicion()
				+ ", getPosicion()=" + getPosicion() + "]";
	}

	/**
	 * @brief Constructor de Casilla
	 * 
	 *        Crea una instancia de Casilla. Deja las fichas de la casilla
	 *        Vac�as en principio.
	 * @param tipoCasilla
	 *            Tipo de la casilla.
	 * @param numeroCasilla
	 *            Numero de la casilla.
	 * 
	 * 
	 */
	public Casilla(TipoCasilla tipoCasilla, int numeroCasilla) {

		this.tipoCasilla = tipoCasilla;
		this.posicion = numeroCasilla;
		this.fichas = new ArrayList<Ficha>();
	}

	/**
	 * @brief Especifica de que tipo es la Casilla.
	 */
	public enum TipoCasilla {
		NORMAL, /** < Tipo de Casilla normal, sin acciones. */

		PUNTO_PARTIDA, /**
		 * <Tipo de Casilla punto de partida, Casilla donde se
		 * posicionan las Fichas cuando salen de la casilla de salida.
		 */
		ENTRADA_META, /**
		 * < Tipo de Casilla Entrada a Meta, tipo de Casilla que
		 * est� justo antes de la entrada a un pasillo.
		 */
		SEGURO, /**
		 * < Tipo de Casilla seguro, una Ficha situada en esta Casilla
		 * estar� salvada y no podr� ser comida.
		 */
		PASILLO, /**
		 * < Tipo de Casilla pasillo, Casillas predecesoras a meta donde
		 * solo entran las fichas de su color, no pueden ser comidas.
		 */
		META,
		/**
		 * < Tipo de Casilla meta, la ficha que este en esta Casilla ha llegado
		 * a su destino y no vuelve al juego
		 */
		INICIO
	}

	/**
	 * @brief Observador
	 * 
	 * @return La Casilla siguiente
	 */
	public Casilla getCasillaSiguiente() {
		return casillaSiguiente;
	}

	/**
	 * @brief Modificador
	 * @param casillaSiguiente
	 *            Casilla que queremos que sea la siguiente de la actual.
	 */
	public void setCasillaSiguiente(Casilla casillaSiguiente) {
		this.casillaSiguiente = casillaSiguiente;
	}

	/**
	 * @brief Observador
	 * @return la posici�n num�rica de la Casilla
	 */
	public int getPosicion() {
		return posicion;
	}

	/**
	 * @brief Calcula si una casilla es puente.
	 * 
	 * @return Devuelve un boolean que informa si es puente o no.
	 * 
	 * @note Una casilla es puente si tiene dos fichas del mismo color en una
	 *       Casilla que no sea NORMAL ni META
	 */
	public boolean esPuente() {
		boolean esPuente = false;
		if (this.tipoCasilla != TipoCasilla.NORMAL
				&& this.tipoCasilla != TipoCasilla.META) {
			if (this.fichas.size() == 2) {
				if (this.fichas.get(0).getColorFicha()
						== this.fichas.get(1).getColorFicha()) {
					esPuente = true;
				}
			}
		}
			
		return esPuente;
	}

	/**
	 * @brief Inserta una ficha en la Casilla
	 * 
	 *        Adem�s de insertar Ficha en la Casilla actualiza la posicion de la
	 *        ficha
	 * 
	 * @param ficha
	 *            Ficha que queremos insertar en la Casilla
	 * @see Ficha.setPosicion
	 */
	public void ponFicha(Ficha ficha) {
		this.fichas.add(ficha);
		ficha.setPosicion(this);
	}

	/**
	 * @brief Saca la ficha de la Casilla
	 * @param ficha
	 *            que queremos sacar de la Casilla
	 */
	public void sacarFicha(Ficha ficha) {
		this.fichas.remove(ficha);
	}

}
