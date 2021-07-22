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
		assertEquals(unJugador, argentina.obtenerDuenio());
	}

	@Test
	public void test04UnJugadorAtacaDeUnPaisAOtro(){
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Pais argentina = new Pais(unJugador);
		Pais brasil = new Pais(otroJugador);
		argentina.setPaisLimitrofe(brasil);

		argentina.incrementarEjercito(1);
		brasil.incrementarEjercito(1);
		int ejercitosIniciales = argentina.obtenerEjercito() + brasil.obtenerEjercito();

		unJugador.atacar(argentina,brasil);
		int ejercitosFinales = argentina.obtenerEjercito() + brasil.obtenerEjercito();
		assertTrue(ejercitosIniciales > ejercitosFinales);
	}

	@Test
	public void test05UnJugadorAtacaDeUnPaisAOtroNoLimitrofeYNoSeEfectuaLaBatalla(){
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Pais argentina = new Pais(unJugador);
		Pais espania = new Pais(otroJugador);

		argentina.incrementarEjercito(1);
		espania.incrementarEjercito(1);
		int ejercitosIniciales = argentina.obtenerEjercito() + espania.obtenerEjercito();

		unJugador.atacar(argentina,espania);
		int ejercitosFinales = argentina.obtenerEjercito() + espania.obtenerEjercito();
		assertTrue(ejercitosIniciales == ejercitosFinales);
	}

	@Test
	public void test06UnJugadorAtacaDeUnPaisAOtroPropioYNoSeEfectuaBatalla(){
		Jugador unJugador = new Jugador();
		Pais argentina = new Pais(unJugador);
		Pais brasil = new Pais(unJugador);
		argentina.setPaisLimitrofe(brasil);

		argentina.incrementarEjercito(1);
		brasil.incrementarEjercito(1);
		int ejercitosIniciales = argentina.obtenerEjercito() + brasil.obtenerEjercito();

		unJugador.atacar(argentina,brasil);
		int ejercitosFinales = argentina.obtenerEjercito() + brasil.obtenerEjercito();
		assertTrue(ejercitosIniciales == ejercitosFinales);
	}
}
