package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class JugadorTest {
	@Test
	public void test01UnJugadorOcupaUnPais(){
		Jugador unJugador = new Jugador();
		Pais unPais = new Pais();

		unJugador.ocupar(unPais);

		assertTrue(unJugador.getPaisesOcupados().contains(unPais));
	}

	@Test
	public void test01UnJugadorDesocupaUnPais(){
		Jugador unJugador = new Jugador();
		Pais unPais = new Pais();

		unJugador.ocupar(unPais);

		assertTrue(unJugador.getPaisesOcupados().contains(unPais));

		unJugador.desocupar(unPais);
		assertFalse(unJugador.getPaisesOcupados().contains(unPais));
	}
}
