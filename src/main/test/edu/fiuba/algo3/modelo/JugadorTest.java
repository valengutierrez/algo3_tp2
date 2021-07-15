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
	public void test02UnJugadorDesocupaUnPais(){
		Jugador unJugador = new Jugador();
		Pais unPais = new Pais();

		unJugador.ocupar(unPais);

		assertTrue(unJugador.getPaisesOcupados().contains(unPais));

		unJugador.desocupar(unPais);
		assertFalse(unJugador.getPaisesOcupados().contains(unPais));
	}

	@Test
	public void test03UnJugadorAgregaEjercitosAUnPais(){
		Jugador unJugador = new Jugador();
		Pais argentina = new Pais(unJugador);
		unJugador.colocarEjercitos(argentina,5);
		assertEquals(unJugador, argentina.getDuenio());
	}
}
