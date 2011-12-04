package parchis;

public class UI {

	public static void imprimeJugadorActual(Jugador jugadorActual) {
		mostrar("Truno del Jugador: " + jugadorActual.getColor());
	}

	public static void mostrar(String string, Object o) {
		mostrar(string + o.toString());		
		
	}
	public static void mostrar(Object o) {
		mostrar(o.toString());		
	}
	
	public static void mostrar(String s) {
		System.out.println(s);		
	}
}
