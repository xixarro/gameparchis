package parchis;

import java.util.Date;
import java.util.Random;
/**
 * @brief Esta clase representa un Dado, genera un numero aleatorio de uno al seis. 
 * 
 *
 */
public class Dado {
	private static final int TIRADA_MAXIMA=6;
	/**
	 * @brief Simula tirar un dado.
	 * 
	 * Devuelve un número aleatorio del 1 al 6 pasando una nueva semilla
	 * new Date().getTime().
	 * @return Un número del 1 al 6.
	 */
	public int tirarDado() {
		Random dado = new Random();
		dado.setSeed(new Date().getTime());
		return dado.nextInt(TIRADA_MAXIMA) + 1;
	}
}
