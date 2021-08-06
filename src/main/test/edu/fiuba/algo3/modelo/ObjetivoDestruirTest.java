package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ObjetivoDestruirTest {
	
	@Test
	public void test01SeCreaUnObjetivoDestruir() {
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		ObjetivoDestruir unObjetivo = new ObjetivoDestruir(unJugador, otroJugador);
		unJugador.setNombre("Ejercito azul");
		otroJugador.setNombre("Ejercito rojo");
		String mensaje = "Destruir a jugador: Ejercito azul\n";
		mensaje += "De no ser posible destruir a : Ejercito rojo";
	
		assertTrue(mensaje.equals(unObjetivo.mostrarse()));
	}
}
